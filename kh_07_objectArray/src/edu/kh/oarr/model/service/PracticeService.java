package edu.kh.oarr.model.service;

import edu.kh.oarr.model.vo.Student;

import java.util.Scanner;

public class PracticeService {
    Scanner sc = new Scanner(System.in);

    public void start(){
        Student[] std = new Student[10];
        int index = 0;
        String anser = "";

        while(true){
            System.out.print("학년 : ");
            int grade = sc.nextInt();
            System.out.print("반 : ");
            int classroom = sc.nextInt();
            sc.nextLine();
            System.out.print("이름 : ");
            String name = sc.nextLine();
            System.out.print("국어점수 : ");
            int kor = sc.nextInt();
            System.out.print("영어점수 : ");
            int eng = sc.nextInt();
            System.out.print("수학점수 : ");
            int math = sc.nextInt();
            sc.nextLine();
            std[index++] = new Student(grade,classroom,name,kor,eng,math);

            while(true){
                if(index<10){
                    System.out.print("계속 입력 하시겠습니까 ? (y/n) :");
                    anser = sc.nextLine();
                }
                if(index==10 || anser.equals("n") || anser.equals("N")){
                    for(int i=0; i<index; i++){
                        System.out.println(std[i]);
                    }
                    return;
                }
                else if(anser.equals("y") || anser.equals("Y")){
                    System.out.println();
                    break;
                }
                else System.out.println("잘못 입력하셨습니다. 다시 입력해 주세요");
            }
        }
    }
}
