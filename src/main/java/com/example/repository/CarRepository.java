package com.example.repository;

import com.example.pojo.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CarRepository extends JpaRepository<Car, String> {

    //请求全部数据
    @Override
    List<Car> findAll();

    //根据ID查询某辆车的详情
    @Override
    Optional<Car> findById(String id);


    //Car findById(Integer id);

    //根据ID删除车辆
    @Override
    void deleteById(String id);

    @Override
    <S extends Car> S save(S s);

    //根据车牌号码或者车型搜索车辆
   //或者只拿ID，在service层再生成对应的对象
//    @Query(value = "select t_car.car_number,t_car.car_type from t_car where t_car.car_type like '%?1%' or t_car.car_number like '%?1%'",nativeQuery = true)
    @Query(value = "select t_car.id from t_car where t_car.car_type like %?1% or t_car.car_number like %?1%",nativeQuery = true)
//    List<Car> findByCarsLike(String input);
    List<String> findByCarsLike(String input);
    //根据车型搜索车辆

}
