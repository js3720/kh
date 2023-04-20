package edu.kh.control.condition;

import java.util.Scanner;

public class SwitchExample {

    /* swith문 : 식 하나의 결과로 많은 경우의 수를 처리할 때 사용하는 조건문
        -식의 결과로 얻은 값과 같은 case 구문이 수행된다.

        [작성법]
        switch(식){
        case 결과값1 : 수행코드1; break;
        case 결과값2 : 수행코드2; break;
        case 결과값3 : 수행코드3; break;
        ...
        default : case를 모두 만족하지 않을 경우 수행하는 코드
        }
    */
    public void ex1(){
        // 키보드로 정수를 입력 받아
        // 1 이면 "빨강색"
        // 2 이면 "주황색"
        // 3 이면 "노란색"
        // 4 이면 "초록색"
        // 1~4 사이 숫자가 아니면 "흰색" 출력

        Scanner sc = new Scanner(System.in);
        System.out.print("정수 입력 : ");
        int input = sc.nextInt();
        String result;

//        if(input==1)  result="빨강색";
//        else if(input==2) result="주황색";
//        else if(input==3) result="노랑색";
//        else if(input==4) result="초록색";
//        else result="흰색";
//
//        if-else 문에서 switch-case 문으로 변환!
        switch(input){
            case 1 : result ="빨강색"; break;
            case 2 : result ="주황색"; break;
            case 3 : result ="노랑색"; break;
            case 4 : result ="초록색"; break;
            default : result ="흰색"; break;
        }
        System.out.println(result);
    }

    public void ex2(){
        Scanner sc = new Scanner(System.in);
        System.out.print("번호 입력 : ");
        int input = sc.nextInt();
        String team;

        switch(input % 4){// 더욱 다양한 경우를 처리하기 위해 계산식을 넣음
            case 1 : team = "백팀"; break;
            case 2 : team = "홍팀"; break;
            case 3 : team = "청팀"; break;
            default : team = "흑팀"; break;
        }
        System.out.println(team);
    }

    public void ex3(){
        Scanner sc = new Scanner(System.in);
        System.out.print("달(month) 입력 : ");
        int month = sc.nextInt();
        String season;

        switch(month){ // 동일한 결과를 내는 경우를 묶어줌으로서 코드를 줄일 수 있음
            case 3 : case 4 : case 5 : season = "봄"; break;
            case 6 : case 7 : case 8 : season = "여름"; break;
            case 9 : case 10 : case 11 : season = "가을"; break;
            case 12 : case 1 : case 2 : season = "겨울"; break;
            default : season = "잘못 입력"; break;
        }
        System.out.println(season);
    }

    public void ex4(){
        // 정수 2개와 연산자( + - * / % ) 입력 받아서 결과 출력
        Scanner sc = new Scanner(System.in);
        System.out.print("정수 1 입력 : ");
        int num1 = sc.nextInt();
        System.out.print("연산자 입력 : ");
        String op = sc.next(); // 스캐너는 문자 하나(char)를 입력 받는 기능이 별도로 없음.
        System.out.print("정수 2 입력 : ");
        int num2 = sc.nextInt();

        switch (op){
            case "+" : System.out.println(num1+op+num2+"="+(num1+num2)); break;
            case "-" : System.out.println(num1+op+num2+"="+(num1-num2)); break;
            case "*" : System.out.println(num1+op+num2+"="+(num1*num2)); break;
            case "/" :
                if(num2==0) System.out.println("0으로 나눌 수 없습니다.");
                else System.out.println(num1+op+num2+"="+(num1/num2));
                break;
            case "%" :
                if(num2==0) System.out.println("0으로 나눌 수 없습니다.");
                else System.out.println(num1+op+num2+"="+(num1%num2));
                break;
            default : System.out.println("존재하지 않는 연산자 입니다."); break;
        }
    }
}
