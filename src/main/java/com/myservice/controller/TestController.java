package com.myservice.controller;

import com.myservice.util.annotation.MethodInfo;
import com.myservice.util.annotation.PassToken;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author
 * @description
 * @date 2019/6/10
 */
@Controller
public class TestController {

    @MethodInfo(date = "2019-6-14",comments = "这是一个测试的方法")
    @RequestMapping(method = RequestMethod.GET,value = "/testMethodInfo")
    @PassToken
    public String testMethodInfo(){
        return "testMethodInfo";
    }

//    @MethodInfo(date = "2019-6-14",comments = "这是一个测试的方法")
//    public static void main(String[] args) {
////        int a = 12;
////        double b = 12.0;
////        long c = 12;
////        boolean d = true;
////        char e = 'e';
////
////        Map map = new HashMap();
////        map.put("a","a");
////        map.put("a",null);
////
////        short s1 = 1;
//////        s1 = s1 + 1;
////        s1 += 1;
////
////        String str = "testqwertyuiop";
////        String[] char1 = str.split("");
////        for (String item: char1
////             ) {
////            System.out.println(item);
////        }
//
////        char ch = '中';
//
////        byte by = (byte)129;
//
////        ArrayList list = new ArrayList();
////        Object obj = new Object();
//        /**
//         * switch case 支持字符串 字符  数字 枚举类型
//         * */
////        TestEnu color = TestEnu.RED;
////        switch (color){
////            case RED:
////                break;
////            case :
////        }
//
//        System.out.println(TestEnum.fromTypeName(1));
//
//    }
}

