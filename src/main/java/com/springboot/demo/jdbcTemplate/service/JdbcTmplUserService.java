package com.springboot.demo.jdbcTemplate.service;

import com.springboot.demo.jdbcTemplate.pojo.UserInfo;

import java.util.List;

public interface JdbcTmplUserService {
    /**
     * 根据用户标识查询用户信息
     * @param userId:用户标识
     * @return用户信息
     */
    public UserInfo getUserById(int userId);

    /**
     * 根据登录账号查询用户集合信息
     * @param loginAccount：登录账号
     * @return 用户集合信息
     */
    public List<UserInfo> findUsersByLoginAccount(String loginAccount);

    /**
     * 根据用户名称查询用户集合信息
     * @param userName:用户名
     * @return 用户集合信息
     */
    public List<UserInfo> findUserByUserName(String userName);

    /**
     * 保存用户信息
     * @param userInfo：需保存用户信息
     * @return 受影响行数
     */
    public int insertUser(UserInfo userInfo);

    /**
     * 更新用户信息
     * @param userInfo：需更新用户信息
     * @return 受影响行数
     */
    public int updateUser(UserInfo userInfo);

    /**
     * 更新用户状态信息
     * @param userState:用户状态
     * @param userId:删除用户标识
     * @return 受影响行数
     */
    public int deleteUser(String userState,long userId);
}
