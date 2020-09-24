package com.spring.petclinic.Service;

import com.spring.petclinic.Exceptions.OwnerNotFoundException;
import com.spring.petclinic.Model.Owner;

import java.util.List;
public interface PetClinicService {
    List<Owner> findOwners();
    List<Owner> findOwners(String lastName);
    Owner findOwner (Long id) throws OwnerNotFoundException;
    void create(Owner owner);
    Owner update(Owner owner);
    void delete(Long id);
}
