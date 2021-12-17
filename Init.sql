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
(41, 'GUEST');



INSERT INTO public.memberteam (id, counthired, countneeds, datestartproject, id_staff)
values
(42, 1.6, 2.2, '2020-10-15', 22),
(43, 1.6, 2.2, '2020-11-12', 23),
(44, 1.6, 2.2, '2020-12-19', 24),
(45, 1.6, 2.2, '2021-01-04', 25),
(46, 1.6, 2.2, '2021-02-10', 26),
(47, 1.6, 2.2, '2021-03-02', 27),

(48, 1.6, 2.2, '2021-01-01', 22),
(49, 1.6, 2.2, '2021-02-01', 23),
(50, 1.6, 2.2, '2021-03-02', 24),
(51, 1.6, 2.2, '2021-05-04', 25),
(52, 1.6, 2.2, '2021-05-10', 26),
(53, 1.6, 2.2, '2021-06-02', 27),

(54, 1.6, 2.2, '2021-08-01', 22),
(55, 1.6, 2.2, '2021-08-12', 23),
(56, 1.6, 2.2, '2021-09-15', 24),
(57, 1.6, 2.2, '2021-10-04', 25),
(58, 1.6, 2.2, '2021-11-10', 26),
(59, 1.6, 2.2, '2021-12-02', 27),

(60, 1.6, 2.2, '2021-12-10', 22),
(61, 1.6, 2.2, '2021-12-25', 23),
(62, 1.6, 2.2, '2022-01-01', 24),
(63, 1.6, 2.2, '2022-02-04', 25),
(64, 1.6, 2.2, '2022-01-10', 26),
(65, 1.6, 2.2, '2022-03-02', 27),

(66, 1.6, 2.2, '2021-11-10', 22),
(67, 1.6, 2.2, '2021-12-12', 23),
(68, 1.6, 2.2, '2021-12-19', 24),
(69, 1.6, 2.2, '2022-01-04', 25),
(70, 1.6, 2.2, '2022-02-10', 26),
(71, 1.6, 2.2, '2022-03-02', 27),

(72, 1.6, 2.2, '2021-08-08', 22),
(73, 1.6, 2.2, '2021-10-10', 23),
(74, 1.6, 2.2, '2021-12-19', 24),
(75, 1.6, 2.2, '2022-03-09', 25),
(76, 1.6, 2.2, '2022-05-11', 26),
(77, 1.6, 2.2, '2022-03-25', 27),

(78, 1.6, 2.2, '2021-12-31', 22),
(79, 1.6, 2.2, '2022-02-12', 23),
(80, 1.6, 2.2, '2022-04-10', 24),
(81, 1.6, 2.2, '2022-04-28', 25),
(82, 1.6, 2.2, '2022-05-10', 26),
(83, 1.6, 2.2, '2022-06-02', 27),

(84, 1.6, 2.2, '2022-01-10', 22),
(85, 1.6, 2.2, '2022-05-22', 23),
(86, 1.6, 2.2, '2022-05-19', 24),
(87, 1.6, 2.2, '2022-06-04', 25),
(88, 1.6, 2.2, '2022-07-10', 26),
(89, 1.6, 2.2, '2022-10-02', 27),

(90, 1.6, 2.2, '2018-12-10', 22),
(91, 1.6, 2.2, '2019-01-19', 23),
(92, 1.6, 2.2, '2019-02-22', 24),
(93, 1.6, 2.2, '2019-03-14', 25),
(94, 1.6, 2.2, '2019-04-25', 26),
(95, 1.6, 2.2, '2019-05-12', 27),

(96, 1.6, 2.2, '2019-05-01', 22),
(97, 1.6, 2.2, '2019-06-18', 23),
(98, 1.6, 2.2, '2019-10-25', 24),
(99, 1.6, 2.2, '2019-12-04', 25),
(100, 1.6, 2.2, '2020-02-10', 26),
(101, 1.6, 2.2, '2020-03-08', 27);


