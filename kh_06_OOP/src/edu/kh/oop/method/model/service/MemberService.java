package edu.kh.oop.method.model.service;

import edu.kh.oop.method.model.vo.Member;

import java.util.Scanner;
import java.util.StringTokenizer;


public class MemberService { // 클래스

    // 속성(필드)
    private Scanner sc = new Scanner(System.in);
    // System.in : 자바에서 기본적으로 지정해둔 입력 장치(키보드)

    private Member memberInfo = null; // 가입한 회원의 정보르를 저장할 변수 *아무것도 참조하고 있지 않다
    private Member loginMenber = null; // 로그인한 회원의 정보를 저장할 변수

    // 기능 (생성자, 메소드)
    public MemberService(){} // 기본 생성자

    // ** 메소드 작성법 **
    // [접근제한자]  [예약어]           반환형             메소드명    ([매개변수]) {}
    // public       static          기본자료형
    // protected    final           참조형(배열, 클래스)
    // (default)    abstract        void
    // private      static final


    public void displayMenu(){ // 메뉴화면 출력 기능
        int menuNum = 0; // 메뉴 선택용 변수
        do{
            System.out.println("===== 회원 정보 관리 프로그램 v1 =====");
            System.out.println("1. 회원 가입");
            System.out.println("2. 로그인");
            System.out.println("3. 회원 정보 조회");
            System.out.println("4. 회원 정보 수정");
            System.out.println("0. 프로그램 종료");
            System.out.print("메뉴 입력 >> ");
            menuNum = sc.nextInt();
            sc.nextLine(); // 입력버퍼에 남은 개행문자 제거

            switch(menuNum){
                case 1 : System.out.println(signUp()); break;
                // 같은 클래스 내부에 있는 필드, 메소드는 이름만 불러도 호출 가능
                // signUp() 메소드를 호출하여 수행 후 반환 받은 값을 출력
                case 2 : System.out.println(login()); break;
                case 3 : System.out.println(selectMember()); break;
                case 4 : break;
                case 0 : System.out.println("프로그램을 종료합니다."); break;
                default : System.out.println("잘못 입력 하셨습니다. 다시 입력 해주세요."); break;
            }
        }while(menuNum!=0);
    }

    public String signUp(){
        System.out.println("\n****** 회원 가입 기능 ******");
        System.out.print("아이디 : ");
        String memberId = sc.next();
        System.out.print("비밀번호 : ");
        String memberPw1 = sc.next();
        System.out.print("비밀번호 확인 : ");
        String memberPw2 = sc.next();
        System.out.print("이름 : ");
        String memberName = sc.next();
        System.out.print("나이 : ");
        int memberAge = sc.nextInt();

        if(memberPw1.equals(memberPw2)) {
            memberInfo = new Member(memberId,memberPw1,memberName,memberAge);
            return "회원 가입 성공!!";
        }
        else return "회원 가입 실패!! (비밀번호 불일치)";
    }

    public String login(){
        System.out.println("\n***** 로그인 *****");
        // 회원 가입을 했는지 부터 확인
        // == memberInfo가 객체를 참조하고 있는지 확인
        if(memberInfo==null) return "회원 가입부터 진행 해주세요.";

        System.out.print("아이디 입력 : ");
        String memberId = sc.next();
        System.out.print("비밀번호 입력 : ");
        String memberPw = sc.next();
        if(memberInfo.getMemberId().equals(memberId) && memberInfo.getMemberPw().equals(memberPw)){
            loginMenber = memberInfo;
            // 참조형 =  Member객체 주소

            // 회원 가입 정보를 loginMember에 대입하여
            // 어떤 회원이 로그인 했는지 구분할 수 있게 한다.
            return loginMenber.getMemberName() + "님 환영합니다.";
        }
        else return "아이디 또는 비밀번호가 일치하지 않습니다.";
    }

    public String selectMember(){
        System.out.println("\n***** 회원 정보 조회 *****");
        // 1) 로그인 여부 확인 -> 필드 loginMember가 참조하는 객체가 있는지 확인
        if(loginMenber == null) return "로그인 후 이용 해주세요.";
        return "이름 : "+loginMenber.getMemberName()+"\n아이디 : "+loginMenber.getMemberId()+"\n나이 : "+loginMenber.getMemberAge()+"세";
    }

}
