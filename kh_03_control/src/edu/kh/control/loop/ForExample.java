package edu.kh.control.loop;

import java.util.Scanner;

public class ForExample {
    /*
    for문 - 끝이 정해져 있는(횟수가 지정되어 있는) 반복문
    [작성법]
    for(초기식 ; 조건식 ; 증감식){
        반복 수행할 코드
    }
    - 초기식 : for문을 제어하는 용도의 변수 선언
    - 조건식 : for문의 반복 여부를 지정하는 식 (다음 반복 진행할지)
              보통 초기식에 사용된 변수를 이용하여 조건식을 작성함
    - 증감식 : 조기식에 사용된 변수를 for문이 끝날 때 마다 증가 또는 감소 시켜
              조건식에 결과를 변하게 하는 식
    */
    public void ex1(){
        /*
        for문 기초 사용법 1
        1~10 출력하기 (1부터 10까지 1씩 증가하며 출력)
         */
        for(int i=1 ; i<=10 ; i++){
            System.out.print(i+" ");
        }
    }

    public  void ex2(){
        /*
        for문 기초 사용법 2
        3에서 7까지 1씩 증가하며 출력
         */
        for(int i=3 ; i<=7 ; i++){
            System.out.print(i+" ");
        }
    }

    public void ex3(){
        // 2부터 15까지 1씩 증가하며 출력
        for(int i=2 ; i<=15 ; i++){
            System.out.print(i+" ");
        }
    }

    public void ex4(){
        // 1부터 입력받은 수 까지 1씩 증가하며 출력
        Scanner sc = new Scanner(System.in);
        System.out.print("끝 번호 : ");
        int input = sc.nextInt();

        for(int i=1 ; i<=input ; i++){
            System.out.print(i+" ");
        }
    }

    public void ex5(){
        // 1부터 입력받은 수 까지 2씩 증가하며 출력
        Scanner sc = new Scanner(System.in);
        System.out.print("끝 번호 : ");
        int input = sc.nextInt();

        for(int i=1 ; i<=input ; i+=2){
            System.out.print(i+" ");
        }
    }

    public void ex6(){
        // 1.0부터 입력받은 수 까지 0.5씩 증가하며 출력
        Scanner sc = new Scanner(System.in);
        System.out.print("끝나는 실수 : ");
        double input = sc.nextDouble();

        for(double i=1 ; i<=input ; i+=0.5){
            System.out.print(i+" ");
        }
    }

    public void ex7(){
        // A부터 Z까지 한줄로 출력
        for(char ch='A' ; ch<='Z' ; ch++){
            System.out.print(ch+" ");
        }
    }

    public void ex8(){
        // 10qnxj 1까지 1씩 감소하며 출력
        for(int i=10 ; i>=1; i--){
            System.out.print(i+" ");
        }
    }

    public void ex9(){
        // for문 응용 1 : 반복문을 이용한 값의 누적
        // 1부터 10까지의 합계
        int sum=0;
        for(int i=1; i<=10 ; i++){
            sum+=i;
        }
        System.out.println("합계 : "+sum);
    }

    public void ex10(){
        // for문 응용 2 : 정수 5개를 입력 받아서 합계 구하기
        // 정수 5개 입력 = 스캐너, 반복문 5번
        // 합계구하기 = 합계 값 넣어둘 변수 하나 선언

        Scanner sc = new Scanner(System.in);
        int sum = 0;
        for(int i=1; i<=5 ; i++){
            System.out.print("입력 "+i+" : ");
            int input = sc.nextInt();
            sum+=input;
        }
        System.out.println("합계 : "+sum);
    }

    public void ex11(){
        // 정수를 몇 번 입력 받을지 먼저 입력 받고
        // 입력된 정수의 합계를 출력
        Scanner sc = new Scanner(System.in);
        int sum=0;

        System.out.print("입력 받을 정수의 개수 : ");
        int maxNum = sc.nextInt();

        for(int i=1; i<=maxNum ; i++){
            System.out.print("입력 "+i+" : ");
//            int input = sc.nextInt(); // 입력받은 값을 input 변수에 저장하고
//            sum+=input;               // sum에다가 대입한뒤에 쓰지도 않는 앤데
//                                         굳이 메모리를 낭비해야 할까?
            sum += sc.nextInt();        // 한줄로 줄여버려도 되겠구나
        }
        System.out.println("합계 : "+sum);
    }

    public void ex12(){
        for(int i=1; i<=20; i++){
            if(i%5==0) System.out.print("("+i+") ");
            else System.out.print(i+" ");
        }
    }

