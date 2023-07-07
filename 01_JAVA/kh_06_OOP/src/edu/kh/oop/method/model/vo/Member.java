package edu.kh.oop.method.model.vo;

public class Member {
    // 필드
    private String memberId; // 아이디
    private String memberPw; // 비밀번호
    private String memberName; // 이름
    private int memberAge; // 나이

    public Member(){} // 기본생성자

    public String getMemberId() {return memberId;}
    public void setMemberId(String memberId) {this.memberId = memberId;}
    public String getMemberPw() {return memberPw;    }
    public void setMemberPw(String memberPw) {this.memberPw = memberPw;}
    public String getMemberName() {return memberName;}
    public void setMemberName(String memberName) {this.memberName = memberName;}
    public int getMemberAge() {return memberAge;}
    public void setMemberAge(int memberAge) {this.memberAge = memberAge;}

    public Member(String memberId, String memberPw, String memberName, int memberAge){ // 매개변수 생성자
        this.memberId = memberId;
        this.memberPw = memberPw;
        this.memberName = memberName;
        this.memberAge = memberAge;
    }
}
