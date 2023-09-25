CREATE TABLE cuentas (
                         habitacion_numero NUMBER NOT NULL,
                         hotel_nit         NUMBER NOT NULL,
                         servicio_id       NUMBER NOT NULL
);

ALTER TABLE cuentas ADD CONSTRAINT cuentas_pk PRIMARY KEY ( habitacion_numero,
                                                            hotel_nit );

CREATE TABLE habitaciones (
                              numero     NUMBER NOT NULL,
                              disponible VARCHAR2(15),
                              hotel_nit  NUMBER NOT NULL,
                              reserva_id NUMBER NOT NULL
);

ALTER TABLE habitaciones
    ADD CHECK ( disponible IN ( 'NO', 'SI' ) );

ALTER TABLE habitaciones ADD CONSTRAINT habitaciones_pk PRIMARY KEY ( numero,
                                                                      hotel_nit );

CREATE TABLE hoteles (
                         nombre VARCHAR2(50),
                         nit    NUMBER NOT NULL
);

ALTER TABLE hoteles ADD CONSTRAINT hoteles_pk PRIMARY KEY ( nit );

CREATE TABLE ocupadas (
                          habitacion_numero        NUMBER NOT NULL,
                          hotel_nit                NUMBER NOT NULL,
                          usuario_numero_documento VARCHAR2(25) NOT NULL
);

ALTER TABLE ocupadas
    ADD CONSTRAINT ocupadas_pk PRIMARY KEY ( habitacion_numero,
                                             hotel_nit,
                                             usuario_numero_documento );

CREATE TABLE planes_consumo (
                                nombre          VARCHAR2(50),
                                plan_consumo_id NUMBER NOT NULL,
                                hotel_nit       NUMBER NOT NULL
);

ALTER TABLE planes_consumo ADD CONSTRAINT planes_consumo_pk PRIMARY KEY ( plan_consumo_id );

ALTER TABLE planes_consumo ADD CONSTRAINT planes_consumo_nit_un UNIQUE ( hotel_nit );

CREATE TABLE reservas (
                          id            NUMBER NOT NULL,
                          hora_reserva  VARCHAR2(50),
                          fecha_inicial DATE,
                          fecha_final   DATE
);

ALTER TABLE reservas ADD CONSTRAINT reservas_pk PRIMARY KEY ( id );

CREATE TABLE servicios (
                           id                       NUMBER NOT NULL,
                           horario_servicio_inicial VARCHAR2(50),
                           horario_servicio_final   VARCHAR2(50),
                           tipo_servicio_id         NUMBER NOT NULL,
                           reserva_id               NUMBER NOT NULL
);

ALTER TABLE servicios ADD CONSTRAINT servicios_pk PRIMARY KEY ( id );

CREATE TABLE tipos_habitaciones (
                                    tipo      VARCHAR2(55),
                                    capacidad VARCHAR2(15),
                                    hotel_nit NUMBER NOT NULL
);

ALTER TABLE tipos_habitaciones
    ADD CHECK ( tipo IN ( 'LARGA_ESTADIA', 'PROMOCION', 'TIEMPO_COMPARTIDO', 'TODO_INCLUIDO' ) );

ALTER TABLE tipos_habitaciones ADD CONSTRAINT tipos_habitaciones_pk PRIMARY KEY ( hotel_nit );

CREATE TABLE tipos_servicios (
                                 id     NUMBER NOT NULL,
                                 nombre VARCHAR2(50)
);

ALTER TABLE tipos_servicios ADD CONSTRAINT tipos_servicios_pk PRIMARY KEY ( id );

CREATE TABLE usuarios (
                          nombre           VARCHAR2(50),
                          tipo_documento   VARCHAR2(25),
                          numero_documento VARCHAR2(25) NOT NULL,
                          rol              VARCHAR2(25),
                          correo           VARCHAR2(30)
);

ALTER TABLE usuarios
    ADD CHECK ( tipo_documento IN ( 'CC', 'CE', 'NIT', 'PASAPORTE' ) );

ALTER TABLE usuarios
    ADD CHECK ( rol IN ( 'ADMINISTRADOR', 'CLIENTE', 'EMPLEADO', 'GERENTE', 'RECEPCIONISTA' ) );

ALTER TABLE usuarios ADD CONSTRAINT usuarios_pk PRIMARY KEY ( numero_documento );

ALTER TABLE cuentas
    ADD CONSTRAINT cuentas_habitaciones_fk FOREIGN KEY ( habitacion_numero,
                                                         hotel_nit )
        REFERENCES habitaciones ( numero,
                                  hotel_nit );

ALTER TABLE cuentas
    ADD CONSTRAINT cuentas_servicios_fk FOREIGN KEY ( servicio_id )
        REFERENCES servicios ( id );

ALTER TABLE habitaciones
    ADD CONSTRAINT habitaciones_hoteles_fk FOREIGN KEY ( hotel_nit )
        REFERENCES hoteles ( nit );

ALTER TABLE habitaciones
    ADD CONSTRAINT habitaciones_reservas_fk FOREIGN KEY ( reserva_id )
        REFERENCES reservas ( id );

ALTER TABLE ocupadas
    ADD CONSTRAINT ocupadas_habitaciones_fk FOREIGN KEY ( habitacion_numero,
                                                          hotel_nit )
        REFERENCES habitaciones ( numero,
                                  hotel_nit );

ALTER TABLE ocupadas
    ADD CONSTRAINT ocupadas_usuarios_fk FOREIGN KEY ( usuario_numero_documento )
        REFERENCES usuarios ( numero_documento );

ALTER TABLE planes_consumo
    ADD CONSTRAINT planes_consumo_hoteles_fk FOREIGN KEY ( hotel_nit )
        REFERENCES hoteles ( nit );

ALTER TABLE servicios
    ADD CONSTRAINT servicios_reservas_fk FOREIGN KEY ( reserva_id )
        REFERENCES reservas ( id );

ALTER TABLE servicios
    ADD CONSTRAINT servicios_tipos_servicios_fk FOREIGN KEY ( tipo_servicio_id )
        REFERENCES tipos_servicios ( id );

ALTER TABLE tipos_habitaciones
    ADD CONSTRAINT tipos_habitaciones_hoteles_fk FOREIGN KEY ( hotel_nit )
        REFERENCES hoteles ( nit );