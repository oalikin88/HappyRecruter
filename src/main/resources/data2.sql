INSERT INTO public.methodology (id, methodologyname) VALUES (nextval('id'), 'Agile');
INSERT INTO public.methodology (id, methodologyname) VALUES (DEFAULT, 'Watefoll');


INSERT INTO public.overtime (id, overtimename) VALUES (DEFAULT, 'Иногда');
INSERT INTO public.overtime (id, overtimename) VALUES (DEFAULT, 'Постоянно');
INSERT INTO public.overtime (id, overtimename) VALUES (DEFAULT, 'Нет');

INSERT INTO public.projectstatus (id, name) VALUES (DEFAULT, 'Черновик');
INSERT INTO public.projectstatus (id, name) VALUES (DEFAULT, 'В работе');
INSERT INTO public.projectstatus (id, name) VALUES (DEFAULT, 'В архиве');

INSERT INTO public.stafflist (id, staffname) VALUES (DEFAULT, 'Аналитики');
INSERT INTO public.stafflist (id, staffname) VALUES (DEFAULT, 'Front');
INSERT INTO public.stafflist (id, staffname) VALUES (DEFAULT, 'Back');
INSERT INTO public.stafflist (id, staffname) VALUES (DEFAULT, 'Fullstack');
INSERT INTO public.stafflist (id, staffname) VALUES (DEFAULT, 'Тестировщики');
INSERT INTO public.stafflist (id, staffname) VALUES (DEFAULT, 'Техписы');

