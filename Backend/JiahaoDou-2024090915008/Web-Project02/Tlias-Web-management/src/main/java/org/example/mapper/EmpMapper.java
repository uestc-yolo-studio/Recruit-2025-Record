package org.example.mapper;


import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.example.pojo.Emp;

import java.util.List;

@Mapper
public interface EmpMapper {
/**
 * 传统方式的分页查询
 */
   /*
    @Select("select e.*,d.name from emp e left join dept d on d.id=e.dept_id " +
            "order by update_time desc limit #{start},#{pageSize}")
    List<Emp> selectByPage(Integer start, Integer pageSize);


    @Select("select count(*) from emp e left join dept d on e.dept_id=d.id")
    Integer selectCountByPage();
    */

    /**
     * 基于PageHelper插件的分页查询
     */
    @Select("select e.*,d.name from emp e left join dept d on d.id=e.dept_id " +
            "order by update_time desc")
    List<Emp> selectByPage();
}
