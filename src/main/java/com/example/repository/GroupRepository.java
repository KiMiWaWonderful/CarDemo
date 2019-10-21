package com.example.repository;

import com.example.pojo.Car;
import com.example.pojo.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface GroupRepository extends JpaRepository<Group,String> {

    //请求全部数据
    @Override
    List<Group> findAll();

    //根据ID查找分组
    @Override
    Optional<Group> findById(String s);

    //根据car的car_group（也就是group的ID）找到group的name，传入car的ID
    @Query(value = "select t_group.group_name from t_group inner join t_car on t_group.id = t_car.car_group where t_car.id = ?1",nativeQuery = true)
    String findGroupName(String carId);

    //根据分组查询车辆
//    @Query(value = "select t_car.id,t_car.car_type,t_car.car_number from t_car join t_group on t_car.car_group = t_group.id where t_group.id = ?1",nativeQuery = true)
//    List<Car> findCarsGroupByGroup(String groupId);
    @Query(value = "select t_car.id from t_car join t_group on t_car.car_group = t_group.id where t_group.id = ?1",nativeQuery = true)
    List<String> findCarsGroupByGroup(String groupId);

    //test
    @Query(value = "select t_car.id,t_car.car_type,t_car.car_number from t_car join t_group on t_car.car_group = t_group.id where t_group.id = ?1",nativeQuery = true)
    List<String> findCarGroupByGroup(String groupId);

    @Query(value = "select t_car.id from t_car join t_group on t_car.car_group = t_group.id where t_group.id = ?1",nativeQuery = true)
    List<String> finddCarGroupByGroup(String groupId);


    //@Query("select new Car() from  Car car inner join Group  gr")
}
