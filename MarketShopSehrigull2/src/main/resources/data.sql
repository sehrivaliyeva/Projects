



INSERT INTO products(name,barcode,price,cost,description,available_quantity,register_date)

 
VALUES
    ('Hp',5555,'30.0','20.0','yaxsi',20,'2023-04-07 12:40:41'),

    ('Acer',6666,60.0,50.0,'normal',50,'2023-03-06 03:54:47'),
    ('Apple',7777,80.0,70.0,'normal',17,'2023-04-05 17:36:10'),
    ('Dell',8888,100.0,90.0,'orta',18,'2023-04-10 13:12:11'),
    ('Asus',9999,200.0,95.0,'pis',14,'2023-09-05 15:37:10'),
    ('Lenovo',1111,420.0,300.0,'yaxsi',35,'2023-04-08 22:30:59'),
    ('AirMac',2222,350.0,200.0,'pis',12,'2023-08-07 04:45:47'),
    ('Toshiba',3333,110.0,80.0,'normal',19,'2023-09-03 21:31:58');

 

insert into cashier_product (name, barcode, price,description,available_quantity) values



    ('Acer','6666','60.0','normal','50'),
    ('Apple',7777,80.0,'normal',17),
    ('Dell',8888,100.0,'orta',18),
    ('Asus',9999,200.0,'pis',14),
    ('Lenovo',1111,420.0,'yaxsi',35),
    ('AirMac',2222,350.0,'pis',12),
    ('Toshiba',3333,110.0,'normal',19);

 




 insert into users (username, password, enabled) values 
('admin', '{noop}12', 1), 
('cashier', '{noop}12', 1);
insert into authorities(username, authority) values 
('admin', 'admin'), 
('cashier', 'cashier');



 

