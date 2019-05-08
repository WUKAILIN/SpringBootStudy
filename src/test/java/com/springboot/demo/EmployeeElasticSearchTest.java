package com.springboot.demo;

import com.springboot.demo.elasticsearch.jpa.pojo.Employee;
import com.springboot.demo.elasticsearch.jpa.service.EmployeeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class EmployeeElasticSearchTest {
    @Autowired
    private EmployeeService employeeServiceImpl;
    @Test
    public void testGetEmployeeById()
    {
        Employee employeeInfo =employeeServiceImpl.getEmployeeById("1983");
        System.out.println("员工姓名-----------"+ employeeInfo.getName()+";联系方式-------------"+ employeeInfo.getMobile());
    }
    @Test
    public void testSave()
    {
        Employee employee=new Employee();
        employee.setName("ES测试ByJPA1983");
        employee.setAddress("esjpa1983");
        employee.setAge((long) 28);
        employee.setBirthday(new Date());
        employee.setMobile("13519611778");
        employee.setSex("男");
        employee.setId("1983");
        employeeServiceImpl.save(employee);
    }
    @Test
    public void testFindAll()
    {
        List<Employee> employeeList=employeeServiceImpl.getAll();
        System.out.println("文档数量------------"+employeeList.size());
        for(Employee employee:employeeList)
        {
            System.out.println("文档标识-------------"+employee.getId()+";员工姓名--------"+employee.getName());
        }
    }
    @Test
    public void testFindByName()
    {
        List<Employee> employeeList=employeeServiceImpl.findEmployeeByNameLike("吴");
        System.out.println("文档数量------------"+employeeList.size());
        for(Employee employee:employeeList)
        {
            System.out.println("文档标识-------------"+employee.getId()+";员工姓名--------"+employee.getName());
        }
    }
    @Test
    public void testFindByNameAndMobile()
    {
        List<Employee> employeeList=employeeServiceImpl.findEmployeeByNameLikeAndMobileIs("吴","13519611778");
        System.out.println("文档数量------------"+employeeList.size());
        for(Employee employee:employeeList)
        {
            System.out.println("文档标识-------------"+employee.getId()+";员工姓名--------"+employee.getName());
        }
    }
    @Test
    public void testDeleteById()
    {
        employeeServiceImpl.deleteById("null");

    }
}
