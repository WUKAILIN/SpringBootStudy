package com.springboot.demo.jpa.service.impl;

import com.springboot.demo.jpa.dao.JpaUserInfoRespository;
import com.springboot.demo.jpa.pojo.UserInfo;
import com.springboot.demo.jpa.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserInfoServiceImpl implements UserInfoService {
    @Autowired
    private JpaUserInfoRespository jpaUserInfoRespository;

    /**
     * 根据用户名模糊查询用户集合信息
     * @param userName:用户名
     * @return 用户集合
     */
    @Override
    public List<UserInfo> findByUserName(String userName) {
        return jpaUserInfoRespository.findByUserName(userName);
    }

    /**
     * 根据登录账户模糊查询用户集合信息
     * @param loginAccount:登录账户
     * @return 用户集合
     */
    @Override
    public List<UserInfo> findByLoginAccount(String loginAccount) {
        return jpaUserInfoRespository.findByLoginAccount(loginAccount);
    }

    /**
     * 根据用户标识查询用户明细
     * @param userId:用户标识
     * @return 用户明细
     */
    @Override
    public UserInfo findByUserId(int userId) {
        return jpaUserInfoRespository.findByUserId(userId);
    }

    /**
     * 保存用户信息
     * @param userInfo
     * @return 被保存用户信息
     */
    @Override
    public UserInfo save(UserInfo userInfo) {
        return jpaUserInfoRespository.save(userInfo);
    }

    /**
     * 更新用户信息
     * @param userInfo
     * @return 被更新用户信息
     */
    @Override
    public UserInfo updateUserInfo(UserInfo userInfo) {
        return jpaUserInfoRespository.saveAndFlush(userInfo);
    }


}
