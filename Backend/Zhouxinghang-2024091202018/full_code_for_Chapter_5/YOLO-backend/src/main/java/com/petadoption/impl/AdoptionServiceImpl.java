/**
 * AdoptionService接口的实现类，用于管理宠物领养。
 * 此类处理管理宠物、领养人和领养的所有业务逻辑。
 */
package com.petadoption.impl;

import com.petadoption.entities.*;
import com.petadoption.mapper.AdopterMapper;
import com.petadoption.mapper.AdoptionRecordMapper;
import com.petadoption.mapper.PetMapper;
import com.petadoption.services.AdoptionService;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.mindrot.jbcrypt.BCrypt;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;

/**
 * AdoptionService接口的主要实现。
 * 使用内存存储来存储宠物、领养人和领养记录。
 */
public class AdoptionServiceImpl implements AdoptionService {
    private static final Logger logger = LoggerFactory.getLogger(AdoptionServiceImpl.class);
    private static final SqlSessionFactory sqlSessionFactory;

    // 静态初始化MyBatis
    static {
        String resource = "mybatis-config.xml";
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream(resource);
        } catch (IOException e) {
            logger.error("MyBatis配置文件加载失败", e);
            throw new RuntimeException("初始化MyBatis失败", e);
        }
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }

    // TODO: 实现领养记录管理相关方法

    // 宠物管理

    /**
     * 向系统添加新的宠物。
     * @param pet 要添加的宠物
     */
    @Override
    public void addPet(Pet pet) {
        SqlSession session = null;
        try {
            // 参数校验
            if (pet.getName() == null || pet.getName().trim().isEmpty()) {
                throw new RuntimeException("宠物名称不能为空");
            }
            if (pet.getAge() <= 0) {
                throw new RuntimeException("年龄不能为非正数");
            }
            session = sqlSessionFactory.openSession();
            PetMapper petMapper = session.getMapper(PetMapper.class);
            pet.setAddedDate(new Date());
            pet.setAdoptStatus(false); // 默认可领养
            petMapper.addPet(pet);
            session.commit();
            logger.info("添加宠物成功: {}", pet.getName());
        } catch (Exception e) {
            if (session != null) {
                session.rollback();//回滚事务
            }
            logger.error("添加宠物失败");
            throw new RuntimeException("添加宠物失败");
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    /**
     * 更新现有宠物的信息。
     * @param pet 更新后的宠物信息
     */
    @Override
    public void updatePet(Pet pet) {
        SqlSession session = null;
        try {
            session = sqlSessionFactory.openSession();
            PetMapper petMapper = session.getMapper(PetMapper.class);
            // 验证宠物是否存在
            if (petMapper.getPetById(pet.getId()) == null) {
                throw new RuntimeException("宠物不存在, ID: " + pet.getId());
            }
            petMapper.updatePet(pet);
            session.commit();
            logger.info("更新宠物成功: {}", pet.getId());
        } catch (Exception e) {
            if (session != null) {
                session.rollback();//回滚事务
            }
            logger.error("更新宠物失败");
            throw new RuntimeException("更新宠物失败");
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    /**
     * 从系统中移除宠物。
     * @param petId 要移除的宠物的ID
     */
    @Override
    public void removePet(int petId) {
        SqlSession session = null;
        try {
            session = sqlSessionFactory.openSession();
            PetMapper petMapper = session.getMapper(PetMapper.class);
            // 验证宠物是否存在
            if (petMapper.getPetById(petId) == null) {
                throw new RuntimeException("宠物不存在, ID: " + petId);
            }
            petMapper.removePet(petId);
            session.commit();
            logger.info("删除宠物成功: " + "{}", petId);
        } catch (Exception e) {
            if (session != null) {
                session.rollback();//回滚事务
            }
            logger.error("删除宠物失败");
            throw new RuntimeException("删除宠物失败");
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    /**
     * 获取系统中的所有宠物。
     * @return 所有宠物的列表
     */
    @Override
    public List<Pet> getAllPets() {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            PetMapper petMapper = session.getMapper(PetMapper.class);
            return petMapper.getAllPets();
        } catch (Exception e) {
            logger.error("查询所有宠物失败");
            throw new RuntimeException("查询所有宠物失败");
        }
    }

    /**
     * 获取当前可领养的所有宠物。
     * @return 可领养宠物的列表
     */
    @Override
    public List<Pet> getAvailablePets() {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            PetMapper petMapper = session.getMapper(PetMapper.class);
            return petMapper.getAvailablePets();
        } catch (Exception e) {
            logger.error("查询可领养宠物失败");
            throw new RuntimeException("查询可领养宠物失败");
        }
    }

    /**
     * 通过ID获取特定的宠物。
     * @param petId 要获取的宠物的ID
     * @return 宠物对象，如果未找到则返回null
     */
    @Override
    public Pet getPetById(int petId) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            PetMapper petMapper = session.getMapper(PetMapper.class);
            return petMapper.getPetById(petId);
        } catch (Exception e) {
            logger.error("查询宠物失败, ID: {}", petId);
            throw new RuntimeException("查询宠物失败");
        }
    }


    // 领养人管理

    /**
     * 向系统添加新的领养人。
     * @param adopter 要添加的领养人
     */
    @Override
    public void addAdopter(Adopter adopter) {
        SqlSession session = null;
        try {
            // 参数校验
            if (adopter.getPhone() == null || adopter.getPhone().trim().isEmpty()) {
                throw new RuntimeException("手机号不能为空");
            }
            if (adopter.getPassword() == null || adopter.getPassword().trim().isEmpty()) {
                throw new RuntimeException("密码不能为空");
            }
            session = sqlSessionFactory.openSession();
            AdopterMapper adopterMapper = session.getMapper(AdopterMapper.class);

            adopter.setRegistrationDate(new Date());
            // 密码加密存储
            adopter.setPassword(BCrypt.hashpw(adopter.getPassword(), BCrypt.gensalt()));
            adopterMapper.addAdopter(adopter);
            session.commit();
            logger.info("注册领养人成功: {}", adopter.getPhone());
        } catch (Exception e) {
            if (session != null) {
                session.rollback();//回滚事务
            }
            logger.error("注册领养人失败");
            throw new RuntimeException("注册领养人失败");
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    /**
     * 更新现有领养人的信息。
     * @param adopter 更新后的领养人信息
     */
    @Override
    public void updateAdopter(Adopter adopter) {
        SqlSession session = null;
        try {
            session = sqlSessionFactory.openSession();
            AdopterMapper adopterMapper = session.getMapper(AdopterMapper.class);

            // 验证领养人是否存在
            if (adopterMapper.getAdopterById(adopter.getId()) == null) {
                throw new IllegalArgumentException("领养人不存在, ID: " + adopter.getId());
            }

            adopterMapper.updateAdopter(adopter);
            session.commit();
            logger.info("更新领养人成功: {}", adopter.getId());
        } catch (Exception e) {
            if (session != null) {
                session.rollback();//回滚事务
            }
            logger.error("更新领养人失败");
            throw new RuntimeException("更新领养人失败");
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    /**
     * 从系统中移除领养人。
     * @param adopterId 要移除的领养人的ID
     */
    @Override
    public void removeAdopter(int adopterId) {
        SqlSession session = null;
        try {
            session = sqlSessionFactory.openSession();
            AdopterMapper adopterDAO = session.getMapper(AdopterMapper.class);

            // 验证领养人是否存在
            if (adopterDAO.getAdopterById(adopterId) == null) {
                throw new IllegalArgumentException("领养人不存在, ID: " + adopterId);
            }

            adopterDAO.removeAdopter(adopterId);
            session.commit();
            logger.info("删除领养人成功: {}", adopterId);
        } catch (Exception e) {
            if (session != null) {
                session.rollback();//回滚事务
            }
            logger.error("删除领养人失败");
            throw new RuntimeException("删除领养人失败");
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    /**
     * 获取所有注册的领养人。
     * @return 所有领养人的列表
     */
    public List<Adopter> getAllAdopters() {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            AdopterMapper adopterMapper = session.getMapper(AdopterMapper.class);
            return adopterMapper.getAllAdopters();
        } catch (Exception e) {
            logger.error("查询所有领养人失败");
            throw new RuntimeException("查询所有领养人失败");
        }
    }

    /**
     * 通过ID获取特定的领养人。
     * @param adopterId 要获取的领养人的ID
     * @return 领养人对象，如果未找到则返回null
     */
    @Override
    public Adopter getAdopterById(int adopterId) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            AdopterMapper adopterMapper = session.getMapper(AdopterMapper.class);
            return adopterMapper.getAdopterById(adopterId);
        } catch (Exception e) {
            logger.error("查询领养人失败, ID: {}", adopterId);
            throw new RuntimeException("查询领养人失败");
        }
    }


    // 领养流程管理

    /**
     * 处理领养人对宠物的领养。
     * @param petId 被领养的宠物的ID
     * @param adopterId 领养宠物的人的ID
     */
    @Override
    public void adoptPet(int petId, int adopterId) {
        SqlSession session = null;
        try {
            session = sqlSessionFactory.openSession();
            PetMapper petMapper = session.getMapper(PetMapper.class);
            AdopterMapper adopterMapper = session.getMapper(AdopterMapper.class);
            AdoptionRecordMapper adoptionRecordMapper = session.getMapper(AdoptionRecordMapper.class);

            // 验证宠物是否存在且可领养
            Pet pet = petMapper.getPetById(petId);
            if (pet == null) {
                throw new RuntimeException("宠物不存在");
            }
            if (pet.isAdoptStatus()) {
                throw new RuntimeException("宠物已被领养");
            }

            // 验证领养人是否存在
            Adopter adopter = adopterMapper.getAdopterById(adopterId);
            if (adopter == null) {
                throw new RuntimeException("领养人不存在");
            }

            adoptionRecordMapper.adoptPet(petId, adopterId);

            // 更新宠物状态为已领养
            pet.setAdoptStatus(true);
            petMapper.updatePet(pet);

            session.commit();
            logger.info("创建领养记录成功: 宠物[{}] - 领养人[{}]", pet.getId(), adopter.getId());
        } catch (Exception e) {
            if (session != null) {
                session.rollback();//回滚事务
            }
            logger.error("创建领养记录失败");
            throw new RuntimeException("创建领养记录失败");
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    /**
     * 获取系统中的所有领养记录。
     * @return 所有领养记录的列表
     */
    public List<AdoptionRecord> getAllAdoptionRecords() {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            AdoptionRecordMapper adoptionRecordMapper = session.getMapper(AdoptionRecordMapper.class);
            return adoptionRecordMapper.getAllAdoptionRecords();
        } catch (Exception e) {
            logger.error("查询所有领养记录失败");
            throw new RuntimeException("查询所有领养记录失败");
        }
    }

    /**
     * 获取特定宠物的领养记录。
     * @param petId 宠物的ID
     * @return 该宠物的领养记录列表
     */
    @Override
    public List<AdoptionRecord> getAdoptionRecordsByPet(int petId) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            AdoptionRecordMapper adoptionRecordMapper = session.getMapper(AdoptionRecordMapper.class);
            return adoptionRecordMapper.getAdoptionRecordsByPet(petId);
        } catch (Exception e) {
            logger.error("查询领养记录失败, 宠物ID: {}", petId);
            throw new RuntimeException("查询领养记录失败");
        }
    }

    /**
     * 获取特定领养人的领养记录。
     * @param adopterId 领养人的ID
     * @return 该领养人的领养记录列表
     */
    @Override
    public List<AdoptionRecord> getAdoptionRecordsByAdopter(int adopterId) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            AdoptionRecordMapper adoptionRecordMapper = session.getMapper(AdoptionRecordMapper.class);
            return adoptionRecordMapper.getAdoptionRecordsByAdopter(adopterId);
        } catch (Exception e) {
            logger.error("查询领养记录失败, 领养人ID: {}", adopterId);
            throw new RuntimeException("查询领养记录失败");
        }
    }

}
