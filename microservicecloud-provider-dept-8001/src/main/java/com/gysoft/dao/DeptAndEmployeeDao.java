package com.gysoft.dao;

import com.gysoft.bean.DeptEmployee;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DeptAndEmployeeDao {

    List<DeptEmployee> getAllDeptAndEmployeeInfo();
}
