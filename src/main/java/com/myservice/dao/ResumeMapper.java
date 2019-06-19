package com.myservice.dao;

import com.myservice.model.Resume;

public interface ResumeMapper {
    int deleteByPrimaryKey(String guid);

    int insert(Resume record);

    int insertSelective(Resume record);

    Resume selectByPrimaryKey(String guid);

    int updateByPrimaryKeySelective(Resume record);

    int updateByPrimaryKey(Resume record);
}