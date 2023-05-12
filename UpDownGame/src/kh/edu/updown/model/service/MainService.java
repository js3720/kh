package kh.edu.updown.model.service;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import kh.edu.updown.model.vo.Member;

public class MainService {

    private Scanner sc = new Scanner(System.in);

    // 회원 가입된 회원의 정보를 저장할 리스트 생성
    private List<Member> members = new ArrayList<Member>();

    // 현재 로그인한 회원의 정보를 참조할 변수 선언.
    private Member loginMember = null; // 로그인 X == null,  로그인 O != null

    // LoginService 생성
    // -> 로그인 시 이용할 수 있는 기능만을 모아둔 객체
    private LoginService loginService = new LoginService();

    // 메뉴 출력 메소드
    // * 메뉴 출력 메소드를 분석해보세요!
    public void displayMenu() {
        int sel = 0; // 메뉴 선택용 변수

        do {
            try {
                System.out.println("\n=== UP/DOWN 게임 ===");

                if(loginMember == null) { // 로그인이 되어있지 않은 경우

                    System.out.println("[메인 메뉴]");
                    System.out.println("1. 회원가입");
                    System.out.println("2. 로그인");
                    System.out.println("0. 종료");
                    System.out.print("메뉴 선택 >> ");

                    sel = sc.nextInt();
                    sc.nextLine(); // 입력 버퍼 개행문자 제거
                    System.out.println(); // 줄바꿈

                    switch(sel) {
                        case 1 : signUp(); break;
                        case 2 : login(); break;
                        case 0 : System.out.println("[프로그램 종료]"); break;
                        default : System.out.println("잘못 입력하셨습니다. 메뉴를 다시 선택해주세요."); break;
                    }

                }else { // 로그인이 되어있는 경우

                    System.out.println("[로그인 메뉴]");
                    System.out.println("1. 업/다운 게임 start");
                    System.out.println("2. 내 정보 조회");
                    System.out.println("3. 전체 회원 조회");
                    System.out.println("4. 비밀번호 변경");
                    System.out.println("9. 로그아웃");
                    System.out.println("0. 프로그램 종료");
                    System.out.print("메뉴 선택 >> ");

                    sel = sc.nextInt();
                    sc.nextLine();
                    System.out.println();


                    // 선택된 메뉴 번호에 따라 LoginService에서 알맞은 기능을 호출
                    switch (sel) { // 메소드명(20);
                        case 1: loginService.startGame(loginMember); break;
                        case 2: loginService.selectMyInfo(loginMember); break;
                        case 3: loginService.selectAllMember(members); break;
                        case 4: loginService.updatePassword(loginMember); break;
                        case 9 : System.out.println("[로그아웃 되었습니다.]");
                            loginMember = null; // loginMember 필드에 아무것도 참조하고 있지 않음을 의미하는 null을 대입
                            break;
                        case 0 : System.out.println("[프로그램 종료]"); break;
                        default: System.out.println("잘못 입력하셨습니다. 메뉴를 다시 선택해주세요."); break;
                    }
                }
            }catch (InputMismatchException e) {
                System.out.println("입력 형식이 올바르지 않습니다. 다시 시도해 주세요.");
                sc.nextLine(); // 버퍼에 남아있는 문자열 제거
            }
        }while(sel != 0);

    }
    // [회원 가입]
    // 아이디, 비밀번호, 이름을 입력 받고
    // Member객체를 생성하여 members 리스트에 추가
    // 단, 이미 중복되는 아이디가 존재하는 경우 가입 불가
    public void signUp() throws InputMismatchException {
        boolean flag = true; // 검사전에 기본상태 ( 겹치는게 없는 상태 )

        System.out.println("[회원 가입]");
        System.out.print("아이디 : ");
        String id = sc.next();
        System.out.print("비밀번호 : ");
        String pw = sc.next();
        System.out.print("이름 : ");
        String name = sc.next();
        for(Member m : members){
            if(m.getMemberId().equals(id)) flag = false;
        }
        if(flag) {
            members.add(new Member(id,pw,name));
            System.out.println(name+"님 가입되셨습니다.");
        }
        else System.out.println("중복되는 ID가 있어 가입이 불가합니다.");
    }

    // [로그인]
    // 아이디, 비밀번호를 입력 받아 일치하는 회원이 members에 있을 경우 로그인
    // 없으면 "아이디 또는 비밀번호가 일치하지 않습니다." 출력
    public void login() throws InputMismatchException {
        boolean flag = true;
        System.out.println("[로그인]");
        System.out.print("아이디 :");
        String id = sc.next();
        System.out.print("비밀번호 :");
        String pw = sc.next();
        for(Member m : members){
            if(m.getMemberId().equals(id) && m.getMemberPw().equals(pw)){
                loginMember = m; // 현재 로그인 했는지 판별하는 로그인맴버 참조변수에 일치하는 회원객체의 주소값을 얕은복사
                flag = false;
            }
        }
        if(flag) System.out.println("아이디 또는 비밀번호가 일치하지 않습니다.");
        else System.out.println(loginMember.getMemberName()+"님 환영합니다");
    }

}
