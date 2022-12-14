package com.itvillage.chapter04.chapter0401;

import com.itvillage.common.Car;
import com.itvillage.common.CarFilter;
import com.itvillage.common.CarMaker;
import com.itvillage.common.CarType;

import java.util.Arrays;
import java.util.List;

/**
 * java.util.function에 내장된 Predicate를 사용하는 예제
 */
public class _5_BuiltinFunctionalInterfaceExample {
    public static void main(String[] args) {

        List<Car> cars = Arrays.asList(
                new Car(CarMaker.HYUNDAE, CarType.SUV, "팰리세이드", 28000000, true),
                new Car(CarMaker.SAMSUNG, CarType.SEDAN, "SM5", 35000000, true),
                new Car(CarMaker.CHEVROLET, CarType.SUV, "트래버스", 50000000, true),
                new Car(CarMaker.KIA, CarType.SEDAN, "K5", 20000000, false),
                new Car(CarMaker.SSANGYOUNG, CarType.SUV, "티볼리", 23000000, true)
        );

        List<Car> carsFilteredByPrice =
                CarFilter.filterCarByBuiltinPredicate(cars, car -> car.getCarPrice() > 30000000);

        for(Car car : carsFilteredByPrice)
            System.out.println("차 이름: " + car.getCarName() + ", 가격: " + car.getCarPrice());

        List<Car> carsFilteredByCarType =
                CarFilter.filterCarByBuiltinPredicate(cars, car -> car.getCarType().equals(CarType.SUV));

        for(Car car : carsFilteredByCarType)
            System.out.println("차 이름: " + car.getCarName() + ", 차종: " + car.getCarType());
    }
}
