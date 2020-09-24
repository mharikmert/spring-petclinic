package com.spring.petclinic.Web;
import com.spring.petclinic.Service.PetClinicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class PetClinicController {
	@Autowired
    private PetClinicService petClinicService;
    @RequestMapping ("/owners")
    public ModelAndView getOwners(){
        ModelAndView mav = new ModelAndView();
        mav.addObject("owners",petClinicService.findOwners());
        mav.setViewName("owners");
        return mav;
    }
}
