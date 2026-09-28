package G10.EQUIPO13.MediFlow.Documentos;


import G10.EQUIPO13.MediFlow.Documentos.controller.DocumentosDTOMapper;
import G10.EQUIPO13.MediFlow.Documentos.controller.DocumentosRequest;
import G10.EQUIPO13.MediFlow.Documentos.controller.DocumentosResponse;
import G10.EQUIPO13.MediFlow.Usuarios.Entity.UsuariosRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class DocumentosService {

    private final DocumentosRepository documentosRepository;

    private final UsuariosRepository usuariosRepository;

    private final DocumentosDTOMapper mapper;


    public DocumentosResponse create(DocumentosRequest documentosRequest){

        //llamar a servicio de llms

        return null;

    }




}
