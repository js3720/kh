package kh.edu.updown.model.service;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import kh.edu.updown.model.vo.Member;

public class LoginService {

    private Scanner sc = new Scanner(System.in);
    // 업다운 게임 시작
    // 1 ~ 100 사이 숫자 중 랜덤하게 한 숫자를 지정하고 업/다운 게임을 진행
    // 맞춘 횟수가 현재 로그인한 회원의 최초 또는 최고 기록인 경우 회원의 highScore 필드 값을 변경
    public void startGame(Member loginMember) throws InputMismatchException {
        System.out.println("[Game Start...]");
        int num = (int)(Math.random()*100)+1;
        int count =0;
        int input =0;
        do{
            System.out.print(++count +"번째 입력 : ");
            input = sc.nextInt();
            if(input>num) System.out.println("-- DOWN --");
            else if(input<num) System.out.println("-- UP --");
            else System.out.println("정답입니다!!!!");
        }
        while(input!=num);
        System.out.println("입력 시도 횟수 : "+count);
        if(loginMember.getHighScore()==0 || loginMember.getHighScore()>count){
            System.out.println("*** 최고 기록 달성 ***");
            loginMember.setHighScore(count);
        }
    }


    // 내 정보 조회
    // 로그인한 멤버의 정보 중 비밀번호를 제외한 나머지 정보만 화면에 출력
    public void selectMyInfo(Member loginMember) {
        System.out.println("[내 정보 조회]");
        System.out.println("아이디 : "+loginMember.getMemberId());
        System.out.println("이름 : "+loginMember.getMemberName());
        System.out.println(loginMember.getHighScore()==0 ? "점수 기록이 없습니다." : "최고점수 : "+loginMember.getHighScore()+"회");
    }

    // 전체 회원 조회
    // 전체 회원의 아이디, 이름, 최고점수를 출럭
    public void selectAllMember(List<Member> members) {
        System.out.println("[전체 회원 조회]");
        if(!members.isEmpty()){
            for(Member m : members){
                if(m != null) System.out.println(m);
                else break;
            }
        }
    }

    // 비밀번호 변경
    // 현재 비밀번호를 입력 받아
    // 같은 경우에만 새 비밀번호를 입력 받아 비밀번호 변경
    public void updatePassword(Member loginMember) throws InputMismatchException {
        System.out.println("[비밀번호 변경]");
        System.out.print("현재 비밀번호 : ");
        String input1 = sc.next();
        if(input1.equals(loginMember.getMemberPw())) {
            System.out.print("변경 할 비밀번호 : ");
            String pw1 = sc.next();
            System.out.print("변경 할 비밀번호 재입력 : ");
            String pw2 = sc.next();
            if(pw1.equals(pw2)) {
                loginMember.setMemberPw(pw1);
                System.out.println("비밀번호 변경 완료");
            }
            else System.out.println("변경할 비밀번호가 일치하지 않습니다.");
        }
        else System.out.println("현재 비밀번호가 일치하지 않습니다.");
    }
}
