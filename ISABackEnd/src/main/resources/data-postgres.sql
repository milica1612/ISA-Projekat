INSERT INTO public.address(
	address_id, city, country, latitude, longitude, street, street_number)
	VALUES (default, 'Novi Sad', 'Srbija', 48, 44, 'Danila Kisa', 30);

INSERT INTO public.address(
	address_id, city, country, latitude, longitude, street, street_number)
	VALUES (default, 'Novi Sad', 'Srbija', 48, 44, 'Branka Bajica', 20);	
	
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
	VALUES (default, 'Backi Jarak','Srbija', 48, 44, 'Veljka Vlahovica', 7);
	
INSERT INTO public.address(
	address_id, city, country, latitude, longitude, street, street_number)
	VALUES (default, 'Temerin','Srbija', 48, 44, ' Petefi Sandora', 32);

INSERT INTO public.address(
	address_id, city, country, latitude, longitude, street, street_number)
	VALUES (default, 'Curug','Srbija', 48, 44, 'Cara Dusana', 9);
	
INSERT INTO public.address(
	address_id, city, country, latitude, longitude, street, street_number)
	VALUES (default, 'Petrovaradin','Srbija', 48, 44, 'Preradoviceva', 62);

INSERT INTO public.address(
	address_id, city, country, latitude, longitude, street, street_number)
	VALUES (default, 'Backi Jarak','Srbija', 48, 44, 'Nikole Tesle', 10);
	
INSERT INTO public.address(
	address_id, city, country, latitude, longitude, street, street_number)
	VALUES (default, 'Kikinda','Srbija', 48, 44, 'Generala Drapsina', 31);

INSERT INTO public.pharmacy(
	pharmacy_id, name, rating, description,consultation_price, address_id)
	VALUES (default, 'BENU', 3.4, 'First Pharmacy',700, 7);

INSERT INTO public.pharmacy(
	pharmacy_id, name, rating, description,consultation_price, address_id)
	VALUES (default, 'Jankovic', 4.6, 'Second Pharmacy',1000, 8);

INSERT INTO public.pharmacy(
	pharmacy_id, name, rating, description,consultation_price, address_id)
	VALUES (default, 'Higija', 5.0, 'Third Pharmacy',600, 11);
	
INSERT INTO public.medicine_specification(
	med_spec_id, dosage)
	VALUES (default, 4);
INSERT INTO public.medicine_specification(
	med_spec_id, dosage)
	VALUES (default, 3);
INSERT INTO public.medicine_specification(
	med_spec_id, dosage)
	VALUES (default, 3);
INSERT INTO public.medicine_specification(
	med_spec_id, dosage)
	VALUES (default, 1);
INSERT INTO public.medicine_specification(
	med_spec_id, dosage)
	VALUES (default, 3);
INSERT INTO public.medicine_specification(
	med_spec_id, dosage)
	VALUES (default, 2);
INSERT INTO public.medicine_specification(
	med_spec_id, dosage)
	VALUES (default, 1);
INSERT INTO public.medicine_specification(
	med_spec_id, dosage)
	VALUES (default, 2);
INSERT INTO public.medicine_specification(
	med_spec_id, dosage)
	VALUES (default, 2);
INSERT INTO public.medicine_specification(
	med_spec_id, dosage)
	VALUES (default, 3);
INSERT INTO public.medicine_specification(
	med_spec_id, dosage)
	VALUES (default, 3);
INSERT INTO public.medicine_specification(
	med_spec_id, dosage)
	VALUES (default, 1);	
    
INSERT INTO public.medicine(
	medicine_id, loyalty_points, manufacturer, code, medicine_form, name, precautions, prescription_type, type, medicine_specification_med_spec_id, rating)
	VALUES (default, 10, 'Hemofarm', 'TR9NF','PILL', 'brufen', 'nema', 'NO_PRESCRIPTION', 'analgetik', 1, 10);
	
INSERT INTO public.medicine(
	medicine_id, loyalty_points, manufacturer, code, medicine_form, name, precautions, prescription_type, type, medicine_specification_med_spec_id, rating)
	VALUES (default, 5, 'Hemofarm', 'E23TR', 'PILL', 'aspirin', 'nema', 'NO_PRESCRIPTION', 'analgetik', 2, 7);
	
