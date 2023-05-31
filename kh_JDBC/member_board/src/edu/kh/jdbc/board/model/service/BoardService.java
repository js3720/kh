package edu.kh.jdbc.board.model.service;

import static edu.kh.jdbc.common.JDBCTemplate.*;
import edu.kh.jdbc.board.model.dao.BoardDAO;
import edu.kh.jdbc.board.model.vo.Board;
import edu.kh.jdbc.board.model.vo.Reply;

import java.sql.Connection;
import java.util.List;



import java.util.List;

public class BoardService {

    private BoardDAO dao = new BoardDAO();

    /** 게시글 목록 조회 Service
     * @return boardList
     * @throws Exception
     */
    public List<Board> selectAll() throws Exception {

        // 1) Connection 생성
        Connection conn = getConnection();

        // 2) DAO 메모스(SELECT) 호출 후 결과 반환 받기
        List<Board> boardList = dao.selectAll(conn);

        // 3) Connection 반환
        close(conn);

        // 4) DAO 수행 결과를 View에 반환

        return boardList;
    }

    public Board selectOne(int boardNo) throws Exception {
        // 1) Connection 생성
        Connection conn = getConnection();

        // 2) 특정 게시글 상세 조회 DAO 메소드 호출 후 결과 반환 받기
        Board board = dao.selectOne(conn, boardNo);

        if(board != null){
            // 3-1) 특정 게시글의 댓글 목록 조회 DAO 메소드 호출 후 결과 반환 받기
            List <Reply> replyList = dao.selectReplyList(conn, boardNo);
            // Board 객체의 replyList 필드에 조회한 댓글 목록을 대입(세팅)
            board.setReplyList(replyList);

            // 3-2) 게시글 조회수 증가 DAO 메소드(UPDATE) 호출하고 결과값 반환
            int result = dao.increaseReadCount(conn, boardNo);

            // 트랜잭션 제어 처리 + 조회수 동기화
            if(result>0) {
                commit(conn);
                // DB READ_COUNT 업데이트
                // -> 업데이트 전에 게시글 정보를 조회 했음
                // -> 조회된 게시글 조회수가 DB 조회수보다 1 낮기 때문에 +1 시켜서 DB와 동기화
                board.setReadCount(board.getReadCount()+1);
            }
            else rollback(conn);
        }

        // 4) Connection 반환
        close(conn);

        // 5) DAO 수행 결과 View로 반한
        return board;
    }

    public int deleteBoard(int boardNo) throws Exception{
        Connection conn = getConnection();
        int result = dao.deleteBoard(conn, boardNo);

        if(result>0) commit(conn);
        else rollback(conn);

        close(conn);

        return result;
    }
}
