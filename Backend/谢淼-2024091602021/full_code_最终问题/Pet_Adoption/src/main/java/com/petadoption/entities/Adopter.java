/**
 * 领养人实体类，用于表示系统中的注册领养人
 * 
 * @author [您的名字]
 * @version 1.0
 */
package com.petadoption.entities;

import lombok.Data;

import java.util.Date;

/**
 * 领养人实体类，包含领养人的基本信息和认证状态
 * 
 * 实现思路：
 * 1. 使用Lombok的@Data注解自动生成getter/setter/toString等方法
 * 2. 实体类属性对应数据库表字段
 * 3. 添加必要的业务方法，如密码验证、状态检查等
 * 4. 使用注释详细说明每个属性和方法的用途
 * 
 * 数据库映射：
 * - id: 主键，自增
 * - name: 领养人姓名，必填
 * - phone: 联系电话，必填
 * - address: 居住地址，必填
 * - registrationDate: 注册时间，自动设置
 * - password: 密码，用于登录验证
 */
@Data
public class Adopter {
    /** 
     * 领养人唯一标识符
     * 数据库字段：id，主键，自增
     */
    private int id;
    
    /** 
     * 领养人姓名
     * 数据库字段：name，varchar(50)，必填
     */
    private String name;
    
    /** 
     * 联系电话
     * 数据库字段：phone，varchar(20)，必填
     */
    private String phone;
    
    /** 
     * 居住地址
     * 数据库字段：address，varchar(100)，必填
     * -- GETTER --
     *  获取居住地址
     *
     * @return 居住地址

     */
    private String address;
    
    /** 
     * 密码（用于登录验证）
     * 数据库字段：password，varchar(50)，必填
     * 注意：密码应加密存储
     */
    private String password;
    
    /** 
     * 注册时间
     * 数据库字段：registration_date，datetime，自动设置
     * -- GETTER --
     *  获取注册时间
     *
     * @return 注册时间
     */
    private Date registrationDate;

    public Adopter(){}
    public Adopter(String name, String phone, String address) {
        this.name = name;
        this.phone = phone;
        this.address = address;
    }
    /**
     * 验证密码是否正确
     * 
     * @param inputPassword 输入的密码
     * @return true if password matches, false otherwise
     */
    public boolean verifyPassword(String inputPassword) {
        // TODO: 实现密码验证逻辑
        // 建议使用密码加密算法进行验证
        return password.equals(inputPassword);
    }

    /**
     * 设置密码
     * 
     * @param password 新密码
     * @throws IllegalArgumentException 如果密码格式不正确
     */
    public void setPassword(String password) {
        // TODO: 实现密码格式验证和加密
        if (password == null || password.length() < 6) {
            throw new IllegalArgumentException("密码长度必须大于6位");
        }
        this.password = password;
    }

    /**
     * 设置居住地址
     * 
     * @param address 新地址
     * @throws IllegalArgumentException 如果地址格式不正确
     */
    public void setAddress(String address) {
        if (address == null || address.trim().isEmpty()) {
            throw new IllegalArgumentException("地址不能为空");
        }
        this.address = address;
    }

    /**
     * 获取领养人对象的字符串表示
     * 
     * @return 领养人信息字符串
     */
    @Override
    public String toString() {
        return "Adopter{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
