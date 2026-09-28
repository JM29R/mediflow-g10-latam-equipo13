package G10.EQUIPO13.MediFlow.Documentos.controller;

import G10.EQUIPO13.MediFlow.Documentos.DocumentosEntity;
import G10.EQUIPO13.MediFlow.Usuarios.Entity.UsuariosEntity;
import org.springframework.stereotype.Component;

@Component
public class DocumentosDTOMapper {

    public DocumentosEntity toEntity(DocumentosRequest documentosRequest, UsuariosEntity usuariosEntity){

        return null;


    }

    public DocumentosResponse toResponse(DocumentosEntity documentosEntity){

        String nombre = documentosEntity.getUsuario().getNombre();

        return new DocumentosResponse(
                documentosEntity.getId(),
                documentosEntity.getTipo(),
                documentosEntity.getContenido(),
                documentosEntity.getEspecialidad(),
                documentosEntity.getDocumentoId(),
                documentosEntity.getFechaRegistro(),
                documentosEntity.getFechaActualizacion(),
                documentosEntity.getScore(),
                nombre
        );

    }

}
