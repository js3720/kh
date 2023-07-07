package edu.kh.op.ex;

import java.util.Scanner;

public class OpExample { // 예제 코드 작성용 클래스

    // -> OpExample이 가지고 있는 기능 중 ex1()이라는 메소드(기능)
    public void ex1(){
        System.out.println("OpExample 클래스에 ex1() 기능 수행");
        System.out.println("클래스에 분리 테스트");
        System.out.println("println 자동완성 해봤어요");
    }

    public void ex2(){
        Scanner sc = new Scanner(System.in);

        System.out.print("정수 입력 1 : ");
        int input1 = sc.nextInt();
        sc.nextLine();
        System.out.print("정수 입력 2 : ");
        int input2 = sc.nextInt();

        System.out.printf("%d / %d = %d\n", input1,input2,input1/input2);
        System.out.printf("%d %% %d = %d\n", input1,input2,input1%input2);
    }

    public void ex3(){
        // 증감(증가 혹은 감소) 연산자 : ++, --
        // -> 피연산자(값)를 1증가 또는 감소 시키는 연산자
        int iNum1 = 10;
        int iNum2 = 10;
        iNum1--;
        iNum2++;
        System.out.println("iNum1 : "+iNum1);
        System.out.println("iNum2 : "+iNum2);

        // 전위 연산 : 연산자가 앞쪽에 배치 (++3, --2)
        int temp1 = 5;
        System.out.println(++temp1 + 5);
        // temp1 = 5+1; 먼저 수행 후 6+5에 대한 값을 출력

        // 후위 연산 : 연산자가 뒤쪽에 배치 (10++, 6--)
        int temp2 = 3;
        System.out.println(temp2-- + 2);
        // 3+2에 대한 값을 출력 후 temp2 = 3-1;을 수행

        int a = 3;
        int b = 5;
        int c = a++ + --b; // 7
        System.out.printf("%d / %d / %d",a,b,c);
        //최종적으로 a=4, b=4, c=7
    }

    public void ex4(){
        // 비교 연산자 : > , < , >= , <= , == , !=
        // 결과는 항상 논리값(true / false)
        // 등호(=)가 포함된 연산자에서 등호는 항상 오른쪽
        // 대입연산자(=)와의 구분을 위해 비교연산자에서의 "같다"는 ==로 사용

        int a = 10;
        int b = 20;
        System.out.println(a > b); //false
        System.out.println(a < b); //true
        System.out.println(a != b);//true
        System.out.println((a == b) == false);//true

        int c = 4; // ->5
        int d = 5;
        System.out.println(c < d); //true
        System.out.println(c+1 <= d); //true
        System.out.println((++c != d) == (--c != d));
        // (++c != d) -> 5 != 5 : 5랑 5가 같지 않으면 true, 아니면 (false)
        // (--c != d) -> 4 != 5 : 4랑 5가 같지 않으면 (true), 아니면 False
        // false == ture -> flase랑 true가 같니? -> false

        int temp = 723;
        System.out.println("temp는 짝수인가? "+(temp %2 == 0));
        System.out.println("temp는 짝수인가? "+(temp %2 != 1));

        System.out.println("temp는 홀수인가? "+(temp %2 == 1));
        System.out.println("temp는 홀수인가? "+(temp %2 != 0));

        System.out.println("temp는 3의 배수인가? "+(temp %3 == 0));
        System.out.println("temp는 4의 배수인가? "+(temp %4 == 0));
        System.out.println("temp는 5의 배수인가? "+(temp %5 == 0));
    }

    public void ex5(){
        // 논리 연산자
        // & : 앰퍼센트, && = AND : 둘다 true면 true, 아니면 false
        // | : 버티칼바, || == OR : 둘중 하나라도 true면 true, 아니면 false

        int a = 100; // 100이상의 짝수인가?
        System.out.println(a>=100);
        System.out.println(a%2==0);
        System.out.println(a>=100 && a%2==0);

        int b = 5; // 1과 10 사이의 숫자인가?
        System.out.println(b>=1);
        System.out.println(b<=10);
        System.out.println(b>=1 && b<=10);

        int c = 10; // 10보다 크거나 짝수인가?
        System.out.println(c>10 || c%2==0);

    }

    public void ex6(){
        // 논리 부정 연산자 : !
        // 논리 값을 반대로 바꾸는 연산자

        boolean bool1 = true;
        boolean bool2 = !bool1;
        System.out.println("bool1 : "+ bool1);
        System.out.println("bool2 : "+ bool2);

        Scanner sc = new Scanner(System.in);

        System.out.print("정수 입력 : ");
        int input = sc.nextInt();

        boolean result1 = input>=1 && input<=100;
        System.out.printf("%d은/는 1 이상, 100이하의 정수인가? : %b\n",input,result1);

        boolean result2 = !(input>=1 && input<=100);
        boolean result3 = input<1 || input>100;
        System.out.printf("%d은/는 1 미만이거나 100 초과 정수인가? : %b, %b\n",input,result2,result3);
    }

    public void ex7(){
        // 복합 대입 연산자 : +=, -=, *=, /=, %=
        // 피연산자가 자신과 연산 후 결과를 다시 자신에게 대입
        int a = 10;
        a++;
        System.out.println("a를 1 증가 : "+a); //11
        a+=4;
        System.out.println("a를 4 증가 : "+a); //15
        a-=10;
        System.out.println("a를 10 감소 : "+a); //5
        a*=3;
        System.out.println("a를 3배 증가 : "+a); //15
        a/=6;
        System.out.println("a를 6으로 나눴을 때 몫 : "+a); //2
        a%=2;
        System.out.println("a를 2로 나눴을 때 나머지 : "+a); //0
    }

    public void ex8(){
        // 삼항 연산자 -> 조건식 ? 식1 : 식2
        // 조건식의 결과가 true면 식1, false면 식2를 수행
        // *조건식 : 연산 결과가 true / false인 식
        //          (비교, 논리, 논리부정 연산이 포함)

        int num = 30;
        // num이 30보다 크면(초과) : "num은 30보다 큰 수 이다."
        // 아니면                 : "num은 30이하의 수 이다." 출력
        String str1 = "num은 30보다 큰 수 이다.";
        String str2 = "num은 30이하의 수 이다.";
        String result = num>30 ? str1 : str2;
        System.out.println(result);

        Scanner sc = new Scanner(System.in);
        System.out.print("정수 입력 : ");
        int input = sc.nextInt();
        System.out.println((input >= 0 ? "양수" : "음수") + " 입니다.");
    }
}
