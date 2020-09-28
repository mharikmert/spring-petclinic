package petclinic.DAO.JDBC;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import petclinic.DAO.OwnerRepository;
import petclinic.Model.Owner;

import java.util.List;

@Repository
public class OwnerRepositoryJdbcImpl implements OwnerRepository {

    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    RowMapper<Owner> rowMapper = (rs, rowNum) -> {
        Owner owner = new Owner();
        owner.setId(rs.getLong("id"));
        owner.setFirstName(rs.getString("first_name"));
        owner.setLastName(rs.getString("last_name"));
        System.out.println("returning owner from rowMapper-> " + owner);
        return owner;
    };
    @Override
    public List<Owner> findAll() {
        String sql = "select id, first_name, last_name from T_OWNER";
        return jdbcTemplate.query(sql, rowMapper);
    }

    @Override
    public Owner findById(Long id) {
        String ownerID = String.valueOf(id);
        String sql = "select id , first_name, last_name from T_OWNER where id =" + ownerID; // selecting all the ids
        return DataAccessUtils.singleResult(jdbcTemplate.query(sql, rowMapper));
    }

    @Override
    public List<Owner> findByLastName(String lastName) {
        String sql = "select id, first_name, last_name from T_OWNER where last_name like "; // selecting all the last_names
        return jdbcTemplate.query(sql, rowMapper);
    }

    @Override
    public void createOwner(Owner owner) {
        String sql = "insert into T_OWNER(id , first_name, last_name) values(owner.getId() + ',' +  owner.getFirstName() + ',' + owner.getLastName()";
        jdbcTemplate.query(sql, rowMapper);

    }
    @Override
    public Owner updateOwner(Owner owner) {
        return null;
    }

    @Override
    public void deleteOwner(Long id) {
            /*testing transactional process */
        String sql = "delete from T_OWNER where id =" + id;
        jdbcTemplate.update(sql, id);
    }
}
