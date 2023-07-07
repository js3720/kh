package edu.kh.op.practice;

import java.util.Scanner;

public class OpPractice {
    public void practice1(){
        Scanner sc = new Scanner(System.in);
        System.out.print("인원 수 : ");
        int Human = sc.nextInt();
        System.out.print("사탕 개수 : ");
        int candy = sc.nextInt();

        System.out.println("\n1인당 사탕 개수 : " + candy/Human);
        System.out.println("남은 사탕 개수 : " + candy%Human);
    }

    public void practice2(){
        Scanner sc = new Scanner(System.in);
        System.out.print("이름 : ");
        String name = sc.next();
        System.out.print("학년(정수) : ");
        int grade = sc.nextInt();
        System.out.print("반(정수) : ");
        int studentClass = sc.nextInt();
        System.out.print("번호(정수) : ");
        int studentNum = sc.nextInt();
        System.out.print("성별(남학생/여학생) : ");
        String gender = sc.next();
        System.out.print("성적(소수점 아래 둘째 자리까지) : ");
        double score = sc.nextDouble();

        System.out.printf("\n%d학년 %d반 %d번 %s %s의 성적은 %.2f점 입니다.\n",
                grade,studentClass,studentNum,name,gender,score);
    }

    public void practice3(){
        Scanner sc = new Scanner(System.in);
        System.out.print("정수 입력 : ");
        int input = sc.nextInt();

        if(input%2==0) System.out.println("짝수 입니다.");
        else System.out.println("홀수 입니다.");
    }

    public void practice4(){
        Scanner sc = new Scanner(System.in);
        System.out.print("국어 : ");
        int kor = sc.nextInt();
        System.out.print("영어 : ");
        int eng = sc.nextInt();
        System.out.print("수학 : ");
        int math = sc.nextInt();

        System.out.println("\n합계 : " + (kor+eng+math));
        System.out.println("평균 : " + (kor+eng+math)/3.0);

        if(kor>=40 && eng>=40 && math>=40 && (kor+eng+math)/3>=60) System.out.println("합격");
        else System.out.println("불합격");
    }
}