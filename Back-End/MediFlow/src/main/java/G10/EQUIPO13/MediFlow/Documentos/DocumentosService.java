package G10.EQUIPO13.MediFlow.Documentos;


import G10.EQUIPO13.MediFlow.AiClient.AIResponse;
import G10.EQUIPO13.MediFlow.AiClient.Temporal.GeminiAnalyzer;
import G10.EQUIPO13.MediFlow.Documentos.Entity.DocumentosEntity;
import G10.EQUIPO13.MediFlow.Documentos.Entity.DocumentosRepository;
import G10.EQUIPO13.MediFlow.Documentos.controller.DocumentosDTOMapper;
import G10.EQUIPO13.MediFlow.Documentos.controller.DocumentosRequest;
import G10.EQUIPO13.MediFlow.Documentos.controller.DocumentosResponse;
import G10.EQUIPO13.MediFlow.Pacientes.PacienteEntity;
import G10.EQUIPO13.MediFlow.Pacientes.PacienteRepository;
import G10.EQUIPO13.MediFlow.Pacientes.PacientesDTOMapper;
import G10.EQUIPO13.MediFlow.Usuarios.Entity.UsuariosEntity;
import G10.EQUIPO13.MediFlow.Usuarios.Service.CurrentUserService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class DocumentosService {

    private final DocumentosRepository documentosRepository;

    private final CurrentUserService currentUserService;

    private final DocumentosDTOMapper mapper;

    private final GeminiAnalyzer gemini;

    private final PacienteRepository pacienteRepository;

    private final PacientesDTOMapper pacientesMapper;


    @Transactional
    public DocumentosResponse analizeText(DocumentosRequest documentosRequest){

        UsuariosEntity user = currentUserService.getCurrentUserId();

        AIResponse aiResponse= gemini.analyzeText(documentosRequest.content());

        DocumentosEntity entity = mapper.toEntity(aiResponse,user);

        DocumentosEntity documentoSaved = documentosRepository.save(entity);

        // Pacientes

        PacienteEntity paciente = pacientesMapper.toDomainFromAI(aiResponse,user);

        PacienteEntity pacienteSaved = pacienteRepository.save(paciente);

        return mapper.toResponse(documentoSaved);

    }




}
