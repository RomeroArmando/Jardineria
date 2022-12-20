package polo.pf.jardineria.repositorios;
// contraseña de spring --> edlx cjrp haqg ecik
import polo.pf.jardineria.entidades.*;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepositorio extends CrudRepository <Usuario, Long>{
    
}
