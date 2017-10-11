create table tb_board (
	no int(10) auto_increment primary key,
	writer varchar(30) not null,
	title varchar(300) not null,
	content varchar(4000) not null,
	reg_date datetime default now() 
);

select * from tb_board;

insert into tb_board(writer, title, content) values
('tester1', '연습1', 'mysql1'),
('tester2', '연습2', 'mysql2'),
('tester3', '연습3', 'mysql3');

commit;