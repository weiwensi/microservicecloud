package com.gysoft.dao;

import com.gysoft.bean.Employee;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

@Mapper
public interface EmployeeDao {
    /**
     * 根据员工id获取员工信息
     *
     * @param id
     * @return
     */
    @Select("select * from tbl_employee where id=#{id}")
    Employee getEmployeeById( Integer id);

    /**
     * 插入员工信息
     *
     * @param employee
     * @return
     */
    Integer insertEmployee(Employee employee);

    /**
     * 更新
     *
     * @param employee
     * @return
     */
    Boolean updateEmployee(Employee employee);

    /**
     * 删除操作
     */

    void deleteEmployeeById(Integer id);

    /**
     * 获取所有的员工
     */
    List<Employee> getAllEmps();

    /**
     * 查询id,性别
     * @return
     */
    Map<Integer,String> getEmployeeByIdReturnMap(  );


}
