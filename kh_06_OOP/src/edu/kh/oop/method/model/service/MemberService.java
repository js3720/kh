package edu.kh.oop.method.model.service;

import edu.kh.oop.method.model.vo.Member;

import java.util.Scanner;
import java.util.StringTokenizer;


public class MemberService { // 클래스

    // 속성(필드)
    private Scanner sc = new Scanner(System.in);
    // System.in : 자바에서 기본적으로 지정해둔 입력 장치(키보드)

    private Member memberInfo = null; // 가입한 회원의 정보르를 저장할 변수 *아무것도 참조하고 있지 않다
    private Member loginMember = null; // 로그인한 회원의 정보를 저장할 변수

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
                case 4 :
                    //System.out.println(updateMember());
                    int result = updateMember();
                    System.out.println(result ==-1 ? "로그인 후 이용 해주세요." : result==0 ? "회원 정보 수정 실패(비밀번호 불일치)" : "회원 정보가 수정 되었습니다.");
                    break;
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
            loginMember = memberInfo;
            // 참조형 =  Member객체 주소

            // 회원 가입 정보를 loginMember에 대입하여
            // 어떤 회원이 로그인 했는지 구분할 수 있게 한다.
            return loginMember.getMemberName() + "님 환영합니다.";
        }
        else return "아이디 또는 비밀번호가 일치하지 않습니다.";
    }

    public String selectMember(){
        System.out.println("\n***** 회원 정보 조회 *****");
        // 1) 로그인 여부 확인 -> 필드 loginMember가 참조하는 객체가 있는지 확인
        if(loginMember == null) return "로그인 후 이용 해주세요.";
        return "이름 : "+loginMember.getMemberName()+"\n아이디 : "+loginMember.getMemberId()+"\n나이 : "+loginMember.getMemberAge()+"세";
    }

    public int updateMember(){
        // 1) 로그인 여부 판별
        //    호그인이 되어있지 않으면 -1반환
        System.out.println("\n***** 회원 정보 수정 *****");
        if(loginMember==null) return -1;

        // 2) 수정할 회원 정보 입력 받기(이름, 나이)
        System.out.print("수정할 이름 입력 : ");
        String inputName = sc.next();
        System.out.print("수정할 나이 입력 : ");
        int inputAge = sc.nextInt();

        //3) 비밀번호를 입력 받아서
        //   로그인한 회원의 비밀번호와 일치하는지 확인
        System.out.print("비밀번호 입력 : ");
        String inputPw = sc.next();

        if(loginMember.getMemberPw().equals(inputPw)){
            loginMember.setMemberName(inputName);
            loginMember.setMemberAge(inputAge);
            return 1;
        }
        else return 0;

    }

//    public String updateMember(){
//        System.out.println("\n***** 회원 정보 수정 *****");
//        if(loginMember == null) return "로그인 후 이용 해주세요.";
//        String result="";
//
//        System.out.print("비밀번호를 입력 : ");
//        String memberPw = sc.next();
//        if(loginMember.getMemberPw().equals(memberPw)){
//            //System.out.println(selectMember());
//            System.out.println("\n===== 회원 정보 수정 =====");
//            System.out.println("1. 이름 수정");
//            System.out.println("2. 아이디 수정");
//            System.out.println("3. 나이 수정");
//            System.out.println("4. 비밀번호 수정");
//            System.out.println("0. 뒤로 가기");
//            System.out.print("메뉴 입력 >> ");
//            int menuNum = sc.nextInt();
//
//            switch (menuNum){
//                case 1:  System.out.print("이름 : "); loginMember.setMemberName(sc.next()); result= "이름 수정 완료"; break;
//                case 2:  System.out.print("아이디 : "); loginMember.setMemberId(sc.next()); result= "아이디 수정 완료"; break;
//                case 3:  System.out.print("나이 : "); loginMember.setMemberAge(sc.nextInt()); result= "나이 수정 완료"; break;
//                case 4:  {
//                    System.out.print("비밀번호 : ");
//                    String inputPw1 = sc.next();
//                    System.out.print("비밀번호 확인 : ");
//                    String inputPw2 = sc.next();
//                    if(inputPw1.equals(inputPw2)){
//                        loginMember.setMemberPw(inputPw1);
//                        result= "비밀번호 수정 완료";
//                        break;
//                    }
//                    else result= "비밀번호가 일치하지 않습니다."; break;
//                }
//                case 0:  result= "회원 정보 수정 취소"; break;
//                default: result= "잘못 입력 하셨습니다."; break;
//            }
//        }
//        return result;
//    }

}
