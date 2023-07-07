package edu.kh.variable.ex2;

public class PrintExample {
    public static void main(String[] args){

        System.out.println("테스트1"); // 한 줄 출력 (출력 후 줄바꿈 O)
        System.out.println("테스트2");
        System.out.print("테스트3"); // 단술 출력 (출력 후 줄바꿈 X)
        System.out.println(); // 내용 없는 println (줄바꿈)
        System.out.print("테스트4");
        System.out.println();

        // 패턴 출력
        int iNum1 = 10;
        int iNum2 = 5;
        System.out.println(iNum1+" + "+iNum2+" = "+(iNum1+iNum2));
        System.out.printf("%d + %d = %d\n",iNum1,iNum2,iNum1+iNum2);
        System.out.println(iNum1+" + "+iNum1+" * "+iNum2+" / "+iNum1/iNum2+" = "+ (iNum1+iNum1*iNum2/(iNum1/iNum2)));
        System.out.printf("%d + %d * %d / %d = %d\n",iNum1,iNum1,iNum2,iNum1/iNum2,iNum1+iNum1*iNum2/(iNum1/iNum2));

        int iNum3 = 3;
        System.out.printf("%d\n",iNum3);
        System.out.printf("%7d\n",iNum3);   // 7칸 공간 확보 후 오른쪽 정렬
        System.out.printf("%-7d\n",iNum3);  // 7칸 공간 확보 후 왼쪽 정렬

        System.out.printf("%f\n",10/4.0);
        System.out.printf("%.2f\n",10/4.0); // 소수점 n번째 자리까지 -> %.nf
        System.out.printf("%.0f\n",10/4.0); // 반올림 처리가 된다.

        boolean isTrue = false;
        char ch = '얍';
        String str = "배고파요";
        System.out.printf("%b / %c / %s\n",isTrue,ch,str);

        //escape 문자 출력
        System.out.println("\\"); // 백슬래시 출력
        System.out.println("a\tb\tc\td"); // 탭키 출력
        System.out.println("\""); // 쌍따옴표 단순 문자 출력
        System.out.println("\'"); // 홑따옴표 단순 문자 출력
        System.out.println("\u0041"); // 유니코드(16진수)번호로 'A'출력

        //System.out.print("입력 3 : "); // 내용 출력하고 줄바꿈 안해줌
        //System.out.printf("%d + %d = %d",변수1,변수2,변수1+2); // 패턴대로 내용을 출력하고 줄바꿈 안해줌
        // 정해진 패턴대로 들어갈 변수를 순차적으로 정해줌 ( 변수는 콤마로 구분 )
        //System.out.println("입력 3 : "); // 내용 출력 후 줄바꿈
    }
}
