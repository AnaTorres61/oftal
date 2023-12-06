CREATE TABLE especialidade (
 id SERIAL PRIMARY KEY,
 descricao VARCHAR(255) NOT NULL UNIQUE,
 conselho VARCHAR(255) NOT NULL
);

CREATE TABLE medico (
 id SERIAL PRIMARY KEY,
 nome VARCHAR(255) NOT NULL,
 crm VARCHAR(255) NOT NULL UNIQUE
);

CREATE TABLE atributo_estrutura_lente (
 id SERIAL PRIMARY KEY,
 descricao VARCHAR(255) NOT NULL,
 lado_olho VARCHAR(255) NOT NULL
);

CREATE TABLE paciente (
 id SERIAL PRIMARY KEY,
 nome VARCHAR(255) NOT NULL,
 cpf VARCHAR(11) NOT NULL UNIQUE,
 dt_nascimento DATE NOT NULL
);

CREATE TABLE especialidade_medica (
 id SERIAL PRIMARY KEY,
 observacao VARCHAR(255),
 dt_conclusao DATE,
 id_especialidade INT NOT NULL REFERENCES especialidade(id),
 id_medico INT NOT NULL REFERENCES medico(id)
);

CREATE TABLE consulta (
 id SERIAL PRIMARY KEY,
 assinatura VARCHAR(255) NOT NULL UNIQUE,
 dt_consulta DATE NOT NULL,
 id_paciente INT NOT NULL REFERENCES paciente(id),
 id_medico INT NOT NULL REFERENCES medico(id)
);

CREATE TABLE receita_oculos (
 id SERIAL PRIMARY KEY,
 detalhamento VARCHAR(255),
 id_consulta INT NOT NULL REFERENCES consulta(id)
);

CREATE TABLE observacao_laudo (
 id SERIAL PRIMARY KEY,
 descricao VARCHAR(255) NOT NULL,
 id_receita_oculos INT NOT NULL REFERENCES receita_oculos(id)
);

CREATE TABLE estrutura_lente (
 id SERIAL PRIMARY KEY,
 tipo_correcao VARCHAR(45) NOT NULL,
 distancia_pupilar INT NOT NULL, 
 id_receita_oculos INT NOT NULL REFERENCES receita_oculos(id)
);

CREATE TABLE especificacao_lente (
 id SERIAL PRIMARY KEY,
 valor FLOAT NOT NULL,
 id_estrutura_lente INT NOT NULL REFERENCES estrutura_lente(id),
 id_atributo_estrutura_lente INT NOT NULL REFERENCES atributo_estrutura_lente(id)
);