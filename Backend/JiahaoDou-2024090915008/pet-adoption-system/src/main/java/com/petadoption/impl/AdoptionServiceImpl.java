/**
 * AdoptionService接口的实现类，用于管理宠物领养。
 * 此类处理管理宠物、领养人和领养的所有业务逻辑。
 */
package com.petadoption.impl;

import com.petadoption.entities.*;
import com.petadoption.mapper.AdopterMapper;
import com.petadoption.mapper.AdoptionMapper;
import com.petadoption.mapper.PetMapper;
import com.petadoption.services.AdoptionService;
import com.petadoption.utils.MyBatisUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSession;

import java.time.LocalDateTime;
import java.util.*;

/**
 * AdoptionService接口的主要实现。
 * 使用内存存储来存储宠物、领养人和领养记录。
 */
@Slf4j
public class AdoptionServiceImpl implements AdoptionService {
    /** 通过ID存储所有宠物的映射 */
    private Map<Integer, Pet> pets;
    /** 通过ID存储所有领养人的映射 */
    private Map<Integer, Adopter> adopters;
    /** 存储所有领养记录的列表 */
    private List<AdoptionRecord> adoptionRecords;
    /** 下一个可用的宠物ID */
    private int nextPetId;
    /** 下一个可用的领养人ID */
    private int nextAdopterId;
    /** 下一个可用的领养记录ID */
    private int nextRecordId;

    /**
     * 构造函数初始化数据结构和ID计数器。
     */
    public AdoptionServiceImpl() {
        pets = new HashMap<>();
        adopters = new HashMap<>();
        adoptionRecords = new ArrayList<>();
        nextPetId = 1;
        nextAdopterId = 1;
        nextRecordId = 1;
    }

    // TODO: 实现领养记录管理相关方法
    // 提示：使用MyBatis进行数据库操作

    @Override
    public void addPet(Pet pet) {
        //单条数据库操作，可以不用绑定事务，直接自动提交即可
        try(SqlSession session= MyBatisUtil.openSession(true)){
            PetMapper petMapper = session.getMapper(PetMapper.class);
            petMapper.addPet(pet);
            log.info("添加了宠物id为：{}", pet.getId());
        }
    }

    @Override
    public void updatePet(Pet pet) {
        try(SqlSession session= MyBatisUtil.openSession(true)){
            PetMapper petMapper = session.getMapper(PetMapper.class);
            petMapper.updatePet(pet);
            log.info("更新了宠物id为：{}", pet.getId());
        }
    }

    @Override
    public void removePet(int petId) {
        try(SqlSession session= MyBatisUtil.openSession(true)){
            PetMapper petMapper = session.getMapper(PetMapper.class);
            petMapper.removePet(petId);
            log.info("删除了宠物id为：{}", petId);
        }
    }

    @Override
    public List<Pet> getAllPets() {
          try(SqlSession session= MyBatisUtil.openSession(true)){
            PetMapper petMapper = session.getMapper(PetMapper.class);
            log.info("获取所有宠物");
            return petMapper.getAllPets();
        }
    }

    @Override
    public List<Pet> getAvailablePets() {
          try(SqlSession session= MyBatisUtil.openSession(true)){
            PetMapper petMapper = session.getMapper(PetMapper.class);
            log.info("获取所有可领养的宠物");
            return petMapper.getAvailablePets();
        }
    }

    @Override
    public Pet getPetById(int petId) {
        try(SqlSession session= MyBatisUtil.openSession(true)){
            PetMapper petMapper = session.getMapper(PetMapper.class);
            log.info("获取宠物id为：{}", petId);
            return petMapper.getPetById(petId);
        }
    }

    @Override
    public void addAdopter(Adopter adopter) {
        try(SqlSession session= MyBatisUtil.openSession(true)){
            AdopterMapper adopterMapper = session.getMapper(AdopterMapper.class);
            adopterMapper.addAdopter(adopter);
            log.info("添加了领养人id为：{}", adopter.getId());
        }
    }

