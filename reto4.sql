CREATE TABLE PROVEEDOR (
    PROV_ID  INT PRIMARY KEY,
    PROV_NOMBRE  CHAR(20),
    PROV_DIRECCION CHAR(45),
    PROV_TELEFONO CHAR(11)
);
INSERT INTO PROVEEDOR VALUES (101, "Auteco","calle 7 No. 45-17", "05713224459");
INSERT INTO PROVEEDOR VALUES (102, "Hitachi", "calle 19 No. 108-26", "05714223344");
INSERT INTO PROVEEDOR VALUES (103, "Bosch", "carrera 68 No. 26-45", "05715678798");
INSERT INTO PROVEEDOR VALUES (104, "Teco", "calle 77 No. 68-33", "05712213243");
INSERT INTO PROVEEDOR VALUES (105, "General Electric", "calle 29 No. 26-12", "05717239919");

CREATE TABLE MOTOCICLETAS_ELECTRICAS (
    ID_MOTOCICLETAS INT(9) PRIMARY KEY,
    NOMBRE_FABRICANTE CHAR(40) NOT NULL,
    PRECIO_UNITARIO INT(15) NOT NULL,
    AUTONOMIA_BATERIA VARCHAR(10) NOT NULL,
    PROVEEDORES_ID INT(15) NOT NULL,
    FOREIGN KEY (PROVEEDORES_ID) REFERENCES proveedor (prov_id)   
);

INSERT INTO MOTOCICLETAS_ELECTRICAS (ID_MOTOCICLETAS,NOMBRE_FABRICANTE,PRECIO_UNITARIO,AUTONOMIA_BATERIA,PROVEEDORES_ID) VALUES
(2001, 'Starker', 4200000, 18, 101),
(2002, 'Lucky Lion', 5600000, 14, 102),
(2003, 'Be Electric', 4600000, 26, 101),
(2004, 'Aima', 8000000, 36, 103),
(2005, 'Mec de Colombia', 5900000, 20, 104),
(2006, 'Atom Electric', 4500000, 12, 105);

CREATE TABLE FABRICANTE (
	FABRICANTES VARCHAR(20)  primary key NOT NULL
);
    
INSERT INTO FABRICANTE (FABRICANTES) VALUES 
('Cannondale'),
('Trek'),
('Starker'),
('Yeti'),
('Fuji'),
('Lucky Lion'),
('Be Electric'),
('Aima'),
('Mec de Colombia'),
('Atom Electric'),
('Bmc');

CREATE TABLE BICICLETAS (
    ID_BICICLETAS INT(9) PRIMARY KEY NOT NULL, 
	NOMBRE_FABRICANTE VARCHAR(50) NOT NULL,
	PRECIO_UNITARIO INT(9) NOT NULL,
	ANIO_CONSTRUCCION INT(4) NOT NULL 
);
INSERT INTO BICICLETAS VALUES (1001,'Cannondale', 1200000, 2020);
INSERT INTO BICICLETAS VALUES (1002,'Trek', 1450000, 2019);
INSERT INTO BICICLETAS VALUES (1003,'Yeti', 2000000, 2020);
INSERT INTO BICICLETAS VALUES (1004,'Fuji', 950000, 2021);
INSERT INTO BICICLETAS VALUES (1005,'Bmc', 1950000, 1018);

CREATE TABLE CLIENTES (
	ALIAS VARCHAR(15) PRIMARY KEY NOT NULL,
	NOMBRES VARCHAR(50) NOT NULL,
	APELLIDOS VARCHAR(50) NOT NULL,
	EMAIL VARCHAR(40) NOT NULL,
	CELULAR VARCHAR(15) NOT NULL,
	CONTRASENIA INT(8) NOT NULL,
	FECHA_NACIMIENTO DATE NOT NULL
);
INSERT INTO CLIENTES (ALIAS, NOMBRES, APELLIDOS, EMAIL, CELULAR, CONTRASENIA, FECHA_NACIMIENTO) VALUES
('lucky', 'Pedro', 'Perez', 'lucky@gmail.com','3204563520', '11111111','2000-01-01'),
('malopez', 'Maria', 'Lopez', 'malopez@gmail.com','3204563520', '11111111','2000-01-01'),
('diva', 'Ana', 'Diaz', 'diva@gmail.com','3204563520', '11111111','2000-01-01'),
('dreamer', 'Luis', 'Rojas', 'dreamer@gmail.com','3204563520', '11111111','2000-01-01'),
('ninja', 'Andres', 'Cruz', 'ninja@gmail.com','3204563520', '11111111','2000-01-01'),
('neon', 'Nelson', 'Ruiz', 'neon@gmail.com','3204563520', '11111111','2000-01-01'),
('rose', 'Claudia', 'Mendez', 'rose@gmail.com','3204563520', '11111111','2000-01-01'),
('green', 'Jorge', 'Rodriguez', 'green@gmail.com','3204563520', '11111111','2000-01-01');

