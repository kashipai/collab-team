import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {DataConfig.class})
public class DataConfigTest {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Test
    public void dbCreation(){
        jdbcTemplate.update("CREATE TABLE Person (PersonID int, FirstName varchar(255), LastName varchar(255))");
        jdbcTemplate.update("INSERT INTO Person VALUES (1,'Max','Planck')");
    }
}
