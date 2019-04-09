package com.springboot.demo.jdbcTemplate.pojo;

public enum SexEnum {
    MALE(1,"男"),
    FEMALE(2,"女");

   private int id;//性别标识
   private String sexName;//性别名称

    SexEnum(int id, String sexName) {
        this.id = id;
        this.sexName = sexName;
    }

    /**
     * 根据标识获取对应性别
     * @param id:性别标识
     * @return 性别
     */
    public static SexEnum getSexById(int id)
    {
        for(SexEnum sex:SexEnum.values())
        {
            if(sex.getId()==id)
            {
                return sex;
            }
        }
        return null;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSexName() {
        return sexName;
    }

    public void setSexName(String sexName) {
        this.sexName = sexName;
    }
}
