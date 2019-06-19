package com.myservice.dao;

import com.myservice.model.SysLog;

public interface SysLogMapper {
    int deleteByPrimaryKey(String guid);

    int insert(SysLog record);

    int insertSelective(SysLog record);

    SysLog selectByPrimaryKey(String guid);

    int updateByPrimaryKeySelective(SysLog record);

    int updateByPrimaryKeyWithBLOBs(SysLog record);

    int updateByPrimaryKey(SysLog record);
}