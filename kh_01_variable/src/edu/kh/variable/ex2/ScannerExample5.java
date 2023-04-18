package edu.kh.variable.ex2;

import java.util.Scanner;

public class ScannerExample5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.printf("한 문장 입력 : ");
        String str1 = sc.nextLine(); // nextLine() : 한 문장 (엔터를 만나면 입력 종료)을 입력받음
        System.out.println(str1);

        System.out.printf("한 단어 입력 : ");
        String str2 = sc.next(); // next() : 한 단어(띄어쓰기, 엔터를 만나면 입력 종료)를 입력받음
        System.out.println(str2);

        // 스캐너 입력 버퍼와 nextXXX의 의미
        // 입력 -> 입력 버퍼에 저장 -> nextXXX()통해 버퍼 내용을 읽어옴

        //                     입력버퍼            nextXXX()        후처리
        // nextLine()   : hello world(엔터) -> hello world(엔터) -> 엔터제거
        // nextINT()    :     100(엔터)           100
        // next(), nextDouble(), nextInt() 등
        // 모두 입력 버퍼에서 엔터를 제외하고 내용만 읽어옴

        System.out.print("nextInt() : ");
        int a = sc.nextInt();

        // nextXXX()수행 시 입력버퍼에서 엔터를 제외한 내용만 가져오기 때문에
        // 연속적인 입력을 받을 경우, 다음 nextXXX() 수행 시 버퍼에 남아있는 (엔터)를 읽고 바로 종료가 된다.
        // 해결법 -> 다음 입력을 수행하기 전 빈 공간에 nextLine();을 한번 작성하여 입력버퍼에 남아있는 (엔터)제거.
        sc.nextLine(); // 입력버퍼에 남아있는 엔터를 날려줌

        System.out.print("nextLine() : ");
        String s = sc.nextLine();

        System.out.println("종료");

    }
}
