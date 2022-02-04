CREATE TABLE producto(
id INTEGER PRIMARY KEY AUTO_INCREMENT,
creador_id INTEGER,
nombre VARCHAR(40),
año INTEGER,
rating FLOAT,
FOREIGN KEY (creador_id) REFERENCES creador(id)
);
INSERT INTO producto(creador_id, nombre, año, rating) VALUES
 (1,"Saw", 2004, 7.6),
 (2,"Shrek", 2001, 8.2),
 (3,"Charlie y la fábrica de chocolate", 2005, 6.6),
 (4,"Encantada", 2007, 5.6),
 (3,"Alicia en el país de las maravillas", 2010, 6),
 (5,"Dark", 2017, 8.8),
 (6,"Mr Robot", 2015, 8.5),
 (7,"Game of Thrones", 2011, 9.2),
 (8,"American Horror Story", 2011, 8),
 (9,"Yo soy Betty, la fea", 1999, 8.2);






