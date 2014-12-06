drop table parkedcars;

create table parkedcars(id int primary key not null generated always as identity (start with 1, increment by 1)
						, vehicle varchar(10) not null
						, inside boolean not null
						, fee int);