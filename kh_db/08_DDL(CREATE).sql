 /*
 -데이터 딕셔너리란?
 자원을 효율적으로 관리하기 위한 다양한 정보를 저장하는 시스템 테이블
 데이터 딕셔너리는 사용자가 테이블을 생성하거나 사용자를 변경하는 등의
 작업을 할 때 데이터 베이스 서버에 의해 자동으로 갱신되는 테이블
 
 
 -User_tables : 자신의 계정이 소유한 객체 등에 관한 정보를 조회 할 수 있는 딕셔너리 뷰

 */
 
 --------------------------------------------------------------------------------------------------------------------

-- DDL(DATA DEFINITION LANGUAGE) : 데이터 정의 언어

-- 객체(OBJECT)를 만들고(CREATE), 수정(ALTER)하고, 삭제(DROP) 등
-- 데이터의 전체 구조를 정의하는 언어로 주로 DB관리자, 설계자가 사용함

-- 오라클에서의 객체 : 테이블(TABLE), 뷰(VIEW), 시퀀스(SEQUENCE),
--                   인덱스(INDEX), 패키지(PACKAGE), 트리거(TRIGGER)
--                   프로시져(PROCEDURE), 함수(FUNCTION),
--                   동의어(SYNONYM), 사용자(USER)

--------------------------------------------------------------------------------------------------------------------

-- CREATE

-- 테이블이나 인덱스, 뷰 등 다양한 데이터베이스 객체를 생성하는 구문
-- 테이블로 생성된 객체는 DROP 구문을 통해 제거 할 수 있음

-- 1. 테이블 생성하기
-- 테이블이란?
-- 행(row)과 열(column)으로 구성되는 가장 기본적인 데이터 베이스 객체
-- 데이터 배이스 내에서 모든 데이터는 테이블을 통해서 저장된다.

-- [표현식] 
/*
    CREATE TABLE 테이블명 (
        컬럼명 자료형(크기), 
        컬럼명 자료형(크기),
        ...);
*/

/* 자료형
    NUMBER : 숫자형(정수, 실수)
    CHAR(크기) : 고정길이 문자형 (2000BYTE) 
        -> ex) CHAR(10) 컬럼에 'ABC' 3BYTE 문자열만 저장해도 10BYTE 저장공간을 모두 사용. 
        
    VARCHAR2(크기) : 가변길이 문자형 (4000 BYTE)
        -> ex) VARCHAR2(10) 컬럼에 'ABC' 3BYTE 문자열만 저장하면 나머지 7BYTE를 반환함.
        
    DATE : 날짜 타입
    BLOB : 대용량 이진 데이터 (4GB)
    CLOB : 대용량 문자 데이터 (4GB) *
*/

-- MEMBER 테이블 생성
CREATE TABLE MEMBER(
    MEMBER_ID VARCHAR2(20), -- 가변 길이 문자열 20바이트(영어, 숫자만 작성 시 20글자)
    MEMBER_PWD VARCHAR2(20),
    MEMBER_NAME VARCHAR2(30), -- 한글 3BYTE * 10글자 = 30BYTE
    MEMBER_SSN CHAR(14), -- 주민등록번호 14글자
    ENROLL_DATE DATE DEFAULT SYSDATE
);
-- Table MEMBER이(가) 생성되었습니다.
-- DEFAULT : 입력되는 값이 없거나 'DEFAULT' 키워드 사용 시에 기록되어질 값을 지정

-- 만든 테이블 확인
SELECT * FROM MEMBER;
SELECT * FROM USER_TABLES; -- 딕셔너리 뷰(데이터 딕셔너리에서 일부분만 뽑아서 만든 가상 테이블)

