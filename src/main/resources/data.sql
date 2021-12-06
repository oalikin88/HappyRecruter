INSERT INTO public.methodology (id, methodologyname) VALUES (1, 'Agile');
INSERT INTO public.methodology (id, methodologyname) VALUES (2, 'Watefoll');

INSERT INTO public.overtime (id, overtimename) VALUES (3, 'Иногда');
INSERT INTO public.overtime (id, overtimename) VALUES (4, 'Постоянно');
INSERT INTO public.overtime (id, overtimename) VALUES (5, 'Нет');

INSERT INTO public.projectstatus (id, name) VALUES (23, 'Черновик');
INSERT INTO public.projectstatus (id, name) VALUES (24, 'В работе');
INSERT INTO public.projectstatus (id, name) VALUES (25, 'В архиве');

INSERT INTO public.stafflist (id, staffname) VALUES (26, 'Аналитики');
INSERT INTO public.stafflist (id, staffname) VALUES (27, 'Front');
INSERT INTO public.stafflist (id, staffname) VALUES (28, 'Back');
INSERT INTO public.stafflist (id, staffname) VALUES (29, 'Fullstack');
INSERT INTO public.stafflist (id, staffname) VALUES (30, 'Тестировщики');
INSERT INTO public.stafflist (id, staffname) VALUES (31, 'Техписы');


INSERT INTO public.stage (id, stagename) VALUES (6, 'Инициация');
INSERT INTO public.stage (id, stagename) VALUES (7, 'Начало');
INSERT INTO public.stage (id, stagename) VALUES (8, 'Середина');
INSERT INTO public.stage (id, stagename) VALUES (9, 'Завершающая');

INSERT INTO public.subjectarea (id, name) VALUES (10, 'Медицина');
INSERT INTO public.subjectarea (id, name) VALUES (11, 'Образование');
INSERT INTO public.subjectarea (id, name) VALUES (12, 'Строительство');
INSERT INTO public.subjectarea (id, name) VALUES (13, 'Торговля');
INSERT INTO public.subjectarea (id, name) VALUES (14, 'Экономика');
INSERT INTO public.subjectarea (id, name) VALUES (15, 'Управление');
INSERT INTO public.subjectarea (id, name) VALUES (16, 'ЖКХ');
INSERT INTO public.subjectarea (id, name) VALUES (17, 'Банковская сфера');
INSERT INTO public.subjectarea (id, name) VALUES (18, 'Нефтяная отрасль');


INSERT INTO public.type1 (id, type) VALUES (19, 'Фикс');
INSERT INTO public.type1 (id, type) VALUES (32, 'T&M');


INSERT INTO public.type2 (id, type) VALUES (20, 'ПО');
INSERT INTO public.type2 (id, type) VALUES (33, 'ПАК');

INSERT INTO public.type3 (id, type) VALUES (21, 'MVP');
INSERT INTO public.type3 (id, type) VALUES (34, 'Полный функционал');

INSERT INTO public.type4 (id, type) VALUES (22, 'Новая система');
INSERT INTO public.type4 (id, type) VALUES (35, 'Модернизация системы');