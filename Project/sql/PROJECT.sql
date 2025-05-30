
create table swim_member (member_id VARCHAR2(30) primary key,
                          member_name varchar(30),
                          phone varchar2(30),
                          member_date varchar2(30),
                          class_level varchar2(30),
                          class_time varchar2(30)
                          );
select *
from swim_member;

insert into swim_member(
                       member_id,
                       member_name,
                       phone,
                       member_date,
                       class_level,
                       class_time)
values (
                          'user01',
                          '손이영',
                          '01012345678',
                          '980519',
                          '초급',
                          '10:00');

                          

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
values ( '중급',
        '밤비',
        '평영발차기');

select class_level,
       teacher,
       subject
from swim_class
where class_level = '초급';