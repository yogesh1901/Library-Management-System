create table librarian(
admin_id int primary key auto_increment,
admin_username varchar(20),
admin_password varchar(20)
);

insert into librarian(admin_username,admin_password) values('Rohan','sharma');
select * from librarian;