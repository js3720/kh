package edu.kh.array2.ex;

import java.util.Arrays;

public class Array2Example {
    /*
        2차원 배열
        - 자료형이 같은 1차원 배열을 묶음으로 다루는 것
        -> 행, 열 개념 추가
         */
    public void ex1(){
        // 2차원 배열 선언
        int[][] arr1;
        // int 자료형 2차원 배열을 참조하는 참조 변수 선언
        // 참조형 == 참조 변수 == 레퍼 런스변수 == 레퍼런스)

        // 2차원 배열 할당
        // -> new 자료형[행크기][열크기];
        arr1 = new int[2][3];
        // heap 영역에 int 2차원배열 2행 3열 공간을 할당

        // 2차원 배열 초기화
        // 1) 행, 열 인덱스를 이용해서 직접 초기화
        arr1[0][0] = 10;
        arr1[0][1] = 20;
        arr1[0][2] = 30;
        arr1[1][0] = 40;
        arr1[1][1] = 50;
        arr1[1][2] = 60;

        // 참조하고 있는 1차원 배열 값을 문자열로 반환
        System.out.println(Arrays.toString(arr1));
        // 참조하고 있는 배열의 데이터가 나오는 부분까지 파고 들어가서 모든 값을 문자열로 반환한다.
        System.out.println("arr1의 값 :"+Arrays.deepToString(arr1));
        // 2) 2중 for문을 이용한 초기화
        int[][] arr2 = new int[2][3];
        int num = 10;
        for(int row=0; row<arr2.length; row++){
            for(int col=0; col<arr2[row].length; col++){
                arr2[row][col] = num;
                num += 10;
            }
        }
        System.out.println("arr2의 값 :"+Arrays.deepToString(arr2));
    }

    public void ex2(){
        // 2차원 배열 선언과 동시에 초기화
        // 3행 3열짜리 정수형 2차원 배열 선언과 동시에 1~9까지 초기화
        int[][] arr = { {1,2,3},
                        {4,5,6},
                        {7,8,9}};
        int[] rowSum = new int[arr.length];
        // 행 별로 합 출력
        for(int row=0; row<arr.length; row++){
            for(int col=0; col<arr[row].length; col++){
                rowSum[row] += arr[row][col];
            }
            System.out.printf("%d행의 합계 : %d\n",row,rowSum[row]);
        }
        System.out.println("--------------");

        int[] colSum = new int[arr[0].length];
        // 열 별로 합 출력
        int totalSum=0;
        // 배열 전체 합 출력
        for(int col=0; col<arr.length; col++){
            for(int row=0; row<arr[col].length; row++){
                colSum[col] += arr[row][col];
            }
            totalSum += colSum[col];
            System.out.printf("%d열의 합계 : %d\n",col,colSum[col]);
        }

        System.out.println("\n전체 합계 : "+totalSum);
    }

    public void ex3(){
        // 가변 배열
        // 2차원 배열 생성 시 마지막 배열 차수(열)를 지정하지 않고
        // ((나중에)) 서로 크기가 다른 1차원 배열을 생성하여 참조하는 배열
        char[][] arr = new char[4][]; // char 2차원 배열 생성 시 행 부분만 생성

        arr[0] = new char[3];
        arr[1] = new char[4];
        arr[2] = new char[5];
        arr[3] = new char[2];
        char ch = 'a';
        for(int row=0; row<arr.length; row++){ //0부터 행길이만큼 반복
            for(int col=0; col<arr[row].length; col++){// 0부터 열길이만큼 반복
                arr[row][col] = ch++;
            }
        }
        System.out.println(Arrays.deepToString(arr));
    }
}
