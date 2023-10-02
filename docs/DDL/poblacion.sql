INSERT INTO usuarios (id, nombre, tipo_documento, numero_documento, rol, correo) VALUES (1, 'Juan Pérez', 'CC', '123456789', 'CLIENTE', 'juan@example.com');
INSERT INTO usuarios (id, nombre, tipo_documento, numero_documento, rol, correo) VALUES (2, 'María López', 'CE', '987654321', 'EMPLEADO', 'maria@example.com');
INSERT INTO usuarios (id, nombre, tipo_documento, numero_documento, rol, correo) VALUES (3, 'Admin1', 'CC', '111111111', 'ADMINISTRADOR', 'admin@example.com');
INSERT INTO usuarios (id, nombre, tipo_documento, numero_documento, rol, correo) VALUES (4, 'Laura Torres', 'NIT', '1234567890', 'GERENTE', 'laura@example.com');

-- Inserción de datos ficticios en la tabla hoteles
INSERT INTO hoteles (id, nombre, nit) VALUES (5, 'Hotel Ejemplo 1', 123456789);
INSERT INTO hoteles (id, nombre, nit) VALUES (6, 'Hotel Prueba 2', 987654321);
INSERT INTO hoteles (id, nombre, nit) VALUES (7, 'Hotel de Fantasía', 555555555);
INSERT INTO hoteles (id, nombre, nit) VALUES (8, 'Hotel Imaginario', 999999999);


-- Inserción de datos ficticios en la tabla planes_consumo
INSERT INTO planes_consumo (id, tipoplan, descuento, hoteles_id, descuento1)
VALUES (1, 'Larga_Estadia', 10.0, 5, 5.0);

INSERT INTO planes_consumo (id, tipoplan, descuento, hoteles_id, descuento1)
VALUES (2, 'Promo_Particular', 15.0, 6, 7.0);

INSERT INTO planes_consumo (id, tipoplan, descuento, hoteles_id, descuento1)
VALUES (3, 'Tiempo_Compartido', 20.0, 7, 8.0);

INSERT INTO planes_consumo (id, tipoplan, descuento, hoteles_id, descuento1)
VALUES (4, 'Todo_Incluido', 25.0, 8, 10.0);