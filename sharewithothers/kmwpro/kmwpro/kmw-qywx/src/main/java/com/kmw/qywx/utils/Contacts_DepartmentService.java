package com.kmw.qywx.utils;



import net.sf.json.JSONObject;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.google.gson.Gson;




public class Contacts_DepartmentService {
    private static Logger log = LoggerFactory.getLogger(Contacts_DepartmentService.class);  

    private  static  String createDepartment_url="https://qyapi.weixin.qq.com/cgi-bin/department/create?access_token=ACCESS_TOKEN";  
    private  static  String updateDepartment_url="https://qyapi.weixin.qq.com/cgi-bin/department/update?access_token=ACCESS_TOKEN";  
    private  static  String deleteDepartment_url="https://qyapi.weixin.qq.com/cgi-bin/department/delete?access_token=ACCESS_TOKEN&id=ID";  
    private  static  String getDepartmentList_url="https://qyapi.weixin.qq.com/cgi-bin/department/list?access_token=ACCESS_TOKEN&id=ID";  
    private  static  String getDepartmentAll_url="https://qyapi.weixin.qq.com/cgi-bin/department/list?access_token=ACCESS_TOKEN";  
    
    //1.创建部门
    public void createDepartment(String accessToken,Department department) {

        //1.获取json字符串：将Department对象转换为json字符串    
        Gson gson = new Gson(); 
        String jsonDepartment =gson.toJson(department);      //使用gson.toJson(jsonDepartment)即可将jsonDepartment对象顺序转成json
        System.out.println("jsonDepartment:"+jsonDepartment);
        //2.拼接请求的url
        createDepartment_url=createDepartment_url.replace("ACCESS_TOKEN", accessToken);

        //3.调用接口，发送请求，创建部门
        JSONObject jsonObject = WeiXinUtil.httpRequest(createDepartment_url, "POST", jsonDepartment);  
        System.out.println("jsonObject:"+jsonObject.toString());
        if (null != jsonObject) {  
            if (0 != jsonObject.getInt("errcode")) {  

                log.error("创建部门失败 errcode:{} errmsg:{}", jsonObject.getInt("errcode"), jsonObject.getString("errmsg"));  
            }  
        }  
    }

    //2.更新部门
    public void updateDepartment(String accessToken,Department department) {

        //1.获取json字符串：将Department对象转换为json字符串    
        Gson gson = new Gson(); 
        String jsonDepartment =gson.toJson(department);      //使用gson.toJson(jsonDepartment)即可将jsonDepartment对象顺序转成json
        System.out.println("jsonDepartment:"+jsonDepartment);
        //2.拼接请求的url
        updateDepartment_url=updateDepartment_url.replace("ACCESS_TOKEN", accessToken);

        //3.调用接口，发送请求，更新部门
        JSONObject jsonObject = WeiXinUtil.httpRequest(updateDepartment_url, "POST", jsonDepartment);  
        System.out.println("jsonObject:"+jsonObject.toString());
        if (null != jsonObject) {  
            if (0 != jsonObject.getInt("errcode")) {  

                log.error("更新部门失败 errcode:{} errmsg:{}", jsonObject.getInt("errcode"), jsonObject.getString("errmsg"));  
            }  
        }  
    }
    

    //3.删除部门
    public void deleteDepartment(String accessToken,String departmentId) {    

        //1.获取请求的url  
        deleteDepartment_url=deleteDepartment_url.replace("ACCESS_TOKEN", accessToken)
                .replace("ID", departmentId);

        //2.调用接口，发送请求，删除部门
        JSONObject jsonObject = WeiXinUtil.httpRequest(deleteDepartment_url, "GET", null);  
        System.out.println("jsonObject:"+jsonObject.toString());

        //3.错误消息处理
        if (null != jsonObject) {  
            if (0 != jsonObject.getInt("errcode")) {  
                log.error("删除部门失败 errcode:{} errmsg:{}", jsonObject.getInt("errcode"), jsonObject.getString("errmsg"));  
            }  
        }  
    }
    
    
    
    //4.获取部门列表
    public void getDepartmentList(String accessToken,String departmentId) {

        //1.获取请求的url  
        getDepartmentList_url=getDepartmentList_url.replace("ACCESS_TOKEN", accessToken)
                .replace("ID", departmentId);

        //2.调用接口，发送请求，获取成员
        JSONObject jsonObject = WeiXinUtil.httpRequest(getDepartmentList_url, "GET", null);  
        System.out.println("jsonObject:"+jsonObject.toString());

        //3.错误消息处理
        if (null != jsonObject) {  
            if (0 != jsonObject.getInt("errcode")) {  
                log.error("获取部门列表 errcode:{} errmsg:{}", jsonObject.getInt("errcode"), jsonObject.getString("errmsg"));  
            }  
        }  
    }

    /**
     * 获取所有部门
     * 20190831 代码没有调试成功，需要后期调整
     * @return
     */
    public static List<Department> getAllDepartment(String accessToken) { 

        String url = getDepartmentAll_url.replace("ACCESS_TOKEN", accessToken);  
        // 调用接口创建部门
        Gson gson = new Gson(); 
        JSONObject jsonObject = WeiXinUtil.httpRequest(getDepartmentAll_url, "POST", "");  
 
        if (null != jsonObject) {
            String departmentjson = jsonObject.getString("department");

            //List<Department> ps = gson.fromJson(departmentjson, new TypeToken<List<Department>>(){}.getType());
         //   return ps;
        }  
        return null;  
    }
}