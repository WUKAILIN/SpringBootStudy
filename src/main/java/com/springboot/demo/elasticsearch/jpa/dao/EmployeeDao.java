package com.springboot.demo.elasticsearch.jpa.dao;

import com.springboot.demo.elasticsearch.jpa.pojo.Employee;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeDao extends ElasticsearchRepository<Employee,String> {
    /**
     * 保存员工信息
     * @param employee:被保存员工信息
     * @return 保存员工信息
     */
    public Employee save(Employee employee);


    /**
     * 根据员工标识删除员工信息
     * @param id:员工标识
     */
    public void deleteById(String id);

    /**
     * 检索所有文档信息
     * 相当于http://host:port/{index}/{type}/_search
     * @return 所有员工文档集合
     */
    public List<Employee> findAll();

    /**
     * 根据员工标识检索员工文档详情
     * 相当于http://host:port/{index}/{type}/{id}
     * @param id:员工标识
     * @return 员工文档详情
     */
    public Employee getEmployeeById(String id);

    /**
     * 根据出生日期模糊检索员工文档集合信息
     * 相当于http://host:port/{index}/{type}/_search后查询表达式{"query":{"match":{"name":{name}}}
     * @param name 员工名称
     * @return 符合检索条件员工文档集合
     */
    public List<Employee> findEmployeeByNameLike(String name);

    /**
     * 根据员工姓名模糊检索和联系方式精确检索匹配员工文档集合
     * 相当于http://host:port/{index}/{type}/_search后查询表达式{"query":{"bool":{"must":[{"match":{"name":{name}}},{"term":{"mobile":{mobile}}}]}}}
     * @param name:员工名称
     * @param mobile:联系方式
     * @return 符合检索条件员工文档信息
     */
    public List<Employee> findEmployeeByNameLikeAndMobileIs(String name, String mobile);
}
