create table office_object_finantial(
	  id int not null auto_increment,
    office_object_id int not null,
    finantial_types_id int not null,
    cost int ,
    action_date date,
    primary key(id),
    foreign key(office_object_id) references office_object_type(id),
    foreign key(finantial_types_id) references finantial_types(id)
);