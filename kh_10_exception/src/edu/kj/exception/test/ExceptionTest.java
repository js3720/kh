package edu.kj.exception.test;

import java.util.Scanner;

public class ExceptionTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while(true){
            System.out.print("정수 입력(0 입력 시 종료) : ");
            int input = sc.nextInt();
            // int a = 99.9; // 자료형이 맞지 않아 연산을 못해서 "컴파일 에러" (코드 틀림)
            if(input == 0) break;
        }

        // 런타임 에러 예제
        // 런타임 에러 : 프로그램 수행 중 발생하는 에러
        //              주로 if문으로 처리 가능

        int[] arr = new int[3];
        arr[0] = 10;
        arr[1] = 20;
        arr[2] = 30;
        if(arr.length>=3) System.out.println("배열의 범위를 초과했습니다.");
        else arr[3] = 40;
    }
}
