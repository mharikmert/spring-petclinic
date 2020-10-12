package petclinic.DAO.JPA;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import petclinic.DAO.OwnerRepository;
import petclinic.Model.Owner;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository("ownerRepository")
public class OwnerRepositoryJpaImpl  implements OwnerRepository {

    @PersistenceContext
    private EntityManager entityManager;
    
    @Override
    public List<Owner> findAll() {
        return entityManager.createQuery("from Owner", Owner.class).getResultList();
    }

    @Override
    public Owner findById(Long id) {
        return entityManager.find(Owner.class, id);
    }

    @Override
    public List<Owner> findByLastName(String lastName) {
        return entityManager.createQuery("from Owner where lastName = :lastName",Owner.class).
                setParameter("lastName", lastName).getResultList();
    }
    @Override
    public void createOwner(Owner owner) {
        entityManager.persist(owner);
    }
    @Override
    public Owner updateOwner(Owner owner) {
        return entityManager.merge(owner);
    }
    @Override
    public void deleteOwner(Long id) {
        entityManager.remove(entityManager.getReference(Owner.class, id));
    }
}
