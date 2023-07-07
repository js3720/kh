package edu.kh.variable.ex2;

import java.util.Scanner;

public class ScannerExample3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // String(문자열)을 3번 입력받아 한 줄로 출력하기
        System.out.printf("입력 1 : ");
        String input1 = sc.next();
        System.out.printf("입력 2 : ");
        String input2 = sc.next();
        System.out.printf("입력 3 : ");
        String input3 = sc.next();
        // next() : 다음 입렧된 한 단어를 읽어온다

        System.out.printf("%s %s %s\n",input1,input2,input3);
    }
}
