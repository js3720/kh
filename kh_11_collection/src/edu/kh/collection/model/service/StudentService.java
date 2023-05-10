package edu.kh.collection.model.service;

import edu.kh.collection.model.vo.Student;

import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class StudentService {

    private Scanner sc = new Scanner(System.in);
    // 학생 정보를 저장할 List(객체 배열 Upgrade버전)
    // java.util.List 인터페이스 : List에 반드시 필요한 필수 기능을 모아둔 인터페이스
    // *인터페이스는 객체 생성X, 부모 참조 변수 O
    // ArrayList() 기본생성자 : 기본 크기 10짜리 리스트 생성 -> 크기가 변하기 때문에 큰 의미 없음

    List<Student> studentList = new ArrayList<Student>();
    List arrList = new ArrayList();
    // Student로 저장되는 타입이 제한된 리스트 생성
    // instanceof로 타입을 검사할 필요가 없이
    // 저장된 모든값이 Student 타입이다.

    public StudentService(){
        studentList.add(new Student("박서준",28,"서울시 강서구",'M',90));
        studentList.add(new Student("김종수",22,"서울시 중구",'M',100));
        studentList.add(new Student("정해인",29,"서울시 강남구",'M',80));
        studentList.add(new Student("박진아",23,"서울시 관악구",'M',95));
        studentList.add(new Student("문광민",32,"경기도 부천시",'M',100));
    }

    public void ex(){
        // List 테스트
        // List.add(Object e) : 리스트에 객체를 추가
        // * 매개변수 타입이 Object == 모든 객체 매개변수로 전달할 수 있음
        // (매개변수 Object == 최상위 부모 참조 변수 == 다형성 적용 가능)

        studentList.add(new Student()); // 0번 인덱스
//        studentList.add(sc);            // 1번 인덱스
//        studentList.add("문자열");       // 2번 인덱스
//        studentList.add(new Object());  // 3번 인덱스
        // -> 컬렉션 특징 : 여러 타입의 데이터를 저장할 수 있다.

        // Object List.get(index i) : 리스트에서 i번째 인덱스에 있는 객체(Object)를 반환한다.
        // 반환형이 Object == 모든 객체를 반환할 수 있다.
        System.out.println(studentList.get(0).toString());
        // 실행 전 : java.lang.Object.toString() == 정적 바인딩
        // 실행 후 : 알고 보니 0번째는 Strudent 객체이고, toString()이 오버라이딩 되어있음
        //          -> Student.toString()이 수행됨 == 동적 바인딩

        if(studentList.get(0) instanceof Student){
            System.out.println(((Student)studentList.get(0)).getName());
        }
        // 코드가 길고 복잡함...
        // -> 컬렉션의 장점인 여러 객체 저장이 오히려 코딩에 방해됨
        // 그래서 등장 했다! **********제네릭스(Generics)**********
        // (보통 제네릭 이라고 함) <>
        // [제일 중요한 역할!]
        // 컬렉션이 저장되는 객체 타입을 한가지로 제한
        System.out.println(studentList.get(0).getName());
    }

    // 메소드 설명용 주석
    /** 메뉴 출력용 메소드 @author 김종수*/
    public void displayMenu(){
        int menuNum = 0;
        do{
            System.out.println("\n========= 학생 관리 프로그램 =========\n");
            System.out.println("1. 학생 정보 추가");
            System.out.println("2. 학생 전체 조회");
            System.out.println("3. 학생 정보 수정");
            System.out.println("4. 학생 정보 제거");
            System.out.println("5. 이름으로 검색(일치)");
            System.out.println("6. 이름으로 검색(포함)");
            System.out.println("0. 프로그램 종료");
            System.out.print("\n메뉴 번호 선택 >> ");
            try{
                menuNum = sc.nextInt();
                switch(menuNum){
                    case 1 : System.out.println(addStudent());break;
                    case 2 : selectAll(); break;
                    case 3 : System.out.println(updateStudent());break;
                    case 4 : System.out.println(removeStudent());break;
                    case 5 : searchName1();break;
                    case 6 : searchName2();break;
                    case 0 : System.out.println("<프로그램 종료>");break;
                    default : System.out.println("메뉴에 작성된 번호만 입력해주세요.");break;
                }
            }catch (InputMismatchException e){
                System.out.println("\nERROR : 입력 형식이 유효하지 않습니다. 다시 시도해 주세요.");
                sc.nextLine();
                menuNum = -1;
            }
        }while(menuNum !=0);
    }

    /** 학생 정보 추가 메소드
     * - 추가 성공 시 "성공", "실패" 문자열 반환
     * */
    public String addStudent() throws InputMismatchException {
        System.out.println("=========== 학생 정보 추가 ===========");
        System.out.print("이름 : ");
        String name = sc.next();
        System.out.print("나이 : ");
        int age = sc.nextInt();
        sc.nextLine();
        System.out.print("사는곳 : ");
        String region = sc.nextLine();
        System.out.print("성별(M/F) : ");
        char gender = sc.next().toUpperCase().charAt(0);
        System.out.print("점수 : ");
        int score = sc.nextInt();

        if(studentList.add(new Student(name,age,region,gender,score))) return "성공";
        else return "실패";
        // boolean java.utile.List.add(Student e)
        // (반환형)            -> 제네릭 <Student> 때문에 List타입이 Student로 제한됨
        // add()는 무조건 true를 반환하기 때문에 실패하는 경우가 거의 없음
        // 대신 예외가 발생해서 add()수행 전 메소드가 종료될 순 있음
    }

    public void selectAll(){
        // -List는 인덱스가 있다. (0번부터 시작)
        // - List에 저장된 데이터의 개수를 얻어오는 방법 : int List.size(); -> 배열명.length 대신 사용

        //if(studentList.size()==0){
        // - List가 비어있는지 확인하는 방법 -> boolean List.isEmpty() : 비어있으면 true를 반환
        if(studentList.isEmpty()){
            System.out.println("학생 정보가 없습니다.");
            return; // 현재 메소드를 종료하고 호출한 곳으로 돌아감 (단, 반환값은 없음(void))
        }
        for(Student s : studentList) System.out.println(s);
        // 향상된 for문 (for each 문)
        // -컬렉션, 배열의 모든 요소를 순차적으로 반복 접근할 수 있는 for문
        // (순차적 : 0번 인덱스부터 마지막 요소까지 인덱스를 1씩 증가)
        // [작성법]
        // for(컬렉션 또는 배열에서 꺼낸 한 개의 요소를 저장할 변수 : 컬렉션명 또는 배열명){}
    }
    /** 학생 정보 수정 메소드 */
    public String updateStudent() throws InputMismatchException{
        // Student List.set(int index, Student e)
        //  -> List의 i번째 요소를 전달받은 e로 변경
        System.out.println("=========== 학생 정보 수정 ===========");
        System.out.print("인덱스 번호 입력 : ");
        int index = sc.nextInt();
        sc.nextLine();
        if(studentList.isEmpty()) return "입력된 학생 정보가 없습니다.";
        else if(index < 0) return "음수는 입력할 수 없습니다.";
        else if(index >= studentList.size()) return "범위를 넘어선 값을 입력할 수 없습니다.";
        else{
            System.out.println(index + "번째 인덱스에 저장된 학생 정보");
            System.out.println(studentList.get(index));
            System.out.print("이름 : ");
            String name = sc.next();
            System.out.print("나이 : ");
            int age = sc.nextInt();
            sc.nextLine();
            System.out.print("사는곳 : ");
            String region = sc.nextLine();
            System.out.print("성별(M/F) : ");
            char gender = sc.next().toUpperCase().charAt(0);
            System.out.print("점수 : ");
            int score = sc.nextInt();
            Student temp = studentList.set(index, new Student(name,age,region,gender,score));
            // 입력받은 index번째에 새로운 학생 정보를 세팅 == 수정
            // 이때, List.set메소드 종료 후 index번째에 있던 기존 학생 정보가 반환된다.
            return temp.getName()+"의 정보가 변경되었습니다.";
        }
    }

    /** 학생 정보 제거 메소드 */
    public String removeStudent() throws InputMismatchException{
        // -Student List.remove(int index)
        // 리스트에서 index번째 요소를 제거
        // 이 때, 제거된 요소가 반환된다.

        // List는 중간에 비어있는 인덱스가 없게 하기 위해서
        // remove()동작 시 뒤쪽 요소를 한 칸씩 당겨온다.

        System.out.println("=========== 학생 정보 제거 ===========");
        System.out.print("인덱스 번호 입력 : ");
        int index = sc.nextInt();
        sc.nextLine();
        if(studentList.isEmpty()) return "입력된 학생 정보가 없습니다.";
        else if(index < 0) return "음수는 입력할 수 없습니다.";
        else if(index >= studentList.size()) return "범위를 넘어선 값을 입력할 수 없습니다.";
        else{
            System.out.print("정말 삭제 하시겠습니까?(Y/N) : ");
            char ch = sc.nextLine().toUpperCase().charAt(0);
            if(ch == 'Y') {
                Student temp = studentList.remove(index);
                return temp.getName()+"의 정보가 제거되었습니다.";
            }
            else return "취소";
        }
    }
    /** 이름이 일치하는 학생을 찾아서 조회하는 메소드*/
    public void searchName1() throws InputMismatchException{
        System.out.println("=========== 학생 검색(이름 일치) ===========");
        System.out.print("검색할 이름 입력 :");
        String input = sc.next();
        int count=0;
        for(Student s : studentList){
            if(s.getName().equals(input)){
                System.out.println(s);
                count++;
            }
        }
        if(count!=0) System.out.println("총"+count+"명의 학생을 찾았습니다.");
        else System.out.println("검색 결과가 없습니다.");
    }

    /** 이름에 특정 문자열이 포함되는 학생을 찾아서 조회하는 메소드*/
    public void searchName2() throws InputMismatchException{
        System.out.println("=========== 학생 검색(이름 포함) ===========");
        System.out.print("이름에 포함되는 문자열 입력 :");
        String input = sc.next();
        int count=0;
        for(Student s : studentList){
            if(s.getName().contains(input)){
                System.out.println(s);
                count++;
            }
        }

        if(count!=0) System.out.println("총"+count+"명의 학생을 찾았습니다.");
        else System.out.println("검색 결과가 없습니다.");
    }
}
