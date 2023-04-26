package edu.kh.array2.practice;

import java.util.Scanner;
import java.util.Arrays;
import java.util.Random;

public class Array2Practice {
    public void practice1(){
        String[][] strArr = new String[3][3];
        for(int row=0; row<strArr.length; row++){           // 행길이 만큼의 반복 0,1,2
            for(int col=0; col<strArr[row].length; col++){  // 열길이 만큼의 반복 0,1,2
                strArr[row][col] = "("+row+", "+col+")";    // "(0, 0)" 과 같은 형식으로 저장
                System.out.print(strArr[row][col]);
            }
            System.out.println();
        }
    }

    public void practice2(){
        int[][] intArr = new int[4][4];
        int num = 1;
        for(int row=0; row<intArr.length; row++){
            for(int col=0; col<intArr[row].length; col++){
                intArr[row][col] = num++;
                System.out.printf("%3d",intArr[row][col]);
            }
            System.out.println();
        }
    }

    public void practice3(){
        int[][] intArr = new int[4][4];
        int num = intArr.length * intArr[0].length;
        for(int row=0; row<intArr.length; row++){
            for(int col=0; col<intArr[row].length; col++){
                intArr[row][col] = num--;
                System.out.printf("%3d",intArr[row][col]);
            }
            System.out.println();
        }
    }

    public void practice4(){
        int[][] intArr = new int[4][4];
        int[] rowSum = new int[4];
        int[] colSum = new int[4];
        int totalSum = 0;
        for(int row=0; row<intArr.length; row++){
            for(int col=0; col<intArr[row].length; col++){
                if(row<intArr[row].length-1) {                          // 마지막행이 아니고
                    if(col!=intArr[row].length-1){                      // 마지막 열이 아닐 때
                        intArr[row][col] = (int)((Math.random()*10)+1);
                        rowSum[col] += intArr[row][col];
                        colSum[row] += intArr[row][col];
                    }
                    else{                                               // 마지막 열일 때
                        intArr[row][col] = colSum[row];
                        totalSum += intArr[row][col];
                    }
                }
                else{                                                   // 마지막 행이고
                    if(col!=intArr[row].length-1){                      // 마지막 열이 아닐 때
                        intArr[row][col] = rowSum[col];
                        totalSum += intArr[row][col];
                    }
                    else{                                               // 마지막 열일 때
                        intArr[row][col] = totalSum;
                    }
                }
                System.out.printf("%4d",intArr[row][col]);              // 배열의 요소값 출력
            }
            System.out.println();
        }
    }

    public void practice5(){
        Scanner sc = new Scanner(System.in);
        int input1,input2;
        while(true){
            System.out.print("행 크기 : ");
            input1 = sc.nextInt();
            System.out.print("열 크기 : ");
            input2 = sc.nextInt();
            if((input1>0 && input1<=10) && (input2>0 && input2<=10)) break;
            else System.out.println("반드시 1~10 사이의 정수를 입력해야 합니다.");
        }
        char[][] chArr = new char[input1][input2];
        for(int row=0; row<chArr.length; row++){
            for(int col=0; col<chArr[row].length; col++){
                chArr[row][col] = (char)((int)(Math.random()*26)+'A');
                System.out.printf("%3c",chArr[row][col]);
            }
            System.out.println();
        }
    }

    public void practice6(){
        Scanner sc = new Scanner(System.in);
        System.out.print("행 크기 : ");
        int input1 = sc.nextInt();
        char[][] chArr = new char[input1][];
        char ch = 'a';
        for(int row=0; row<input1; row++){
            System.out.print(row+"열의 크기 : ");
            int input2 = sc.nextInt();
            chArr[row] = new char[input2];
        }
        for(int row=0; row<chArr.length; row++){
            for(int col=0; col<chArr[row].length; col++){
                chArr[row][col] = ch++;
                System.out.print(chArr[row][col]+" ");
            }
            System.out.println();
        }
    }



}
