package org.example.controller;


import lombok.extern.slf4j.Slf4j;
import org.example.pojo.Dept;
import org.example.pojo.Result;
import org.example.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@Slf4j
@RequestMapping("/depts")
@RestController
public class DeptCtroller {
    @Autowired
    private DeptService deptService;

    @GetMapping
    public Result list() {
        log.info("查询全部部门数据");
        List<Dept> data = deptService.findall();
        return Result.success(data);
    }

    @DeleteMapping
    public Result delete(Integer id) {
        log.info("请求删除：{}",id);
        deptService.deleteByID(id);
        return Result.success();
    }

    @PostMapping
    public Result add(@RequestBody Dept dept) {
        log.info("请求添加：{}",dept);
        deptService.addByPojo(dept);
        return Result.success();
    }

    @GetMapping("/{id}")
    public Result get(@PathVariable Integer id) {
        log.info("根据id查询：{}",id);
        return Result.success(deptService.getByID(id));
    }

    @PutMapping
    public Result update(@RequestBody Dept dept) {
        log.info("修改部门：{}",dept);
        deptService.updateByPojo(dept);
        return Result.success();
    }

}
