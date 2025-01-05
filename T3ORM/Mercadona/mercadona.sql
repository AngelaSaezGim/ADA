CREATE DATABASE IF NOT EXISTS mercadona;
USE mercadona;

CREATE TABLE IF NOT EXISTS seccion (
    idSeccion INT AUTO_INCREMENT PRIMARY KEY, 
    responsable VARCHAR(45),
    seccion VARCHAR(45) 
);

CREATE TABLE IF NOT EXISTS producto (
    idProducto INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(45),
    precio FLOAT,
    descripcion VARCHAR(45),
    idSeccion INT,
    FOREIGN KEY (idSeccion) REFERENCES seccion(idSeccion)
    ON DELETE CASCADE
    ON UPDATE CASCADE
);

-- Insertar en la tabla seccion
INSERT INTO seccion (responsable, seccion)
VALUES ('Antonio', 'Electrónica');

INSERT INTO seccion (responsable, seccion)
VALUES ('Paco', 'Perfumeria');

-- Insertar en la tabla producto
INSERT INTO producto (nombre, precio, descripcion, idSeccion)
VALUES ('Ordenador', 600, 'ordenador barato', 1);

INSERT INTO producto (nombre, precio, descripcion, idSeccion)
VALUES ('colonia', 50, 'colonia floral', 2);

INSERT INTO producto (nombre, precio, descripcion, idSeccion)
VALUES ('Ratón', 15, 'raton barato', 1);

SELECT * FROM producto ORDER BY idSeccion;
SELECT * FROM seccion;

