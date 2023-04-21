package edu.kh.control.loop;

import java.util.Scanner;

public class WhileExample {
    /*
    while문
    - 별도의 초기식, 증감식이 존재하지 않고
      반복 종료 조건을 자유롭게 설정하는 반복문

      확실히 언제 반복이 끝날지는 모르지만
      언젠간 반복 조건이 false가 되는 경우 반복을 종료함

      [작성법]
      while(조건식){
        조건식이 ture일 때 반복 수행할 구문
      }
     */
    public void ex1(){
        Scanner sc = new Scanner(System.in);
        int input=0;
        while(input!=9){
            System.out.println("----------------");
            System.out.println("---- 메뉴선택 ----");
            System.out.println("1. 돈가스");
            System.out.println("2. 김치찌개");
            System.out.println("3. 삼겹살");
            System.out.println("9. 종료");

            System.out.print("메뉴 선택 >> ");
            input = sc.nextInt();

            switch (input){
                case 1 : System.out.println("돈가스를 주문했습니다"); break;
                case 2 : System.out.println("김치찌개를 주문했습니다"); break;
                case 3 : System.out.println("삼겹살을 주문했습니다"); break;
                case 9 : System.out.println("메뉴 선택을 종료합니다"); break;
                default : System.out.println("잘못 선택하셨습니다.."); break;
            }
        }
    }

    public void ex2(){
        // 입력되는 모든 정수의 합 구하기
        Scanner sc = new Scanner(System.in);
        int input = -1;
        int sum = 0;
        // input의 값이 0일 경우 while문이 수행되지 않고 끝난다.
        // 첫번 째 해결법
        // -0이 아닌 다른 값으로 초기화 해서 while문이 처음에 수행될 수 있도록 함
        while(input != 0){
            System.out.printf("정수 입력 : ");
            input = sc.nextInt();
            sum += input;
        }

        System.out.println("입력받은 값의 합계 :"+sum);
    }

    public void ex3(){
        // 입력되는 모든 정수의 합 구하기
        Scanner sc = new Scanner(System.in);
        int input = 0;
        int sum = 0;
        // 두번 째 해결법
        // do-while문 : 조건을 따지지 않고 무조건 처음 한번은 수행
        //              그 뒤부터 조건에 맞을 경우에만 반복 수행
        do{
            System.out.printf("정수 입력 : ");
            input = sc.nextInt();
            sum += input;
        }while(input!=0);

        System.out.println("입력받은 값의 합계 :"+sum);
    }

}
