INSERT INTO public.address(
	address_id, city, country, latitude, longitude, street, street_number)
	VALUES (default, 'Novi Sad', 'Srbija', 48, 44, 'Danila Kisa', 30);

INSERT INTO public.address(
	address_id, city, country, latitude, longitude, street, street_number)
	VALUES (default, 'Novi Sad', 'Srbija', 48, 44, 'Branka Bajića', 20);	
	
INSERT INTO public.address(
	address_id, city, country, latitude, longitude, street, street_number)
	VALUES (default, 'Novi Sad', 'Srbija', 48, 44, 'Bulevar kralja Petra I', 25);	

INSERT INTO public.address(
	address_id, city, country, latitude, longitude, street, street_number)
	VALUES (default, 'Novi Sad','Srbija', 48, 44, 'Alekse Santica', 46);
	
INSERT INTO public.address(address_id, city, country, latitude, longitude, street, street_number)
	VALUES (default, 'Novi Sad','Srbija', 48, 44, 'Alekse Santica', 11);
	
INSERT INTO public.address(
	address_id, city, country, latitude, longitude, street, street_number)
	VALUES (default, 'Novi Sad','Srbija', 48, 44, 'Kisacka', 3);

INSERT INTO public.address(
	address_id, city, country, latitude, longitude, street, street_number)
	VALUES (default, 'Novi Sad','Srbija', 48, 44, 'Maksima Gorkog', 11);

INSERT INTO public.address(
	address_id, city, country, latitude, longitude, street, street_number)
	VALUES (default, 'Novi Sad','Srbija', 48, 44, 'Sremska', 98);

INSERT INTO public.address(
	address_id, city, country, latitude, longitude, street, street_number)
	VALUES (default, 'Novi Sad','Srbija', 48, 44, 'Kosovska', 18);
	
INSERT INTO public.address(
	address_id, city, country, latitude, longitude, street, street_number)
	VALUES (default, 'Backi Jarak','Srbija', 48, 44, 'Veljka Vlahovica', 10);

INSERT INTO public.pharmacy(
	pharmacy_id, name, rating, description, adress_id)
	VALUES (default, 'BENU', 3.4, 'First Pharmacy', 7);

INSERT INTO public.pharmacy(
	pharmacy_id, name, rating, description, adress_id)
	VALUES (default, 'Jankovic', 4.6, 'Second Pharmacy', 8);
	
INSERT INTO public.medicine_specification(
	med_spec_id, dosage)
	VALUES (1, 4);
	INSERT INTO public.medicine_specification(
	med_spec_id, dosage)
	VALUES (2, 3);
	INSERT INTO public.medicine_specification(
	med_spec_id, dosage)
	VALUES (3, 3);
	
INSERT INTO public.medicine(
	medicine_id, loyalty_points, manufacturer, code, medicine_form, name, precautions, prescription_type, type, medicine_specification_med_spec_id, rating)
	VALUES (default, 10, 'Hemofarm', 'TR9NF','PILL', 'brufen', 'nema', 'NO_PRESCRIPTION', 'analgetik', 1, 10);
	
INSERT INTO public.medicine(
	medicine_id, loyalty_points, manufacturer, code, medicine_form, name, precautions, prescription_type, type, medicine_specification_med_spec_id, rating)
	VALUES (default, 5, 'Hemofarm', 'E23TR', 'PILL', 'aspirin', 'nema', 'NO_PRESCRIPTION', 'analgetik', 2, 7);
	
INSERT INTO public.medicine(
	medicine_id, loyalty_points, manufacturer, code, medicine_form, name, precautions, prescription_type, type, medicine_specification_med_spec_id, rating)
	VALUES (default, 10, 'Galenika', 'G567H', 'PILL', 'kafetin', 'nema', 'NO_PRESCRIPTION', 'analgetik', 3, 9);
	
INSERT INTO public.allergy(
	allergy_id)
	VALUES (default);
	
INSERT INTO public.allergy_medicine(
	allergy_allergy_id, medicine_medicine_id)
	VALUES (1, 1);
-- password Milica123! 
INSERT INTO public.user(
	dtype, user_id, email, enabled, first_login, first_name, last_name, last_reset_pass_date, password, salt, phone_number, username, user_type, rating, penalty, address_id, pharmacy_pharmacy_id, allergy_allergy_id)
	VALUES ('Patient', default, 'milica98@gmail.com', true, false, 'Milica', 'Lukic', '2020-11-11', '$2a$12$npxcTCqr.HeAJL6YaFDfruts5K9VCYusMwk3XFL0IwE0qGSiMe51G', 'ML896k0z0oWyHZC5i5v761==', '065/897-87-65', 'mimi', 'PATIENT', null, 0, 1, null, 1);
	
INSERT INTO public.loyalty_card(
	card_id, loyalty_category, points, patient_user_id) 
	VALUES (default, 'GOLD', 40, 1);
