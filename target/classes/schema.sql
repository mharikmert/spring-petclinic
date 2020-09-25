create table t_owner
(
    id         bigint not null,
    first_name varchar(255),
    last_name  varchar(255)
);
create table t_pet
(
    id         bigint not null,
    name       varchar(255),
    birth_date date,
    owner_id   bigint
);
alter table t_owner add constraint constraint_1 primary key(id);

alter table t_pet add constraint constraint_2 primary key(id);

alter table t_pet add constraint constraint_3 foreign key(owner_id) references public.t_owner(id);

create sequence public.petclinic_sequnce start with 100;
