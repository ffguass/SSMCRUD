package com.crud.controller;

import com.crud.beans.Employee;
import com.crud.service.EmployeeService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


import java.util.List;

/**处理员工的CRUD请求
 * @MethodName:
 * @Description: TODO
 * @Param:
 * @Return:
 * @Author: gmf
 * @Date: 2019/11/7
**/
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;
    /**
     * 查询员工数据（分页查询）
     * @Return:
     * */
    @RequestMapping("/emps")
    public String getEmps(@RequestParam(value = "pn",defaultValue = "1") Integer pn,
                          Model model){
        //引入PageHelper分页插件
        //在查询之前只需要调用,传入页码和每页大小
        PageHelper.startPage(pn,10);
        //startPage后面这个查询就是分页查询
        List<Employee> emps = employeeService.getAll();
        //使用pageInfo包装查询后的结果，将pageInfo交给页面就行了
        //封装了详细的分页信息，包括有需要的查询出来的数据，传入连续显示的页数
        PageInfo page =new PageInfo(emps);
        model.addAttribute("pageInfo",page);
        return "list";
    }
}