INSERT INTO public.medicine(
	medicine_id, loyalty_points, manufacturer, code, medicine_form, name, precautions, prescription_type, type, medicine_specification_med_spec_id, rating)
	VALUES (default, 10, 'Galenika', 'G567H', 'PILL', 'kafetin', 'nema', 'NO_PRESCRIPTION', 'analgetik', 3, 9);
	
INSERT INTO public.medicine(
	medicine_id, loyalty_points, manufacturer, code, medicine_form, name, precautions, prescription_type, type, medicine_specification_med_spec_id, rating)
	VALUES (default, 10, 'Hemofarm', 'M01AB05', 'PILL', 'diklofenak', 'nema', 'NO_PRESCRIPTION', 'analgetik', 4, 8);

INSERT INTO public.medicine(
	medicine_id, loyalty_points, manufacturer, code, medicine_form, name, precautions, prescription_type, type, medicine_specification_med_spec_id, rating)
	VALUES (default, 6, 'BENU', 'R05CA12', 'SOLUTION', 'prospan', 'nema', 'NO_PRESCRIPTION', 'biljni_lek', 5, 8);

INSERT INTO public.medicine(
	medicine_id, loyalty_points, manufacturer, code, medicine_form, name, precautions, prescription_type, type, medicine_specification_med_spec_id, rating)
	VALUES (default, 6, 'BENU', 'R65B12', 'PILL', 'febricit', 'nema', 'NO_PRESCRIPTION', 'antibiotik', 6, 7);

INSERT INTO public.medicine(
	medicine_id, loyalty_points, manufacturer, code, medicine_form, name, precautions, prescription_type, type, medicine_specification_med_spec_id, rating)
	VALUES (default, 9, 'BENU', 'B94656', 'PILL', 'penicilin', 'nema', 'NO_PRESCRIPTION', 'antibiotik', 7, 10);

INSERT INTO public.medicine(
	medicine_id, loyalty_points, manufacturer, code, medicine_form, name, precautions, prescription_type, type, medicine_specification_med_spec_id, rating)
	VALUES (default, 4, 'Hemofarm', 'B31P33', 'PILL', 'ampicilin', 'nema', 'NO_PRESCRIPTION', 'antibiotik', 8, 8);

INSERT INTO public.medicine(
	medicine_id, loyalty_points, manufacturer, code, medicine_form, name, precautions, prescription_type, type, medicine_specification_med_spec_id, rating)
	VALUES (default, 6, 'BENU', 'P12M01', 'POWDER', 'azaran', 'nema', 'NO_PRESCRIPTION', 'antibiotik', 9, 9);

INSERT INTO public.medicine(
	medicine_id, loyalty_points, manufacturer, code, medicine_form, name, precautions, prescription_type, type, medicine_specification_med_spec_id, rating)
	VALUES (default, 6, 'Galenika', 'V08O41', 'POWDER', 'lendacin', 'nema', 'NO_PRESCRIPTION', 'antibiotik', 10, 8);

INSERT INTO public.medicine(
	medicine_id, loyalty_points, manufacturer, code, medicine_form, name, precautions, prescription_type, type, medicine_specification_med_spec_id, rating)
	VALUES (default, 6, 'Hemofarm', 'C142T4', 'SOLUTION', 'ceftriakson', 'nema', 'NO_PRESCRIPTION', 'antibiotik', 11, 9);

INSERT INTO public.medicine(
	medicine_id, loyalty_points, manufacturer, code, medicine_form, name, precautions, prescription_type, type, medicine_specification_med_spec_id, rating)
	VALUES (default, 6, 'Galenika', 'C16T05', 'SOLUTION', 'longacef', 'nema', 'NO_PRESCRIPTION', 'antibiotik', 12, 10);

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
	VALUES ('Supplier', default, 'isateam3921@gmail.com', true, false, 'Mirko', 'Mirkovic', '2020-11-11', '$2a$12$OiJS32BGySotXVIb99d3cua6bJ2GdIVEnyMjzgM/RR3KwXObqdYG.', 'BV1010SsRNlpMB1021Og45==', '065/789-41-00', 'null', 'SUPPLIER', null, 0, 4, null, null);

