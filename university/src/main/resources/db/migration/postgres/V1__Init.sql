create table subjects
(
    id   bigserial primary key,
    name varchar(50) unique
);

create table groups
(
    id   bigserial primary key,
    name varchar(50) unique
);

create table time
(
    id        bigserial primary key,
    startTime time,
    endTime   time
);

create table classrooms
(
    id   bigserial primary key,
    name varchar(50) unique
);

create table roles
(
    id   bigserial primary key,
    name varchar(50) unique
);

create table schedule
(
    id           bigserial primary key,
    group_id     bigint references groups (id),
    subject_id   bigint references subjects (id),
    day          smallint,
    time_id      bigint references time (id),
    classroom_id bigint references classrooms (id),
    role_id      bigint references roles (id)
);

create table users
(
    id   bigserial primary key,
    name varchar(50)
);

create table user_role
(
    user_id bigint references users,
    role_id bigint references roles,
    primary key (user_id, role_id)
);
