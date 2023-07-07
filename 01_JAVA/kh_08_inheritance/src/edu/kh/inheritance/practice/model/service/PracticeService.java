package edu.kh.inheritance.practice.model.service;
import edu.kh.inheritance.practice.model.vo.Employee;
import edu.kh.inheritance.practice.model.vo.Student;

import java.util.Scanner;

public class PracticeService {
    private Scanner sc = new Scanner(System.in);
    public void homework(){
        Student[] std = new Student[3];
        std[0] = new Student("카리나",20,168.2,70.0,1,"정보시스템공학과");
        std[1] = new Student("정해인",21,187.3,80.0,2,"경영학과");
        std[2] = new Student("박서준",23,179.0,45.0,4,"정보통신학과");
        for(Student s : std){
            System.out.println(s);
        }
        int empCount = 0;
        char ch =' ';
        Employee[] emp = new Employee[10];
        while (true){
            System.out.print("이름 : ");
            String name = sc.nextLine();
            System.out.print("나이 : ");
            int age = sc.nextInt();
            System.out.print("신장 : ");
            double height = sc.nextDouble();
            System.out.print("몸무게 : ");
            double weight = sc.nextDouble();
            System.out.print("급여 : ");
            int salary = sc.nextInt();
            sc.nextLine();
            System.out.print("부서 : ");
            String dept = sc.nextLine();
            emp[empCount++] = new Employee(name,age,height,weight,salary,dept);
            while(true){
                if(empCount<10){
                    System.out.print("계속 추가 하시겠습니까? (y/n)");
                    ch = sc.nextLine().toUpperCase().charAt(0);
                }
                if(empCount==10 || ch=='N'){
                    for(Employee e : emp){
                        if(e != null) System.out.println(e);
                        else break;
                    }
                    return;
                }
                else if(ch=='Y') break;
                else System.out.println("잘못 입력하셨습니다. 다시 입력 해주세요");
            }
        }
    }
}
