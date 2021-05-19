INSERT INTO public.address(
	address_id, city, country, latitude, longitude, street, street_number)
	VALUES ('1', 'Novi Sad', 'Srbija', 48, 44, 'Danila Kisa', 30);

INSERT INTO public.address(
	address_id, city, country, latitude, longitude, street, street_number)
	VALUES ('2', 'Novi Sad', 'Srbija', 48, 44, 'Branka Bajića', 20);	
	
INSERT INTO public.address(
	address_id, city, country, latitude, longitude, street, street_number)
	VALUES ('3', 'Novi Sad', 'Srbija', 48, 44, 'Bulevar kralja Petra I', 25);	

INSERT INTO public.address(
	address_id, city, country, latitude, longitude, street, street_number)
	VALUES ('4', 'Novi Sad','Srbija', 48, 44, 'Alekse Santica', 46);
	
INSERT INTO public.address(address_id, city, country, latitude, longitude, street, street_number)
	VALUES ('5', 'Novi Sad','Srbija', 48, 44, 'Alekse Santica', 11);
	
INSERT INTO public.address(
	address_id, city, country, latitude, longitude, street, street_number)
	VALUES ('6', 'Novi Sad','Srbija', 48, 44, 'Kisacka', 3);

INSERT INTO public.address(
	address_id, city, country, latitude, longitude, street, street_number)
	VALUES ('7', 'Novi Sad','Srbija', 48, 44, 'Maksima Gorkog', 11);

INSERT INTO public.address(
	address_id, city, country, latitude, longitude, street, street_number)
	VALUES ('8', 'Novi Sad','Srbija', 48, 44, 'Sremska', 98);

INSERT INTO public.address(
	address_id, city, country, latitude, longitude, street, street_number)
	VALUES (9, 'Novi Sad','Srbija', 48, 44, 'Kosovska', 18);
	
INSERT INTO public.address(
	address_id, city, country, latitude, longitude, street, street_number)
	VALUES (10, 'Backi Jarak','Srbija', 48, 44, 'Veljka Vlahovica', 10);

INSERT INTO public.pharmacy(
	pharmacy_id, name, rating, description, adress_id)
	VALUES (1, 'BENU', 3.4, 'First Pharmacy', 7);

INSERT INTO public.pharmacy(
	pharmacy_id, name, rating, description, adress_id)
	VALUES (2, 'Jankovic', 4.6, 'Second Pharmacy', 8);
	
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
	VALUES (1, 10, 'Hemofarm', 'TR9NF','PILL', 'brufen', 'nema', 'NO_PRESCRIPTION', 'analgetik', 1, 10);
	
INSERT INTO public.medicine(
	medicine_id, loyalty_points, manufacturer, code, medicine_form, name, precautions, prescription_type, type, medicine_specification_med_spec_id, rating)
	VALUES (2, 5, 'Hemofarm', 'E23TR', 'PILL', 'aspirin', 'nema', 'NO_PRESCRIPTION', 'analgetik', 2, 7);
	
INSERT INTO public.medicine(
	medicine_id, loyalty_points, manufacturer, code, medicine_form, name, precautions, prescription_type, type, medicine_specification_med_spec_id, rating)
	VALUES (3, 10, 'Galenika', 'G567H', 'PILL', 'kafetin', 'nema', 'NO_PRESCRIPTION', 'analgetik', 3, 9);
	
INSERT INTO public.allergy(
	allergy_id)
	VALUES (1);
	
INSERT INTO public.allergy_medicine(
	allergy_allergy_id, medicine_medicine_id)
	VALUES (1, 1);

INSERT INTO public.patient(
	 user_id, email, first_name, last_name, password, phone_number, username, user_type, address_id, penalty, allergy_allergy_id)
	VALUES ('1', 'milica98@gmail.com', 'Milica', 'Lukic', 'm_98', '065/897-87-65', 'mimi', 'PATIENT',1, 0, 1);
	
INSERT INTO public.loyalty_card(
	card_id, loyalty_category, points, patient_user_id)
	VALUES (1, 'GOLD', 40, 1);

INSERT INTO public.pharmacist(
	user_id, email, first_name, last_name, password, phone_number, username, user_type, address_id, rating, pharmacy_pharmacy_id)
	VALUES ('2', 'isateam39@gmail.com', 'Nikola', 'Nikolic', '123', '061/000-25-10', 'nikola123', 'PHARMACIST',3, 7.2, 1);

INSERT INTO public.dermatologist(
	user_id, email, first_name, last_name, password, phone_number, username, user_type, address_id, rating)
	VALUES ('3', 'isateam39@gmail.com', 'Katarina', 'Majkic', '123', '060/588-15-85', 'katarina123', 'DERMATOLOGIST', 2, 9.6);

INSERT INTO public.dermatologist_pharmacy(
	dermatologist_user_id, pharmacy_pharmacy_id)
	VALUES ('3', '1');

INSERT INTO public.pharmacyadmin(
	user_id, email, first_name, last_name, password, phone_number, username, user_type, address_id, pharmacy_pharmacy_id)
	VALUES (4, 'isateam39@gmail.com', 'Marko', 'Markovic', 'marko', '064/789-11-10', 'marko123', 'PH_ADMINISTRATOR', 6, 1);

