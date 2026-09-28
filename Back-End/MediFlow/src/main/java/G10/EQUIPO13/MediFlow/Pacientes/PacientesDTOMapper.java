package G10.EQUIPO13.MediFlow.Pacientes;

import G10.EQUIPO13.MediFlow.AiClient.AIResponse;
import G10.EQUIPO13.MediFlow.Usuarios.Entity.UsuariosEntity;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class PacientesDTOMapper {


    public PacienteEntity toDomainFromAI(AIResponse aiResponse, UsuariosEntity user){

        PacienteEntity pacienteEntity = new PacienteEntity();
        pacienteEntity.setNombre(aiResponse.nombrePaciente());
        pacienteEntity.setDiagnostico(aiResponse.Diagnostico());
        pacienteEntity.setEdad(aiResponse.edad());
        pacienteEntity.setRut(aiResponse.rut());
        pacienteEntity.setFechaRegistro(LocalDateTime.now());
        pacienteEntity.setFechaActualizacion(LocalDateTime.now());
        pacienteEntity.setEstado(aiResponse.estado());
        pacienteEntity.setUsuario(user);

        return pacienteEntity;

    }


}
