package edu.kh.control.condition;

import java.util.Scanner;

public class ConditionExample {

    public void ex1(){
        // if문 : 조건식이 true일 때만 내부 코드 수행.
        /* [작성법]
        if(조건식){
            조건식이 true일 때 수행할 코드
        }
        */
        Scanner sc = new Scanner(System.in);
        System.out.print("정수 입력 : ");
        int input = sc.nextInt();

        if(input > 0){
            System.out.println("양수 입니다.");
        }
        if(input <= 0){
            System.out.println("양수가 아닙니다.");
        }
    }

    public void ex2(){
        // if-else문 : 조건식이 true이면 if문을 수행, false이면 else구문 수행
        /* [작성법]
        if(조건식){
            조건식이 true일 때 수행할 코드
        }
        else{
            조건식이 false일 때 수행할 코드
        }
        */
        Scanner sc = new Scanner(System.in);
        System.out.print("정수 입력 : ");
        int input = sc.nextInt();

        if(input%2!=0) {
            System.out.println("홀수 입니다.");
        }
        else if(input==0){
            System.out.println("0 입니다.");
        }
        else{
            System.out.println("짝수 입니다.");
        }
    }

    public void ex3(){
        Scanner sc = new Scanner(System.in);
        System.out.print("정수 입력 : ");
        int input = sc.nextInt();

        if(input >0){
            System.out.println("양수 입니다.");
        }
        else if( input <0){
            System.out.println("음수 입니다.");
        }
        else{
            System.out.println("0 입니다.");
        }
        // if = 만약에 이 조건이면
        // else if = 그게 아니고 이 조건이면
        // else = 그게 아니면
    }
    public void ex4(){
        // 달(month)을 입력 받아 해당 달에 맞는 계절 출력
        Scanner sc = new Scanner(System.in);
        System.out.print("정수 입력 : ");
        int input = sc.nextInt();
        String season; // 아래 조건문 수행 결과를 저장할 변수 선언

        if(input>=3 && input<=5){                   // 3,4,5
            season = "봄 입니다.";
        }
        else if(input>=6 && input<=8){              // 6,7,8
            season ="여름 입니다.";
        }
        else if(input>=9 && input<=11){             // 9,10,11
            season ="가을 입니다.";
        }
        else if(input==12 || input==1 || input==2){ // 12,1,2
            season ="겨울 입니다.";
        }
        else{ // if, else if가 모두 false인 경우 수행
            season ="해당하는 계절이 없습니다.";
        }
        System.out.println(season);
    }
    public void ex5(){
        Scanner sc = new Scanner(System.in);
        System.out.print("나이 입력 : ");
        int age = sc.nextInt();

        if(age<=13){
            System.out.println("어린이 입니다.");
        }
        else if(age<=19){
            System.out.println("청소년 입니다.");
        }
        else{
            System.out.println("성인 입니다.");
        }
    }

    public void ex6(){
        // 점수(100점 만점)를 입력 받아
        // 90점 이상 : A
        // 80점 이상 90점 미만 : B
        // 70점 이상 80점 미만 : C
        // 60점 이상 70점 미만 : D
        // 60점 미만 : F
        // 0점 미만, 100 초과 : "잘못 입력하셨습니다"
        Scanner sc = new Scanner(System.in);
        System.out.print("점수 입력(0~100) : ");
        int score = sc.nextInt();
        String result;

        if(score < 0 || score > 100) result="잘못 입력하셨습니다.";
        else if(score >= 90) result="A";
        else if(score >= 80) result="B";
        else if(score >= 70) result="C";
        else if(score >= 60) result="D";
        else result="F";
        System.out.println(result);
    }

    public void ex7(){
        // 놀이기구 탑승 제한 검사
        // 나이가 12세 이상, 키 140.0cm 이상 일 경우에만 "탑승 가능"
        // 나이가 12미만인 경우 : "적정 연령이 아닙니다."
        // 키가 140.0cm 미만 : "적정 키가 아닙니다."
        // 나이를 0세 미만, 100세 초과 시 : "잘못 입력 하셨습니다."
        Scanner sc = new Scanner(System.in);
        System.out.print("나이 입력 : ");
        int age = sc.nextInt();
//        sc.nextLine();
//        System.out.print("키 입력 : ");
//        Double hight = sc.nextDouble();
        String result;

//        if(age<0 || age>100) result="잘못 입력 하셨습니다.";
//        else if(age < 12) result="적정 연령이 아닙니다.";
//        else if(hight < 140) result="적정 키가 아닙니다.";
//        else result="탑승 가능";

//        if(age<0 || age>100){                               // 0~100 안의 숫자가 아닐경우 끝
//            result="잘못 입력 하셨습니다.";
//        }
//        else{
//            if(age < 12) result="적정 연령이 아닙니다.";       // 0~100 안의 숫자일 경우 12살 미만이면 끝
//            else{                                           // 12살 이상일 경우에
//                if(hight < 140.00){                         // 키가 140 미만이면 끝
//                    result= "적정 키가 아닙니다.";
//                }
//                else{                                       // 숫자도 정상적으로 입력했고, 12살이상 키 140이상인 친구들만 남음
//                    result = "탑승 가능";
//                }
//            }
//        }

        if(age<0 || age>100){
            result="잘못 입력 하셨습니다.";
        }
        else{
            System.out.print("키 입력 : ");
            Double hight = sc.nextDouble();

            if(age < 12) result="적정 연령이 아닙니다.";
            else if(hight < 140.00){
                result="적정 키가 아닙니다.";
            }
            else{
                result="탑승 가능";
            }
        }
        System.out.println(result);

    }
    public void ex8(){
        // 놀이기구 탑승 제한 검사 프로그램
        // 조건 - 나이 : 12세 이상
        //     -  키 : 140.0cm 이상

        // 나이를 0~100세 사이로 입력하지 않은 경우 : "나이를 잘못 입력 하셨습니다."
        // 키를 0~250.0cm 사이로 입력하지 않은 경우 : "키를 잘못 입력 하셨습니다."
        // -> 입력이 되자 마자 검사를 진행하여 잘못된 경우 프로그램 종료

        // 나이 O , 키 X : "나이는 적절하나, 키가 적절치 않음";
        // 나이 X , 키 O : "키는 적절하나, 나이는 적절치 않음";
        // 나이 X , 키 X : "나이와 키 모두 적절치 않음";
        // 나이 O , 키 O : "탑승 가능"
        Scanner sc = new Scanner(System.in);
        String result;
        System.out.print("나이 입력 : ");
        int age = sc.nextInt();

        if(age<0 || age>100){
            result = "나이를 잘못 입력하셨습니다";
        }
        else{
            System.out.print("키 입력 : ");
            double height = sc.nextDouble();

            if(height<0 || height>250.0){
                result="키를 잘못 입력 하셨습니다.";
            }
            else{
                if(age<12 && height>=140.0){ // 키0 나이X
                    result="키는 적절하나 나이는 적절치 않음";
                }
                else if(age>=12 && height<140.0){ // 키X, 나이O
                    result="나이는 적절하나 키가 적절치 않음";
                }
                else if(age<12 && height<140.0){ // 키X, 나이X
                    result="나이와 키 모두 적절치 않음";
                }
                else{ // 키O, 나이O
                    result="탑승 가능";
                }
            }
        }
        System.out.println(result);
    }

}
