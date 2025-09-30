package com.petadoption.mapper;

import com.petadoption.entities.AdoptionRecord;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
@Mapper
public interface AdoptionRecordMapper {
    /**
     * 处理领养人对宠物的领养。
     * @param petId 被领养的宠物的ID
     * @param adopterId 领养宠物的人的ID
     */
    @Insert("insert into adoption_record (pet_id, adopter_id, adoption_date, `status`) values (#{petId}, #{adopterId}, NOW(), '申请中')")
    void adoptPet(int petId, int adopterId);

    /**
     * 获取系统中的所有领养记录。
     * @return 所有领养记录的列表
     */
    @Select("select * from adoption_record")
    List<AdoptionRecord> getAllAdoptionRecords();

    /**
     * 获取特定宠物的领养记录。
     * @param petId 宠物的ID
     * @return 该宠物的领养记录列表
     */
    @Select("select * from adoption_record where pet_id = #{petId}")
    List<AdoptionRecord> getAdoptionRecordsByPet(int petId);

    /**
     * 获取特定领养人的领养记录。
     * @param adopterId 领养人的ID
     * @return 该领养人的领养记录列表
     */
    @Select("select * from adoption_record where adopter_id = #{adopterId}")
    List<AdoptionRecord> getAdoptionRecordsByAdopter(int adopterId);
}
