CREATE TABLE `documentosalumnos` (
  `id` int NOT NULL AUTO_INCREMENT,
  `numPaginas` int NOT NULL,
  `dni` varchar(45) NOT NULL,
  `nombre` varchar(45) NOT NULL,
  `apellido1` varchar(45) NOT NULL,
  `apellido2` varchar(45) NOT NULL,
  `curso` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `dni_UNIQUE` (`dni`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `documentosprofesores` (
  `id` int NOT NULL AUTO_INCREMENT,
  `numPaginas` int NOT NULL,
  `dni` varchar(45) NOT NULL,
  `nombre` varchar(45) NOT NULL,
  `apellido1` varchar(45) NOT NULL,
  `apellido2` varchar(45) NOT NULL,
  `dpto` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `dni_UNIQUE` (`dni`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `historialalumnos` (
  `id` int NOT NULL AUTO_INCREMENT,
  `numPaginas` int NOT NULL,
  `dni` varchar(45) NOT NULL,
  `nombre` varchar(45) NOT NULL,
  `apellido1` varchar(45) NOT NULL,
  `apellido2` varchar(45) NOT NULL,
  `curso` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `historialprofesores` (
  `id` int NOT NULL AUTO_INCREMENT,
  `numPaginas` int NOT NULL,
  `dni` varchar(45) NOT NULL,
  `nombre` varchar(45) NOT NULL,
  `apellido1` varchar(45) NOT NULL,
  `apellido2` varchar(45) NOT NULL,
  `dpto` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

insert into documentosalumnos (id, numPaginas, dni, nombre, apellido1, apellido2, curso) 
values
(1,25,"12345678J","Jaime","Garcia","Jimenez","PRIMERODAM"),
(2,35,"12345678A","Anabel","Sanchez","Diaz","PRIMEROESO"),
(3,10,"123456778G","Gabriel","Gonzalez","Hernandez","SEGUNDOBACH"),
(4,15,"12234567K","Beatriz","Blanco","Caballero","PRIMEROBACH"),
(5,30,"12334567C","Carla","Dominguez","Sanchez","CUARTOESO");

insert into documentosprofesores (id, numPaginas, dni, nombre, apellido1, apellido2, dpto) 
values
(1,15,"123455678P","Manuel","Gallego","Morales","MUSICA"),
(2,20,"123345678Y","Yaiza","Garcia","Trujillo","FISICA"),
(3,20,"11234567H","Hugo","Sanchez","Herrera","INGLES"),
(4,25,"13325647J","Jose","Barea","Prieto","TECNOLOGIA");