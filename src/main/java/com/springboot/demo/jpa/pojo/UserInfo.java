package com.springboot.demo.jpa.pojo;

import com.springboot.demo.jdbcTemplate.pojo.SexEnum;
import com.springboot.demo.jpa.convert.SexEnumConvert;

import javax.persistence.*;

@Entity(name = "userInfo")
@Table(name = "t_user")
public class UserInfo {
    /**
     * 标识主键
     * GeneratedValue用于标识主键生成策略：此处为自增
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;
    @Column(name = "user_name")
    private String userName;
    @Column(name="login_account")
    private String loginAccount;
    @Column(name="pass_word")
    private String  passWord;
    @Column(name="user_age")
    private int userAge;
    @Column(name="create_date")
    private String createDate;
    @Column(name="update_date")
    private String updateDate;
    @Column(name="user_state")
    private String userState;
    /**
     *定义枚举类型转换器，用于在数据库类型和枚举类型间进行数据转换
     */
    @Convert(converter = SexEnumConvert.class)
    private SexEnum userSex;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getLoginAccount() {
        return loginAccount;
    }

    public void setLoginAccount(String loginAccount) {
        this.loginAccount = loginAccount;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public int getUserAge() {
        return userAge;
    }

    public void setUserAge(int userAge) {
        this.userAge = userAge;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(String updateDate) {
        this.updateDate = updateDate;
    }

    public String getUserState() {
        return userState;
    }

    public void setUserState(String userState) {
        this.userState = userState;
    }

    public SexEnum getUserSex() {
        return userSex;
    }

    public void setUserSex(SexEnum userSex) {
        this.userSex = userSex;
    }
}
