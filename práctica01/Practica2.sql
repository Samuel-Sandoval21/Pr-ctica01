-- 1️ Eliminar base de datos si existe (para comenzar limpio)
DROP DATABASE IF EXISTS practica;
 
-- 2️ Crear la base de datos
CREATE DATABASE practica CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
USE practica;
 
-- 3️ Crear tabla 'estado'
CREATE TABLE estado (
  id_estado INT AUTO_INCREMENT PRIMARY KEY,
  nombre_estado VARCHAR(50) NOT NULL
);
 
-- 4️ Crear tabla 'arbol'
CREATE TABLE arbol (
  id_arbol INT AUTO_INCREMENT PRIMARY KEY,
  nombre_comun VARCHAR(150) NOT NULL,
  tipo_flor VARCHAR(100),
  dureza_madera VARCHAR(50),
  altura_promedio DECIMAL(6,2),
  edad_promedio INT,
  ruta_imagen VARCHAR(255),
  id_estado INT,
  CONSTRAINT fk_arbol_estado FOREIGN KEY (id_estado) REFERENCES estado(id_estado)
);
 
-- 5️ [ELIMINADO] Ya no necesitamos crear usuario especial, usaremos root
 
-- 6️ Insertar datos en 'estado'
INSERT INTO estado (nombre_estado) VALUES ('Activo'), ('Inactivo');
 
-- 7️ Insertar datos de prueba en 'arbol'
INSERT INTO arbol (nombre_comun, tipo_flor, dureza_madera, altura_promedio, edad_promedio, ruta_imagen, id_estado)
VALUES
('Ceiba', 'No aplicable', 'Media', 30.00, 100, '/uploads/ceiba.jpg', 1),
('Guayacán', 'Pequeña', 'Alta', 12.50, 60, '/uploads/guayacan.jpg', 1);
 
-- 8️ [OPCIONAL] Verificar que root tenga permisos (normalmente ya los tiene)
-- GRANT ALL PRIVILEGES ON practica.* TO 'root'@'localhost';
-- FLUSH PRIVILEGES;