package com.example.service;

import com.example.pojo.Car;
import com.example.pojo.Group;

import java.util.List;

public interface GroupService {

    //保存单个Group
    void saveGroup(Group group);

    Group formGroup(String groupJson);

    //请求全部数据
    List<Group> findAll();

    //根据ID查找分组
    Group findById(String id);

    //根据car的car_group（也就是group的ID）找到group的name
    String getGroupName(String carId);

    //根据分组查询车辆
//    List<Car> getCarsGroupByGroup(String groupId);
    List<Car> getCarsGroupByGroup(String groupId);

    //test
    //List<String> getCarGroupByGroup(String groupId);
}
