create sequence board_seq;  --�������� ���������� �ְڴٴ� ��

create table tbl_board(
 board_no number primary key,  --�Խñ� ��ȣ
 title varchar2(100) not null, --����
 content varchar2(1000) not null, --����
 writer varchar2(30) not null, --�ۼ���
 write_date date default sysdate, --�ۼ��Ͻ�
 read_cnt number default 0);  --��ȸ��
 
insert into tbl_board(board_no, title, content, writer)
values(board_seq.nextval, '�Խñۿ���', '�۵�Ͽ������Դϴ�', 'user01');

insert into tbl_board(board_no, title, content, writer)
values(board_seq.nextval, 'mybatis������', 'mybatis�� �����ӿ�ũ�Դϴ�', 'user02');

insert into tbl_board(board_no, title, content, writer)
values(board_seq.nextval, 'JSP�� ���?', '���ݺ����ϳ� ����־��', 'user03');

insert into tbl_board(board_no, title, content, writer)
values(board_seq.nextval, '����������̤�', '�����ּ���...��', 'user04');



select * from tbl_board
order by board_no;

select to_char(write_date, 'yyyy-mm-dd hh24:mi:ss') wdate
from tbl_board;
 
--����¡ó�� (���� ������ �־�ߵ�)
--board_no�������� ����
select b.*
from (select rownum rn, a.*
     from (select *
     from tbl_board
     order by board_no desc) a) b
where b.rn > (:page -1) * 5 
and b.rn<= :page * 5;

--���� �ִ� ����� ����..
insert into tbl_board(board_no, title, content, writer)
select board_seq.nextval, title, content, writer
from tbl_board;

select count(*)
from tbl_board;

create table tbl_member ( 
                         member_id varchar2(30) primary key,
                         member_name varchar2(100) not null,
                         password varchar2(50) not null,
                         reponsibility varchar2(10) default 'User');
                         
                         
insert into tbl_member 
values ('user01', '���̿�', '1111', 'User');

insert into tbl_member 
values ('user03', '�赿��', '2222', 'User');

insert into tbl_member 
values ('user99', '������', '3333', 'User');

insert into tbl_member 
values ('user98', '��������', '4444', 'User');

insert into tbl_member 
values ('user97', '����', '5555', 'User');

insert into tbl_member 
values ('user96', '¡¡��', '6666', 'User');

select *
from tbl_member;

update tbl_member
set reponsibility = 'Admin'
where Member_name = '���̿�';
        

--������̺�
create sequence reply_seq;
create table tbl_reply(reply_no number    --��۹�ȣ
                       ,board_no number not null   --�����۹�ȣ
                       ,reply varchar2(300) not null   --��۳���
                       ,replyer varchar2(100) not null  --����ۼ���
                       ,reply_date date default sysdate);   --�ۼ��Ͻ�
alter table tbl_reply add constraint pk_reply
                                      primary key(reply_no);

--221�� �ۿ� ���� ���

insert into tbl_reply (reply_no, board_no, reply, replyer)
values (reply_seq.nextval, 221, '221���� ����Դϴ�.', 'user01');

insert into tbl_reply (reply_no, board_no, reply, replyer)
values (reply_seq.nextval, 221, '221���� �����Դϱ�?', 'user01');

insert into tbl_reply (reply_no, board_no, reply, replyer)
values (reply_seq.nextval, 221, '��ۿ�������', 'user01');

insert into tbl_reply (reply_no, board_no, reply, replyer)
values (reply_seq.nextval, 213, '213���� ����Դϴ�.', 'user01');

insert into tbl_reply (reply_no, board_no, reply, replyer)
values (reply_seq.nextval, 213, '213���� �����Դϱ�?', 'user01');

insert into tbl_reply (reply_no, board_no, reply, replyer)
values (reply_seq.nextval, 213, '����۾��ϱ�', 'user01');


insert into tbl_reply (reply_no, board_no, reply, replyer)
values (reply_seq.nextval, 3, '����۾��ϱ�', 'user01');

insert into tbl_reply (reply_no, board_no, reply, replyer)
values (reply_seq.nextval, 3, '������ ����׿�', 'user01');

insert into tbl_reply (reply_no, board_no, reply, replyer)
values (reply_seq.nextval, 3, '�̹��ֵ� ���� ��������~', 'user01');

insert into tbl_reply (reply_no, board_no, reply, replyer)
select reply_seq.nextval, board_no, reply, replyer
from tbl_reply
where board_no = 3;


select *
from tbl_reply
where board_no = 3;

 select reply_seq.nextval 
 from dual;

--index�� Ȱ���ؼ� �������༭ order by ���X
select a.*  
from (select/*+INDEX_DESC (r pk_reply) */rownum rn, r.* 
      from tbl_reply r
      where board_no = :bno) a
where a.rn > (:page -1) * 5
and a.rn <= (:page * 5);

-- �ۼ��� 
select writer, member_name, count(1)
from tbl_board b
join tbl_member m
on b.writer = m.member_id
group by writer, member_name;

--event���̺� ����
create table tbl_events(title varchar2(30) not null,      
                       d_start varchar2(300) not null,   
                       d_end varchar2(100)); 
                    
drop table tbl_events;


insert into tbl_events(title, d_start, d_end)
values ('Birthday', '2025-06-16', null);

insert into tbl_events(title, d_start, d_end)
values ('meeting', '2025-06-02', '2025-06-04');

select *
from tbl_events
order by title;

