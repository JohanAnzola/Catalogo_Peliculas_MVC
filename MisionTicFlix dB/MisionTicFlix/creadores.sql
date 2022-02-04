CREATE TABLE creador(
id INTEGER PRIMARY KEY AUTO_INCREMENT,
nombre VARCHAR(30),
nacionalidad VARCHAR(20),
edad INTEGER
);
INSERT INTO creador(nombre, nacionalidad, edad) 
VALUES
	("James Wan", "Australiano", 44),
	("Andrew Adamson", "Neozelandés", 54),
	("Tim Burton", "Estadounidense", 62),
	("Kevin Lima", "Estadounidense", 59),
	("Baran bo Odar", "Alemana", 43),
	("Sam Esmail", "Estadounidense", 43),
	("David Benioff", "Estadounidense", 50),
	("Ryan Murphy", "Estadounidense", 55),
	("Fernando Gaitán", "Colombiana", 58);
insert into creador(nombre, nacionalidad) values("creador nuevo holi","Bogotana")

