/**
 * 领养人实体类，用于表示系统中的注册领养人
 * 
 * @author [您的名字]
 * @version 1.0
 */
package com.petadoption.entities;

import lombok.Getter;
import lombok.Setter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Date;
import java.util.Scanner;

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
//@Data，不使用@Data注解，因为有些getter和setter方法要重写
public class Adopter {
    /** 
     * 领养人唯一标识符
     * 数据库字段：id，主键，自增
     */
    @Getter
    @Setter
    private int id;
    
    /** 
     * 领养人姓名
     * 数据库字段：name，varchar(50)，必填
     */
    @Getter
    @Setter
    private String name;
    
    /** 
     * 联系电话
     * 数据库字段：phone，varchar(20)，必填
     */
    @Getter
    @Setter
    private String phone;
    
    /** 
     * 居住地址
     * 数据库字段：address，varchar(100)，必填
     */
    @Getter
    private String address;
    
    /** 
     * 密码（用于登录验证）
     * 数据库字段：hashedPassword，char(60)必填
     * 这里做了一个修改，因为加密算法默认产生60字符，所以说改成了char(60)，使得数据库效率提高了一些
     * 注意：密码应加密存储
     */
    private String hashedPassword;//被加密过的密码，本质存的是哈希值
    //安全密码的加密器（为Password加密的工具）
    private  static final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    /** 
     * 注册时间
     * 数据库字段：registration_date，datetime，自动设置
     */
    @Getter
    @Setter
    private Date registrationDate;
    
    /**
     * 验证密码是否正确
     * 
     * @param inputPassword 输入的密码
     * @return true if password matches, false otherwise
     */
    public boolean verifyPassword(String inputPassword) {
        // 使用 BCrypt 进行验证
        return passwordEncoder.matches(inputPassword, this.hashedPassword);
    }

    /**
     * 设置密码
     * 
     * @param plainPassword 新密码
     *
     */
    public boolean setPassword(String plainPassword) {
        /**
         * 加一个验证，设置密码前必须先检验一次原密码，成功才可以进行，否则直接失败
         */
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入原密码：");
        String originalPassword = scanner.nextLine();
        if (!verifyPassword(originalPassword)){
            System.out.println("原密码错误");
            return false;
        }
        //正常长度验证
        if(plainPassword.length() > 6){
            try {
                throw new IllegalArgumentException("密码长度不能超过6位");
            } catch (IllegalArgumentException e) {
                System.out.println("请重新设置密码并重新校验");
                plainPassword = scanner.nextLine();
                setPassword(plainPassword);
            }
        }else{
            this.hashedPassword = passwordEncoder.encode(plainPassword);
        }
        return true;
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
     * 获取注册时间
     * 
     * @return 注册时间
     */
    //Lombok自动生成
    /*public Date getRegistrationDate() {
        return registrationDate;
    }*/

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