    public void ex13(){
        // 1 부터 20까지 1씩 증가하면서 출력
        // 단, 입력 받은 수의 배수는 () 표시

        // ex)
        // 괄호를 표시할 배수 : 3
        // 1 2 (3) 4 5 (6) ...

        // 괄호를 표시할 배수 : 4
        // 1 2 3 (4) 5 6 7 (8) 9 ...
        Scanner sc = new Scanner(System.in);
        System.out.print("괄호를 표시할 배수 : ");
        int num = sc.nextInt();

        for(int i=1; i<=20; i++){
            if(i%num==0) System.out.print("("+i+") ");
            else System.out.print(i+" ");
        }

    }

    public void ex14() {
        // [구구단 출력]
        // 2 ~ 9 사이 수를 하나 입력 받아
        // 해당 단을 출력
        // 단, 입력 받은 수가 2 ~ 9 사이 숫자가 아니면 "잘못 입력 하셨습니다" 출력 --- 끝
        Scanner sc = new Scanner(System.in);
        System.out.print("2 ~ 9 사이의 수 입력 : ");
        int num = sc.nextInt();

        if(num<2 || num>9) System.out.println("잘못 입력 하셨습니다.");
        else{
            for(int i=1; i<=9; i++){
                System.out.printf("%d X %d = %d\n",num,i,num*i);
            }
        }
    }

    public void ex15(){
        // [19단 출력]
        // 2 ~ 19 사이 수를 하나 입력 받아서  X1 ~ X19까지 출력
        // 단, 입력 받은 수가 2 ~ 19 사이 숫자가 아니면 "잘못 입력 하셨습니다" 출력
        Scanner sc = new Scanner(System.in);
        System.out.print("2 ~ 19 사이의 수 입력 : ");
        int num = sc.nextInt();

        if(num<2 || num>19) System.out.println("잘못 입력 하셨습니다.");
        else{
            for(int i=1; i<=19; i++){
                System.out.printf("%d X %d = %d\n",num,i,num*i);
            }
        }
    }

    public void ex16(){
        // 중첩 반복문 - 구구단 모두 출력하기
        for(int i=2; i<=9; i++){
            for(int j=1; j<=9; j++){
                System.out.printf("%d X %d = %d\t",i,j,i*j);
            }
            System.out.println();
        }
    }

    public void ex17(){
        // 중첩 반복문 - 구구단 9단부터 2단까지 역발향으로 출력하기, 곱해지는 수는 1 -> 9 정방향
        for(int i=9; i>=2; i--){
            for(int j=1; j<=9; j++){
                System.out.printf("%d X %d = %d\t",i,j,i*j);
            }
            System.out.println();
        }
    }

    public void ex18(){
        // 중첩 반복문 - 12345를 5번 출력하기
        for(int i=1; i<=5; i++){
            for(int j=1; j<=5; j++){
                System.out.print(j);
            }
            System.out.println();
        }
        System.out.println("-----");
        for(int i=1; i<=3; i++){
            for(int j=5; j>=1; j--){
                System.out.print(j);
            }
            System.out.println();
        }
    }

    public void ex19(){
        // 2중 for문을 이용하여 다음 모양을 출력 하시오.
        // 1
        // 12
        // 123
        // 1234
        for(int i=1; i<=4; i++){
            for(int j=1; j<=i; j++){
                System.out.print(j);
            }
            System.out.println();
        }
        System.out.println("-----");
        // 4321
        // 321
        // 21
        // 1
        for(int i=4; i>=1; i--){
            for(int j=i; j>=1; j--){
                System.out.print(j);
            }
            System.out.println();
        }
    }

    public void ex20(){
        // 숫자 세기(count)
        int count = 0;                      // 3의 배수의 개수를 세기위한 변수
        for(int i=1; i<=20; i++){           // 1부터 20까지 1씩 증가하면서
            if(i%3==0){                     // 3의 배수이면
                System.out.print(i+" ");    // 출력하고
                count++;                    // 3의 배수 개수를 센다 ( 너 3의 배수네? 개수 +1 )
            }
        }
        System.out.println(" : "+ count + "개\n");// 3의 배수 개수 출력

        System.out.println("----------------");

        int sum = 0;                        // 3의 배수의 개수를 더하기위한 변수
        for(int i=1; i<=20; i++){           // 1부터 20까지 1씩 증가하면서
            if(i%3==0){                     // 3의 배수이면
                System.out.print(i+" ");    // 출력하고
                sum+=i;                     // 3의 배수 개수를 센다 ( 너 3의 배수네? 합계값 sum에 지금 값을 더해줘 )
            }
        }
        System.out.println("3의 배수의 합계 : "+ sum);
    }

    public void ex21(){
        // 2중 for문과 count를 이용해서 아래 모양 출력하기.
        int count = 0;
        for(int i= 1; i<=3; i++){
            for(int j=1; j<=4; j++){
                System.out.printf("%3d",++count);
            }
            System.out.println();
        }
    }

}
//    Scanner sc = new Scanner(System.in);
//    System.out.print("");
//    int num = sc.nextInt();