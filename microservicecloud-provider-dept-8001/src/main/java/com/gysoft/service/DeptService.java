package com.gysoft.service;

import com.gysoft.bean.Dept;

import java.util.List;

/**
 * @Description
 * @Author DJZ-WWS
 * @Date 2019/5/8 10:22
 */
public interface DeptService {
    public boolean add(Dept dept);
    public Dept    get(Long id);
    public List<Dept> list();
}
