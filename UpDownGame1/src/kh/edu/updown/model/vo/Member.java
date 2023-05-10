package kh.edu.updown.model.vo;

public class Member {
    private String memberId;
    private String memberPw;
    private String memberName;
    private int highScore;

    public Member() { }


    public Member(String memberId, String memberPw, String memberName) {
        super();
        this.memberId = memberId;
        this.memberPw = memberPw;
        this.memberName = memberName;
    }

    public Member(String memberId, String memberPw, String memberName, int highScore) {
        super();
        this.memberId = memberId;
        this.memberPw = memberPw;
        this.memberName = memberName;
        this.highScore = highScore;
    }

    // getter / setter
    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getMemberPw() {
        return memberPw;
    }

    public void setMemberPw(String memberPw) {
        this.memberPw = memberPw;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public int getHighScore() {
        return highScore;
    }

    public void setHighScore(int highScore) {
        this.highScore = highScore;
    }

    @Override
    public String toString() {
        return "[ 아이디 : " + memberId + " ], [ 이름 : " + memberName + (highScore == 0 ? " ], [ 점수 기록 없음 ]" : " ], [ 최고점수 : " + highScore + "회 ]");
    }
}
