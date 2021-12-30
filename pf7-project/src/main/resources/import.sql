insert into PEOPLE(ID, YOB, COUNTRY, FIRSTNAME, ISALIVE, LASTNAME) values (1,1960,'Italy','Damiano',FALSE,'Moretti');
insert into PEOPLE(ID, YOB, COUNTRY, FIRSTNAME, ISALIVE, LASTNAME) values (2,1986,'United Kingdom','John',TRUE,'Brown');
insert into PEOPLE(ID, YOB, COUNTRY, FIRSTNAME, ISALIVE, LASTNAME) values (3,1989,'Norway','Magnus',TRUE,'Carlsen');
insert into PEOPLE(ID, YOB, COUNTRY, FIRSTNAME, ISALIVE, LASTNAME) values (4,1942,'France','Amelie',FALSE,'Trindeux');
insert into PEOPLE(ID, YOB, COUNTRY, FIRSTNAME, ISALIVE, LASTNAME) values (5,2002,'Greece','Constantinos',TRUE,'Constantopoulos');
insert into PEOPLE(ID, YOB, COUNTRY, FIRSTNAME, ISALIVE, LASTNAME) values (6,1907,'United States','John',FALSE,'Jackson');
insert into PEOPLE(ID, YOB, COUNTRY, FIRSTNAME, ISALIVE, LASTNAME) values (7,1969,'China','Lee',FALSE,'Sin');
insert into PEOPLE(ID, YOB, COUNTRY, FIRSTNAME, ISALIVE, LASTNAME) values (8,1948,'Australia','Jake',FALSE,'Smith');
insert into PEOPLE(ID, YOB, COUNTRY, FIRSTNAME, ISALIVE, LASTNAME) values (9,1999,'Slovenia','Luka',TRUE,'Doncic');
insert into PEOPLE(ID, YOB, COUNTRY, FIRSTNAME, ISALIVE, LASTNAME) values (10,1955,'Japan','Tanaka',TRUE,'Mayumi');
insert into PEOPLE(ID, YOB, COUNTRY, FIRSTNAME, ISALIVE, LASTNAME) values (11,1972,'Japan','Takeuchi ',TRUE,'Junko');


insert into FILMS (ID, DESCRIPTION, DURATION, LANGUAGE, RATING, RELEASEYEAR, TITLE) values (1,'Do not watch this alone',136,'English','four',2016,'Are you alone ?');
insert into FILMS (ID, DESCRIPTION, DURATION, LANGUAGE, RATING, RELEASEYEAR, TITLE) values (2,'Do watch this alone',146,'English','two',2018,'Are you alone ? 2');
insert into FILMS (ID, DESCRIPTION, DURATION, LANGUAGE, RATING, RELEASEYEAR, TITLE) values (3,'A show about pirates',25,'Japanese','five',1998,'One Piece');
insert into FILMS (ID, DESCRIPTION, DURATION, LANGUAGE, RATING, RELEASEYEAR, TITLE) values (4,'A show about pirates',25,'Japanese','five',2012,'One Piece, Marineford');
insert into FILMS (ID, DESCRIPTION, DURATION, LANGUAGE, RATING, RELEASEYEAR, TITLE) values (5,'A show about pirates',24,'Japanese','five',2018,'One Piece, Dressrosa');
insert into FILMS (ID, DESCRIPTION, DURATION, LANGUAGE, RATING, RELEASEYEAR, TITLE) values (6,'A show about ninjas',25,'Japanese','four',1999,'Naruto');
insert into FILMS (ID, DESCRIPTION, DURATION, LANGUAGE, RATING, RELEASEYEAR, TITLE) values (7,'A show about ninjas',25,'Japanese','five',2001,'Naruto, Chounin Exams');
insert into FILMS (ID, DESCRIPTION, DURATION, LANGUAGE, RATING, RELEASEYEAR, TITLE) values (8,'A show about ninjas',26,'Japanese','five',2011,'Naruto, Akatsuki');
insert into FILMS (ID, DESCRIPTION, DURATION, LANGUAGE, RATING, RELEASEYEAR, TITLE) values (9,'Luca and Bugs Bunny ',113,'English','four',2026,'Space Jump 3');
insert into FILMS (ID, DESCRIPTION, DURATION, LANGUAGE, RATING, RELEASEYEAR, TITLE) values (10,'Best movie no one knows',129,'English','three',2014,'Peanut Butter');


insert into TVSHOWS(NUMBEROFEPISODES, NUMBEROFSEASONS, ID) values (2,22,3);
insert into TVSHOWS(NUMBEROFEPISODES, NUMBEROFSEASONS, ID) values (2,14,6);
--
--
-- insert into TVSHOWS_EPISODES(TVSHOW_ID, EPISODES_ID) values (3 ,4 );
-- insert into TVSHOWS_EPISODES(TVSHOW_ID, EPISODES_ID) values (3 ,5 );
-- insert into TVSHOWS_EPISODES(TVSHOW_ID, EPISODES_ID) values (6 ,8 );
-- insert into TVSHOWS_EPISODES(TVSHOW_ID, EPISODES_ID) values (6 ,7 );
--

