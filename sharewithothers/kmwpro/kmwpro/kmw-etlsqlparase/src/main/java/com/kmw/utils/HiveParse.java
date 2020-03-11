package com.kmw.utils;
import org.apache.hadoop.hive.metastore.api.ThriftHiveMetastore.AsyncProcessor.list_privileges;
import org.apache.hadoop.hive.ql.parse.ASTNode;
import org.apache.hadoop.hive.ql.parse.BaseSemanticAnalyzer;
import org.apache.hadoop.hive.ql.parse.HiveParser;
import org.apache.hadoop.hive.ql.parse.ParseDriver;
import org.apache.hadoop.hive.ql.parse.ParseException;
import org.apache.hadoop.hive.ql.parse.SemanticException;

import groovy.lang.ListWithDefault;

import org.apache.hadoop.hive.ql.parse.HiveParser.nullOrdering_return;
import org.apache.hadoop.hive.ql.parse.HiveParser_IdentifiersParser.intervalExpression_return;

import sun.tools.tree.ThisExpression;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 目的：获取AST中的表，列，以及对其所做的操作，如SELECT,INSERT
 * 重点：获取SELECT操作中的表和列的相关操作。其他操作这判断到表级别。
 * 实现思路：对AST深度优先遍历，遇到操作的token则判断当前的操作，
 *                     遇到TOK_TAB或TOK_TABREF则判断出当前操作的表，遇到子句则压栈当前处理，处理子句。
 *                    子句处理完，栈弹出。 
 *
 */

public class HiveParse {
    
    private  static final String UNKNOWN = "UNKNOWN";
	private static final String String = null;
    private Map<String, String> alias = new HashMap<String, String>();
    private Map<String, String> cols = new TreeMap<String, String>();
    private Map<String, String> colAlais = new TreeMap<String, String>();
    private Set<String> tables = new HashSet<String>();
    private Stack<String> tableNameStack = new Stack<String>();
    private Stack<Oper> operStack = new Stack<Oper>();
    private String nowQueryTable = "";//定义及处理不清晰，修改为query或from节点对应的table集合或许好点。目前正在查询处理的表可能不止一个。
    private Oper oper ;
    private boolean joinClause = false;

