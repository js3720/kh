/* SELECT {DML 또는 DQL} : 조회

- 데이터를 조회(SELECT)하면 조건에 맞는 형들이 조회됨
이때, 조회된 형들의 집합을 "RESULT SET"이라고 한다.

- RESULT SET에는 0개 이상의 행이 포함될 수 있다.
 왜 0개 이상? -> 조건이 맞는 행이 없을 수도 있기 때문에

*/

-- EMPLOYEE 테이블에서 모든 사원의 정보를 조회
-- '*' : ALL, 모든, 전부
SELECT * FROM EMPLOYEE;

-- [SELECT 컬럼명 FROM 테이블명]
-- EMPLOYEE 테이블에서 모든 사원의 이름만 조회
SELECT EMP_NAME FROM EMPLOYEE;

-- [SELECT 컬럼명, 컬럼명, ... FROM 테이블명]
-- EMPLOYEE 테이블에서 모든 사원의 사번, 이름, 전화번호 조회
SELECT EMP_ID, EMP_NAME, PHONE FROM EMPLOYEE;

-- EMPLOYEE 테이블에서 모든 사원의 사번, 이메일, 입사일 조회
SELECT EMP_ID, EMAIL, HIRE_DATE FROM EMPLOYEE;

-- DEPARTMENT 테이블에 있는 모든 행 조회
SELECT * FROM DEPARTMENT;

------------------------------------------------------
-- <컬럼 값 산술 연산>
-- 컬럼 값 : 테이블의 한 칸(== 한 셀)에 작성된 값(DATA)

-- SELECT문 작성 시 컬럼명에 산술 연산을 작성하면
-- 조회되는 결과 컬럼 값에 산술 연산이 반영된다.

-- EMPLOYEE 테이블에서 모든 사원의 사번, 이름, 급여 + 100만 을 조회0
SELECT EMP_ID, EMP_NAME, SALARY+1000000 FROM EMPLOYEE;

-- EMPLOYEE 테이블에서 모든 사원의 이름, 급여, 연봉(급여*12개월)을 조회
SELECT EMP_NAME, SALARY, SALARY*12 FROM EMPLOYEE;

-------------------------------------------------------

-- (중요) <오늘 날짜 조회> 많이 사용 될 예정이니 꼭 암기하기
SELECT SYSDATE FROM DUAL;
-- SYSDATE : 시스템상의 현재 날짜
--           (년,월,일,시,분,초 단위까지 표현 가능하지만, 디벨로퍼의 
--            날짜 표기 방법이 년/월/일로 지정되어 있는 것 이다.)
--          도구 - 환경설정 - 데이터베이스 -NLS에서 표기방법 설정가능

-- DUAL(DUmmy tAbLe) : 가짜 테이블(임시 테이블, 단순 조회 테이블)

-- ** DB는 날짜 데이터의 연산(+,-)이 가능하다 (일 단위) **
SELECT SYSDATE, SYSDATE+1, SYSDATE-1 FROM DUAL

-- EMPLOYEE 테이블에서 이름, 입사일, 오늘까지 근무한 날짜 조회
SELECT EMP_NAME, HIRE_DATE, (SYSDATE-HIRE_DATE)/365 FROM EMPLOYEE;

--------------------------------------------------------

-- <컬럼 별칭 지정>

-- SELECT 조회 결과의 집합인 RESULT SET에 컬럼명을 지정
/*
 1) 컬럼명 AS 별칭 : 띄어쓰기x, 특수문자x, 문자o
 2) 컬럼명 별칭 : 1번에서 AS만 생략 한 것
 
 3) 컬럼명 AS "별칭" : 띄어쓰기o, 특수문자o, 문자o
 4) 컬럼명 "별칭" : 3번에서 AS만 생략 한 것
*/

-- EMPLOYEE 테이블에서
-- 사번, 이름, 급여(원), 근무 일수를 모두 조회
SELECT EMP_ID AS 사번, EMP_NAME 이름, SALARY AS "급여(원)", (SYSDATE-HIRE_DATE) "근무 일수"
FROM EMPLOYEE;

-------------------------------------------------------

-- 리터럴 : 값 자체

-- DB에서의 리터럴 : 임의로 지정한 값을 기존 테이블에 존재하는 값처럼 사용
--> 리터럴 표기법 ''(홑따옴표)

SELECT EMP_NAME, SALARY,'원' AS 단위 FROM EMPLOYEE;

-------------------------------------------------------

-- DISTINCT : 조회 시 컬럼에 포함된 중복 값을 한 번만 표시할 때 사용
-- (주의사항)
-- 1) DISTINCT는 SELECT문에 딱 한번만 작성할 수 있다.
-- 2) DISTINCT는 SELECT문 가장 앞에 작성 되어야 한다.

-- EMPLOYEE 테이블에 저장된 직원들이 속해있는 부서 코드 종류 조회
SELECT DISTINCT DEPT_CODE FROM EMPLOYEE;