-- password Llukic123@
INSERT INTO public.user(
	dtype, user_id, email, enabled, first_login, first_name, last_name, last_reset_pass_date, password, salt, phone_number, username, user_type, rating, penalty, address_id, pharmacy_pharmacy_id, allergy_allergy_id)
	VALUES ('Supplier', default, 'luka10@gmail.com', true, false, 'Luka', 'Lukovic', '2020-11-11', '$2a$12$OiJS32BGySotXVIb99d3cua6bJ2GdIVEnyMjzgM/RR3KwXObqdYG.', 'L10Labvsfsw2312fsf22a8==', '061/333-11-00', 'null', 'SUPPLIER', null, 0, 5, null, null);

-- password Marko123!	
INSERT INTO public.user(
	dtype, user_id, email, enabled, first_login, first_name, last_name, last_reset_pass_date, password, salt, phone_number, username, user_type, rating, penalty, address_id, pharmacy_pharmacy_id, allergy_allergy_id)
	VALUES ('PharmacyAdministrator', default, 'markovicm@gmail.com', true, false, 'Marko', 'Markovic', '2020-11-11', '$2a$12$bj4hnB7C50TPVVTZMjY0pOhL.3CImLOMztQXKxmqKaQDHvW9TmwRS', 'MaRa1324ZYw2012XxV22aR==', '065/789-41-23', 'null', 'PH_ADMINISTRATOR', null, 0, 2, 3, null);

-- password Kaca1234!
INSERT INTO public.user(
	dtype, user_id, email, enabled, first_login, first_name, last_name, last_reset_pass_date, password, salt, phone_number, username, user_type, rating, penalty, address_id, pharmacy_pharmacy_id, allergy_allergy_id)
	VALUES ('Dermatologist', default, 'kaca39@gmail.com', true, false, 'Katarina', 'Majkic', '2020-11-11', '$2a$12$abB8v5qvozbo5eEegktY5e.lh0Xw3VeoA8XYPsc8rmbvWrEQ9gTte', 'KaA4cA100w2OpVr23HaxVa==', '060/588-15-85', 'katarina123', 'DERMATOLOGIST', 7.2, null, 9, null, null);	

-- password Ivana123!
INSERT INTO public.user(
	dtype, user_id, email, enabled, first_login, first_name, last_name, last_reset_pass_date, password, salt, phone_number, username, user_type, rating, penalty, address_id, pharmacy_pharmacy_id, allergy_allergy_id)
	VALUES ('SystemAdministrator', default, 'ivanagavric05@gmail.com', true, false, 'Ivana', 'Gavric', '2020-11-11', '$2a$12$8PpQEGJYFqTMAgdvoPi1Uu0ILjKVNMGaJeQ1G5CaS8sREwJTvkKJi', '650dg1MXBhE5yby/44jsRw==', '065/789-41-23', 'null', 'SYS_ADMINISTRATOR', null, 0, 2, null, null);

-- password Nikola1234!
INSERT INTO public.user(
	dtype, user_id, email, enabled, first_login, first_name, last_name, last_reset_pass_date, password, salt, phone_number, username, user_type, rating, penalty, address_id, pharmacy_pharmacy_id, allergy_allergy_id)
	VALUES ('Pharmacist', default, 'nikola7@gmail.com', true, false, 'Nikola', 'Spasic', '2020-11-11', '$2a$12$0ZQ9aHaXtbFp0c03gRFHNOTMd6BQiNAcjlVK.KSAscOlotnSpXQM.', '62l3V017w2ISV4pJ9uHTIx==', '061/333-66-10', 'nikolaspasic7', 'PHARMACIST', 9.2, null, 6, 2, null);

-- password Luka3456!
INSERT INTO public.user(
	dtype, user_id, email, enabled, first_login, first_name, last_name, last_reset_pass_date, password, salt, phone_number, username, user_type, rating, penalty, address_id, pharmacy_pharmacy_id, allergy_allergy_id)
	VALUES ('PharmacyAdministrator', default, 'lukait@gmail.com', true, false, 'Luka', 'Petrovic', '2020-11-19', '$2a$12$iFtunNf69vM1mAfDfp.zQ.3r9OVZNKvtCf8oUzUiyOyW6ee6Ipa8O', 'BolZV6e7PoImVOpZIxuHi7==', '064/225-34-49', 'lukait', 'PH_ADMINISTRATOR', null, 0, 10, 2, null);

