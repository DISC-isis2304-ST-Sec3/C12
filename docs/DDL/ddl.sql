
CREATE TABLE bares (
    id                     NUMBER NOT NULL,
    estilo                 VARCHAR2(50) NOT NULL,
    productos_productos_id NUMBER NOT NULL
);

ALTER TABLE bares
    ADD CHECK ( estilo IN ( 'Frances', 'Italiano', 'Mediterraneo', 'Mexicano', 'Oriental' ) );

ALTER TABLE bares ADD CONSTRAINT bar_restaurantes_pk PRIMARY KEY ( id );

CREATE TABLE conferencias (
    capacidad NUMBER NOT NULL,
    fecha     DATE,
    hora      DATE NOT NULL,
    duracion  NUMBER NOT NULL,
    id        NUMBER NOT NULL
);

ALTER TABLE conferencias ADD CONSTRAINT conferencias_pk PRIMARY KEY ( id );

CREATE TABLE cuentas (
    habitaciones_numero NUMBER NOT NULL,
    servicios_id        NUMBER NOT NULL
);

ALTER TABLE cuentas ADD CONSTRAINT cuentas_pk PRIMARY KEY ( habitaciones_numero,
                                                            servicios_id );

CREATE TABLE gimnasios (
    id        NUMBER NOT NULL,
    capacidad NUMBER NOT NULL,
    maquinas  VARCHAR2(255) NOT NULL
);

ALTER TABLE gimnasios ADD CONSTRAINT gimnasio_pk PRIMARY KEY ( id );

CREATE TABLE habitaciones (
    numero                NUMBER NOT NULL,
    disponible            VARCHAR2(5) NOT NULL,
    precionoche           NUMBER NOT NULL,
    hoteles_id            NUMBER NOT NULL,
    tipos_habitaciones_id NUMBER NOT NULL,
    reservas_id           NUMBER NOT NULL
);

ALTER TABLE habitaciones
    ADD CHECK ( disponible IN ( 'NO', 'SI' ) );

CREATE UNIQUE INDEX habitaciones__idx ON
    habitaciones (
        reservas_id
    ASC );

ALTER TABLE habitaciones ADD CONSTRAINT habitaciones_pk PRIMARY KEY ( numero );

CREATE TABLE hoteles (
    nombre VARCHAR2(50) NOT NULL,
    nit    NUMBER NOT NULL,
    id     NUMBER NOT NULL
);

ALTER TABLE hoteles ADD CONSTRAINT hoteles_pk PRIMARY KEY ( id );

CREATE TABLE internet (
    anchobanda FLOAT NOT NULL,
    id         NUMBER NOT NULL
);

ALTER TABLE internet ADD CONSTRAINT internet_pk PRIMARY KEY ( id );

CREATE TABLE ocupadas (
    habitaciones_numero NUMBER NOT NULL,
    usuarios_id         NUMBER NOT NULL
);

ALTER TABLE ocupadas ADD CONSTRAINT ocupadas_pk PRIMARY KEY ( habitaciones_numero,
                                                              usuarios_id );

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
    hoteles_id NUMBER NOT NULL
);

ALTER TABLE planes_consumo
    ADD CHECK ( tipoplan IN ( 'Larga_Estadia', 'Promo_Particular', 'Tiempo_Compartido', 'Todo_Incluido' ) );

ALTER TABLE planes_consumo ADD CONSTRAINT planes_consumo_pk PRIMARY KEY ( id );

CREATE TABLE productos (
    id              NUMBER NOT NULL,
    nombre          VARCHAR2(100) NOT NULL,
    precio          NUMBER NOT NULL,
    restaurantes_id NUMBER NOT NULL,
    bares_id        NUMBER NOT NULL,
    tiendas_id      NUMBER NOT NULL
);

ALTER TABLE productos ADD CONSTRAINT productos_nombre_un PRIMARY KEY ( nombre );

ALTER TABLE productos ADD CONSTRAINT productos_pk UNIQUE ( id );

CREATE TABLE reservas (
    hora_reserva  DATE,
    fecha_inicial DATE NOT NULL,
    fecha_final   DATE NOT NULL,
    acompañantes  NUMBER NOT NULL,
    id            NUMBER NOT NULL
);

ALTER TABLE reservas ADD CONSTRAINT reservas_pk PRIMARY KEY ( id );

CREATE TABLE restaurantes (
    id                     NUMBER NOT NULL,
    estilo                 VARCHAR2(50) NOT NULL,
    productos_productos_id NUMBER NOT NULL
);

ALTER TABLE restaurantes ADD CONSTRAINT restaurante_pk PRIMARY KEY ( id );

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
    horarioinicial DATE,
    horariofinal   DATE,
    nombre         VARCHAR2(63) NOT NULL,
    costo          NUMBER NOT NULL,
    cargado        VARCHAR2(2) NOT NULL,
    existe         VARCHAR2(2) NOT NULL,
    id             NUMBER NOT NULL,
    reservas_id    NUMBER NOT NULL
);

