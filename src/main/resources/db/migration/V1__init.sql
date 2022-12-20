create table if not exists products (id bigserial primary key, title varchar(255), price int);

insert into products (title, price) values ('phone', 1000), ('computer', 5000), ('lipstick', 100), ('pencil', 56),
('bag', 123), ('hat', 135), ('dress', 160), ('napkins', 11), ('scrub', 110), ('cup', 54), ('glass', 60), ('mirror', 74),
('chair', 117), ('table', 155), ('earrings', 111);
