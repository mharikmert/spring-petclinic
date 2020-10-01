package petclinic.Web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.ControllerLinkBuilder;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import petclinic.Exceptions.OwnerNotFoundException;
import petclinic.Service.PetClinicService;
import petclinic.Model.Owner;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/rest")
public class PetClinicRestController {
	//Rest API
    private PetClinicService petClinicService;
	@Autowired
	public void setPetClinicService(PetClinicService petClinicService) {
		this.petClinicService = petClinicService;
	}
    @RequestMapping(method = RequestMethod.GET, value = "/owners")
    public ResponseEntity<List<Owner>> getOwners(){
		List<Owner> owners = petClinicService.findOwners();
        return ResponseEntity.ok(owners);
    }
    
    @RequestMapping(method = RequestMethod.GET, value = "/owner")
    public ResponseEntity<List<Owner>> getOwners(@RequestParam("ln") String lastName){
    	List<Owner> owners = petClinicService.findOwners(lastName);
    	return ResponseEntity.ok(owners);
    }
    
    @RequestMapping(method= RequestMethod.GET, value = "/owner/{id}")
    public ResponseEntity<Owner> getOwner(@PathVariable("id") Long id){
    	try {
    		Owner owner = petClinicService.findOwner(id);
        	return ResponseEntity.ok(owner);
    	}
    	catch(OwnerNotFoundException ex) {
    		return ResponseEntity.notFound().build();
    	}
    }
    @RequestMapping(method = RequestMethod.GET, value = "/owner/{id}", produces= "application/json")
    public ResponseEntity<?> getOwnerAsHateoas(@PathVariable("id") Long id){
    	try{
    		Owner owner = petClinicService.findOwner(id);
    		Link self  = ControllerLinkBuilder.linkTo(PetClinicRestController.class).slash("/owner/" + id).withSelfRel();
    		Link create  = ControllerLinkBuilder.linkTo(PetClinicRestController.class).slash("/owner/" + id).withRel("create");
    		Link update  = ControllerLinkBuilder.linkTo(PetClinicRestController.class).slash("/owner/" + id).withRel("update");
    		Link delete  = ControllerLinkBuilder.linkTo(PetClinicRestController.class).slash("/owner/" + id).withRel("delete");
			EntityModel<Owner> resource = new EntityModel<>(owner, self, create, update, delete);
			return ResponseEntity.ok(resource);
    	}catch(OwnerNotFoundException ex){
    		return ResponseEntity.notFound().build();
		}
	}
    @RequestMapping(method = RequestMethod.PUT, value = "/owner/{id}")
    public ResponseEntity<?> updateOwner(@PathVariable("id") Long id, @RequestBody Owner ownerRequest){
    	try {
    		Owner owner = petClinicService.findOwner(id);
    		owner.setFirstName(ownerRequest.getFirstName());
    		owner.setLastName(ownerRequest.getLastName());
    		petClinicService.update(owner);
    		return ResponseEntity.ok().build();
    		
    	}catch(OwnerNotFoundException ex) {
    		return ResponseEntity.notFound().build();
    	}catch(Exception ex) {
    		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    	}
    	
    }
    @RequestMapping(method = RequestMethod.POST, value = "/owner")
    public ResponseEntity <URI> createOwner(@RequestBody Owner owner){
    	try {
    		petClinicService.createOwner(owner);
        	Long id = owner.getId();
        	URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(id).toUri();
    		return ResponseEntity.created(location).build();
    	}catch(Exception ex) {
    		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    	}
    }
    @RequestMapping(method = RequestMethod.DELETE, value = "/owner/{id}")
    public ResponseEntity<?> deleteOwner(@PathVariable("id") Long id){
		try {
			petClinicService.deleteOwner(id);
			return ResponseEntity.ok().build();
	    	
		}catch(OwnerNotFoundException ex) {
			return ResponseEntity.notFound().build();
		}catch(Exception ex) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
    }
}
