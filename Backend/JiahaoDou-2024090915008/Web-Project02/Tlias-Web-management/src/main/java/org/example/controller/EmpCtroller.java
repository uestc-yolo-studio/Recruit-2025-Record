package org.example.controller;


import lombok.extern.slf4j.Slf4j;
import org.example.pojo.Emp;
import org.example.pojo.PageResult;
import org.example.pojo.Result;
import org.example.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequestMapping("/emps")
@RestController
public class EmpCtroller {

    @Autowired
    private EmpService empservice;

    @GetMapping
    public Result selectByPage(Integer page,Integer pageSize){
        log.info("分页查询：{}，{}",page,pageSize);
        PageResult<Emp> pageResult=empservice.selectByPage(page,pageSize);
        return Result.success(pageResult);
    }


}
