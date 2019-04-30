CREATE TABLE cidade (
id INT NOT NULL, 
nome VARCHAR (255) NOT NULL,
estado VARCHAR (255) NOT NULL,
pais VARCHAR (255) NOT NULL,
populacao INT NOT NULL,
PRIMARY KEY(id)
);
SELECT * FROM cidade

CREATE TABLE contabancaria (
id_cb INT NOT NULL,
nome_titular VARCHAR(255) NOT NULL,
saldo INT NOT NULL,
numero_agencia INT NOT NULL,
PRIMARY KEY(id_cb)
);
SELECT * FROM contabancaria

