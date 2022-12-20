package polo.pf.jardineria.repositorios;

import polo.pf.jardineria.entidades.*;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolRepositorio extends CrudRepository <Rol, Long>{
    
}
