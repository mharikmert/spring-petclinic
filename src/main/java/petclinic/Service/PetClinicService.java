package petclinic.Service;

import petclinic.Exceptions.OwnerNotFoundException;

import petclinic.Model.Owner;
import java.util.List;
public interface PetClinicService {

    List<Owner> findOwners();
    List<Owner> findOwners(String lastName);
    Owner findOwner (Long id) throws OwnerNotFoundException;
    void create(Owner owner);
    Owner update(Owner owner);
    void delete(Long id);
}
