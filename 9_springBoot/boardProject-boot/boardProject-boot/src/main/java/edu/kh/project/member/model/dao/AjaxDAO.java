package edu.kh.project.member.model.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.kh.project.member.model.dto.Member;

@Repository // DB를 연결한다 + bean 등록 
public class AjaxDAO {
   
   @Autowired // bean 중에서 타입이 같은 객체를 DI(의존성 주입)
   private AjaxMapper mapper;

   /** 이메일로 닉네임 조회
    * @param email 
    * @return nickname
    */
   public String selectNickname(String email) {
      
      
      //return sqlSession.selectOne("ajaxMapper.selectNickname", email);
      return mapper.selectNickname(email);
      
   }

   /** 닉네임으로 전화번호 조회
    * @param inputNickname
    * @return tel
    */
   public String selectMemberTel(String nickname) {
      //return sqlSession.selectOne("ajaxMapper.selectMemberTel", nickname);
      return mapper.selectMemberTel(nickname);
   }

   
   /** 이메일 중복 검사
    * @param email
    * @return count
    */
   public int checkEmail(String email) {
      //return sqlSession.selectOne("ajaxMapper.checkEmail", email);
      return mapper.checkEmail(email);
   }

   /** 닉네임 중복 검사
    * @param nickname
    * @return count
    */
   public int checkNickname(String nickname) {
      //return sqlSession.selectOne("ajaxMapper.checkNickname", nickname);
      return mapper.checkNickname(nickname);
   }

   /** 이메일로 회원 정보 조회
    * @param email
    * @return member
    */
   public Member selectMember(String email) {
      //return sqlSession.selectOne("ajaxMapper.selectMember", email);
      return mapper.selectMember(email);
   }

   /** 이메일이 일부라도 일치하는 회원 정보 조회
    * @param input
    * @return
    */
   public List<Member> selectMemberList(String input) {
      //return sqlSession.selectList("ajaxMapper.selectMemberList", input);
      return mapper.selectMemberList(input);
   }
   
}