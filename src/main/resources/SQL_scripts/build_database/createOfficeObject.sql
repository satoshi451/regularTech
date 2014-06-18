create table office_object(
  id int not null auto_increment primary key,
  name varchar(64) not null,
  office_object_type_id int,
  office_object_status_id int,
  foreign key(office_object_type_id) references office_object_type(id),
  foreign key(office_object_status_id) references office_object_status(id)
);