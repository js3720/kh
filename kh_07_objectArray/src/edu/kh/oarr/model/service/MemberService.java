package edu.kh.oarr.model.service;

import edu.kh.oarr.model.vo.Member;

import java.util.Scanner;

public class MemberService {

    private Scanner sc = new Scanner(System.in);

    // Member 5칸짜리 객체 배열 선언 및 할당
    private Member[] memberArr = new Member[5];

    // 현재 로그인한 회원의 정보를 저장할 변수 선언
    private Member loginMember = null;

    public MemberService(){
        memberArr[0] = new Member("user01","pass01","김일",30,"서울");
        memberArr[1] = new Member("user02","pass02","김이",29,"경기");
        memberArr[2] = new Member("user03","pass03","김삼",28,"인천");
        memberArr[3] = new Member("user04","pass04","김사",27,"제주");
        memberArr[4] = new Member("user05","pass05","김오",26,"서울");
    }

    public void displayMenu(){ // 메뉴화면 출력 기능
        int menuNum = 0; // 메뉴 선택용 변수
        do{
            System.out.println("===== 회원 정보 관리 프로그램 v2 =====");
            System.out.println("1. 회원 가입");
            System.out.println("2. 로그인");
            System.out.println("3. 회원 정보 조회");
            System.out.println("4. 회원 정보 수정");
            System.out.println("5. 회원 검색(지역)");
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
                    int result = updateMember(); // -1, 0, 1
                    System.out.println(result==-1 ? "로그인 후 이용 해주세요." : result==0 ? "회원 정보 수정 실패(비밀번호 불일치)" : "회원 정보가 수정 되었습니다.");
                    break;
                case 5 : searchRegion(); break;
                case 0 : System.out.println("프로그램을 종료합니다..."); break;
                default :System.out.println(""); break;
            }
        }while(menuNum!=0);
    }

    // 회원 가입 메소드
    public String signUp(){
        System.out.println("\n=============== 회원 가입 ===============");

        // 객체 배열(memberArr)에 가입한 회원 정보를 저장할 예정
        // -> 새로운 회원 정보를 저장할 공간이 있는지 확인하고
        //    비었으면 빈 공간의 인덱스 번호를 얻어 온다. --> 새로운 메소드 작성
        int index = emptyIndex(); // memberArr 배열에서 비어있는 인덱스를 반환 받음.
        if(index == -1) return "회원 가입이 불가능합니다.(인원 수 초과)";
        System.out.println("현재 회원 수 : " + index);

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
        System.out.print("지역 : ");
        String region = sc.next();

        if(memberPw1.equals(memberPw2)) {
            memberArr[index] = new Member(memberId,memberPw1,memberName,memberAge,region);
            return "회원 가입 성공 !!!";
        }
        else return "회원 가입 실패 ㅠㅠ (비밀번호 불일치)";
    }

    // memberArr의 비어있는 인덱스 번호 반환하는 메소드
    // 단, 비어있는 인덱스가 없으면 -1 반환
    public int emptyIndex(){
        for(int i=0; i<memberArr.length; i++){
            if(memberArr[i] == null) return i;
        }
        return -1; // for문을 수행 했지만 return이 되지 않은 경우 해당 위치 코드가 수행된다.
    }

    // 로그인 메소드
    public String login(){
        System.out.println("\n=============== 로그인 ===============");
        System.out.print("아이디 : ");
        String memberId = sc.next();
        System.out.print("비밀번호 : ");
        String memberPw = sc.next();

        // 1) memberArr 배열 내 요소를 순서대로 접근하여 null이 아닌지 확인
        for(int i=0; i<memberArr.length; i++){
            // 2) 회원 정보(memberArr[i]의 아이디, 비밀번호와 입력받은 정보가 일치하는지 확인  `
            if(memberArr[i]!=null) {
                if(memberArr[i].getMemberId().equals(memberId) && memberArr[i].getMemberPw().equals(memberPw)){
                    // 3) 로그인 회원 정보 객체(Member)를 참조하는 변수 loginMember에
                    //    현재 접근 중인 memberArr[i] 요소에 저장된 주소를 얕은 복사
                    loginMember = memberArr[i];
                    break; // 더 이상 같은 아이디, 비밀번호가 없기 때문에 for문 종료
                }
            }
        }
        // 4) 로그인 성공/실패 여부에 따라 결과 값을 반환
        if(loginMember==null) return "아이디 또는 비밀번호가 일치하지 않습니다.";
        else return loginMember.getMemberName()+"님 환영합니다.";
    }

    // 회원 정보 조회 메소드
    public String selectMember(){
        System.out.println("\n============ 회원 정보 조회 ============");

        // 1) 로그인 여부 확인
        // 로그인이 안되어 있으면 로그인 후 이용 해주세요 반환
        // 2) 로그인이 되어있는 경우
        //    회원 정보를 출력할 문자열을 만들어서 반환
        //    (단, 비밀번호는 제외)

        if(loginMember == null) return "로그인 후 이용 해주세요.";
        else{
            return "이름 : "+loginMember.getMemberName()+
                    "\n아이디 : "+loginMember.getMemberId()+
                    "\n나이 : "+loginMember.getMemberAge()+"세"+
                    "\n지역 : "+ loginMember.getRegion();
        }
    }

    // 회원 정보 수정 메소드
    public int updateMember(){
        System.out.println("\n============ 회원 정보 수정 ============");
        // 1) 로그인 여부 판별
        //    로그인이 되어있지 않으면 -1 반환.
        if(loginMember == null) return -1;
        // 2) 로그인이 되어 있다면 수정할 회원 정보 입력 받기(이름, 나이, 지역)
        else{
            System.out.print("수정할 이름 : ");
            String memberName = sc.next();
            System.out.print("수정할 나이 : ");
            int memberAge = sc.nextInt();
            System.out.print("수정할 지역 : ");
            String region = sc.next();
            // 3) 비밀번호를 입력 받아서 로그인한 회원의 비밀번호와 일치한지 확인
            System.out.print("비밀번호 입력 : ");
            String inputPw = sc.next();
            // 4) 비밀번호가 같을 경우 로그인한 회원의이름, 나이, 지역정보를 입력받은 값으로 변경 후 1 반환
            if(loginMember.getMemberPw().equals(inputPw)){
                loginMember.setMemberName(memberName);
                loginMember.setMemberAge(memberAge);
                loginMember.setRegion(region);
                return 1;
            }
            // 5) 비밀번호가 다를 경우 0 반환
            else return 0;
        }
    }

    // 회원 검색(지역) 메소드
    public void searchRegion(){
        System.out.println("\n============ 회원 검색(자역) ============");
        System.out.println("검색할 지역을 입력하세요 : ");
        String inputRegion = sc.next();
        boolean flag = true;
        int count = 0;
        char ch = 'a';

        // 1) memberArr 배열의 모든 요소 순차 접근
        for(int i=0; i<memberArr.length; i++){
            // 2) memberArr[i] 요소가 null인 경우 반복 종료
            if(memberArr[i]==null) break;
            // 3) memberArr[i] 요소에 저장된 지역(getRegion())이
            //    입력받은 지역(inputRegion)과 같을 경우(equals()), 회원의 아이디와 이름을 출력
            if(memberArr[i].getRegion().equals(inputRegion)){
                System.out.printf("아이디 : %s, 이름 : %s\n",memberArr[i].getMemberId(),memberArr[i].getMemberName());
                flag = false;
            }
        }
        // 4) 검색 결과가 없을 경우 "일치하는 검색 결과가 없습니다." 출력
        if(flag) System.out.println("일치하는 검색 결과가 없습니다.");
    }

}
