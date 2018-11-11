--创建学生表
create table Student(
  Sno char(9) primary key,
  Sname char(10)unique,	
  Ssex char(2),
  Sage smallint,
  Sdept char(20)
)

--插入数据
  insert into Student values('200215121','李勇','男',20,'CS');
  insert into student values('200215122','刘晨','女',19,'CS');
  insert into student values('200215123','王敏','女',18,'MA');
  insert into student values('201215125','张立','男',19,'IS');
 
--drop table Student;

--创建课程表
create table Course(
   Cno char(9) primary key,
   Cname char(40) unique,
   Cpno char(4),
   Ceredit smallint, 
)

--插入数据
  insert into Course values('1','数据库','5',4)
  insert into Course values('2','数学','',2)
  insert into Course values('3','信息系统','1',4)
  insert into Course values('4','操作系统','6',3)
  insert into Course values('5','数据结构','7',4)
  insert into Course values('6','数据处理','',2)
  insert into Course values('7','PASCAL语言','6',4)

--drop table  Course;

--建立连接
create table SC(
   Grade smallint,
   Sno char(9) constraint fk_Sno foreign key references Student(Sno),
   Cno char(9)  foreign key references Course(Cno),
   --constraint pk_SC  primary key (Sno,Cno,Grade) --把三个字段变成一个共同主键
)

--插入数据
   insert into SC values(92,'200215121','1')
   insert into SC values(85,'200215121','2')
   insert into SC values(88,'200215121','3')
   insert into SC values(90,'200215122','2')
   insert into SC values(80,'200215122','3')
   
--drop table SC

--select * from Course,Student,SC


