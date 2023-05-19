--C## : 일반 사용자(사용자 계정을 의미)

-- 계정 생성
CREATE USER C##workbook IDENTIFIED BY workbook1234;
CREATE USER workbook IDENTIFIED BY workbook1234;

-- 접속, 기본 객체 생성 권한
GRANT CONNECT, RESOURCE TO C##workbook;
GRANT CONNECT, RESOURCE TO workbook;

-- 객체가 생성될 수 있는 공간 할달량 지정
-- alter user [유저명] default tablespace [테이블스페이스] quota unlimited on [테이블스페이스];
ALTER USER C##workbook DEFAULT TABLESPACE SYSTEM QUOTA UNLIMITED ON SYSTEM;
ALTER USER kh DEFAULT TABLESPACE SYSTEM QUOTA UNLIMITED ON SYSTEM;