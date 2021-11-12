-- javalink/javalink

drop table Book;
create table book (
	id varchar2(20) primary key,
	name varchar2(20),
	price number(10)
);

insert into Book values('aaaa','hong',1000);
insert into Book values('bbbb','alphago',2000);
insert into Book values('cccc','beta',3000);

select * from book;
