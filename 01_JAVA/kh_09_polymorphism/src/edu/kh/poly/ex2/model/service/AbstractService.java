package edu.kh.poly.ex2.model.service;

import edu.kh.poly.ex2.model.vo.Animal;
import edu.kh.poly.ex2.model.vo.Fish;
import edu.kh.poly.ex2.model.vo.Person;

public class AbstractService {
    public void ex1(){
//        Animal a1 = new Animal();
        // 클래스 : 객체의 속성, 기능을 정의한 것 (일종의 설계도)
        // 추상 클래스 : 미완성 메소드를 포함한 클래스 (미완성 설계도)
        // -> 미완성 설계도로는 객체를 만들 수 없다!! (오류 발생)

        // 해결방법 : Animal을 상속받아 미완성 부분을 구현 한 클래스를 이용해 객체 행성

        // * 추상 클래스를 상속 받은 자식 객체 생성하기
        Person p1 = new Person();
        p1.setName("공유");

        // 상속받은 기능 호출
        p1.setType("척추동물");
        p1.setEatType("잡식");

        // 오버라이딩한 메 소드 호출
        p1.eat();
        p1.breath();

        Fish f1 = new Fish();
        f1.eat();
        f1.breath();
    }

    public void ex2(){
        // 추상 클래스와 다형성 + 바인딩
        Animal[] arr = new Animal[2];
        arr[0] = new Person("사람","잡식","김종수");
        arr[1] = new Fish("물고기","잡식");

        for(int i=0; i<arr.length; i++){
            arr[i].eat();
            arr[i].breath();
            System.out.println(arr[i]+"\n-------------------------------------------");
        }
        // 프로그램 실행 시
        // 참조하고 있는 자식 객체의 오버라이딩 된 eat()메소드 수행
        // -동적 바인딩 (부모타입 참조변수로 메소드를 호출 했지만 자식타입에 오버라이딩된 메소드가 수행)
        // 업캐스팅 상태(부모 참조변수 = 자식 객체)에서
        // 부모 메소드 호출 시, 오버라이딩된 자식 메소드 수행
    }
}
