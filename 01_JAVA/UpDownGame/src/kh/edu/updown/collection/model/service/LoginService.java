package kh.edu.updown.collection.model.service;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;
import kh.edu.updown.model.vo.Member;

public class LoginService {

    private Scanner sc = new Scanner(System.in);

    // 업다운 게임 시작
    // 1 ~ 100 사이 숫자 중 랜덤하게 한 숫자를 지정하고 업/다운 게임을 진행
    // 맞춘 횟수가 현재 로그인한 회원의 최초 또는 최고 기록인 경우 회원의 highScore 필드 값을 변경
    public void startGame(Member loginMember) throws InputMismatchException{
        System.out.println("[Game Start...]");
        int count =0;
        int input =0;
        int random = (int)(Math.random()*100+1);
        while(input != random){
            System.out.print(++count+"번째 입력 : ");
            input = sc.nextInt();
            System.out.println(input>random ? "-- DOWN --" : input<random ? "-- UP --" : "정답!!!");
        }
        if(loginMember.getHighScore()==0 || loginMember.getHighScore()>count) {
            loginMember.setHighScore(count);
            System.out.println("입력 시도 횟수 : "+count+"\n*** 최고 기록 달성 ***");
        }
    }

    // 내 정보 조회
    // 로그인한 멤버의 정보 중 비밀번호를 제외한 나머지 정보만 화면에 출력
    public void selectMyInfo(Member loginMember) {
        System.out.println("[내 정보 조회]\n"+loginMember);
    }

    // 전체 회원 조회
    // 전체 회원의 아이디, 이름, 최고점수를 출럭
    public void selectAllMember(List<Member> members) {
        System.out.println("[전체 회원 조회]");
        if(members.isEmpty()) System.out.println("등록된 회원이 없습니다");
        else for(Member m : members) System.out.println(m);
    }

    // 비밀번호 변경
    // 현재 비밀번호를 입력 받아
    // 같은 경우에만 새 비밀번호를 입력 받아 비밀번호 변경
    public void updatePassword(Member loginMember) {
        System.out.println("[비밀번호 변경]");
        System.out.print("현재 비밀번호 입력 : ");
        String pw1 = sc.next();
        if(loginMember.getMemberPw().equals(pw1)){
            System.out.print("변경 할 비밀번호 입력 : ");
            String pw2 = sc.next();
            System.out.print("변경 할 비밀번호 재입력 : ");
            String pw3 = sc.next();
            if(pw2.equals(pw3)){
                loginMember.setMemberPw(pw3);
                System.out.println("비밀번호 변경 성공");
            } else System.out.println("비밀번호 입력 실패");
        }
    }
}