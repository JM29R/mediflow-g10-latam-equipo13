package G10.EQUIPO13.MediFlow.Usuarios.Entity;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UsuariosRepository extends JpaRepository<UsuariosEntity,Long> {


    Optional<UsuariosEntity> findByNombre(String name);

    List<UsuariosEntity> findAllByRol(Roles rol);
}