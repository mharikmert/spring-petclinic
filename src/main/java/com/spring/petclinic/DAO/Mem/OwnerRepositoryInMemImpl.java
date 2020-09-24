package com.spring.petclinic.DAO.Mem;
import com.spring.petclinic.DAO.OwnerRepository;
import com.spring.petclinic.Model.Owner;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.*;
import java.util.stream.Collectors;

@Repository // create bean while project is working
public class OwnerRepositoryInMemImpl implements OwnerRepository {
    private final Map<Long, Owner> ownersMap = new HashMap<>();
    public OwnerRepositoryInMemImpl(){
        Owner owner1 = new Owner("user1", "lastname1",1L);
        Owner owner2 = new Owner("user2", "lastname2",2L);
        Owner owner3 = new Owner("user3", "lastname3",3L);
        Owner owner4 = new Owner("user4", "lastname4",4L);
        ownersMap.put(owner1.getId(), owner1);
        ownersMap.put(owner2.getId(), owner2);
        ownersMap.put(owner3.getId(), owner3);
        ownersMap.put(owner4.getId(), owner4);
    }
    @Override
    public @ResponseBody
    List<Owner> findAll() {
        return new ArrayList<>(ownersMap.values());
    }

    @Override
    public Owner findById(Long id) {
        return ownersMap.get(id);
    }

    @Override
    public List<Owner> findByLastName(String lastName) {
        return ownersMap.values().stream().filter(o -> o.getLastName().equals(lastName)).collect(Collectors.toList());
    }

    @Override
    public void createOwner(Owner owner) {
         owner.setId(new Date().getTime()); // owner id should be unique
        ownersMap.put(owner.getId(), owner);
    }

    @Override
    public Owner updateOwner(Owner owner) {
        return ownersMap.replace(owner.getId(), owner);
    }

    @Override
    public void deleteOwner(Long id) {
        ownersMap.remove(id);
    }
}
