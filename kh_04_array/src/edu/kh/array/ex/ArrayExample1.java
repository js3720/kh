package edu.kh.array.ex;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayExample1 {
    /*
    배열(Array)
    같은 자료형의 변수를 하나의 묶음으로 다루는 것 (자료구조)
    묶여진 변수들은 하나의 배열명으로 불러지고
    구분은 index를 이용한다 (index는 0부터 시작하는 정수)
     */
    public void ex1(){
        // 변수 vs 배열

        // 1-1. 변수 선언
        int num;
        // Stack 영역에 int 자료형을 저장 할 수 있는 공간 4byte를  생성(할당)하고
        // 그 공간에 num 이라는 이름을 부여한다
        // 1-2. 변수 대입

        num = 10;
        // 생성된 num이라는 변수 공간에 10을 대입

        // 1-3 변수 사용
        System.out.println("num에 저장된 값 : "+num);
        //num이 작성된 자리에 num에 저장된 값을 읽어와서 출력

        // 2-1 배열 선언
        int[] arr;
        // Stack 영역에 int[] (int배열) 자료형 공간을 8byte 할당하고
        // 그 공간에 arr이라는 이름을 부여한다.
        // 해당 변수(int[])는 참조형으로, 주소값(8byte)만을 저장할 수 있다.

        // 2-2 배열 할당
        arr = new int[3];
        // new : "new 연산자" 라고 하며
        //       Heap 메모리 영역에 새로운 공간(배열, 객체)을 할당한다.
        // int[3] : int 자료형 변수 3개를 하나의 묶음으로 나타내는 배열
        // new int[3] : heap영역에 int 3칸짜리 int[]을 생성(할당)
        //              생성된 int[]에는 시작 주소가 지정된다!!
        // arr = new int[];
        // (int[])  (int[]) 같은 자료형 == 연산가능
        // heap 영역에 생성된 int[]의 시작 주소를
        // stack 영역에 생성된 arr 변수에 대입
        // -> arr변수가 int[]을 참조학세됨!
        // 그래서 arr을 참조형 이라고 한다.

        // 2-3. 배열 요소 값 대입
        // arr은 int[] 참조형 변수 이지만
        // arr[index]는 int형 변수이기 때문에 정수 값을 대입할 수 있다.
        arr[0] = 10;
        arr[1] = 20;
        arr[2] = 30;
        System.out.println("arr 배열의 값 : "+Arrays.toString(arr));
    }

    public void ex2(){
        int[] arr = new int[4];
        // 1) stack 영역에 int[] 자료형 참조형 변수 arr 선언
        // 2) heap 영역에 int 자료형 4래를 묶음으로 다루는 int[] 할당
        // 3) 생성된 int[]의 주소를 arr에 대입하여 참조하는 형태를 만든다.

        // 배열의 길이(몇 칸 인가) : 배열명.length
        System.out.println("배열의 길이 : "+arr.length);
        arr[0] = 100;
        arr[1] = 200;
        arr[2] = 500;
        arr[3] = 1000;

        for(int i=0; i<arr.length; i++){
            System.out.printf("arr[%d]에 저장된 값 : %d\n",i,arr[i]);
        }
    }

    public void ex3(){
        // 5명의 키(cm)를 입력 받고 평균 구하기

        // 1번 키 입력 : 170.5
        // 2번 키 입력 : 165.7
        // 3번 키 입력 : 184.3
        // 4번 키 입력 : 190.2
        // 5번 키 입력 : 174.4

        // 입력 받은 키 : 170.5  165.7  184.3  190.2  174.4
        // 평균 : 177.02cm
        Scanner sc = new Scanner(System.in);
        double[] heightArr = new double[5];
        double sum = 0;
        for(int i=0; i<heightArr.length; i++){
            System.out.print(i+1+"번 키 입력 : ");
            heightArr[i] = sc.nextDouble();
            sum += heightArr[i];
        }
        System.out.printf("입력 받은 키 : %.1f\t%.1f\t%.1f\t%.1f\t%.1f\n",heightArr[0],heightArr[1],heightArr[2],heightArr[3],heightArr[4]);
        System.out.printf("평균 : %.2fcm\n",sum/heightArr.length);
    }
    public void ex4(){
        // 입력 받은 인원 수 만큼의 점수를 입력 받아 배열에 저장
        // 입력이 완료되면 점수 합계, 평균, 최고점, 최저점 출력

        // ex)
        // 입력 받을 인원 수 : 4
        // 1번 점수 입력 : 100
        // 2번 점수 입력 : 80
        // 3번 점수 입력 : 50
        // 4번 점수 입력 : 60

        // 합계 : 290
        // 평균 : 72.50
        // 최고점 : 100
        // 최저점 : 50

        Scanner sc = new Scanner(System.in);
        System.out.print("입력 받을 인원 수 : ");
        int input = sc.nextInt();
        int[] score = new int[input]; // 입력받은 숫자만큼의 배열 할당
        int sum = 0;
        int max = 0;
        int min = 0;
        for(int i=0; i<score.length; i++){
            System.out.print((i+1)+"번 점수 입력 : ");
            score[i] = sc.nextInt();
            sum += score[i];
            if(i==0){
                max = score[i];
                min = score[i];
            }
            else{
                max = max < score[i] ? score[i] : max;
                min = min > score[i] ? score[i] : min;
            }
        }
        System.out.println("합계 : "+sum);
        System.out.printf("평균 : %.2f\n",(double)sum/score.length);
        System.out.println("최고점 : "+max);
        System.out.println("최저점 : "+min);
    }

    public void ex5(){
        // 배열 선언과 동시에 초기화
        char[] arr = new char[5];
        // char[] arr이 참조하는 배열 요소에 A, B, C, D, E 대입하기

        for(int i=0; i<arr.length; i++){
            arr[i] = (char)('A' + i);
        }
        System.out.println(Arrays.toString(arr));

        // 배열 선언과 동시에 (할당 및) 초기화
        char[] arr2 = {'A','B','C','D','E'};
        // char[] 참조변수 arr2를 선언하고
        // heap 영역에 5칸짜리 char[]을 생성하고
        // 각각 'A','B','C','D','E'로 초기화 후 주소를 arr2에 대입한다.
        // {} (중괄호)는 배열의 리터럴 표기법
        System.out.println("arr3 길이 : "+arr2.length);
        System.out.println(Arrays.toString(arr2));
    }
}
