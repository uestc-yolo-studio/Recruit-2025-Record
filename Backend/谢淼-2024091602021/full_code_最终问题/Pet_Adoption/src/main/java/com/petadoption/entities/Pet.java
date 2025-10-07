/**
 * 宠物实体类，用于表示系统中的可领养宠物
 * 
 * @author [您的名字]
 * @version 1.0
 */
package com.petadoption.entities;

import lombok.Data;

import java.util.Date;

/**
 * 宠物实体类，包含宠物的基本信息和领养状态
 * 
 * 实现思路：
 * 1. 使用Lombok的@Data注解自动生成getter/setter/toString等方法
 * 2. 实体类属性对应数据库表字段
 * 3. 添加必要的业务方法
 * 4. 使用注释详细说明每个属性和方法的用途
 * 
 * 数据库映射：
 * - id: 主键，自增
 * - name: 宠物名字，必填
 * - species: 宠物种类，必填
 * - age: 宠物年龄，必填
 * - adoptStatus: 领养状态，默认为false
 * - addedDate: 添加时间，自动设置
 */
@Data
public class Pet {
    /** 
     * 宠物唯一标识符
     * 数据库字段：id，主键，自增
     */
    private int id;
    
    /** 
     * 宠物名字
     * 数据库字段：name，varchar(50)，必填
     */
    private String name;
    
    /** 
     * 宠物种类（如狗、猫）
     * 数据库字段：species，varchar(50)，必填
     */
    private String species;
    
    /** 
     * 宠物年龄（以年为单位）
     * 数据库字段：age，int，必填
     */
    private int age;
    
    /** 
     * 领养状态
     * - true: 已被领养
     * - false: 可供领养
     * 数据库字段：adopt_status，boolean，默认false
     * -- SETTER --
     *  设置领养状态
     *
     *
     */
    private boolean adopt_status;
    
    /** 
     * 宠物添加到系统的时间
     * 数据库字段：added_date，datetime，自动设置
     */
    private Date added_Date;
    public Pet(){}
    public Pet( String name, String species, int age) {
        this.name = name;
        this.species = species;
        this.age = age;
    }
    /**
     * 设置宠物年龄
     * 
     * @param age 宠物年龄
     * @throws IllegalArgumentException 如果年龄小于0
     */
    public void setAge(int age) {
        if (age < 0) {
        throw new IllegalArgumentException("年龄不能小于0");
        }
        this.age = age;
    }
    /**
     * 获取领养状态
     * 
     * @return true if pet has been adopted, false otherwise
     */
    public boolean getAdopt_status() {
        return adopt_status;
    }

    /**
     * 获取添加时间
     * 
     * @return 添加时间
     */
    public Date getAdded_date() {
        return added_Date;
    }
    
    /**
     * 获取宠物对象的字符串表示
     * 
     * @return 宠物信息字符串
     */
    @Override
    public String toString() {
        return "Pet{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", species='" + species + '\'' +
                ", age=" + age +
                ", adoptStatus=" + adopt_status +
                ", addedDate=" + added_Date +
                '}';
    }
}
