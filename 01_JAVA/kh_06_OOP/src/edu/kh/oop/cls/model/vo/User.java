package edu.kh.oop.cls.model.vo;

public class User {
    // 속성(==필드)

    // 아이디, 비밀번호, 이름, 나이, 성별 (추상화 진행)
    private String userId;
    private String userPw;
    private String userName;
    private int userAge;
    private char userGender;

    // 기능(==생성자 + 메소드)


    // 생성자 : new 연산자를 통해서 객체를 생성할 때
    //         생성된 객체의 필드 값 초기화 + 지정된 기능을 수행하는 역할

    public User(){
        System.out.println("기본 생성자로 User 객체 생성");
        userId = "user01";
        userPw = "password";
        userName = "홍길동";
        userAge = 20;
        userGender = '남';
    }

    public User(String userId, String userPw){
        System.out.println("매개변수 생성자를 이용해서 User 객체 생성");
        this.userId = userId;
        this.userPw = userPw;
    }

    public User(String userId, String userPw, String userName, int userAge, char userGender){

        // 전달 받은 값을 필드에 초기화(this 참조 변수)

        // ** this 참조 변수 **
        // - 객체가 자기 자신을 참조할 수 있도록 하는 변수
        // - 모든 객체 내부에 숨겨져 있다.
        // 왜 사용하는가 ??
        // -> 필드명과 매개변수명이 같을 경우 이를 구분하기 위해서 주로 사용

        this(userId,userPw); // this() 생성자
        // - 같은 클래스의 다른 생성자를 호출할 때 사용
        // - 생성자 내에서 반드시 첫 번째 줄에 작성되어야 한다
        // 왜 사용 하는가? 붕복 코드 제거, 코드 길이 감소, 재사용성 증가
        // (가동성이 안좋아지는 경우가 생길 수 있어서 많이 사용되진 않음)

        //this.userId = userId;
        //this.userPw = userPw;
        this.userName = userName;
        this.userAge = userAge;
        this.userGender = userGender;
    }

    // 자바는 기본적으로 필드명, 생성자명, 메소드명, 변수명의 중복을 허용하지 않는다.

    /*
    private String userId; // Duplicate field User.userId
    public User(){} // Duplicate method User() in type User
    public String getUserId(){} // Duplicate method User() in type User
    public void ex(){
        int num = 10;
        int num = 10; // Duplicate local variable num
    }
     */
    // *** 오버로딩(Over Loading) ***
    // - 클래스 내에서 동일한 이름의 메소드(생성자 포함)를 여러 개 작성하는 기법
    // --> 하나의 이름으로 여러 기능을 수행할 수 있게 하는 것
    // [오버로딩 조건]
    // 1. 메소드(생성자 포함)의 이름이 동일
    // 2. 매개변순의 개수, 타입, 순서 중 1개라도 달라야 한다

    // public User(){} // 기본 생성자가 이미 작성되어 있어서 중복
    public User(String userId){} // 매개변수 개수가 같은 생성자 없음 -> 오버로딩 성립
    public User(int userAge){} // 매개변수 개수는 같지만 타입이 다름 -> 오버로딩 성립
    public User(int userAge, String userId){} // 매개변수 개수는 같지만 타입이 다름 -> 오버로딩 성립
    public User(String userId, int userAge){} // 매개변수 개수와 타입은 같지만 순서가 다름 -> 오버로딩 성립

    public User(String UserId, String userPw, String userName){}
    //public User(String userName, String userId, String userPW){}
    // 매개변수의 개수, 타입, 순서가 모두 같아서 오버로딩 불가
    // -> 순서를 따질 때 변수명은 신경쓰지 않는다!!


    // 캡슐화로 인한 간접 접근 기능(getter / setter)
    public void setUserId(String userId) {
        this.userId = userId;
    }
    public void setUserPw(String userPw) {
        this.userPw = userPw;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public void setUserAge(int userAge) {
        this.userAge = userAge;
    }
    public void setUserGender(char userGender) {this.userGender = userGender;}
    public String getUserId() {
        return userId;
    }
    public String getUserPw() {
        return userPw;
    }
    public String getUserName() {
        return userName;
    }
    public int getUserAge() {
        return userAge;
    }
    public char getUserGender() {
        return userGender;
    }
}
