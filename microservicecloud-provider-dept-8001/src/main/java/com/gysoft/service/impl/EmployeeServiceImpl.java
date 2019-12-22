package com.gysoft.service.impl;

import com.gysoft.bean.*;
import com.gysoft.dao.DeptAndEmployeeDao;
import com.gysoft.dao.DeptDao;
import com.gysoft.dao.EmployeeDao;
import com.gysoft.service.EmployeeService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Resource
    private EmployeeDao employeeDao;
    @Resource
    private DeptDao deptDao;
    @Resource
    private DeptAndEmployeeDao deptAndEmployeeDao;

    public void getEmplotees() {
        //获取所有的员工
        List<Employee> allEmps = employeeDao.getAllEmps();
        System.out.println(allEmps);
        Employee empl2 = Employee.builder().email("dddd@qq.com").gender("2").id(3).lastName("李三").lastName("风").build();
        employeeDao.updateEmployee(empl2);
    }

    @Override
    public Employee getEmployeeById(Integer id) {
        return  employeeDao.getEmployeeById(id);
    }

    @Override
    public Map<Integer, String> getEmployeeMapById() {
        return employeeDao.getEmployeeByIdReturnMap();
    }

    @Override
    public  Map<String, List<String>> getDeptAndEmployee() {
        List<DepNameEmpNameInfo> deptNameAndEmployeeNameList = deptDao.getDeptNameAndEmployeeNameList();
        System.out.println(deptNameAndEmployeeNameList);
        Map<String, List<String>> deptNameAndEmpName = deptNameAndEmployeeNameList.stream().
                collect(Collectors.groupingBy(DepNameEmpNameInfo::getDname,
                Collectors.mapping(DepNameEmpNameInfo::getLast_name, Collectors.toList())));
        return deptNameAndEmpName;
    }

}
