package petclinic.DAO;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.test.annotation.Rollback;
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

    @Test @Rollback
    public void deleteOwner(){
           ownerRepository.deleteOwner(10L);
    }

    @Test @Commit
    public void testCreateOwner(){
        Owner owner = new Owner("test","user", 10L);
        Owner owner2 = new Owner();
        owner2.setFirstName(null);
        owner2.setLastName(null);
        ownerRepository.createOwner(owner);
        //Assertions.assertThrows(SQLGrammarException.class,() -> {
    //ownerRepository.createOwner(owner);});
    }
    @Test //rollback default
    public void testUpdateOwner(){
        Owner owner =  new Owner("updated", "owner", 10L);
        ownerRepository.updateOwner(owner);
    }

}
