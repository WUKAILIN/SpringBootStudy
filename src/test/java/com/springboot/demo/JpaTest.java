package com.springboot.demo;

import com.springboot.demo.jdbcTemplate.pojo.SexEnum;
import com.springboot.demo.jpa.pojo.UserInfo;
import com.springboot.demo.jpa.service.UserInfoService;
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
public class JpaTest {
    @Autowired
    private UserInfoService userInfoServiceImpl;
    @Test
    public void testSaveUserInfo()
    {
        UserInfo userInfo=new UserInfo();
        userInfo.setUserName("FabregasByJPA");
        userInfo.setLoginAccount("FabregasByJpa");
        userInfo.setUserAge(31);
        userInfo.setPassWord("880118");
        userInfo.setUserSex(SexEnum.MALE);
        userInfo.setUserState("1");
        userInfo.setCreateDate(DatetimeUtils.dateFormatStr(new Date()));
        userInfo.setUpdateDate(DatetimeUtils.dateFormatStr(new Date()));
        //int count=jdbcTmplUserServiceImpl.insertUser(userInfo);
        System.out.println("登录账号为-------"+userInfo.getLoginAccount());
        UserInfo user=userInfoServiceImpl.save(userInfo);
    }
    @Test
    public void testFindByUserNameLike()
    {
        List<UserInfo> userInfos=userInfoServiceImpl.findByUserName("Fa");
        System.out.println("用户数为---------"+userInfos.size());
        for(UserInfo userInfo:userInfos)
        {
            System.out.println("用户名分别为-----"+userInfo.getUserName()+";");
        }
    }
    @Test
    public void testFindByUserId()
    {
        UserInfo userInfo=userInfoServiceImpl.findByUserId(5);
        System.out.println("用户名为-----"+userInfo.getUserName()+",用户性别为------"+userInfo.getUserSex().getSexName());
    }
    @Test
    public void testUpdate()
    {
        UserInfo userInfo=userInfoServiceImpl.findByUserId(5);
        userInfo.setUserState("0");
        UserInfo updateUser=userInfoServiceImpl.updateUserInfo(userInfo);
        System.out.println("被更新用户名-------"+updateUser.getUserName()+",更新状态为-------:"+updateUser.getUserState());
    }
}
