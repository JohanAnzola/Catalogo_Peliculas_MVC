CREATE TABLE pelicula(
id INTEGER PRIMARY KEY AUTO_INCREMENT,
producto_id INTEGER,
duracion INTEGER,
resumen TEXT,
FOREIGN KEY (producto_id) REFERENCES producto(id)
);
INSERT INTO pelicula(producto_id, duracion,resumen) VALUES
 (1,103,"Adam y Lawrence se despiertan encadenados en un baño infecto con un cadáver entre ellos. Su secuestrador es un maniaco, cuyo juego consiste en forzar a sus cautivos a herirse a sí mismos o a otros para permanecer vivos."),
 (2,95,"Un ogro llamado Shrek vive en su pantano, pero su preciada soledad se ve súbitamente interrumpida por la invasión de los ruidosos personajes de los cuentos de hadas. Todos fueron expulsados de sus reinos por el malvado Lord Farquaad. Decidido a salvar su hogar, Shrek hace un trato con Farquaad y se prepara para rescatar a la princesa Fiona, quien será la esposa de Farquaad."),
 (3,115,"Un niño pobre y cuatro jovencitos ricos ganan un paseo a la increíble empresa de un raro fabricante de dulces."),
 (4,109,"Giselle, la princesa de un cuento de hadas, es desterrada por una reina malvada y termina en el Manhattan moderno, en donde la música, la magia y los finales felices no son muy frecuentes. Giselle se siente extraña en su nuevo mundo, hasta que un abogado divorciado llega para ayudarla. Giselle empieza a enamorarse de su benefactor, pero el romance de su libro de cuentos se complica más cuando un príncipe de su mundo llega a rescatarla."),
 (5,108,"Alicia, ahora una joven de 19 años de edad, regresa al País de las Maravillas para encontrar su verdadero destino y terminar con el gobierno de terror de la malvada reina Roja.");