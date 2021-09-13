insert into users(name)
values ('User1');

insert into subjects(name)
values ('Subject1'),
       ('Subject2');

insert into groups(name)
values ('Group1'),
       ('Group2');

insert into classrooms(name)
values ('Classroom1'),
       ('Classroom2');

insert into time (starttime, endtime)
values ('08:00:00', '08:40:00'),
       ('09:00:00', '09:40:00');

insert into schedule (group_id, subject_id, day, time_id, classroom_id)
values (1, 1, 1, 1, 1);