    private enum Oper {
        SELECT, INSERT, DROP, TRUNCATE, LOAD, CREATETABLE, ALTER
    }
    public Set<String> parseIteral(ASTNode ast) {
        Set<String> set= new HashSet<String>();//当前查询所对应到的表集合
        prepareToParseCurrentNodeAndChilds(ast);
        set.addAll(parseChildNodes(ast));
        set.addAll(parseCurrentNode(ast ,set));
        endParseCurrentNode(ast);
        return set;
    }
    private void endParseCurrentNode(ASTNode ast){
        if (ast.getToken() != null) {
            switch (ast.getToken().getType()) {//join 从句结束，跳出join
                case HiveParser.TOK_RIGHTOUTERJOIN:
                case HiveParser.TOK_LEFTOUTERJOIN:
                case HiveParser.TOK_JOIN:
                    joinClause = false;
                    break;
                case HiveParser.TOK_QUERY:
                    break;
                case HiveParser.TOK_INSERT:
                case HiveParser.TOK_SELECT:
                    nowQueryTable = tableNameStack.pop();
                    oper = operStack.pop();
                    break;
            }
        }
    }
    private Set<String> parseCurrentNode(ASTNode ast, Set<String> set){
        if (ast.getToken() != null) {
            switch (ast.getToken().getType()) {
            case HiveParser.TOK_TABLE_PARTITION:
//            case HiveParser.TOK_TABNAME:
                if (ast.getChildCount() != 2) {
                    String table = BaseSemanticAnalyzer
                            .getUnescapedName((ASTNode) ast.getChild(0));
                    if (oper == Oper.SELECT) {
                        nowQueryTable = table;
                    }
                    tables.add(table + "\t" + oper);
                }
                break;

            case HiveParser.TOK_TAB:// outputTable
                String tableTab = BaseSemanticAnalyzer
                        .getUnescapedName((ASTNode) ast.getChild(0));
                if (oper == Oper.SELECT) {
                    nowQueryTable = tableTab;
                }
                tables.add(tableTab + "\t" + oper);
                break;
            case HiveParser.TOK_TABREF:// inputTable
                ASTNode tabTree = (ASTNode) ast.getChild(0);
                String tableName = (tabTree.getChildCount() == 1) ? BaseSemanticAnalyzer
                        .getUnescapedName((ASTNode) tabTree.getChild(0))
                        : BaseSemanticAnalyzer
                                .getUnescapedName((ASTNode) tabTree.getChild(0))
                                + "." + tabTree.getChild(1);
                if (oper == Oper.SELECT) {
                    if(joinClause && !"".equals(nowQueryTable) ){
                        nowQueryTable += "&"+tableName;//
                    }else{
                        nowQueryTable = tableName;
                    }
                    set.add(tableName);
                }
                tables.add(tableName + "\t" + oper);
                if (ast.getChild(1) != null) {
                    String alia = ast.getChild(1).getText().toLowerCase();
                    alias.put(alia, tableName);//sql6 p别名在tabref只对应为一个表的别名。
                }
                break;
            case HiveParser.TOK_TABLE_OR_COL:
                if (ast.getParent().getType() != HiveParser.DOT) {
                    String col = ast.getChild(0).getText().toLowerCase();
                    if (alias.get(col) == null
                            && colAlais.get(nowQueryTable + "." + col) == null) {
                        if(nowQueryTable.indexOf("&") > 0){//sql23
                            cols.put(UNKNOWN + "." + col, "");
                        }else{
                            cols.put(nowQueryTable + "." + col, "");
                        }
                    }
                }
                break;
            case HiveParser.TOK_ALLCOLREF:
                cols.put(nowQueryTable + ".*", "");
                break;
            case HiveParser.TOK_SUBQUERY:
                if (ast.getChildCount() == 2) {
                    String tableAlias = unescapeIdentifier(ast.getChild(1)
                            .getText());
                    String aliaReal = "";
                    for(String table : set){
                        aliaReal+=table+"&";
                    }
                    if(aliaReal.length() !=0){
                        aliaReal = aliaReal.substring(0, aliaReal.length()-1);
                    }
//                    alias.put(tableAlias, nowQueryTable);//sql22
                    alias.put(tableAlias, aliaReal);//sql6
//                    alias.put(tableAlias, "");// just store alias
                }
                break;

            case HiveParser.TOK_SELEXPR:
                 if (ast.getChild(0).getType() == HiveParser.TOK_TABLE_OR_COL) {
                    String column = ast.getChild(0).getChild(0).getText()
                            .toLowerCase();
                    if(nowQueryTable.indexOf("&") > 0){
                        cols.put(UNKNOWN + "." + column, "");
                    }else if (colAlais.get(nowQueryTable + "." + column) == null) {
                        cols.put(nowQueryTable + "." + column, "");
                    }
                } else if (ast.getChild(1) != null) {// TOK_SELEXPR (+
                                                        // (TOK_TABLE_OR_COL id)
                                                        // 1) dd
                    String columnAlia = ast.getChild(1).getText().toLowerCase();
                    colAlais.put(nowQueryTable + "." + columnAlia, "");
                }
                break;
            case HiveParser.DOT:
                if (ast.getType() == HiveParser.DOT) {
                    if (ast.getChildCount() == 2) {
                        if (ast.getChild(0).getType() == HiveParser.TOK_TABLE_OR_COL
                                && ast.getChild(0).getChildCount() == 1
                                && ast.getChild(1).getType() == HiveParser.Identifier) {
                            String alia = BaseSemanticAnalyzer
                                    .unescapeIdentifier(ast.getChild(0)
                                            .getChild(0).getText()
                                            .toLowerCase());
                            String column = BaseSemanticAnalyzer
                                    .unescapeIdentifier(ast.getChild(1)
                                            .getText().toLowerCase());
                            String realTable = null;
                            if (!tables.contains(alia + "\t" + oper)
                                    && alias.get(alia) == null) {// [b SELECT, a
                                                                    // SELECT]
                                alias.put(alia, nowQueryTable);
                            }
                            if (tables.contains(alia + "\t" + oper)) {
                                realTable = alia;
                            } else if (alias.get(alia) != null) {
                                realTable = alias.get(alia);
                            }
                            if (realTable == null || realTable.length() == 0 || realTable.indexOf("&") > 0) {
                                realTable = UNKNOWN;
                            }
                            cols.put(realTable + "." + column, "");

                        }
                    }
                }
                break;
            case HiveParser.TOK_ALTERTABLE_ADDPARTS:
            case HiveParser.TOK_ALTERTABLE_RENAME:
            case HiveParser.TOK_ALTERTABLE_ADDCOLS:
                ASTNode alterTableName = (ASTNode) ast.getChild(0);
                tables.add(alterTableName.getText() + "\t" + oper);
                break;
            }
        }
        return set;
    }
    private  Set<String> parseChildNodes(ASTNode ast){
        Set<String> set= new HashSet<String>();
        int numCh = ast.getChildCount();
        if (numCh > 0) {
            for (int num = 0; num < numCh; num++) {
                ASTNode child = (ASTNode) ast.getChild(num);
                set.addAll(parseIteral(child));
            }
        }
        return set;
    }
    private void prepareToParseCurrentNodeAndChilds(ASTNode ast){
        if (ast.getToken() != null) {
            switch (ast.getToken().getType()) {//join 从句开始
                case HiveParser.TOK_RIGHTOUTERJOIN:
                case HiveParser.TOK_LEFTOUTERJOIN:
                case HiveParser.TOK_JOIN:
                    joinClause = true;
                    break;
                case HiveParser.TOK_QUERY:
                    tableNameStack.push(nowQueryTable);
                    operStack.push(oper);
                    nowQueryTable = "";//sql22
                    oper = Oper.SELECT;
                    break;
                case HiveParser.TOK_INSERT:
                    tableNameStack.push(nowQueryTable);
                    operStack.push(oper);
                    oper = Oper.INSERT;
                    break;
                case HiveParser.TOK_SELECT:
                    tableNameStack.push(nowQueryTable);
                    operStack.push(oper);
//                    nowQueryTable = nowQueryTable
                    // nowQueryTable = "";//语法树join 
                    // 注释语法树sql9， 语法树join对应的设置为""的注释逻辑不符
                    oper = Oper.SELECT;
                    break;
                case HiveParser.TOK_DROPTABLE:
                    oper = Oper.DROP;
                    break;
                case HiveParser.TOK_TRUNCATETABLE:
                    oper = Oper.TRUNCATE;
                    break;
                case HiveParser.TOK_LOAD:
                    oper = Oper.LOAD;
                    break;
                case HiveParser.TOK_CREATETABLE:
                    oper = Oper.CREATETABLE;
                    break;
            }
             if (ast.getToken() != null
                        && ast.getToken().getType() >= HiveParser.TOK_ALTERDATABASE_PROPERTIES
                        && ast.getToken().getType() <= HiveParser.TOK_ALTERVIEW_RENAME) {
                    oper = Oper.ALTER;
                }
        }
    }
    public static String unescapeIdentifier(String val) {
        if (val == null) {
            return null;
        }
        if (val.charAt(0) == '`' && val.charAt(val.length() - 1) == '`') {
            val = val.substring(1, val.length() - 1);
        }
        return val;
    }

