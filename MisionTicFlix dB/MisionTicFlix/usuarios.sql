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

