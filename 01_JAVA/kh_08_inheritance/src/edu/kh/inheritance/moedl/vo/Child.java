package edu.kh.inheritance.moedl.vo;

public class Child extends Parent{ // 자식 클래스
    // Parent 상속 중...

    @Override
    public void method(){
        System.out.println("오버라이딩 성공!!");
    }
}
