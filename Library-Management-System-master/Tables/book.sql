create table book(
book_id int auto_increment,
book_name varchar(50),
author_id int,
isbn_id int,
primary key(book_id),
foreign key(author_id) references author(author_id),
foreign key(isbn_id) references isbn(isbn_id)
);
alter table book
add Quantity int ;

insert into book (book_name,author_id,isbn_id,Quantity)
values();

update book
set Quantity = Quantity+1;

update book
set Quantity = Quantity-1;

alter table book
drop foreign key isbn_id;

update book set isbn_id=9 where book_id =9;

select  from book;

select * from book where book_id=2;

select book_name,book_id from book where book_id=(select book_id from user_book_mapping where user_id =?);

update book set Quantity = Quantity-1 where book_id =?;

select * from book where book_name like 'gitanjali';

select max(book_id) from book;


update book set Quantity = Quantity+1 where (select book_id from user_book_mapping where user_id = 2);

update book set Quantity = Quantity+1 where (select book_id from issue_book where issue_id = 1);

select * from book where book_name like 'gitanjali';

select book_name,book_id from book where book_id=(select book_id from user_book_mapping where user_id =2);
