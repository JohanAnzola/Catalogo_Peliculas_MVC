SELECT "Consulta 1";
SELECT nombre FROM usuario ORDER BY nombre;
SELECT "Consulta 2";
SELECT nombre, temporadas, rating FROM producto JOIN serie ON (producto.id = serie.producto_id) WHERE rating > 9;
SELECT "Consulta 3";
SELECT producto.nombre FROM creador JOIN producto JOIN pelicula ON (creador.id = producto.creador_id) AND (producto.id = pelicula.producto_id)
WHERE creador.nombre LIKE "Tim Burton" ORDER BY duracion;
SELECT "Consulta 4";
SELECT producto.nombre FROM producto JOIN comentario ON (producto.id = comentario.producto_id) WHERE usuario_alias LIKE "walterxd" ORDER BY rating;
SELECT "Consulta 5";
SELECT opinion FROM producto JOIN serie JOIN comentario ON (producto.id = serie.producto_id) AND (serie.producto_id= comentario.producto_id) WHERE nombre LIKE "American Horror Story";
SELECT "Consulta 6";
SELECT count(*) FROM producto JOIN serie ON (producto.id = serie.producto_id) WHERE rating > 8.5;