create table if not exists todos (
  id int auto_increment primary key,
  note varchar(255) not null
);

insert into todos(note) values
    ("Купить машину"),
    ("Завести кота");