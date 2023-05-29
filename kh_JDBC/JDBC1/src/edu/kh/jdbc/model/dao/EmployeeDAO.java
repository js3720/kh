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

    private PreparedStatement pstmt;
    // Statement의 자식으로 좀 더 향상된 기능을 제공
    // - ?(위치홀더)를 이용하여 SQL에 작성되어지는 리터럴을 동적으로 제어함
    // --> 오타 위험 감소, 가동성 상승

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

    /**
     * 사번으로 사원 정보 조회 DAO
     * @return
     */
    public Employee selectOne(int input) {
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

            rs = stmt.executeQuery("SELECT * FROM EMPLOYEE_COPY WHERE EMP_ID = "+input);

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

    /**
     * 입력 받은 급여 이상으로 받는 모든 직원 조회 DAO
     * @return
     */
    public List<Employee> selectSalary(int input) {

        List <Employee> empList = new ArrayList<>();

        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");

            conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","kjs","kjs1234");

            stmt = conn.createStatement();

            rs = stmt.executeQuery("SELECT * FROM EMPLOYEE_COPY WHERE SALARY >= "+input);

            while(rs.next()) {
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

                Employee emp = new Employee(empId, empName, empNo, email, phone, deptCode, jobCode,
                        salLevel, salary, bonus, managerId, hireDate, entDate, entYn);
                empList.add(emp);
            }

        }catch (SQLException e){
            e.printStackTrace();
        }catch (ClassNotFoundException e){
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
        return empList;
    }

    /**
     * 새로운 사원 정보 추가 DAO
     * @return
     */
    public int insertEmployee(Employee emp) {

        int result = 0;

        try {

            // 오라클 JDBC드라이버 메모리에 로드함
            Class.forName("oracle.jdbc.driver.OracleDriver"); // 드라이버 메모리

            // 커넥션 생성
            conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","kjs","kjs1234");
            // --> 생성된 커넥션을 이용해 SQL을 수행하면 자동 커밋이 된다(기본값)
            // --> 자동 커밋 기능을 끄고 개발자가 트랜잭션을 직접 제어하는게 좋음
            conn.setAutoCommit(false); // 자동 커밋 기능 비활성화
            // --> 자동 커밋을 비활성화 시켜도
            //     conn.close()가 실행되면 남은 트랜잭션 내용이 모두 commit 된다.

            // SQL 작성
            String sql = "INSERT INTO EMPLOYEE_COPY VALUES(?,?,?,?,?,?,?,'S5',?,?,200,SYSDATE,NULL,'N')";
            // ? 기호 <- 위치홀더 라고 한다

            // Statement : 커넥션 생성 - SQL 작성 - Statement 객체 생성 - SQL 수행 후 결과 반환

            // PreparedStatement : 커넥션 생성 - SQL 작성(?사용) - PreparedStatement 객체 생성(SQL 적재)
            //                  - 위치홀더(?)에 알맞는 값 대입 - SQL 수행 후 결과 반환

            // PreparedStatement 객체 생성(SQL 적재)
            pstmt = conn.prepareStatement(sql);

            // 위치홀더에 알맞는 값 대입
            // pstmt.set[Type](위치홀더 순서, 값)

            pstmt.setInt(1, emp.getEmpId()); // 입력 받은 사번을 1번 ?(위치홀더)에 세팅
            pstmt.setString(2, emp.getEmpName());
            pstmt.setString(3, emp.getEmpNo());
            pstmt.setString(4, emp.getEmail());
            pstmt.setString(5, emp.getPhone());
            pstmt.setString(6, emp.getDeptCode());
            pstmt.setString(7, emp.getJobCode());
            pstmt.setInt(8, emp.getSalary());
            pstmt.setDouble(9, emp.getBonus());

            // SQL 수행 후 결과 반환 받기
            // 1) Statement - SELECT         : stmt.executeQuery(sql);
            // 2) PreparedStatement - SELECT   : pstmt.executeQuery(); <- sql 다시 담지 않음!! *주의*

            // ***** DML 수행 시 executeUpdate 사용 *****
            // 3) Statement - DML         : stmt.executeUpdate(sql);
            // 4) PreparedStatement - DML   : pstmt.executeUpdate(); <- sql 다시 담지 않음

            result = pstmt.executeUpdate(); // INSERT, UPDATE, DELETE가 성공한 행의 개수를 반환
            // 조건에 맞는 행이 없으면 0 반환

            //************* 트랜잭션 제어 *************
            if(result >0) conn.commit(); // DML 성공 시 commit 수행
            else conn.rollback(); // DML 실패 시 rollback 수행


        }catch(Exception e) {
            e.printStackTrace();
        }finally {
            try {
                if(rs != null) rs.close();
                if(pstmt != null) pstmt.close();
                if(conn != null) conn.close();

            }catch(SQLException e) {
                e.printStackTrace();

            }
        }

        return result;
    }

    /**
     * 사번으로 사원 정보 삭제 DAO
     * @return
     */
    public int deleteEmployee(int empId) {
        int result = 0;

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver"); // 드라이버 메모리

            conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","kjs","kjs1234");
            conn.setAutoCommit(false); // 자동 커밋 비활성화
            // -> 활성화 상태일 경우 SQL이 수행 되자마자 commit이 되어버림


            String sql = "DELETE FROM EMPLOYEE_COPY WHERE EMP_ID = ?";

            pstmt = conn.prepareStatement(sql);

            pstmt.setInt(1, empId);

            result = pstmt.executeUpdate();

            if(result >0) conn.commit();
            else conn.rollback();

        }catch(Exception e) {
            e.printStackTrace();
        }finally {
            try {
                if(pstmt != null) pstmt.close();
                if(conn != null) conn.close();

            }catch(SQLException e) {
                e.printStackTrace();

            }
        }

        return result;
    }

    /**
     * 사번으로 사원 정보 수정(pstmt) DAO
     * @param emp
     * @return
     */
    public int updateEmployee(Employee emp) {
        int result = 0;
        try{
            // oracle jdbc driver 메모리 로드
            Class.forName("oracle.jdbc.driver.OracleDriver");

            // 커넥션 생성
            conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","kjs","kjs1234");

            // 자동 커밋 비활성화
            conn.setAutoCommit(false);

            // sql 작성 (위치홀더 포함)
            String sql = "UPDATE EMPLOYEE_COPY SET EMAIL = ?, PHONE = ?, SALARY = ? WHERE EMP_ID = ?";

            // PreparedStatement 생성
            pstmt = conn.prepareStatement(sql);

            // 위치 홀더에 알맞은 값 대입
            pstmt.setString(1,emp.getEmail());
            pstmt.setString(2,emp.getPhone());
            pstmt.setInt(3,emp.getSalary());
            pstmt.setInt(4,emp.getEmpId());
            // setString()을 통해서 위치 홀더에 문자열 값을 대입하면
            // 문자열 양쪽에 '' (홑따옴표)가 포함된 상태로 추가된다!
            // ex) pstmt.setString(1, "abc"); --> 위치홀더 자리에 'abc'
            // setInt()는 '' (홑따옴표) 붙지 않음

            // SQL 수행
            // pstmt.executeQuery(); // SELECT 수행 시 사용
            pstmt.executeUpdate(); // DML(INSERT, UPDATE, DELETE) 수행 시 사용

            // 트랜잭션 제어
            if(result >0) conn.commit();
            else conn.rollback();

        }catch(Exception e){
            e.printStackTrace();
        }finally{
            try{
                if(pstmt != null) pstmt.close();
                if(conn != null) conn.close();
            }catch(SQLException e){
                e.printStackTrace();
            }
        }
        return result;
    }

    /**
     * 사번으로 사원 정보 수정2(stmt) DAO
     * @param emp
     * @return
     */
    public int updateEmployee2(Employee emp) {
        int result = 0;
        try{
            // oracle jdbc driver 메모리 로드
            Class.forName("oracle.jdbc.driver.OracleDriver");

            // 커넥션 생성
            conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","kjs","kjs1234");

            // 자동 커밋 비활성화
            conn.setAutoCommit(false);

            // sql 작성
            String sql = "UPDATE EMPLOYEE_COPY SET EMAIL = '"+emp.getEmail()+"', " +
                    "PHONE = '"+emp.getPhone()+"', " +
                    "SALARY = "+emp.getSalary()+" WHERE EMP_ID = "+emp.getEmpId();

            // Statement 객체 생성
            stmt = conn.createStatement();

            // SQL 수행
            result = stmt.executeUpdate(sql);

            // 트랜잭션 제어
            if(result >0) conn.commit();
            else conn.rollback();

        }catch(Exception e){
            e.printStackTrace();
        }finally{
            try{
                if(stmt != null) stmt.close();
                if(conn != null) conn.close();
            }catch(SQLException e){
                e.printStackTrace();
            }
        }

        return result;
    }

    /**
     * 부서코드, 보서스율 입력받아 부서의 보너스를 모두 수정(pstmt) DAO
     * @param emp
     * @return
     */
    public int updateBonus(Employee emp) {
        int result = 0;
        try{
            // oracle jdbc driver 메모리 로드
            Class.forName("oracle.jdbc.driver.OracleDriver");

            // 커넥션 생성
            conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","kjs","kjs1234");

            // 자동 커밋 비활성화
            conn.setAutoCommit(false);

            // sql 작성
            String sql = "UPDATE EMPLOYEE_COPY SET BONUS = ? WHERE DEPT_CODE = ?";

            // Statement 객체 생성
            pstmt = conn.prepareStatement(sql);

            pstmt.setDouble(1,emp.getBonus());
            pstmt.setString(2,emp.getDeptCode());

            // SQL 수행
            result = pstmt.executeUpdate();

            // 트랜잭션 제어
            if(result >0) conn.commit();
            else conn.rollback();

        }catch(Exception e){
            e.printStackTrace();
        }finally{
            try{
                if(pstmt != null) pstmt.close();
                if(conn != null) conn.close();
            }catch(SQLException e){
                e.printStackTrace();
            }
        }
        return result;
    }

    /**
     * 부서코드, 보서스율 입력받아 부서의 보너스를 모두 수정2(smtm) DAO
     * @param emp
     * @return
     */
    public int updateBonus2(Employee emp) {
        int result = 0;
        try{
            // oracle jdbc driver 메모리 로드
            Class.forName("oracle.jdbc.driver.OracleDriver");

            // 커넥션 생성
            conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","kjs","kjs1234");

            // 자동 커밋 비활성화
            conn.setAutoCommit(false);

            // sql 작성
            String sql = "UPDATE EMPLOYEE_COPY SET BONUS = "+emp.getBonus()+" WHERE DEPT_CODE = '"+emp.getDeptCode()+"'";

            // Statement 객체 생성
            stmt = conn.createStatement();

            // SQL 수행
            result = stmt.executeUpdate(sql);

            // 트랜잭션 제어
            if(result >0) conn.commit();
            else conn.rollback();

        }catch(Exception e){
            e.printStackTrace();
        }finally{
            try{
                if(stmt != null) stmt.close();
                if(conn != null) conn.close();
            }catch(SQLException e){
                e.printStackTrace();
            }
        }
        return result;
    }
}