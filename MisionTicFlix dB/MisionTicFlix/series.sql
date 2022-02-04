CREATE TABLE serie(
id INTEGER PRIMARY KEY AUTO_INCREMENT,
producto_id INTEGER,
temporadas INTEGER,
episodios INTEGER,
FOREIGN KEY (producto_id) REFERENCES producto(id)
);
INSERT INTO serie(producto_id, temporadas, episodios) VALUES
 (6, 3, 26),
 (7, 4, 45),
 (8, 8, 73),
 (9, 9, 103),
 (10, 1, 335);
