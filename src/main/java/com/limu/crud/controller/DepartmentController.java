package com.limu.crud.controller;

import com.limu.crud.bean.Department;
import com.limu.crud.bean.Msg;
import com.limu.crud.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * TODO 类描述
 *
 * @author: LiMu
 * @createTime: 2022年08月11日 19:52
 * 处理和部门有关的请求
 */

@Controller
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;


    /*
        返回所有的部门信息
    */
    @RequestMapping("/depts")
    @ResponseBody
    public Msg getDepts(){
        //查出的所有部门信息
        List<Department> list = departmentService.getDepts();

        return Msg.success().add("depts",list);
    }

}
