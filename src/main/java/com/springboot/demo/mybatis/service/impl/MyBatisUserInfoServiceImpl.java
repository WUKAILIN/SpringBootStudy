package com.springboot.demo.mybatis.service.impl;

import com.springboot.demo.mybatis.dao.MyBatisUserInfoDao;
import com.springboot.demo.mybatis.pojo.UserInfo;
import com.springboot.demo.mybatis.service.MyBatisUserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MyBatisUserInfoServiceImpl implements MyBatisUserInfoService {
    @Autowired
    private MyBatisUserInfoDao userInfoDao;



    @Override
    public List<UserInfo> findUserInfoByUserName(String userName) {
        return userInfoDao.findUserInfoByUserName(userName);
    }

    @Override
    public List<UserInfo> findUserInfoByLoginAccount(String loginAccount) {

        return userInfoDao.findUserInfoByLoginAccount(loginAccount);
    }

    @Override
    public UserInfo findUserInfoByUserId(int userId) {
        return userInfoDao.findUserInfoByUserId(userId);
    }

    @Override
    public void saveUserInfo(UserInfo userInfo) {
        userInfoDao.saveUserInfo(userInfo);
    }

    @Override
    public void updateUserInfo(UserInfo userInfo) {
        userInfoDao.updateUserInfo(userInfo);
    }

    @Override
    public void updateUserState(UserInfo userInfo) {
        userInfoDao.updateUserState(userInfo);
    }
}
