package edu.kh.variable.ex2;

import java.util.Scanner;

public class ScannerExample4
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("입력 1 : ");
        String input = sc.next() + " "; // 띄어쓰기 추가
        System.out.println(input);

        System.out.print("입력 2 : ");
        input = input + sc.next() + " "; // 기존 변수에 들어있는 "안녕 "을 먼저 더한 후 대입
        System.out.println(input);

        System.out.print("입력 3 : ");
        input = input + sc.next() + " "; // 누적효과 (재사용성)
        System.out.println(input);
    }
}
