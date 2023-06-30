package edu.kh.jsp.controller;

public class Person {
	private String name;
	private int age;
	private String address;
	
	public Person(){}
	public Person(String name, int age, String address){
		
	}
	
	public String getName() {return name;}
	public void setName(String name) {this.name = name;}
	
	public int getAge() {return age;}
	public void setAge(int age) {this.age = age;}
	
	public String getAddress() {return address;}
	public void setAddress(String address) {this.address = address;}
	
	@Override
	public String toString() {
		return "이름 : " + name + ", 나이: " + age + ", 주소 : " + address;
	}
}
