package petclinic.Web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import petclinic.Exceptions.OwnerNotFoundException;
import petclinic.Service.PetClinicService;

import petclinic.Model.Owner;

@Controller
public class DeleteOwnerController {
    @Autowired
    private PetClinicService petClinicService;

    @RequestMapping(value = "/owners/delete/{id}", method = RequestMethod.GET)
    public String loadOwner(@PathVariable Long id, ModelMap modelMap){
        Owner owner = petClinicService.findOwner(id);
        modelMap.put("owner", owner);
        return "deleteOwner";
    }
    @RequestMapping(value = "/owners/delete/{id}", method = RequestMethod.POST)
    public String deleteOwner(@ModelAttribute Owner owner){
        petClinicService.deleteOwner(owner.getId());
        return "redirect:/owners";
    }
}
