package petclinic.Web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
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
    public String deleteOwner(@ModelAttribute Owner owner, RedirectAttributes redirectAttributes){
        petClinicService.deleteOwner(owner.getId());
        redirectAttributes.addFlashAttribute("message", "Owner deleted with id: " + owner.getId());
        return "redirect:/owners";
    }
}
