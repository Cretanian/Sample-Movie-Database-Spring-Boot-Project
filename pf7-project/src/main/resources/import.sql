insert into PEOPLE(ID, YOB, COUNTRY, FIRSTNAME, ISALIVE, LASTNAME) values (1,1960,'Italy','Damiano',FALSE,'Moretti');
insert into PEOPLE(ID, YOB, COUNTRY, FIRSTNAME, ISALIVE, LASTNAME) values (2,1987,'Argentina','Lionel',TRUE,'Messi');
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


-- insert into TVSHOWS_EPISODES(TVSHOW_ID, EPISODES_ID) values (3 ,4 );
-- insert into TVSHOWS_EPISODES(TVSHOW_ID, EPISODES_ID) values (3 ,5 );
-- insert into TVSHOWS_EPISODES(TVSHOW_ID, EPISODES_ID) values (6 ,8 );
-- insert into TVSHOWS_EPISODES(TVSHOW_ID, EPISODES_ID) values (6 ,7 );


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


insert into CASTED_PERSON(ID, FILM_ID, PERSON_ID) values (1,1,1);
insert into CASTED_PERSON(ID, FILM_ID, PERSON_ID) values (2,1,2);
insert into CASTED_PERSON(ID, FILM_ID, PERSON_ID) values (3,1,3);
insert into CASTED_PERSON(ID, FILM_ID, PERSON_ID) values (4,1,4);
insert into CASTED_PERSON(ID, FILM_ID, PERSON_ID) values (5,1,5);
insert into CASTED_PERSON(ID, FILM_ID, PERSON_ID) values (6,2,1);
insert into CASTED_PERSON(ID, FILM_ID, PERSON_ID) values (7,2,2);
insert into CASTED_PERSON(ID, FILM_ID, PERSON_ID) values (8,2,3);
insert into CASTED_PERSON(ID, FILM_ID, PERSON_ID) values (9,2,4);
insert into CASTED_PERSON(ID, FILM_ID, PERSON_ID) values (10,2,5);
insert into CASTED_PERSON(ID, FILM_ID, PERSON_ID) values (11,3,10);
insert into CASTED_PERSON(ID, FILM_ID, PERSON_ID) values (12,3,7);
insert into CASTED_PERSON(ID, FILM_ID, PERSON_ID) values (13,3,8);
insert into CASTED_PERSON(ID, FILM_ID, PERSON_ID) values (14,4,10);
insert into CASTED_PERSON(ID, FILM_ID, PERSON_ID) values (15,4,7);
insert into CASTED_PERSON(ID, FILM_ID, PERSON_ID) values (16,5,10);
insert into CASTED_PERSON(ID, FILM_ID, PERSON_ID) values (17,5,7);
insert into CASTED_PERSON(ID, FILM_ID, PERSON_ID) values (18,5,8);
insert into CASTED_PERSON(ID, FILM_ID, PERSON_ID) values (19,6,11);
insert into CASTED_PERSON(ID, FILM_ID, PERSON_ID) values (20,6,7);
insert into CASTED_PERSON(ID, FILM_ID, PERSON_ID) values (21,6,8);
insert into CASTED_PERSON(ID, FILM_ID, PERSON_ID) values (22,7,11);
insert into CASTED_PERSON(ID, FILM_ID, PERSON_ID) values (23,7,7);
insert into CASTED_PERSON(ID, FILM_ID, PERSON_ID) values (24,7,8);
insert into CASTED_PERSON(ID, FILM_ID, PERSON_ID) values (25,8,11);
insert into CASTED_PERSON(ID, FILM_ID, PERSON_ID) values (26,8,7);
insert into CASTED_PERSON(ID, FILM_ID, PERSON_ID) values (27,9,9);
insert into CASTED_PERSON(ID, FILM_ID, PERSON_ID) values (28,9,2);
insert into CASTED_PERSON(ID, FILM_ID, PERSON_ID) values (29,9,3);
insert into CASTED_PERSON(ID, FILM_ID, PERSON_ID) values (30,9,4);
insert into CASTED_PERSON(ID, FILM_ID, PERSON_ID) values (31,9,6);
insert into CASTED_PERSON(ID, FILM_ID, PERSON_ID) values (32,9,5);
insert into CASTED_PERSON(ID, FILM_ID, PERSON_ID) values (33,10,3);
insert into CASTED_PERSON(ID, FILM_ID, PERSON_ID) values (34,10,6);
insert into CASTED_PERSON(ID, FILM_ID, PERSON_ID) values (35,10,8);
insert into CASTED_PERSON(ID, FILM_ID, PERSON_ID) values (36,10,2);
insert into CASTED_PERSON(ID, FILM_ID, PERSON_ID) values (37,10,1);
insert into CASTED_PERSON(ID, FILM_ID, PERSON_ID) values (38,10,7);
insert into CASTED_PERSON(ID, FILM_ID, PERSON_ID) values (39,10,5);


