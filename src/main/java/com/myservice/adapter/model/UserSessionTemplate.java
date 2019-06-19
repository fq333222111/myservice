package com.myservice.adapter.model;



import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * 用户session模型
 * Created by msg on 08/04/2018.
 */
public class UserSessionTemplate {

    private String userId;

    private String token;

    private Map<String,Serializable> sesstionAttr = new HashMap<>();

    private long outTime;

//    private SysUser sysUser;
//
//    public SysUser getSysUser() {
//        return sysUser;
//    }
//
//    public void setSysUser(SysUser sysUser) {
//        this.sysUser = sysUser;
//    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public long getOutTime() {
        return outTime;
    }

    public void setOutTime(long outTime) {
        this.outTime = outTime;
    }

    public Map<String, Serializable> getSesstionAttr() {
        return sesstionAttr;
    }

    public void setSesstionAttr(Map<String, Serializable> sesstionAttr) {
        this.sesstionAttr = sesstionAttr;
    }
}
