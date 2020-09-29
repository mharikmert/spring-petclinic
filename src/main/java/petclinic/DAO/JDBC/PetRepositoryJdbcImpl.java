package petclinic.DAO.JDBC;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import petclinic.DAO.PetRepository;
import petclinic.Model.Pet;

import java.util.List;

@Repository
public class PetRepositoryJdbcImpl implements PetRepository {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Pet findById(Long id) {
        return null;
    }

    @Override
    public List<Pet> findByOwnerId(Long ownerId) {
        return null;
    }

    @Override
    public void create(Pet pet) { }

    @Override
    public Pet update(Pet pet) {
        return null;
    }

    @Override
    public void delete(Long id) { }

    @Override
    public void deleteByOwnerId(Long ownerId) {
        String sql = "delete from t_pet where id =" + ownerId;
        jdbcTemplate.update(sql , ownerId);
    }
}
