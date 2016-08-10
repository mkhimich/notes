drop DATABASE notes_test if exists;
create table NOTES (ID INT identity primary key, user_id INT not null, note varchar(45) not null, note_full varchar(255));