insert into FILMGENRE(FILM_ID, GENRE_ID) values(1,'Romance');
insert into FILMGENRE(FILM_ID, GENRE_ID) values(1,'Horror');
insert into FILMGENRE(FILM_ID, GENRE_ID) values(1,'Thriller');
insert into FILMGENRE(FILM_ID, GENRE_ID) values(2,'Romance');
insert into FILMGENRE(FILM_ID, GENRE_ID) values(2,'Horror');
insert into FILMGENRE(FILM_ID, GENRE_ID) values(2,'Thriller');
insert into FILMGENRE(FILM_ID, GENRE_ID) values(2,'SciFi');
insert into FILMGENRE(FILM_ID, GENRE_ID) values(3,'Adventure');
insert into FILMGENRE(FILM_ID, GENRE_ID) values(3,'Comedy');
insert into FILMGENRE(FILM_ID, GENRE_ID) values(3,'Fantasy');
insert into FILMGENRE(FILM_ID, GENRE_ID) values(3,'Animation');
insert into FILMGENRE(FILM_ID, GENRE_ID) values(4,'Adventure');
insert into FILMGENRE(FILM_ID, GENRE_ID) values(4,'Comedy');
insert into FILMGENRE(FILM_ID, GENRE_ID) values(4,'Fantasy');
insert into FILMGENRE(FILM_ID, GENRE_ID) values(4,'Animation');
insert into FILMGENRE(FILM_ID, GENRE_ID) values(5,'Adventure');
insert into FILMGENRE(FILM_ID, GENRE_ID) values(5,'Comedy');
insert into FILMGENRE(FILM_ID, GENRE_ID) values(5,'Fantasy');
insert into FILMGENRE(FILM_ID, GENRE_ID) values(5,'Animation');
insert into FILMGENRE(FILM_ID, GENRE_ID) values(6,'Action');
insert into FILMGENRE(FILM_ID, GENRE_ID) values(6,'Comedy');
insert into FILMGENRE(FILM_ID, GENRE_ID) values(6,'Fantasy');
insert into FILMGENRE(FILM_ID, GENRE_ID) values(6,'Animation');
insert into FILMGENRE(FILM_ID, GENRE_ID) values(7,'Action');
insert into FILMGENRE(FILM_ID, GENRE_ID) values(7,'Comedy');
insert into FILMGENRE(FILM_ID, GENRE_ID) values(7,'Fantasy');
insert into FILMGENRE(FILM_ID, GENRE_ID) values(7,'Animation');
insert into FILMGENRE(FILM_ID, GENRE_ID) values(8,'Action');
insert into FILMGENRE(FILM_ID, GENRE_ID) values(8,'Comedy');
insert into FILMGENRE(FILM_ID, GENRE_ID) values(8,'Fantasy');
insert into FILMGENRE(FILM_ID, GENRE_ID) values(8,'Animation');
insert into FILMGENRE(FILM_ID, GENRE_ID) values(9,'Comedy');
insert into FILMGENRE(FILM_ID, GENRE_ID) values(9,'Action');
insert into FILMGENRE(FILM_ID, GENRE_ID) values(9,'SliceOfLife');
insert into FILMGENRE(FILM_ID, GENRE_ID) values(10,'Crime');
insert into FILMGENRE(FILM_ID, GENRE_ID) values(10,'Psychological');


