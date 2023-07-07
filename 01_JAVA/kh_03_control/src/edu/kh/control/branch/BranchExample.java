package edu.kh.control.branch;

import java.util.Random;
import java.util.Scanner;

public class BranchExample {
    public void ex1(){
        // 1부터 10까지 1씩 증가하며 출력하는 반복문 작성
        // 단, 5를 출력하면 반복문을 멈춤
        for(int i=1; i<=10; i++){
            System.out.println(i);
            if(i==5) break;
        }
    }

    public void ex2(){
        // 0이 입력될 때 까지의 모든 정수의 합 구하기
        Scanner sc = new Scanner(System.in);
        int input = 0;
        int sum = 0;
        // while문을 처음에 무조건 수행하고, 특정 조건에 종료하는 방법
        // 1) input에 초기값을 0이 아닌 다른 값
        //    while(input != 0)

        // 2) do-while문 사용

        // 3) 무한루프 상태의 while문을 만들고
        //    내부에 break 조건 작성
        while(true){
            System.out.print("정수 입력 : ");
            input = sc.nextInt();
            if(input==0) break; // 입력 받은 수가 0이면 종료
            else sum += input;
        }
        System.out.println("합계 : "+sum);
    }

    public void ex3(){
        // 입력받은 모든 문자열을 누적
        // 단, "exit@" 입력 시 문자열 누적을 종료하고 결과 출력
        Scanner sc = new Scanner(System.in);
        String str="";
        String temp;
        while(true){
            System.out.print("문자열 입력: ");
            temp = sc.nextLine();
            // if(temp == "exit@")
            // String자료형은 비교연산자(==)로 같은 문자열인지 판별할 수 없다.
            // 비교 연산자는 보통 기본 자료형 끼리의 연산에만 사용 가능하다.
            // -> String은 기본 자료형이 아닌 참조형

            // 해결방법 : 문자열1.equals(문자열2) 으로 비교 가능하다.
            if(temp.equals("exit@")) break;
            else str += temp+"\n";
        }
        System.out.println(str);
    }

    public void ex4(){
        // 중첩 반복문 내부에서 break 사용하기
        // 구구단 2~9단까지 모두 출력
        // 단, 2단은 x2까지, 3단은x3까지... 9단은 x9까지만 출력
        for(int i=2; i<=9; i++){
            for(int j=1; j<=9; j++){
                System.out.printf("%d X %d = %d\t",i,j,i*j);
                if(i == j) break;
                // 분기문이 중첩 반복문 내에서 사용되면
                // 가장 가까운 반복문에 작용한다.
            }
            System.out.println();
        }
    }

    public void ex5(){
        // break : 반복문을 바로 멈춤
        // continue : 다음 반복으로 넘어감
        // 1 ~ 10 까지 1씩 증가하며 출력
        // 단, 3의 배수는 제외
        for(int i=1; i<=10; i++){
            if(i%3==0) continue;
            System.out.print(i+" ");
        }
    }

    public void ex6(){
        // 1 ~ 100까지 1씩 증가하며 출력하는 반복문
        // 단, 5의 배수는 건너 뛰고
        // 증가하는 값이 40이 되었을 때 반복을 멈춤
        for(int i=1; i<=100; i++){
            if(i==40) break;
            if(i%5==0) continue;
            System.out.print(i+" ");
        }
    }

    public void RPSGame(){
        // 가위 바위 보 게임
        // 몇판? : 3

        // 1번째 게임
        // 가위/바위/보 중 하나를 입력 해주세요 :  가위
        // 컴퓨터는 [보]를 선택했습니다.
        // 플레이어 승!
        // 현재 기록 : 1승 0무 0패

        // 2번째 게임
        // 가위/바위/보 중 하나를 입력 해주세요 :  보
        // 컴퓨터는 [보]를 선택했습니다.
        // 비겼습니다.
        // 현재 기록 : 1승 1무 0패

        // 3번째 게임
        // 가위/바위/보 중 하나를 입력 해주세요 :  가위
        // 컴퓨터는 [바위]를 선택했습니다.
        // 졌습니다ㅠㅠ
        // 현재 기록 : 1승 1무 1패
        Scanner sc = new Scanner(System.in);
        String input, output;
        System.out.println("[가위 바위 보 게임]");
        System.out.print("몇 판? : ");
        int round = sc.nextInt();
        sc.nextLine();
        int s = 0;
        int m = 0;
        int p = 0;

        for(int i=1; i<=round; i++) {
            System.out.println("\n" + i + "번 째 게임");
            System.out.print("가위/바위/보 중 하나를 입력 해주세요 : ");
            input = sc.nextLine();

            int random = (int) (Math.random() * 3 + 1);
            String com;
            switch (random) {
                case 1: com = "가위"; break;
                case 2: com = "바위"; break;
                default: com = "보"; break;
            }
            System.out.printf("컴퓨터는 [%s]를 선택했습니다.\n", com);

            if(input.equals(com)) {
                System.out.println("비겼습니다.");
                m++;
            }
            else if(input.equals("가위") && com.equals("보") || input.equals("바위") && com.equals("가위") || input.equals("보") && com.equals("바위")) {
                System.out.println("플레이어 승 !");
                s++;
            }
            else {
                System.out.println("졌습니다ㅜㅜ");
                p++;
            }
            System.out.printf("현재 기록 : %d승 %d무 %d패\n", s,m,p);
        }
    }
}
