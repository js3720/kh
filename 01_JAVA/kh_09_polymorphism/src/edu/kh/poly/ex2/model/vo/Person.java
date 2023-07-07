package edu.kh.poly.ex2.model.vo;

public class Person extends Animal {
    // Animal의 추상 메소드를 오버라이딩 하지 않으면 오류 발생

    private String name;

    public Person(){}
    public Person(String type, String eatType, String name) {
        super(type, eatType);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString(){
        return "Person : "+super.toString()+" / "+name;
    }

    @Override
    public void eat() {
        System.out.println("숟가락, 젓가락, 나이프, 포크 등을 이용해서 먹는다.");
    }

    @Override
    public void breath() {
        System.out.println("코와 입으로 숨을 쉰다.");
    }
}
