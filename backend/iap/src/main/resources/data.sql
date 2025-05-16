-- password is 'password' (it is Bcrypt encoded string)
INSERT INTO Rent_User (login, password, name, surname, rent_user_role) 
VALUES ('user', '$2a$12$AX5RoIUobp0gohFeJZNUQ./9M8ghyVVumovA0oT9vP30DYA6ChyDu', 'Witold', 'Kubisiak', 'ROLE_USER');
INSERT INTO Rent_User (login, password, name, surname, rent_user_role) 
VALUES ('admin', '$2a$12$AX5RoIUobp0gohFeJZNUQ./9M8ghyVVumovA0oT9vP30DYA6ChyDu', 'Adam', 'Kowalski', 'ROLE_ADMIN');
INSERT INTO Rent_User (login, password, name, surname, rent_user_role) 
VALUES ('user1', '$2a$12$AX5RoIUobp0gohFeJZNUQ./9M8ghyVVumovA0oT9vP30DYA6ChyDu', 'Robert', 'Przybysz', 'ROLE_USER');
INSERT INTO Rent_User (login, password, name, surname, rent_user_role) 
VALUES ('user2', '$2a$12$AX5RoIUobp0gohFeJZNUQ./9M8ghyVVumovA0oT9vP30DYA6ChyDu', 'Natalia', 'Biernacka', 'ROLE_USER');
INSERT INTO Rent_User (login, password, name, surname, rent_user_role) 
VALUES ('user3', '$2a$12$AX5RoIUobp0gohFeJZNUQ./9M8ghyVVumovA0oT9vP30DYA6ChyDu', 'Michał', 'Kopański', 'ROLE_USER');
INSERT INTO Rent_User (login, password, name, surname, rent_user_role) 
VALUES ('user4', '$2a$12$AX5RoIUobp0gohFeJZNUQ./9M8ghyVVumovA0oT9vP30DYA6ChyDu', 'Robert', 'Makłowicz', 'ROLE_USER');
INSERT INTO Rent_User (login, password, name, surname, rent_user_role) 
VALUES ('user5', '$2a$12$AX5RoIUobp0gohFeJZNUQ./9M8ghyVVumovA0oT9vP30DYA6ChyDu', 'Ewa', 'Olczak', 'ROLE_USER');
INSERT INTO Rent_User (login, password, name, surname, rent_user_role) 
VALUES ('user6', '$2a$12$AX5RoIUobp0gohFeJZNUQ./9M8ghyVVumovA0oT9vP30DYA6ChyDu', 'Krystian', 'Marczak', 'ROLE_USER');

INSERT INTO Car (name, picture, price_per_day,category) 
VALUES ('Volkswagen Golf', 'https://ocs-pl.oktawave.com/v1/AUTH_2887234e-384a-4873-8bc5-405211db13a2/autoblog/2019/10/volkswagen-golf-8-2020-05.jpg', 100.0,'Compact');
INSERT INTO Car (name, picture, price_per_day,category) 
VALUES ('Chevrolet Spark', 'https://webp-konwerter.incdn.pl/eyJmIjoiaHR0cHM6Ly9nNC5/pbmZvci5wbC9wL19maWxlcy/8xMDgwMDAvYW1fNjg0M3NfO/TI0NjguanBnIiwidyI6NjYwfQ.png', 45.3,'Mini');
INSERT INTO Car (name, picture, price_per_day,category) 
VALUES ('Toyota Corolla', 'https://kong-proxy-intranet.toyota-europe.com/c1-images/resize/ccis/680x680/zip/pl/product-token/678bc86c-41f0-48a2-9369-31807799e797/vehicle/70f25b53-e790-4f94-8db6-8de9f209c39d/padding/50,50,50,50/image-quality/70/day-exterior-04_040.png', 150.6,'Compact');
INSERT INTO Car (name, picture, price_per_day,category) 
VALUES ('Volvo XC60', 'https://autocentrumgroup.pl/wp-content/uploads/2024/08/2024_volvo_xc60_4dr-suv_recharge-t8-plus_fq_oem_1_1600.jpg', 250.6,'Premium');
INSERT INTO Car (name, picture, price_per_day,category) 
VALUES ('Mazda CX60', 'https://carleasepolska.pl/uploads/b786d011e204d69d7016e8f0829b6ad8_webp_converted.webp', 250.6,'Premium');
INSERT INTO Car (name, picture, price_per_day,category) 
VALUES ('Kia Sportage', 'https://kiaautopol.pl/wp-content/uploads/2021/12/sportage-wersja-m-l.png', 130.5,'Compact SUV');
INSERT INTO Car (name, picture, price_per_day,category) 
VALUES ('Hyundai i20', 'https://kaizenrent.pl/sites/default/files/styles/galeria_powiekszony/public/obraz_pgf/hyundai-novi-i20-12-dohc-84ks-style-gbpz-benzin-637467562664120194_1600_900.jpeg.webp?itok=xhCnqqfS', 60.3,'Mini');
INSERT INTO Car (name, picture, price_per_day,category) 
VALUES ('MG HS', 'https://mg.grupabemo.pl/wp-content/uploads/2024/11/diamond-red.jpg', 110.4,'Compact SUV');



