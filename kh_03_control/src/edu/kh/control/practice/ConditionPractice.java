package edu.kh.control.practice;

import java.util.Scanner;

public class ConditionPractice {
    public void practice1(){
        Scanner sc = new Scanner(System.in);
        System.out.print("숫자를 한 개 입력하세요 : ");
        int input = sc.nextInt();
        if(input<0) System.out.println("양수만 입력해주세요.");
        else{
            if(input%2==0) System.out.println("짝수입니다.");
            else System.out.println("홀수입니다.");
        }
    }

    public void practice2(){
        Scanner sc = new Scanner(System.in);
        System.out.print("국어점수 : ");
        int kor = sc.nextInt();
        System.out.print("수학어점수 : ");
        int math = sc.nextInt();
        System.out.print("영어점수 : ");
        int eng = sc.nextInt();

        System.out.println("합계 : " + (kor+math+eng));
        System.out.println("평균 : " + (kor+math+eng)/3.0);

        if(kor>=40 && math>=40 && eng>=40 && (kor+math+eng)/3>=60){
            System.out.println("축하합니다, 합격입니다!");
        }
        else System.out.println("불합격입니다.");
    }

    public void practice3(){
        Scanner sc = new Scanner(System.in);
        System.out.print("1~12 사이의 정수 입력 : ");
        int month = sc.nextInt();
        int maxDay;
        if(month>=1 && month<=12){
            switch(month){
                case 1 : case 3 : case 5 : case 7 : case 8 : case 10 : case 12 : maxDay=31; break;
                default : maxDay=30; break;
            }
            System.out.println(month+"월은"+maxDay+"까지 있습니다.");
        }
        else System.out.println(month+"월은 잘못 입력된 달입니다.");
    }

    public void practice4(){
        Scanner sc = new Scanner(System.in);
        System.out.print("키(m)를 입력해 주세요 : ");
        double height = sc.nextDouble();
        System.out.print("몸무게(kg)를 입력해 주세요 : ");
        double weight = sc.nextDouble();

        double bmi = weight/(height*height);
        System.out.println("BMI 지수 : "+bmi);

        if(bmi < 18.5) System.out.println("저체중");
        else if(bmi>=18.5 && bmi<23) System.out.println("정상체중");
        else if(bmi>=23 && bmi<25) System.out.println("과체중");
        else if(bmi>=25 && bmi<30) System.out.println("비만");
        else System.out.println("고도 비만");
    }

    public void practice5(){
        Scanner sc = new Scanner(System.in);
        System.out.print("중간고사 : ");
        int midterm = sc.nextInt();
        System.out.print("기말고사 : ");
        int finals = sc.nextInt();
        System.out.print("과제점수 : ");
        int assignment = sc.nextInt();
        System.out.print("출석횟수 : ");
        int attendance = sc.nextInt();
        double sum = midterm*0.2 + finals*0.3 + assignment*0.3 + attendance;

        System.out.println("========== 결과 ==========");
        if(attendance<15) System.out.printf("Fail [출석 횟수 부족 (%d/20)]\n",attendance);
        else{
            System.out.printf("중간 고사 점수(20) : %.1f\n", midterm*0.2);
            System.out.printf("중간 고사 점수(30) : %.1f\n", finals*0.3);
            System.out.printf("과제 점수\t(30) : %.1f\n", assignment*0.3);
            System.out.printf("출석 점수\t(20) : %.1f\n", (double)attendance);
            System.out.printf("총점 : %.1f\n", sum);

            if(sum<70) System.out.println("Fail [점수 미달]");
            else System.out.println("Pass");
        }
    }
}
