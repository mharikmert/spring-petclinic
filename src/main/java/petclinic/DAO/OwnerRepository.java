package petclinic.DAO;

import petclinic.Model.Owner;
import java.util.List;

public interface OwnerRepository {
    List<Owner> findAll();
    Owner findById(Long id);
    List<Owner> findByLastName(String lastName);
    void createOwner(Owner owner);
    Owner updateOwner(Owner owner);
    void deleteOwner(Long id);
}
