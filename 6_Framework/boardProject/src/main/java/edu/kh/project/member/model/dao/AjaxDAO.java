package edu.kh.project.member.model.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository // DB 연결 의미 + bean 등록
public class AjaxDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSession;

	/** 이메일로 닉네임 조회
	 * @param email
	 * @return nickname
	 */
	public String selectNickname(String email) {
		return sqlSession.selectOne("ajaxMapper.selectNickname",email);
	}

	/** 닉네임으로 전화번호 조회
	 * @param nickname
	 * @return tel
	 */
	public String selectMemberTel(String nickname) {
		return sqlSession.selectOne("ajaxMapper.selectMemberTel",nickname);
	}

	/** 이메일 중복 검사
	 * @param email
	 * @return email
	 */
	public int checkEmail(String email) {
		return sqlSession.selectOne("ajaxMapper.checkEmail",email);
	}

	/** 닉네임 중복 검사
	 * @param nickname
	 * @return count
	 */
	public int checkNickname(String nickname) {
		return sqlSession.selectOne("ajaxMapper.checkNickname",nickname);
	}
}
