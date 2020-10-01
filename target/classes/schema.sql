create table users(
    username varchar(128) not null primary key ,
    password varchar(512) not null,
    enabled boolean
);
create table authorities(
    username varchar(128),
    authority varchar(128)
);
CREATE TABLE t_owner(
    id BIGINT NOT NULL,
    first_name VARCHAR(255),
    last_name VARCHAR(255)
);            
ALTER TABLE t_owner ADD CONSTRAINT CONSTRAINT_1 PRIMARY KEY(id);

CREATE TABLE t_pet(
    id BIGINT NOT NULL,
    name VARCHAR(255),
    birth_date DATE,
    owner_id BIGINT
);            
ALTER TABLE t_pet ADD CONSTRAINT CONSTRAINT_2 PRIMARY KEY(id);

ALTER TABLE t_pet ADD  CONSTRAINT CONSTRAINT_3 FOREIGN KEY(owner_id)  REFERENCES t_owner(id);

