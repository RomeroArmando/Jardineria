package polo.pf.jardineria.controladores;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


@RestController
public class EjemploControlador {

    @RequestMapping("/roles")
    public ModelAndView ejemplo(){
        ModelAndView maw = new ModelAndView();
        maw.setViewName("fragments/base");
        maw.addObject("titulo", "ejemplo");
        maw.addObject("vista", "plantas/roles");
        //maw.addObject("paises", paisServicio.getAll());
        return maw;
    }

}
