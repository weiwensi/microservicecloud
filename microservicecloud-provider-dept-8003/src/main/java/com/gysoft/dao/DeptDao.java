package com.gysoft.dao;

/**
 * @Description
 * @Author DJZ-WWS
 * @Date 2019/5/8 10:20
 */

import com.gysoft.bean.Dept;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DeptDao
{
    public boolean addDept(Dept dept);

    public Dept findById(Long id);

    public List<Dept> findAll();
}