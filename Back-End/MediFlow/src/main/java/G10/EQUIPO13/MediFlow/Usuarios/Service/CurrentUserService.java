package G10.EQUIPO13.MediFlow.Usuarios.Service;

import G10.EQUIPO13.MediFlow.Usuarios.Entity.UsuariosEntity;
import G10.EQUIPO13.MediFlow.Usuarios.Entity.UsuariosRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CurrentUserService {

    private final UsuariosRepository usuariosRepository;

    public UsuariosEntity getCurrentUserId() {
        String nombreUsuario = SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getName();

        return usuariosRepository.findByNombre(nombreUsuario)
                .orElseThrow(() ->
                        new UsernameNotFoundException(
                                "Usuario no encontrado: " + nombreUsuario
                        ));
    }
}
