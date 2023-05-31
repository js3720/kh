package edu.kh.jdbc.member.view;

import edu.kh.jdbc.member.model.service.MemberService;
import edu.kh.jdbc.member.model.vo.Member;

import java.sql.SQLOutput;
import java.util.List;
import java.util.Scanner;

public class MemberView { // 회원 관련 화면 입출력

    private Scanner sc = new Scanner(System.in);

    // 회원 관련 서비스 제공 객체 생성 및 참조
    private MemberService service = new MemberService();

    /**
     * 회원 가입 화면 출력용 메소드
     */
    public void signUp() {
        System.out.println("[회원 가입]");

        try {
            String memberId = null;
            String memberPw = null;
            String memberPw2 = null;
            String memberName = null;
            char memberGender = ' ';

            while (true) { // 중복 아이디가 없을 경우 종료하는 if문 필요
                System.out.print("아이디 : ");
                memberId = sc.next();

                /* 아이디 중복 검사 (DB에 일치하는 아이디 있으면 "중복" -> 다시 아이디 입력 받기  */
                int result = service.duplicateCheck(memberId); // result 중복이면 1, 중복아니면 0 반환 예정

                if (result == 0) { // 중복이 아니면 반복문 종료
                    System.out.println("[사용 가능한 아이디 입니다.]");
                    break;

                } else {
                    System.out.println("[이미 사용중인 아이디 입니다. 다시 입력 해주세요.]");
                }

            } // 중복 검사 while문 종료

            // 비밀번호, 비밀번호 확인을 각각 입력받아
            // 일치할 때 까지 무한반복
            while (true) {

                System.out.print("비밀번호 : ");
                memberPw = sc.next();

                System.out.print("비밀번호 확인 : ");
                memberPw2 = sc.next();

                if (memberPw.equals(memberPw2)) break; // 일치하면
                else System.out.println("\n[비밀번호가 일치하지 않습니다. 다시 입력 해주세요.]");

            }// 비밀번호 확인 while 종료

            // 이름 입력
            System.out.print("회원 이름 : ");
            memberName = sc.next();

            // 성별이 'M' 또는 'F'가 입력 될 때 까지 반복

            while (true) {
                System.out.print("성별(M/F) : ");
                memberGender = sc.next().toUpperCase().charAt(0);

                if (memberGender != 'M' && memberGender != 'F') {
                    System.out.println("\n[성별을 M 또는 F만 입력 해주세요.]\n");
                }
                else break;
            }

            // 입력 받은 값을 하나의 객체(Member)에 저장
            Member signupMember = new Member(memberId,memberPw,memberName,memberGender);

            // 회원가입 Service 호출 후 결과 반환 받기
            // -회원가입 == DB에 회원 정보 삽입 == INSERT(DML)
            //  -> DML구문 수행 시 성공한 행의 개수가 반환됨 == int형 변수로 결과를 저장
            int result = service.signUp(signupMember);

            if(result > 0) System.out.println("\n***회원 가입 성공***\n");
            else System.out.println("[회원 가입 실패]");

        }catch(Exception e){
            System.out.println("\n<회원 가입 중 예외 발생>");
            e.printStackTrace(); // 예외 내용 출력
        }
    }

    /**
     * 회원 로그인 메소드
     */
    public Member login() {
        System.out.println("[로그인]");
        System.out.print("아이디 : ");
        String memberId = sc.next();

        System.out.print("비밀번호 : ");
        String memberPw = sc.next();

        // Member 객체를 생성하여 입력 받은 값 세팅
        Member mem = new Member();
        mem.setMemberId(memberId);
        mem.setMemberPw(memberPw);

        // 로그인 Service 수행 후 결과 반환 받기
        Member loginMember = null;
        try{
            loginMember = service.login(mem);
            if(loginMember != null) {
                System.out.println("\n*** "+loginMember.getMemberName()+"님 환영합니다. ***\n");
            }
            else {
                System.out.println("\n[아이디 또는 비밀번호가 일치하지 않습니다.]\n");// 로그인 실패( 아이디 또는 비밀번호 불일치 또는 탈퇴한 회원)
            }
        }catch (Exception e){
            System.out.println("\n<로그인 과정에서 예외 발생>\n");
            e.printStackTrace();
        }
        return loginMember;
    }

    /**
     * 내 정보 조회 메소드
     * @param loginMember
     */
    public void myInfo(Member loginMember) {
        System.out.println("[내 정보 조회]");
        System.out.println("회원 번호 : "+ loginMember.getMemberNo());
        System.out.println("아이디 : "+ loginMember.getMemberId());
        System.out.println("이름 : "+ loginMember.getMemberName());
        System.out.println("성별 : "+ (loginMember.getMemberGender()=='M' ? "남성" : "여성"));
        System.out.println("가입일 : "+ loginMember.getEnrollDate());
    }

