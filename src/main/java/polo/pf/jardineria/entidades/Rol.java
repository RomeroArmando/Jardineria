package polo.pf.jardineria.entidades;

import com.fasterxml.jackson.annotation.*;
import java.util.*;
import javax.persistence.*;
import javax.validation.constraints.*;
import lombok.*;

@Entity
@NoArgsConstructor //me evita escribir constructores
@AllArgsConstructor
@Data
@Builder //realiza los getters y los setters
@Table(name="roles")
public class Rol {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //TIPO DE GENERACION - AUTOINCREMENTAL 
    private Long id;

    @NotBlank(message = "Campo obligatorio") //define al atributo nombre (Es Una Validacion)
    @Size(max = 100, message= "Nombre demasiado largo")
    private String nombre;

    @NotBlank(message = "Campo obligatorio") //define al atributo nombre (Es Una Validacion)
    @Size(max = 250, message= "Nombre demasiado largo")
    private String descripcion;

    private Integer estado;

    @OneToMany(mappedBy = "rol") //muchos usuarios van a tener un rol
    @JsonManagedReference //evita bucles infinitos
    private List<Usuario> usuarios;

    @Override
    public String toString(){
        return this.nombre;
    }
}
