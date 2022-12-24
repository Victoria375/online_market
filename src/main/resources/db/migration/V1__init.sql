create table if not exists products (id bigserial primary key, title varchar(255), price int);

insert into products (title, price) values ('phone', 1000), ('computer', 5000), ('lipstick', 100), ('pencil', 56),
('bag', 123), ('hat', 135), ('dress', 160), ('napkins', 11), ('scrub', 110), ('cup', 54), ('glass', 60), ('mirror', 74),
('chair', 117), ('table', 155), ('earrings', 111);


create table if not exists users (id bigserial primary key, username VARCHAR(20), password VARCHAR(200));

insert into users (username, password) values
('bob', '$2a$12$NHwWdLoNbzMNx3kizf7xyO56VWy7xjEABjRduTtuI.BOb4aMVlKr2'),
('john', '$2a$12$zjpwQbrgf.mlZ1egiJba6eQDEg.wUJsZJQ/F8Qhexjq1TOTZqTk5a');

create table if not exists roles (id bigserial primary key, name VARCHAR(20));

insert into roles (name) values ('ROLE_USER'), ('ROLE_ADMIN');


create table if not exists users_roles (user_id int references users (id), role_id int references roles (id));

insert into users_roles (user_id, role_id) values (1, 1), (2, 2);


create table if not exists orders (id bigserial primary key, user_id int references users (id), price int,
phone varchar(55), address varchar(255));

create table if not exists cart_items (id bigserial primary key, order_id int references orders (id),
product_id int references products (id), quantity int, price_per_product int, price int);
