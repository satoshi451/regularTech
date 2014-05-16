create table office_object_type(
id int auto_increment,
name varchar(512) not null,
primary key(id)
);

create table office_object(
id int auto_increment,
name varchar(512) not null,
office_object_type_id int,

primary key(id),
foreign key(office_object_type_id) references office_object_type(id)
);

create table financial_types(
id int auto_increment,
name varchar(512) not null,
primary key(id)
);

create table office_oject_financial (
id int auto_increment,
office_oject_id int not null,
financial_types_id int not null,
cost int,
action_date date,
primary key(id),
foreign key (office_oject_id) references office_oject(id),
foreign key (financial_types_id) references financial_types(id)
);


