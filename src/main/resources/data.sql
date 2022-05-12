//Queries used for testing application
------------------------------------
/*
insert into user(user_id,user_name,password) values(1,'Sumathy','MTIzNDU='); 

//Actual password is 12345. Encoded string stored in DB
 
insert into product (product_id,price,product_name) values (100,800,'Java Book');
insert into Book(author,genre,publications,product_id) values ('James Gosling','Technical','Pearson',100);
insert into cart_item (cart_item_id,quantity,user_id,product_id) values (1,2,1,100);


insert into product (product_id,price,product_name) values (101,801,'Java ');
insert into Book(author,genre,publications,product_id) values ('James Gosling','Technical','Pearson',101);
insert into cart_item (cart_item_id,quantity,user_id,product_id) values (2,2,1,101);

insert into product (product_id,price,product_name) values (102,900,'Saree');
insert into apparel(brand,design,type,product_id) values ('BIBA','NEW','COTTON',102);
insert into cart_item (cart_item_id,quantity,user_id,product_id) values (3,1,1,102);

insert into product (product_id,price,product_name) values (103,800,'Pant');
insert into apparel(brand,design,type,product_id) values ('Lee','Latest','Jeans',103);
insert into cart_item (cart_item_id,quantity,user_id,product_id) values (4,2,1,103);
*/