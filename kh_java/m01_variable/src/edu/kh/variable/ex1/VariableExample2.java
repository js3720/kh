package adu.kh.variable.ex1;

public class VariableExample2 {

    public static void main(String[] args) {
        /*
*
        자바의 기본 자료형 8가지
        논리형 : boolean (1byte)
        정수형 : byte(1byte), short(2byte), int(4byte), long(8byte)
        실수형 : float(4byte), double(8byte)
        문자형 : char(2byte)

        + 추가적으로 참조형 1가지
        문자열 형식 : String

        -------------------------------------------------------------------
        변수 선언 : 메모리에 값을 저장할 공간을 할당 하는 것
        변수 값 대입(집어넣기) 변수에 값을 집어 넣는 것
        처음 변수에 값을 대입하는 것 --> 초기화

        변수 명명 규칙
        1. 대소문자 구분, 길이제한 X
        int abcdefghijklmnopqrstuvwxyz; // 대소문자만 다르게 해줘도
        int abcdefghijklmnopqrstuvwxyZ; // 서로 다른 변수로 인식

        2. 예약어 사용 금지
        double double; X

        3. 숫자로 시작 금지
        char 1abc; X

        4. 특수문자는 _ 와 $만 사용 사능 (하지만 쓰지 않는다)
        int $intNumber; // 문제는 없지만 개발자가 직접 작성하진 않음
        int int_number; // 자바는 카멜표기법 사용한다. _ 작성 표기법은 DB에서 사용

        5. 카멜(낙타)표기법
        변수명 작성 시 여러 단어를 이어서 작성하는 경우
        띄어쓰지 않고 후속 단어 첫 글자를 대문자로 작성
        단, 첫 시작 글자는 소문자로 하는것이 관례
        char helloWorldAppleBananaTomato;

        6. 변수명은 언어를 가리지 않음 (하지만 사용하지 않음)
        int 정수1번;
        double 실수2번 = 3.14;
        System.out.println(실수2번);

        -------------------------------------------------------------------

        int intNum = 10;
        자료형 변수명 = 리터럴;
        * 리터럴 : 변수에 대입되거나 작성 되어지는 값 자체
        자료형에 따라 리터럴 표기법이 다름 ( long : L, float : f ) 안붙히면 에러 발생
        정수, 실수형의 기본형(int, double)에는 리터럴 표기법이 없다.
        리터럴 표기법이 없는 정수는 int, 실수는 double로 자동 인식한다.

        */

        boolean booleanData; // 선언만 해두고 나중에 초기화
        // 메모리에 논리 값(t/f) 저장할 공간을 1byte 할당하고 할당된 공간을 booleanData라고 부르겠다.
        booleanData = true; // booleanData 변수에 true값을 집어 넣기


        byte byteNumber = 127; // 변수 선언 및 초기화
        // 메모리에 정수 값을 저장할 공간을 1byte 할당하고 할달된 공간을 byteNumber라고 부르겠다.
        // 선언된 byteNumber 변수에 처음으로 127을 집어 넣음
        short shortNumber = 32767;
        // 메모리에 정수 값을 저장할 공간을 2byte 할당하고
        // 할당된 공간은 shortNumber라고 부르겠다.
        int intNumber = 2147483647; // 정수형 중에서 기본형
        // 메모리에 정수 값을 저장할 공간을 4byte 할당하고
        // 할당된 공간을 intNumber라고 부르겠다.
        long longNumber=10000000000L;
        // 메모리에 정수 값을 저장할 공간을 8byte 할당하고
        // 할당된 공간을 longNumber라고 부르겠다.


        float floatNumber=1.2345f;
        // 메모리에 실수 값을 저장할 공간을 4byte 할당하고
        // 할당된 공간을 floatNumber라고 부르겠다.
        double doubleNumber=3.141592; // 실수형 중에서 기본형
        // 메모리에 실수 값을 저장할 공간을 8byte 할당하고
        // 할당된 공간을 doubleNumber라고 부르겠다.


        char ch = 'A'; // 문자형 리터럴 표기법 : '' (홑따옴표) --> 문자 하나만 저장
        // 메모리에 문자형 값을 저장할 공간을 2byte 할당하고
        // 할당된 공간을 ch라고 부르겠다.
        System.out.println("ch : "+ch); // ch : A 출력

        char ch2 = 66;
        System.out.println("ch2 : "+ch2); // ch2 : B 출력
        // char 자료형에 숫자가 대입될 수 있는 이유
        // 컴퓨터에는 문자표가 존재하고 있는데, 숫자에 따라 지정된 문자 모양이 매핑되어 있고
        // 'B' 라는 문자가 대입이 되면 변수에 숫자 66으로 변환되어 저장
        // 반대로 생각하면 애초에 변수에 66이라는 숫자를 저장하는 것이 가능


        // 변수는 말 그대로 상황에 따라 언제든 변할수 있는 수
        int number = 10;
        System.out.println("number : "+number); // number : 10 출력
        number = 20;
        System.out.println("number : "+number); // number : 20 출력

        /*
        상수(항상 같은 수)
        - 변수의 한 종류
        - 한번 값이 대입되면 다른 값을 대입할 수 없음
        - 자료형 앞에 final 키워드를 작성 (마지막 대입되는 값)

        - 상수 명명 규칙 : 모두 대문자, 여러 단어 작성 시 "_" 사용
        - 상수를 사용하는 경우
            1) 변하면 안되는 고정된 값을 저장할 때
            2) 특정한 값에 의미를 부여하는 경우
        */
        final int LEFT_MOVE = -1;
        final int RIGHT_MOVE = 1;
        final double PI_VALUE = 3.14;
        // ex) PI_VALUE = 2.3222; 에러! 대입 불가


    }

}
