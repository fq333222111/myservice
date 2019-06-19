package com.myservice.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

/**
 * @author
 * @description AOP日志处理
 * @date 2019/4/15
 */
@Aspect
@Component
public class WebLogAspect {

    Logger logger = null;
    /**
     * @Description //TODO 配置那个包需要AOP日志处理
     * @Date 2019/4/15
     * @Param []
     * @return void
     * @Author
     **/
    @Pointcut("execution(public * com.myservice.controller.*.*(..))")
    public void weblog(){

    }

    /**
     * @Description //TODO 执行方法之前
     * @Date 2019/4/15
     * @Param [joinPoint]
     * @return void
     * @Author
     **/
    @Before("weblog()")
    public void doBefore(JoinPoint joinPoint) throws Throwable {
        logger = LoggerFactory.getLogger(joinPoint.getTarget().getClass());
        //接受请求，记录请求内容
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        //记录下请求内容
        logger.info("URL : >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" + request.getRequestURI().toString());
        logger.info("HTTP_METHOD : >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" + request.getMethod());
        logger.info("IP : >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" + request.getRemoteAddr());
        Enumeration<String> enu = request.getParameterNames();
        while (enu.hasMoreElements()){
            String name = enu.nextElement();
            logger.info("name : {},value : {}",name,request.getParameter(name));
        }
    }

    /**
     * @Description //TODO 处理完之后打印
     * @Date 2019/4/15
     * @Param [ret]
     * @return void
     * @Author
     **/
    @AfterReturning(returning = "ret",pointcut = "weblog()")
    public void doAfterReturning(Object ret){
        //处理完后  返回请求结果
        logger.info("RESPONSE : >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+ret);
    }
}
