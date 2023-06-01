package edu.kh.jdbc.board.model.vo;

// VO(Value object) : 값 저장용 객체
// 꼭 테이블과 같은 모양일 필요가 없다!

import java.util.Date;
import java.util.List;

public class Board {

    private int boardNo;
    private String boardTitle;
    private Date createDate;
    private int readCount;
    private String memberName;
    private int replyCount;

    private String boardContent;
    private List<Reply> replyList;

    private  int memberNo;

    public Board(){}

    public Board(int boardNo, String boardTitle, Date createDate, int readCount, String memberName, int replyCount) {
        this.boardNo = boardNo;
        this.boardTitle = boardTitle;
        this.createDate = createDate;
        this.readCount = readCount;
        this.memberName = memberName;
        this.replyCount = replyCount;
    }

    public int getBoardNo() {
        return boardNo;
    }

    public void setBoardNo(int boardNo) {
        this.boardNo = boardNo;
    }

    public String getBoardTitle() {
        return boardTitle;
    }

    public void setBoardTitle(String boardTitle) {
        this.boardTitle = boardTitle;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public int getReadCount() {
        return readCount;
    }

    public void setReadCount(int readCount) {
        this.readCount = readCount;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public int getReplyCount() {
        return replyCount;
    }

    public void setReplyCount(int replyCount) {
        this.replyCount = replyCount;
    }

    public String getBoardContent() {
        return boardContent;
    }

    public void setBoardContent(String boardContent) {
        this.boardContent = boardContent;
    }

    public List<Reply> getReplyList() {
        return replyList;
    }

    public void setReplyList(List<Reply> replyList) {
        this.replyList = replyList;
    }

    public int getMemberNo() {
        return memberNo;
    }

    public void setMemberNo(int memberNo) {
        this.memberNo = memberNo;
    }

    @Override
    public String toString() {
        return boardNo +"\t"+ boardTitle +"\t\t"+ memberName +"\t"+ createDate +"\t\t"+ readCount +"\t\t"+ replyCount +"\n";
    }
}
