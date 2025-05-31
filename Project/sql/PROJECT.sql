
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

insert into swim_class
            ( class_level,
            teacher,
            subject)
values ( '고급',
        '킹콩',
        '접영완성');
        
        insert into swim_class
            ( class_level,
            teacher,
            subject)
values ( '마스터',
        '호남',
        '오리발');
        
select class_level,
       teacher,
       subject
from swim_class
where class_level = '초급';


create table teacher ( 
                        name VARCHAR2(30),
                          phone varchar(30),
                          gender varchar2(30)
                          );
                        
        
insert into teacher ( name,
                     phone,
                     gender)
values ('손이영',
        '01055558888',
        '여자');
        
insert into teacher ( name,
                     phone,
                     gender)
values ('김동동',
        '010588884444',
        '남자');        
                      
SELEct * from teacher;

insert into swim_class
            ( class_level,
            teacher,
            subject)
values ( '고급',
        '김동동',
        '접영완성');

insert into swim_class
            ( class_level,
            teacher,
            subject)
values ( '고급',
        '손이영',
        '자유형완성');

select *
from teacher 
where name = (select teacher
             from swim_class
             where subject= '접영완성');
