create database Library;
use Library;


create table issue_book(
issue_id int auto_increment,
user_id int,
book_id int,
issue_date date,
ecpected_return_date date,
return_date date ,
primary key(issue_id),
foreign key(user_id) references users(user_id),
foreign key(book_id) references book(book_id)
);


alter table issue_book
add column status varchar(20) default( 'pending');


drop table issue_book;

alter table issue_book
rename column late_return_fine to total_due;

alter table issue_book
add total_due long ;

select * from issue_book;

update issue_book set total_due= if(curdate()-ecpected_return_date<0,0,null)where user_id=2  and book_id = 3;

update issue_book set total_due= if(curdate()-ecpected_return_date<0,0,100) where book_id =3;

select book_id from issue_book where ecpected_return_date=curdate();

delete from issue_book where issue_id=4;

truncate table issue_book;