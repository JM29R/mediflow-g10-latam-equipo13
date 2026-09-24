CREATE TABLE pacientes (
    id BIGINT NOT NULL AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    diagnostico VARCHAR(255),
    ubicacion VARCHAR(50) NOT NULL,
    usuario_id BIGINT,
    PRIMARY KEY (id),
    CONSTRAINT fk_pacientes_usuario
        FOREIGN KEY (usuario_id) REFERENCES usuarios (id)
);