insert into CASTED_PERSON(ID, ROLE, FILM_ID, PERSON_ID) values (1,'Actor',1,1);
insert into CASTED_PERSON(ID, ROLE, FILM_ID, PERSON_ID) values (2,'BoomOperator',1,2);
insert into CASTED_PERSON(ID, ROLE, FILM_ID, PERSON_ID) values (3,'CameraOperator',1,3);
insert into CASTED_PERSON(ID, ROLE, FILM_ID, PERSON_ID) values (4,'Actor',1,4);
insert into CASTED_PERSON(ID, ROLE, FILM_ID, PERSON_ID) values (5,'Director',1,1);
insert into CASTED_PERSON(ID, ROLE, FILM_ID, PERSON_ID) values (6,'Producer',1,1);
insert into CASTED_PERSON(ID, ROLE, FILM_ID, PERSON_ID) values (7,'Producer',1,3);
insert into CASTED_PERSON(ID, ROLE, FILM_ID, PERSON_ID) values (8,'CostumeDesigner',1,5);
insert into CASTED_PERSON(ID, ROLE, FILM_ID, PERSON_ID) values (9,'Actor',2,1);
insert into CASTED_PERSON(ID, ROLE, FILM_ID, PERSON_ID) values (10,'BoomOperator',2,2);
insert into CASTED_PERSON(ID, ROLE, FILM_ID, PERSON_ID) values (11,'CameraOperator',2,3);
insert into CASTED_PERSON(ID, ROLE, FILM_ID, PERSON_ID) values (12,'Actor',2,4);
insert into CASTED_PERSON(ID, ROLE, FILM_ID, PERSON_ID) values (13,'Director',2,1);
insert into CASTED_PERSON(ID, ROLE, FILM_ID, PERSON_ID) values (14,'CostumeDesigner',2,5);
insert into CASTED_PERSON(ID, ROLE, FILM_ID, PERSON_ID) values (15,'Actor',3,10);
insert into CASTED_PERSON(ID, ROLE, FILM_ID, PERSON_ID) values (16,'Producer',3,7);
insert into CASTED_PERSON(ID, ROLE, FILM_ID, PERSON_ID) values (17,'Producer',3,8);
insert into CASTED_PERSON(ID, ROLE, FILM_ID, PERSON_ID) values (18,'Actor',4,10);
insert into CASTED_PERSON(ID, ROLE, FILM_ID, PERSON_ID) values (19,'Producer',4,7);
insert into CASTED_PERSON(ID, ROLE, FILM_ID, PERSON_ID) values (20,'Actor',5,10);
insert into CASTED_PERSON(ID, ROLE, FILM_ID, PERSON_ID) values (21,'Producer',5,7);
insert into CASTED_PERSON(ID, ROLE, FILM_ID, PERSON_ID) values (22,'Producer',5,8);
insert into CASTED_PERSON(ID, ROLE, FILM_ID, PERSON_ID) values (23,'Actor',6,11);
insert into CASTED_PERSON(ID, ROLE, FILM_ID, PERSON_ID) values (24,'Producer',6,7);
insert into CASTED_PERSON(ID, ROLE, FILM_ID, PERSON_ID) values (25,'Director',6,8);
insert into CASTED_PERSON(ID, ROLE, FILM_ID, PERSON_ID) values (26,'Actor',7,11);
insert into CASTED_PERSON(ID, ROLE, FILM_ID, PERSON_ID) values (27,'Producer',7,7);
insert into CASTED_PERSON(ID, ROLE, FILM_ID, PERSON_ID) values (28,'Director',7,8);
insert into CASTED_PERSON(ID, ROLE, FILM_ID, PERSON_ID) values (29,'Actor',8,11);
insert into CASTED_PERSON(ID, ROLE, FILM_ID, PERSON_ID) values (30,'Producer',8,7);
insert into CASTED_PERSON(ID, ROLE, FILM_ID, PERSON_ID) values (31,'Actor',9,9);
insert into CASTED_PERSON(ID, ROLE, FILM_ID, PERSON_ID) values (32,'BoomOperator',9,2);
insert into CASTED_PERSON(ID, ROLE, FILM_ID, PERSON_ID) values (33,'CameraOperator',9,3);
insert into CASTED_PERSON(ID, ROLE, FILM_ID, PERSON_ID) values (34,'Actor',9,4);
insert into CASTED_PERSON(ID, ROLE, FILM_ID, PERSON_ID) values (35,'Director',9,9);
insert into CASTED_PERSON(ID, ROLE, FILM_ID, PERSON_ID) values (36,'PhotographyDirector',9,6);
insert into CASTED_PERSON(ID, ROLE, FILM_ID, PERSON_ID) values (37,'Producer',9,4);
insert into CASTED_PERSON(ID, ROLE, FILM_ID, PERSON_ID) values (38,'Writer',9,5);
insert into CASTED_PERSON(ID, ROLE, FILM_ID, PERSON_ID) values (39,'Actor',10,3);
insert into CASTED_PERSON(ID, ROLE, FILM_ID, PERSON_ID) values (40,'BoomOperator',10,6);
insert into CASTED_PERSON(ID, ROLE, FILM_ID, PERSON_ID) values (41,'FilmEditor',10,3);
insert into CASTED_PERSON(ID, ROLE, FILM_ID, PERSON_ID) values (42,'Actor',10,8);
insert into CASTED_PERSON(ID, ROLE, FILM_ID, PERSON_ID) values (43,'Director',10,2);
insert into CASTED_PERSON(ID, ROLE, FILM_ID, PERSON_ID) values (44,'PhotographyDirector',10,1);
insert into CASTED_PERSON(ID, ROLE, FILM_ID, PERSON_ID) values (45,'AssistantDirector',10,7);
insert into CASTED_PERSON(ID, ROLE, FILM_ID, PERSON_ID) values (46,'Writer',10,5);


