package edu.kh.array.practice.service;

import java.util.Scanner;

public class PracticeService {

    public void practice1(){
        int[] num = new int[9];
        int sum = 0;
        for(int i=0; i<9; i++){
            num[i] = i+1;
            System.out.print(num[i] +" ");
            if(i%2==0) sum+=num[i];
        }
        System.out.println("\n짝수 번째 인덱스 합 : "+sum);
    }

    public void practice2(){
        int[] num = new int[9];
        int sum = 0;
        for(int i=0; i<9; i++){
            num[i] = num.length-i;
            System.out.print(num[i] +" ");
            if(i%2==1) sum+=num[i];
        }
        System.out.println("\n홀수 번째 인덱스 합 : "+sum);
    }

    public void practice3(){
        Scanner sc = new Scanner(System.in);
        System.out.print("양의 정수 : ");
        int input = sc.nextInt();
        int[] num = new int[input];
        for(int i=0; i<input; i++){
            num[i]=i+1;
            System.out.print(num[i]+" ");
        }
    }

}
