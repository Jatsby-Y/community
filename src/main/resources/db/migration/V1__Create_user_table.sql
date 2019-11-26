create table user
(
    id int auto_increment not null,
    account_id varchar(100),
    name varchar(50),
    token varchar(36),
    gmt_create bigint,
    gmt_modified bigint,
    primary key (id)
);