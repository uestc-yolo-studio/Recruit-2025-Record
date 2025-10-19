package org.example.service;


import org.example.pojo.Dept;

import java.util.List;

public interface DeptService {
    List<Dept> findall();

    void deleteByID(Integer id);

    void addByPojo(Dept dept);
    Dept getByID(Integer id);

    void updateByPojo(Dept dept);
}
