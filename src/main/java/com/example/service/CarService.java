package com.example.service;

import com.example.pojo.Car;

import java.util.List;
import java.util.Optional;

public interface CarService {

    //请求全部数据
    List<Car> findAll();

    //根据ID查询某辆车的详情
    Car findById(String id);

    //根据ID删除车辆
    void deleteById(String id);

    Car formCar(String carJson);

    Car formEditCar(String carJson);
    //保存单个车辆
    void saveCar(Car car);

    //搜索车辆
    List<Car> searchCar(String input);

}
