package edu.kh.poly.ex2.run;

import edu.kh.poly.ex2.model.service.AbstractService;
import edu.kh.poly.ex2.model.vo.Animal;

public class AbstractRun {
    public static void main(String[] args) {
        AbstractService service = new AbstractService();
//        service.ex1();
        service.ex2();
    }
}
