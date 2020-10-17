package petclinic.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import petclinic.Model.Vet;

import java.util.List;
@Repository
public interface VetRepository extends JpaRepository<Vet,Long> {
    List<Vet> findAll();
    Vet findVetById(Long id);
}