    private void output(Map<String, String> map) {
        java.util.Iterator<String> it = map.keySet().iterator();
        while (it.hasNext()) {
            String key = it.next();
            System.out.println(key + "\t" + map.get(key));
        }
    }
    public void parse(ASTNode ast) {
        parseIteral(ast);
        System.out.println("***************表***************");
        for (String table : tables) {
            System.out.println(table);
        }
        System.out.println("***************列***************");
        output(cols);
        System.out.println("***************别名***************");
        output(alias);
    }
    
    /*
     * 
     * 对SQL后面的结束符处理
     * 
     * 
     * */
    public static List<String> dealAfterString(String sqlString,String sufixString) {
    	if(sqlString == null||sqlString.equals("")) return null;
    	//结束符字符，默认为;
    	if(null == sufixString ||sufixString.equals("")){
    		
    	}
    	List<String> lstList = new ArrayList<>();
    	String singleString="";
    	String[] sqlArrayStrings=sqlString.split(sufixString);
    	List<String> list = Arrays.asList(sqlArrayStrings);  //此集合无法操作添加元素
    	List<String> list1 = new ArrayList<String>(list); //此集合可操作元素
    	return list1;
    }
    
    /*
     * 
     * 对SQL中的通配符进行处理。
     * 
     * 
     * */
    public static String replaceWildCards(String sqlString,List<String> wildcardList) {
    	String afterString="";
    	
    	if(wildcardList == null || wildcardList.equals("")) {
    		afterString = sqlString;
    	}else {
			for(int i=0;i<wildcardList.size();i++) {
				afterString = sqlString.replace(wildcardList.get(i), " not_define");
				/*
				 * Pattern p = Pattern.compile("\\$\\{(.*?)}"); // 匹配】 Matcher matcher =
				 * p.matcher(wpp);
				 */
				sqlString = afterString;
			}
		}
    	return afterString;
    }
    
