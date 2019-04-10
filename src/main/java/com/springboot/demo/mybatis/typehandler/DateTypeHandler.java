package com.springboot.demo.mybatis.typehandler;

import com.springboot.demo.utils.DatetimeUtils;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class DateTypeHandler extends BaseTypeHandler<Date> {
    /**
     * 设置参数
     * @param preparedStatement：预编译语句
     * @param i：下标
     * @param date：日期类型
     * @param jdbcType：jdbc类型
     * @throws SQLException
     */
    @Override
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, Date date, JdbcType jdbcType) throws SQLException {
        String dateStr= DatetimeUtils.dateFormatStr(date);
        preparedStatement.setString(i,dateStr);
    }

    /**
     * 从结果集中根据列名取出日期
     * @param resultSet:结果集
     * @param s:列名
     * @return 日期
     * @throws SQLException
     */
    @Override
    public Date getNullableResult(ResultSet resultSet, String s) throws SQLException {
        return resultSet.getDate(s);
    }

    /**
     * 从结果集中根据索引取出日期
     * @param resultSet:结果集
     * @param i:索引
     * @return 日期
     * @throws SQLException
     */
    @Override
    public Date getNullableResult(ResultSet resultSet, int i) throws SQLException {
        return resultSet.getDate(i);
    }

    @Override
    public Date getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
        return null;
    }
}
