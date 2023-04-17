package adu.kh.variable.ex1;

public class VariableExample3 {

    public static void main(String[] args) {
        /*
        형변환 (Casting) : 값의 자료형을 변환하는 것 (boolean 제외)
        형변환은 왜 필요할까?
        컴퓨터는 기본적으로 같은 자료형 끼리만 연산이 가능함
        다른 자료형과 연산 시 오류 발생
        --> 이런 상황을 해결하기 위해서 필요한 기술이 형변환
        자동 / 강제 형변환이 존재


        자동 형변환
        - [값의 범위]가 큰 자료형과
        - [값의 범위]가 작은 자료형의 연산 시
        - 작은 자료형 -> 큰 자료형으로  컴파일러에 의해 자동적으로 변환되는 것
        */
        int num1 = 10;
        double num2 = 3.5;
        System.out.println("자동 형변환 결과 : "+ (num1+num2));
        // 원래 에러가 발생해야 되지만 "자동 형변환" 덕분에 발생하지 않음

        int i1 = 3;
        double d1 = i1;
        // double은 실수만 저장할 수 있는 자료형 이지만
        // 정수가 대입되는 연산이 수행되면 자동으로 형변환
        System.out.println("i1 : " + i1); // i1 : 3 출력
        System.out.println("d1 : " + d1); // d1 : 3.0 출력

        // int -> long 형변환
        int i2 = 2_100_000_000; // 21억
        long l2 = 10_000_000_000L; // 100억
        long result2 = i2 + l2;
        // int + long -> long + long = long
        System.out.println("result2 : "+result2); //121억

        // char -> int 형변환
        char ch3 = 'J';
        int i3 = ch3; // 대입도 연산이다!
        // int 변수 = char 값
        // char형 값이 int형 값으로 자동 형변환
        System.out.println("ch3 : "+ i3); // ch3 : 74 출력

        char ch4 = '사';
        int i4 = ch4;
        System.out.println(i4);
        // char형 값 '사' -> int형으로 자동 형변환되어 49324 출력

        long l5 = 123456789123456789L;
        float f5 = l5*100; // long의 범위를 초과
        // float = long * int (int보다 long이 값의 범위가 더 크기 때문에 int가 long형으로 자동 형변환)
        // float = long * long (같은 자료형으로 되어 연산이 가능해졌다.)
        // float = long (long형보다 float가 값의 범위가 더 크기 때문에 자동형변환이 된다.
        // float = float (float형 변수에 float 리터럴이 저장)

        System.out.println(f5); // -6.1010652E18 (오버플로우)
        // 오버플로우 현상은 컴퓨터가 미리 예측할 수 없다.
        // -> 개발자가 미리 예측을 해야함

        int i6 = 2147483647; // int의 최대값
        int result6 = i6 + 1; // 최대값에서 1이 더해지면 오버플로우가 일어난다.
        System.out.println(result6); // int형 값의 범위 중 최소 값이 출력 됨

    }

}
