INSERT INTO Rent_User (login, password, name, surname) 
VALUES ('Vitek', 'password', 'Witold', 'Kubisiak');
INSERT INTO Rent_User (login, password, name, surname) 
VALUES ('Adam123', 'password', 'Adam', 'Kowalski');
INSERT INTO Rent_User (login, password, name, surname) 
VALUES ('R0bert', 'password', 'Robert', 'Przybysz');

INSERT INTO Car (name, picture, price_per_day) 
VALUES ('Ford', 'link', 100.0);
INSERT INTO Car (name, picture, price_per_day) 
VALUES ('Kia', 'link', 45.3);
INSERT INTO Car (name, picture, price_per_day) 
VALUES ('Mustang', 'link', 150.6);

INSERT INTO Reservation (user_id, car_id, start_date, end_date) 
VALUES (1, 3, '2025-03-01', '2025-03-06');
INSERT INTO Reservation (user_id, car_id, start_date, end_date) 
VALUES (2, 1, '2024-12-28', '2025-01-02');
INSERT INTO Reservation (user_id, car_id, start_date, end_date) 
VALUES (1, 2, '2025-03-09', null);