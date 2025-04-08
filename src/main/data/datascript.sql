CREATE DATABASE IF NOT EXISTS exam_gestion_entreprise;
USE exam_gestion_entreprise;

CREATE TABLE prevision (
    id INT AUTO_INCREMENT PRIMARY KEY,
    libelle VARCHAR(100) NOT NULL,
    montant DECIMAL(15,2) DEFAULT 0.00,
    date_prevision DATETIME DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE depense (
    id INT AUTO_INCREMENT PRIMARY KEY,
    id_prevision INT NOT NULL,
    montant DECIMAL(15,2) DEFAULT 0.00,
    date_depense DATETIME DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (id_prevision) REFERENCES prevision(id)
);

CREATE TABLE users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL
);

INSERT INTO users (username, password) 
VALUES ('max', 'mdp123');
