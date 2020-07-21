create table if not exists todos (
  id int auto_increment primary key,
  note varchar(255) not null,
  user_id int not null,
  constraint foreign key(user_id) references users(id)
);
