CREATE TABLE documentos (
    id BIGINT NOT NULL AUTO_INCREMENT,
    tipo VARCHAR(50) NOT NULL,
    contenido TEXT,
    score FLOAT,
    usuario_id BIGINT,
    PRIMARY KEY (id),
    CONSTRAINT fk_documentos_usuario
        FOREIGN KEY (usuario_id) REFERENCES usuarios (id)
);