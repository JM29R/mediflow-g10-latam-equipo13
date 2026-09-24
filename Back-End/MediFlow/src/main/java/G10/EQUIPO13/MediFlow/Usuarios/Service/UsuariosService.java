package G10.EQUIPO13.MediFlow.Usuarios.Service;


import G10.EQUIPO13.MediFlow.Usuarios.Controller.UsuarioRegister;
import G10.EQUIPO13.MediFlow.Usuarios.Controller.UsuarioResponse;
import G10.EQUIPO13.MediFlow.Usuarios.Entity.Roles;
import G10.EQUIPO13.MediFlow.Usuarios.Entity.UsuariosEntity;
import G10.EQUIPO13.MediFlow.Usuarios.Entity.UsuariosRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class UsuariosService {

    private final UsuariosRepository repository;

    private final UsuarioMapperDTO mapper;

    private final PasswordEncoder passwordEncoder;


    @Transactional
    public ResponseEntity<UsuarioResponse> register(UsuarioRegister reg) {

        UsuariosEntity entity = mapper.ToEntityRegister(reg);

        entity.setPassword(passwordEncoder.encode(entity.getPassword()));

        UsuariosEntity response = repository.save(entity);

        return ResponseEntity.ok(mapper.ToDTO(response));
    }

    public List<UsuarioResponse> listAll(){

        return repository.findAll()
                .stream()
                .map(mapper::ToDTO)
                .toList();

    }

    public UsuarioResponse findById(Long id){
       UsuariosEntity entity = repository.findById(id).orElse(null);
       return mapper.ToDTO(entity);
    }

    public UsuarioResponse findByName(String name){
        UsuariosEntity entity = repository.findByName(name).orElse(null);
        return mapper.ToDTO(entity);
    }

    public List<UsuarioResponse> findAllByRol(Roles rol){

        List<UsuariosEntity> entities= repository.findAllByRol(rol);

        return entities
                .stream()
                .map(mapper::ToDTO)
                .toList();

    }
    @Transactional
    public void  deleteById(Long id){repository.deleteById(id);}

    @Transactional
    public ResponseEntity<UsuarioResponse> roleChange(Long id, Roles rol) {

        UsuariosEntity entity = repository.findById(id).orElse(null);

        entity.setRol(rol);

        UsuariosEntity response = repository.save(entity);

        return ResponseEntity.ok(mapper.ToDTO(response));

    }
}
