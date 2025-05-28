create table swim_member (member_name varchar(30) primary key,
                          phone varchar2(30) not null,
                          member_date varchar(30),
                          class_level varchar2(30),
                          class_time varchar2(30)
                          );
desc swim_member;

select *
from swim_member;

insert into swim_member (member_name,
                       phone,
                       member_date,
                       class_level,
                       class_time
                       )
values('손이영', '010-1234-1234', '980405', '초급', '19시');
drop table swim_member;

create table swim_member (member_id VARCHAR2(30) primary key,
                          member_name varchar(30),
                          phone varchar2(30),
                          member_date varchar(30),
                          class_level varchar2(30),
                          class_time varchar2(30)
                          );
select *
from swim_member;