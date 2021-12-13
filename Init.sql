CREATE TABLE public.users (
		id INT8 NOT NULL PRIMARY KEY,
		fio VARCHAR(255),
		username VARCHAR(255),
		password VARCHAR(255)
	);
CREATE TABLE public.stage (
		id INT8 NOT NULL PRIMARY KEY,
		stagename VARCHAR(255)
	);
	

CREATE TABLE public.projectstatus (
		id INT8 NOT NULL PRIMARY KEY,
		statusvalue VARCHAR(255)
	);
	

CREATE TABLE public.type3 (
		id INT8 NOT NULL PRIMARY KEY,
		type_value VARCHAR(255)
	);
	


	

CREATE TABLE public.subjectarea (
		id INT8 NOT NULL PRIMARY KEY,
		name VARCHAR(255)
	);
	

CREATE TABLE public.memberteam (
		id INT8 NOT NULL PRIMARY KEY,
		counthired FLOAT4 NOT NULL,
		countneeds FLOAT4 NOT NULL,
		datestartproject DATE,
		id_staff INT8
	);
	

CREATE TABLE public.overtime (
		id INT8 NOT NULL PRIMARY KEY,
		overtimename VARCHAR(255)
	);
	

CREATE TABLE public.type1 (
		id INT8 NOT NULL PRIMARY KEY,
		type_value VARCHAR(255)
	);
	

CREATE TABLE public.methodology (
		id INT8 NOT NULL PRIMARY KEY,
		methodologyname VARCHAR(255)
	);
	

CREATE TABLE public.type2 (
		id INT8 NOT NULL PRIMARY KEY,
		type_value VARCHAR(255)
	);
	

CREATE TABLE public.roles (
		id INT8 NOT NULL PRIMARY KEY,
		name VARCHAR(255)
	);
	

CREATE TABLE public.type4 (
		id INT8 NOT NULL PRIMARY KEY,
		type_value VARCHAR(255)
	);
	

CREATE TABLE public.stafflist (
		id INT8 NOT NULL PRIMARY KEY,
		staffname VARCHAR(255)
	);

CREATE TABLE public.users_roles (
		user_id INT8 NOT NULL,
		role_id INT8 NOT NULL
	);
	CREATE TABLE public.project (
		id INT8 NOT NULL PRIMARY KEY,
		companyname VARCHAR(255),
		datecloseproject DATE,
		datetimecreate TIMESTAMP,
		description VARCHAR(255),
		functionalarea VARCHAR(255),
		hasanotherspecialists VARCHAR(255),
		hasdesigners BOOL NOT NULL,
		isarchived BOOL NOT NULL,
		isdelegated BOOL NOT NULL,
		isdocumentated BOOL NOT NULL,
		isdraft BOOL NOT NULL,
		isinworked BOOL NOT NULL,
		isproductproject BOOL NOT NULL,
		isworkhome BOOL NOT NULL,
		location VARCHAR(255),
		procedureenteringstaff VARCHAR(255),
		projectname VARCHAR(255),
		projecttasks VARCHAR(255),
		stakeholders INT4 NOT NULL,
		technologies VARCHAR(255),
		id_methodology INT8,
		id_overtime INT8,
		id_stage INT8,
		id_type1 INT8,
		id_type2 INT8,
		id_type3 INT8,
		id_type4 INT8,
		memberteam1_id INT8,
		memberteam2_id INT8,
		memberteam3_id INT8,
		memberteam4_id INT8,
		memberteam5_id INT8,
		memberteam6_id INT8,
		creator_id INT8,
		projectstatus_id INT8,
		subjectarea_id INT8
	);
	
ALTER TABLE public.project ADD FOREIGN KEY
(id_stage) REFERENCES public.stage;
ALTER TABLE public.project ADD FOREIGN KEY
(id_overtime) REFERENCES public.overtime;
ALTER TABLE public.project ADD FOREIGN KEY
(id_methodology) REFERENCES public.methodology;
ALTER TABLE public.project ADD FOREIGN KEY
(id_type1) REFERENCES public.type1;
ALTER TABLE public.project ADD FOREIGN KEY
(id_type2) REFERENCES public.type2;
ALTER TABLE public.project ADD FOREIGN KEY
(id_type3) REFERENCES public.type3;
ALTER TABLE public.project ADD FOREIGN KEY
(id_type4) REFERENCES public.type4;

ALTER TABLE public.project ADD FOREIGN KEY
(memberteam1_id) REFERENCES public.memberteam;
ALTER TABLE public.project ADD FOREIGN KEY
(memberteam2_id) REFERENCES public.memberteam;
ALTER TABLE public.project ADD FOREIGN KEY
(memberteam3_id) REFERENCES public.memberteam;
ALTER TABLE public.project ADD FOREIGN KEY
(memberteam4_id) REFERENCES public.memberteam;
ALTER TABLE public.project ADD FOREIGN KEY
(memberteam5_id) REFERENCES public.memberteam;
ALTER TABLE public.project ADD FOREIGN KEY
(memberteam6_id) REFERENCES public.memberteam;

ALTER TABLE public.project ADD FOREIGN KEY
(creator_id) REFERENCES public.users;
	
ALTER TABLE public.project ADD FOREIGN KEY
(projectstatus_id) REFERENCES public.projectstatus;

ALTER TABLE public.project ADD FOREIGN KEY
(subjectarea_id) REFERENCES public.subjectarea;