-- 2) 컬럼에 주석 달기
-- [표현식]
-- COMMENT ON COLUMN 테이블명.컬럼명 IS '주석내용';
COMMENT ON COLUMN MEMBER.MEMBER_ID IS '회원 아이디'; -- Comment이(가) 생성되었습니다.
COMMENT ON COLUMN MEMBER.MEMBER_PWD IS '회원 비밀번호';
COMMENT ON COLUMN MEMBER.MEMBER_NAME IS '회원 이름';
COMMENT ON COLUMN MEMBER.MEMBER_SSN IS '주민 등록 번호';
COMMENT ON COLUMN MEMBER.ENROLL_DATE IS '회원 가입일';

-- USER_TABLES : 사용자가 작성한 테이블을 확인 하는 뷰
-- 데이터 딕셔너리에 정의되어 있음
SELECT * FROM USER_TABLES;

-- MEMBER 테이블에 샘플 데이터 삽입
INSERT INTO MEMBER VALUES('MEM01','123ABC','홍길동','990808-1234567', DEFAULT);
COMMIT;

-- 데이터 삽입 확인
SELECT * FROM MEMBER;

-- 추가 샘플 데이터 삽입
-- 가입일 -> SYSDATE를 활용
INSERT INTO MEMBER VALUES('MEM02', 'QWER1234', '김영희', '980909-2345678', SYSDATE);
COMMIT;
SELECT * FROM MEMBER;

-- 가입일 -> DEFAULT 활용(테이블 생성 시 정의된 값이 반영됨)
INSERT INTO MEMBER VALUES('MEM03', 'ASDFQWER', '박철수', '950405-1111222', DEFAULT);
COMMIT;
SELECT * FROM MEMBER;

-- 가입일 -> INSERT 시 미작성 하는 경우 -> DEAFULT 값이 반영됨
INSERT INTO MEMBER(MEMBER_ID, MEMBER_PWD, MEMBER_NAME, MEMBER_SSN)
VALUES('MEM04', '12341234', '이지연', '000101-4564567');
COMMIT;
--  데이터  삽입 확인
SELECT * FROM MEMBER;

-- 주민등록번호의 데이터 타입을 NUMBER로 지정할 경우 문제점
CREATE TABLE MEMBER2(
    MEMBER_NAME VARCHAR2(20),
    MEMBER_SSN NUMBER
);

INSERT INTO MEMBER2 VALUES('홍길동',9908081234567);
SELECT * FROM MEMBER2;

INSERT INTO MEMBER2 VALUES('김영희',0011134567890);
SELECT * FROM MEMBER2;
--> NUMBER 타입 컬럼에 데이터 삽입 시 앞에 0이 있으면 사라지는 문제점이 있음!!

DROP TABLE MEMBER2; -- Table MEMBER2이(가) 삭제되었습니다.

--------------------------------------------------------------------------------

-- 제약 조건(CONSTRAINTS)

/* 
    사용자가 원하는 조건의 데이터만 유지하기 위해서 특정 컬럼에 설정하는 제약.
    데이터 무결성 보장을 목적으로 함.
    -> 데이터 무결성이란? 중복데이터 최소화, NULL 최소화 지향
    
    + 입력 데이터에 문제가 없는지 자동으로 검사하는 목적
    + 데이터의 수정/삭제 가능여부 검사등을 목적으로 함 
        --> 제약조건을 위배하는 DML 구문은 수행할 수 없음!
    
    제약조건 종류
    PRIMARY KEY, NOT NULL, UNIQUE, CHECK, FOREIGN KEY.
    
*/

-- 제약 조건 확인
-- USER_CONSTRAINTS : 사용자가 작성한 제약조건을 확인하는 딕셔너리 뷰
DESC USER_CONSTRAINTS;
SELECT * FROM USER_CONSTRAINTS;

-- USER_CONS_COLUMNS : 제약조건이 걸려 있는 컬럼을 확인하는 딕셔너리 뷰
DESC USER_CONS_COLUMNS;
SELECT * FROM USER_CONS_COLUMNS;

-- 1. NOT NULL
-- 해당 컬럼에 반드시 값이 기록되어야 하는 경우 사용
-- 삽입/수정시 NULL값을 허용하지 않도록 철럼레벨에서 제한

