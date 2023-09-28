-- Generado por Oracle SQL Developer Data Modeler 23.1.0.087.0806
--   en:        2023-09-27 00:32:45 COT
--   sitio:      Oracle Database 12c
--   tipo:      Oracle Database 12c



-- predefined type, no DDL - MDSYS.SDO_GEOMETRY

-- predefined type, no DDL - XMLTYPE

CREATE TABLE bares (
                       estilo VARCHAR2(50) NOT NULL,
                       id     NUMBER NOT NULL
);

ALTER TABLE bares
    ADD CHECK ( estilo IN ( 'Jazz', 'Karaoke', 'Moderna', 'Rock', 'Taberna',
                            'Tradicional' ) );

ALTER TABLE bares ADD CONSTRAINT bares_pk PRIMARY KEY ( id );

CREATE TABLE carta (
                       bares_id         NUMBER NOT NULL,
                       productos_nombre VARCHAR2(100) NOT NULL
);

ALTER TABLE carta ADD CONSTRAINT carta_pk PRIMARY KEY ( bares_id,
                                                        productos_nombre );

CREATE TABLE cartav1 (
                         restaurantes_id  NUMBER NOT NULL,
                         productos_nombre VARCHAR2(100) NOT NULL
);

ALTER TABLE cartav1 ADD CONSTRAINT cartav1_pk PRIMARY KEY ( restaurantes_id,
                                                            productos_nombre );

CREATE TABLE conferencias (
                              capacidad NUMBER NOT NULL,
                              fecha     DATE,
                              hora      DATE NOT NULL,
                              duracion  NUMBER NOT NULL,
                              id        NUMBER NOT NULL
);

ALTER TABLE conferencias ADD CONSTRAINT conferencias_pk PRIMARY KEY ( id );

CREATE TABLE cuentas (
                         servicio_id        NUMBER NOT NULL,
                         habitacionesnumero NUMBER NOT NULL
);

ALTER TABLE cuentas ADD CONSTRAINT cuentas_pk PRIMARY KEY ( servicio_id,
                                                            habitacionesnumero );

CREATE TABLE gimnasio (
                          capacidad NUMBER NOT NULL,
                          maquinas  VARCHAR2(255) NOT NULL,
                          id        NUMBER NOT NULL
);

ALTER TABLE gimnasio ADD CONSTRAINT gimnasio_pk PRIMARY KEY ( id );

CREATE TABLE habitaciones (
                              numero                NUMBER NOT NULL,
                              disponible            VARCHAR2(5) NOT NULL,
                              hoteles_id            NUMBER NOT NULL,
                              tipos_habitaciones_id NUMBER NOT NULL,
                              reservas_id           NUMBER NOT NULL,
                              precionoche           NUMBER NOT NULL
);

ALTER TABLE habitaciones
    ADD CHECK ( disponible IN ( 'NO', 'SI' ) );

CREATE UNIQUE INDEX habitaciones__idx ON
    habitaciones (
                  reservas_id
                  ASC );

ALTER TABLE habitaciones ADD CONSTRAINT habitaciones_pk PRIMARY KEY ( numero );

CREATE TABLE hoteles (
                         id     NUMBER NOT NULL,
                         nombre VARCHAR2(50) NOT NULL,
                         nit    NUMBER NOT NULL
);

ALTER TABLE hoteles ADD CONSTRAINT hoteles_pk PRIMARY KEY ( id );

CREATE TABLE internet (
                          anchobanda FLOAT NOT NULL,
                          id         NUMBER NOT NULL
);

ALTER TABLE internet ADD CONSTRAINT internet_pk PRIMARY KEY ( id );

CREATE TABLE ocupadas (
                          usuario_id         NUMBER NOT NULL,
                          habitacionesnumero NUMBER NOT NULL
);

ALTER TABLE ocupadas ADD CONSTRAINT ocupadas_pk PRIMARY KEY ( usuario_id,
                                                              habitacionesnumero );