ALTER TABLE public.users_roles ADD FOREIGN KEY
(user_id) REFERENCES public.users;
ALTER TABLE public.users_roles ADD FOREIGN KEY
(role_id) REFERENCES public.roles;

ALTER TABLE public.memberteam ADD FOREIGN KEY
(id_staff) REFERENCES public.stafflist;



insert into methodology (id, methodologyname) values
(1, 'Agile'),
(2, 'Waterfall');

insert into overtime (id, overtimename) values
(3, 'Иногда'),
(4, 'Постоянно'),
(5, 'Нет');

insert into stage (id, stagename) values
(6, 'Стадия инициации'),
(7, 'Начало'),
(8, 'Середина'),
(9, 'Завершающая');

insert into subjectarea (id, name) values 
(10, 'Медицина'),
(11, 'Образование'),
(12, 'Строительство'),
(13, 'Торговля'),
(14, 'Экономика'),
(15, 'Управление'),
(16, 'ЖКХ'),
(17, 'Банковская сфера'),
(18, 'Нефтяная отрасль');

insert into projectstatus (id, statusvalue) values 
(19, 'Черновик'),
(20, 'В работе'),
(21, 'В архиве');

insert into stafflist (id, staffname) values
(22, 'Аналитики'),
(23, 'Front'),
(24, 'Back'),
(25, 'Fullstack'),
(26, 'Тестировщики'),
(27, 'Техписы');

insert into type1 (id, type_value) values 
(28, 'Fixed Price'),
(29, 'T&M');

insert into type2 (id, type_value) values
(30, 'ПО'),
(31, 'ПАК');

insert into type3 (id, type_value) values 
(32, 'MVP'),
(33, 'Полный функционал');

insert into type4 (id, type_value) values 
(34, 'Новая система'),
(35, 'Модернизация системы');

insert into users (id, fio, username, password) values
(36, 'Иванов Иван Иванович', 'ivanov@mail.ru', 'qwerty'),
(37, 'Петров Петр Петрович', 'petrov@mail.ru', '12345'),
(38, 'Кондратов Кондрат Кондратович', 'kondrat@mail.ru', 'poiuy');

insert into roles (id, name) values
(39, 'ADMIN'),
(40, 'MANAGER'),
(76, 'GUEST');

/*INSERT INTO public.memberteam (id, counthired, countneeds, datestartproject, id_staff)
values
(70, 1.6, 2.2, '2020-10-10', 22),
(49, 1.6, 2.2, '2020-10-10', 22),
(63, 1.6, 2.2, '2020-10-10', 22),
(42, 1.6, 2.2, '2020-10-10', 22),
(56, 1.6, 2.2, '2020-10-10', 22),
(75, 1.6, 2.2, '2020-10-10', 22);




INSERT INTO public.project (id,companyname,datecloseproject,
datetimecreate,description,functionalarea,hasanotherspecialists,
hasdesigners,isarchived,isdelegated,isdocumentated,isdraft,isinworked,
isproductproject,isworkhome,"location",procedureenteringstaff,
projectname,projecttasks,stakeholders,technologies,id_methodology,
id_overtime,id_stage,id_type1,id_type2,id_type3,id_type4,memberteam1_id,memberteam2_id,
memberteam3_id,memberteam4_id,memberteam5_id,memberteam6_id,creator_id,projectstatus_id,
subjectarea_id) VALUES
	 (69,'Здоровье','2021-12-07','2000-07-12 06:43:49.024345',
	 'Разработка сайта компании','Функциональное описание',true,true,false,true,true,false,false,true,true,
	 'Москва','Процедура вывода людей','Таблеточка','Задачи',10,'Много технологий',1,3,7,28,30,33,34,70,71,72,73,74,75,NULL,20,17),
	 
	 (48,'Альянс','2021-12-07','2020-10-10 06:43:46.768588','Разработка сайта компании','Функциональное описание',
	 true,true,false,true,true,false,false,true,true,'Москва','Процедура вывода людей','Альянс','Задачи',10,'Много технологий',
	 1,3,7,28,30,33,34,49,50,51,52,53,54,NULL,19,17),
	 (62,'Народный банк','2021-12-07','2015-02-12 06:43:48.212664','Разработка сайта компании','Функциональное описание',
	 true,true,false,true,true,false,false,true,true,'Москва','Процедура вывода людей','Банкомат','Задачи',10,'Много технологий',
	 1,3,7,28,30,33,34,63,64,65,66,67,68,NULL,21,17),
	 
	 (41,'Газпром','2021-12-07','2021-10-08 06:43:17.444018','Разработка сайта компании','Функциональное описание',
	 true,true,false,true,true,false,false,true,true,'Москва','Процедура вывода людей','Нефтянник','Задачи',10,'Много технологий',
	 1,3,7,28,30,33,34,42,43,44,45,46,47,NULL,20,17),
	 (55,'Промстрой','2021-12-07','2021-08-08 06:43:47.542078','Разработка сайта компании','Функциональное описание',
	true,true,false,true,true,false,false,true,true,'Москва','Процедура вывода людей','Стройка','Задачи',10,'Много технологий',
	 1,3,7,28,30,33,34,56,57,58,59,60,61,NULL,20,17);*/



CREATE SEQUENCE public.hibernate_sequence INCREMENT 1 START 76 MINVALUE 41;

