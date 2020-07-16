create database farming_app;
use farming_app
create table mst_seasons(id serial primary key,
season_name varchar(100));
create table mst_months(id serial primary key,
month_name varchar(100),month_code varchar(3));
create table tbl_season_months(id serial primary key,
season_id bigint unsigned,month_id bigint unsigned);
alter table tbl_season_months add foreign key(season_id)
references mst_seasons(id); 
alter table tbl_season_months add foreign key(month_id)
references mst_months(id);
create table mst_plant_types(id serial primary key,
type_name varchar(100));
create table mst_plants(id serial primary key,
plant_name varchar(100),
plant_description text,
seed_image varchar(255),
plant_image varchar(255),
plant_type_id bigint unsigned,
created_date timestamp default CURRENT_TIMESTAMP,
modified_date timestamp null,
status boolean default true
);
alter table mst_plants add foreign key(plant_type_id)
references mst_plant_types(id);
create table tbl_plantation(id serial primary key,
plant_id bigint unsigned,month_from_id bigint unsigned,
month_to_id bigint unsigned
);
alter table tbl_plantation add foreign key(plant_id)
references mst_plants(id);
create table mst_roles(id serial primary key,
role_name varchar(100));
insert into mst_roles(role_name) values('admin'),('user');
create table mst_users(id serial primary key,
username varchar(100),password varchar(100),
email varchar(100),role_id bigint unsigned,
created_date timestamp default CURRENT_TIMESTAMP,
modified_date timestamp null,status boolean);
insert into mst_users(username,password,email,role_id,status)
values("admin","admin1234","admin@email","1","true");
insert into mst_users(username,password,email,role_id,status)
values("admin","
$2a$10$hpWMFU4GSyQLC/mUueWhUeJb.zFJ1aTpGoWyGC2Ee49zM30KpISfm","admin@email","1","true");
insert into mst_users(username,password,email,role_id,status)
values("user","user1234","user@email","2","true");

alter table mst_users add foreign key(role_id) 
references mst_roles(id);

select role_name from mst_roles
join mst_users on
mst_users.role_id=mst_roles.id
where mst_users.username="jan"

alter table tbl_users modify created_date timestamp default current_timestamp;

create table mst_diseases(id serial primary key,
disease_name varchar(100),
 disease_code varchar(20));
create table tbl_plant_diseases(id serial primary key,
plant_id bigint unsigned,
 disease_id bigint unsigned);

alter table tbl_plant_diseases add foreign key(plant_id) 
references mst_plants(id);
alter table tbl_plant_diseases add foreign key(disease_id) 
references mst_diseases(id);