CREATE TABLE piscinas (
                          capacidad   NUMBER NOT NULL,
                          profundidad FLOAT NOT NULL,
                          id          NUMBER NOT NULL
);

ALTER TABLE piscinas ADD CONSTRAINT piscinas_pk PRIMARY KEY ( id );

CREATE TABLE planes_consumo (
                                id         NUMBER NOT NULL,
                                tipoplan   VARCHAR2(50) NOT NULL,
                                descuento  FLOAT NOT NULL,
                                hoteles_id NUMBER NOT NULL,
                                descuento1 FLOAT NOT NULL
);

ALTER TABLE planes_consumo
    ADD CHECK ( tipoplan IN ( 'Larga_Estadia', 'Promo_Particular', 'Tiempo_Compartido', 'Todo_Incluido' ) );

ALTER TABLE planes_consumo ADD CONSTRAINT planes_consumo_pk PRIMARY KEY ( id );

CREATE TABLE productos (
                           nombre VARCHAR2(100) NOT NULL,
                           precio NUMBER NOT NULL
);

ALTER TABLE productos ADD CONSTRAINT productos_pk PRIMARY KEY ( nombre );

CREATE TABLE reservas (
                          id            NUMBER NOT NULL,
                          hora_reserva  DATE,
                          fecha_inicial DATE NOT NULL,
                          fecha_final   DATE NOT NULL,
                          acompañantes  NUMBER NOT NULL
);

ALTER TABLE reservas ADD CONSTRAINT reservas_pk PRIMARY KEY ( id );

CREATE TABLE restaurantes (
                              estilo VARCHAR2(50) NOT NULL,
                              id     NUMBER NOT NULL
);

ALTER TABLE restaurantes
    ADD CHECK ( estilo IN ( 'Frances', 'Italiano', 'Mediterraneo', 'Mexicano', 'Oriental' ) );

ALTER TABLE restaurantes ADD CONSTRAINT restaurantes_pk PRIMARY KEY ( id );

CREATE TABLE reuniones (
                           capacidad      NUMBER NOT NULL,
                           costoadicional NUMBER NOT NULL,
                           fecha          DATE,
                           hora           DATE NOT NULL,
                           duracion       NUMBER NOT NULL,
                           id             NUMBER NOT NULL
);

ALTER TABLE reuniones ADD CONSTRAINT reuniones_pk PRIMARY KEY ( id );

CREATE TABLE servicios (
                           id             NUMBER NOT NULL,
                           horarioinicial DATE,
                           horariofinal   DATE,
                           reservas_id    NUMBER NOT NULL,
                           nombre         VARCHAR2(63) NOT NULL,
                           costo          NUMBER NOT NULL,
                           cargado        VARCHAR2
--  ERROR: VARCHAR2 size not specified
                                                 NOT NULL,
                           existe         VARCHAR2
--  ERROR: VARCHAR2 size not specified
                                                 NOT NULL
);

ALTER TABLE servicios
    ADD CHECK ( cargado IN ( 'NO', 'SI' ) );

ALTER TABLE servicios
    ADD CHECK ( existe IN ( 'NO', 'SI' ) );

ALTER TABLE servicios ADD CONSTRAINT servicios_pk PRIMARY KEY ( id );

CREATE TABLE serviciospas (
                              duración NUMBER NOT NULL,
                              costo    NUMBER NOT NULL,
                              fecha    DATE NOT NULL,
                              spas_id  NUMBER NOT NULL
);

CREATE TABLE spas (
                      capacidad NUMBER NOT NULL,
                      id        NUMBER NOT NULL
);

ALTER TABLE spas ADD CONSTRAINT spas_pk PRIMARY KEY ( id );

CREATE TABLE tienda (
                        tipo VARCHAR2
--  ERROR: VARCHAR2 size not specified
                                    NOT NULL,
                        id   NUMBER NOT NULL
);

ALTER TABLE tienda
    ADD CHECK ( tipo IN ( 'Joyeria', 'Moda', 'Souvenirs', 'Supermercado' ) );