    @Override
    public void updateAdopter(Adopter adopter) {
        try(SqlSession session= MyBatisUtil.openSession(true)){
            AdopterMapper adopterMapper = session.getMapper(AdopterMapper.class);
            adopterMapper.updateAdopter(adopter);
            log.info("更新了领养人id为：{}", adopter.getId());
        }
    }

    @Override
    public void removeAdopter(int adopterId) {
        try(SqlSession session= MyBatisUtil.openSession(true)){
            AdopterMapper adopterMapper = session.getMapper(AdopterMapper.class);
            adopterMapper.removeAdopter(adopterId);
            log.info("删除了领养人id为：{}", adopterId);
        }
    }

    @Override
    public List<Adopter> getAllAdopters() {
        try(SqlSession session= MyBatisUtil.openSession(true)){
            AdopterMapper adopterMapper = session.getMapper(AdopterMapper.class);
            log.info("获取所有领养人");
            return adopterMapper.getAllAdopters();
        }
    }

    @Override
    public Adopter getAdopterById(int adopterId) {
        try(SqlSession session= MyBatisUtil.openSession(true)){
            AdopterMapper adopterMapper = session.getMapper(AdopterMapper.class);
            log.info("获取领养人id为：{}", adopterId);
            return adopterMapper.getAdopterById(adopterId);
        }
    }

    @Override
    public void adoptPet(int petId, int adopterId) {
         //这个方法比较复杂，里边涉及到多个操作，故需要手动管理事务来保证事务的一致性
        try(SqlSession session= MyBatisUtil.openSession(false)){
              //首先更新宠物表
              PetMapper petMapper = session.getMapper(PetMapper.class);
              Pet pet = petMapper.getPetById(petId);
              pet.setAdoptStatus(true);
              petMapper.updatePet(pet);

              //然后更新领养记录表，插入一条新的领养记录
              AdoptionMapper adoptionMapper = session.getMapper(AdoptionMapper.class);
              AdoptionRecord adoptionRecord = new AdoptionRecord();
              adoptionRecord.setPet(pet);
              //先找到那个adopter
              AdopterMapper adopterMapper = session.getMapper(AdopterMapper.class);
              adoptionRecord.setAdopter(adopterMapper.getAdopterById(adopterId));

              //设置领养时间（即为当前程序运行时间）
              adoptionRecord.setAdoptionDate(new Date());
              adoptionRecord.setStatus(AdoptionRecord.Status.APPLYING);

              //最后插入
              adoptionMapper.addAdoptionRecord(adoptionRecord);
              log.info("添加了领养记录id为：{}", adoptionRecord.getId());
              session.commit();
             }catch(Exception e){
                 throw e;
             }
         }

    @Override
    public List<AdoptionRecord> getAllAdoptionRecords() {
         try(SqlSession session= MyBatisUtil.openSession(true)){
             AdoptionMapper adoptionMapper = session.getMapper(AdoptionMapper.class);
             log.info("获取所有领养记录");
             return adoptionMapper.getAllAdoptionRecords();
         }
    }

    @Override
    public List<AdoptionRecord> getAdoptionRecordsByPet(int petId) {
         try(SqlSession session= MyBatisUtil.openSession(true)){
             AdoptionMapper adoptionMapper = session.getMapper(AdoptionMapper.class);
             log.info("获取宠物id为：{}的领养记录", petId);
             return adoptionMapper.getAdoptionRecordsByPet(petId);
         }
    }

    /** 获取特定领养人的领养记录。
     * @param adopterId 领养人的ID
     * @return 该领养人的领养记录列表
     */
    @Override
    public List<AdoptionRecord> getAdoptionRecordsByAdopter(int adopterId) {
        List<AdoptionRecord> records = new ArrayList<>();
        for (AdoptionRecord record : adoptionRecords) {
            if (record.getAdopter().getId() == adopterId) {
                records.add(record);
            }
        }
        return records;
    }
}
