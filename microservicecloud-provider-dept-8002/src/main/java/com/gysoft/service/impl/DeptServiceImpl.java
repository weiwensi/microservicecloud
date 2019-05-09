package com.gysoft.service.impl;

import com.gysoft.bean.Dept;
import com.gysoft.dao.DeptDao;
import com.gysoft.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description
 * @Author DJZ-WWS
 * @Date 2019/5/8 10:23
 */

@Service
public class DeptServiceImpl  implements DeptService {

    @Autowired
    private DeptDao dao ;

    @Override
    public boolean add(Dept dept)
    {
        return dao.addDept(dept);
    }

    @Override
    public Dept get(Long id)
    {
        return dao.findById(id);
    }

    @Override
    public List<Dept> list()
    {
        return dao.findAll();
    }
}
