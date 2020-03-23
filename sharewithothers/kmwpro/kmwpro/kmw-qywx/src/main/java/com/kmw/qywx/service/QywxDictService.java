package com.kmw.qywx.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kmw.qywx.domain.WxUser;
import com.kmw.system.domain.SysDictData;

@Service("qywxdict")
public class QywxDictService {
    @Autowired
    IWxUserService wxUserService;
    /**
     * 根据字典类型查询字典数据信息
     * 
     * @param dictType 字典类型
     * @return 参数键值
     */
    public List<WxUser> getWxUserName(String account)
    {
    	WxUser wxUser = new WxUser();
    	wxUser.setAccount(account);
        return wxUserService.selectWxUserList(wxUser);
        
    }


}
