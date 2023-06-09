create table solo_project1_site_member(
	m_id varchar2(20 char) primary key,
	m_pw varchar2(20 char) not null,
	m_name varchar2(20 char) not null,
	m_pic varchar2(50 char) not null,
	m_sex varchar2(20 char) not null,
	m_point number(10) not null,
	m_createdate date not null,
	m_birth date not null
);

insert into solo_project1_site_member values ('test1', 'test1', 'test1', 'test1', 'male', 5000, sysdate, to_date('1994-11-16', 'YYYY-MM-DD'));

select * from solo_project1_site_member;

select * from movie_test;

-- asd Asdasd123 test2
-- test3 Test3asd