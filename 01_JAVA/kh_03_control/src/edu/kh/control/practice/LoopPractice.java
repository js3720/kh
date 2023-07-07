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
        //   *      첫번 째 반복할 때 (4)번째 별
        //  **      두번 째 반복할 때 (3),4번째 별
        // ***      세번 째 반복할 때 (2),3,4번째 별
        //****      네번 째 반복할 때 (1),2,3,4번째 별
        for(int i=num; i>=1; i--){      //i = 4부터 1까지 -1씩
            for(int j=1; j<=num; j++){  //만약에 i보다 크거나같으면 별, 아니면 공백 출력
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
        for(int i=num-1; i>=1; i--){
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
        int space = num-1;

        for(int i=1; i<=num; i++){
            for(int j=1; j<=space; j++){
                System.out.print(" ");
            }
            for(int j=1; j<=star; j++){
                System.out.print("*");
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
            for(int j=1; j<=num; j++){
                if(i==1 || i==num || j==1 || j==num){             // 첫번 째 low 혹은 마지막 low 이거나,
                    System.out.print("*");                        // 첫번 째 col 혹은 마지막 col 이면, "*" 출력
                }
                else System.out.print(" ");                       // 아니면 " " 출력
            }
            System.out.println();
        }
//        설명용
//        for(int i=1; i<=num; i++){
//            if(i==1 || i==num){                                 // 첫번 째 줄이랑 마지막 줄은 *로 꽉 채움
//                for(int j=1; j<=num; j++) {
//                    System.out.print("*");
//                }
//            }
//            else{                                               // 첫번 째랑 마지막 줄이 아니면
//                for(int j=1; j<=num; j++){
//                    if(j==1 || j==num) System.out.print("*");   // 첫번 째 출력이랑 마지막 출력은 *로
//                    else System.out.print(" ");                 // 나머지 출력은 " "으로
//                }
//            }
//            System.out.println();
//        }
    }
    public void practice13(){
        //                                      int count = 0;
        // 1부터 ~ 사용자에게 입력받은 수까지 중에서  // for(int i=1; i<iput; i++){
        // 1) 2와 3의 배수를 모두 출력하고          // if(i%2==0 || i%3==0) System.out.print(i);
        // 2) 2와 3의 공배수의 개수를 출력하세요.     // if(i%2==0 && i%3==0) count++;
        Scanner sc = new Scanner(System.in);
        System.out.print("자연수 하나를 입력하세요 : ");
        int num = sc.nextInt();
        int count=0;

        for(int i=1; i<=num; i++){
            if(i%2==0 || i%3==0) System.out.print(i + " "); // 2 또는 3의 배수일 경우
            if(i%2==0 && i%3==0) count++;                   // 2와 3의 공배수일 경우
        }
        System.out.println("\ncount : "+count);
    }
}