ALTER TABLE tienda ADD CONSTRAINT tienda_pk PRIMARY KEY ( id );

CREATE TABLE tipos_habitaciones (
                                    id        NUMBER NOT NULL,
                                    tipo      VARCHAR2(55) NOT NULL,
                                    capacidad NUMBER NOT NULL,
                                    dotacion  VARCHAR2(255) NOT NULL
);

ALTER TABLE tipos_habitaciones
    ADD CHECK ( tipo IN ( 'Doble', 'Familiar', 'Sencilla', 'Suite', 'Suite Presidencial' ) );

ALTER TABLE tipos_habitaciones ADD CONSTRAINT tipos_habitaciones_pk PRIMARY KEY ( id );

CREATE TABLE usuarios (
                          id             NUMBER NOT NULL,
                          nombre         VARCHAR2(50),
                          tipo_documento VARCHAR2(25),
                          numdoc         NUMBER NOT NULL,
                          rol            VARCHAR2(25),
                          correo         VARCHAR2(40)
);

ALTER TABLE usuarios
    ADD CHECK ( tipo_documento IN ( 'CC', 'CE', 'NIT', 'PASAPORTE', 'TI' ) );

ALTER TABLE usuarios
    ADD CHECK ( rol IN ( 'ADMINISTRADOR', 'CLIENTE', 'EMPLEADO', 'GERENTE', 'RECEPCIONISTA' ) );

ALTER TABLE usuarios ADD CONSTRAINT usuarios_pk PRIMARY KEY ( id );

CREATE TABLE utensilio (
                           devuelto VARCHAR2
--  ERROR: VARCHAR2 size not specified
                                           NOT NULL,
                           estado   VARCHAR2(255) NOT NULL,
                           id       NUMBER NOT NULL
);

ALTER TABLE utensilio
    ADD CHECK ( devuelto IN ( 'NO', 'SI' ) );

ALTER TABLE utensilio ADD CONSTRAINT utensilio_pk PRIMARY KEY ( id );

ALTER TABLE bares
    ADD CONSTRAINT bares_servicios_fk FOREIGN KEY ( id )
        REFERENCES servicios ( id );

ALTER TABLE carta
    ADD CONSTRAINT carta_bares_fk FOREIGN KEY ( bares_id )
        REFERENCES bares ( id );

ALTER TABLE carta
    ADD CONSTRAINT carta_productos_fk FOREIGN KEY ( productos_nombre )
        REFERENCES productos ( nombre );

ALTER TABLE cartav1
    ADD CONSTRAINT cartav1_productos_fk FOREIGN KEY ( productos_nombre )
        REFERENCES productos ( nombre );

ALTER TABLE cartav1
    ADD CONSTRAINT cartav1_restaurantes_fk FOREIGN KEY ( restaurantes_id )
        REFERENCES restaurantes ( id );

ALTER TABLE conferencias
    ADD CONSTRAINT conferencias_servicios_fk FOREIGN KEY ( id )
        REFERENCES servicios ( id );

ALTER TABLE cuentas
    ADD CONSTRAINT cuentas_habitaciones_fk FOREIGN KEY ( habitacionesnumero )
        REFERENCES habitaciones ( numero );

ALTER TABLE cuentas
    ADD CONSTRAINT cuentas_servicios_fk FOREIGN KEY ( servicio_id )
        REFERENCES servicios ( id );

ALTER TABLE gimnasio
    ADD CONSTRAINT gimnasio_servicios_fk FOREIGN KEY ( id )
        REFERENCES servicios ( id );

ALTER TABLE habitaciones
    ADD CONSTRAINT habitaciones_hoteles_fk FOREIGN KEY ( hoteles_id )
        REFERENCES hoteles ( id );

ALTER TABLE habitaciones
    ADD CONSTRAINT habitaciones_reservas_fk FOREIGN KEY ( reservas_id )
        REFERENCES reservas ( id );

