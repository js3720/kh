package edu.kh.jdbc.model.service;

import edu.kh.jdbc.model.dao.EmployeeDAO;
import edu.kh.jdbc.model.vo.Employee;
import java.util.List;

public class EmployeeService {

    private EmployeeDAO dao = new EmployeeDAO();


    /**
     w 전체 사원 정보 조회 서비스
     * @return
     */
    public List<Employee> selectAll(){
        List<Employee> empList = dao.selectAll();
        return empList;
    }

    public Employee selectOne(int input) {
        Employee emp = dao.selectone(input);
        return emp;
    }
}
