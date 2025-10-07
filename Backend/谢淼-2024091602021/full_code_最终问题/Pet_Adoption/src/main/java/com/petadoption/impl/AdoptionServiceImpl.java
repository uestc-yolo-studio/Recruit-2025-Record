/**
 * AdoptionService接口的实现类，用于管理宠物领养。
 * 此类处理管理宠物、领养人和领养的所有业务逻辑。
 */
package com.petadoption.impl;

import com.petadoption.Mapper.AdopterMapper;
import com.petadoption.Mapper.AdoptionRecordMapper;
import com.petadoption.Mapper.PetMapper;
import com.petadoption.entities.*;
import com.petadoption.services.AdoptionService;
import java.util.ArrayList;
import java.util.List;


/**
 * AdoptionService接口的主要实现。
 * 使用内存存储来存储宠物、领养人和领养记录。
 */
//重构这个类
public class AdoptionServiceImpl implements AdoptionService {
    private List<AdoptionRecord> adoptionRecords;
    /** 下一个可用的宠物ID */
    private int nextPetId;
    /** 下一个可用的领养人ID */
    private int nextAdopterId;
    /** 下一个可用的领养记录ID */
    private int nextRecordId;
    // MyBatis的Mapper接口
    private final PetMapper petMapper;
    private final AdopterMapper adopterMapper;
    private final AdoptionRecordMapper adoptionRecordmapper;
    /**
     * 构造函数初始化数据结构和ID计数器。
     */
    public AdoptionServiceImpl(PetMapper petMapper, AdopterMapper adopterMapper, AdoptionRecordMapper adoptionRecordmapper) {
        adoptionRecords = new ArrayList<>();
        this.petMapper = petMapper;
        this.adopterMapper = adopterMapper;
        this.adoptionRecordmapper = adoptionRecordmapper;
    }
    //宠物管理
    /**
     * 向系统添加新的宠物。
     * @param pet 要添加的宠物
     */
    @Override
    public void addPet(Pet pet) {
        petMapper.addPet(pet);
    }
    /**
     * 根据ID获取宠物信息。
     * @param id 宠物的ID
     * @return 对应ID的宠物对象，如果不存在则返回null
     */
    @Override
    public Pet getPetById(int id) {
        return petMapper.getPetById(id);
    }
    /**
     * 更新宠物信息。
     * @param pet 要更新的宠物对象
     */
    @Override
    public void updatePet(Pet pet) {
        petMapper.updatePet(pet);
    }
    /**
     * 从系统中移除宠物。
     * @param id 要移除的宠物的ID
     */
    @Override
    public void removePet(int id) {
        petMapper.removePet(id);
    }
    /**
     * 获取系统中的所有宠物。
     * @return 所有宠物的列表
     */
    @Override
    public List<Pet> getAllPets() {
        return petMapper.getAllPets();
    }
    /**
     * 获取当前可领养的所有宠物。
     * @return 可领养宠物的列表
     */
    @Override
    public List<Pet> getAvailablePets() {
        return petMapper.getAvailablePets();
    }
    @Override
    public void updateStatus(Pet pet) {
        petMapper.updateStatus(pet);
    }
    //领养人管理
    /**
     * 添加新的领养人。
     * @param adopter 要添加的领养人对象
     */
    @Override
    public void addAdopter(Adopter adopter) {
        adopterMapper.addAdopter(adopter);
    }
    /**
     * 更新领养人信息。
     * @param adopter 要更新的领养人对象
     */
    @Override
    public void updateAdopter(Adopter adopter) {
        adopterMapper.updateAdopter(adopter);
    }
    /**
     * 从系统中移除领养人。
     * @param id 要移除的领养人的ID
     */
    @Override
    public void removeAdopter(int id) {
        adopterMapper.removeAdopter(id);
    }
    /**
     * 根据ID获取领养人信息。
     * @param id 领养人的ID
     * @return 对应ID的领养人对象，如果不存在则返回null
     */
    @Override
    public Adopter getAdopterById(int id) {
        return adopterMapper.getAdopterById(id);
    }
    /**
     * 获取所有注册的领养人。
     * @return 所有领养人的列表
     */
    @Override
    public List<Adopter> getAllAdopters() {
        return adopterMapper.getAllAdopters();
    }
    // TODO: 实现领养记录管理相关方法
    // 提示：使用MyBatis进行数据库操作
    /**
     * 记录宠物的领养信息。
     * @param record 领养记录对象，包含领养人ID、宠物ID和领养日期等信息
     */
    @Override
    public void adoptPet(AdoptionRecord record) {
        adoptionRecordmapper.adoptPet(record);
    }
    /**
     * 更新领养记录信息。
     * @param record 要更新的领养记录的ID
     */
    @Override
    public void updateRecord(AdoptionRecord record) {
        adoptionRecordmapper.updateRecord(record);
    }
    /**
     * 根据ID获取领养记录信息。
     * @param recordId 领养记录的ID
     * @return 对应ID的领养记录对象，如果不存在则返回null
     */
    @Override
    public AdoptionRecord getRecordById(int recordId) {
        return adoptionRecordmapper.getRecordById(recordId);
    }
    /**
     * 获取系统中的所有领养记录。
     * @return 所有领养记录的列表
     */
    @Override
    public List<AdoptionRecord> getAllAdoptionRecords() {
        return adoptionRecordmapper.getAllAdoptionRecords();
    }
    /**
     * 获取指定宠物的领养记录
     * @param petId 宠物的ID
     * @return 所有结果的列表
     */
    @Override
    public List<AdoptionRecord> getAdoptionRecordsByPet(int petId) {
        return adoptionRecordmapper.getAdoptionRecordsByPet(petId);
    }
    /*
     * 获取特定领养人的领养记录。
     * @param adopterId 领养人的ID
     * @return 该领养人的领养记录列表
     */
    @Override
    public List<AdoptionRecord> getAdoptionRecordsByAdopter(int adopterId) {
        return adoptionRecordmapper.getAdoptionRecordsByAdopter(adopterId);
    }
}
