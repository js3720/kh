package edu.kh.array.practice.service;

import javax.swing.text.Style;
import java.util.Arrays;
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

    public void practice4(){
        Scanner sc = new Scanner(System.in);
        int[] num = new int[5];
        boolean flag = false;

        for(int i=0; i<5; i++){
            System.out.printf("입력 %d : ",i);
            num[i]= sc.nextInt();
        }
        System.out.print("검색할 값 : ");
        int input = sc.nextInt();
        for(int i=0; i<5; i++){
            if(num[i]==input) System.out.println("인덱스 : "+i);
        }
        if(!flag) System.out.println("일치하는 값이 존재하지 않습니다.");
    }

    public void practice5(){
        Scanner sc = new Scanner(System.in);
        System.out.print("문자열 : ");
        String Str = sc.nextLine();
        char[] chArr = new char[Str.length()];
        for(int i=0; i<Str.length(); i++){
            chArr[i]=Str.charAt(i);
        }
        int count=0;

        System.out.print("문자 : ");
        char ch = sc.next().charAt(0);
        System.out.printf("application에 %c가 존재하는 위치(인덱스) : ",ch);
        for(int i=0; i<Str.length(); i++){
            if(chArr[i]==ch){
                System.out.print(i+" ");
                count++;
            }
        }
        System.out.printf("\n%c 개수 : %d\n",ch,count);
    }

    public void practice6(){
        Scanner sc = new Scanner(System.in);
        System.out.print("정수 : ");
        int input = sc.nextInt();
        int[] num = new int[input];
        int sum=0;
        for(int i=0; i<input; i++){
            System.out.printf("배열 %d번째 인덱스에 넣을 값 : ",i);
            num[i] = sc.nextInt();
            sum += num[i];
        }
        for(int i=0; i<input; i++){
            System.out.print(num[i]+" ");
        }
        System.out.println("\n총 합 : "+sum);
    }

    public void practice7(){
        Scanner sc = new Scanner(System.in);
        System.out.print("주민등록번호(-포함) : ");
        String str = sc.nextLine();
        for(int i=0; i<14; i++){
            System.out.print(i<8 ? str.charAt(i) : "*");
        }
    }





















































    // 문제4번 처음에 입력 0 1 2 3 4 하고 입력한 값으로 어떻게 넘어가야할 지 모르겠습니다,,

    public void prac4(){
        // 정수 5개를 입력받아 배열을 초기화하고
        // 검색할 정수를 하나 입력받아 배열에서 같은 수가 있는 인덱스를 찾아 출력.
        // 배열에 같은 수가 없을 경우 "일치하는 값이 존재하지 않습니다" 출력
        Scanner sc = new Scanner(System.in);

        int[] arr = new int[5]; //5칸짜리 방만 만들어줬어
        for(int i=0; i<arr.length; i++){  // 0 ~ 4 까지  5번
            System.out.printf("입력 %d : ",i);
            arr[i] = sc.nextInt();              // 몇번방에 입력받을 값을 넣어줄 지
        }

        // arr = {5,8,9,8,8}
        //int count=0; // 찾은게 없으니까 0입니다...        // count = 3;
        System.out.print("검색할 값 : ");
        int input = sc.nextInt();        // input : 8
        System.out.print("인덱스 : ");
        for(int i=0; i<arr.length; i++){ // 0~4 까지 반복
            if(arr[i] == input){   //arr[4] == 8 ?
                System.out.print(i+" ");
                //count++;
            }
        }
        //System.out.println("\n총 일치하는 값 : "+count+"개 입니다");
        // 인덱스 : 1 3 4
    }














}
