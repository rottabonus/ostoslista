CREATE TABLE ostoslista(
id int auto_increment not null,
nimi varchar(20) not null,
maara int not null,
kuvaus varchar(40) not null,
hinta decimal(5,2) not null,
PRIMARY KEY (id)
)engine=innoDB;