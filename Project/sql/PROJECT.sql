
create table swim_member (member_id VARCHAR2(30) primary key,
                          member_name varchar(30),
                          phone varchar2(30),
                          member_date varchar(30),
                          class_level varchar2(30),
                          class_time varchar2(30)
                          );
select *
from swim_member;

select  member_id,
       member_name,
       phone
from swim_member;

select member_id
from swim_member;

delete from swim_member
where member_id = 'user02';

commit;
select *
from swim_member;

select member_id,
       member_name,
       phone,
       member_date
from swim_member
where member_id = 'user01';

/* 테이블 생성 */
create table swim_class(class_level VARCHAR2(30)not null,
                          teacher varchar2(30),
                          subject varchar2(30)
                          );
SELECT
    * FROM swim_class; 
    
insert into swim_class
            ( class_level,
            teacher,
            subject)
values ( '초급',
        '밤비',
        '호흡배우기');
        
insert into swim_class
            ( class_level,
            teacher,
            subject)
values ( '초급',
        '밤비',
        '자유형발차기');