-- password Ivana1234!
INSERT INTO public.user(
	dtype, user_id, email, enabled, first_login, first_name, last_name, last_reset_pass_date, password, salt, phone_number, username, user_type, rating, penalty, address_id, pharmacy_pharmacy_id, allergy_allergy_id)
	VALUES ('Supplier', default, 'ivanagavric@gmail.com', true, false, 'Pera', 'Peric', '2020-11-11', '$2a$12$oI9p3iPsjtJ3y.0DEGo2T.zWkB8RKdtHRrzMyvSDx2JN8q3jYekGS', 'AN777Ivx9owXayu67jL012==', '065/789-41-23', 'null', 'SUPPLIER', null, 0, 2, null, null);
-- password Dobavljac17!
INSERT INTO public.user(
	dtype, user_id, email, enabled, first_login, first_name, last_name, last_reset_pass_date, password, salt, phone_number, username, user_type, rating, penalty, address_id, pharmacy_pharmacy_id, allergy_allergy_id)
	VALUES ('Supplier', default, 'isateam3921@gmail.com', true, false, 'Mirko', 'Mirkovic', '2020-11-11', '$2a$12$pdxtJczjkp.hLRLosRub/eYxQ.VZE8D/BhhmHbcqw7BYePkUVqAO.', 'BV1010SsRNlpMB1021Og44==', '065/789-41-00', 'null', 'SUPPLIER', null, 0, 4, null, null);
-- password Llukic123@
INSERT INTO public.user(
	dtype, user_id, email, enabled, first_login, first_name, last_name, last_reset_pass_date, password, salt, phone_number, username, user_type, rating, penalty, address_id, pharmacy_pharmacy_id, allergy_allergy_id)
	VALUES ('Supplier', default, 'luka10@gmail.com', true, false, 'Luka', 'Lukovic', '2020-11-11', '$2a$12$MG2navV0F.P58I7lsd05IuMmtJpJl7Ef4RzTFaeb4HpIvclAcG2gq', 'L10Labvsfsw2312fsf22a8==', '061/333-11-00', 'null', 'SUPPLIER', null, 0, 5, null, null);
-- password Marko123!	
INSERT INTO public.user(
	dtype, user_id, email, enabled, first_login, first_name, last_name, last_reset_pass_date, password, salt, phone_number, username, user_type, rating, penalty, address_id, pharmacy_pharmacy_id, allergy_allergy_id)
	VALUES ('PharmacyAdministrator', default, 'markovicm@gmail.com', true, false, 'Marko', 'Markovic', '2020-11-11', '$2a$12$bj4hnB7C50TPVVTZMjY0pOhL.3CImLOMztQXKxmqKaQDHvW9TmwRS', 'MaRa1324ZYw2012XxV22aR==', '065/789-41-23', 'null', 'SYS_ADMINISTRATOR', null, 0, 2, null, null);
-- password Kaca1234!
INSERT INTO public.user(
	dtype, user_id, email, enabled, first_login, first_name, last_name, last_reset_pass_date, password, salt, phone_number, username, user_type, rating, penalty, address_id, pharmacy_pharmacy_id, allergy_allergy_id)
	VALUES ('Dermatologist', default, 'kaca39@gmail.com', true, false, 'Katarina', 'Majkic', '2020-11-11', '$2a$12$abB8v5qvozbo5eEegktY5e.lh0Xw3VeoA8XYPsc8rmbvWrEQ9gTte', 'KaA4cA100w2OpVr23HaxVa==', '060/588-15-85', 'katarina123', 'DERMATOLOGIST', 9.6, null, 9, 2, null);	
-- password Ivana123#
INSERT INTO public.user(
	dtype, user_id, email, enabled, first_login, first_name, last_name, last_reset_pass_date, password, salt, phone_number, username, user_type, rating, penalty, address_id, pharmacy_pharmacy_id, allergy_allergy_id)
	VALUES ('SystemAdministrator', default, 'ivanagavric05@gmail.com', true, false, 'Ivana', 'Gavric', '2020-11-11', '$2a$12$qpNRlsMJyGpNSfGkjXNnJOsg2yQiudrpl59DJ6nS.zLp4pxkbQnXu', 'Iv24cA007w2LeVpJ2uHTV2==', '065/789-41-23', 'null', 'SYS_ADMINISTRATOR', null, 0, 2, null, null);

INSERT INTO public.order(
	order_id, offer_deadline, order_status, pharmacy_pharmacy_id, pharmacy_administrator_user_id)
	VALUES (default, '2021/04/04', 'PROCESSED', '2', '5');

INSERT INTO public.order(
	order_id, offer_deadline, order_status, pharmacy_pharmacy_id, pharmacy_administrator_user_id)
	VALUES (default, '2021/04/11', 'PROCESSED', '2', '5');
	
INSERT INTO public.order(
	order_id, offer_deadline, order_status, pharmacy_pharmacy_id, pharmacy_administrator_user_id)
	VALUES (default, '2021/04/21', 'PROCESSED', '2', '5');

