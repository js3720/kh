package edu.kh.collection.model.vo;

import java.util.Objects;

public class Member {
    private String id;
    private String pw;
    private int age;

    public Member() {
    }

    public Member(String id, String pw, int age) {
        this.id = id;
        this.pw = pw;
        this.age = age;
    }

    public String getId() {return id;}
    public void setId(String id) {this.id = id;}

    public String getPw() {return pw;}
    public void setPw(String pw) {this.pw = pw;}

    public int getAge() {return age;}
    public void setAge(int age) {this.age = age;}

    @Override
    public String toString() {
        return "Member{" + "id='" + id + '\'' + ", pw='" + pw + '\'' + ", age=" + age + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Member member = (Member) o;
        return age == member.age && Objects.equals(id, member.id) && Objects.equals(pw, member.pw);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, pw, age);
    }
//    @Override
//    public boolean equals(Object obj) {
//        Member other = (Member)obj;
//        return this.id.equals(other.id) && this.pw.equals(other.pw) && this.age==other.age;
//    }
//    @Override
//    public int hashCode() {
//        // 필드 값이 같은 객체는 같은 정수를 반환해야 한다.
//        // == 필드 값을 이용해서 정수를 만들면 된다.
//
//        final int PRIME = 31; // 31이 연산속도가 빠른 소수 중 하나
//        // 소수
//        int result = 1; // 결과 저장 변수
//
//        result = result * PRIME * age;   // 25 jsk 123123   // 25 jsk 123124
//
//        result += result * PRIME * ( id==null? 0: id.hashCode() );
//
//        result += result * PRIME * ( pw==null? 0: pw.hashCode() );
//
//        return result;
//    }
}