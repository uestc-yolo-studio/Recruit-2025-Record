package org.example.service;

import org.example.pojo.Emp;
import org.example.pojo.PageResult;

public interface EmpService {
    PageResult<Emp> selectByPage(Integer page, Integer pageSize);
}
