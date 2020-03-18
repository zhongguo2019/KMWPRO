package com.kmw.utils;

import org.apache.hadoop.hive.metastore.api.ThriftHiveMetastore.AsyncProcessor.list_privileges;
import org.apache.hadoop.hive.ql.parse.ASTNode;
import org.apache.hadoop.hive.ql.parse.BaseSemanticAnalyzer;
import org.apache.hadoop.hive.ql.parse.HiveParser;
import org.apache.hadoop.hive.ql.parse.ParseDriver;
import org.apache.hadoop.hive.ql.parse.ParseException;
import org.apache.hadoop.hive.ql.parse.SemanticException;
import org.apache.hadoop.hive.ql.parse.HiveParser.nullOrdering_return;
import org.slf4j.Logger;

import com.kmw.etlsqlparase.domain.SqlParameter;

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
 * 目的：获取AST中的表，列，以及对其所做的操作，如SELECT,INSERT 重点：获取SELECT操作中的表和列的相关操作。其他操作这判断到表级别。
 * 实现思路：对AST深度优先遍历，遇到操作的token则判断当前的操作，
 * 遇到TOK_TAB或TOK_TABREF则判断出当前操作的表，遇到子句则压栈当前处理，处理子句。 子句处理完，栈弹出。
 *
 */

public class HiveParse {

	private static final String UNKNOWN = "UNKNOWN";
	private static final String String = null;
	private Map<String, String> alias = new HashMap<String, String>();
	private Map<String, String> cols = new TreeMap<String, String>();
	private Map<String, String> colAlais = new TreeMap<String, String>();
	private Set<String> tables = new HashSet<String>();
	private Stack<String> tableNameStack = new Stack<String>();
	private Stack<Oper> operStack = new Stack<Oper>();
	private String nowQueryTable = "";// 定义及处理不清晰，修改为query或from节点对应的table集合或许好点。目前正在查询处理的表可能不止一个。
	private Oper oper;
	private boolean joinClause = false;

	private enum Oper {
		SELECT, INSERT, DROP, TRUNCATE, LOAD, CREATETABLE, ALTER
	}

	public Set<String> parseIteral(ASTNode ast) {
		Set<String> set = new HashSet<String>();// 当前查询所对应到的表集合
		prepareToParseCurrentNodeAndChilds(ast);
		set.addAll(parseChildNodes(ast));
		set.addAll(parseCurrentNode(ast, set));
		endParseCurrentNode(ast);
		return set;
	}

