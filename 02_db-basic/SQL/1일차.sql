-- 현재 사용자의 전체 테이블 목록 보기
select * 
  from tab;
  
-- CREATE : 테이블 생성하기
-- 테이블명, 컬럼명 내부적으로 대문자로 관리된다.
-- (별도의 처리가 없을 경우임..)
create table 테이블명 (
	컬럼명  타입(크기), 
	컬럼명  타입(크기) 
);  

create table Member -> 내부적으로 MEMBER
테이블명 규칙 -> t_ 앞에 붙이거나 또는 tb_, tc_, ...
              -> 단어와 단어 사이에 "_"를 추가한다.
              -> 단어를 축약해서 사용할 경우 3자 또는 4자를 사용함
              
              
게시판을 표현하는 테이블 생성 스크립트(SQL) 작성하기
참고 : BoardVO 클래스

CREATE TABLE TB_BOARD (
    NO NUMBER(6),
    TITLE VARCHAR2(200), 
    WRITE VARCHAR2(30),
    CONTENT VARCHAR2(4000),
    REG_DATE DATE
);

-- 테이블 삭제
DROP TABLE TB_BOARD;

-- 제약조건 : 테이블레벨 제약조건, 컬럼레벨 제약조건 
--          : 제약조건 이름 설정(사용자 정의) - constraint 이름
-- 1. PK : Primary key - 하나의 테이블에 하나의 키만 존재함
--                     - UNIQUE + NOT NULL 
-- 2. UNIQUE           - 테이블내에서 값이 고유해야 한다.(null이 허용)
-- 3. NN : NOT NULL    - null 값을 허용하지 않는다.
-- 4. FK : FOREIGN KEY - 다른 테이블 또는 자기 자신의 다른 컬럼의 값을 참조
-- 5. CK : CHECK       - 값의 입력시 제약 설정
-- 주의 : 여러개의 컬럼을 묶어서 제약조건을 설정하려면 테이블레벨을 이용해야 함

-- default : 값이 입력되지 않은 경우 기본으로 값을 설정

create table 테이블명 (
	컬럼명  타입(크기) 제약조건(컬럼), 
	컬럼명  타입(크기), 
	컬럼명  타입(크기) default 값,
	제약조건...(테이블) 
);  

CREATE TABLE TB_BOARD (
    NO NUMBER(6) NOT NULL,
    TITLE VARCHAR2(200) NOT NULL, 
    WRITER VARCHAR2(30) not null,
    CONTENT VARCHAR2(4000) not null,
    REG_DATE DATE default sysdate,
    PRIMARY KEY (NO, TITLE)
);

sysdate : 현재 시간 정보를 반환하는 함수

CREATE TABLE TB_BOARD (
    NO NUMBER(6) constraint pk_no primary key,
    TITLE VARCHAR2(200) NOT NULL, 
    WRITER VARCHAR2(30) not null,
    CONTENT VARCHAR2(4000) not null,
    REG_DATE DATE default sysdate
);


-- 테이블명 변경하기
RENAME A(원래 테이블명) TO B(변경할 테이블명);

RENAME TB_BOARD TO BOARD_TB;

-- 생성된 테이블 구조 살펴보기
DESCRIBE 테이블명;
DESC 테이블명;

DESC TB_BOARD;


-- INSERT : 데이터 입력
-- 입력시 주의점 : 문자를 입력할 때는 반드시 "'"으로 묶는다.
insert into tb_board(no, title, writer, content, reg_date)
values(1, '제목', '글쓴이', '내용', sysdate);

insert into tb_board(no, title, writer, content)
values(2, '제목2', '글쓴이2', '내용2');

-- no 컬럼은 primary key로 설정되었기 때문에 중복된 데이터는 허용하지 않는다.
insert into tb_board(no, title, writer, content)
values(2, '제목2', '글쓴이2', '내용2');

-- ORA-01400: NULL을 ("HR"."TB_BOARD"."CONTENT") 안에 삽입할 수 없습니다
insert into tb_board(no, title, writer)
values(3, '제목3', '글쓴이3');

-- 컬럼명이 별도로 설정되지 않은 경우 모든 컬럼에 데이터 입력(권장 X)
insert into tb_board
values(3, '제목3', '글쓴이3', '내용3', sysdate);

-- 복구 불가능 데이터 삭제 
truncate table tb_board;

-- 데이터 수정 : update
update 테이블명
   set 컬럼 = 변경할 값
       [, 컬럼 = 변경할 값 ..]
[조건절(where)]

-- 1번 게시물의 내용을 "추운날"로 변경합니다.
update tb_board
   set content = '추운날' 
 where no = 1;  
 
-- 2번 게시물의 제목을 "본차로드"로 내용을 "느끼"로 변경합니다. 
update tb_board
   set content = '느끼',
       title = '본차로드' 
 where no = 2;  

-- 데이터 삭제 : delete
delete 
  from 테이블명
[조건절(where)]

-- 2번 게시물을 삭제하는 쿼리 작성
delete 
  from tb_board
 where no = 2;  


===================================================
SELECT 절
===================================================
select *          -- 컬럼명 
  from tb_board;  -- 테이블명

-- 특정 컬럼만 조회하기
select no, title, writer
  from tb_board;
  
--  
select employee_id, first_name
  from employees;
  
-- 산술 연산자 사용
-- 사원의 연봉을 출력하시오(연봉 : 급여 * 15)
select last_name, salary, salary * 15
  from employees;
  

-- 컬럼의 별칭(alias) 사용 : 컬럼 별칭, 컬럼 as 별칭
select last_name 이름, salary as 급여, salary * 15 연봉
  from employees;  
  
  
-- 합성연산자(||) : 자바에서의 "+" 역활
String name = "홍";
int age = 29;

String msg = name + "님의 나이는 " + age + "입니다"; 

-- ???사원의 급여는 ???입니다.
사원정보 : employees
출력컬럼 : last_name, salary

select last_name || '사원의 급여는 ' || salary || '입니다.'
  from employees;
  
===================================================
WHERE 절
===================================================
SELECT : 사원의 정보
FROM   : EMPLYEES
WHERE  : SALARY >= 10000
-- 사원 중에서 급여가 10000 이상인 사원의 정보를 출력하시오   
SELECT *
  FROM EMPLYEES
 WHERE SALARY >= 10000;

 
-- 사원 정보를 출력합니다. 단, 100번 부서가 아닌 사원들만 출력합니다.
SELECT *
  FROM EMPLYEES
 WHERE DEPARTMENT_ID != 100; 
 
 
-- 주의 값은 대소문자가 비교된다.
-- last_name 이 'King'인 사원의 정보를 출력
select last_name
  from employees
 where last_name = 'King'; 
 

-- 사원의 부서가 100 번 부서이면서 급여가 10000 이상인 사원의 정보를 출력
select last_name
  from employees
 where DEPARTMENT_ID = 100
   and salary >= 10000; 
 
  
-- 사원의 부서가 100 번 또는 90번인 사원의 정보를 출력
select *
  from employees
 where DEPARTMENT_ID = 100 
    or DEPARTMENT_ID = 90;    

-- 사원의 부서가 100 번 또는 90번에 포함되어 있으면서 급여가 10000 이상인
   사원의 정보를 출력
select *
  from employees
 where (DEPARTMENT_ID = 100 or DEPARTMENT_ID = 90)
   and salary >= 10000;   

-- 급여가 10000이상인 사원의 수
select count(*)
  from employees
 where salary >= 10000;


































