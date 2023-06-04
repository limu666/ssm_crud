package com.limu.crud.service;

import com.limu.crud.bean.Employee;
import com.limu.crud.bean.EmployeeExample;
import com.limu.crud.dao.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * TODO 类描述
 *
 * @author: LiMu
 * @createTime: 2022年08月08日 19:15
 */


@Service
public class EmployeeService {

    @Autowired
    EmployeeMapper employeeMapper;

    /*
    * 查询所有员工
    * */

    public List<Employee> getALL() {

        return employeeMapper.selectByExampleWithDept(null);
    }

    /*
    * 员工保存
    * */
    public void saveEmp(Employee employee) {
        employeeMapper.insertSelective(employee);
    }

    //校验用户名是否可用
    public boolean checkUser(String empName) {
        EmployeeExample example = new EmployeeExample();
        EmployeeExample.Criteria criteria = example.createCriteria();
        criteria.andEmpNameEqualTo(empName);
        long count = employeeMapper.countByExample(example);
        return count == 0; //true代表可用  FALSE代表不可用
    }

    /*
    按照员工id查询员工
    * */
    public Employee getEmp(Integer id) {
        Employee employee = employeeMapper.selectByPrimaryKey(id);
        return employee;
    }

    //员工更新
    public void updateEmp(Employee employee) {
        employeeMapper.updateByPrimaryKeySelective(employee);
    }

    //员工删除
    public void deleteEmp(Integer id) {
        employeeMapper.deleteByPrimaryKey(id);
    }

    public void deleteBatch(List<Integer> ids) {
        EmployeeExample example = new EmployeeExample();
        EmployeeExample.Criteria criteria = example.createCriteria();
        //delete from xxx where empId in(1,2,3)
        criteria.andEmpIdIn(ids);
        employeeMapper.deleteByExample(example);

    }
}
