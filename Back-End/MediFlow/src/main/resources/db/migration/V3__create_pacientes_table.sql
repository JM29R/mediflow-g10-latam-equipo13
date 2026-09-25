CREATE TABLE pacientes (
    id BIGINT NOT NULL AUTO_INCREMENT,
    nombre VARCHAR(255) NOT NULL,
    edad TINYINT UNSIGNED CHECK (edad BETWEEN 0 AND 120),
    rut VARCHAR(255),
    diagnostico TEXT,
    fecha_registro      DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    fecha_actualizacion DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    estado VARCHAR(50) NOT NULL,
    usuario_id          BIGINT       NOT NULL,
    INDEX idx_usuario_id (usuario_id),
    PRIMARY KEY (id),
    CONSTRAINT fk_pacientes_usuario
        FOREIGN KEY (usuario_id) REFERENCES usuarios (id) ON DELETE RESTRICT
);