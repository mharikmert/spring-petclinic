package petclinic.Web;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import petclinic.Service.PetClinicService;

@Controller
@Configuration
public class PetClinicController {

    private PetClinicService petClinicService;

    @Autowired
    public void setPetClinicService(PetClinicService petClinicService){
        this.petClinicService = petClinicService;
    }

    @RequestMapping("/owners")
    public ModelAndView getOwners() {
        ModelAndView mav = new ModelAndView();
        mav.addObject("owners", petClinicService.findOwners());
        mav.setViewName("owners");
        return mav;
    }

    @RequestMapping(value =  {"/","index.html"})
    public ModelAndView index(){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("index");
        return mav;
    }
}