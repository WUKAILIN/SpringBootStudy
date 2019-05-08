package com.springboot.demo.mybatis.transactional;

import com.springboot.demo.mybatis.pojo.UserInfo;

import java.util.List;

public interface MybatisTransactionalUserInfoService {
    /**
     *根据用户名称查询用户集合信息
     * @param userName:用户名
     * @return用户集合信息
     */
    public List<UserInfo> findUserInfoByUserName(String userName);

    /**
     * 根据登录账户查询用户集合信息
     * @param loginAccount：登录账户
     * @return用户集合信息
     */
    public List<UserInfo> findUserInfoByLoginAccount(String loginAccount);

    /**
     * 根据用户标识查询用户详情信息
     * @param userId:用户标识
     * @return 用户详情
     */
    public UserInfo findUserInfoByUserId(int userId);
    /**
     * 保存用户信息
     * @param userInfo：用户信息
     */
    public void saveUserInfo(UserInfo userInfo);

    /**
     * 更新用户信息
     * @param userInfo:用户信息
     */
    public void updateUserInfo(UserInfo userInfo);
    /**
     * 更新用户状态
     * @param userInfo：更新状态用户
     */
    public void updateUserState(UserInfo userInfo);
}
