package edu.kh.oarr.run;

import edu.kh.oarr.model.service.PracticeService;

public class PracticeRun {
    public static void main(String[] args) {
        PracticeService service = new PracticeService();
        service.start();
    }
}
