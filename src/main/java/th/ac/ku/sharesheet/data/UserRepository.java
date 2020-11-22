package th.ac.ku.sharesheet.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import th.ac.ku.sharesheet.model.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {



}
