package polo.pf.jardineria.controladores;

import polo.pf.jardineria.entidades.*;
import polo.pf.jardineria.servicios.*;
import java.util.*;
import java.io.*;
import java.nio.file.Paths;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.*;
import org.springframework.validation.BindingResult; //esto devuleve el mismo formulario en caso de error
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@RestController
@RequestMapping("roles")
public class RolControlador implements WebMvcConfigurer{
    
    @Autowired
    RolServicio rolServicio;

    @GetMapping
    private ModelAndView index(){ //inicio

        ModelAndView maw = new ModelAndView();
        maw.setViewName("fragments/base");
        maw.addObject("titulo", "Lista de Roles");
        maw.addObject("vista", "plantas/index");
        maw.addObject("roles", rolServicio.getAll());
        return maw;

    }
    /*
    private List<Rol> index(){
        return rolServicio.getAll();
    }
    */

    @GetMapping("/{id}")//mostrar un rol
    private ModelAndView one(@PathVariable("id") Long id){

        ModelAndView maw = new ModelAndView();
        maw.setViewName("fragments/base");
        maw.addObject("titulo", "Detalles del jugador #" + id);
        maw.addObject("vista", "plantas/ver");
        maw.addObject("roles", rolServicio.getById(id));
        return maw;

    }
    /* 
    private Rol one(@PathVariable("id") Long id){
        return rolServicio.getById(id);
    }
    */
    @GetMapping("/crear")
    public ModelAndView crear(Rol rol){
        ModelAndView maw = new ModelAndView();
        maw.setViewName("fragments/base");
        maw.addObject("titulo", "Crear rol");
        maw.addObject("vista", "plantas/crear");
        return maw;
    }

    @PostMapping("/crear")
	public ModelAndView guardar(@Valid Rol rol, BindingResult br)
    {
		if ( br.hasErrors() ){
			return this.crear(rol);
		}

        rolServicio.save(rol); 
        ModelAndView maw = this.index();
        maw.addObject("exito", "Rol Guardado Exitosamente");
		return maw; //vuelvo al index
	}

    @GetMapping("/editar/{id}")//editar un rol
    public ModelAndView editar(@PathVariable("id") Long id, Rol rol){

        return this.editar(id, rol, true);

    }

    public ModelAndView editar(@PathVariable("id") Long id, Rol rol, boolean estaPersistido){
        
        ModelAndView maw = new ModelAndView();
        maw.setViewName("fragments/base");
        maw.addObject("titulo", "Editar Rol");
        maw.addObject("vista", "plantas/editar");
        //maw.addObject("Roles", rolServicio.getAll());
        
        if(estaPersistido){
            maw.addObject("roles", rolServicio.getById(id));
        }
        return  maw;
    }

    @PutMapping("/editar/{id}")
    private ModelAndView update(@PathVariable("id") Long id, @Valid Rol rol, BindingResult br, RedirectAttributes ra){

        if (br.hasErrors()){
            return this.editar(id, rol, false);
        }

        Rol registro = rolServicio.getById(id);
        registro.setNombre(rol.getNombre());
        registro.setDescripcion(rol.getDescripcion());
        registro.setEstado(rol.getEstado());
        ModelAndView maw = this.index();

        rolServicio.save(registro);
        maw.addObject("exito", "Jugador Editado Exitosamente");
        return maw;
    }

    @DeleteMapping("/{id}")
    private ModelAndView delete(@PathVariable("id") Long id) {
        rolServicio.delete(id);
        ModelAndView maw = this.index();
        maw.addObject("exito", "Jugador borrado exitosamente");
        return maw;
    }
}
