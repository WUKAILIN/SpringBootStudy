package com.springboot.demo;

import com.springboot.demo.jdbcTemplate.pojo.SexEnum;
import com.springboot.demo.mybatis.pojo.UserInfo;
import com.springboot.demo.mybatis.service.MyBatisUserInfoService;
import com.springboot.demo.mybatis.transactional.MybatisTransactionalUserInfoService;
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
public class MybatisTransactionTest {
    @Autowired
    private MybatisTransactionalUserInfoService mybatisTransactionalUserInfoServiceImpl;
    @Test
    public void testFindUserByUserName()
    {
        List<UserInfo> userInfos=mybatisTransactionalUserInfoServiceImpl.findUserInfoByUserName("s");
        System.out.println("用户数量-----"+userInfos.size());
        for(UserInfo userInfo:userInfos)
        {
            System.out.println("用户名分别为--------"+userInfo.getUserName());
        }
    }
    @Test
    public void testFindUserByLoginAccount()
    {
        List<UserInfo> userInfos=mybatisTransactionalUserInfoServiceImpl.findUserInfoByLoginAccount("gas");
        System.out.println("用户数量-----"+userInfos.size());
        for(UserInfo userInfo:userInfos)
        {
            System.out.println("用户名分别为--------"+userInfo.getUserName());
        }
    }
    @Test
    public void testFindUserByUserId()
    {
        UserInfo userInfo=mybatisTransactionalUserInfoServiceImpl.findUserInfoByUserId(1);
        System.out.println("用户名为--------"+userInfo.getUserName());
    }
    @Test
    public void testSaveUser()
    {
        UserInfo userInfo=new UserInfo();
        userInfo.setUserName("testMybatis");
        userInfo.setLoginAccount("testMybatis");
        userInfo.setCreateDate(DatetimeUtils.dateFormatStr(new Date()));
        userInfo.setUpdateDate(DatetimeUtils.dateFormatStr(new Date()));
        userInfo.setUserAge(36);
        userInfo.setUserState("1");
        userInfo.setPassWord("123456");
        userInfo.setSexEnum(SexEnum.MALE);
        mybatisTransactionalUserInfoServiceImpl.saveUserInfo(userInfo);
    }
    @Test
    public void testUpdateUserState()
    {
        UserInfo userInfo=mybatisTransactionalUserInfoServiceImpl.findUserInfoByUserId(7);
        userInfo.setUserState("1");
        userInfo.setUpdateDate(DatetimeUtils.dateFormatStr(new Date()));
        mybatisTransactionalUserInfoServiceImpl.updateUserState(userInfo);
        System.out.println("更新后的状态为------"+userInfo.getUserState()+",更新日期---------"+userInfo.getUpdateDate());
    }
}
