package petclinic.Web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import petclinic.Model.Owner;
import petclinic.Service.PetClinicService;

@Controller
public class CreateOwnerController {
    @Autowired
    private PetClinicService petClinicService;

    @RequestMapping(value = "/owners/createOwner", method = RequestMethod.GET)
    public String createOwner (){
        return "createOwner";
    }

    @ModelAttribute
    public Owner initModel(){
        return new Owner();
    }

    @RequestMapping(value = "/owners/createOwner", method = RequestMethod.POST)
    public String handleCreateForm(@ModelAttribute Owner owner){
        petClinicService.createOwner(owner);
        return "redirect:/owners";
    }

}
