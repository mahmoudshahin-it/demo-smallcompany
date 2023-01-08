create table IF not exists lookup_skills
(
    id uuid not null PRIMARY KEY,
    created_by varchar not null,
    create_time timestamp not null,
    updated_by varchar,
    update_time timestamp,
    active boolean default true not null,
    skillname varchar


);

create unique index if not exists lookup_skills_unique_skillname on lookup_skills (lower(skillname));

create table IF not exists departments
(
    id uuid not null PRIMARY KEY,
    created_by varchar not null,
    create_time timestamp not null,
    updated_by varchar,
    update_time timestamp,
    active boolean default true not null,
    departmentname varchar


);

create unique index if not exists departments_unique_departmentname on departments (lower(departmentname));


create table IF not exists employees
(
    id uuid not null PRIMARY KEY,
    created_by varchar not null,
    create_time timestamp not null,
    updated_by varchar,
    update_time timestamp,
    active boolean default true not null,
    firstname varchar,
    lastname varchar,
    phone varchar,
    email varchar,
    birthdate date,
    address varchar,
    departmentid uuid constraint employees_departments_departmentid_fk
    references departments
);

create unique index if not exists employees_unique_phone on employees (lower(phone));
create unique index if not exists employees_unique_email on employees (lower(email));
create unique index if not exists employees_unique_name on employees (lower(firstname),lower(lastname));

create table IF not exists employeess_skills
(
    employeeid uuid not null  constraint employees_fk
    references employees,
    skillid uuid not null constraint skills_fk
    references lookup_skills
)
