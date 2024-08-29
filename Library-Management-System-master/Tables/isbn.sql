create table isbn(
isbn_id int auto_increment,
isbn_number long ,
primary key(isbn_id)
);

insert into isbn (isbn_number)
values(001);
insert into isbn (isbn_number)
values(002);
insert into isbn (isbn_number)
values(003);
insert into isbn (isbn_number)
values(004);
insert into isbn (isbn_number)
values(005);
insert into isbn (isbn_number)
values(006);
insert into isbn (isbn_number)
values(007);
insert into isbn (isbn_number)
values(008);
insert into isbn (isbn_number)
values(009);

select * from isbn;
drop table isbn;