package com.limu.crud.service;

import com.limu.crud.bean.Department;
import com.limu.crud.dao.DepartmentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * TODO 类描述
 *
 * @author: LiMu
 * @createTime: 2022年08月11日 19:53
 */


@Service
public class DepartmentService {

    @Autowired
    private DepartmentMapper departmentMapper;

    public List<Department> getDepts() {
        List<Department> list = departmentMapper.selectByExample(null);
        return list;
    }
}
