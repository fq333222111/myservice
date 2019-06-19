package com.myservice.exception;

import com.myservice.base.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpMethod;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by fq333 on 2019/4/15.
 *
 * @RestControllerAdvice 相当于@ControllerAdvice + @ResponseBody
 *
 * 全局捕获异常案例
 */
//@ControllerAdvice(basePackages = {"com.product.fq.controller"})
@RestControllerAdvice(basePackages = {"com.myservice.controller"})
@Slf4j
public class GlobalExceptionHandler {

    /**
     * 异常格式工厂
     * */
    private static final String logExceptionFormat = "Capture Exception By GlobalExceptionHandler: Code: %s Detail: %s";

    /**
     * @Description //TODO 运行时异常处理
     * @Date 2019/4/19
     * @Param [ex]
     * @return java.lang.String
     * @Author
     **/
    @ExceptionHandler(RuntimeException.class)
    public Result runtimeExceptionHandler(RuntimeException ex) {
        return resultFormat("系统错误","500", ex);
    }

    /**
     * @Description //TODO 空指针异常处理
     * @Date 2019/4/19
     * @Param [ex]
     * @return java.lang.String
     * @Author
     **/
    @ExceptionHandler(NullPointerException.class)
    public Result nullPointerExceptionHandler(NullPointerException ex) {
        return resultFormat("NullPointerException","500", ex);
    }

    /**
     * @Description //TODO 类型转换异常
     * @Date 2019/4/19
     * @Param [ex]
     * @return java.lang.String
     * @Author
     **/
    @ExceptionHandler(ClassCastException.class)
    public Result classCastExceptionHandler(ClassCastException ex) {
        return resultFormat("类型转换异常","500", ex);
    }

    //
    /**
     * @Description //TODO IO异常
     * @Date 2019/4/19
     * @Param [ex]
     * @return java.lang.String
     * @Author
     **/
    @ExceptionHandler(IOException.class)
    public Result iOExceptionHandler(IOException ex) {
        return resultFormat("IO异常","500", ex);
    }

    /**
     * @Description //TODO 未知方法异常
     * @Date 2019/4/19
     * @Param [ex]
     * @return java.lang.String
     * @Author
     **/
    @ExceptionHandler(NoSuchMethodException.class)
    public Result noSuchMethodExceptionHandler(NoSuchMethodException ex) {
        return resultFormat("未知方法异常","500", ex);
    }

    /**
     * @Description //TODO 数组越界异常
     * @Date 2019/4/19
     * @Param [ex]
     * @return java.lang.String
     * @Author
     **/
    @ExceptionHandler(IndexOutOfBoundsException.class)
    public Result indexOutOfBoundsExceptionHandler(IndexOutOfBoundsException ex) {
        return resultFormat("数组越界异常","500", ex);
    }

    /**
     * @Description /2019/4/19/TODO 400错误
     * @Date
     * @Param [ex]
     * @return java.lang.String
     * @Author
     **/
    @ExceptionHandler({HttpMessageNotReadableException.class})
    public Result requestNotReadable(HttpMessageNotReadableException ex) {
        return resultFormat("不支持的消息体转换，或者消息体丢失","400", ex);
    }

//    /**
//     * @Description //TODO 400错误
//     * @Date 2019/4/19
//     * @Param [ex]
//     * @return java.lang.String
//     * @Author
//     **/
//    @ExceptionHandler({TypeMismatchException.class})
//    public String requestTypeMismatch(TypeMismatchException ex) {
//        System.out.println("400..TypeMismatchException");
//        return resultFormat(8, ex);
//    }

    /**
     * @Description //TODO 400错误
     * @Date 2019/4/19
     * @Param [ex]
     * @return java.lang.String
     * @Author
     **/
    @ExceptionHandler({MissingServletRequestParameterException.class})
    public Result requestMissingServletRequest(MissingServletRequestParameterException ex) {
        System.out.println("400..MissingServletRequest");
        return resultFormat("缺少请求参数 " + ex.getParameterName(),"400", ex);
    }

    /**
     * @Description //TODO 405错误
     * @Date 2019/4/19
     * @Param [ex]
     * @return java.lang.String
     * @Author
     **/
    @ExceptionHandler({HttpRequestMethodNotSupportedException.class})
    public Result request405(HttpRequestMethodNotSupportedException ex) {
        Set<HttpMethod> cves= ex.getSupportedHttpMethods();
        Iterator<HttpMethod> iterator=cves.iterator();
        StringBuilder sb = new StringBuilder();
        String delimiter=";";
        while(iterator.hasNext()){
            HttpMethod violation = iterator.next();
            sb.append(violation.name());
            sb.append(delimiter);
        }
        return resultFormat("不支持的访问方法，请使用一下方法:"+sb.substring(0,sb.lastIndexOf(delimiter)),"405", ex);
    }

//    /**
//     * @Description //TODO 406错误
//     * @Date 2019/4/19
//     * @Param [ex]
//     * @return java.lang.String
//     * @Author
//     **/
//    @ExceptionHandler({HttpMediaTypeNotAcceptableException.class})
//    public String request406(HttpMediaTypeNotAcceptableException ex) {
//        System.out.println("406...");
//        return resultFormat(11, ex);
//    }
//
//    /**
//     * @Description //TODO 500错误
//     * @Date 2019/4/19
//     * @Param [ex]
//     * @return java.lang.String
//     * @Author
//     **/
//    @ExceptionHandler({ConversionNotSupportedException.class, HttpMessageNotWritableException.class})
//    public String server500(RuntimeException ex) {
//        System.out.println("500...");
//        return resultFormat(12, ex);
//    }
//
//    /**
//     * @Description //TODO 栈溢出
//     * @Date 2019/4/19
//     * @Param [ex]
//     * @return java.lang.String
//     * @Author
//     **/
//    @ExceptionHandler({StackOverflowError.class})
//    public String requestStackOverflow(StackOverflowError ex) {
//        return resultFormat(13, ex);
//    }
//
//    /**
//     * @Description //TODO 除数不能为0
//     * @Date 2019/4/19
//     * @Param [ex]
//     * @return java.lang.String
//     * @Author
//     **/
//    @ExceptionHandler({ArithmeticException.class})
//    public String arithmeticException(ArithmeticException ex) {
//        return resultFormat(13, ex);
//    }


    /**
     * @Description //TODO 其他错误
     * @Date 2019/4/19
     * @Param [ex]
     * @return java.lang.String
     * @Author
     **/
    @ExceptionHandler({Exception.class})
    public Result exception(Exception ex) {
        return resultFormat("系统出错了","500", ex);
    }

    /**
     * @Description //TODO 日志打印和返回错误信息
     * @Date 2019/4/19
     * @Param [code, ex]
     * @return java.lang.String
     * @Author
     **/
    private <T extends Throwable> Result resultFormat(String message, String code,T ex) {
        ex.printStackTrace();
        log.error(String.format(logExceptionFormat, code, ex.getMessage()));
        return Result.error(code,message,ex.getMessage());
    }

}