insert into PERSON_ROLE(CASTED_PERSON_ID,ROLE_ID) values (1,'Actor');
insert into PERSON_ROLE(CASTED_PERSON_ID,ROLE_ID) values (1,'Director');
insert into PERSON_ROLE(CASTED_PERSON_ID,ROLE_ID) values (1,'Producer');
insert into PERSON_ROLE(CASTED_PERSON_ID,ROLE_ID) values (2,'BoomOperator');
insert into PERSON_ROLE(CASTED_PERSON_ID,ROLE_ID) values (3,'CameraOperator');
insert into PERSON_ROLE(CASTED_PERSON_ID,ROLE_ID) values (3,'Producer');
insert into PERSON_ROLE(CASTED_PERSON_ID,ROLE_ID) values (4,'Actor');
insert into PERSON_ROLE(CASTED_PERSON_ID,ROLE_ID) values (5,'CostumeDesigner');
insert into PERSON_ROLE(CASTED_PERSON_ID,ROLE_ID) values (6,'Actor');
insert into PERSON_ROLE(CASTED_PERSON_ID,ROLE_ID) values (6,'Director');
insert into PERSON_ROLE(CASTED_PERSON_ID,ROLE_ID) values (7,'BoomOperator');
insert into PERSON_ROLE(CASTED_PERSON_ID,ROLE_ID) values (8,'CameraOperator');
insert into PERSON_ROLE(CASTED_PERSON_ID,ROLE_ID) values (9,'Actor');
insert into PERSON_ROLE(CASTED_PERSON_ID,ROLE_ID) values (10,'CostumeDesigner');
insert into PERSON_ROLE(CASTED_PERSON_ID,ROLE_ID) values (11,'Actor');
insert into PERSON_ROLE(CASTED_PERSON_ID,ROLE_ID) values (12,'Producer');
insert into PERSON_ROLE(CASTED_PERSON_ID,ROLE_ID) values (13,'Producer');
insert into PERSON_ROLE(CASTED_PERSON_ID,ROLE_ID) values (14,'Actor');
insert into PERSON_ROLE(CASTED_PERSON_ID,ROLE_ID) values (15,'Producer');
insert into PERSON_ROLE(CASTED_PERSON_ID,ROLE_ID) values (16,'Actor');
insert into PERSON_ROLE(CASTED_PERSON_ID,ROLE_ID) values (17,'Producer');
insert into PERSON_ROLE(CASTED_PERSON_ID,ROLE_ID) values (18,'Producer');
insert into PERSON_ROLE(CASTED_PERSON_ID,ROLE_ID) values (19,'Actor');
insert into PERSON_ROLE(CASTED_PERSON_ID,ROLE_ID) values (20,'Producer');
insert into PERSON_ROLE(CASTED_PERSON_ID,ROLE_ID) values (21,'Director');
insert into PERSON_ROLE(CASTED_PERSON_ID,ROLE_ID) values (22,'Actor');
insert into PERSON_ROLE(CASTED_PERSON_ID,ROLE_ID) values (23,'Producer');
insert into PERSON_ROLE(CASTED_PERSON_ID,ROLE_ID) values (24,'Director');
insert into PERSON_ROLE(CASTED_PERSON_ID,ROLE_ID) values (25,'Actor');
insert into PERSON_ROLE(CASTED_PERSON_ID,ROLE_ID) values (26,'Producer');
insert into PERSON_ROLE(CASTED_PERSON_ID,ROLE_ID) values (27,'Actor');
insert into PERSON_ROLE(CASTED_PERSON_ID,ROLE_ID) values (27,'Director');
insert into PERSON_ROLE(CASTED_PERSON_ID,ROLE_ID) values (28,'BoomOperator');
insert into PERSON_ROLE(CASTED_PERSON_ID,ROLE_ID) values (29,'CameraOperator');
insert into PERSON_ROLE(CASTED_PERSON_ID,ROLE_ID) values (30,'Actor');
insert into PERSON_ROLE(CASTED_PERSON_ID,ROLE_ID) values (30,'Producer');
insert into PERSON_ROLE(CASTED_PERSON_ID,ROLE_ID) values (31,'PhotographyDirector');
insert into PERSON_ROLE(CASTED_PERSON_ID,ROLE_ID) values (32,'Writer');
insert into PERSON_ROLE(CASTED_PERSON_ID,ROLE_ID) values (33,'Actor');
insert into PERSON_ROLE(CASTED_PERSON_ID,ROLE_ID) values (33,'FilmEditor');
insert into PERSON_ROLE(CASTED_PERSON_ID,ROLE_ID) values (34,'BoomOperator');
insert into PERSON_ROLE(CASTED_PERSON_ID,ROLE_ID) values (35,'Actor');
insert into PERSON_ROLE(CASTED_PERSON_ID,ROLE_ID) values (36,'Director');
insert into PERSON_ROLE(CASTED_PERSON_ID,ROLE_ID) values (37,'PhotographyDirector');
insert into PERSON_ROLE(CASTED_PERSON_ID,ROLE_ID) values (38,'AssistantDirector');
insert into PERSON_ROLE(CASTED_PERSON_ID,ROLE_ID) values (39,'Writer');


