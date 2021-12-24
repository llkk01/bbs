--P.446
--jsp/jsp
--교재(MySQL) =>마이그레이션해서 Oracle로 변경해서 작성해야한다.
create table guestbook_message(
	message_id int not null primary key,
	guest_name varchar2(50) not null,
	password varchar2(10) not null,
	message long not null
);

select * from guestbook_message;

--auto_increment(MySQL) => sequence(Oracle)로 변경해서 작업
create sequence message_id_seq INCREMENT BY 1 START WITH 1; 

commit;