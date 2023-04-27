package edu.kh.oop.abstraction.model.vo;

// VO (Value Object) : 값 저장용 객체를 만들기 위한 클래스를 모아두는 패키지

public class People { // 국민(사람) 클래스
    // 클래스란? 객체의 특성(속성, 기능)을 정의한 것
    // == 객체를 만들기 위한 설계도
    
    // 캡슐화(encapsulation)
    // - 데이터와 기능을 하나로 묶어서 관리하는 기법
    // - 데이터의 직접적인 접근을 제한 하는 것이 원칙이다.
    //   -> 직접 접근을 못하기 때문에 클래스 내부에 
    //      간접 접근 방법을 제공하는 기능을 작성해둔다.
    
    // ***데이터 직접 접근 제한***
    // public(공공의) -> private(사적인, 개인적인) 변경
    
    // 속성 == 값 == data
    // 값을 저장하기 위한 변수 선언
    // -> 국민이라면 공통적으로 가지고있는 속성만 작성(추상화)
    private String name;
    private char gender;
    private String pNo;
    private String address;
    private String phone;
    private int age;
    //double bitCoin; // 공통점이 아니므로 제거

    // 기능 == 행동 == method
    public void tax(){
        System.out.println("세금을 냅니다.");
    }
    public void vote(){
        System.out.println("투표를 합니다");
    }

    public void setName(String name){
        // 외부로부터 전달받은 name을 현재 객체의 속성 중에 있는 name에 대입한다.
        this.name = name;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public void setpNo(String pNo) {
        this.pNo = pNo;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName(){
        // 현재 객체의 속성 중 name을 호출한 곳으로 반환(return)
        return this.name;
    }

    public char getGender() {
        return gender;
    }

    public String getpNo() {
        return pNo;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public int getAge() {
        return age;
    }
}