	private void endParseCurrentNode(ASTNode ast) {
		if (ast.getToken() != null) {
			switch (ast.getToken().getType()) {// join 从句结束，跳出join
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

	private Set<String> parseCurrentNode(ASTNode ast, Set<String> set) {
		if (ast.getToken() != null) {
			switch (ast.getToken().getType()) {
			case HiveParser.TOK_TABLE_PARTITION:
//            case HiveParser.TOK_TABNAME:
				if (ast.getChildCount() != 2) {
					String table = BaseSemanticAnalyzer.getUnescapedName((ASTNode) ast.getChild(0));
					if (oper == Oper.SELECT) {
						nowQueryTable = table;
					}
					tables.add(table + "\t" + oper);
				}
				break;

			case HiveParser.TOK_TAB:// outputTable
				String tableTab = BaseSemanticAnalyzer.getUnescapedName((ASTNode) ast.getChild(0));
				if (oper == Oper.SELECT) {
					nowQueryTable = tableTab;
				}
				tables.add(tableTab + "\t" + oper);
				break;
			case HiveParser.TOK_TABREF:// inputTable
				ASTNode tabTree = (ASTNode) ast.getChild(0);
				String tableName = (tabTree.getChildCount() == 1)
						? BaseSemanticAnalyzer.getUnescapedName((ASTNode) tabTree.getChild(0))
						: BaseSemanticAnalyzer.getUnescapedName((ASTNode) tabTree.getChild(0)) + "."
								+ tabTree.getChild(1);
				if (oper == Oper.SELECT) {
					if (joinClause && !"".equals(nowQueryTable)) {
						nowQueryTable += "&" + tableName;//
					} else {
						nowQueryTable = tableName;
					}
					set.add(tableName);
				}
				tables.add(tableName + "\t" + oper);
				if (ast.getChild(1) != null) {
					String alia = ast.getChild(1).getText().toLowerCase();
					alias.put(alia, tableName);// sql6 p别名在tabref只对应为一个表的别名。
				}
				break;
			case HiveParser.TOK_TABLE_OR_COL:
				if (ast.getParent().getType() != HiveParser.DOT) {
					String col = ast.getChild(0).getText().toLowerCase();
					if (alias.get(col) == null && colAlais.get(nowQueryTable + "." + col) == null) {
						if (nowQueryTable.indexOf("&") > 0) {// sql23
							cols.put(UNKNOWN + "." + col, "");
						} else {
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
					String tableAlias = unescapeIdentifier(ast.getChild(1).getText());
					String aliaReal = "";
					for (String table : set) {
						aliaReal += table + "&";
					}
					if (aliaReal.length() != 0) {
						aliaReal = aliaReal.substring(0, aliaReal.length() - 1);
					}
//                    alias.put(tableAlias, nowQueryTable);//sql22
					alias.put(tableAlias, aliaReal);// sql6
//                    alias.put(tableAlias, "");// just store alias
				}
				break;

			case HiveParser.TOK_SELEXPR:
				if (ast.getChild(0).getType() == HiveParser.TOK_TABLE_OR_COL) {
					String column = ast.getChild(0).getChild(0).getText().toLowerCase();
					if (nowQueryTable.indexOf("&") > 0) {
						cols.put(UNKNOWN + "." + column, "");
					} else if (colAlais.get(nowQueryTable + "." + column) == null) {
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
									.unescapeIdentifier(ast.getChild(0).getChild(0).getText().toLowerCase());
							String column = BaseSemanticAnalyzer
									.unescapeIdentifier(ast.getChild(1).getText().toLowerCase());
							String realTable = null;
							if (!tables.contains(alia + "\t" + oper) && alias.get(alia) == null) {// [b SELECT, a
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

	private Set<String> parseChildNodes(ASTNode ast) {
		Set<String> set = new HashSet<String>();
		int numCh = ast.getChildCount();
		if (numCh > 0) {
			for (int num = 0; num < numCh; num++) {
				ASTNode child = (ASTNode) ast.getChild(num);
				set.addAll(parseIteral(child));
			}
		}
		return set;
	}

	private void prepareToParseCurrentNodeAndChilds(ASTNode ast) {
		if (ast.getToken() != null) {
			switch (ast.getToken().getType()) {// join 从句开始
			case HiveParser.TOK_RIGHTOUTERJOIN:
			case HiveParser.TOK_LEFTOUTERJOIN:
			case HiveParser.TOK_JOIN:
				joinClause = true;
				break;
			case HiveParser.TOK_QUERY:
				tableNameStack.push(nowQueryTable);
				operStack.push(oper);
				nowQueryTable = "";// sql22
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
			if (ast.getToken() != null && ast.getToken().getType() >= HiveParser.TOK_ALTERDATABASE_PROPERTIES
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
	 * 判断当前的SQL语法是否合法的查询语句
	 * 
	 * 
	 */
	public static Boolean isCheckSql(String sqlString) {

		List<String> startKeyList = new ArrayList<String>();
		startKeyList = Arrays.asList(SqlParameter.startKeyWord);
		for (int ii = 0; ii < startKeyList.size(); ii++) {
			String strCompareString = startKeyList.get(ii).toUpperCase();
			if (sqlString.startsWith(strCompareString)) {
				return true;
			}
		}
		return false;

	}

	/*
	 * 
	 * 对SQL后面的结束符处理
	 * 
	 * 
	 */
	public static List<String> dealAfterString(String sqlString, String sufixString) {
		if (sqlString == null || sqlString.equals(""))
			return null;
		// 结束符字符，默认为;
		if (null == sufixString || sufixString.equals("")) {

		}
		List<String> lstList = new ArrayList<>();
		String singleString = "";
		String[] sqlArrayStrings = sqlString.split(sufixString);
		List<String> list = Arrays.asList(sqlArrayStrings); // 此集合无法操作添加元素
		List<String> list1 = new ArrayList<String>(list); // 此集合可操作元素
		return list1;
	}

	/*
	 * 
	 * 对SQL中的通配符进行处理。
	 * 
	 * 
	 */
	public static String replaceWildCards(String sqlString, List<String> wildcardList) {
		String afterString = "";
        String stringTmp = sqlString;
		if (wildcardList == null || wildcardList.equals("")) {
			afterString = sqlString;
		} else {
			for (int i = 0; i < wildcardList.size(); i++) {
				stringTmp = stringTmp.replace(wildcardList.get(i).trim(), " not_define");
				/*
				 * Pattern p = Pattern.compile("\\$\\{(.*?)}"); // 匹配】 Matcher matcher =
				 * p.matcher(wpp);
				 */
			}
		}
		return stringTmp;
	}

	/*
	 * public static void main(String[] args) throws IOException, ParseException,
	 * SemanticException { ParseDriver pd = new ParseDriver(); String sql25 = "";
	 * 
	 * String parsesql = sql24; HiveParse hp = new HiveParse();
	 * System.out.println(parsesql); ASTNode ast = pd.parse(parsesql);
	 * System.out.println(ast.toStringTree()); hp.parse(ast);
	 * 
	 * 
	 * 
	 * // 待处理字符串 String wpp =
	 * "jdbc:mysql://${wpp1}:${wpp2}/${wpp3}?&useSSL=false&characterEncoding=utf-8&serverTimezone=Asia/Shanghai&zeroDateTimeBehavior=convertToNull";
	 * //\u0024\u007B\u0028\u002E\u002A\u003F\u0029} // 匹配方式 Pattern p =
	 * Pattern.compile("\\$\\{(.*?)}"); // 匹配】 Matcher matcher = p.matcher(wpp); //
	 * 处理匹配到的值 while (matcher.find()) { System.out.println("woo: " +
	 * matcher.group()); }
	 * 
	 * List<String> lstStrings = dealAfterString(sql25, ";"); List<String>
	 * lstWildCards = new ArrayList<String>();
	 * lstWildCards.add("${hiveconf:data_dt}");
	 * lstWildCards.add("${hiveconf:part_condition}");
	 * lstWildCards.add("${hiveconf:query_condition}"); for (int ii = 0; ii <
	 * lstStrings.size(); ii++) { if(lstStrings.get(ii).trim().equals("")) {
	 * continue; } System.out.println(lstStrings.get(ii).trim()); if
	 * (isCheckSql(lstStrings.get(ii).toString().trim())) { String oneSqlString =
	 * replaceWildCards(lstStrings.get(ii).trim(), lstWildCards); //
	 * System.out.println("==========================="+ii); //
	 * System.out.println(oneSqlString); HiveParse hp = new HiveParse(); ASTNode ast
	 * = pd.parse(oneSqlString.trim()); // System.out.println(ast.toStringTree());
	 * hp.parse(ast); }
	 * 
	 * } }
	 */
	
	
	/*
	 * 
	 * 对SQL语句中的注释进行处理。
	 * 
	 * 
	 */
	public String filterSqlComment(String sql) {
		System.out.println("注释处理前"+sql);
		String strAfterString = "";
		String str[] = sql.split("\n");
		List<String> lstLine = Arrays.asList(sql.split("\n"));

		List<String> lstStartStrings = new ArrayList<>();
		lstStartStrings.add("-");
		lstStartStrings.add("--");
		lstStartStrings.add(" -");
		lstStartStrings.add(" --");
		lstStartStrings.add("--");

		for (int ii = 0; ii < lstLine.size(); ii++) {
			if (lstLine.get(ii).equals(""))
				continue;

			String linString = lstLine.get(ii).trim();
			// System.out.println("字符串为【"+lstLine.get(ii).trim()+"】");
			// System.out.println("TMD 分隔符为【"+lstLine.get(ii).trim().substring(0,1)+"】");
	        Pattern r = Pattern.compile("-.*");
	        // 创建 matcher 对象
	        Matcher m = r.matcher(linString);
	        while (m.find()) {   

	            System.out.println("Found value: " + m.group().toString());
	        	continue;
	        }
	        
	        
			if (linString.startsWith("-") 
					|| linString.startsWith("--") 
					|| linString.startsWith(" -")
					|| linString.startsWith(" --") 
					|| linString.toLowerCase().startsWith("set")
					|| linString.toLowerCase().startsWith("use") 
					|| linString.toLowerCase().startsWith("alter")) {
				// System.out.println("开头是注释："+lstLine.get(ii).trim());
			} else {
				// System.out.println("开头不是注释："+lstLine.get(ii).trim());
				strAfterString = strAfterString + "\n" + lstLine.get(ii);
			}
		}
		System.out.println("注释处理后"+strAfterString);
		return strAfterString;

	}

	public Map<String, Object> paraseSql(String etlsql, String wildcards)
			throws IOException, ParseException, SemanticException {
		ParseDriver pd = new ParseDriver();

		List<String> lstStrings = dealAfterString(etlsql, ";");
		List<String> lstWildCards = new ArrayList<String>();
		lstWildCards.add("${hiveconf:data_dt}");
		lstWildCards.add("${hiveconf:part_condition}");
		lstWildCards.add("${hiveconf:query_condition}");

		for (int ii = 0; ii < lstStrings.size(); ii++) {

			// String paraseSqlString = lstStrings.get(ii);
			// System.out.println("待分解的SQL:" + lstStrings.get(ii));
	
			// if (isCheckSql(lstStrings.get(ii).replace("\n", ""))) {
            if(lstStrings.get(ii).equals("")) {
            	continue;
            }
            
            
    		String paraseSqlString = filterSqlComment(lstStrings.get(ii));
            if(paraseSqlString.equals("")) {
            	continue;
            }    		
			String oneSqlString = replaceWildCards(paraseSqlString.trim(), lstWildCards);
			// System.out.println("替换符处理后的sql:" + oneSqlString);
			System.out.println("要解析的sql:\n" + oneSqlString);
			if (oneSqlString.equals("") || oneSqlString == null)
				continue;
			HiveParse hp = new HiveParse();

			ASTNode ast = pd.parse(oneSqlString.trim());
			hp.parse(ast);
			// }

		}
		Map<String, Object> mprtnMap = new HashMap<String, Object>();
		/*
		 * tablenamelist list<string> columnnamelist list<string>
		 * 
		 */

		return mprtnMap;

	
	}
	
	
	
	public static void main(String[] args) {    
        // 查找的字符串
        String line =
        		"﻿-- METADATA BEGIN\r\n" + 
        		"-- @DESC    个人客户关系\r\n" + 
        		"-- @SRC     SDM_DATA.SDM_CMIS_BUSINESS_CONTRACT,SDM_DATA.SDM_CMIS_BUSINESS_TYPE,SDM_DATA.SDM_CMIS_FLOW_TASK\r\n" + 
        		"-- @TGT     FDM_DATA.FDM_LOAN_CREDITLINE\r\n" + 
        		"-- @AUTHOR  王超\r\n" + 
        		"-- @EDIT_DATE  20180224\r\n" + 
        		"---@EDIT_NOTE  个人客户关系\r\n" + 
        		"---METADATA END\r\n" + 
        		"-- 包括 个人-个人的婚姻、亲属、担保 关系\r\n"
        		+ "-- asdfasdfsafa--";
        //正则表达式
        String pattern = "(-:)(.*?)"; //Java正则表达式以括号分组，第一个括号表示以"（乙方）:"开头，第三个括号表示以" "(空格)结尾，中间括号为目标值，
        // 创建 Pattern 对象
       // Pattern r = Pattern.compile(pattern);
        Pattern r = Pattern.compile("--.* ");
        // 创建 matcher 对象
        Matcher m = r.matcher(line);
        while (m.find()) {   
            /*
             自动遍历打印所有结果   group方法打印捕获的组内容，以正则的括号角标从1开始计算，我们这里要第2个括号里的            
             值， 所以取 m.group(2)， m.group(0)取整个表达式的值，如果越界取m.group(4),则抛出异常
           */
            System.out.println("Found value: " + m.group().toString());
        }
	}
}