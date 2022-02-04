CREATE TABLE comentario(
id INTEGER PRIMARY KEY AUTO_INCREMENT,
usuario_alias VARCHAR(20),
producto_id INTEGER,
opinion TEXT,
FOREIGN KEY (usuario_alias) REFERENCES usuario(alias), 
FOREIGN KEY (producto_id) REFERENCES producto(id)
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