-- password Maja366!
INSERT INTO public.user(
	dtype, user_id, email, enabled, first_login, first_name, last_name, last_reset_pass_date, password, salt, phone_number, username, user_type, rating, penalty, address_id, pharmacy_pharmacy_id, allergy_allergy_id) 
	VALUES ('Pharmacist', default, 'maja36@gmail.com', true, false, 'Maja', 'Lakic', '2021-10-11', '$2a$12$GSlMPBf8Ow9ZvbD0ci4tYuranBxuldFavPiMpfb6LH2pozD8aX1Ly','MoJZ7YXSup34xO4ZIxuHi7==','061/585-10-10', 'maja36', 'PHARMACIST', 8.1, null, 12, 3, null);	

-- password Sara123!
INSERT INTO public.user(
	dtype, user_id, email, enabled, first_login, first_name, last_name, last_reset_pass_date, password, salt, phone_number, username, user_type, rating, penalty, address_id, pharmacy_pharmacy_id, allergy_allergy_id)
	VALUES ('Dermatologist', default, 'sara20@gmail.com', true, false, 'Sara', 'Jovanovic', '2020-11-11', '$2a$12$ZJyJxPRFZGgw6t5nKDDsqOboD/H2pfLmoKADcu7LbVozp6WZ3UCMS', 'aB5ScB102w2XpVr3SIzpOl==', '061/444-01-99', 'sara20', 'DERMATOLOGIST', 8.9, null, 9, null, null);		

-- password Branko12! - branko12
INSERT INTO public.user(
	dtype, user_id, email, enabled, first_login, first_name, last_name, last_reset_pass_date, password, salt, phone_number, username, user_type, rating, penalty, address_id, pharmacy_pharmacy_id, allergy_allergy_id)
	VALUES ('Dermatologist', default, 'lukait31@gmail.com', true, false, 'Branko', 'Sudic', '2020-11-11', '$2a$12$QSz8Nyp6jzwWbR0Rxlp/bOyp/PAcCw200HIYp7nOz0NC1R823M42e', 'rB5acN122w2XOVr3sIDpx1==', '064/333-66-39', 'branko12', 'DERMATOLOGIST', 9.8, null, 13, null, null);		

-- password Milan123!
INSERT INTO public.user(
	dtype, user_id, email, enabled, first_login, first_name, last_name, last_reset_pass_date, password, salt, phone_number, username, user_type, rating, penalty, address_id, pharmacy_pharmacy_id, allergy_allergy_id)
	VALUES ('Dermatologist', default, 'milan81@gmail.com', true, false, 'Milan', 'Lakic', '2021-03-11', '$2a$12$syxpqo4ncnY0GpT99kfM3.TSo/kZL/1qbPO1Nl0SkT1sMHmmet.m2', '100cNAmjo2IODkesxlDpx1==', '061/000-16-19', 'milan81', 'DERMATOLOGIST', 9.8, null, 12, null, null);		

-- password Luka22! 
INSERT INTO public.user(
	dtype, user_id, email, enabled, first_login, first_name, last_name, last_reset_pass_date, password, salt, phone_number, username, user_type, rating, penalty, address_id, pharmacy_pharmacy_id, allergy_allergy_id)
	VALUES ('Patient', default, 'lukait31@gmail.com', true, false, 'Luka', 'Tomic', '2021-05-11', '$2a$12$XDR3iRfQvVtFMBGBcVv9u.kSDM6I3da97eXy7Jeedsl9dGbZWp0hu', 't89kMz0s2c51dssd3oW761==', '064/292-21-10', 'lukatomic', 'PATIENT', null, 0, 14, null, null);	

