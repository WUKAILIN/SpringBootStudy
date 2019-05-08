package com.springboot.demo.elasticsearch.jpa.service.impl;

import com.springboot.demo.elasticsearch.jpa.dao.EmployeeDao;
import com.springboot.demo.elasticsearch.jpa.pojo.Employee;
import com.springboot.demo.elasticsearch.jpa.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeDao employeeDao;
    @Override
    public Employee save(Employee employee) {
        return employeeDao.save(employee);
    }



    @Override
    public void deleteById(String id) {
        employeeDao.deleteById(id);
    }

    @Override
    public List<Employee> getAll() {
        return employeeDao.findAll();
    }

    @Override
    public Employee getEmployeeById(String id) {
        return employeeDao.getEmployeeById(id);
    }

    @Override
    public List<Employee> findEmployeeByNameLike(String name) {
        return employeeDao.findEmployeeByNameLike(name);
    }

    @Override
    public List<Employee> findEmployeeByNameLikeAndMobileIs(String employeeName, String mobile) {
        return employeeDao.findEmployeeByNameLikeAndMobileIs(employeeName,mobile);
    }
}
