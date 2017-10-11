------------------------------------------
시퀀스(sequence) : 고유번호 생성기
공용객체
어느 테이블에서나 시퀀스 사용이 가능함
일반적으로는 특정 테이블의 특정 컬럼에서 사용
------------------------------------------
-- 시퀀스 생성하기
-- 생성 옵션을 설정하지 않은 경우 
-- 시작 : 1, 증가 : 1
create sequence s_board_no;

-- 생성된 시퀀스에서 고유번호 얻기 : nextVal
-- 시퀀스명.nextVal
select s_board_no.nextVal from dual;

-- 시퀀스 삭제하기
drop sequence s_board_no;

-- 시퀀스를 이용한 게시글 등록
insert into tb_board(no, title, writer, content)
values (s_board_no.nextVal, '제목', '글쓴이', '내용');

select * 
  from tb_board;

------------------------------------------
alter : 테이블 변경
-- 컬럼 추가, 컬럼 삭제, 컬럼 변경(타입, 크기, defalut, not null)
-- add : 컬럼 추가시 사용
-- drop : 컬럼 삭제시 사용
-- modify : 컬럼 변경시 사용

alter table 테이블명
add (컬럼...)

alter table 테이블명
drop (컬럼)

alter table 테이블명
modify (컬럼...)

9i부터 컬럼의 이름 변경
alter table 테이블명
rename column A to B;
------------------------------------------
create table t_alter (
    nama varchar2(10),
    age  varchar2(3)
);
-- email 컬럼 추가
alter table t_alter 
add (email varchar2(30));

desc t_alter;

alter table t_alter
rename column nama to name;

alter table t_alter 
drop (email);

-- 컬럼 변경
alter table t_alter
modify (age number(3));

insert into t_alter (name, age)
values ('test', 22);

-- 컬럼 크기 증가
alter table t_alter
modify (age number(5));

-- 컬럼 크기 감소 : null 인 경우만 가능함 
alter table t_alter
modify (age number(3));  
  
  
------------------------------------------
트랜잭션 : transaction
하나의 트랜잭션 : 논리적으로 묶인 여러개의 dml 작업들
------------------------------------------
창1
SQL> select * from t_tran;

ID      
------
MSG
------
a
aaa


SQL> update t_tran set msg = 'bbb' where id = 'a';

1 행이 갱신되었습니다.

SQL> select * from t_tran;

ID
------
MSG
--------------------------------------------------------------------------------

a
bbb


SQL> commit;

커밋이 완료되었습니다.

SQL> select * from t_tran;

ID
------
MSG
--------------------------------------------------------------------------------

a
bbb


SQL> select * from t_tran;

ID
------
MSG
--------------------------------------------------------------------------------

a
ccc


SQL>
  
  
창2


SQL> select * from t_tran;

ID
------
MSG
--------------------------------------------------------------------------------

a
aaa


SQL> update t_tran set msg = 'ccc' where id = 'a';

1 행이 갱신되었습니다.

SQL> commit;

커밋이 완료되었습니다.

SQL>












