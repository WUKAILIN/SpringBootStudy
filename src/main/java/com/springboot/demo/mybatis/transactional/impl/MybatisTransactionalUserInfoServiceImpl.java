package com.springboot.demo.mybatis.transactional.impl;

import com.springboot.demo.mybatis.dao.MyBatisUserInfoDao;
import com.springboot.demo.mybatis.pojo.UserInfo;
import com.springboot.demo.mybatis.transactional.MybatisTransactionalUserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class MybatisTransactionalUserInfoServiceImpl implements MybatisTransactionalUserInfoService {
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
    @Transactional(isolation = Isolation.SERIALIZABLE)
    @Override
    public void saveUserInfo(UserInfo userInfo) {
        userInfoDao.saveUserInfo(userInfo);
    }
    @Transactional(isolation = Isolation.SERIALIZABLE)
    @Override
    public void updateUserInfo(UserInfo userInfo) {
        userInfoDao.updateUserInfo(userInfo);
    }
    @Transactional(isolation = Isolation.SERIALIZABLE)
    @Override
    public void updateUserState(UserInfo userInfo) {
        userInfoDao.updateUserState(userInfo);
    }

}
