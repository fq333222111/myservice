package com.myservice.dao;

import com.myservice.model.Projects;

public interface ProjectsMapper {
    int deleteByPrimaryKey(String guid);

    int insert(Projects record);

    int insertSelective(Projects record);

    Projects selectByPrimaryKey(String guid);

    int updateByPrimaryKeySelective(Projects record);

    int updateByPrimaryKey(Projects record);
}