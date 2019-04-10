package com.springboot.demo.mybatis.typehandler;

import com.springboot.demo.jdbcTemplate.pojo.SexEnum;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@MappedJdbcTypes(JdbcType.INTEGER)
@MappedTypes(value = SexEnum.class)
public class SexTypeHandler extends BaseTypeHandler<SexEnum>{
    /**
     * 设置非空性别参数
     * @param preparedStatement：预编译语句
     * @param i:索引
     * @param sexEnum:性别枚举
     * @param jdbcType:jdbc数据类型
     * @throws SQLException
     */
    @Override
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, SexEnum sexEnum, JdbcType jdbcType) throws SQLException {
        preparedStatement.setInt(i,sexEnum.getId());
    }

    /**
     * 通过列名读取性别
     * @param resultSet:结果集
     * @param s:列名
     * @return 性别枚举
     * @throws SQLException
     */
    @Override
    public SexEnum getNullableResult(ResultSet resultSet, String s) throws SQLException {
        int sex=resultSet.getInt(s);
        if(sex!=1 && sex!=2)
        {
            return null;
        }
        return SexEnum.getSexById(sex);
    }

    /**
     * 通过下标读取性别
     * @param resultSet:结果集
     * @param i:下标
     * @return 性别枚举
     * @throws SQLException
     */
    @Override
    public SexEnum getNullableResult(ResultSet resultSet, int i) throws SQLException {
        int sex=resultSet.getInt(i);
        if(sex!=1 && sex!=2)
        {
            return null;
        }
        return SexEnum.getSexById(sex);
    }

    /**
     *
     * @param callableStatement：存储过程
     * @param i:下标
     * @return 性别枚举
     * @throws SQLException
     */
    @Override
    public SexEnum getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
        int sex=callableStatement.getInt(i);
        if(sex!=1 && sex!=2)
        {
            return null;
        }
        return SexEnum.getSexById(sex);
    }
}
