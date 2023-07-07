package edu.kh.collection.model.service;

import edu.kh.collection.model.vo.Member;

import java.util.*;

public class MapService {
    // Map : Key와 Value 한 쌍이 데이터가 되어 이를 모아둔 객체

    // - Key를 모아두면 Set의 특징을 가지고 있다 (중복허용 안됨)
    // - value를 모아두면 List의 특징 (중복 허용)

    public void ex1(){
        // HashMap<K, V> : Map의 자식 클래스 중 가장 대표되는 Map
        Map<Integer, String> map = new HashMap<Integer, String>();
        // Map.put(Integer key, String Value) : 추가 (put은 "놓다" 라는 뜻)
        map.put(1,"홍길동");
        map.put(2,"고길동");
        map.put(3,"김길동");
        map.put(4,"박길동");
        map.put(5,"이길동");
        map.put(6,"최길동");
        System.out.println(map);

        // key 중복 테스트
        map.put(1,"홍홍홍"); // 중복허용 X, 대신 vlaue 덮어쓰기됨

        // value 중복 테스트
        map.put(7,"최길동"); // 중복허용 O
    }

    public void ex2(){
        // Map 사용 예제

        // VO(값 저장용 객체)는 특정 데이터 묶음의 재사용이 많은 경우 주로 사용
        // -> 재사용이 적은 VO는 오히려 코드 낭비이다.
        // -> 이때 Map을 이용해서 VO와 비슷한 코드를 작성할 수 있다.

        // 1) VO 버전
        Member mem = new Member();
        // 값 세팅
        mem.setId("user01");
        mem.setPw("pass01");
        mem.setAge(30);
        // 값 출력
        System.out.println(mem.getId());
        System.out.println(mem.getPw());
        System.out.println(mem.getAge());
        System.out.println("-----------------------");

        // 2) Map 버전
        Map<String, Object> map = new HashMap<String, Object>();
        // value가 Object 타입 == 어떤 객체든 value에 들어올 수 있다.
        // 값 세팅
        map.put("id", "user02");
        map.put("pw", "pass02");
        map.put("age", 25); // int -> Integer(AutoBoxing) - 대입-> Object
        // 값 출력
        System.out.println(map.get("id"));
        System.out.println(map.get("pw"));
        System.out.println(map.get("age"));

        // *** Map에 저장된 데이터 순차적으로 접근하기 ***
        // Map에서 Key만 모아두면 Set의 특징을 가진다.
        // -> 이를 활용할 수 있도록 Map에서 Keyset(메소드 제공)
        //    -> key만 모아서 Set으로 반환 해줌
        Set<String> set = map.keySet(); // id, pw, age가 저장된 Set 반환
        System.out.println(set);
        for(String key : set) System.out.println(map.get(key));
    }

    public void ex3(){
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();

        for(int i=0; i<10; i++){
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("id","user0"+i);
            map.put("pw","pase0"+i);
            list.add(map);
        } // for문 종료 시 list에는 10개의 map 객체가 추가되어 있다.

        // * list에 저장된 Map에서 key가 "id"인 경우의 value를 모두 출력
        for(Map<String, Object> temp : list){
            System.out.println(temp.get("id"));
        }
    }

}
