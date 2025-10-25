package com.petadoption.mapper;

import com.petadoption.entities.Adopter;
import org.apache.ibatis.annotations.*;

import java.util.List;
@Mapper
public interface AdopterMapper {
    /**
     * 向系统添加新的领养人。
     * @param adopter 要添加的领养人
     */
    @Insert("insert into adopter (`name`, phone, address, registration_date, `password`) values (#{name}, #{phone}, #{address}, #{registrationDate}, #{password})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void addAdopter(Adopter adopter);

    /**
     * 更新现有领养人的信息。
     * @param adopter 更新后的领养人信息
     */
    @Update("update adopter set `name` = #{name}, phone = #{phone}, address = #{address}, registration_date = #{registrationDate}, `password` = #{password} where id = #{id}")
    void updateAdopter(Adopter adopter);

    /**
     * 从系统中移除领养人。
     * @param adopterId 要移除的领养人的ID
     */
    @Delete("delete from adopter where id = #{adopterId}")
    void removeAdopter(int adopterId);

    /**
     * 获取所有注册的领养人。
     * @return 所有领养人的列表
     */
    @Select("select * from adopter")
    List<Adopter> getAllAdopters();

    /**
     * 通过ID获取特定的领养人。
     * @param adopterId 要获取的领养人的ID
     * @return 领养人对象，如果未找到则返回null
     */
    @Select("select * from adopter where id =#{adopterId}")
    Adopter getAdopterById(int adopterId);
}
