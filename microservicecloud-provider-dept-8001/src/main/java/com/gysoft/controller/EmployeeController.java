package com.gysoft.controller;

import com.gysoft.bean.Employee;
import com.gysoft.service.EmployeeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@RestController
public class EmployeeController {
    @Resource
    private EmployeeService employeeService;
    @GetMapping("/doEmployee")
    public   String  doEmployee(){
        employeeService.getEmplotees();
        return "ok";
    }

    @GetMapping("/getEmployeeById/{id}")
    public Employee  getEmployeeById(@PathVariable Integer id){
       return employeeService.getEmployeeById(id);
    }
    //返回 id,性别map
    @GetMapping("/getEmployeeMapById")
    public Map<Integer,String> getEmployeeMapById(){
        return employeeService.getEmployeeMapById();
    }

    //返回各个部门的人名
    @GetMapping("/getDeptAndEmployee")
    public  Map<String, List<String>> getDeptAndEmployee(){
       return employeeService.getDeptAndEmployee();
    }

}
