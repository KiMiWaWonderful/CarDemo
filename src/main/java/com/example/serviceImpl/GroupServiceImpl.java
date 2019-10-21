package com.example.serviceImpl;

import com.example.pojo.Car;
import com.example.pojo.Group;
import com.example.repository.GroupRepository;
import com.example.service.CarService;
import com.example.service.GroupService;
import com.example.utils.IdGenerator;
import com.example.utils.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class GroupServiceImpl implements GroupService {

    @Autowired
    private GroupRepository groupRepository;
    @Autowired
    private CarService carService;
    @Autowired
    private IdGenerator idGenerator;

    //根据JSON字符串，转化成对象，再配置ID
    @Override
    public Group formGroup(String groupJson) {
        Group group = JsonUtils.jsonToPojo(groupJson,Group.class);
        group.setId(idGenerator.snowflakeId()+"");
        return group;
    }

    @Override
    public List<Group> findAll() {
        return groupRepository.findAll();
    }

    //根据ID查找分组
    @Override
    public Group findById(String id) {
        Optional<Group> groupOptional = groupRepository.findById(id);
        if(groupOptional.isPresent()){
            Group group = groupOptional.get();
            return group;
        }else {
            throw new EntityNotFoundException(id);
        }
    }

    //根据car的car_group（也就是group的ID）找到group的name，传入car的ID
    @Override
    public String getGroupName(String carId) {
        return groupRepository.findGroupName(carId);
    }

    @Override
    public List<Car> getCarsGroupByGroup(String groupId) {
        List<String> strings = groupRepository.findCarsGroupByGroup(groupId);
        List<Car> cars = new ArrayList<>();

        for (int i = 0; i < strings.size(); i++) {
            Car car = carService.findById(strings.get(i));
            cars.add(car);
        }
        return cars;
    }

    //根据分组查询车辆
//    @Override
//    public List<Car> getCarsGroupByGroup(String groupId) {
//     //   System.out.println(groupId);
////        List<Car> cars = groupRepository.findCarsGroupByGroup(groupId);
////        for (int i = 0; i < cars.size(); i++) {
////            System.out.print(cars.get(i) + " ");
////        }
//        return groupRepository.findCarsGroupByGroup(groupId);
//    }
//
//    //Test
//    @Override
//    public List<String> getCarGroupByGroup(String groupId) {
//       List<String> s = groupRepository.finddCarGroupByGroup(groupId);
//       List<Car> cars = new ArrayList<>();
//
//                for (int i = 0; i < s.size(); i++) {
//                    Car car = carService.findById(s.get(i));
//                    cars.add(car);
//           // System.out.print(s.get(i) + " ");
//        }
//
//        for (int i = 0; i < cars.size(); i++) {
//            System.out.print(cars.get(i).toString() + " ");
//        }
//
//        return null;
//    }

    //保存单个Group
    @Override
    public void saveGroup(Group group) {
        groupRepository.save(group);
    }
}
