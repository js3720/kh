package edu.kh.jdbc.view;

import edu.kh.jdbc.model.service.EmployeeService;
import edu.kh.jdbc.model.vo.Employee;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

// View : 입, 출력 담당 클래스
// -사용자 담당 인터페이스 요소로 사용자의 요청과 으압을 보여주는 화면
public class EmployeeView {
    private Scanner sc = new Scanner(System.in);
    // 공통적으로 호출할 Service 객체를 필드에서 생성
    private EmployeeService service = new EmployeeService();

    /**
     메인 메뉴
     */
    public void displayMenu(){
        int menuNum = 0;

        do{
            try{
                System.out.println();
                System.out.println("====================================");
                System.out.println("[사원 관리 프로그램]");
                System.out.println("1. 전체 사원 정보 조회");
                System.out.println("2. 사번으로 사원 정보 조회");
                System.out.println("3. 새로운 사원 정보 추가");
                System.out.println("4. 사번으로 사원 정보 수정");
                System.out.println("5. 사번으로 사원 정보 삭제");
                System.out.println("6. 입력 받은 급여 이상으로 받는 모든 직원 조회");
                System.out.println("0. 프로그램 종료");
                System.out.println("====================================");
                System.out.print("메뉴 선택 >> ");
                menuNum = sc.nextInt();
                System.out.println();

                switch(menuNum){
                    case 1 : selectAll();break;
                    case 2 : selectOne();break;
                    case 3 : break;
                    case 4 : break;
                    case 5 : break;
                    case 6 : break;
                    case 0 : System.out.println("프로그램을 종료합니다...");break;
                    default:  System.out.println("잘못 입력하셨습니다, 다시 입력 해주세요.");break;
                }

            }catch(InputMismatchException e){
                System.out.println("입력 형식이 잘못되었습니다. 다시 시도 해주세요.");
                menuNum = -1;
                sc.nextLine();
            }
        }while(menuNum !=0);
    }

    /**
     전체 사원 정보 조회 View
     */
    public void selectAll(){
        System.out.println("[전체 사원 정보 조회]");
        // DB에서 조회해온 사원 리스트를 출력

        // 1) 전체 사원 정보를 반환하는 서비스 메서드 호출
        List<Employee> empList = service.selectAll();

        // 2) 서비스 호출 결과를 출력용 메소드를 이용해서 출력
        printList(empList);
    }

    /**
     * Employee List 출력용 View
     * @param empList
     */
    public void printList(List<Employee> empList){
        if( empList.isEmpty() ) System.out.println("조회 결과가 없습니다.");
        else {
            for( Employee emp : empList) System.out.println(emp);
        }
    }

    /**
     * 사번 입력용 View ( 2, 4, 5번 메뉴에 필요)
     * @return
     */
    public int inputEmpId(){
        System.out.print("사번을 입력하세요 : ");
        int empNo = sc.nextInt();
        sc.nextLine();
        return empNo;
    }

    /**
     * 사번으로 사원 정보 조회 View
     */
    public void selectOne(){
        System.out.println("[사번으로 사원 정보 조회]");
        int input = inputEmpId();
        Employee emp = service.selectOne(input);
        // emp가 참조하는 객체가 있는지 확인 == 조회 결과가 있는지 확인

        List<Employee> empList = new ArrayList<>();

        if(emp != null){
            empList.add(emp);
        }
        printList(empList);
    }

}
