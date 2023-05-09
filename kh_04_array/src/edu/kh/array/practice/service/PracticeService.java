package edu.kh.array.practice.service;

import javax.swing.text.Style;
import java.util.Arrays;
import java.util.Scanner;

public class PracticeService {

    public void practice1(){
        int[] num = new int[9];
        int sum = 0;
        for(int i=0; i<9; i++){
            num[i] = i+1;
            System.out.print(num[i] +" ");
            if(i%2==0) sum+=num[i];
        }
        System.out.println("\n짝수 번째 인덱스 합 : "+sum);
    }

    public void practice2(){
        int[] num = new int[9];
        int sum = 0;
        for(int i=0; i<9; i++){
            num[i] = num.length-i;
            System.out.print(num[i] +" ");
            if(i%2==1) sum+=num[i];
        }
        System.out.println("\n홀수 번째 인덱스 합 : "+sum);
    }

    public void practice3(){
        Scanner sc = new Scanner(System.in);
        System.out.print("양의 정수 : ");
        int input = sc.nextInt();
        int[] num = new int[input];
        for(int i=0; i<input; i++){
            num[i]=i+1;
            System.out.print(num[i]+" ");
        }
    }

    public void practice4(){
        // 정수 5개를 입력받아 배열을 초기화하고
        // 검색할 정수를 하나 입력받아 배열에서 같은 수가 있는 인덱스를 찾아 출력.
        // 배열에 같은 수가 없을 경우 "일치하는 값이 존재하지 않습니다" 출력
        Scanner sc = new Scanner(System.in);
        int[] num = new int[5];
        boolean flag = false;

        for(int i=0; i<5; i++){
            System.out.printf("입력 %d : ",i);
            num[i]= sc.nextInt();
        }
        System.out.print("검색할 값 : ");
        int input = sc.nextInt();
        for(int i=0; i<5; i++){
            if(num[i]==input) System.out.println("인덱스 : "+i);
        }
        if(!flag) System.out.println("일치하는 값이 존재하지 않습니다.");
    }

    public void practice5(){
        Scanner sc = new Scanner(System.in);
        System.out.print("문자열 : ");
        String Str = sc.nextLine();
        char[] chArr = new char[Str.length()];
        for(int i=0; i<Str.length(); i++){
            chArr[i]=Str.charAt(i);
        }
        int count=0;

        System.out.print("문자 : ");
        char ch = sc.next().charAt(0);
        System.out.printf("application에 %c가 존재하는 위치(인덱스) : ",ch);
        for(int i=0; i<Str.length(); i++){
            if(chArr[i]==ch){
                System.out.print(i+" ");
                count++;
            }
        }
        System.out.printf("\n%c 개수 : %d\n",ch,count);
    }

    public void practice6(){
        Scanner sc = new Scanner(System.in);
        System.out.print("정수 : ");
        int input = sc.nextInt();
        int[] num = new int[input];
        int sum=0;
        for(int i=0; i<input; i++){
            System.out.printf("배열 %d번째 인덱스에 넣을 값 : ",i);
            num[i] = sc.nextInt();
            sum += num[i];
        }
        for(int i=0; i<input; i++){
            System.out.print(num[i]+" ");
        }
        System.out.println("\n총 합 : "+sum);
    }

    public void practice7(){
        Scanner sc = new Scanner(System.in);
        System.out.print("주민등록번호(-포함) : ");
        String str = sc.nextLine();
        for(int i=0; i<14; i++) System.out.print(i<8 ? str.charAt(i) : "*");
    }

    public void practice8(){
        Scanner sc = new Scanner(System.in);
        int input=0;
        while(true){
            System.out.print("정수 : ");
            input = sc.nextInt();
            if(input>=3 && input%2==1) break;
            else System.out.println("다시 입력하세요.");
        }
        int[] arr = new int[input];
        int num = 0;
        for(int i=0; i<arr.length; i++){
            if(i <= arr.length/2) arr[i] = ++num;
            else arr[i] = --num;
            System.out.print(num);
            if(i!=arr.length-1) System.out.print(", ");
        }
    }

    public void practice9(){
        int[] arr = new int[10];
        System.out.print("발생한 난수 : ");
        for(int i=0; i<arr.length; i++){
            arr[i] = (int)(Math.random()*10+1);
            System.out.print(arr[i]+" ");
        }
    }

    public void practice10(){
        int[] arr = new int[10];
        int max = 0;
        int min = 0;
        System.out.print("발생한 난수 : ");
        for(int i=0; i<arr.length; i++){
            arr[i] = (int)(Math.random()*10+1);
            if(i==0){
                max = arr[i];
                min = arr[i];
            }
            else {
                if(max<arr[i]) max=arr[i];
                if(min>arr[i]) min=arr[i];
            }
            System.out.print(arr[i]+" ");
        }
        System.out.println("\n최대값 : "+max);
        System.out.println("최소값 : "+min);
    }

    public void practice11(){
        int[] arr = new int[10];
        for(int i=0; i<arr.length; i++){
            arr[i] = (int)(Math.random()*10+1);
            for(int j=0; j<i; j++){
                if(arr[i]==arr[j]) {
                    i--;
                    break;
                }
            }
        }
        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i]+" ");
        }
    }

    public void practice12(){
        int[] arr = new int[6];
        for(int i=0; i<arr.length; i++){
            arr[i] = (int)(Math.random()*45+1);
            for(int j=0; j<i; j++){
                if(arr[i]==arr[j]) {
                    i--;
                    break;
                }
            }
        }
        Arrays.sort(arr);
        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i]+" ");
        }
    }

    public void practice13(){
        Scanner sc = new Scanner(System.in);
        System.out.print("문자열 : ");
        String str = sc.nextLine();
        char[] arr = new char[str.length()];
        int index =0;

        for(int i=0; i<str.length(); i++){
            if(i==0) arr[index++] = str.charAt(i);
            else{
                for(int j=0; j<i; j++){
                    if(arr[j]==str.charAt(i)) break;
                    if(j==i-1)arr[index++]=str.charAt(i);
                }
            }
        }
        System.out.print("문자열에 있는 문자 : ");
        for(int i=0; i<index; i++){
            System.out.print(arr[i]);
            if(i!=index-1) System.out.print(", ");
        }
        System.out.println("\n문자 개수 : "+ index);
    }

    public void practice14(){
        Scanner sc = new Scanner(System.in);
        String[] result = null;
        String answer = "y";
        int index = 0;
        while((answer.equals("y") || answer.equals("Y"))){
            if(index==0)System.out.print("배열의 크기를 입력하세요 : ");
            else System.out.print("더 입력하고 싶은 개수 : ");
            int input = sc.nextInt();
            sc.nextLine();

            String[] arr = new String[index+input];
            if(index>0){ // 2회차 이상 값 입력 시 이전 회차 결과값 배열(result)에 있던 값을 현재 회차 배열(arr)에 깊은 복사
                for(int i=0; i<result.length; i++){
                    arr[i] = result[i];
                }
            }
            for(int i=index; i<arr.length; i++){ // 이번 회차 배열(arr)에 추가적인 문자열 입력
                System.out.print((index+1)+"번 째 문자열 : ");
                arr[index++] = sc.nextLine();
            }
            result = new String[arr.length]; // 이번 회차 배열(arr)값 을 결과값 배열(result)에 깊은복사
            for(int i=0; i<arr.length; i++){
                result[i] = arr[i];
            }
            System.out.print("더 값을 입력하시겠습니까?(Y/N) : ");
            answer = sc.nextLine();
        }
        System.out.println(Arrays.toString(result));
    }

}
