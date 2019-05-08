package com.springboot.demo.elasticsearch.jpa.service;

import com.springboot.demo.elasticsearch.jpa.pojo.Employee;

import java.util.List;

public interface EmployeeService {
    public Employee save(Employee employee);
    public void deleteById(String id);
    public List<Employee> getAll();
    public Employee getEmployeeById(String id);
    public List<Employee> findEmployeeByNameLike(String name);
    public List<Employee> findEmployeeByNameLikeAndMobileIs(String employeeName, String mobile);
}
