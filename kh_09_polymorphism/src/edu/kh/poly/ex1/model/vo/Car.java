package edu.kh.poly.ex1.model.vo;

public class Car {
    private String engine;
    private String fuel;
    private int wheel;

    public Car() { // 기본 생성자
        super(); // 부모생성자(Object) -> 안적어주어도 컴파일러가 자동으로 수행하기 때문에 생략 가능
    }

    public Car(String engine, String fuel, int wheel) {
        super();
        this.engine = engine;
        this.fuel = fuel;
        this.wheel = wheel;
    }

    public String getEngine() {return engine;}
    public void setEngine(String engine) {this.engine = engine;}

    public String getFuel() {return fuel;}
    public void setFuel(String fuel) {this.fuel = fuel;}

    public int getWheel() {return wheel;}
    public void setWheel(int wheel) {this.wheel = wheel;}
}
