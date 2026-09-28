package G10.EQUIPO13.MediFlow.Usuarios.Controller;

import G10.EQUIPO13.MediFlow.Usuarios.Entity.Roles;
import G10.EQUIPO13.MediFlow.Usuarios.Service.UsuariosService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/user")
public class UsuariosController {

    private final UsuariosService service;

    @PostMapping("/register")
    public ResponseEntity<UsuarioResponse> register(@RequestBody UsuarioRegister reg){

        return service.register(reg);

    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/{id}/rol/{rol}")
    public ResponseEntity<UsuarioResponse> rolechange(@PathVariable("id") Long id, @PathVariable("rol") Roles rol){

        return service.roleChange(id,rol);

    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/findallbyrol/{rol}")
    public ResponseEntity<List<UsuarioResponse>> findbyrol(@PathVariable("rol") Roles rol){

        return ResponseEntity.ok(service.findAllByRol(rol));
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/findAll")
    public ResponseEntity<List<UsuarioResponse>> findAll(){

        return ResponseEntity.ok(service.listAll());

    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/findbyId/{id}")
    public ResponseEntity<UsuarioResponse> findById(@PathVariable Long id){
        return ResponseEntity.ok(service.findById(id));
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/findbyname/{name}")
    public ResponseEntity<UsuarioResponse> findByName(@PathVariable String name){
        return ResponseEntity.ok(service.findByName(name));
    }


    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){

        service.deleteById(id);

        return ResponseEntity.ok().build();
    }




}
