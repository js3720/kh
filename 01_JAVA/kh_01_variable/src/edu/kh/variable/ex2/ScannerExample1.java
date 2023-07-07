package edu.kh.variable.ex2;
// Scanner 프로그램 실행 중 키보드 입력을 받을 수 있게 하는 역할
import java.util.Scanner; // Scanner 생성 ->프로그램 안에 스캐너 라는 기계를 만드는 것
//import : 다른 패키지에 존재하는 클래스를 얻어오는 구문

public class ScannerExample1 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        // import 하지 않으면 오류 발생 -> 스캐너의 설계도(Class)가 없어서 만들 수 없음
        System.out.print("정수 1 입력 : ");
        int input1 = sc.nextInt(); // 입력받은 정수를 input1 변수에 대입
        // nextInt() : 다음 입력된 정수를 읽어옴 (키보드로 입력된 정수를 읽어옴)
        System.out.print("정수 2 입력 : ");
        int input2 = sc.nextInt();

        System.out.printf("%d + %d = %d",input1,input2,input1+input2); // 정수1+정수2=결과값 출력
        // 사용자가 입력받은 값을 이용하여 결과값을 출력 -> (응용)
        // 이러한 프로그램을 응용 애플리캐이션(프로그램)이라 한다.

    }
}