    /**
     * 전체 회원 조회 메소드
     * @return
     */
    public List<Member> selectAll() {
        System.out.println("[가입된 회원 목록 조회]");
        List<Member> memberList = null;
        try{
            memberList = service.selectAll();
            if(memberList.isEmpty()) System.out.println("조회 결과가 없습니다.");
            else for(Member m : memberList) System.out.printf("%-12s %-12s %-12s\n",m.getMemberId(), m.getMemberName(), m.getEnrollDate().toString());
        }catch (Exception e){
            System.out.println("\n<회원 목록 조회 과정에서 예외 발생>\n");
            e.printStackTrace();
        }
        return  memberList;
    }

    /**
     * 내 정보 수정 메소드
     * @param loginMember
     */
    public void updateMyInfo(Member loginMember) {
        System.out.println("[내 정보 수정(이름, 성별)]");

        System.out.print("변경할 이름 : ");
        String memberName = sc.next();
        System.out.print("변경할 성별(M/F) : ");
        char memberGender = sc.next().toUpperCase().charAt(0);

        // 입력 받은 값 + 로그인한 회원 번호를 하나의 Member 객체에 저장
        // (로그인한 회원 번호 == 어떤 회원 정보를 수정할지 지정)

        Member updateMember = new Member();
        updateMember.setMemberName(memberName);
        updateMember.setMemberGender(memberGender);
        updateMember.setMemberNo(loginMember.getMemberNo());

        try{
            int result = service.updateMyInfo(updateMember);
            if(result>0){
                System.out.println("\n[회원 정보가 수정되었습니다.]\n");
                loginMember.setMemberName(memberName);
                loginMember.setMemberGender(memberGender);
            }
            else System.out.println("\n[회원 정보 수정에 실패하였습니다.]\n");
        }catch (Exception e){
            System.out.println("\n<내 정보 수정 과정에서 예외 발생>\n");
            e.printStackTrace();
        }
    }

    /**
     * 비밀번호 변경 메소드
     * @param loginMember
     */
    public void updatePw(Member loginMember) {
        String newPw;
        String updatePw2;
        System.out.println("[비밀번호 변경]");

        // 현재 비밀번호 --> DB Update 조건(WHERE)
        System.out.print("현재 비밀번호 : ");
        String currentPw = sc.next();

        // currentPw.equals(loginMember.getMemberPw())
        while(true){
            System.out.print("새 비밀번호 : ");
            newPw = sc.next();
            System.out.print("새 비밀번호 확인 : ");
            updatePw2 = sc.next();

            if(newPw.equals(updatePw2)) break;
            else System.out.println("\n새 비밀번호가 일치하지 않습니다. 다시 입력해주세요.\n");
        }
        try{
            int result = service.updatePw(loginMember.getMemberNo(), currentPw, newPw);
            if(result>0){
                System.out.println("\n[비밀번호가 수정되었습니다.]\n");
                loginMember.setMemberPw(newPw);
            }
            else System.out.println("\n[비밀번호 변경에 실패하였습니다.]\n");
        }catch (Exception e){
            System.out.println("\n<비밀번호 변경 과정에서 예외 발생>\n");
            e.printStackTrace();
        }
    }

    /**
     * 회원 탈퇴 메소드
     * @param loginMember
     * @return
     */
    public boolean secession(Member loginMember) {
        System.out.println("[회원 탈퇴]");

        // 1. 현재 비밀번호 입력 받기
        System.out.print("현재 비밀번호 : ");
        String memberPw = sc.next();

        // 2. 탈퇴여부 한번더 물어보기
        System.out.print("정말 탈퇴하시겠습니까?(Y/N) : ");
        char ch = sc.next().toUpperCase().charAt(0);

        // 3. Y입력 시 탈퇴 service 수행
        if(ch == 'Y'){
            try{
                int result = service.secession(loginMember.getMemberNo(), memberPw);
                if(result>0){
                    System.out.println("\n[탈퇴 되었습니다.]\n");
                    return true;
                }
                else System.out.println("\n[비밀번호가 일치하지 않습니다.]\n");
            }catch(Exception e){
                System.out.println("\n<회원 탈퇴 과정에서 예외 발생>\n");
                e.printStackTrace();
            }
        }
        else System.out.println("\n[회원 탈퇴 취소]\n");
        return false;
    }
}
