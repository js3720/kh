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
        userId = "Id";
        userPw = "password";
        userName = "이름";
        userAge = 0;
        userGender = 'X';
    }

    public User(String userId, String userPw, String userName, int userAge, char userGender){
        System.out.println("매개변수 생성자를 이용해서 User 객체 생성");

        // 전달 받은 값을 필드에 초기화(this 참조 변수)
        this.userId = userId;
        this.userPw = userPw;
        this.userName = userName;
        this.userAge = userAge;
        this.userGender = userGender;
    }


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
    public void setUserGender(char userGender) {
        this.userGender = userGender;
    }
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
