package com.myservice.dao;

import com.myservice.model.SysUser;

public interface SysUserMapper {
    int deleteByPrimaryKey(String guid);

    int insert(SysUser record);

    int insertSelective(SysUser record);

    SysUser selectByPrimaryKey(String guid);

    int updateByPrimaryKeySelective(SysUser record);

    int updateByPrimaryKey(SysUser record);
}