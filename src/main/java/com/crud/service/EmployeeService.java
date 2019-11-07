package com.crud.service;

import com.crud.beans.Employee;
import com.crud.dao.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @ClassName EmployeeService
 * @Description: TODO
 * @Author gmf
 * @Date 2019/11/7
 * @Version V1.0
 **/
public class EmployeeService {
    
    @Autowired
    EmployeeMapper employeeMapper;
    
     /**查询所有员工
      * @MethodName:
      * @Description: TODO
      * @Param: 
      * @Return: 
      * @Author: gmf
      * @Date: 2019/11/7
     **/
    public List<Employee> getAll() {
        return  employeeMapper.selectByExampleWithDept(null);
    }
}