INSERT INTO Reservation (user_id, car_id, start_date, end_date) 
VALUES (1, 3, '2025-03-01', '2025-03-06');
INSERT INTO Reservation (user_id, car_id, start_date, end_date) 
VALUES (2, 1, '2024-12-28', '2025-01-02');
INSERT INTO Reservation (user_id, car_id, start_date, end_date) 
VALUES (1, 2, '2025-03-09', null);

INSERT INTO Reservation (user_id, car_id, start_date, end_date) 
VALUES (2, 3, '2025-05-06', '2025-05-12');
INSERT INTO Reservation (user_id, car_id, start_date, end_date) 
VALUES (5, 3, '2024-05-17', '2025-05-24');

INSERT INTO Reservation (user_id, car_id, start_date, end_date) 
VALUES (8, 2, '2025-02-28', '2025-03-08');
INSERT INTO Reservation (user_id, car_id, start_date, end_date) 
VALUES (6, 2, '2025-02-12', '2025-02-14');
INSERT INTO Reservation (user_id, car_id, start_date, end_date) 

VALUES (4, 1, '2025-01-03', '2025-01-07');
INSERT INTO Reservation (user_id, car_id, start_date, end_date) 
VALUES (5, 1, '2025-02-05', '2025-02-06');
INSERT INTO Reservation (user_id, car_id, start_date, end_date) 
VALUES (1, 1, '2025-01-20', '2025-01-23');
INSERT INTO Reservation (user_id, car_id, start_date, end_date) 
VALUES (8, 1, '2025-07-13', '2025-07-25');

VALUES (3, 4, '2025-06-03', '2025-06-08');
INSERT INTO Reservation (user_id, car_id, start_date, end_date) 
VALUES (5, 4, '2025-04-05', '2025-04-13');
INSERT INTO Reservation (user_id, car_id, start_date, end_date) 
VALUES (2, 4, '2025-03-20', '2025-03-27');
INSERT INTO Reservation (user_id, car_id, start_date, end_date) 
VALUES (7, 4, '2025-01-15', '2025-01-17');

VALUES (1, 5, '2025-01-29', '2025-02-02');
INSERT INTO Reservation (user_id, car_id, start_date, end_date) 
VALUES (7, 5, '2025-04-06', '2025-04-11');
INSERT INTO Reservation (user_id, car_id, start_date, end_date) 
VALUES (8, 5, '2025-03-20', '2025-03-27');

VALUES (3, 7, '2025-05-23', '2025-05-28');
INSERT INTO Reservation (user_id, car_id, start_date, end_date) 
VALUES (5, 7, '2024-12-30', '2025-01-01');
INSERT INTO Reservation (user_id, car_id, start_date, end_date) 
VALUES (8, 7, '2025-06-01', '2025-06-03');
INSERT INTO Reservation (user_id, car_id, start_date, end_date) 
VALUES (7, 7, '2025-02-15', '2025-02-20');
INSERT INTO Reservation (user_id, car_id, start_date, end_date) 
VALUES (4, 7, '2025-04-20', '2025-04-25');

INSERT INTO Reservation (user_id, car_id, start_date, end_date) 
VALUES (4, 8, '2024-11-01', '2024-11-08');
INSERT INTO Reservation (user_id, car_id, start_date, end_date) 
VALUES (6, 8, '2025-05-19', '2025-06-01');
INSERT INTO Reservation (user_id, car_id, start_date, end_date) 
VALUES (4, 8, '2025-08-25', '2025-09-10');