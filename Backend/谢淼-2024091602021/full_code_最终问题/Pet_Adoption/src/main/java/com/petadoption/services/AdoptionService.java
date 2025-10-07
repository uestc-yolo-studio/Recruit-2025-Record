/**
 * 定义管理宠物领养的核心操作的接口。
 * 此接口提供了管理宠物、领养人和领养记录的方法。
 */
package com.petadoption.services;

import com.petadoption.entities.AdoptionRecord;
import com.petadoption.entities.Pet;
import com.petadoption.entities.Adopter;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * 宠物领养服务接口
 * 
 * TODO: 请实现以下业务方法
 * 
 * 接口说明：
 * 1. 宠物管理相关方法：
 *    - 添加宠物
 *    - 更新宠物信息
 *    - 删除宠物
 *    - 查询所有宠物
 *    - 根据ID查询宠物
 * 
 * 2. 领养人管理相关方法：
 *    - 添加领养人
 *    - 更新领养人信息
 *    - 删除领养人
 *    - 查询所有领养人
 *    - 根据ID查询领养人
 * 
 * 3. 领养记录管理相关方法：
 *    - 处理领养过程
 *    - 查询所有领养记录
 *    - 根据ID查询领养记录
 *    - 根据宠物ID查询领养记录
 *    - 根据领养人ID查询领养记录
 * 
 * 注意：
 * 1. 所有方法都需要进行参数校验
 * 2. 需要处理并发情况
 * 3. 需要处理事务
 * 4. 需要处理异常情况
 */

public interface AdoptionService {

    /**
     * 向系统添加新的宠物。
     * @param pet 要添加的宠物
     */
    void addPet(Pet pet);
    
    /**
     * 更新现有宠物的信息。
     * @param pet 更新后的宠物信息
     */
    void updatePet(Pet pet);
    
    /**
     * 从系统中移除宠物。
     * @param petId 要移除的宠物的ID
     */
    void removePet(int petId);
    
    /**
     * 获取系统中的所有宠物。
     * @return 所有宠物的列表
     */
    List<Pet> getAllPets();
    
    /**
     * 获取当前可领养的所有宠物。
     * @return 可领养宠物的列表
     */
    List<Pet> getAvailablePets();
    
    /**
     * 通过ID获取特定的宠物。
     * @param petId 要获取的宠物的ID
     * @return 宠物对象，如果未找到则返回null
     */
    Pet getPetById(int petId);
    /**
     * 更新宠物的领养状态
     * @param pet 要更新状态的宠物对象
     */
    void updateStatus(Pet pet);
    // 领养人管理操作
    
    /**
     * 向系统添加新的领养人。
     * @param adopter 要添加的领养人
     */
    void addAdopter(Adopter adopter);
    
    /**
     * 更新现有领养人的信息。
     * @param adopter 更新后的领养人信息
     */
    void updateAdopter(Adopter adopter);
    
    /**
     * 从系统中移除领养人。
     * @param adopterId 要移除的领养人的ID
     */
    void removeAdopter(int adopterId);
    
    /**
     * 获取所有注册的领养人。
     * @return 所有领养人的列表
     */
    List<Adopter> getAllAdopters();
    
    /**
     * 通过ID获取特定的领养人。
     * @param adopterId 要获取的领养人的ID
     * @return 领养人对象，如果未找到则返回null
     */
    Adopter getAdopterById(int adopterId);

    // 领养管理操作
    
    /**
     * 处理领养人对宠物的领养。
     * @param record 领养记录对象，包含宠物ID和领养人ID等信息
     */
    void adoptPet(AdoptionRecord record);
    /**
     * 更新领养记录的信息。
     * @param record 要更新的领养记录
     */
    void updateRecord(AdoptionRecord record);
    /**
     * 通过ID获取特定的领养记录。
     * @param recordId 要获取的领养记录的ID
     * @return 领养记录对象，如果未找到则返回null
     */
    AdoptionRecord getRecordById(int recordId);
    /**
     * 获取系统中的所有领养记录。
     * @return 所有领养记录的列表
     */
    List<AdoptionRecord> getAllAdoptionRecords();
    
    /**
     * 获取特定宠物的领养记录。
     * @param petId 宠物的ID
     * @return 该宠物的领养记录列表
     */
    List<AdoptionRecord> getAdoptionRecordsByPet(int petId);
    
    /**
     * 获取特定领养人的领养记录。
     * @param adopterId 领养人的ID
     * @return 该领养人的领养记录列表
     */
    List<AdoptionRecord> getAdoptionRecordsByAdopter(int adopterId);
}
