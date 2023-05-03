package edu.kh.inheritance.moedl.service;

import edu.kh.inheritance.moedl.vo.Employee;
import edu.kh.inheritance.moedl.vo.Person;
import edu.kh.inheritance.moedl.vo.Student;

import java.util.Scanner;

public class InheritanceService {

    public  void ex1(){
        // 상속 확인
        // - Person을 상속 받은 Student가 Person의 필드, 메소드를 사용할 수 있는가?

        Person p = new Person();
        p.setName("홍길동");
        p.setAge(25);
        p.setNationality("대한민국");

        System.out.printf("이름 : %s\n나이 : %d\n국적 : %s\n",p.getName(),p.getAge(),p.getNationality());
        System.out.println("--------------------------------");

        // Student 객체 생성
        Student std = new Student();
        // Student만의 고유한 메소드
        std.setGrade(3);
        std.setClassRoom(5);
        // Person 클래스로부터 상속받은 메소드
        std.setName("고아라");
        std.setAge(19);
        std.setNationality("대한민국");

        System.out.printf("%d학년 %d반\n이름 : %s\n나이 : %d\n국적 : %s\n",std.getGrade(),std.getClassRoom(),std.getName(),std.getAge(),std.getNationality());
        System.out.println("--------------------------------");

        // Employee 객체 생성
        Employee emp = new Employee();
        // Employee만의 고유한 메소드
        emp.setCompany("KH정보교육원");
        // Person 클래스로부터 상속 받은 메소드
        emp.setName("다나카");
        emp.setAge(35);
        emp.setNationality("일본");

        System.out.printf("소속 : %s\n이름 : %s\n나이 : %d\n국적 : %s\n",emp.getCompany(),emp.getName(),emp.getAge(),emp.getNationality());
        System.out.println("--------------------------------");

        // 추가된 breath() 메소드 확인하기
        p.breath();
        std.breath();
        emp.breath();
    }
    public void ex2(){
        // super() 생성자 사용 방법

        // Student 매개변수 5개 짜리 생성자
        Student std = new Student("김종수",28,"대한민국",2,8);
        System.out.printf("%d학년 %d반\n이름 : %s\n나이 : %d\n국적 : %s\n",std.getGrade(),std.getClassRoom(),std.getName(),std.getAge(),std.getNationality());
    }
    public void ex3(){
        // 오버라이딩 확인 예제
        Student std = new Student();
        Employee emp = new Employee();
        std.move(); // 오버라이딩 X -> Person의 메소드 수행
        emp.move(); // 오버라이딩 O -> Employee의 메소드 수행
    }
    public void ex4(){
        // 모든 클래스는 object 클래스의 후손이다. == 모든 클래스의 최상의 부모는 object 클래스다
        Person p = new Person(); // Object를 상속 받은 Person 객체를 생성
        Student std = new Student(); // Person을 상속 받은 Student 객체를 생성
        Scanner sc = new Scanner(System.in);
        String str = "abc";

        System.out.println(p.hashCode()); // Object에서 물려 받은 hashcode()
        System.out.println(std.getAge()); // Person에서 물려 받은 getAge()
        System.out.println(std.hashCode()); // Person이 Object에서 물려받은 hashcode를 student가 또 물려 받아 사용
        // 상속의 상속의  상속의 ... 상속 가능

        System.out.println(sc.hashCode());
        // Object - hashCode()
        System.out.println(str.hashCode());
        // String - hashCode()
    }
    public void ex5(){
        Person p = new Person("이동휘",28,"한국");
        System.out.println(p.toString());
        System.out.println(p);
        // print 구문 수행 시 참조 변수명을 작성하면 자동으로 toString()메소드를 호출해서 출력한다.
        System.out.println("------------------------");
        Student std = new Student("윈터",27,"미국",2,6);
        System.out.println(std.toString());
        System.out.println(std);
        // 1) Student 클래스 toString() 오버라이딩 전
        // Person으로부터 상속 받은 오버라이딩 된 toString() 수행

        // 2) Student 클래스 toString() 오버라이딩 후
        // Student의 toString()수행

        Employee emp = new Employee("김근로",26,"한국","00증권");
        System.out.println(emp);
    }
}
