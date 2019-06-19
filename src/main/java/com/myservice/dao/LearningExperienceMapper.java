package com.myservice.dao;

import com.myservice.model.LearningExperience;

public interface LearningExperienceMapper {
    int deleteByPrimaryKey(String guid);

    int insert(LearningExperience record);

    int insertSelective(LearningExperience record);

    LearningExperience selectByPrimaryKey(String guid);

    int updateByPrimaryKeySelective(LearningExperience record);

    int updateByPrimaryKey(LearningExperience record);
}