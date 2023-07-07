package edu.kh.collection.model.service;

import edu.kh.collection.model.vo.Member;

import java.util.*;

public class SetService {
    // set(집합)
    // - 순서를 유지하지 않음( == 인덱스 없음)
    // - 중복을 허용하지 않는다. ( + null도 중복이 안된다, 1개만 저장 가능)

    // *** Set이 중복을 확인하는 방법 ***
    // -> 객체가 가지고 있는 필드 값이 모두 같으면 중복으로 판단
    // --> 이 때 필드 값이 모두 같은지 비교하기 위해서 객체에
    //     equals()가 반드시! 오버라이딩 되어있어야 한다.

    public void ex1(){
        Set<String> set = new HashSet<String>();
        // HashSet : Set의 대표적인 자식 클래스
        // 사용조건 1 : 저장되는 객체에 equals() 오버라이딩 필수
        // 사용조건 2 : 저장되는 객체에 hashCode() 오버라이딩 필수

        // *참고* : Hash라는 단어가 붙은 컬렉션은 반드시 저장되는 객체에
        //          equals(), hashCode()를 오버라이딩 해야함

        // Set.add(String s) : 추가
        set.add("네이버");
        set.add("카카오");
        set.add("라인");
        set.add("쿠팡");
        set.add("배달의민족");
        set.add("배달의민족");
        set.add("배달의민족");
        set.add("null");
        set.add("null");
        set.add("null");

        System.out.println(set);
        //순서, 중복 안됐는지 확인

        //size() : 저장된 데이터의 개수 반환
        System.out.println("저장된 데이터의 수 : "+set.size());

        // romove(String s) : Set에 저장된 객체 중 매개변수 s와 필드값이 같은 객체를 제거
        //                    + Hash라는 단어가 포함된 Set면 hashCode()도 같아야함

        System.out.println(set.remove("라인"));
        System.out.println(set.remove("야놀자"));
        System.out.println(set); // 제거 됐는지 확인
        System.out.println();
        // Set은 순서가 없어서 저장된 객체 하나를 얻어올 수 있는 방법이 없다!
        // -> 대신에 Set 전체의 데이터를 하나씩 반복적으로 얻어올 순 있다.

        // 1. Iterator (반복자)
        // - 컬렉션에서 제공하는 컬렉션 객체 반복 접근자
        // (컬렉션에 저장된 데이터를 임의로 하나씩 반복적으로 꺼내는 역할)
        // Iterator가 얻어온 데이터의 타입은 모두 String임을 알려줌
        Iterator<String> it = set.iterator();
        while(it.hasNext()){
            // it.hasNext() : 다음 가져올 값이 있으면 true 반환
            // it.next() : 다음 값(객체)를 얻어옴
            String temp = it.next();
            System.out.println(temp);
        }
        System.out.println("-------------------------------------------");

        // 향상된 for문 사용
        // for(하나씩 꺼내서 저장할 변수 : 컬렉션 )
        for(String temp : set){
            System.out.println(temp);
        }
    }
    public void ex2(){
        // Object의 equals(), hashCode() 오버라이딩
        // A.equals(B) : A와 B가 가지고 있는 필드 값이 모두 같으면 true, 아니면 false

        // Hash 함수 : 입력된 단어를 지정된 길이의 문자열로 변환하는 함수 (중복X)
        // ex) 입력 : 111 -> "asdfg" (5글자)
        // ex) 입력 : 1234567 -> "qwert" (5글자)

        // hashCode() : 필드 값이 다르면 중복되지 않는 숫자를 만드는 메소드
        // -> 왜 만들까? 빠른 데이터 검색을 위해서(객체가 어디에 있는지 빨리 찾기 위해서)
        // HashSet() : 중복 없이 데이터 저장(Set)하고 데이터 검색이 빠름(Hash)
        Member mem1 = new Member("user01","pass01",30);
        Member mem2 = new Member("user01","pass01",30);
        Member mem3 = new Member("user02","pass02",20);
        System.out.println(mem1 == mem2); // 얕은 복사한 경우가 아니라면 값이 일치해도 다 false

        // mem1과 mem2가 가지고 있는 필드 값이 같은지 비교
        if(mem1.getId().equals(mem2.getId())){       // 아이디가 같을 경우
            if(mem1.getPw().equals(mem2.getPw())){   // 비밀번호도 같을 경우
                if(mem1.getAge() == mem2.getAge()) { // 나이도 같을 경우
                    System.out.println("같은 객체 입니다. (true)");
                }
            }
        }
        // -> 매번 이렇게 비교하기 힘들다.. 비교 코드를 작성해서 재활용하자!
        // == equals()메소드 오버라이딩

        System.out.println("-------------------------------------------------");
        System.out.println(mem1.equals(mem2)); // mem1이랑 mem2랑 같은가?
        System.out.println(mem1.equals(mem3)); // mem1이랑 mem3이랑 같은가?
        // 서로 다른 객체지만 필드 값이 같다 == 동등
        // 비교하려는 것이 정말 같은 하나의 객체이다 == 동일
    }

