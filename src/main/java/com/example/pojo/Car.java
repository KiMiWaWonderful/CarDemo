package com.example.pojo;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "t_car")
public class Car implements Serializable {

    @Id
   // @GeneratedValue(strategy=GenerationType.IDENTITY)
    private String id;

    @Column(nullable = false)
    private String carType;

    @Column(nullable = false)
    private String carNumber;

    @Column(nullable = false)
    private String gpsNumber;

    @Column(nullable = false)
    private String carDriver;

    @Column(nullable = false)
    private String carGroup;

    @Lob
    @Column(nullable = true,columnDefinition = "TEXT")
    private String carDesc;

    @Column(nullable = false)
    private String carOverspeedSet;

    @Override
    public String toString() {
        return "Car{" +
                "id='" + id + '\'' +
                ", carType='" + carType + '\'' +
                ", carNumber='" + carNumber + '\'' +
                ", gpsNumber='" + gpsNumber + '\'' +
                ", carDriver='" + carDriver + '\'' +
                ", carGroup=" + carGroup +
                ", carDesc='" + carDesc + '\'' +
                ", carOverspeedSet='" + carOverspeedSet + '\'' +
                '}';
    }

    public Car(String carType, String carNumber, String gpsNumber, String carDriver, String carGroup, String carDesc, String carOverspeedSet) {
        this.carType = carType;
        this.carNumber = carNumber;
        this.gpsNumber = gpsNumber;
        this.carDriver = carDriver;
        this.carGroup = carGroup;
        this.carDesc = carDesc;
        this.carOverspeedSet = carOverspeedSet;
    }

    public Car() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }

    public String getCarNumber() {
        return carNumber;
    }

    public void setCarNumber(String carNumber) {
        this.carNumber = carNumber;
    }

    public String getGpsNumber() {
        return gpsNumber;
    }

    public void setGpsNumber(String gpsNumber) {
        this.gpsNumber = gpsNumber;
    }

    public String getCarDriver() {
        return carDriver;
    }

    public void setCarDriver(String carDriver) {
        this.carDriver = carDriver;
    }

    public String getCarGroup() {
        return carGroup;
    }

    public void setCarGroup(String carGroup) {
        this.carGroup = carGroup;
    }

    public String getCarDesc() {
        return carDesc;
    }

    public void setCarDesc(String carDesc) {
        this.carDesc = carDesc;
    }

    public String getCarOverspeedSet() {
        return carOverspeedSet;
    }

    public void setCarOverspeedSet(String carOverspeedSet) {
        this.carOverspeedSet = carOverspeedSet;
    }
}
