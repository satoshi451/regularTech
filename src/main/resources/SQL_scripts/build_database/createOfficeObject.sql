create table office_object(
	  id int nou null auto_increment primary key,
    name varchar(512) not null,
    office_object_type_id int,
    foreign key(office_object_type_id) references office_object_type(id)
);