    public static void main(String[] args) throws IOException, ParseException,
            SemanticException {
        ParseDriver pd = new ParseDriver();
        String sql25="-----------------------------------------------------------------------------------------------\r\n" + 
        		"INSERT OVERWRITE TABLE FDM_DATA.FDM_CARD_CREDIT_TRAD_DETAIL PARTITION\r\n" + 
        		"  (DATA_DT_ID, CRT_NO_ID)\r\n" + 
        		"  SELECT RSLT.*\r\n" + 
        		"    FROM (SELECT NVL(B.CARD_NBR, '') AS CARD_NO,\r\n" + 
        		"                 --卡号\r\n" + 
        		"                 NVL(A.XACCOUNT, '') AS CREDITCARD_ACT,\r\n" + 
        		"                 --信用卡账户\r\n" + 
        		"                 --(CASE\r\n" + 
        		"                 --   WHEN CONCAT('6524',NVL(TRIM(SUBSTR(P.BANKNO,-1, 4)),'0000')) = '' THEN\r\n" + 
        		"                 --    '999999999'\r\n" + 
        		"                 --   ELSE\r\n" + 
        		"                 --    CONCAT('6524',NVL(TRIM(SUBSTR(P.BANKNO,-1, 4)),'0000'))\r\n" + 
        		"                 -- END) AS ORG_NUM,\r\n" + 
        		"                 B.ORG_NO AS ORG_NUM,\r\n" + 
        		"                 --内部机构号\r\n" + 
        		"                 NVL(B.CURRNCY_CD, '') AS CURR_CD,\r\n" + 
        		"                 --币种\r\n" + 
        		"                 (CASE\r\n" + 
        		"                    WHEN NVL(B.VAL_DATE, '') = '' THEN\r\n" + 
        		"                     B.PUR_DATE\r\n" + 
        		"                    ELSE\r\n" + 
        		"                     B.VAL_DATE\r\n" + 
        		"                  END) AS CUST_ID,\r\n" + 
        		"                 --交易记账日期\r\n" + 
        		"                 NVL(B.CARD_NBR, '') AS REF_NUM,\r\n" + 
        		"                 --核心交易流水号\r\n" + 
        		"                 NVL(B.XTRANNO, '') AS GL_ITEM_CODE,\r\n" + 
        		"                 --子交易流水号\r\n" + 
        		"                 0 AS SERIAL,\r\n" + 
        		"                 --笔次序号\r\n" + 
        		"                 NVL(B.DESC_NAR, '') AS TRANTYPE,\r\n" + 
        		"                 --卡片交易类型\r\n" + 
        		"                 '人民币' AS CASH_FLG,\r\n" + 
        		"                 --钞汇类别\r\n" + 
        		"                 (CASE\r\n" + 
        		"                    WHEN NVL(B.TRANS_TYPE, '') IN ('2090',\r\n" + 
        		"                                                   '7000',\r\n" + 
        		"                                                   '2180',\r\n" + 
        		"                                                   '2160',\r\n" + 
        		"                                                   '8110',\r\n" + 
        		"                                                   '8112',\r\n" + 
        		"                                                   '2010',\r\n" + 
        		"                                                   '2000',\r\n" + 
        		"                                                   '2110',\r\n" + 
        		"                                                   '4000',\r\n" + 
        		"                                                   '4010',\r\n" + 
        		"                                                   '4110',\r\n" + 
        		"                                                   '4160',\r\n" + 
        		"                                                   '4300',\r\n" + 
        		"                                                   '4310',\r\n" + 
        		"                                                   '4400',\r\n" + 
        		"                                                   '4410',\r\n" + 
        		"                                                   '4460',\r\n" + 
        		"                                                   '4180',\r\n" + 
        		"                                                   '2300',\r\n" + 
        		"                                                   '2310',\r\n" + 
        		"                                                   '2410',\r\n" + 
        		"                                                   '2460',\r\n" + 
        		"                                                   '2046',\r\n" + 
        		"                                                   '7040',\r\n" + 
        		"                                                   '2092',\r\n" + 
        		"                                                   '2042',\r\n" + 
        		"                                                   '2040',\r\n" + 
        		"                                                   '2170') THEN\r\n" + 
        		"                     '现'\r\n" + 
        		"                    ELSE\r\n" + 
        		"                     '转'\r\n" + 
        		"                  END) AS TRANS_FLG,\r\n" + 
        		"                 --现转标志\r\n" + 
        		"                 NVL(B.XTRANNO, '') AS TRA_MED_CODE,\r\n" + 
        		"                 --交易凭证号\r\n" + 
        		"                 (CASE\r\n" + 
        		"                    WHEN NVL(B.BILL_AMT_SIGN, '') = '+' THEN\r\n" + 
        		"                     'DR'\r\n" + 
        		"                    ELSE\r\n" + 
        		"                     'CR'\r\n" + 
        		"                  END) AS CD_TYPE,\r\n" + 
        		"                 --借贷标志\r\n" + 
        		"                 NVL(B.BILL_AMT, 0) AS TRANAMT,\r\n" + 
        		"                 --交易金额\r\n" + 
        		"                 (CASE\r\n" + 
        		"                    WHEN NVL(B.TRANS_TYPE, '') IN ('4012',\r\n" + 
        		"                                                   '8030',\r\n" + 
        		"                                                   '8024',\r\n" + 
        		"                                                   '3250',\r\n" + 
        		"                                                   '3252',\r\n" + 
        		"                                                   '4042',\r\n" + 
        		"                                                   '4040',\r\n" + 
        		"                                                   '4046',\r\n" + 
        		"                                                   '4170',\r\n" + 
        		"                                                   '4340') THEN\r\n" + 
        		"                     NVL(B.BILL_AMT, 0)\r\n" + 
        		"                    ELSE\r\n" + 
        		"                     0\r\n" + 
        		"                  END) AS FEE_AMT,\r\n" + 
        		"                 --客户手续费金额\r\n" + 
        		"                 '消费入账' AS REPAY_SEQ, --欠款归还次序\r\n" + 
        		"                 (CASE\r\n" + 
        		"                    WHEN NVL(A.CUTOFF_DAY, '19000102') <= '19000101'\r\n" + 
        		"                         OR NVL(A.CUTOFF_DAY, '19000102') >= '21001231' THEN\r\n" + 
        		"                     '19000102'\r\n" + 
        		"                    ELSE\r\n" + 
        		"                     NVL(A.CUTOFF_DAY, '19000102')\r\n" + 
        		"                  END) AS ST_INT_DT, --交易起息日期\r\n" + 
        		"                 (CASE\r\n" + 
        		"                    WHEN NVL(B.INP_DATE, '19000102') <= '19000101'\r\n" + 
        		"                         OR NVL(B.INP_DATE, '19000102') >= '21001231' THEN\r\n" + 
        		"                     '19000102'\r\n" + 
        		"                    ELSE\r\n" + 
        		"                     NVL(B.INP_DATE, '19000102')\r\n" + 
        		"                  END) AS TRADE_DATE, --交易发生日期\r\n" + 
        		"                 CONCAT(SUBSTR(A.ETL_DT, 1, 6), SUBSTR(CONCAT('00', A.CYCLE_NBR), -2, 2)) AS TRADE_BILL_DATE, --交易帐单日期\r\n" + 
        		"                 '' AS OPPO_ACCT_NUM, --对方账号\r\n" + 
        		"                 (CASE\r\n" + 
        		"                    WHEN NVL(B.SEC_LVL, '') = 'AX'\r\n" + 
        		"                         OR NVL(B.SEC_LVL, '') = 'YO' THEN\r\n" + 
        		"                     '2'\r\n" + 
        		"                    ELSE\r\n" + 
        		"                     '1'\r\n" + 
        		"                  END) AS INSTAL_PLAN_FLG, --分期付款标志\r\n" + 
        		"                 (CASE\r\n" + 
        		"                    WHEN NVL(B.DESC_NAR, '') LIKE '%柜面%' THEN\r\n" + 
        		"                     '柜面'\r\n" + 
        		"                    WHEN NVL(B.DESC_NAR, '') LIKE '%ATM%' THEN\r\n" + 
        		"                     'ATM'\r\n" + 
        		"                    WHEN NVL(B.DESC_NAR, '') LIKE '%网银%' THEN\r\n" + 
        		"                     '网银'\r\n" + 
        		"                    WHEN NVL(B.DESC_NAR, '') LIKE '%手机%' THEN\r\n" + 
        		"                     '手机银行'\r\n" + 
        		"                    ELSE\r\n" + 
        		"                     '其他'\r\n" + 
        		"                  END) AS CHANNEL, --交易渠道\r\n" + 
        		"                 SUBSTR(NVL(B.INP_TIME, ''), 1, 6) AS TRADE_TIME, --交易时间\r\n" + 
        		"                 '' AS TRADE_TELLER_NUM, --交易柜员号\r\n" + 
        		"                 '' AS TRADE_ORG_NUM, --交易机构号\r\n" + 
        		"                 (CASE\r\n" + 
        		"                    WHEN NVL(B.DESC_NAR, '') LIKE '%柜面%' THEN\r\n" + 
        		"                     '柜员工作站'\r\n" + 
        		"                    WHEN NVL(B.DESC_NAR, '') LIKE '%ATM%' THEN\r\n" + 
        		"                     'ATM'\r\n" + 
        		"                    WHEN NVL(B.DESC_NAR, '') LIKE '%网银%' THEN\r\n" + 
        		"                     '多媒体自助终端'\r\n" + 
        		"                    ELSE\r\n" + 
        		"                     'POS'\r\n" + 
        		"                  END) AS WORKPLACE_TYPE, --工作站性质\r\n" + 
        		"                 NVL(B.TERMINAL, '') AS WORKPLACE_CODE, --工作站编号\r\n" + 
        		"                 (CASE\r\n" + 
        		"                    WHEN NVL(B.DESC_NAR, '') = '' THEN\r\n" + 
        		"                     NVL(B.DES_LINE1, '')\r\n" + 
        		"                    ELSE\r\n" + 
        		"                     NVL(B.DESC_NAR, '')\r\n" + 
        		"                  END) AS SUMMARY, --摘要\r\n" + 
        		"                 (CASE\r\n" + 
        		"                    WHEN NVL(B.DESC_NAR, '') = '' THEN\r\n" + 
        		"                     B.DES_LINE1\r\n" + 
        		"                    ELSE\r\n" + 
        		"                     B.DESC_NAR\r\n" + 
        		"                  END) AS REMARK, --备注\r\n" + 
        		"                 '${hiveconf:data_dt}' AS DATA_DT, --采集日期\r\n" + 
        		"                 '${hiveconf:data_dt}' AS DATA_DT_ID,\r\n" + 
        		"                 NVL(B.CRT_NO, '') AS CRT_NO_ID\r\n" + 
        		"            FROM SDM_DATA.SDM_CCFS_TRAN B --客户交易数据\r\n" + 
        		"            LEFT JOIN SDM_DATA.SDM_CCFS_ACCT A --帐户资料\r\n" + 
        		"              --ON B.CARD_NBR = A.CARD_NBR\r\n" + 
        		"              ON B.ACCTNBR=A.XACCOUNT\r\n" + 
        		"             AND A.ETL_DT_ID = '${hiveconf:data_dt}'\r\n" + 
        		"            --LEFT JOIN SDM_DATA.SDM_AFA_AFA_BRNOBANKMAP P --机构行号对应表\r\n" + 
        		"            --  ON CONCAT(SUBSTR(P.NOTE1,1,9),SUBSTR(P.BANKNO,1,4)) = A.BRANCH\r\n" + 
        		"            -- AND P.ETL_DT_ID = '${hiveconf:data_dt}'\r\n" + 
        		"           WHERE B.ETL_DT_ID = '${hiveconf:data_dt}'\r\n" + 
        		"             AND B.ETL_DT = '${hiveconf:data_dt}' ) RSLT\r\n" + 
        		"   WHERE ${hiveconf:query_condition};";
		/*
		 * String parsesql = sql24; HiveParse hp = new HiveParse();
		 * System.out.println(parsesql); ASTNode ast = pd.parse(parsesql);
		 * System.out.println(ast.toStringTree()); hp.parse(ast);
		 */
        
		/*
		 * // 待处理字符串 String wpp =
		 * "jdbc:mysql://${wpp1}:${wpp2}/${wpp3}?&useSSL=false&characterEncoding=utf-8&serverTimezone=Asia/Shanghai&zeroDateTimeBehavior=convertToNull";
		 * //\u0024\u007B\u0028\u002E\u002A\u003F\u0029} // 匹配方式 Pattern p =
		 * Pattern.compile("\\$\\{(.*?)}"); // 匹配】 Matcher matcher = p.matcher(wpp); //
		 * 处理匹配到的值 while (matcher.find()) { System.out.println("woo: " +
		 * matcher.group()); }
		 */
        List<String> lstStrings =dealAfterString(sql25,";");
        List<String> lstWildCards = new ArrayList<String>();
        lstWildCards.add("${hiveconf:data_dt}");
        lstWildCards.add("${hiveconf:part_condition}");
        lstWildCards.add( "${hiveconf:query_condition}");
        for(int ii=0;ii<lstStrings.size();ii++) {

        	System.out.println(lstStrings.get(ii));
        	String oneSqlString = replaceWildCards(lstStrings.get(ii),lstWildCards);
        	//System.out.println("==========================="+ii);
        	//System.out.println(oneSqlString);
        	 HiveParse hp = new HiveParse();
        	 ASTNode ast = pd.parse(oneSqlString.trim());
        	// System.out.println(ast.toStringTree());
        	 hp.parse(ast);
        }
        
    }
}