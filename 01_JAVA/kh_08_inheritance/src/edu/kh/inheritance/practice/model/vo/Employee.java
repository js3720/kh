package edu.kh.inheritance.practice.model.vo;

public class Employee extends Person{
    private int salary;
    private String dept;

    public Employee() {
    }
    public Employee(String name, int age, double height, double weight, int salary, String dept) {
        super(age, height, weight);
        super.name = name;
        this.salary = salary;
        this.dept = dept;
    }

    @Override
    public String toString(){
        return "이름 : "+this.name+", "+super.toString()+", 급여 : "+salary+", 부서 : "+dept;
    }

    public int getSalary() {return salary;}
    public void setSalary(int salary) {this.salary = salary;}

    public String getDept() {return dept;}
    public void setDept(String dept) {this.dept = dept;}
}