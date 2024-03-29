package edu.kh.project.member.model.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.kh.project.member.model.dto.Member;

@Repository
public class MemberDAO{
	
	@Autowired
	private MemberMapper memberMapper; // MemberMapper 인터페이스를 상속 받은 자식 객체
									   // -> 자식 객체가 SqlSessionTemplate을 이용
	
	public Member login(Member inputMember) {
	
		return memberMapper.login(inputMember);
		
	}
	
	/** 회원 가입
	 * @param inputMember
	 * @return result
	 */
	public int signUp(Member inputMember) {
		
		return memberMapper.signUp(inputMember);
	}
}
