package com.myservice.dao;

import com.myservice.model.SysDictionary;

public interface SysDictionaryMapper {
    int deleteByPrimaryKey(String guid);

    int insert(SysDictionary record);

    int insertSelective(SysDictionary record);

    SysDictionary selectByPrimaryKey(String guid);

    int updateByPrimaryKeySelective(SysDictionary record);

    int updateByPrimaryKey(SysDictionary record);
}