drop database if exists illud_prototype;
create database illud_prototype; 
use illud_prototype;


create table if not exists author(
    author_id int not null auto_increment, 
    author_name char(50),
    nacionality char(30) not null,
    primary key(author_id)
);

create table if not exists publisher(
    publisher_id int not null auto_increment,
    publisher_name varchar(256), 
    street_name varchar(256) not null,
    city_name varchar(256) not null,
    country_name char(30) not null,
    primary key(publisher_id)
);

create table if not exists books(
    book_code int not null auto_increment,
    barcode varchar(256) not null,
    title varchar(256),
    _year int, 
    publisher_id int not null,
    author_id int not null,
    foreign key(author_id) references author(author_id),
    foreign key(publisher_id) references publisher(publisher_id),
    primary key(book_code)
);