-- password Luka678!
INSERT INTO public.user(
	dtype, user_id, email, enabled, first_login, first_name, last_name, last_reset_pass_date, password, salt, phone_number, username, user_type, rating, penalty, address_id, pharmacy_pharmacy_id, allergy_allergy_id)
	VALUES ('Pharmacist', default, 'lukait31@gmail.com', true, false, 'Luka', 'Lolic', '2020-11-11', '$2a$12$PMWEMnAEXIKiojFMHl2Lj.e/hh1a9Mcp4JkG6Up0vEBFSKBTk9KiK', '10l3i01XCw2ISV4Ju1D31x==', '064/336-23-77', '', 'PHARMACIST', 8.6, null, 15, 2, null);

	
INSERT INTO public.order(
	order_id, offer_deadline, order_status, pharmacy_pharmacy_id, pharmacy_administrator_user_id)
	VALUES (default, '2021/04/04', 'PROCESSED', 2, 5);

INSERT INTO public.order(
	order_id, offer_deadline, order_status, pharmacy_pharmacy_id, pharmacy_administrator_user_id)
	VALUES (default, '2021/04/11', 'PROCESSED', 2, 5);
	
INSERT INTO public.order(
	order_id, offer_deadline, order_status, pharmacy_pharmacy_id, pharmacy_administrator_user_id)
	VALUES (default, '2021/04/21', 'PROCESSED', 2, 5);

INSERT INTO public.offer(
	offer_id, delivery_deadline, price, status, order_order_id, supplier_user_id)
	VALUES (default, '2021/05/05', 22000, 'ACCEPTED', 1, 2);
	
INSERT INTO public.offer(
	offer_id, delivery_deadline, price, status, order_order_id, supplier_user_id)
	VALUES (default, '2021/06/06', 8000, 'ACCEPTED', 2, 2);

INSERT INTO public.offer(
	offer_id, delivery_deadline, price, status, order_order_id, supplier_user_id)
	VALUES (default, '2021/06/05', 12000, 'DECLINED', 3, 2);	
	
INSERT INTO public.offer(
	offer_id, delivery_deadline, price, status, order_order_id, supplier_user_id)
	VALUES (default, '2021/03/05', 15000, 'WAITING', 1, 2);
	
INSERT INTO public.offer(
	offer_id, delivery_deadline, price, status, order_order_id, supplier_user_id)
	VALUES (default, '2021/02/03', 100000, 'DECLINED', 2, 2);

INSERT INTO public.offer(
	offer_id, delivery_deadline, price, status, order_order_id, supplier_user_id)
	VALUES (default, '2021/02/15', 2000, 'WAITING', 3, 2);
	
INSERT INTO public.offer(
	offer_id, delivery_deadline, price, status, order_order_id, supplier_user_id)
	VALUES (default, '2021/02/01', 54000, 'DECLINED', 1, 2);
	
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
INSERT INTO public.user_authorities(user_user_id, authorities_id) VALUES (5, 3);
INSERT INTO public.user_authorities(user_user_id, authorities_id) VALUES (6, 4);
INSERT INTO public.user_authorities(user_user_id, authorities_id) VALUES (7, 6);	
INSERT INTO public.user_authorities(user_user_id, authorities_id) VALUES (8, 2);
INSERT INTO public.user_authorities(user_user_id, authorities_id) VALUES (9, 5);
INSERT INTO public.user_authorities(user_user_id, authorities_id) VALUES (10, 4);
INSERT INTO public.user_authorities(user_user_id, authorities_id) VALUES (11, 5);
INSERT INTO public.user_authorities(user_user_id, authorities_id) VALUES (12, 6);
INSERT INTO public.user_authorities(user_user_id, authorities_id) VALUES (13, 6);
INSERT INTO public.user_authorities(user_user_id, authorities_id) VALUES (14, 6);
INSERT INTO public.user_authorities(user_user_id, authorities_id) VALUES (15, 1);
INSERT INTO public.user_authorities(user_user_id, authorities_id) VALUES (16, 5);

--- Pharmacies - Dermatologists - TABLE INSERT DATA ---
-- Sara dermatologist
 INSERT INTO public.pharmacy_dermatologist(
	pharmacy_pharmacy_id, dermatologist_user_id)
	VALUES (1, 12);
 INSERT INTO public.pharmacy_dermatologist(
	pharmacy_pharmacy_id, dermatologist_user_id)
	VALUES (2, 12);
 INSERT INTO public.pharmacy_dermatologist(
	pharmacy_pharmacy_id, dermatologist_user_id)
	VALUES (3, 12);   
