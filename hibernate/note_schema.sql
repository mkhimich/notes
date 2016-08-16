drop table if exists notes
drop table if exists users
create table notes (id bigint not null auto_increment, add_date bigint not null, note varchar(255), user_id bigint not null, primary key (id))
create table users (id bigint not null auto_increment, reg_date bigint not null, email varchar(255), nickname varchar(255) not null, password varchar(255), primary key (id))
