# Applicativo di analisi e storage di ordinativi

## Svolgimento

### DB e Crud
```sql

mysql -u root
show databases;
create database `negozio` default charset=utf8mb4;
grant all privileges on `negozio`.* to `commerciante`@'%' identified by 'password';
exit
mysql -u commerciante -p --password
use `negozio`;
create table clienti (
    id int not null auto_increment primary key,
    codice int not null,
    nome varchar(100) not null,
    cognome varchar(100) not null
    );
create table acquisti (
    id int not null auto_increment primary key,
    idcliente int not null,
    importo int not null,
    prodotto int not null -- ,
    -- foreign key (idcliente) references clienti(id)
    );
alter table clienti add timestamp varchar(20) not null;
alter table acquisti add timestamp varchar(20) not null;


show tables;
describe clienti;
show create table clienti;
describe acquisti;
show create table acquisti;
```