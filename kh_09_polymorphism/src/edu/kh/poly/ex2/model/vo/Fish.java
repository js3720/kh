package edu.kh.poly.ex2.model.vo;

public class Fish extends Animal{

    public Fish() {}

    public Fish(String type, String eatType) {
        super(type, eatType);
    }

    @Override
    public String toString() {
        return "Fish : "+super.toString();
    }

    @Override
    public void eat() {
        System.out.println("입을 뻐끔 뻐끔 거리면서 먹는다");
    }

    @Override
    public void breath() {
        System.out.println("아가미 호흡을 한다.");
    }
}
