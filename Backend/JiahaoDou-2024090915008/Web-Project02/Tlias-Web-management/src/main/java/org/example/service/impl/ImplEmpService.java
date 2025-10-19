package org.example.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.example.mapper.EmpMapper;
import org.example.pojo.Emp;
import org.example.pojo.PageResult;
import org.example.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImplEmpService implements EmpService {

    @Autowired
    private EmpMapper empMapper;


    /**
     *传统方式的分页查询
     */
   /*
    @Override
    public PageResult<Emp> selectByPage(Integer page, Integer pageSize) {
        Integer count=empMapper.selectCountByPage();
        List<Emp> list=empMapper.selectByPage((page-1)*pageSize,pageSize);
        return new PageResult<Emp>(count,list);
    }
    */

    /**
     * 优化后基于PageHelper插件的分页查询
     */
    @Override
    public PageResult<Emp> selectByPage(Integer page, Integer pageSize) {
        PageHelper.startPage(page,pageSize);
        List<Emp> empList=empMapper.selectByPage();
        Page<Emp> empPage=(Page<Emp>) empList;
        return new PageResult<Emp>(empPage.getTotal(),empPage.getResult());
    }

}
