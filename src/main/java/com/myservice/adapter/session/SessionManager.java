package com.myservice.adapter.session;

import com.myservice.adapter.model.UserSessionTemplate;

import java.util.concurrent.ConcurrentHashMap;

/**
 *  Session管理中心
 * Created by msg on 08/04/2018.
 */
public class SessionManager {

    private SessionManager(){

    }

    private static ConcurrentHashMap<String,UserSessionTemplate> contextSession = new ConcurrentHashMap<>();

    public static UserSessionTemplate getSession(String token){
        return contextSession.get(token);
    }

    public static void addSession(String token,UserSessionTemplate sessionTemplate){
        contextSession.put(token,sessionTemplate);
    }

    public static void removeSession(String token){
        contextSession.remove(token);
    }

    public static void removeAllSession(){
        contextSession.clear();
    }

}
