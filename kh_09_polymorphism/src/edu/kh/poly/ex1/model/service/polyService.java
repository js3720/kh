package edu.kh.poly.ex1.model.service;

import edu.kh.poly.ex1.model.vo.Car;
import edu.kh.poly.ex1.model.vo.Tesla;

public class polyService {
    public void ex1(){
        // 다형성 확인 예제

        Car car = new Car();
        // 부모타입 참조변수 = 부모 객체;
        Tesla tesla = new Tesla();
        // 자식타입 참조변수 = 자식 객체

        Car car2 = new Tesla();

    }
}
