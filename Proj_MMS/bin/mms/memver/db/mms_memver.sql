맥 monterey sqldeveloper 오류-- javalink/javalink

CREATE TABLE mms_member(
	id number primary key,
	name varchar2(12) unique not null,
	addr varchar2(50) not null,
	nation varchar2(12) not null,
	email varchar2(30) not null,
	age number null
);

create sequence mms_member_id_seq;

select * from mms_member;