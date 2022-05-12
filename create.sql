create sequence hibernate_sequence start with 1 increment by 1;
create table apparel (brand varchar(255), design varchar(255), type varchar(255), product_id integer not null, primary key (product_id));
create table book (author varchar(255), genre varchar(255), publications varchar(255), product_id integer not null, primary key (product_id));
create table cart (cart_id integer not null, quantity integer not null, user_id integer not null, primary key (cart_id));
create table product (product_id integer not null, price float not null, product_name varchar(255), cart_id integer, primary key (product_id));
create table user (user_id integer not null, password varchar(255), user_name varchar(255), primary key (user_id));
alter table apparel add constraint FK8pb72ptchxn0ebojtk2r20bp8 foreign key (product_id) references product;
alter table book add constraint FKka98u01ogtkot3g9ibmt3qfr4 foreign key (product_id) references product;
alter table product add constraint FK4dk3kwbu3jpiq1xxbmkasv9n3 foreign key (cart_id) references cart;
