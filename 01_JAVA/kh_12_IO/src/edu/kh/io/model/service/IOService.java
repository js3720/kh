package edu.kh.io.model.service;

import edu.kh.io.dto.Student;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IOService {

    // IO

    // Input (입력) : 외부 -> 내부로 데이터를 들여오는것
    // Output (출력) : 내부 -> 외부로 데이터를 내보내는것

    // Stream : 입/출력 통로 역할(데이터가 흘러가는 통로)
    //          기본적으로 Stream은 단방향

    // 1) 파일 출력 (내부 == 프로그램, 외부 == 파일)
    public void output1(){
        FileOutputStream fos = null;
        try{
            fos = new FileOutputStream("test1.txt");
            // 현재 프로그램에서 test1.txt 파일로 출력하는 통로 객체 생성

            // 파일에 "Hello" 내보내기
            String str = "Hello";
            for(int i=0; i<str.length(); i++){
                System.out.println(str.charAt(i));
                fos.write(str.charAt(i)); // write()는 IOException을 발생시킬 가능성이 있다.
            }
        }
        catch (IOException e){
            System.out.println("예외 발생");
            e.printStackTrace(); // 예외 추적
        }
        finally { // 예외가 발생 하든 말든 무조건 수행
            System.out.println();
            try {
                fos.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            // 사용한 스트림 자원 반환(통로 없앰) --> 필수 작성!
            // 프로그램 메모리 관리 차원에서 항상 다 쓰면 끊어줘야 한다 --> 작성 안하면 문제점
        }
        // FileOutputStream 객체 생성 시
        // FileNotFoundException 예외가 발생할 가능성이 있음 -> 예외 처리 필요
    }
    // 2) 파일 출력 (문자 기반 스트림)
    public void output2(){
        FileWriter fw = null; // 프로그램 -> 파일로 쓰는 문자 기반 스트림
        try{
            fw = new FileWriter("test2.txt",true); // 외부 파일과 연결하는 스트림 객체 생성
            // fw = new FileWriter("경로", 이어쓰기 옵션); -> byte기반 스트림도 사용 가능한 옵션
            String str = "안녕하세요. Hello. 1234 !#\n";
            // fw.write(int c) : 한 문자 씩
            // fw.write(String s) : 한 줄 씩 출력

            fw.write(str);

            // 실행 했는데 출력이 안된다.. why??
            // -> 한 줄을 통째로 보내기 위해 "버퍼"를 이용하는데
            // 버퍼에 담겨만 있음. -> 이걸 강제로 밀어넣어서 버퍼를 비워야 한다.
            // close()구문 수행 시 통로에 남아있는 내욜을 모두 내보내고 통로를 없앤다
        }catch (IOException e){
            System.out.println("test");
            e.printStackTrace();
        }finally {
            try {
                fw.close();
            } catch (IOException e) {
                e.printStackTrace(); // 예외 추적
            }
        }
    }

    public void input1(){
        FileInputStream fis = null; // 파일 -> 프로그램으로 읽어오는 바이트 기반 스트림
        try{
            fis = new FileInputStream("test1.txt");
            // FileInputStream은 1byte만 읽어올 수 있다.
            while(true){
                int data = fis.read(); // 다음 1byte를 읽어오는데 정수형임
                                        // 다음 내용이 없으면 -1 반환함
                if(data == -1){ //다음 내욜 없음 -> 종료
                    break;
                }
                // 반복 종료 안됐으면 char로 강제 형변환하여 문자로 출력
                System.out.print((char)data);
            }
        }catch (IOException e){

        }finally {
            try {
                System.out.println();
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public  void input2(){
        FileReader fr = null;
        try{
            fr = new FileReader("test2.txt");
            while(true){
                int data = fr.read(); // 다음 한 문자를 읽어옴. 읽어올게 없으면 -1
                if(data == -1){ // 다음 읽어올게 없으면 반복문 탈출
                    break;
                }
                System.out.print((char)data);
            }
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            try {
                System.out.println();
                fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    // 5) 객체 출력 보조 스트림
    public void objectOutput(){
        // ObjectXXXStream : 객체를 파일 또는 네트워크를 통해 입/출력할 수 있는 스트림

        // ObjectOutputStream -> 객체를 바이트 기반 스트림으로 출력할 수 있게 하는 스트림
        // 조건 : 출력하려는 객체에 직렬화 가능 여부를 나타내는 Serializable 인터페이스를 상속 받아야 한다.
        // ObjectInputStream :

        ObjectOutputStream oos = null;
        try{
            oos = new ObjectOutputStream(new FileOutputStream("object/Student.txt"));
            Student s = new Student("홍길동",3,5,7,'남');
            oos.writeObject(s);
            System.out.println("학생 출력 완료");
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                if( oos != null ) oos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    // 6) 객체 입력 보조 스트림
    public void objectInput(){
        ObjectInputStream ois = null;
        try{
            ois = new ObjectInputStream(new FileInputStream("object/Student.txt"));
            Student s = (Student)ois.readObject(); // 직렬화된 객체 데이터를 읽어와 역직렬화 시켜 정상적인 객체 형태로 반환
            System.out.println(s);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try{
                if(ois != null) ois.close();
            }
            catch (IOException e){
                e.printStackTrace();
            }
        }
    }

    // 7) List Student 객체를 담아서 파일로 출력
    public void listOutput(){
        ObjectOutputStream oos = null;

        try{
            oos = new ObjectOutputStream(new FileOutputStream("object/studentList.ini"));
            List<Student> list = new ArrayList<>();

            list.add(new Student("A",1,1,1,'여'));
            list.add(new Student("B",2,2,2,'여'));
            list.add(new Student("C",3,3,3,'남'));
            list.add(new Student("D",4,4,3,'남'));

            oos.writeObject(list);
            // writeObject(객체) : 출력하려는 객체는 직렬화가 가능해야만 한다!
            // Serializable 인터페이스 구현 필수
            // 컬렉션은 모두 직렬화가 가능하도록 Serializable 인터페이스 구현이 완료된 상태이다.
            // -> 단, 컬렉션에 저장하는 객체가 직렬화 가능하지 않다면 출력이 되지 않는다 (NotSerializableException 발생)

            System.out.println("학생 출력 완료");
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try{
                if(oos != null) oos.close();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }

    // 8)
    public void listInput(){
        ObjectInputStream ois = null;
        try{
            ois = new ObjectInputStream(new FileInputStream("object/studentList.ini"));
            List<Student> list = (List<Student>)ois.readObject(); // 직렬화된 객체 데이터를 읽어와 역직렬화 시켜 정상적인 객체 형태로 반환
            for(Student s : list) System.out.println(s.getName());
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try{
                if(ois != null) ois.close();
            }
            catch (IOException e){
                e.printStackTrace();
            }
        }
    }

    // 8) ★ys_source★
    public void listInput1(){
        try(
                //try-with-resource 문을 사용하면 자동으로 자원 반납해줌, 메서드 종료시
                ObjectInputStream ois = new ObjectInputStream(new FileInputStream("object/studentList.ini"));
            ){
            List<Student> list = (List<Student>)ois.readObject(); // 직렬화된 객체 데이터를 읽어와 역직렬화 시켜 정상적인 객체 형태로 반환
            for(Student s : list) System.out.println(s.getName());
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
