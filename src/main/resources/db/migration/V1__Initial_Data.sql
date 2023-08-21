-- Create the Medicos table if it doesn't exist
CREATE TABLE IF NOT EXISTS Medicos (
    id INT AUTO_INCREMENT PRIMARY KEY,
    ativo BOOLEAN,
    crm VARCHAR(255),
    email VARCHAR(255),
    nome VARCHAR(255),
    telefone VARCHAR(255),
    especialidade VARCHAR(255),
    bairro VARCHAR(255),
    cep VARCHAR(255),
    cidade VARCHAR(255),
    complemento VARCHAR(255),
    logradouro VARCHAR(255),
    numero VARCHAR(255),
    uf VARCHAR(255)
);

-- Create the Pacientes table if it doesn't exist
CREATE TABLE IF NOT EXISTS Pacientes (
    id INT AUTO_INCREMENT PRIMARY KEY,
    ativo BOOLEAN,
    cpf VARCHAR(255),
    email VARCHAR(255),
    nome VARCHAR(255),
    telefone VARCHAR(255),
    bairro VARCHAR(255),
    cep VARCHAR(255),
    cidade VARCHAR(255),
    complemento VARCHAR(255),
    logradouro VARCHAR(255),
    numero VARCHAR(255),
    uf VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS Usuarios (
    id INT PRIMARY KEY AUTO_INCREMENT,
    login VARCHAR(100) NOT NULL,
    senha VARCHAR(255) NOT NULL
);


-- Populating the Usuarios table with password 123456, in BCrypt algorithm format
INSERT INTO Usuarios (login, senha) VALUES ('admin@email.com', '$2a$10$Y50UaMFOxteibQEYLrwuHeehHYfcoafCopUazP12.rqB41bsolF5.');


-- Populating the Medicos table
INSERT INTO Medicos (ativo, crm, email, nome, telefone, especialidade, bairro, cep, cidade, complemento, logradouro, numero, uf)
VALUES (true, 'CRM1', 'medico1@example.com', 'Médico 1', '123456789', 'ORTOPEDIA', 'Bairro1', '12345', 'Cidade1', 'Complemento1', 'Logradouro1', '123', 'UF1'),
       (true, 'CRM2', 'medico2@example.com', 'Médico 2', '987654321', 'CARDIOLOGIA', 'Bairro2', '54321', 'Cidade2', 'Complemento2', 'Logradouro2', '456', 'UF2');

-- Populating the Pacientes table
INSERT INTO Pacientes (ativo, cpf, email, nome, telefone, bairro, cep, cidade, complemento, logradouro, numero, uf)
VALUES (true, 'CPF1', 'paciente1@example.com', 'Paciente 1', '987654321', 'Bairro2', '54321', 'Cidade2', 'Complemento2', 'Logradouro2', '456', 'UF2'),
       (true, 'CPF2', 'paciente2@example.com', 'Paciente 2', '123456789', 'Bairro1', '12345', 'Cidade1', 'Complemento1', 'Logradouro1', '123', 'UF1');