    public void ex3(){
        // equals()가 오버라이딩된 Member를 Set에 저장
        Set<Member> memberSet = new HashSet<Member>();
        memberSet.add(new Member("user01","pass01",30));
        memberSet.add(new Member("user02","pass02",30));
        memberSet.add(new Member("user03","pass03",20));
        memberSet.add(new Member("user04","pass04",25));
        memberSet.add(new Member("user04","pass04",25));

        for(Member m : memberSet){
            System.out.println(m);
        }
        Member mem1 = new Member("user01","pass01",30);
        Member mem2 = new Member("user01","pass01",30);
        Member mem3 = new Member("user01","pass01",31);

        System.out.println(mem1.hashCode());
        System.out.println(mem2.hashCode());
        System.out.println(mem3.hashCode());
    }

    public void ex4(){
        // Wrapper Class : 기본 자료형 -> 객체로 포장하는 클래스

        // - 컬렉션에 기본 자료형 값을 저장할 때 사용
        // - 기본 자료형에 없던 추가 기능, 값을 이용하고 싶을 때 사용

        // <Wrapper Class 종류>
        // int  ->  Interger
        // double   ->  Double
        // boolean, Byte, Short, Long, Float, Character

        int iNum = 10;
        double dNum = 3.14;

        // 기본 자료형 -> 포장
        Integer w1 = new Integer(iNum);
        Double w2 = new Double(dNum);

        // Wrapper Class 활용
        System.out.println("int 최대값 : "+w1.MAX_VALUE); // 기울어진 글씨 == static
        System.out.println("double 최소값 : "+w2.MIN_VALUE); // static은 클래스명.필드명 / 클래스명.메소드명() 호출가능

        System.out.println("w1 값 : "+w1);
        System.out.println("w2 값 : "+w2);
        System.out.println("-----------------------------------------------------------");
        System.out.println("static 방식으로 wrapper Class 사용하기");

        System.out.println("int 최소값 : " + Integer.MIN_VALUE);
        System.out.println("Double 최대값 : " + Double.MAX_VALUE);

        // ************************************************************************************
        // parsing : 데이터의 형식을 변환
        // ! String 데이터를 기본 자료형으로 변환 !
        int num1 = Integer.parseInt(("100")); // 문자열 "100"을 int형식으로 변환
        double num2 = Double.parseDouble(("1.23456")); // 문자열 "1.23456"을 double형식으로 변환
        System.out.println(num1+num2); //101.23456
        // ************************************************************************************
    }

    public void ex5(){
        // Wrapper Class의 AutoBoxing / AutoUnBoxing

        Integer w1 = new Integer(100);
        // 삭제선 == deprecated == 해당 구문은 삭제될 예정이다 -> 사용 권장하지 않음
        Integer w2 = 100;
        // w2와 100은 자료형이 달라서 원래 연산이 안되어야 하지만
        // Integer는 int의 포장 형식이라는 것을 Java가 인식하고 있어서
        // 위와 같은 경우 int를 Integer로 자동 포장 해준다. (AutoBoxing)
        Integer w3 = 100;
        System.out.println("w2 + w3 = "+(w2+w3));
        // 원래는 객체끼리 더해줄 수 없지만 Integer는 int의 포장형태 라는걸 Java가 인식하고 있어서
        // + 연산시 포장을 자동으로 벗겨내어 연산해 준다. (AutoUnBoxing)

    }

    public void lotto(){
        // Set<int> lotto = new HashSet<int>();
        // int는 기본자료형이기 때문에 객체만 저장하는 컬렉션에는 들어갈 수 없어서 제네릭으로 타입을 제한할 수 없다.
        // -> 해결방법 : Wrapper Class를 이용해서 기본 자료형을 객체로 포장한다.

        Set<Integer> lotto = new TreeSet<Integer>();
//        Set<Integer> lotto = new LinkedHashSet<Integer>();
//        Set<Integer> lotto = new HashSet<Integer>();
        // Integer는 equals(), hashCode() 오버라이딩 완료 상태
        while(lotto.size()!=6){
            int random = (int)(Math.random()*45+1);
            lotto.add(random);
        }
        System.out.println("로또 번호 : " + lotto);
    }
}
