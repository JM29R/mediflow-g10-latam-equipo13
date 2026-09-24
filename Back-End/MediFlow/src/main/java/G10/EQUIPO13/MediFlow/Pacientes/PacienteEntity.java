package G10.EQUIPO13.MediFlow.Pacientes;


import G10.EQUIPO13.MediFlow.Usuarios.Entity.UsuariosEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "pacientes")
public class PacienteEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String diagnostico;

    @Enumerated(EnumType.STRING)
    private Ubicacion ubicacion;

    @ManyToOne(fetch = FetchType.LAZY)
    private UsuariosEntity usuario;

}
