-- 1) Crear la base de datos

CREATE DATABASE IF NOT EXISTS practica CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;

USE practica;
 
-- 2) Crear tabla 'arbol'

CREATE TABLE IF NOT EXISTS arbol (

  id_arbol INT AUTO_INCREMENT PRIMARY KEY,

  nombre_comun VARCHAR(150) NOT NULL,

  tipo_flor VARCHAR(100),

  dureza_madera VARCHAR(50),

  altura_promedio DECIMAL(6,2), -- permite hasta 9999.99 si fuese necesario

  edad_promedio INT,

  ruta_imagen VARCHAR(255)

);
 
-- 3) (Opcional) Crear tabla 'estado' que menciona la parte III

CREATE TABLE IF NOT EXISTS estado (

  id_estado INT AUTO_INCREMENT PRIMARY KEY,

  nombre_estado VARCHAR(50) NOT NULL

);
 
-- 4) (Opcional) Relacionar arbol con estado

ALTER TABLE arbol

  ADD COLUMN IF NOT EXISTS id_estado INT,

  ADD CONSTRAINT IF NOT EXISTS fk_arbol_estado FOREIGN KEY (id_estado) REFERENCES estado(id_estado);
 
-- 5) Crear el usuario y conceder permisos en la base 'practica'

-- Nota: en algunas instalaciones de MySQL/MariaDB puede usarse CREATE USER ... IDENTIFIED BY ...

CREATE USER IF NOT EXISTS 'usuario_practica'@'localhost' IDENTIFIED BY 'la_Clave';

GRANT ALL PRIVILEGES ON practica.* TO 'usuario_practica'@'localhost';

FLUSH PRIVILEGES;
 
-- Opcional: insertar datos de prueba

INSERT INTO estado (nombre_estado) VALUES ('Activo'), ('Inactivo');
 
INSERT INTO arbol (nombre_comun, tipo_flor, dureza_madera, altura_promedio, edad_promedio, ruta_imagen, id_estado)

VALUES

('Ceiba', 'No aplicable', 'Media', 30.00, 100, '/uploads/ceiba.jpg', 1),

('Guayacán', 'Pequeña', 'Alta', 12.50, 60, '/uploads/guayacan.jpg', 1);
 