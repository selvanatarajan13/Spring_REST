-- create a table
create database if not exists `one-to-one`;

-- select the db
use `one-to-one`;

-- create table
create table if not exists `instructor_detail` (
	`id` int not null auto_increment,
    `email` varchar(60) not null,
    `channel_name` varchar(60) default null,
    
    primary key(`id`)
) engine=InnoDB auto_increment=100 default charset=latin1;

-- create another table
create table if not exists `instructor` (
	`id` int not null auto_increment,
    `first_name` varchar(60) default null,
    `last_name` varchar(60) not null,
    `instructor_detail_id` int default null,
    
    primary key(`id`)
) engine=InnoDB auto_increment=1 default charset=latin1;

-- add foreign key
alter table `instructor` add constraint `FK_DETAIL` foreign key(`instructor_detail_id`) references `instructor_detail` (`id`);