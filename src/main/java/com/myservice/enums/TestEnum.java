package com.myservice.enums;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by fq333 on 2019/6/14.
 */

public enum TestEnum {
    BLANK(3), GREEN(2), RED(1)/**
     * 枚举使用情景
     * 2. 带参数的枚举常量
     * 此场景是定义有值的枚举类型，按照值回去对应的类型；
     * */
    , YELLO(4);

    private int typeName;

    TestEnum(int typeName) {
        this.typeName = typeName;
    }

    public static TestEnum fromTypeName(int typeName) {
        for (TestEnum type : TestEnum.values()) {
            if (type.getTypeName() == typeName) {
                return type;
            }
        }
        return null;
    }

    public int getTypeName() {
        return typeName;
    }


    /**
     * 枚举使用情景
     * 3. 带索引的枚举类型，
     *
     * */
//    RED("红色", 1), GREEN("绿色", 2), BLANK("白色", 3), YELLO("黄色", 4);
//
//    // 普通方法
//    public static String getName(int index) {
//        for (TestEnum c : TestEnum.values()) {
//            if (c.getIndex() == index) {
//                return c.name;
//            }
//        }
//        return null;
//    }
//
//    // 成员变量
//    @Setter
//    @Getter
//    private String name;
//    @Setter
//    @Getter
//    private int index;
//    // 构造方法
//    private TestEnum(String name, int index) {
//        this.name = name;
//        this.index = index;
//    }
}
