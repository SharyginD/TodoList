create table if not exists users (
  id int auto_increment primary key,
  login varchar(255) not null,
  password varchar(255) not null,
  role varchar(255) not null
);