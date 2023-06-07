
 
 
INSERT INTO  books (name, price, publish_date, language) VALUES ('Java17', '25', '2011-06-03', 'Azərbaycan');


 

INSERT INTO  authors
(name) values ('James'),('Richard'),('Jon'),('Henry');


  
  INSERT INTO  users
( username,password,enabled) values 

('admin','{noop}admin',1) 
;


  INSERT INTO  authority_list
(  authority ) values  

('admin'),
('books:get:all'),
('users:get:all'),
('books:search'),
('books:delete:by:id'),
('books:open:add'),
('books:save'),
('books:open:edit');

  INSERT INTO  authorities
( username,authority ) values  

 
('admin','admin') ,
('admin','books:get:all') ,
('admin','users:get:all') ,
('admin','books:search') ,
('admin','books:delete:by:id') ,
('admin','books:open:add') ,
('admin','books:save') ,
('admin','books:open:edit') 


;
 
 

