package petclinic.Service.PetClinicServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import petclinic.DAO.OwnerRepository;
import petclinic.Exceptions.OwnerNotFoundException;
import petclinic.Service.PetClinicService;

import petclinic.Model.Owner;
import java.util.List;

@Service
public class PetClinicServiceImpl implements PetClinicService {
    @Autowired
    private OwnerRepository ownerRepository;

    public void setOwnerRepository(OwnerRepository ownerRepository) {
        this.ownerRepository = ownerRepository;
    }

    @Override
    public List<Owner> findOwners() {
        return ownerRepository.findAll();
    }

    @Override
    public List<Owner> findOwners(String lastName) {
        return ownerRepository.findByLastName(lastName);
    }

    @Override
    public Owner findOwner(Long id) throws OwnerNotFoundException {
        Owner owner = ownerRepository.findById(id);
        if(owner == null) throw new OwnerNotFoundException("Owner not found");
        return owner;
    }
    @Override
    public void create(Owner owner) {
        ownerRepository.createOwner(owner);
    }
    @Override
    public Owner update(Owner owner) {
        return ownerRepository.updateOwner(owner);
    }
    @Override
    public void delete(Long id) {
        ownerRepository.deleteOwner(id);
    }
}