INSERT INTO public.offer(
	offer_id, delivery_deadline, price, status, order_order_id, supplier_user_id)
	VALUES (default, '2021/05/05', '22000', 'ACCEPTED', '1', '2');
	
INSERT INTO public.offer(
	offer_id, delivery_deadline, price, status, order_order_id, supplier_user_id)
	VALUES (default, '2021/06/06', '8000', 'ACCEPTED', '2', '2');

INSERT INTO public.offer(
	offer_id, delivery_deadline, price, status, order_order_id, supplier_user_id)
	VALUES (default, '2021/06/05', '12000', 'DECLINED', '3', '2');	
	
INSERT INTO public.offer(
	offer_id, delivery_deadline, price, status, order_order_id, supplier_user_id)
	VALUES (default, '2021/03/05', '15000', 'WAITING', '1', '2');
	
INSERT INTO public.offer(
	offer_id, delivery_deadline, price, status, order_order_id, supplier_user_id)
	VALUES (default, '2021/02/03', '100000', 'DECLINED', '2', '2');

INSERT INTO public.offer(
	offer_id, delivery_deadline, price, status, order_order_id, supplier_user_id)
	VALUES (default, '2021/02/15', '2000', 'WAITING', '3', '2');
	
INSERT INTO public.offer(
	offer_id, delivery_deadline, price, status, order_order_id, supplier_user_id)
	VALUES (default, '2021/02/01', '54000', 'DECLINED', '1', '2');
	
INSERT INTO public.authority(name) VALUES ('ROLE_PATIENT');	
INSERT INTO public.authority(name) VALUES ('ROLE_SYS_ADMIN');	
INSERT INTO public.authority(name) VALUES ('ROLE_SUPPLIER');	
INSERT INTO public.authority(name) VALUES ('ROLE_PH_ADMIN');
INSERT INTO public.authority(name) VALUES ('ROLE_PHARMACIST');	
INSERT INTO public.authority(name) VALUES ('ROLE_DERMATOLOGIST');

INSERT INTO public.user_authorities(user_user_id, authorities_id) VALUES (1, 1);	
INSERT INTO public.user_authorities(user_user_id, authorities_id) VALUES (2, 3);
INSERT INTO public.user_authorities(user_user_id, authorities_id) VALUES (3, 3);
INSERT INTO public.user_authorities(user_user_id, authorities_id) VALUES (4, 3);
INSERT INTO public.user_authorities(user_user_id, authorities_id) VALUES (5, 4);
INSERT INTO public.user_authorities(user_user_id, authorities_id) VALUES (6, 6);	
INSERT INTO public.user_authorities(user_user_id, authorities_id) VALUES (7, 2);


INSERT INTO public.appointment(dtype, appointment_id, appointment_status, cancelled, date_and_time, 
duration, points, price, patient_user_id, shift_shift_id, pharmacist_user_id, dermatologist_user_id,
pharmacy_pharmacy_id)
VALUES ('Consultation', default, 'NONE', false, '2021-11-11 11:00:00', 30, 5, 1500, null, null, null, 6,1);
	
INSERT INTO public.appointment(dtype, appointment_id, appointment_status, cancelled, date_and_time, 
duration, points, price, patient_user_id, shift_shift_id, pharmacist_user_id, dermatologist_user_id,
pharmacy_pharmacy_id)
VALUES ('Consultation', default, 'NONE', false, '2021-11-11 11:30:00', 30, 5, 1500, null, null, null, 6,1);
	
INSERT INTO public.appointment(dtype, appointment_id, appointment_status, cancelled, date_and_time, 
duration, points, price, patient_user_id, shift_shift_id, pharmacist_user_id, dermatologist_user_id,
pharmacy_pharmacy_id)
VALUES ('Consultation', default, 'NONE', false, '2021-11-11 12:00:00', 30, 5, 1500, null, null, null, 6,1);
	
INSERT INTO public.appointment(dtype, appointment_id, appointment_status, cancelled, date_and_time, 
duration, points, price, patient_user_id, shift_shift_id, pharmacist_user_id, dermatologist_user_id,
pharmacy_pharmacy_id)
VALUES ('Consultation', default, 'NONE', false, '2021-11-11 12:30:00', 30, 5, 1500, null, null, null, 6,1);

INSERT INTO public.appointment(dtype, appointment_id, appointment_status, cancelled, date_and_time, 
duration, points, price, patient_user_id, shift_shift_id, pharmacist_user_id, dermatologist_user_id,
pharmacy_pharmacy_id)
VALUES ('Consultation', default, 'NONE', false, '2021-10-11 12:00:00', 30, 5, 1500, null, null, null, 6,2);
	
INSERT INTO public.appointment(dtype, appointment_id, appointment_status, cancelled, date_and_time, 
duration, points, price, patient_user_id, shift_shift_id, pharmacist_user_id, dermatologist_user_id,
pharmacy_pharmacy_id)
VALUES ('Consultation', default, 'NONE', false, '2021-10-11 12:30:00', 30, 5, 1500, null, null, null, 6,2);
	
	
	
	
	
