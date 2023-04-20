package edu.kh.control.practice;

import java.util.Scanner;

public class LoopPractice {
    public void practice1(){
        Scanner sc = new Scanner(System.in);
        System.out.print("1이상의 숫자를 입력하세요 : ");
        int maxNum = sc.nextInt();
        if(maxNum>=1) for(int i=1; i<=maxNum; i++) System.out.print(i+" ");
        else System.out.println("1 이상의 숫자를 입력해주세요.");
    }

    public void practice2(){
        Scanner sc = new Scanner(System.in);
        System.out.print("1이상의 숫자를 입력하세요 : ");
        int maxNum = sc.nextInt();
        if(maxNum>=1) for(int i=maxNum; i>=1; i--) System.out.print(i+" ");
        else System.out.println("1 이상의 숫자를 입력해주세요.");
    }

    public  void practice3(){
        Scanner sc = new Scanner(System.in);
        System.out.print("정수를 하나 입력하세요 : ");
        int num = sc.nextInt();
        int sum = 0;
        for(int i=1; i<=num; i++){
            sum += i;
            System.out.print(i);
            System.out.print(i!=num ? " + " : " = ");
        }
        System.out.println(sum);
    }

    public void practice4(){
        Scanner sc = new Scanner(System.in);
        System.out.print("첫 번째 숫자 : ");
        int num1 = sc.nextInt();
        System.out.print("두 번째 숫자 : ");
        int num2 = sc.nextInt();

        if(num1>=1 && num2>=1) {
            if(num1>=num2) for(int i=num2; i<=num1; i++) System.out.print(i+" ");
            else for(int i=num1; i<=num2; i++) System.out.print(i+" ");
        }
        else System.out.println("1 이상의 숫자를 입력해주세요.");
    }
}
