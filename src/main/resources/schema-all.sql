DROP TABLE persona IF EXISTS;

CREATE TABLE persona(
	ID BIGINT IDENTITY NOT NULL PRIMARY KEY,
	nombre VARCHAR(50),
	apellido VARCHAR(50),
	telefono VARCHAR(20)
);