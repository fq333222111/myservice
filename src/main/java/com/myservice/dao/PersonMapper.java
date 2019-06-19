package com.myservice.dao;

import com.myservice.model.Person;

public interface PersonMapper {
    int deleteByPrimaryKey(String guid);

    int insert(Person record);

    int insertSelective(Person record);

    Person selectByPrimaryKey(String guid);

    int updateByPrimaryKeySelective(Person record);

    int updateByPrimaryKey(Person record);
}