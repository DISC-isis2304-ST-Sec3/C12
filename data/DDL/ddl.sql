CREATE TABLE USUARIOS (
    ID NUMBER NOT NULL,
    NOMBRE VARCHAR2(50) NOT NULL,
    TIPODOCUMENTO VARCHAR2(50) NOT NULL,
    NUMERODOCUMENTO VARCHAR2(50) NOT NULL,
    ROL VARCHAR2(50) NOT NULL,
    CORREO VARCHAR2(50) NOT NULL,

    CONSTRAINT PK_USUARIOS PRIMARY KEY (ID),
    CONSTRAINT CK_TIPODOCUMENTO CHECK (TIPODOCUMENTO IN ('CC', 'CE', 'TI', 'PASAPORTE')),
    CONSTRAINT CK_ROL CHECK (ROL IN ('ADMINISTRADOR', 'USUARIO'))
)

INSERT INTO USUARIOS (ID, NOMBRE, TIPODOCUMENTO, NUMERODOCUMENTO, ROL, CORREO) VALUES (1, 'Juan', 'CC', '123456789', 'ADMINISTRADOR', '123@123');