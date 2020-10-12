package petclinic.Service.PetClinicServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.access.annotation.Secured;
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
    private JavaMailSender javaMailSender;

    @Autowired
    public void setJavaMailSender(JavaMailSender javaMailSender){this.javaMailSender = javaMailSender;}

    @Autowired
    public void setOwnerRepository(OwnerRepository ownerRepository) {
        this.ownerRepository = ownerRepository;
    }

    @Autowired
    public void setPetRepository(PetRepository petRepository) {this.petRepository = petRepository;}

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    @Secured(value = {"ROLE_USER", "ROLE_EDITOR"})
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

        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("from@email.com");
        message.setTo("to@email.com");
        message.setSubject("Owner created");
        message.setText("owner entity with id: " + owner.getId());
        javaMailSender.send(message);
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
