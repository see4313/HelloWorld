
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
                          '���̿�',
                          '01012345678',
                          '980519',
                          '�ʱ�',
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

/* ���̺� ���� */
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
values ( '�ʱ�',
        '���',
        'ȣ�����');
        
insert into swim_class
            ( class_level,
            teacher,
            subject)
values ( '�߱�',
        '���',
        '�򿵹�����');

insert into swim_class
            ( class_level,
            teacher,
            subject)
values ( '���',
        'ŷ��',
        '�����ϼ�');
        
        insert into swim_class
            ( class_level,
            teacher,
            subject)
values ( '������',
        'ȣ��',
        '������');
        
select class_level,
       teacher,
       subject
from swim_class
where class_level = '�ʱ�';


create table teacher ( 
                        name VARCHAR2(30),
                          phone varchar(30),
                          gender varchar2(30)
                          );
                        
        
insert into teacher ( name,
                     phone,
                     gender)
values ('���̿�',
        '01055558888',
        '����');
        
insert into teacher ( name,
                     phone,
                     gender)
values ('�赿��',
        '010588884444',
        '����');        
                      
SELEct * from teacher;

insert into swim_class
            ( class_level,
            teacher,
            subject)
values ( '���',
        '�赿��',
        '�����ϼ�');

insert into swim_class
            ( class_level,
            teacher,
            subject)
values ( '���',
        '���̿�',
        '�������ϼ�');

select *
from teacher 
where name = (select teacher
             from swim_class
             where subject= '�����ϼ�');
