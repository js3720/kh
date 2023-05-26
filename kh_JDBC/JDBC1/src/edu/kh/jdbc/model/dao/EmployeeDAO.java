package edu.kh.jdbc.model.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import edu.kh.jdbc.model.vo.Employee;

// DAO(Data Access Object) : 데이터 접근 객체
// - DB와 연결되어 SQL를 수행하고 결과를 반환 받는 혁할

public class EmployeeDAO {

    // JDBC 객체 저장용 참조 변수 필드 선언
    private Connection conn;
    // DB 연결 정보를 담은 객체 (Java - DB사이의 통로 역할)

    private Statement stmt;
    // Connection을 통해 SQL을 수행하고 결과를 반환 받는 객체

    private ResultSet rs;
    // SELECT 수행 후 반환되는 객체


    /**
     * 전체 사원 정보 조회 DAO
     * @return
     */
    public List<Employee> selectAll() {
        // 결과 저장용 변수 준비
        List<Employee> empList = new ArrayList<Employee>();

        try {

            // 1) Oracle JDBC Driver 메모리 로드 ** 꼭 써줘야함 **
            Class.forName("oracle.jdbc.driver.OracleDriver");

            // 2) DB 연결 작업(Connection 얻어오기)
            String type = "jdbc:oracle:thin:@"; // JDBC 드라이버 thin 타입

            String ip = "localhost"; // DB 서버 컴퓨터 IP
            String port = ":1521";
            String sid = ":xe"; // DB 이름
            String user = "kjs"; // 사용자 명
            String pw = "kjs1234"; //비밀번호
            conn = DriverManager.getConnection(type + ip + port + sid, user, pw);
            // DriverManager : Connection 생성 메소스 제공

            // 3) 수행할 SQL 작성
            String sql = "SELECT * FROM EMPLOYEE_COPY ORDER BY EMP_ID";
            // *** SQL 작성 시 세미콜론은 없어야 된다 !! ***

            // 4) Statement 객체 생성
            stmt = conn.createStatement(); // 커넥션을 왔다 갔다 하는 셔틀버스 같은 역할

            // 5) SQL 수행 후 결과(ResultSet) 반환 받기
            rs = stmt.executeQuery(sql);
            // executeQuery(): SELECT문 수행 후 ResultSet 결과를 반환

            // 6) 결과를 List 에 옮겨 담기
            // - > ResultSet을 한 행씩 접근하여 컬럼값을 얻어와
            //         한 행의 정보가 담긴 Employee 객체를 생성하고
            //        이를 empList에 추가

            while(rs.next()) {
                // rs.next() : 다음 행이 있으면 true, 호출 시 마다 다음행으로 이동

                int empId = rs.getInt("EMP_ID"); // 현재 행의 EMP_ID 컬럼 값을 int  자료형으로 얻어옴.
                String empName = rs.getString("EMP_NAME");
                String empNo = rs.getString("EMP_NO");
                String email = rs.getString("EMAIL");
                String phone = rs.getString("PHONE");
                String deptCode = rs.getString("DEPT_CODE");
                String jobCode = rs.getString("JOB_CODE");
                String salLevel = rs.getString("SAL_LEVEL");
                int salary = rs.getInt("SALARY");
                double bonus = rs.getDouble("BONUS");
                int managerId = rs.getInt("MANAGER_ID");
                Date hireDate = rs.getDate("HIRE_DATE");
                Date entDate = rs.getDate("ENT_DATE");
                char entYn = rs.getString("ENT_YN").charAt(0);
                // rs.getChar()는 존재하지 않음
                // 왜? 자바에서는 문자 하나(cjar) 개념이 있지만, DB에서는 오로지 문자열 개념만 존재 함.
                // -> String.charAt(0) 을 이용함

                // 얻어온 컬럼 값으로 객체 생성 후 초기화
                Employee emp = new Employee(empId, empName, empNo, email, phone, deptCode, jobCode,
                        salLevel, salary, bonus, managerId, hireDate, entDate, entYn);
                empList.add(emp);
            }

        } catch (Exception e) {
            // Exception : 모든 예외의 최상위 부모
            // -> try에서 발생하는 모든 예외를 잡아서 처리
            e.printStackTrace();
        }finally{
            // 7) 사용한 JDBC 자원 반환(close)
            // -> 이 때 생성 역순으로 반환하는게 좋다!
            try{
                if(rs != null) rs.close();
                if(stmt != null) stmt.close();
                if(conn != null) conn.close();
            }catch(SQLException e){
                e.printStackTrace();
            }
        }

        // 8) List 호출부로 반환
        return empList;
    }

    public Employee selectone(int input) {
        Employee emp = null; // 결과 저장용 변수
        try{
            // 1) Oracle JDBC Driver 메모리 로드 ** 꼭 써줘야함 **
            Class.forName("oracle.jdbc.driver.OracleDriver");

            String type = "jdbc:oracle:thin:@"; // JDBC 드라이버가 thin타입
            String ip = "localhost"; // 접속할 아이피
            String port = ":1521";
            String sid = ":xe"; // 접속할 DB 이름
            String user = "kjs"; // 사용자 계정 명
            String pw = "kjs1234"; // 사용자 계정 비밀번호

            // 커넥션 생성
            conn = DriverManager.getConnection(type + ip + port + sid, user, pw);

            stmt = conn.createStatement();

            rs = stmt.executeQuery("SELECT * FROM EMPLOYEE WHERE EMP_ID = "+input);

            // 조회 결과가 있다면 1행 밖에 나오지 않으므로 while 대신 if문 사용
            if(rs.next()){
                int empId = rs.getInt("EMP_ID"); // 현재 행의 EMP_ID 컬럼 값을 int  자료형으로 얻어옴.
                String empName = rs.getString("EMP_NAME");
                String empNo = rs.getString("EMP_NO");
                String email = rs.getString("EMAIL");
                String phone = rs.getString("PHONE");
                String deptCode = rs.getString("DEPT_CODE");
                String jobCode = rs.getString("JOB_CODE");
                String salLevel = rs.getString("SAL_LEVEL");
                int salary = rs.getInt("SALARY");
                double bonus = rs.getDouble("BONUS");
                int managerId = rs.getInt("MANAGER_ID");
                Date hireDate = rs.getDate("HIRE_DATE");
                Date entDate = rs.getDate("ENT_DATE");
                char entYn = rs.getString("ENT_YN").charAt(0);

                emp = new Employee(empId, empName, empNo, email, phone, deptCode, jobCode,
                        salLevel, salary, bonus, managerId, hireDate, entDate, entYn);
            }

        }catch(Exception e){
            e.printStackTrace();
        }finally {
            // 사용한 JDBC 객체 자원 반환
            try{
                if(rs != null) rs.close();
                if(stmt != null) stmt.close();
                if(conn != null) conn.close();
            }catch(SQLException e){
                e.printStackTrace();
            }
        }
        return emp;
    }
}