-- Katarina dermatologist
 INSERT INTO public.pharmacy_dermatologist(
	pharmacy_pharmacy_id, dermatologist_user_id)
	VALUES (2, 7);
 INSERT INTO public.pharmacy_dermatologist(
	pharmacy_pharmacy_id, dermatologist_user_id)
	VALUES (3, 7);
-- Branko dermatologist
 INSERT INTO public.pharmacy_dermatologist(
	pharmacy_pharmacy_id, dermatologist_user_id)
	VALUES (2, 13);
-- Milan dermatologist
 INSERT INTO public.pharmacy_dermatologist(
	pharmacy_pharmacy_id, dermatologist_user_id)
	VALUES (3, 14);
 
-- PROMOTION - TEST DATA - my mail lukait31@gmail.com for Patient Luka Tomic 
INSERT INTO promotion_notification (patient_id, pharmacy_id) VALUES (15, 2);

-- PHARMACIST-VACATION - TEST DATA
insert into pharmacist_vacation(vacation_id, start_date, end_date, pharmacist_user_id, status) values (default, '20210912 07:00:00 AM','20210922 07:00:00 PM', 11, 2); 

insert into pharmacist_vacation(vacation_id, start_date, end_date, pharmacist_user_id, status) values (default, '20210905 07:00:00 AM','20210915 07:00:00 PM', 16, 2); 

-- DERMATOLOGIST-VACATION - TEST DATA
insert into dermatologist_vacation(vacation_id, start_date, end_date, dermatologist_user_id, status) values (default, '20210912 07:00:00 AM','20210922 07:00:00 PM', 13, 2); 


INSERT INTO public.examination(appointment_id, appointment_status, cancelled, date_and_time,
duration, points, price, dermatologist_user_id, patient_user_id, pharmacy_pharmacy_id)
VALUES (default, 'NONE', false, '2021-01-01 11:00:00', 30, 5,1500, 12, null, 1);

INSERT INTO public.examination(appointment_id, appointment_status, cancelled, date_and_time,
duration, points, price, dermatologist_user_id, patient_user_id, pharmacy_pharmacy_id)
VALUES (default, 'NONE', false, '2021-11-11 11:30:00', 30, 5,2000, 12, null, 1);

INSERT INTO public.examination(appointment_id, appointment_status, cancelled, date_and_time,
duration, points, price, dermatologist_user_id, patient_user_id, pharmacy_pharmacy_id)
VALUES (default, 'NONE', true, '2021-11-11 12:00:00', 30, 5,2000, 13, 1, 1);

INSERT INTO public.examination(appointment_id, appointment_status, cancelled, date_and_time,
duration, points, price, dermatologist_user_id, patient_user_id, pharmacy_pharmacy_id)
VALUES (default, 'NONE', false, '2021-12-12 12:00:00', 30, 5,2100, 13, null, 2);

INSERT INTO public.examination(appointment_id, appointment_status, cancelled, date_and_time,
duration, points, price, dermatologist_user_id, patient_user_id, pharmacy_pharmacy_id)
VALUES (default, 'NONE', false, '2021-08-21 12:00:00', 30, 5,2100, 13, 1, 2);

INSERT INTO public.medicine_replacement_medicine(
	medicine_medicine_id, replacement_medicine_medicine_id)
	VALUES (1, 6);
INSERT INTO public.medicine_replacement_medicine(
	medicine_medicine_id, replacement_medicine_medicine_id)
	VALUES (7, 8);
INSERT INTO public.medicine_replacement_medicine(
	medicine_medicine_id, replacement_medicine_medicine_id)
	VALUES (9, 10);
INSERT INTO public.medicine_replacement_medicine(
	medicine_medicine_id, replacement_medicine_medicine_id)
	VALUES (11, 12);
INSERT INTO public.medicine_item(
	medicine_item_id, quantity, medicine_medicine_id)
	VALUES (1, 10, 1);
INSERT INTO public.medicine_item(
	medicine_item_id, quantity, medicine_medicine_id)
	VALUES (2, 20, 2);
INSERT INTO public.medicine_item(
	medicine_item_id, quantity, medicine_medicine_id)
	VALUES (3, 3, 3);
