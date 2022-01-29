CREATE TABLE users (
	id int primary key auto_increment NOT NULL,
	username VARCHAR(50) NOT NULL,
	password VARCHAR(100) NOT NULL
);

CREATE TABLE IF NOT EXISTS roles (
	id int AUTO_INCREMENT PRIMARY KEY NOT NULL,
	role VARCHAR(20) NOT NULL
);

CREATE TABLE IF NOT EXISTS users_roles (
	users_id INT NOT NULL,
	roles_id INT NOT NULL
);

INSERT INTO USERS (username, password) values('eduit','$2y$10$pz6nmql6Sz5kOcNuSZw/reJSu1ZG1QYS8TMMRnNNZ0dO4zPARYD9m');

INSERT INTO roles(role) VALUES('ADMIN');
INSERT INTO roles(role) VALUES('USER');
INSERT INTO users_roles(USERS_ID,ROLES_ID) VALUES(1,1);


#paises
#socios
#estados_ordenes
#ordenes

CREATE TABLE IF NOT EXISTS paises (
  id int AUTO_INCREMENT PRIMARY KEY NOT NULL,
  descripcion varchar(100) NOT NULL,
  descripcion_corta varchar(6) NOT NULL,
  habilitada int NOT NULL
);

CREATE TABLE IF NOT EXISTS socios (
  id int AUTO_INCREMENT PRIMARY KEY NOT NULL,
  nombre varchar(50) NOT NULL,
  apellido varchar(50) NOT NULL,
  email varchar(100) DEFAULT NULL,
  fecha_alta date NOT NULL,
  direccion VARCHAR(100),
  paises_id int,
  users_id int NOT NULL
) ;


CREATE TABLE IF NOT EXISTS estados_ordenes (
  id int AUTO_INCREMENT PRIMARY KEY NOT NULL,
  descripcion varchar(45) NOT NULL,
  descripcion_corta varchar(45) DEFAULT NULL,
  estado_final int NOT NULL
) ;

CREATE TABLE IF NOT EXISTS ordenes (
  id int AUTO_INCREMENT PRIMARY KEY NOT NULL,
  fecha_creacion date DEFAULT NULL,
  socios_id int DEFAULT NULL,
  estados_ordenes_id int DEFAULT NULL,
  monto_total float DEFAULT NULL,
  cupones_id int DEFAULT NULL  
) ;

#alter table!
ALTER TABLE SOCIOS ADD CONSTRAINT FK_socios_users FOREIGN KEY (users_id) REFERENCES USERS(ID);
ALTER TABLE ORDENES ADD CONSTRAINT FK_ordenes_estados_ordenes FOREIGN KEY (ESTADOS_ORDENES_ID) REFERENCES ESTADOS_ORDENES(ID);
ALTER TABLE ORDENES ADD CONSTRAINT FK_ordenes_socios FOREIGN KEY (SOCIOS_ID) REFERENCES SOCIOS(ID);
ALTER TABLE ORDENES ADD CONSTRAINT FK_ordenes_cupones FOREIGN KEY (CUPONES_ID) REFERENCES CUPONES(ID);
