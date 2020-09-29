package petclinic.Service.PetClinicServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import petclinic.DAO.OwnerRepository;
import petclinic.DAO.PetRepository;
import petclinic.Exceptions.OwnerNotFoundException;
import petclinic.Service.PetClinicService;
import petclinic.Model.Owner;

import java.util.List;

@Service
@Transactional// all public methods become transactional
public class PetClinicServiceImpl implements PetClinicService {

    private OwnerRepository ownerRepository;
    private PetRepository petRepository;

    @Autowired
    public void setOwnerRepository(OwnerRepository ownerRepository) {
        this.ownerRepository = ownerRepository;
    }

    @Autowired
    public void setPetRepository(PetRepository petRepository) {this.petRepository = petRepository;}

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public List<Owner> findOwners() {
        return ownerRepository.findAll();
    }
    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public List<Owner> findOwners(String lastName) {
        return ownerRepository.findByLastName(lastName);
    }
    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public Owner findOwner(Long id) throws OwnerNotFoundException {
        Owner owner = ownerRepository.findById(id);
        if(owner == null) throw new OwnerNotFoundException("Owner not found");
        return owner;
    }
    @Override
    public void createOwner(Owner owner) {
        ownerRepository.createOwner(owner);
    }
    @Override
    public Owner update(Owner owner) {
        return ownerRepository.updateOwner(owner);
    }
    @Override
    public void deleteOwner(Long id) {
        petRepository.deleteByOwnerId(id); // deleting pets first
        ownerRepository.deleteOwner(id); //then delete the owner
        //throw new RuntimeException("transactional rollback"); // throw an unchecked exception for rollback

    }
}
