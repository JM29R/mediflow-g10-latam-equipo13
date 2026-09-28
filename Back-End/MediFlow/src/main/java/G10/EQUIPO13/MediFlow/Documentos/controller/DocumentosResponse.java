package G10.EQUIPO13.MediFlow.Documentos.controller;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record DocumentosResponse(
        Long id,
        String tipo,
        String contenido,
        String especialidad,
        String documentoId,
        LocalDateTime fechaRegistro,
        LocalDateTime fechaActualizacion,
        BigDecimal score,
        String nombreMedico

) {
}
