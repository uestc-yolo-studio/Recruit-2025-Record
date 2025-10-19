package org.example.mapper;

import org.apache.ibatis.annotations.*;
import org.example.pojo.Dept;

import java.util.List;

@Mapper
public interface DeptMapper {
    @Select("select id,name,create_time,update_time from dept order by update_time DESC")
    List<Dept> findall();

    @Delete("delete from dept where id=#{id}")
    void deleteByID(Integer id);

    @Insert("insert into dept (name, create_time, update_time) values (#{name}, #{createTime}, #{updateTime})")
    void addByPojo(Dept dept);

    @Select("select id,name,create_time,update_time from dept where id=#{id}")
    Dept getByID(Integer id);

    @Update("update dept set name=#{name},update_time=#{updateTime} where id=#{id}")
    void updateByPojo(Dept dept);
}
