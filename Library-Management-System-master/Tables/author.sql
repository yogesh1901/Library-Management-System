create table author(
author_id int auto_increment,
author_name varchar(20),
primary key(author_id)
);

insert into author(author_name)
values('chetan bhagat');

insert into author(author_name)
values('amrita pritam');

insert into author(author_name)
values('Jhumpa Lahiri');

insert into author(author_name)
values('Khushwant Singh');

insert into author(author_name)
values(' R. K. Narayan');

insert into author(author_name)
values('Rabindranath Tagore');

insert into author(author_name)
values('Ruskin Bond');

select * from author;



delete from author where author_id = 6;