package com.springboot.demo.elasticsearch.jpa.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.io.Serializable;
import java.util.Date;

@Document(indexName = "linkman",type = "info")
public class Employee implements Serializable {
    @Id
    private String id;
    private String name;
    private Long age;
    private Date birthday;
    private String mobile;
    private String sex;
   private String address;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getAge() {
        return age;
    }

    public void setAge(Long age) {
        this.age = age;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Employee(String id, String name, Long age, Date birthday, String mobile, String sex, String address) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.birthday = birthday;
        this.mobile = mobile;
        this.sex = sex;
        this.address = address;
    }

    public Employee() {
    }
}
