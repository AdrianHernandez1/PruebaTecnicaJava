CREATE DATABASE BD_Productos;
USE BD_Productos;

CREATE TABLE Productos(
	idProducto INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(250) NOT NULL,
    descripccion VARCHAR(250),
    precio DECIMAL(16,2) NOT NULL,
    cantidad INT NOT NULL,
    estatus INT NOT NULL
);

CREATE TABLE Rol(
	idRol INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    rol VARCHAR(250) NOT NULL,
    estatus INT NOT NULL
); 

CREATE TABLE Usuarios(
	idUsuario INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(250) NOT NULL,
    apellido_paterno VARCHAR(250) NOT NULL,
    apellido_materno VARCHAR(250) ,
    usuario VARCHAR(250) NOT NULL,
    contrasenia VARCHAR(250) NOT NULL,
    estatus INT NOT NULL
);


CREATE TABLE Permisos(
    idPermiso INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	idRol INT NOT NULL,
	idUsuario INT NOT NULL,
	FOREIGN KEY (idRol) REFERENCES Rol(idRol),
    FOREIGN KEY (idUsuario) REFERENCES Usuarios(idUsuario)
);

CREATE TABLE Movimientos(
    idMovimiento INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    estatus_entrada_salida INT NOT NULL,
    fecha_hora TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    idUsuario INT NOT NULL,
    FOREIGN KEY (idUsuario) REFERENCES Usuarios(idUsuario)
);

INSERT INTO usuario VALUES("ADMINISTRADOR","","","administrador@gmail.com","123456",1);