ALTER TABLE servicios
    ADD CHECK ( cargado IN ( 'NO', 'SI' ) );

ALTER TABLE servicios
    ADD CHECK ( existe IN ( 'NO', 'SI' ) );

ALTER TABLE servicios ADD CONSTRAINT servicios_pk PRIMARY KEY ( id );

CREATE TABLE serviciospas (
    id       NUMBER NOT NULL,
    duración NUMBER NOT NULL,
    costo    NUMBER NOT NULL,
    fecha    DATE NOT NULL,
    spas_id  NUMBER NOT NULL
);

ALTER TABLE serviciospas ADD CONSTRAINT serviciospas_pk PRIMARY KEY ( id );

CREATE TABLE spas (
    capacidad NUMBER NOT NULL,
    id        NUMBER NOT NULL
);

ALTER TABLE spas ADD CONSTRAINT spas_pk PRIMARY KEY ( id );

CREATE TABLE tiendas (
    id                     NUMBER NOT NULL,
    tipo                   VARCHAR2(40) NOT NULL,
    productos_productos_id NUMBER NOT NULL
);

ALTER TABLE tiendas
    ADD CHECK ( tipo IN ( 'Joyeria', 'Moda', 'Souvenirs', 'Supermercado' ) );

ALTER TABLE tiendas ADD CONSTRAINT tienda_pk PRIMARY KEY ( id );

CREATE TABLE tipos_habitaciones (
    tipo      VARCHAR2(55) NOT NULL,
    capacidad NUMBER NOT NULL,
    dotacion  VARCHAR2(255) NOT NULL,
    id        NUMBER NOT NULL
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

CREATE TABLE utensilios (
    devuelto VARCHAR2(2) NOT NULL,
    estado   VARCHAR2(255) NOT NULL,
    id       NUMBER NOT NULL
);

ALTER TABLE utensilios
    ADD CHECK ( devuelto IN ( 'NO', 'SI' ) );

ALTER TABLE utensilios ADD CONSTRAINT utensilio_pk PRIMARY KEY ( id );

ALTER TABLE bares
    ADD CONSTRAINT bar_restaurantes_servicios_fk FOREIGN KEY ( id )
        REFERENCES servicios ( id );

ALTER TABLE conferencias
    ADD CONSTRAINT conferencias_servicios_fk FOREIGN KEY ( id )
        REFERENCES servicios ( id );

ALTER TABLE cuentas
    ADD CONSTRAINT cuentas_habitaciones_fk FOREIGN KEY ( habitaciones_numero )
        REFERENCES habitaciones ( numero );

ALTER TABLE cuentas
    ADD CONSTRAINT cuentas_servicios_fk FOREIGN KEY ( servicios_id )
        REFERENCES servicios ( id );

ALTER TABLE gimnasios
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
    ADD CONSTRAINT ocupadas_habitaciones_fk FOREIGN KEY ( habitaciones_numero )
        REFERENCES habitaciones ( numero );

ALTER TABLE ocupadas
    ADD CONSTRAINT ocupadas_usuarios_fk FOREIGN KEY ( usuarios_id )
        REFERENCES usuarios ( id );

ALTER TABLE piscinas
    ADD CONSTRAINT piscinas_servicios_fk FOREIGN KEY ( id )
        REFERENCES servicios ( id );

ALTER TABLE planes_consumo
    ADD CONSTRAINT planes_consumo_hoteles_fk FOREIGN KEY ( hoteles_id )
        REFERENCES hoteles ( id );

ALTER TABLE productos
    ADD CONSTRAINT productos_bares_fk FOREIGN KEY ( bares_id )
        REFERENCES bares ( id );

ALTER TABLE productos
    ADD CONSTRAINT productos_restaurantes_fk FOREIGN KEY ( restaurantes_id )
        REFERENCES restaurantes ( id );

ALTER TABLE productos
    ADD CONSTRAINT productos_tiendas_fk FOREIGN KEY ( tiendas_id )
        REFERENCES tiendas ( id );

ALTER TABLE restaurantes
    ADD CONSTRAINT restaurante_servicios_fk FOREIGN KEY ( id )
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

ALTER TABLE tiendas
    ADD CONSTRAINT tienda_servicios_fk FOREIGN KEY ( id )
        REFERENCES servicios ( id );

ALTER TABLE utensilios
    ADD CONSTRAINT utensilio_servicios_fk FOREIGN KEY ( id )
        REFERENCES servicios ( id );

CREATE SEQUENCE productos_id_seq START WITH 1 NOCACHE ORDER;

CREATE OR REPLACE TRIGGER productos_id_trg BEFORE
    INSERT ON productos
    FOR EACH ROW
    WHEN ( new.id IS NULL )
BEGIN
    :new.id := productos_id_seq.nextval;
END;
/
