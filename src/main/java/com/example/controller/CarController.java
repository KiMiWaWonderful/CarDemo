package com.example.controller;

import com.example.pojo.Car;
import com.example.service.CarService;
import com.example.serviceImpl.CarServiceImpl;
import com.example.utils.BeanUtil;
import com.example.utils.JsonUtils;
import net.sf.json.JSONObject;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/car")
@CrossOrigin
public class CarController {

    @Autowired
    private CarService carService;

    //请求全部数据
    @GetMapping("/carList")
    @CrossOrigin
    public List<Car> getAllCars(){
        return carService.findAll();
    }

    //根据ID查询某辆车的详情
    @GetMapping("/carDetail/{id}")
    @CrossOrigin
    public Car getCarDetail(@PathVariable("id") String id){

        return carService.findById(id);
    }

    //根据ID删除车辆
    @DeleteMapping("/carDelete/{id}")
    @CrossOrigin
    public void deleteCar(@PathVariable("id") String id){
        carService.deleteById(id);
    }

    //保存单个车辆
//    @PostMapping("/carAdd")
//    @CrossOrigin
//    public void addCar(@RequestParam("car") Car car){
//        carService.saveCar(car);
//    }
    @PostMapping("/carAdd")
    @CrossOrigin
    public void addCar(@RequestBody String carJson){
//        Car car = new Car();
//        JSONObject
//
        Car car = carService.formCar(carJson);
        carService.saveCar(car);
        //System.out.println(carJson);
    }

    @PostMapping("/carEdit/{id}")
    //@CrossOrigin(allowCredentials="true")
    @CrossOrigin
    public void editCar(@PathVariable("id") String id,@RequestBody String carJson){
        Car editCar = carService.formEditCar(carJson);
        Car oldCar = carService.findById(id);
        BeanUtils.copyProperties(editCar,oldCar, BeanUtil.getNullPropertyNames(editCar));
        carService.saveCar(oldCar);
//        System.out.println(id);
//        System.out.println(carJson);
       // System.out.println(oldCar.toString());
    }

    @PostMapping("/carSearch")
    @CrossOrigin
    public List<Car> searchCar(@RequestParam String input){

       // System.out.println(car);
        return carService.searchCar(input);
    }
}
