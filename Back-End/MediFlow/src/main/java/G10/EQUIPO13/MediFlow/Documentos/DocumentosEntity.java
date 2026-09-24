package G10.EQUIPO13.MediFlow.Documentos;

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
@Table(name = "documentos")
public class DocumentosEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private Tipo tipo;

    private String contenido;


    private Float score;

    @ManyToOne(fetch = FetchType.LAZY)
    private UsuariosEntity usuario;

}
