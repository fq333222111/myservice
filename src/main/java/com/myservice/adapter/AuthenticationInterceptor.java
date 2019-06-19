package com.myservice.adapter;

import com.alibaba.fastjson.JSON;
import com.myservice.adapter.model.UserSessionTemplate;
import com.myservice.adapter.session.SessionManager;
import com.myservice.base.Result;
import com.myservice.util.StringUtils;
import com.myservice.util.annotation.PassToken;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;
import java.nio.charset.Charset;
import java.util.Set;

/**
 * @author
 * @description 定义的拦截器
 * @date 2019/4/18
 */
@Slf4j
public class AuthenticationInterceptor implements HandlerInterceptor {

    private static final Integer SESSION_OUT_TIME = 60 * 60 * 1000;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object object) throws Exception {
        String userId ;// 从 http 请求头中取出 token
        String requestUrl = request.getRequestURI();
        if (requestUrl.contains("//")) {
            requestUrl = requestUrl.replaceAll("//", "/");
        }

        /**
         * 如果为swagger网址直接跳过
         * */
        if (requestUrl.contains("/v2/") || requestUrl.contains("/swagger-resources/")|| requestUrl.contains("/swagger")) {
            return true;
        }


        /**
         * 注释拦截
         *
         * 如果不是映射到方法直接通过
         * */
        if(!(object instanceof HandlerMethod)){
            return true;
        }
        HandlerMethod handlerMethod=(HandlerMethod)object;
        Method method=handlerMethod.getMethod();
        //检查是否有passtoken注释，有则跳过认证
        if (method.isAnnotationPresent(PassToken.class)) {
            PassToken passToken = method.getAnnotation(PassToken.class);
            if (passToken.required()) {
                return true;
            }
        }

//        //检查是否有MethodInfo注释，有则跳过认证
//        if (method.isAnnotationPresent(MethodInfo.class)) {
//            MethodInfo methodInfo = method.getAnnotation(MethodInfo.class);
//            System.out.println(methodInfo.author());
//            System.out.println(methodInfo.date());
//            System.out.println(methodInfo.revision());
//            System.out.println(methodInfo.comments());
//        }

        /**
         * 登录超时拦截
         * */
        if (!StringUtils.isEmpty(request.getHeader("token"))){
            String  token = request.getHeader("token");
            UserSessionTemplate template = SessionManager.getSession(token);
            if (template != null) {
                if (template.getOutTime() != 0 && System.currentTimeMillis() - template.getOutTime() >= SESSION_OUT_TIME) {
                    SessionManager.removeSession(token);
                    noAuth(response, "您的登录已超时，请重新登录", "-1001");
                    return false;
                }
                userId = template.getUserId();
                Set<String> attrNames = template.getSesstionAttr().keySet();
                for (String name : attrNames) {
                    request.getSession().setAttribute(name, template.getSesstionAttr().get(name));
                }
                template.setOutTime(System.currentTimeMillis());
            } else {
                SessionManager.removeSession(token);
                noAuth(response, "您还没有登录", "-1001");
                return false;
            }
        } else {
            noAuth(response, "您还没有登录", "-1001");
            return false;
        }
//        //检查有没有需要用户权限的注解
//        if (method.isAnnotationPresent(UserLoginToken.class)) {
//            UserLoginToken userLoginToken = method.getAnnotation(UserLoginToken.class);
//            if (userLoginToken.required()) {
//                // 执行认证
//                if (token == null) {
//                    throw new RuntimeException("无token，请重新登录");
//                }
//                // 获取 token 中的 user id
//                String userId;
//                try {
//                    userId = JWT.decode(token).getAudience().get(0);
//                } catch (JWTDecodeException j) {
//                    throw new RuntimeException("401");
//                }
//                Student student = studentService.selectStudentByName(userId);
//                if (student == null) {
//                    throw new RuntimeException("用户不存在，请重新登录");
//                }
//                // 验证 token
//                JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256(student.getId()+"")).build();
//                try {
//                    jwtVerifier.verify(token);
//                } catch (JWTVerificationException e) {
//                    throw new RuntimeException("401");
//                }
//                return true;
//            }
//
//        }

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest,
                           HttpServletResponse httpServletResponse,
                           Object o, ModelAndView modelAndView) throws Exception {

    }
    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest,
                                HttpServletResponse httpServletResponse,
                                Object o, Exception e) throws Exception {
    }


    /**
     * @Author chengpunan
     * @Description TODO 
     * @Date 14:21 2019/6/19
     * @Param [response, message, code]
     * @return void
     **/
    private void noAuth(HttpServletResponse response, String message, String code) {
        Result result = new Result();
        result.setData(null);
        result.setSuccess(false);
        result.setMessage(message);
        result.setCode(code);
        try {
            response.getOutputStream().write(JSON.toJSONString(result).getBytes(Charset.forName("utf-8")));
        } catch (IOException e) {
            log.warn("返回权限校验结果失败", e);
        }
    }

}
