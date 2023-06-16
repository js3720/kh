-- 한 줄 주석
/*범위 주석*/

-- SQL 실행 방법 : SQL문에 커서를 두거나, 블럭처리 후 CTR + ENTER
select username from dba_users;

-- 18c 버전은 일반 사용자를 구분할 때 ID앞에 c##을 붙여야만 하는데
-- 11g와 호환되는 SQL문을 작성하게 하는 SQL을 수행해야 한다.
ALTER SESSION SET "_ORACLE_SCRIPT" = TRUE;
CREATE USER kjs IDENTIFIED BY kjs1234;

-- 생성한 사용자 계정 권한 부여
GRANT CONNECT, RESOURCE TO kjs;
-- CONNECT : DB연결 권한 ROLE
-- RESOURCE : BD 기본 객체 생성 권한 ROLE

-- 객체(테이블 등)가 생성될 수 있는 공간 할당량 지정
ALTER USER kjs DEFAULT TABLESPACE SYSTEM QUOTA UNLIMITED ON SYSTEM;
