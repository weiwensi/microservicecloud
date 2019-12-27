package com.gysoft.service;

import com.gysoft.bean.Employee;

import java.util.List;
import java.util.Map;

public interface EmployeeService {

    void getEmplotees();

    /**
     * 根据员工id获取员工信息
     * @param id
     * @return
     */
    Employee getEmployeeById(Integer id);

    /**
     * 返回员工的id,性别map
     * @return
     */
    Map<Integer,Object> getEmployeeMapById();

    /**
     * 获取所有部门及所有员工
     * @return
     */
    Map<String, List<String>> getDeptAndEmployee();

}
