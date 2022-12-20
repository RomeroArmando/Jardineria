package polo.pf.jardineria.controladores;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class HomeControlador {
    
    @RequestMapping("/")
    public ModelAndView home(){
        ModelAndView maw = new ModelAndView();
        maw.setViewName("fragments/base");
        maw.addObject("titulo", "Home");
        maw.addObject("vista", "inicio/home");
        return maw;
    }

}
