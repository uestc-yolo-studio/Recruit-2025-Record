/**
 * 领养记录实体类，用于记录宠物领养过程的详细信息
 * 
 * @author [您的名字]
 * @version 1.0
 */
package com.petadoption.entities;

import lombok.Data;

import java.util.Date;

/**
 * 领养记录实体类，记录宠物领养的完整过程
 * 
 * 实现思路：
 * 1. 使用Lombok的@Data注解自动生成getter/setter/toString等方法
 * 2. 实体类属性对应数据库表字段
 * 3. 添加状态管理方法
 * 4. 使用注释详细说明每个属性和方法的用途
 * 
 * 数据库映射：
 * - id: 主键，自增
 * - pet_id: 外键，关联pet表
 * - adopter_id: 外键，关联adopter表
 * - adoption_date: 领养日期，自动设置
 * - status: 领养状态（申请中、已批准、已完成等）
 */
@Data
public class AdoptionRecord {
    /** 
     * 领养记录唯一标识符
     * 数据库字段：id，主键，自增
     */
    private int id;
    
    /** 
     * 被领养的宠物
     * 数据库字段：pet_id，外键，关联pet表
     */
    private Pet pet;
    
    /** 
     * 领养人
     * 数据库字段：adopter_id，外键，关联adopter表
     */
    private Adopter adopter;
    
    /** 
     * 领养日期
     * 数据库字段：adoption_date，datetime，自动设置
     */
    private Date adoptionDate;
    
    /** 
     * 领养状态枚举
     * - APPLYING: 申请中
     * - APPROVED: 已批准
     * - COMPLETED: 已完成
     * - CANCELLED: 已取消
     */
    public enum Status {
        APPLYING("申请中"),
        APPROVED("已批准"),
        COMPLETED("已完成"),
        CANCELLED("已取消");
        
        private final String description;
        
        Status(String description) {
            this.description = description;
        }
        
        public String getDescription() {
            return description;
        }
    }
    
    /** 
     * 当前领养状态
     * 数据库字段：status，varchar(20)
     */
    private Status status;
    
    /**
     * 设置领养人
     * 
     * @param adopter 领养人对象
     * @throws IllegalArgumentException 如果领养人为空
     */
    public void setAdopter(Adopter adopter) {
        if (adopter == null) {
            throw new IllegalArgumentException("领养人不能为空");
        }
        this.adopter = adopter;
    }

    /**
     * 获取领养日期
     * 
     * @return 领养日期
     */
    public Date getAdoptionDate() {
        return adoptionDate;
    }

    /**
     * 设置领养状态
     * 
     * @param status 新状态
     * @throws IllegalArgumentException 如果状态转换非法
     */
    public void setStatus(Status status) {
        if (status == null) {
            throw new IllegalArgumentException("状态不能为空");
        }
        // TODO: 实现状态转换验证逻辑
        // 申请中可以转换成：已批准、已取消
        // 已批准可以转换成：已完成、已取消
        // 已完成不可以再转换
        // 已取消不可以再转换

        // 首次设置状态（当前状态为null时）
        if (this.status == null) {
            this.status = status;
            return;
        }
        // 状态相同，不需要处理
        if(this.status == status){
            return;
        }
        // 判断其他类型
        switch (this.status){
            case APPLYING:// 申请中可以转换成：已批准、已取消
                if(status == Status.APPROVED || status == Status.CANCELLED){
                    this.status = status;
                    return;
                }
                break;
            case APPROVED:// 已批准可以转换成：已完成、已取消
                if(status == Status.COMPLETED || status == Status.CANCELLED){
                    this.status = status;
                    return;
                }
                break;
            case COMPLETED:// 已完成不可以再转换
            case CANCELLED:// 已取消不可以再转换
            default:
                break;//继续往下走
        }
        //此处处理所有非法的转换
        throw new IllegalArgumentException(String.format("不允许从状态[%s]转换到[%s]",
                this.status.getDescription(),
                status.getDescription()));
    }

    /**
     * 获取当前状态的描述
     * 
     * @return 状态描述
     */
    public String getStatusDescription() {
        return status.getDescription();
    }

    /**
     * 获取领养记录的字符串表示
     * 
     * @return 领养记录信息字符串
     */
    @Override
    public String toString() {
        return "AdoptionRecord{" +
                "id=" + id +
                ", pet=" + pet.getName() +
                ", adopter=" + adopter.getName() +
                ", adoptionDate=" + adoptionDate +
                ", status=" + status.getDescription() +
                '}';
    }
}
