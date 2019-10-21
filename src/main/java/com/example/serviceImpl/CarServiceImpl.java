package com.example.serviceImpl;

import com.example.pojo.Car;
import com.example.repository.CarRepository;
import com.example.service.CarService;
import com.example.utils.IdGenerator;
import com.example.utils.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CarServiceImpl implements CarService {

    //@Resource
    @Autowired
    private CarRepository carRepository;
    @Autowired
    private CarService carService;
    @Autowired
    private IdGenerator idGenerator;

    //请求全部数据
    @Override
    public List<Car> findAll() {
       // System.out.println("CarServiceImpl's findAll");
        return carRepository.findAll();
    }

    //根据ID查询某辆车的详情
    @Override
    public Car findById(String id) {
        Optional<Car> carOptional = carRepository.findById(id);
        if(carOptional.isPresent()){
            Car car = carOptional.get();
            return car;
        }else {
            throw new EntityNotFoundException(id);
        }
        //return carRepository.findById(id)
    }

    //根据ID删除车辆
    @Override
    public void deleteById(String id) {
            carRepository.deleteById(id);
    }

    //根据JSON字符串，转化成对象，再配置ID
    @Override
    public Car formCar(String carJson) {
        Car car = JsonUtils.jsonToPojo(carJson,Car.class);
        car.setId(idGenerator.snowflakeId()+"");
        return car;
    }

    //为修改车辆使用，不需要再配置id
    @Override
    public Car formEditCar(String carJson) {
        Car car = JsonUtils.jsonToPojo(carJson,Car.class);
        return car;
    }

    //保存单个车辆
    @Override
    public void saveCar(Car car) {
        carRepository.save(car);
    }

    //根据车牌号码或者车型搜索车辆
    @Override
    public List<Car> searchCar(String input) {
        //strings = new ArrayList<>();
        List<Car> cars = new ArrayList<>();
        List<String> strings = carRepository.findByCarsLike(input);
        for (int i = 0; i < strings.size(); i++) {
            Car car = carService.findById(strings.get(i));
            cars.add(car);
        }

        for (int i = 0; i < cars.size(); i++) {
            System.out.print(cars.get(i)+" ");
        }
        return cars;
    }
}
