package com.example.controller;

import com.example.pojo.Car;
import com.example.pojo.Group;
import com.example.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/group")
@CrossOrigin
public class GroupController {

    @Autowired
    private GroupService groupService;

    //请求全部数据
    @GetMapping("/groupList")
    @CrossOrigin
    public List<Group> getAllGroups(){
        return groupService.findAll();
    }

    @PostMapping("/groupAdd")
    @CrossOrigin
    public void addGroup(@RequestBody String groupJson){
        System.out.println(groupJson);
        Group group = groupService.formGroup(groupJson);
        groupService.saveGroup(group);
        //System.out.println(carJson);
    }

    //根据ID查询某分组的详情
    @GetMapping("/groupDetail/{id}")
    @CrossOrigin
    public Group getGroupDetail(@PathVariable("id") String id){
        return groupService.findById(id);
    }

    //根据car的car_group（也就是group的ID）找到group的name，传入car的ID
    @GetMapping("/groupName/{id}")
    @CrossOrigin
    public String getGroupName(@PathVariable("id") String carId){
        return groupService.getGroupName(carId);
    }

    @GetMapping("/groupCars/{id}")
    @CrossOrigin
    public List<Car> getCarsGroupByGroup(@PathVariable("id") String groupId){
        return groupService.getCarsGroupByGroup(groupId);
    }

//    @GetMapping("/groupCars/{id}")
//    @CrossOrigin
//    public List<String> getCarsGroupByGroup(@PathVariable("id") String groupId){
//        return groupService.getCarGroupByGroup(groupId);
//    }
}