INSERT INTO public.project (id,companyname,datecloseproject,
datetimecreate,description,functionalarea,hasanotherspecialists,
hasdesigners,isarchived,isdelegated,isdocumentated,isdraft,isinworked,
isproductproject,isworkhome,location,procedureenteringstaff,
projectname,projecttasks,stakeholders,technologies,id_methodology,
id_overtime,id_stage,id_type1,id_type2,id_type3,id_type4,memberteam1_id,memberteam2_id,
memberteam3_id,memberteam4_id,memberteam5_id,memberteam6_id,projectstatus_id,
subjectarea_id,creator_id) VALUES
	 (102,'Здоровье','2021-05-07','2020-10-01 06:43:49.024345','Разработка сайта компании','Функциональное описание',
	 'возможно',true,false,true,true,false,false,true,true,'Тюмень','Процедура вывода людей','Таблеточка','Задачи',1,'Много технологий',
	 1,3,9,28,30,33,34,42,43,44,45,46,47,21,13,36),
	 
	 (103,'Альянс','2021-12-31','2021-01-01 06:43:46.768588','Разработка приложения для перевозок такси','Функциональное описание',
	 'возможно',true,false,true,true,false,false,true,true,'Саранск','Процедура вывода людей','Такси - Альянс','Задачи',1,'Много технологий',
	 1,3,9,28,30,33,34,48,49,50,51,52,53,20,15,36),
	 
	 (104,'Народный банк','2021-12-31','2021-07-20 06:43:48.212664','Разработка сайта компании','Функциональное описание',
	 'возможно',true,false,true,true,false,false,true,true,'Иваново','Процедура вывода людей','Банкомат','Задачи',5,'Много технологий',
	 1,3,9,28,30,33,34,54,55,56,57,58,59,20,17,37),
	 
	 (105,'Газпром','2022-05-01','2021-12-01 06:43:17.444018','Разработка сайта компании','Функциональное описание',
	 'возможно',true,false,true,true,false,false,true,true,'Москва','Процедура вывода людей','Нефтянник','Задачи',7,'Много технологий',
	 1,3,8,28,30,33,34,60,61,62,63,64,65,20,18,37),
	 
	 (106,'Промстрой','2022-04-17','2021-11-01 06:43:47.542078','Разработка приложения для нужд компании','Функциональное описание',
	'возможно',true,false,true,true,false,false,true,true,'Сыктывкар','Процедура вывода людей','Стройка','Задачи',2,'Много технологий',
	 1,3,8,28,30,33,34,66,67,68,69,70,71,19,12,38),
	 
	 
	 (107,'Газпром газораспределение','2021-05-07','2020-10-01 06:43:49.024345','Разработка приложения для расчетов','Функциональное описание',
	 'возможно',true,false,true,true,false,false,true,true,'Санкт-Петербург','Процедура вывода людей','ГазСчет','Задачи',10,'Много технологий',
	 1,3,9,28,30,33,34,72,73,74,75,76,77,21,16,36),
	 
	 (108,'Газпромбанк','2021-12-31','2021-01-01 06:43:46.768588','Разработка сайта компании','Функциональное описание',
	 'возможно',true,false,true,true,false,false,true,true,'Москва','Процедура вывода людей','Газпромбанк','Задачи',15,'Много технологий',
	 1,3,9,28,30,33,34,78,79,80,81,82,83,20,17,36),
	 
	 (109,'Газпром межрегионгаз','2021-12-31','2021-07-20 06:43:48.212664','Разработка приложения для внутренного использования','Функциональное описание',
	 'возможно',true,false,true,true,false,false,true,true,'Владимир','Процедура вывода людей','ГостМежГаз','Задачи',9,'Много технологий',
	 1,3,9,28,30,33,34,84,85,86,87,88,89,20,16,37),
	 
	 (110,'Лапуши','2022-05-01','2021-12-01 06:43:17.444018','Разработка сайта компании','Функциональное описание',
	 'возможно',true,false,true,true,false,false,true,true,'Киров','Процедура вывода людей','IЛюбимец','Задачи',1,'Много технологий',
	 1,3,6,28,30,33,34,90,91,92,93,94,95,20,12,37),
	 
	 (111,'Стройинвестконсалт','2022-04-17','2021-11-01 06:43:47.542078','Разработка сайта компании','Функциональное описание',
	'возможно',true,false,true,true,false,false,true,true,'Москва','Процедура вывода людей','Стройка','Задачи',3,'Много технологий',
	 1,3,7,28,30,33,34,96,97,98,99,100,101,20,12,38);



CREATE SEQUENCE public.hibernate_sequence INCREMENT 1 START 112 MINVALUE 112;

