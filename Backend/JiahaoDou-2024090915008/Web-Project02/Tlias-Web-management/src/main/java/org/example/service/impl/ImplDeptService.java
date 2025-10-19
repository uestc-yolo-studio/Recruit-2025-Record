package org.example.service.impl;

import org.example.mapper.DeptMapper;
import org.example.pojo.Dept;
import org.example.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ImplDeptService implements DeptService {
    @Autowired
    private DeptMapper deptMapper;

    @Override
    public List<Dept> findall() {
        return deptMapper.findall();
    }

    @Override
    public void deleteByID(Integer id) {
        deptMapper.deleteByID(id);
    }

    @Override
    public void addByPojo(Dept dept) {
        dept.setCreateTime(LocalDateTime.now());
        dept.setUpdateTime(LocalDateTime.now());
        deptMapper.addByPojo(dept);
    }

    @Override
    public Dept getByID(Integer id) {
        return deptMapper.getByID(id);
    }

    @Override
    public void updateByPojo(Dept dept) {
        dept.setUpdateTime(LocalDateTime.now());
        deptMapper.updateByPojo(dept);
    }
}
