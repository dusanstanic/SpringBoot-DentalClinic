create database if not exists dentalclinic;

use dentalclinic;

create table dentist 
(
	id int primary key auto_increment,
	phone_number varchar(255) not null,
	first_name varchar(255) not null,
    last_name varchar(255) not null
);

create table type
(
	id int primary key auto_increment,
    name varchar(255) not null
);

create table appointment_time (
	id int primary key auto_increment,
	appointment_date date not null,
    from_time time not null,
    to_time time not null,
    available boolean not null
);

create table appointment (
	id int primary key auto_increment,
	phone_number int not null,
    type_id int not null,
    appointment_time_id int not null,
    foreign key (type_id) references type(id),
	foreign key (appointment_time_id) references appointment_time(id)
);

insert into appointment_time(appointment_date, from_time, to_time, available) values 
('2020-07-04', '09:00:00', '09:30:00', true), 
('2020-07-05', '09:00:00', '09:30:00', true), 
('2020-07-05', '09:30:00', '10:00:00', true), 
('2020-07-05', '10:00:00', '10:30:00', true), 
('2020-07-05', '10:30:00', '11:00:00', true),
('2020-07-05', '11:00:00', '11:30:00', true), 
('2020-07-05', '11:30:00', '12:00:00', true), 
('2020-07-05', '12:00:00', '12:30:00', true), 
('2020-07-05', '12:30:00', '13:00:00', true), 
('2020-07-05', '13:00:00', '13:30:00', true), 
('2020-07-05', '13:30:00', '14:00:00', true), 
('2020-07-05', '14:00:00', '14:30:00', true), 
('2020-07-05', '14:30:00', '15:00:00', true), 
('2020-07-05', '15:00:00', '15:30:00', true), 
('2020-07-05', '15:30:00', '16:00:00', true),  
('2020-07-05', '16:00:00', '16:30:00', true), 
('2020-07-05', '16:30:00', '17:00:00', true),
('2020-07-05', '09:00:00', '10:00:00', true), 
('2020-07-05', '10:00:00', '11:00:00', true), 
('2020-07-05', '11:00:00', '12:00:00', true), 
('2020-07-05', '12:00:00', '13:00:00', true), 
('2020-07-05', '13:00:00', '14:00:00', true), 
('2020-07-05', '14:00:00', '15:00:00', true), 
('2020-07-05', '15:00:00', '16:00:00', true), 
('2020-07-05', '16:00:00', '17:00:00', true);

insert into dentist(first_name, last_name, phone_number) values ('Dusan','Stanic', 0651111111);

insert into type(name) values ('Cleaning'), ('Cavity');

insert into appointment(first_name, last_name, phone_number, type_id, appointment_time_id) values ('Client1','Client1', 0654567890, 1, 1);















