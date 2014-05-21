create table appusers(
	id int auto_increment not null primary key,
 	login varchar(128) unique not null,
  password varchar(128) not null,
  isadmin int(11)
);