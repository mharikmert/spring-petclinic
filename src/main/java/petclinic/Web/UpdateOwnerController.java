package petclinic.Web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import petclinic.Service.PetClinicService;

import petclinic.Model.Owner;

@Controller
public class UpdateOwnerController {
    @Autowired
    private PetClinicService petClinicService;

    @RequestMapping(value = "/owners/update/{id}", method = RequestMethod.GET)
    public String loadOwner(@PathVariable Long id, ModelMap modelMap){
          Owner owner = petClinicService.findOwner(id);
        modelMap.put("owner", owner);
        return "updateOwner";
    }

    @RequestMapping(value = "/owners/update/{id}", method = RequestMethod.POST)
    public String handleUpdateForm(@ModelAttribute @Validated Owner owner, BindingResult bindingResult,
RedirectAttributes redirectAttributes){
        if(bindingResult.hasErrors())
            return "updateOwner";
        petClinicService.update(owner);
        redirectAttributes.addFlashAttribute("message", "Owner updated with id : " + owner.getId());
        return "redirect:/owners";
    }
}
