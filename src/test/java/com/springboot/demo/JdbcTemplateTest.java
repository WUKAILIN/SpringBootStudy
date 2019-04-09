package com.springboot.demo;

import com.springboot.demo.jdbcTemplate.pojo.SexEnum;
import com.springboot.demo.jdbcTemplate.pojo.UserInfo;
import com.springboot.demo.jdbcTemplate.service.JdbcTmplUserService;
import com.springboot.demo.utils.DatetimeUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class JdbcTemplateTest {
    @Autowired
    private JdbcTmplUserService jdbcTmplUserServiceImpl;
    @Test
    public void testInsertUser()
    {
        UserInfo userInfo=new UserInfo();
        userInfo.setUserName("Fabregas");
        userInfo.setLoginAccount("Fabregas");
        userInfo.setUserAge(31);
        userInfo.setPassWord("880118");
        userInfo.setSexEnum(SexEnum.MALE);
        userInfo.setUserState("1");
        userInfo.setCreateDate(DatetimeUtils.dateFormatStr(new Date()));
        userInfo.setUpdateDate(DatetimeUtils.dateFormatStr(new Date()));
        int count=jdbcTmplUserServiceImpl.insertUser(userInfo);
        System.out.println("受影响行数----------"+count+",登录账号为-------"+userInfo.getLoginAccount());
    }
    @Test
    public void testUpdateUser()
    {
        UserInfo userInfo=jdbcTmplUserServiceImpl.getUserById(1);
        userInfo.setSexEnum(SexEnum.FEMALE);
        userInfo.setUpdateDate(DatetimeUtils.dateFormatStr(new Date()));
        int count=jdbcTmplUserServiceImpl.updateUser(userInfo);
        System.out.println("受影响行数----------"+count+",更新用户为-------"+userInfo.getLoginAccount()+",更新性别为--------"+userInfo.getSexEnum().getSexName());
    }
    @Test
    public void testUpdateState()
    {
        UserInfo userInfo=jdbcTmplUserServiceImpl.getUserById(1);
        userInfo.setUserState("0");
        userInfo.setUpdateDate(DatetimeUtils.dateFormatStr(new Date()));
        int count=jdbcTmplUserServiceImpl.deleteUser(userInfo.getUserState(),userInfo.getUserId());
        System.out.println("受影响行数----------"+count+",更新用户为-------"+userInfo.getLoginAccount()+",更新状态为--------"+userInfo.getUserState());
    }
    @Test
    public void testQueryByLoginAccount()
    {
        List<UserInfo> userInfos=jdbcTmplUserServiceImpl.findUsersByLoginAccount("e");
        System.out.println("查询出的用户数为-------"+userInfos.size()+",登录账号分别为:");
        for(UserInfo userInfo:userInfos)
        {
            System.out.println(userInfo.getLoginAccount()+";");
        }
    }
    @Test
    public void testQueryByUserName()
    {
        List<UserInfo> userInfos=jdbcTmplUserServiceImpl.findUserByUserName("s");
        System.out.println("查询出的用户数为-------"+userInfos.size()+",用户名分别为:");
        for(UserInfo userInfo:userInfos)
        {
            System.out.println(userInfo.getUserName()+";");
        }
    }
}
