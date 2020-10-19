import component.Subtraction;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {ConfigOne.class})
@ActiveProfiles("add")
public class ConfigOneTest {

    @Autowired
    private Addition addition;

    @Test
    public void setAddition(){
        int sum = addition.addtionofTwoNumber(5,6);
        assertEquals(11,sum);
    }
}
