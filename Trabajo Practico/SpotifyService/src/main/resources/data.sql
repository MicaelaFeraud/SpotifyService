drop table if exist artist;

create table artist (
idArtist int auto_increment PRIMARY KEY,
name varchar(250),
genere varchar (250),
image varchar (250)
)