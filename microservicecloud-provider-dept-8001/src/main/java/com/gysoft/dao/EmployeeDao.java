package com.gysoft.dao;

import com.gysoft.bean.Employee;
import com.gysoft.vo.QueryParam;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
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
    Map<Integer,Object> getEmployeeByIdReturnMap(Integer id );
    //获取map结果  key(id),V(List)
     @MapKey("id")
     Map<String,Employee>  selectAllEmpsReturnMap();

    List<Employee> getEmployeeByVo(@Param("qp") QueryParam param);


    List<Employee> getEmployeeIf(@Param("lastName") String  lastName,@Param("gender")Integer  gender);

    List<Employee>  pageQueryEmployee(@Param("currentPage") Integer  currentPage,@Param("pageSize") Integer pageSize);
}
