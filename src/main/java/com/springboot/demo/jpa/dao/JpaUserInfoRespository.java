package com.springboot.demo.jpa.dao;

import com.springboot.demo.jpa.pojo.UserInfo;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface JpaUserInfoRespository extends JpaRepository<UserInfo,Integer> {
    /**
     * 根据用户名模糊查询
     * @param userName:用户名
     * @return 用户信息集合
     */
    public List<UserInfo> findByUserName(String userName);
    /**
     * 根据登录账户名模糊查询
     * @param loginAccount:登录账户
     * @return 用户集合信息
     */
    public List<UserInfo> findByLoginAccount(String loginAccount);

    /**
     * 根据用户标识查询用户信息
     * @param userId:用户标识
     * @return 用户明细信息
     */
    public UserInfo findByUserId(int userId);

    /**
     * 保存用户信息
     * @param userInfo
     * @return 被保存用户
     */
    public UserInfo save(UserInfo userInfo);


}
