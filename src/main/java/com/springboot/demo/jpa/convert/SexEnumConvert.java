package com.springboot.demo.jpa.convert;

import com.springboot.demo.jdbcTemplate.pojo.SexEnum;

import javax.persistence.AttributeConverter;

/**
 * 枚举转换器，用于在数据库数据类型和枚举类型间进行数据转换
 */
public class SexEnumConvert implements AttributeConverter<SexEnum,Integer> {
    /**
     * 枚举类型转数据库类型
     * @param sexEnum：枚举类型
     * @return 枚举标识(数据库存储)
     */
    @Override
    public Integer convertToDatabaseColumn(SexEnum sexEnum) {
        return sexEnum.getId();
    }

    /**
     * 数据库类型转枚举类型
     * @param id:数据库存储枚举标识
     * @return 枚举类型
     */
    @Override
    public SexEnum convertToEntityAttribute(Integer id) {
        return SexEnum.getSexById(id);
    }
}
