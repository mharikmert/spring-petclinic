package petclinic.DAO;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import petclinic.Model.Owner;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@SpringBootTest
@ActiveProfiles("dev")
@Transactional
public class OwnerRepositoryTests {
    @Autowired
    private OwnerRepository ownerRepository;

    @PersistenceContext
    private EntityManager entityManager;

    @Test
    public void findOwners(){
            ownerRepository.findAll();
    }

    @Test @Commit
    public void deleteOwner() { // fits owners lists to 10, other owners will be deleted
        while (ownerRepository.findAll().size() > 10)
            ownerRepository.deleteOwner(ownerRepository.findAll().get(ownerRepository.findAll().size()-1).getId());
    }
    @Test @Commit
    public void testCreateOwner(){
        Owner owner = new Owner("test","user", 10L);
        Owner owner2 = new Owner();
        owner2.setFirstName(null);
        owner2.setLastName(null);
        ownerRepository.createOwner(owner);
    }
    @Test //rollback default
    public void testUpdateOwner(){
        Owner owner =  new Owner("updated", "owner", 10L);
        ownerRepository.updateOwner(owner);
    }

}
