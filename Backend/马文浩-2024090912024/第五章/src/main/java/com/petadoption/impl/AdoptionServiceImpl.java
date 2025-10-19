/**
 * AdoptionService接口的实现类，用于管理宠物领养。
 * 此类处理管理宠物、领养人和领养的所有业务逻辑。
 */
package com.petadoption.impl;
import com.petadoption.entities.AdoptionRecord;
import com.petadoption.entities.PetDAO;
import com.petadoption.entities.AdopterDAO;
import com.petadoption.entities.AdoptionRecordDAO;
import com.petadoption.entities.Pet;
import com.petadoption.entities.Adopter;

import com.petadoption.entities.*;
import com.petadoption.services.AdoptionService;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;


import java.io.IOException;
import java.io.Reader;
import java.util.*;

/**
 * AdoptionService接口的主要实现。
 * 使用内存存储来存储宠物、领养人和领养记录。
 */
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


    private SqlSessionFactory sqlSessionFactory;

    public AdoptionServiceImpl() {
        try {
            Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addPet(Pet pet) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            PetDAO petDAO = session.getMapper(PetDAO.class);
            pet.setAddedDate(new Date());
            petDAO.insert(pet);
            session.commit();
        }
    }

    @Override
    public void updatePet(Pet pet) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            PetDAO petDAO = session.getMapper(PetDAO.class);
            petDAO.update(pet);
            session.commit();
        }
    }

    @Override
    public void removePet(int petId) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            PetDAO petDAO = session.getMapper(PetDAO.class);
            petDAO.delete(petId);
            session.commit();
        }
    }

    @Override
    public Pet getPetById(int petId) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            PetDAO petDAO = session.getMapper(PetDAO.class);
            return petDAO.selectById(petId);
        }
    }

    @Override
    public void addAdopter(Adopter adopter) {

    }

    @Override
    public void updateAdopter(Adopter adopter) {

    }

    @Override
    public void removeAdopter(int adopterId) {

    }

    @Override
    public List<Adopter> getAllAdopters() {
        return List.of();
    }

    @Override
    public Adopter getAdopterById(int adopterId) {
        return null;
    }

    @Override
    public List<Pet> getAllPets() {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            PetDAO petDAO = session.getMapper(PetDAO.class);
            return petDAO.selectAll();
        }
    }

    @Override
    public List<Pet> getAvailablePets() {
        List<Pet> allPets = getAllPets();
        List<Pet> availablePets = new ArrayList<>();
        for (Pet pet : allPets) {
            if (!pet.isAdoptStatus()) {
                availablePets.add(pet);
            }
        }
        return availablePets;
    }
    @Override
    public void adoptPet(int petId, int adopterId) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            // 获取 DAO 映射器
            PetDAO petDAO = session.getMapper(PetDAO.class);
            AdopterDAO adopterDAO = session.getMapper(AdopterDAO.class);
            AdoptionRecordDAO adoptionRecordDAO = session.getMapper(AdoptionRecordDAO.class);

            // 获取宠物和领养人信息
            Pet pet = petDAO.selectById(petId);
            Adopter adopter = adopterDAO.selectById(adopterId);

            if (pet != null && adopter != null && !pet.isAdoptStatus()) {
                // 更新宠物领养状态
                pet.setAdoptStatus(true);
                petDAO.update(pet);

                // 创建领养记录
                AdoptionRecord record = new AdoptionRecord();
                record.setPet(pet);
                record.setAdopter(adopter);
                record.setAdoptionDate(new Date());

                // 插入领养记录
                adoptionRecordDAO.insert(record);

                session.commit();
            }
        }
    }
    @Override
    public List<AdoptionRecord> getAllAdoptionRecords() {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            AdoptionRecordDAO adoptionRecordDAO = session.getMapper(AdoptionRecordDAO.class);
            return adoptionRecordDAO.selectAll();
        }
    }

    @Override
    public List<AdoptionRecord> getAdoptionRecordsByPet(int petId) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            AdoptionRecordDAO adoptionRecordDAO = session.getMapper(AdoptionRecordDAO.class);
            return adoptionRecordDAO.selectByPetId(petId);
        }
    }



    // TODO: 实现领养记录管理相关方法
    // 提示：使用MyBatis进行数据库操作
//     * 获取特定领养人的领养记录。
//     * @param adopterId 领养人的ID
//     * @return 该领养人的领养记录列表
//     */
//    @Override
//    public List<AdoptionRecord> getAdoptionRecordsByAdopter(int adopterId) {
//        List<AdoptionRecord> records = new ArrayList<>();
//        for (AdoptionRecord record : adoptionRecords) {
//            if (record.getAdopter().getId() == adopterId) {
//                records.add(record);
//            }
//        }
//        return records;
//    }
    @Override
    public List<AdoptionRecord> getAdoptionRecordsByAdopter(int adopterId) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            AdoptionRecordDAO adoptionRecordDAO = session.getMapper(AdoptionRecordDAO.class);
            return adoptionRecordDAO.selectByAdopterId(adopterId);
        }
    }
}
