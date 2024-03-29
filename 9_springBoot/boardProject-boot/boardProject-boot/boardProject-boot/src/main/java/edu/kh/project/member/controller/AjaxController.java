package edu.kh.project.member.controller;



import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import edu.kh.project.member.model.dto.Member;
import edu.kh.project.member.model.service.AjaxService;
import oracle.jdbc.proxy.annotation.Post;

@Controller // 요청/응답 제어 + bean 등록
public class AjaxController {

	@Autowired // DI
	private AjaxService service;

	// 이메일로 닉네임 조회
	@GetMapping(value="/selectNickname", produces = "application/text; charset=UTF-8")
	@ResponseBody
	public String selectNickname(String email) {
		// 쿼리스트링에 담긴 파라미터
		return service.selectNickname(email);
	}

	// 닉네임으로 전화번호 조회
	@GetMapping("/selectMemberTel")
	@ResponseBody
	public String selectMemberTel(String nickname) {
		// 쿼리스트링에 담긴 파라미터

		// return 리다이렉트 / 포워드; -> 새로운 화면이 보임(동기식)

		// return 데이터; -> 데이터를 요청한 곳으로 반환(비동기식)

		return service.selectMemberTel(nickname);
	}


	// 이메일 중복 검사

	// !!produces 속성은 한글 깨질 때 사용!!
	@GetMapping("/dupCheck/email")
	@ResponseBody // HttpMessageConverter를 이용해
	// JS에서 인식할 수 있는 형태(TEXT/JSON)변환
	// + 비동기 요청한 곳으로 돌아감

	/* jack-databind pom.xml에 추가!*/
	public int checkEmail(String email) {
		return service.checkEmail(email);
	}

	// 닉네임 중복 검사
	@GetMapping("/dupCheck/nickname")
	@ResponseBody
	public int checkNickname(String nickname) {
		return service.checkNickname(nickname);
	}

	// 이메일로 회원 정보 조회
	@PostMapping(value="/selectMember", produces="application/json; charset=UTF-8")
	@ResponseBody // Java 데이터 -> JSON, TEXT로 변환 + 비동기 요청한 곳으로 응답
	public Member selectMember(@RequestBody Map<String, Object> paramMap) {

		// @RequestBody Map<String, Object> paramMap
		// -> 요청된 HTTP Body에 담긴 모든 데이터를 Map으로 반환

		String email = (String)paramMap.get("email");

		return service.selectMember(email);
	}


	// 이메일이 일부라도 일치하는 모든회원 조회
	@PostMapping(value="/selectMemberList", produces="application/json; charset=UTF-8")
	@ResponseBody
	public List<Member> selectMemberList(@RequestBody String input){

		return service.selectMemberList(input);

	}

}
