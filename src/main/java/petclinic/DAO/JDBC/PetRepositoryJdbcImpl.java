package petclinic.DAO.JDBC;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import petclinic.DAO.PetRepository;
import petclinic.Model.Pet;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository("petRepository") //
public class PetRepositoryJdbcImpl implements PetRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    RowMapper<Pet> rowMapper = new RowMapper<Pet>() {
        @Override
        public Pet mapRow(ResultSet resultSet, int rowNum) throws SQLException {
            Pet pet = new Pet();
            pet.setId(resultSet.getLong("id"));
            pet.setFirstName(resultSet.getString("first_name"));
            pet.setLastName(resultSet.getString("last_name"));
            return pet;
        }
    };

    @Override
    public Pet findById(Long id) {
        String pet_id = String.valueOf(id);
        String sql = "select id, first_name, last_name from t_pet where id =" + pet_id;
        return DataAccessUtils.singleResult(jdbcTemplate.query(sql, rowMapper));
    }

    @Override
    public List<Pet> findByOwnerId(Long ownerId) {
        return null;
    }

    @Override
    public void create(Pet pet) {

    }

    @Override
    public Pet update(Pet pet) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public void deleteByOwnerId(Long ownerId) {

    }
}