--  ERROR: FK name length exceeds maximum allowed length(30)
ALTER TABLE habitaciones
    ADD CONSTRAINT habitaciones_tipos_habitaciones_fk FOREIGN KEY ( tipos_habitaciones_id )
        REFERENCES tipos_habitaciones ( id );

ALTER TABLE internet
    ADD CONSTRAINT internet_servicios_fk FOREIGN KEY ( id )
        REFERENCES servicios ( id );

ALTER TABLE ocupadas
    ADD CONSTRAINT ocupadas_habitaciones_fk FOREIGN KEY ( habitacionesnumero )
        REFERENCES habitaciones ( numero );

ALTER TABLE ocupadas
    ADD CONSTRAINT ocupadas_usuarios_fk FOREIGN KEY ( usuario_id )
        REFERENCES usuarios ( id );

ALTER TABLE piscinas
    ADD CONSTRAINT piscinas_servicios_fk FOREIGN KEY ( id )
        REFERENCES servicios ( id );

ALTER TABLE planes_consumo
    ADD CONSTRAINT planes_consumo_hoteles_fk FOREIGN KEY ( hoteles_id )
        REFERENCES hoteles ( id );

ALTER TABLE restaurantes
    ADD CONSTRAINT restaurantes_servicios_fk FOREIGN KEY ( id )
        REFERENCES servicios ( id );

ALTER TABLE reuniones
    ADD CONSTRAINT reuniones_servicios_fk FOREIGN KEY ( id )
        REFERENCES servicios ( id );

ALTER TABLE servicios
    ADD CONSTRAINT servicios_reservas_fk FOREIGN KEY ( reservas_id )
        REFERENCES reservas ( id );

ALTER TABLE serviciospas
    ADD CONSTRAINT serviciospas_spas_fk FOREIGN KEY ( spas_id )
        REFERENCES spas ( id );

ALTER TABLE spas
    ADD CONSTRAINT spas_servicios_fk FOREIGN KEY ( id )
        REFERENCES servicios ( id );

ALTER TABLE tienda
    ADD CONSTRAINT tienda_servicios_fk FOREIGN KEY ( id )
        REFERENCES servicios ( id );

ALTER TABLE utensilio
    ADD CONSTRAINT utensilio_servicios_fk FOREIGN KEY ( id )
        REFERENCES servicios ( id );

-- Informe de Resumen de Oracle SQL Developer Data Modeler:
--
-- CREATE TABLE                            23
-- CREATE INDEX                             1
-- ALTER TABLE                             57
-- CREATE VIEW                              0
-- ALTER VIEW                               0
-- CREATE PACKAGE                           0
-- CREATE PACKAGE BODY                      0
-- CREATE PROCEDURE                         0
-- CREATE FUNCTION                          0
-- CREATE TRIGGER                           0
-- ALTER TRIGGER                            0
-- CREATE COLLECTION TYPE                   0
-- CREATE STRUCTURED TYPE                   0
-- CREATE STRUCTURED TYPE BODY              0
-- CREATE CLUSTER                           0
-- CREATE CONTEXT                           0
-- CREATE DATABASE                          0
-- CREATE DIMENSION                         0
-- CREATE DIRECTORY                         0
-- CREATE DISK GROUP                        0
-- CREATE ROLE                              0
-- CREATE ROLLBACK SEGMENT                  0
-- CREATE SEQUENCE                          0
-- CREATE MATERIALIZED VIEW                 0
-- CREATE MATERIALIZED VIEW LOG             0
-- CREATE SYNONYM                           0
-- CREATE TABLESPACE                        0
-- CREATE USER                              0
--
-- DROP TABLESPACE                          0
-- DROP DATABASE                            0
--
-- REDACTION POLICY                         0
-- TSDP POLICY                              0
--
-- ORDS DROP SCHEMA                         0
-- ORDS ENABLE SCHEMA                       0
-- ORDS ENABLE OBJECT                       0
--
-- ERRORS                                  15
-- WARNINGS                                 0