CREATE TABLE REGISTRO (
	ID_REGISTRO INT(9) PRIMARY KEY,
    NOMBRE_REGISTRO VARCHAR(15) NOT NULL,
    MARCA_REGISTRO VARCHAR(20) NOT NULL,
    FECHA_HORA TIMESTAMP NOT NULL,
    FOREIGN KEY (NOMBRE_REGISTRO) REFERENCES clientes(ALIAS),
    FOREIGN KEY (MARCA_REGISTRO) REFERENCES fabricante(FABRICANTES)
    );
INSERT INTO REGISTRO (ID_REGISTRO, NOMBRE_REGISTRO, MARCA_REGISTRO, FECHA_HORA) VALUES
(4001, "lucky" , "Cannondale" , '2017-10-25 20:00:00'),
(4002, "lucky" , "Trek" , '2019-03-15 18:30:00'),
(4003, "lucky" , "Starker" , '2019-05-20 20:30:00'),
(4004, "malopez" , "Cannondale" , '2018-05-20 20:30:00'),
(4005, "malopez" , "Starker" , '2020-01-20 20:30:00'),
(4006, "diva" , "Yeti" , '2019-05-20 20:30:00'),
(4007, "diva" , "Fuji" , '2018-06-22 21:30:00'),
(4008, "diva" , "Lucky Lion" , '2020-03-17 15:30:20'),
(4009, "dreamer" , "Lucky Lion" , '2020-03-17 15:30:20'),
(4010, "dreamer",  "Be Electric" , '2020-04-10 18:30:20'),
(4011, "ninja", "Aima" , '2020-02-17 20:30:20'),
(4012, "ninja" , "Starker" , '2020-02-20 16:30:20'),
(4013, "ninja" , "Mec de Colombia" , '2020-03-27 18:30:20'),
(4014, "rose",  "Atom Electric" , '2020-03-20 21:30:20'),
(4015, "green" , "Yeti" , '2020-01-10 17:30:20'),
(4016, "green" , "Trek" , '2020-02-15 20:30:20'),
(4017, "green" , "Bmc" , '2020-03-17 18:30:20');

update bicicletas set ANIO_CONSTRUCCION = 2017, NOMBRE_FABRICANTE = "Cannodale" where ID_BICICLETAS = 1001;
update clientes set CELULAR = 3115678432 where ALIAS = "ninja";
delete from registro  where NOMBRE_REGISTRO = "green" and MARCA_REGISTRO = "Trek";

Select "Consulta 1";
Select * from fabricante order by FABRICANTES;
Select "Consulta 2";
Select NOMBRE_FABRICANTE, PRECIO_UNITARIO, ANIO_CONSTRUCCION from bicicletas where ANIO_CONSTRUCCION >= 2019 order by NOMBRE_FABRICANTE;
Select "Consulta 3";
Select NOMBRE_FABRICANTE from motocicletas_electricas where PROVEEDORES_ID = 101;
Select "Consulta 4";
Select MARCA_REGISTRO from registro where NOMBRE_REGISTRO = "lucky" order by MARCA_REGISTRO;
Select "Consulta 5";
Select ALIAS, NOMBRES, APELLIDOS from clientes inner join registro on NOMBRE_REGISTRO = ALIAS where MARCA_REGISTRO = "Yeti";
Select "Consulta 6";
Select count(ID_BICICLETAS) AS CUENTA from bicicletas where ANIO_CONSTRUCCION >= 2019;
