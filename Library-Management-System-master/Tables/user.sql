create table user(
user_id int primary key auto_increment,
user_name varchar(20)
);
alter table user
add user_password varchar(20);

alter table user
add total_due int;

alter table user
modify user_phone long;


insert into user(user_name)
values();



select * from users;

alter table user 
modify user_phone long;
alter table user 
rename to users;

delete from user where user_id=1;

update users set total_due= if( curdate()-ecpected_return_date<0,0,total_due+100) where user_id=2;

update users set total_due= if( select user_id from issue_book where curdate()-ecpected_return_date<0,0,total_due+100) where user_id=2;