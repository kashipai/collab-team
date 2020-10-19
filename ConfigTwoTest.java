import component.Subtraction;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {ConfigTwo.class})
@ActiveProfiles("sub")
public class ConfigTwoTest {

    @Autowired
    private Subtraction subtraction ;

    @Test
    public void setSubtraction (){
        int sum = subtraction.substractionofTwoNumber(11,5);
        assertEquals(6,sum);
    }
}
