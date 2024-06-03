/*
  Authors: Yu-Pin Liang
*/


DROP database if exists `group48`;
CREATE DATABASE if not exists `group48`;
USE group48;


drop table if exists users;
create table users(
state varchar(766),
subcategory varchar(766),
category varchar(766),
numFollowing int,
numFollowers int,
name varchar(766),
screenname varchar(766),
primary key(screenname)
);


drop table if exists tweets;
create table tweets(
tid bigint NOT NULL,
text text, 
retweet_count int,
createdTime date,

posts_by varchar(766),
primary key(tid),
foreign key (posts_by) references users (screenname)
);



drop table if exists mentions;
create table mentions(

tid bigint NOT NULL,
screenname varchar(766) NOT NULL,

primary key(tid,screenname),
foreign key (tid) references tweets (tid),
foreign key (screenname) references users (screenname)
);

drop table if exists hasTags;
create table hasTags(
name varchar(766),
tid bigint,
primary key(name,tid),
foreign key (tid) references tweets (tid)
);

drop table if exists hasUrls;
create table hasUrls(
address varchar(766),
tid bigint,
primary key(address,tid),
foreign key (tid) references tweets (tid)
);
