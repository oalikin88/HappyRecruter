CREATE TABLE public.stage (
		id INT8 NOT NULL,
		stagename VARCHAR(255)
	);

CREATE TABLE public.projectstatus (
		id INT8 NOT NULL,
		name VARCHAR(255)
	);

CREATE TABLE public.type3 (
		id INT8 NOT NULL,
		type_value VARCHAR(255)
	);

CREATE TABLE public.persons (
		id INT8 NOT NULL,
		fio VARCHAR(255),
		login VARCHAR(255),
		password VARCHAR(255)
	);

CREATE TABLE public.persons_roles (
		person_id INT8 NOT NULL,
		role_id INT8 NOT NULL
	);

CREATE TABLE public.project (
		id INT8 NOT NULL,
		companyname VARCHAR(255),
		datecloseproject DATE,
		datetimecreate TIMESTAMP,
		description VARCHAR(255),
		functionalarea VARCHAR(255),
		hasanotherspecialists BOOL NOT NULL,
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

CREATE TABLE public.subjectarea (
		id INT8 NOT NULL,
		name VARCHAR(255)
	);

CREATE TABLE public.memberteam (
		id INT8 NOT NULL,
		counthired FLOAT4 NOT NULL,
		countneeds FLOAT4 NOT NULL,
		datestartproject DATE,
		id_staff INT8
	);

CREATE TABLE public.overtime (
		id INT8 NOT NULL,
		overtimename VARCHAR(255)
	);

CREATE TABLE public.type1 (
		id INT8 NOT NULL,
		type_value VARCHAR(255)
	);

CREATE TABLE public.methodology (
		id INT8 NOT NULL,
		methodologyname VARCHAR(255)
	);

CREATE TABLE public.type2 (
		id INT8 NOT NULL,
		type_value VARCHAR(255)
	);

CREATE TABLE public.roles (
		id INT8 NOT NULL,
		name VARCHAR(255)
	);

CREATE TABLE public.type4 (
		id INT8 NOT NULL,
		type_value VARCHAR(255)
	);

CREATE TABLE public.stafflist (
		id INT8 NOT NULL,
		staffname VARCHAR(255)
	);
	
	
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

insert into projectstatus (id, name) values 
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

insert into persons (id, fio, login, password) values
(36, 'Иванов Иван Иванович', 'ivanov@mail.ru', 'qwerty'),
(37, 'Петров Петр Петрович', 'petrov@mail.ru', '12345'),
(38, 'Кондратов Кондрат Кондратович', 'kondrat@mail.ru', 'poiuy');

insert into roles (id, name) values
(39, 'manager'),
(40, 'hr');

CREATE SEQUENCE public.hibernate_sequence INCREMENT 1 START 41 MINVALUE 41;

