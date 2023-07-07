package edu.kh.inheritance.moedl.vo;

public class Employee extends Person{
    //필드
    private String company;

    //생성자
    public Employee() {}
    public Employee(String name, int age, String nationality, String company) {
        super(name,age,nationality);
        this.company = company;
    }

    //메소드
    public String getCompany() {return company;}
    public void setCompany(String company) {this.company = company;}

    // Person으로부터 상속 받은 메소드 중
    // move() 메소드를 Employee에 맞게 재정의(오버라이딩)

    // @Override 어노테이션 : 해당 메소드가 오버라이딩 되었음을 컴파일러에게 알려주는 역할
    // 어노테이션(Annotation) : 컴파일러에게 알려주기 위한 코드 (컴파일러 인식용 주석)
    @Override // 오버라이딩 시 무조건 작성 해주는 것이 좋다.
    public void move(){
        // 기존 부모 코드 삭제 후 자식의 새롭게 재정의
        System.out.println("오버라이딩 된 move() 메소드");
        System.out.println("효율적으로 빨리 일처리하고 야근을 하지 않는다.");
    }
    // 상속받은 자식들에 대한 공통적인 규약 정의할 수 있다.
    // -> 상속 받은 자식들은 모두 부모와 같은 필드, 메소드를 가지고 있으므로
    //    클래스들이 일부 공통된 형태를 띈다.

    @Override
    public String toString(){
        return super.toString()+" / "+company;
    }

    // *** 오버라이딩 성립 조건 ***
    // 1. 메소드 이름 동일
    // 2. 반환형 동일
    // 3. 매개변수 동일
    // 4. 접근제한자가 같거나 더 넓은 범위
    //    ex) (부) protected -> (자) protected 또는 public
    // 5. 예외처리 범위는 같거나 더 좁게
    // + 부모의 private 메소드는 오버라이딩 불가
    // -> 자식도 엄연히 다른 클래스여서 접근할 수 없기 때문에.
}
