create table users(
    username varchar(128) not null primary key,
    password varchar(512) not null,
    enabled boolean
);
create table authorities(
    username varchar(128),
    authority varchar(128)
);
CREATE TABLE t_owner(
    id bigint primary key auto_increment,
    first_name VARCHAR(255) not null,
    last_name VARCHAR(255) not null
);

CREATE TABLE t_pet(
    id BIGINT NOT NULL primary key auto_increment,
    name VARCHAR(255),
    birth_date DATE,
    owner_id BIGINT
);

create table t_vet(
    id bigint primary key auto_increment,
    first_name varchar(255),
    last_name varchar(355)
);
ALTER TABLE t_pet ADD  CONSTRAINT CONSTRAINT_3 FOREIGN KEY(owner_id)  REFERENCES t_owner(id);
ALTER TABLE t_vet ADD  CONSTRAINT CONSTRAINT_11 FOREIGN KEY(id)  REFERENCES t_owner(id);

