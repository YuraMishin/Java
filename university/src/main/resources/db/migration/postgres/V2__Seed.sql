insert into users(name)
values ('Gusev Anton');

insert into subjects(name)
values ('Algebra'),
       ('Geometry');

insert into groups(name)
values ('1A'),
       ('1B');

insert into classrooms(name)
values ('1-101'),
       ('2-202');

insert into time (starttime, endtime)
values ('08:00:00', '08:40:00'),
       ('09:00:00', '09:40:00');

insert into schedule (group_id, subject_id, day, time_id, classroom_id)
values (1, 1, 1, 1, 1);