package edu.kh.jdbc.ex1;
import java.sql.*;

public class JDBCExample2 {
    public static void main(String[] args) {
        int salarySum = 0;

        try(
                Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","kjs","kjs1234");
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT EMP_ID, EMP_NAME, SALARY, DEPT_CODE FROM EMPLOYEE ORDER BY EMP_NAME");
                ){
            Class.forName("oracle.jdbc.driver.OracleDriver");

            while(rs.next()) {
                int empId = rs.getInt("EMP_ID");
                String empName = rs.getString("EMP_NAME");
                int salary = rs.getInt("SALARY");
                String deptCode = rs.getString("DEPT_CODE");
                System.out.printf("사번 : %d, 이름 : %s, 급여 : %7d, 부서코드 : %s\n", empId,empName,salary,deptCode);
                salarySum += salary;
            }
            System.out.println("급여 합계 : "+salarySum);

        }catch(SQLException e){
            e.printStackTrace();
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }

    }
}
