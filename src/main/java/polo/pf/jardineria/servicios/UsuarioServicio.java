package polo.pf.jardineria.servicios;

import polo.pf.jardineria.entidades.*;
import polo.pf.jardineria.repositorios.*;
import java.util.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

@Service
public class UsuarioServicio {
    
    @Autowired
    UsuarioRepositorio usuarioRepositorio;

    public List<Usuario> getAll(){
        
        List<Usuario> lista = new ArrayList<Usuario>();
        usuarioRepositorio.findAll().forEach(registro -> lista.add(registro));
        return lista;

    }

    public Usuario getById(Long id){
        
        return usuarioRepositorio.findById(id).get();

    }

    public void save(Usuario usuario){

        usuarioRepositorio.save(usuario);

    }

    public void delete(Long id){

        usuarioRepositorio.deleteById(id);

    }

}
