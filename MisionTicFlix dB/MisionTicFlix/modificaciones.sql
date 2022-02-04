UPDATE producto SET rating = 9.2 WHERE id = 6;
UPDATE usuario SET contraseña = 87654321 WHERE alias = "bsgarciac";
DELETE FROM comentario WHERE usuario_alias LIKE "walterxd" AND producto_id = 3;