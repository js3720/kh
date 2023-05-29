package edu.kh.jdbc.model.service;

import edu.kh.jdbc.model.dao.EmployeeDAO;
import edu.kh.jdbc.model.vo.Employee;
import java.util.List;

public class EmployeeService {

    private EmployeeDAO dao = new EmployeeDAO();


    /**
     w 전체 사원 정보 조회 Service
     * @return
     */
    public List<Employee> selectAll(){
        List<Employee> empList = dao.selectAll();
        return empList;
    }

    /**
     * 사번으로 사원 정보 조회 Service
     * @param input
     * @return
     */
    public Employee selectOne(int input) {
        Employee emp = dao.selectOne(input);
        return emp;
    }

    /**
     * 입력 받은 급여 이상으로 받는 모든 직원 조회 Service
     * @param input
     * @return
     */
    public List<Employee> selectSalary(int input) {
        List <Employee> empList = dao.selectSalary(input);
        return empList;
    }

    /**
     * 새로운 사원 정보 추가 Service
     * @param emp
     * @return
     */
    public int insertEmployee(Employee emp) {
        int result = dao.insertEmployee(emp);
        return result;
    }

    /**
     * 사번으로 사원 정보 삭제 Service
     * @param empId
     * @return
     */
    public int deleteEmployee(int empId) {
        int result = dao.deleteEmployee(empId);
        return result;
    }

    /**
     * 사번으로 사원 정보 수정 Service
     * @param emp
     * @return
     */
    public int updateEmployee(Employee emp) {
//        int result = dao.updateEmployee(emp); // pstmt
        int result = dao.updateEmployee2(emp); // stmt
        return result;
    }

    /**
     * 서코드, 보서스율 입력받아 부서의 보너스를 모두 수정하는 Service
     * @param emp
     * @return
     */
    public int updateBonus(Employee emp) {
        int result = dao.updateBonus(emp); // pstmt
//        int result = dao.updateBonus2(emp); // stmt
        return result;
    }
}
