INSERT INTO Rent_User (login, password, name, surname) 
VALUES ('Vitek', 'password', 'Witold', 'Kubisiak');
INSERT INTO Rent_User (login, password, name, surname) 
VALUES ('Adam123', 'password', 'Adam', 'Kowalski');
INSERT INTO Rent_User (login, password, name, surname) 
VALUES ('R0bert', 'password', 'Robert', 'Przybysz');

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


INSERT INTO Reservation (user_id, car_id, start_date, end_date) 
VALUES (1, 3, '2025-03-01', '2025-03-06');
INSERT INTO Reservation (user_id, car_id, start_date, end_date) 
VALUES (2, 1, '2024-12-28', '2025-01-02');
INSERT INTO Reservation (user_id, car_id, start_date, end_date) 
VALUES (1, 2, '2025-03-09', null);