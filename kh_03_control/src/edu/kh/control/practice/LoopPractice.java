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

    public void practice5(){
        Scanner sc = new Scanner(System.in);
        System.out.print("숫자 : ");
        int num = sc.nextInt();
        System.out.println("====="+num+"단=====");
        for(int i=1; i<=9; i++){
            System.out.printf("%d X %d = %d\n",num,i,num*i);
        }
    }

    public void practice6(){
        Scanner sc = new Scanner(System.in);
        System.out.print("숫자 : ");
        int num = sc.nextInt();
        if(num>=2 && num<=9){
            System.out.println("====="+num+"단=====");
            for(int i=1; i<=9; i++){
                System.out.printf("%d X %d = %d\n",num,i,num*i);
            }
        }
        else System.out.println("2~9 사이 숫자만 입력해주세요.");
    }

    public void practice7(){
        Scanner sc = new Scanner(System.in);
        System.out.print("정수 입력 : ");
        int num = sc.nextInt();
        for(int i=1; i<=num; i++){
            for(int j=1; j<=i; j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public void practice8(){
        Scanner sc = new Scanner(System.in);
        System.out.print("정수 입력 : ");
        int num = sc.nextInt();
        for(int i=num; i>=1; i--){
            for(int j=1; j<=i; j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
    public void practice9(){
        Scanner sc = new Scanner(System.in);
        System.out.print("정수 입력 : ");
        int num = sc.nextInt();
        for(int i=num; i>=1; i--){
            for(int j=1; j<=num; j++){
                if(j>=i) System.out.print("*");
                else System.out.print(" ");
            }
            System.out.println();
        }
    }
    public void practice10(){
        Scanner sc = new Scanner(System.in);
        System.out.print("정수 입력 : ");
        int num = sc.nextInt();
        for(int i=1; i<=num; i++){
            for(int j=1; j<=i; j++){
                System.out.print("*");
            }
            System.out.println();
        }
        for(int i=num; i>=1; i--){
            if(i==num) continue;
            for(int j=1; j<=i; j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public void practice11(){
        Scanner sc = new Scanner(System.in);
        System.out.print("정수 입력 : ");
        int num = sc.nextInt();
        int star = 1;
        int space = num;

        for(int i=1; i<=num; i++){
            for(int j=1; j<=space; j++){
                System.out.print(" ");
            }
            for(int j=1; j<=star; j++){
                System.out.print("*");
            }
            for(int j=1; j<=space; j++){
                System.out.print(" ");
            }
            star+=2;
            space--;
            System.out.println();
        }
    }
    public void practice12(){
        Scanner sc = new Scanner(System.in);
        System.out.print("정수 입력 : ");
        int num = sc.nextInt();

        for(int i=1; i<=num; i++){
            if(i==1 || i==num){
                for(int j=1; j<=num; j++) {
                    System.out.print("*");
                }
            }
            else{
                for(int j=1; j<=num; j++){
                    if(j==1 || j==num) System.out.print("*");
                    else System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

}
