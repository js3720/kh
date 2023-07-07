package edu.kh.array.ex;

import java.util.Arrays;

public class ArrayExample2 {

    public void shallowCopy(){
        // 얕은 복사 (shallow : 얕은)
        // 주소를 복사하여 서로 다른 두 변수가
        //하나의 배열(또는 객체)을 참조하는 상태를 만드는 복사 방법
        int[] arr = {1,2,3,4,5};
        //얕은 복사 진행
        int[] copyArr = arr; // 주소만 복사한다.
        System.out.println(arr);
        System.out.println(copyArr);
        System.out.println("변경 전");
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(copyArr));
        // 얕은 복사한 배열의 값을 변경
        copyArr[2] = 999;
        System.out.println("변경 후");
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(copyArr));
    }

    public void deepCopy(){
        // 깊은 복사 (deep : 깊은)
        // 같은 자료형의 새로운 배열을 만들어서
        // 기존 배열의 데이터를 모두 복사하는 방법
        int[] arr = {1,2,3,4,5}; // 원본배열
        int[] copyArr1 = new int[arr.length]; // arr의 길이만큼의 메모리를 새롭게 생성
        // 1. for문을 이용한 깊은복사
        for(int i=0; i<arr.length; i++){
            copyArr1[i] = arr[i];
        }
        // 2. System.arraycopy(원본배열, 원본 복사 시작 인덱스, 복사배열, 복사배열의 삽입 시작 인덱스, 복사길이);
        int[] copyArr2 = new int[arr.length];
        System.arraycopy(arr,0,copyArr2,0,arr.length);

        // 3. Arrays.copyof(원본배열, 복사할 길이);
        int[] copyArr3 = Arrays.copyOf(arr,arr.length);

        System.out.println("arr : "+Arrays.toString(arr));
        System.out.println("copyArr1 : "+Arrays.toString(copyArr1));
        System.out.println("copyArr2 : "+Arrays.toString(copyArr2));
        System.out.println("copyArr3 : "+Arrays.toString(copyArr3));
    }

    public void createLottoNumber(){
        // 배열을 이용한 중복 데이터 제거 + 정렬
        // 로또 번호 생성기
        int[] numArr = new int[6];
        for(int i=0; i<numArr.length; i++){
            int random = (int)(Math.random()*46);
            numArr[i] = random;
            for(int j=0; j<i; j++){
                if(random == numArr[j]){
                    i--;
                    break;
                }
            }
        }
        Arrays.sort(numArr);
        System.out.println(Arrays.toString(numArr)); // [정수1, 정수2, 정수3, 정수4, 정수5, 정수6]

    }
}