CREATE TABLE USER_USED_NN(
    USER_NO NUMBER NOT NULL, -- 사용자 번호(무조건 있어야 함) -> 컬럼레벨 제약조건 설정
    USER_ID VARCHAR2(20),
    USER_PWD VARCHAR2(30),
    USER_NAME VARCHAR2(30),
    GENDER VARCHAR2(10),
    PHONE VARCHAR2(30),
    EMAIL VARCHAR2(50)
);

INSERT INTO USER_USED_NN
VALUES(1, 'user01', 'pass01', '홍길동', '남', '010-1234-5678', 'hong123@kh.or.kr');

INSERT INTO USER_USED_NN
VALUES(NULL, NULL, NULL, NULL, NULL, '010-1234-5678', 'hong123@kh.or.kr');
-- ORA-01400: NULL을 ("KJS"."USER_USED_NN"."USER_NO") 안에 삽입할 수 없습니다
-- ORA-01400 오류코드

--------------------------------------------------------------------------------

-- 2. UNIQUE 제약조건
-- 컬럼에 입력 값에 대해서 중복을 제한하는 제약조건
-- 컬럼레벨에서 설정 가능, 테이블 레벨에서 설정 가능
-- 단, UNIQUE 제약 조건이 설정된 컬럼에 NULL 값은 중복 삽입 가능

CREATE TABLE USER_USED_UK(
    USER_NO NUMBER,
    --USER_ID VARCHAR2(20) UNIQUE, -- 컬럼레벨 제약조건 설정 (제약조건명 미지정)
    --USER_ID VARCHAR2(20) CONSTRAINT USER_ID_U UNIQUE, -- (제약조건명 지정)
    
    USER_ID VARCHAR2(20),
    USER_PWD VARCHAR2(30),
    USER_NAME VARCHAR2(30),
    GENDER VARCHAR2(10),
    PHONE VARCHAR2(30),
    EMAIL VARCHAR2(50),
    
    -- 테이블 레벨 제약조건 설정 부분
    -- UNIQUE(USER_ID) -- 테이블 레벨 제약조건 설정(제약조건명 미지정)
    CONSTRAINT USER_ID_U UNIQUE(USER_ID) -- 테이블 레벨 제약조건 설정(제약조건명 지정)
);
DROP TABLE USER_USED_UK; -- 테이블 삭제

INSERT INTO USER_USED_UK
VALUES(1, 'user01', 'pass01', '홍길동', '남', '010-1234-5678', 'hong123@kh.or.kr');

INSERT INTO USER_USED_UK
VALUES(1, 'user01', 'pass01', '홍길동', '남', '010-1234-5678', 'hong123@kh.or.kr');
-- 같은 아이디인 데이터가 이미 테이블에 있으므로 UNIQUE 제약 조건에 위배되어 오류 발생
-- ORA-00001: 무결성 제약 조건(KJS.USER_ID_U)에 위배됩니다

INSERT INTO USER_USED_UK
VALUES(1, NULL, 'pass01', '홍길동', '남', '010-1234-5678', 'hong123@kh.or.kr');
-->아이디에 NULL값 삽입 가능

INSERT INTO USER_USED_UK
VALUES(1, NULL, 'pass01', '홍길동', '남', '010-1234-5678', 'hong123@kh.or.kr');
--> 아이디에 NULL값 중복 삽입 가능

-- 오류 보고에 나타나는 SYS_C008635 같은 제약 조건명으로
-- 해당 제약 조건이 설정된 테이블명, 컬럼, 제약 조건 타입 조회 
SELECT UCC.TABLE_NAME, UCC.COLUMN_NAME, UC.CONSTRAINT_TYPE
FROM USER_CONSTRAINTS UC, USER_CONS_COLUMNS UCC
WHERE UCC.CONSTRAINT_NAME = UC.CONSTRAINT_NAME
AND UCC.CONSTRAINT_NAME = 'USER_ID_U';
