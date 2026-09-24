package G10.EQUIPO13.MediFlow.Usuarios.Service;

import G10.EQUIPO13.MediFlow.Usuarios.Controller.UsuarioRegister;
import G10.EQUIPO13.MediFlow.Usuarios.Controller.UsuarioResponse;
import G10.EQUIPO13.MediFlow.Usuarios.Entity.UsuariosEntity;
import G10.EQUIPO13.MediFlow.Usuarios.Entity.Roles;
import org.springframework.stereotype.Component;

@Component
public class UsuarioMapperDTO {

    public UsuariosEntity ToEntityRegister(UsuarioRegister request){

        UsuariosEntity entity = new UsuariosEntity();
        entity.setName(request.name());
        entity.setPassword(request.password());
        entity.setRol(Roles.NO_ASIGNADO);

        return entity;
    }

    public UsuarioResponse ToDTO(UsuariosEntity entity){
        UsuarioResponse response = new UsuarioResponse(entity.getId(), entity.getName(),String.valueOf(entity.getRol()));
        return response;
    }



}
