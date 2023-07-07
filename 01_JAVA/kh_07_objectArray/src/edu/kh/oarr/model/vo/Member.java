package edu.kh.oarr.model.vo;

public class Member {
    //필드 (== 멤버 변수)
    private String memberId;
    private String memberPw;
    private String memberName;
    private int memberAge;
    private String region; // 지역

    //생성자
    public Member(){}
    public Member(String id, String pw, String name, int age, String region){
        this.memberId = id;
        this.memberPw = pw;
        this.memberName = name;
        this.memberAge = age;
        this.region = region;
    }

    //메소드
    public String getMemberId(){ return memberId; }
    public String getMemberPw(){ return memberPw; }
    public String getMemberName(){ return memberName; }
    public int getMemberAge(){ return memberAge; }
    public String getRegion(){ return region; }

    public void setMemberId(String id){ this.memberId = id; }
    public void setMemberPw(String pw){ this.memberPw = pw; }
    public void setMemberName(String name){ this.memberName = name; }
    public void setMemberAge(int age){ this.memberAge = age; }
    public void setRegion(String region){ this.region = region; }

    // Member m1 = new Member(); X
    // USer u1 = new User();
    // People p1 = new People();

    // 사람형식의 종수.setAge(30);를 만들고 = 그 속성과 기능은 사람 설계도랑 같을거야
    // 사람형식의 수현.setAge(29);을 만들고 =
    // 객체배열로 만들어서
    // 사람형식[] 사람 = new 사람형식[5];


    // jongSoo.setMemberId("whdtn");
    // jongSoo.setMemberPw("123123");
    // jongSoo.setMemberName("김종수");
    // jongSoo.setMemberAge(20);
    // jongSoo.setRegion("서울");

    // Member jongSoo = new Member("whdtn","123123","김종수",20,"서울");
    // 개수, 자료형(타입), 순서중 하나라도 달라야 한다
    // 같은 이름의 메소드로 서로 다른 기능을 하기 위해 오버로딩을 한다

    // 모든 메소드는 종료 시 호출한 곳으로 돌아가는 return 구문이 작성 되어야만 하지만,
    // void일 경우 생략 가능하다. -> 생략 시 컴파일러가 자동으로 추가해 준다.
}
