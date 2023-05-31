package edu.kh.jdbc.board.model.dao;

import edu.kh.jdbc.board.model.vo.Board;
import edu.kh.jdbc.board.model.vo.Reply;

import static edu.kh.jdbc.common.JDBCTemplate.*;
import java.io.*;
import java.sql.*;
import java.util.*;
import java.sql.Date;

public class BoardDAO {
    private Statement stmt;
    private PreparedStatement pstmt;
    private ResultSet rs;

    private Properties prop;

    public BoardDAO(){
        try{
            prop = new Properties();
            prop.loadFromXML(new FileInputStream("board-sql.xml"));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public List<Board> selectAll(Connection conn) throws Exception{
        // 결과 저장용 변수
        List<Board> boardList = new ArrayList<>();

        try{
            String sql = prop.getProperty("selectAll");

            stmt = conn.createStatement();

            rs = stmt.executeQuery(sql);

            while(rs.next()){
                int boardNo = rs.getInt("BOARD_NO");
                String boardTitle = rs.getString("BOARD_TITLE");
                Date createDate = rs.getDate("CREATE_DATE");
                int readCount = rs.getInt("READ_COUNT");
                String memberName = rs.getString("MEMBER_NM");
                int replyCount = rs.getInt("REPLY_COUNT");

                boardList.add(new Board(boardNo, boardTitle, createDate, readCount, memberName, replyCount));
            }
        }finally {
            close(rs);
            close(stmt);
        }

        return boardList;
    }

    /**
     * 특정 게시글 상세 조회 DAO
     * @param conn
     * @param boardNo
     * @return board
     * @throws Exception
     */
    public Board selectOne(Connection conn, int boardNo) throws Exception{
        Board board = null;

        try{
            // 1) SQL 작성
            String sql = prop.getProperty("selectOne");

            // 2) PreparedStatement 생성
            pstmt = conn.prepareStatement(sql);

            // 3) 위치홀더 '?' 알맞은 값 세팅
            pstmt.setInt(1,boardNo);

            // 4) SQL 수행(SELECT) 후 결과 반환 받기 (ResultSet)
            rs = pstmt.executeQuery();

            // 5) 조회된 한 행(if)이 있을 경우 조회된 컬럼 값 얻어오기
            if(rs.next()){
                boardNo = rs.getInt("BOARD_NO");
                String boardTitle = rs.getString("BOARD_TITLE");
                Date createDate = rs.getDate("CREATE_DATE");
                int readCount = rs.getInt("READ_COUNT");
                String memberName = rs.getString("MEMBER_NM");

                String boardContent = rs.getString("BOARD_CONTENT");
                int memberNo = rs.getInt("MEMBER_NO");

                // 6) Board 객체를 생성하여 컬럼 값 세팅
                board = new Board();
                board.setBoardNo(boardNo);
                board.setBoardTitle(boardTitle);
                board.setBoardContent(boardContent);
                board.setCreateDate(createDate);
                board.setReadCount(readCount);
                board.setMemberName(memberName);
                board.setMemberNo(memberNo);
            }

        }finally {
            // 7) 사용한 JDBC 자원반환
            close(rs);
            close(pstmt);
        }
        // 8) 결과 반환
        return board;
    }

    /**
     * 특정 게시글 댓글 목록 조회 DAO
     * @param conn
     * @param boardNo
     * @return replyList
     * @throws Exception
     */
    public List<Reply> selectReplyList(Connection conn, int boardNo) throws Exception{

        List<Reply> replyList = new ArrayList<>(); // 결과 저장용 변수

        try{
            // 1) SQL 작성
            String sql = prop.getProperty("selectReplyList");

            // 2) PreparedStatement 생성
            pstmt = conn.prepareStatement(sql);

            // 3) 위치홀더에 알맞은 값 대입
            pstmt.setInt(1, boardNo);

            // 4) SQL(SELECT) 수행 후 결과 (ResultSet) 반환 받기)
            rs = pstmt.executeQuery();

            // 5) 조회된 결과를 한 행씩 접근
            while(rs.next()){
                // 6) Reply 객체를 생성하여 컬럼 값 담기
                int replyNo = rs.getInt("REPLY_NO");
                String replyContent = rs.getString("REPLY_CONTENT");
                Date createDate = rs.getDate("CREATE_DATE");
                int memberNo = rs.getInt("MEMBER_NO");
                String memberName = rs.getString("MEMBER_NM");

                // 7) replyList에 Reply 객체 추가
                Reply reply = new Reply();
                reply.setReplyNo(replyNo);
                reply.setReplyContent(replyContent);
                reply.setCreateDate(createDate);
                reply.setMemberNo(memberNo);
                reply.setMemberName(memberName);
                reply.setBoardNo(boardNo);
                replyList.add(reply);
            }

        }finally {
            // 8) JDBC 객체 자원 반환
            close(rs);
            close(pstmt);
        }
        return replyList;
    }

    public int increaseReadCount(Connection conn, int boardNo) throws Exception{
        int result = 0; // 결과 저장용 변수

        try{
            String sql = prop.getProperty("increaseReadCount");

            pstmt = conn.prepareStatement(sql);

            pstmt.setInt(1,boardNo);

            result = pstmt.executeUpdate();

        }finally {
            close(pstmt);
        }
        return result;
    }

    public int deleteBoard(Connection conn, int boardNo) throws Exception{
        int result = 0;
        try{
            String sql = prop.getProperty("deleteBoard");
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1,boardNo);
            result = pstmt.executeUpdate();
        }finally {
            close(pstmt);
        }
        return result;
    }
}