INSERT INTO public.medicine_item(
	medicine_item_id, quantity, medicine_medicine_id)
	VALUES (4, 10, 4);
INSERT INTO public.medicine_item(
	medicine_item_id, quantity, medicine_medicine_id)
	VALUES (5, 20, 5);
INSERT INTO public.medicine_item(
	medicine_item_id, quantity, medicine_medicine_id)
	VALUES (6, 3, 6);
INSERT INTO public.medicine_item(
	medicine_item_id, quantity, medicine_medicine_id)
	VALUES (8, 3, 8);  
    
INSERT INTO public.time_interval(
	time_interval_id, start_date, end_date)
	VALUES (default, '2021-11-11 07:00:00', '2021-11-11 15:00:00');

INSERT INTO public.time_interval(
	time_interval_id, start_date, end_date)
	VALUES (default, '2021-11-01 00:00:00', '2021-11-30 23:59:59');

INSERT INTO public.time_interval(
	time_interval_id, start_date, end_date)
	VALUES (default, '2021-11-11 15:00:00', '2021-11-11 20:00:00');

INSERT INTO public.time_interval(
	time_interval_id, start_date, end_date)
	VALUES (default, '2021-11-01 00:00:00', '2021-11-30 23:59:59');

INSERT INTO public.time_interval(
	time_interval_id, start_date, end_date)
	VALUES (default, '2021-11-11 07:00:00', '2021-11-11 15:00:00');

INSERT INTO public.time_interval(
	time_interval_id, start_date, end_date)
	VALUES (default, '2021-11-01 00:00:00', '2021-11-30 23:59:59');

INSERT INTO public.work_schedule_pharmacist(
	work_schedule_id, pharmacist_user_id, pharmacy_pharmacy_id, shift_time_interval_id, valid_for_time_interval_id)
	VALUES (default, 9, 2, 1, 2);

INSERT INTO public.work_schedule_pharmacist(
	work_schedule_id, pharmacist_user_id, pharmacy_pharmacy_id, shift_time_interval_id, valid_for_time_interval_id)
	VALUES (default, 11, 3, 3, 4);

INSERT INTO public.consultation(
	appointment_id, appointment_status, cancelled, date_and_time, duration, points, price, patient_user_id, pharmacist_user_id, pharmacy_pharmacy_id)
	VALUES (default, 'NONE', false, '2021-11-11 08:15:00', 30, 5, 700, 1, 9, 2);

INSERT INTO public.consultation(
	appointment_id, appointment_status, cancelled, date_and_time, duration, points, price, patient_user_id, pharmacist_user_id, pharmacy_pharmacy_id)
	VALUES (default, 'NONE', false, '2021-11-11 09:00:00', 30, 5, 700, 1, 9, 2);

INSERT INTO public.consultation(
	appointment_id, appointment_status, cancelled, date_and_time, duration, points, price, patient_user_id, pharmacist_user_id, pharmacy_pharmacy_id)
	VALUES (default, 'NONE', false, '2021-11-11 16:15:00', 30, 5, 700, 1, 11, 3);

INSERT INTO public.consultation(
	appointment_id, appointment_status, cancelled, date_and_time, duration, points, price, patient_user_id, pharmacist_user_id, pharmacy_pharmacy_id)
	VALUES (default, 'NONE', false, '2021-11-11 17:15:00', 30, 5, 700, 1, 11, 3);

INSERT INTO public.work_schedule_pharmacist_scheduled_consultations(
	work_schedule_pharmacist_work_schedule_id, scheduled_consultations_appointment_id)
	VALUES (1, 1);

INSERT INTO public.work_schedule_pharmacist_scheduled_consultations(
	work_schedule_pharmacist_work_schedule_id, scheduled_consultations_appointment_id)
	VALUES (1, 2);

INSERT INTO public.work_schedule_pharmacist_scheduled_consultations(
	work_schedule_pharmacist_work_schedule_id, scheduled_consultations_appointment_id)
	VALUES (2, 3);

INSERT INTO public.work_schedule_pharmacist_scheduled_consultations(
	work_schedule_pharmacist_work_schedule_id, scheduled_consultations_appointment_id)
	VALUES (2, 4);