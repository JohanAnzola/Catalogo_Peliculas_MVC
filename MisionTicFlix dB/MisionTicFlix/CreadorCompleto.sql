DROP database MisionTicFlix_2;
CREATE SCHEMA MisionTicFlix_2;
USE MisionTicFlix_2;
CREATE TABLE creador(
	id INTEGER PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(60),
	nacionalidad VARCHAR(60),
    edad INTEGER
);
INSERT INTO creador(nombre, nacionalidad, edad) 
VALUES 
	("James Wan","Australiano", 44),
	("Andrew Adamson","Neozelandés", 54),
    ("Tim Burton","Estadounidense", 62),
    ("Kevin Lima","Estadounidense", 59),
    ("Baran bo Odar", "Alemana", 43),
    ("Sam Esmail", "Estadounidense",43),
    ("David Benioff", "Estadounidense", 50),
    ("Ryan Murphy", "Estadounidense", 55),
    ("Fernando Gaitán", "Colombiana", 58);
    
 SELECT * FROM creador;
CREATE TABLE producto(
	id INTEGER PRIMARY KEY AUTO_INCREMENT,
    creador_id INTEGER REFERENCES creador(id),
    nombre VARCHAR(60),
    anio INTEGER,
    rating double
);

-- SELECT * FROM producto;
CREATE TABLE pelicula(
    producto_id INTEGER PRIMARY KEY REFERENCES producto(id),
    duracion INTEGER,
    resumen	VARCHAR(500) 
);

INSERT INTO producto(nombre, anio, rating, creador_id) 
VALUES 
	("Saw", 2004, 7.6, 1),
    ("Shrek", 2001, 8.2, 2),
    ("Charlie y la fábrica de chocolate", 2005, 6.6, 3),
    ("Encantada", 2007, 5.6, 4),
    ("Alicia en el país de las maravillas",2010, 6, 3);
INSERT INTO pelicula(producto_id, duracion, resumen) 
VALUES 
	(1, 103,"Adam y Lawrence se despiertan encadenados en un baño infecto con un cadáver entre ellos. Su secuestrador es un maniaco, cuyo juego consiste en forzar a sus cautivos a herirse a sí mismos o a otros para permanecer vivos."),
    (2, 95, "Un ogro llamado Shrek vive en su pantano, pero su preciada soledad se ve súbitamente interrumpida por la invasión de los ruidosos personajes de los cuentos de hadas. Todos fueron expulsados de sus reinos por el malvado Lord Farquaad. Decidido a salvar su hogar, Shrek hace un trato con Farquaad y se prepara para rescatar a la princesa Fiona, quien será la esposa de Farquaad."),
    (3, 115, "Un niño pobre y cuatro jovencitos ricos ganan un paseo a la increíble empresa de un raro fabricante de dulces."),
    (4, 109, "Giselle, la princesa de un cuento de hadas, es desterrada por una reina malvada y termina en el Manhattan moderno, en donde la música, la magia y los finales felices no son muy frecuentes. Giselle se siente extraña en su nuevo mundo, hasta que un abogado divorciado llega para ayudarla. Giselle empieza a enamorarse de su benefactor, pero el romance de su libro de cuentos se complica más cuando un príncipe de su mundo llega a rescatarla."),
    (5, 108,"Alicia, ahora una joven de 19 años de edad, regresa al País de las Maravillas para encontrar su verdadero destino y terminar con el gobierno de terror de la malvada reina Roja.");
    
    -- SELECT producto.id,producto.nombre,ano,rating,duracion, creador.id,creador.nombre, resumen 
#		FROM producto join pelicula join creador 
#        on (producto.id = producto_id and creador_id = creador.id);
CREATE TABLE serie(
    producto_id INTEGER PRIMARY KEY REFERENCES producto(id),
    temporadas INTEGER,
    episodios INTEGER
);
INSERT INTO producto(nombre, anio, rating, creador_id) 
VALUES 
	("Dark", 2017, 8.8, 5),
    ("Mr Robot", 2015, 8.5, 6),
    ("Game of Thrones", 2011, 9.2, 7),
    ("American Horror Story", 2011, 8, 8),
    ("Yo soy Betty, la fea", 1999, 8, 9);
INSERT INTO serie(producto_id, temporadas, episodios) 
VALUES 
	(6, 3, 26),
    (7, 4, 45),
    (8, 8, 73),
    (9, 9, 103),
    (10, 1, 335);
 
 CREATE TABLE usuario(
	alias VARCHAR(20) PRIMARY KEY,
	nombre VARCHAR(20),
	apellido VARCHAR(20),
	contraseña VARCHAR(10),
	documento INTEGER,
	tipo_de_documento ENUM("CC", "CE", "TI")
);
INSERT INTO usuario VALUES 
	("bsgarciac","Brayan","García","12345678",10000001,"CC"),
	("sebascrack88","Sebastian","Molina","abcd1234",123014510,"CC"),
	("dianasofia1","Diana","Cardenas","password",3245142,"TI"),
	("jesslyz","Jessica","Guzman","jessguz1",12478412,"CC"),
	("walterxd","Walter","Black","anything32",11243412,"CE"),
	("chikisasori","Juan","Solano","135478632",135478632,"CC");
 
 CREATE TABLE comentario(
	id INTEGER PRIMARY KEY AUTO_INCREMENT,
    usuario_alias VARCHAR(20) REFERENCES usuario(alias),
    producto_id INTEGER REFERENCES producto(id),
    opinion VARCHAR(100)
);
INSERT INTO comentario(usuario_alias, producto_id, opinion) VALUES
	("chikisasori",10,"Muy buena novela, me ha cambiado la vida"),
	("dianasofia1",4,"La he visto 5 veces, ya me sé todas las canciones"),
	("walterxd",3,"Yo creo que Willy Wonka tenía planeado todo desde el principio"),
	("walterxd",1,"Pensé que era una película para niños…"),
	("bsgarciac",2,"Shrek 2 es mejor"),
	("jesslyz",9,"La cuarta temporada es la mejor, Freak Show <3"),
	("sebascrack88",9,"Respeto tu opinión, pero la mejor temporada es la segunda xd"),
	("walterxd",8,"No me gustó el final"),
	("sebascrack88",8,"A mí tampoco me gustó uwu"),
	("dianasofia1",6,"Esta serie me motivó a tomar el curso de MisionTic");