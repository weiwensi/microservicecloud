package com.gysoft.service.impl;

import com.gysoft.bean.*;
import com.gysoft.dao.DeptAndEmployeeDao;
import com.gysoft.dao.DeptDao;
import com.gysoft.dao.EmployeeDao;
import com.gysoft.service.EmployeeService;
import com.gysoft.vo.QueryParam;
import org.apache.ibatis.annotations.Param;
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
    public Map<Integer, Object> getEmployeeMapById() {
        Integer id =1;
        return employeeDao.getEmployeeByIdReturnMap(id);
    }

    @Override
    public  Map<String, List<String>> getDeptAndEmployee() {
        List<DepNameEmpNameInfo> deptNameAndEmployeeNameList = deptDao.getDeptNameAndEmployeeNameList();
        System.out.println(deptNameAndEmployeeNameList);
        Map<String, List<String>> deptNameAndEmpName = deptNameAndEmployeeNameList.stream().
                collect(Collectors.groupingBy(DepNameEmpNameInfo::getDname,
                Collectors.mapping(DepNameEmpNameInfo::getLast_name, Collectors.toList())));
        //--------------查询参数是一个对象-----------
        QueryParam  param=new QueryParam();
        param.setGender(2);
        param.setLastName("肖肖");
        List<Employee> employeeByVo = employeeDao.getEmployeeByVo(param);
        System.out.println(employeeByVo);
        //查询条件可能存在也可能不存在
        QueryParam  param2=new QueryParam();
        String lastName ="肖肖";
        Integer  a=null;
        List<Employee> voIf= employeeDao.getEmployeeIf( lastName,a);
        System.out.println("动态sql标签if: "+"集合元素个数："+voIf+voIf.size()+"个");
       //测试分页 查询
        List<Employee> pageResult = employeeDao.pageQueryEmployee(0, 2);
        System.out.println("分页查询查出的结果是："+pageResult);
        return deptNameAndEmpName;
    }

    public void  test1(){
        //mybatis 返回key  对象的集合
        Map<String, Employee> employeeIdMap = employeeDao.selectAllEmpsReturnMap();
       //返回一个map
      //查询参数是一个对象

    }

}
