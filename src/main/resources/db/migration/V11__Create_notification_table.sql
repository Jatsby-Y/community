create table notification
(
	id bigint auto_increment not null,
	notifier bigint not null,
	receiver bigint not null,
	outerid bigint not null,
	type int not null,
	gmt_create bigint not null,
	status int default 0 not null,
	primary key (id)
);