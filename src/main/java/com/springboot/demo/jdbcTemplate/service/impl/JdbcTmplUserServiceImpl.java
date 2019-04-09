package com.springboot.demo.jdbcTemplate.service.impl;

import com.springboot.demo.jdbcTemplate.pojo.SexEnum;
import com.springboot.demo.jdbcTemplate.service.JdbcTmplUserService;
import com.springboot.demo.jdbcTemplate.pojo.UserInfo;
import com.springboot.demo.utils.DatetimeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.util.List;
@Service
public class JdbcTmplUserServiceImpl implements JdbcTmplUserService {
    @Autowired
    private JdbcTemplate jdbcTemplate;//自动装配jdbcTemplate

    /**
     * 实现数据库实体映射接口
     * @return
     */
    // 获取映射关系
    private RowMapper<UserInfo> getUserMapper() {
        // 使用Lambda表达式创建用户映射关系
        RowMapper<UserInfo> userRowMapper = (ResultSet rs, int rownum) -> {
            UserInfo user = new UserInfo();
            user.setUserId(rs.getLong("user_id"));
            user.setUserName(rs.getString("user_name"));
            user.setLoginAccount(rs.getString("login_account"));
            user.setUserAge(rs.getInt("user_age"));
            user.setUserState(rs.getString("user_state"));
            user.setPassWord(rs.getString("pass_word"));
            user.setCreateDate(DatetimeUtils.dateFormatStr(rs.getDate("create_date")));
            user.setUpdateDate(DatetimeUtils.dateFormatStr(rs.getDate("update_date")));
            int sexId = rs.getInt("user_sex");
            SexEnum sex =SexEnum.getSexById(sexId);
            user.setSexEnum(sex);
           // user.setNote(rs.getString("note"));
            return user;
        };
        return userRowMapper;
    }

    /**
     * 根据用户标识查询用户信息
     * @param userId:用户标识
     * @return 用户信息
     */
    @Override
    public UserInfo getUserById(int userId) {
        //需要执行的查询SQL
        String querySql="select user_id,user_name,login_account,pass_word,user_age,user_sex," +
                "create_date,update_date,user_state from t_user where user_id=?";
        //查询参数数组
        Object[] params=new Object[]{userId};
        /**
         * 返回查询结果映射对象
         */
        return jdbcTemplate.queryForObject(querySql,params,getUserMapper());
    }

    /**
     * 根据登录账号模糊查询用户信息集合
     * @param loginAccount：登录账号
     * @return 用户信息集合
     */
    @Override
    public List<UserInfo> findUsersByLoginAccount(String loginAccount) {
        String querySql="select user_id,user_name,login_account,pass_word,user_age,user_sex," +
                "create_date,update_date,user_state from t_user where login_account like concat('%',?,'%')";
        Object[] params=new Object[]{loginAccount};
        return jdbcTemplate.query(querySql,params,getUserMapper());
    }

    /**
     * 根据用户名称查询用户信息集合
     * @param userName:用户名
     * @return用户信息集合
     */
    @Override
    public List<UserInfo> findUserByUserName(String userName) {
        String querySql="select user_id,user_name,login_account,pass_word,user_age,user_sex," +
                "create_date,update_date,user_state from t_user where user_name like concat('%',?,'%')";
        Object[] params=new Object[]{userName};
        return jdbcTemplate.query(querySql,params,getUserMapper());
    }

    /**
     * 保存用户信息
     * @param userInfo：需保存用户信息
     * @return 受影响行数
     */
    @Override
    public int insertUser(UserInfo userInfo) {
        String insertSql="insert into t_user (user_name,login_account,pass_word," +
                "user_age,user_sex,create_date,update_date,user_state)" +
                " values(?,?,?,?,?,?,?,?)";
        Object[] params=new Object[]{userInfo.getUserName(),userInfo.getLoginAccount(),userInfo.getPassWord()
                ,userInfo.getUserAge(),userInfo.getSexEnum().getId(),userInfo.getCreateDate(),userInfo.getUpdateDate(),
                userInfo.getUserState()};
        return jdbcTemplate.update(insertSql,params);
    }

    /**
     * 更新用户信息
     * @param userInfo：需更新用户信息
     * @return 受影响行数
     */
    @Override
    public int updateUser(UserInfo userInfo) {
        String updateSql="update t_user set user_name=?,login_account=?,user_age=?,user_sex=? " +
                "where user_id=?";
        Object[] params=new Object[]{userInfo.getUserName(),userInfo.getLoginAccount(),userInfo.getUserAge(),
                userInfo.getSexEnum().getId(),userInfo.getUserId()};
        return jdbcTemplate.update(updateSql,params);
    }

    /**
     * 更新用户状态信息
     * @param userState:用户状态
     * @param userId:删除用户标识
     * @return 受影响行数
     */
    @Override
    public int deleteUser(String userState,long userId) {
        String updateSql="update t_user set user_state=? where user_id=?";
        Object[] params=new Object[]{userState,userId};
        return jdbcTemplate.update(updateSql,params);
    }
}
