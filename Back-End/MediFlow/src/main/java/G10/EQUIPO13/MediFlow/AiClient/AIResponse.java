package G10.EQUIPO13.MediFlow.AiClient;

import G10.EQUIPO13.MediFlow.Pacientes.Entity.Estado;

import java.math.BigDecimal;

public record AIResponse(
        //documentos
        String tipo,
        String contenido,
        String especialidad,
        String documentoId,
        BigDecimal score,

        //Paciente
        String nombrePaciente,
        String Diagnostico,
        Short edad,
        String rut,
        Estado estado
) {
}
