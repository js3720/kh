package edu.kh.jdbc.member.model.dao;
import edu.kh.jdbc.member.model.vo.Member;

import static edu.kh.jdbc.common.JDBCTemplate.*;

import java.io.FileInputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

// DAO (Date Access Object) : 데이터가 저장되어 있는 DB, 파일등에 접근하는 객체
//                             -> DB 접근할 수 있다 == SQL을 수행하고결과를 반환 받을 수 있다.

// Java에서 DB에 접근하고 결과를 반환 받기 위한 프로그래밍 API를 제공함
// == JDBC(Connecion, Statement, PreparedStatment, ResultSet)

public class MemberDAO {

    private Statement stmt;
    private PreparedStatement pstmt;
    private ResultSet rs = null;

    private Properties prop = null;
    // Map인데 K, V가 모두 String, 외부 XML 파일 입출력 특화 되어있다.

    public MemberDAO(){
        try{
            prop = new Properties();
            prop.loadFromXML(new FileInputStream("member-sql.xml"));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * 아이디 중복 검사 DAO 메소드
     * @param conn
     * @param memberId
     * @return
     * @throws Exception
     */
    public int duplicateCheck(Connection conn, String memberId) throws Exception{
        // 1) 결과 저장용 변수
        int result = 0;

        try{
            // 2) SQL 작성
            String sql = "SELECT COUNT(*) FROM MEMBER WHERE MEMBER_ID = ? AND SECESSION_FL = 'N'";

            // 3) PreparedStatement 객체 생성(Connection, SQL 필요)
            pstmt = conn.prepareStatement(sql);

            // 4) 위치 홀더'?'에 알맞은 값 세팅
            pstmt.setString(1, memberId);

            // 5) SQL 수행 수 결과 반환 받기
            rs = pstmt.executeQuery(); // SELECT 수행 결과 ResultSet을 반환 받음

            // 6) 조회 결과를 한 행씩 접근하여 원하는 컬럼 값 얻어오기
            // -> 아이디 중복 검사 SELECT 결과는 0 또는 1이라는 1행 결과가 무조건 나옴
            // -> while문 보다 if문을 사용하는게 효율적
            if(rs.next()){
                result = rs.getInt("COUNT(*)"); // rs.getInt(1); == SELECT구문 컬럼의 순서
            }

        }finally { // try-finally 구문 (catch는 throws에 의해서 생략)
            // 7) 사용한 JDBC 자원 반환(conn 제외) == service에서도 사용해야 하기 때문에
            close(rs);
            close(pstmt);
        }
        // 8) SQL 수행 결과 반환
        return result;
    }

    /**
     * 회원 가입 DAO
     * @param conn
     * @param signupMember
     * @return
     * @throws Exception
     */
    public int signUp(Connection conn, Member signupMember) throws Exception{
        int result = 0;

        try {
            // 1) SQL 작성
            String sql = prop.getProperty("signUp");

            // 2) PreparedStatement 객체 생성(Connection, SQL 필요)
            pstmt = conn.prepareStatement(sql);

            // 3) 위치 홀더 '?'에 알맞은 값 세팅
            // VALUES(SEQ_MEMBER_NO.NEXTVAL, ?, ?, ?, ?, DEFAULT, DEFAULT)
            pstmt.setString(1, signupMember.getMemberId());
            pstmt.setString(2, signupMember.getMemberPw());
            pstmt.setString(3, signupMember.getMemberName());
            pstmt.setString(4, signupMember.getMemberGender()+"");
            // getMemberGender()의 반환형은 char
            // setString()의 매개변수는 String -> 자료형 불일치로 오류 발생
            // char형 + "" = String형

            // 4) SQL(INSERT) 수행 후 결과 반환 받기
            result = pstmt.executeUpdate();

        }finally {
            // 5) 사용한 JDBC 자원 반환
            close(pstmt);
        }
        return result;
    }

    /**
     * 로그인 DAO
     * @param conn
     * @param mem
     * @return
     * @throws Exception
     */
    public Member login(Connection conn, Member mem) throws Exception{

        // 결과 저장용 변수 선언
        Member loginMember = null;
        try{
            // 1) SQL작성(Properties에서 얻어오기)
            String sql = prop.getProperty("login");

            // 2) PreparedStatement 생성
            pstmt = conn.prepareStatement(sql);

            // 3) 위치홀더 '?'에 알맞은 값 세팅
            pstmt.setString(1, mem.getMemberId());
            pstmt.setString(2, mem.getMemberPw());

            // 4) SQL(SELECT) 수행 후 결과 반환(ResultSet) 받기 (rs변수 사용)
            rs = pstmt.executeQuery();

            // 5) if 또는 while문을 이용해서 rs에 한 행 씩 접근하여 원하는 값 얻어오기
            if(rs.next()) {
                int memberNo = rs.getInt("MEMBER_NO");
                String memberId = rs.getString("MEMBER_ID");
                String memberName = rs.getString("MEMBER_NM");
                char memberGender = rs.getString("MEMBER_GENDER").charAt(0);
                Date enrollDate = rs.getDate("ENROLL_DATE");


                // 6) 얻어온 컬럼 값을 이용해서 Member 객체를 생성하여 loginMember 변수에 저장
                loginMember = new Member();
                loginMember.setMemberNo(memberNo);
                loginMember.setMemberId(memberId);
                loginMember.setMemberName(memberName);
                loginMember.setMemberGender(memberGender);
                loginMember.setEnrollDate(enrollDate);
            }

        }finally {
            // 7) 사용한 JDBC 객체 자원 반환(Connection 제외)
            close(rs);
            close(pstmt);
        }
        // 8) DAO 수행 결과 반환
        return loginMember;
    }

    /**
     * 가입된 회원 목록 조회 DAO
     * @param conn
     * @return
     */
    public List<Member> selectAll(Connection conn) throws Exception{
        // 결과 저장용 변수
        List<Member> memberList = new ArrayList<>();

        try{
            String sql = prop.getProperty("selectAll");

            stmt = conn.createStatement();

            rs = stmt.executeQuery(sql);

            while(rs.next()){
                String memberId = rs.getString("MEMBER_ID");
                String memberName = rs.getString("MEMBER_NM");
                Date enrollDate = rs.getDate("ENROLL_DATE");

                Member mem = new Member();
                mem.setMemberId(memberId);
                mem.setMemberName(memberName);
                mem.setEnrollDate(enrollDate);
                memberList.add(mem);
            }

        }finally {
            close(rs);
            close(stmt);
        }
        return memberList;
    }

    public int updateMyInfo(Connection conn, Member updateMember) throws Exception{
        int result = 0;
        try{
            String sql = prop.getProperty("updateMyInfo");

            pstmt = conn.prepareStatement(sql);

            pstmt.setString(1, updateMember.getMemberName());
            pstmt.setString(2, updateMember.getMemberGender()+"");
            pstmt.setInt(3, updateMember.getMemberNo());

            result = pstmt.executeUpdate();

        }finally {
            close(pstmt);
        }
        return result;
    }
}
