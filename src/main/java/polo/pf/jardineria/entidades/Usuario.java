package polo.pf.jardineria.entidades;

import com.fasterxml.jackson.annotation.JsonBackReference;
import java.util.*;
import javax.persistence.*;
import javax.validation.constraints.*;
import lombok.*;

@Entity
@NoArgsConstructor //me evita escribir constructores
@AllArgsConstructor
@Data
@Builder //realiza los getters y los setters
@Table(name="usuarios")
public class Usuario {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //TIPO DE GENERACION - AUTOINCREMENTAL 
    private Long id;

    private String email;

    private String nombre;
    
    private String clave;

    private Integer estado;

    @ManyToOne
    @JsonBackReference
    private Rol rol;

}
