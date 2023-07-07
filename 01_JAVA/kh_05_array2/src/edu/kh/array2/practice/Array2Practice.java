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
        int num = intArr.length * intArr[0].length; // 행*열 -> 총 인덱스 개수 (현재 4*4 = 16)
        for(int row=0; row<intArr.length; row++){
            for(int col=0; col<intArr[row].length; col++){
                intArr[row][col] = num--;
                System.out.printf("%3d",intArr[row][col]);
            }
            System.out.println();
        }
    }

    public void practice4(){
        int[][] arr = new int[4][4];
        // 상수 사용법 : 변하지 않는 특정 값에 이름을 붙여줌
        final int ROW_LAST_INDEX = arr.length-1;        //행 마지막 인덱스
        final int COL_LAST_INDEX = arr[0].length-1;     //열 마지막 인덱스

        for(int row=0; row<=ROW_LAST_INDEX; row++){
            for(int col=0; col<=COL_LAST_INDEX; col++){
                // 마지막 행, 마지막 열이 아닌 경우
                if(row != ROW_LAST_INDEX && col != COL_LAST_INDEX){
                    int random = (int)(Math.random()*10+1);
                    arr[row][col] = random;
                    // 각 행의 마지막 열에 난수를 누적
                    arr[row][COL_LAST_INDEX] += arr[row][col];
                    // 각 행의 마지막 행에 난수를 누적
                    arr[ROW_LAST_INDEX][col] += arr[row][col];
                    // 생성된 모든 난수를 마지막 행, 마지막 열에 누적
                    arr[ROW_LAST_INDEX][COL_LAST_INDEX] += arr[row][col];
                }
//                else if(!(row==ROW_LAST_INDEX && col==COL_LAST_INDEX)) {
//                    arr[ROW_LAST_INDEX][COL_LAST_INDEX] += arr[row][col];
//                }
                System.out.printf("%4d",arr[row][col]);
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
            if((input1>0 && input1<=10) && (input2>0 && input2<=10)) {
                char[][] chArr = new char[input1][input2];
                for(int row=0; row<chArr.length; row++){
                    for(int col=0; col<chArr[row].length; col++){
                        chArr[row][col] = (char)((int)(Math.random()*26)+'A');
                        System.out.printf("%3c",chArr[row][col]);
                    }
                    System.out.println();
                }
            }
            else System.out.println("반드시 1~10 사이의 정수를 입력해야 합니다.");
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

    public void homeWork() {    // 문제 4번 출력결과랑 동일하게 나와야하는데 뭐가 문제인지 해결하기

        int[][] arr = new int[4][4];
        int rowsum = arr.length-1;                          // 3
        int colsum = arr[0].length -1;                      // 3
        for(int row=0; row<arr.length; row++) {             // row 0,1,2,3
            for(int col=0; col<arr[row].length; col++) {    // col 0,1,2,3
                if(!(row==rowsum || col==colsum)){          // 행 또는 열이 마지막인덱스가 아닐 경우에만 돌아가게 해줌 ----
                    arr[row][col] = (int)(Math.random()*10+1);  // arr[0][0] = 1~10 랜덤값
                    arr[rowsum][col] += arr[row][col];          // arr[3][0] += arr[0][0]
                    arr[row][colsum] += arr[row][col];          // arr[0][3] += arr[0][0]
                    arr[rowsum][colsum] += arr[row][col];        // arr[3][3] = arr[0][0]     +=로 바꿔줌----
                }
                System.out.printf("%3d" , arr[row][col] );  // 현재 요소 값 출력
            }
            System.out.println();
        }
    }

    public void practice7(){
        String[] students = {"강건강", "남나나", "도대담", "류라라", "문미미", "박보배","송성실", "윤예의", "진재주", "차천축", "피풍표", "홍하하"};
        int index = 0;
        String[][] str1 = new String[3][2];
        String[][] str2 = new String[3][2];
        for(int num=0; num<2; num++){
            System.out.println(num==0 ? "== 1분단 ==" : "== 2분단 ==");
            for(int i=0; i<3; i++){
                for(int j=0; j<2; j++){
                    if(num==0){
                        str1[i][j] = students[index++];
                        System.out.print(str1[i][j]+" ");
                    }
                    else{
                        str2[i][j] = students[index++];
                        System.out.print(str2[i][j]+" ");
                    }
                }
                System.out.println();
            }
        }
    }

    public void practice8(){
        String[] students = {"강건강", "남나나", "도대담", "류라라", "문미미", "박보배","송성실", "윤예의", "진재주", "차천축", "피풍표", "홍하하"};
        int index = 0;
        String[][][] str = new String [2][3][2];
        for(int num=0; num<2; num++){
            System.out.println(num==0 ? "== 1분단 ==" : "== 2분단 ==");
            for(int i=0; i<3; i++){
                for(int j=0; j<2; j++){
                    str[num][i][j] = students[index++];
                    System.out.print(str[num][i][j]+" ");
                }
                System.out.println();
            }
        }
        System.out.println("==========================");
        Scanner sc = new Scanner(System.in);
        System.out.print("검색할 학생 이름을 입력하세요 : ");
        String input = sc.next();
        for(int num=0; num<2; num++){
            for(int i=0; i<3; i++){
                for(int j=0; j<2; j++){
                    if(str[num][i][j].equals(input)){
                        System.out.printf("검색하신 %s 학생은 %d분단 %d번째 줄 %s에 있습니다.",input,num+1,i+1,j==0 ? "왼쪽" : "오른쪽");
                    }
                }
            }
        }
    }

    public void practice9(){
        Scanner sc = new Scanner(System.in);
        String[][] arr = new String[6][6];
        System.out.print("행 인덱스 입력 : ");
        int row = sc.nextInt();
        System.out.print("열 인덱스 입력 : ");
        int col = sc.nextInt();
        sc.nextLine();

        for(int i=0; i<arr.length; i++){
            for(int j=0; j<arr[0].length; j++){
                if(i==0 && j==0) arr[i][j] = " ";
                else if(i==0) arr[i][j] = (j-1)+"";
                else if(j==0) arr[i][j] = (i-1)+"";
                else if(i==row+1 && j==col+1) arr[row+1][col+1]="X";
                else arr[i][j] = " ";
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }

    public void practice10(){
        Scanner sc = new Scanner(System.in);
        String[][] arr = new String[6][6];
        for(int i=0; i<arr.length; i++){
            for(int j=0; j<arr[0].length; j++){
                if(i==0 && j==0) arr[i][j] = " ";
                else if(i==0) arr[i][j] = (j-1)+"";
                else if(j==0) arr[i][j] = (i-1)+"";
                else arr[i][j] = " ";
            }
        }
        while(true){
            System.out.print("행 인덱스 입력 : ");
            int row = sc.nextInt();
            System.out.print("열 인덱스 입력 : ");
            int col = sc.nextInt();
            sc.nextLine();

            if(row==99 || col==99) {
                System.out.println("프로그램 종료");
                break;
            }

            for(int i=0; i<arr.length; i++){
                for(int j=0; j<arr[0].length; j++){
                    if(i==row+1 && j==col+1) arr[row+1][col+1]="X";
                    System.out.print(arr[i][j]+" ");
                }
                System.out.println();
            }
            System.out.println();
        }
    }

}
