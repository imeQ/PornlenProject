alter table pornlen.driver modify column pin integer;
alter table pornlen.driver modify column password integer;
insert into pornlen.application_user(last_modified_date, name) values (now(), 'Mietek');