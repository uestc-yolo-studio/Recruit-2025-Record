package com.petadoption.mapper;

import com.petadoption.entities.Pet;
import org.apache.ibatis.annotations.*;

import java.util.List;
@Mapper
public interface PetMapper {
    /**
     * 向系统添加新的宠物。
     * @param pet 要添加的宠物
     */
    @Insert("insert into pet (`name`, species, age, adopt_status, added_date) values (#{name}, #{species}, #{age}, #{adoptStatus}, #{addedDate})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void addPet(Pet pet);

    /**
     * 更新现有宠物的信息。
     * @param pet 更新后的宠物信息
     */
    @Update("update pet set `name`= #{name}, species = #{species}, age = #{age}, adopt_status = #{adoptStatus}, added_date = #{addedDate} where id = #{id}")
    void updatePet(Pet pet);

    /**
     * 从系统中移除宠物。
     * @param petId 要移除的宠物的ID
     */
    @Delete("delete from pet where id = #{petId}")
    void removePet(int petId);

    /**
     * 获取系统中的所有宠物。
     * @return 所有宠物的列表
     */
    @Select("select * from pet")
    List<Pet> getAllPets();

    /**
     * 获取当前可领养的所有宠物。
     * @return 可领养宠物的列表
     */
    @Select("select * from pet where adopt_status = false")
    List<Pet> getAvailablePets();

    /**
     * 通过ID获取特定的宠物。
     * @param petId 要获取的宠物的ID
     * @return 宠物对象，如果未找到则返回null
     */
    @Select("select * from pet where id = #{petId}")
    Pet getPetById(int petId);
}
