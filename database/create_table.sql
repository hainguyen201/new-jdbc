use newservlet12month2018;
create table role(
	id bigint not null identity(1,1) primary key,
	name varchar(255) not null,
	code varchar(255) not null,
	createddtate datetime null,
	modifieddate datetime null,
	createdby varchar(255) null,
	modifiedby varchar(255) null
);
create table userr(
	id bigint not null identity(1,1) primary key,
	username varchar(150) not null,
	password varchar(150) not null,
	fullname varchar(150) null,
	status  int not null,
	roleid bigint not null,
	createddtate datetime null,
	modifieddate datetime null,
	createdby varchar(255) null,
	modifiedby varchar(255) null	
);
alter table userr add constraint
fk_userr_role foreign key (roleid) references role(id);
create table news (
	id bigint not null identity(1,1) primary key,
	title varchar(255) null,
	thumbnail varchar(255) null,
	shortdesciption text null,
	content text null,
	categoryid bigint not null,
	createddtate datetime null,
	modifieddate datetime null,
	createdby varchar(255) null,
	modifiedby varchar(255) null
)
create table category(
	id bigint not null identity(1,1) primary key,
	name varchar(255) not null,
	code varchar(255) not null,
	createddtate datetime null,
	modifieddate datetime null,
	createdby varchar(255) null,
	modifiedby varchar(255) null
);
alter table news add constraint fk_news_category foreign key (categoryid) references category(id);
create table comment(
	id bigint not null identity(1,1) primary key,
	content text not null,
	user_id bigint  not null,
	new_id bigint not null,
	createddtate datetime null,
	modifieddate datetime null,
	createdby varchar(255) null,
	modifiedby varchar(255) null
);
alter table comment add constraint fk_comment_user foreign key (user_id) references userr(id);
alter table comment add constraint fk_comment_news foreign key (new_id) references news(id);


