package Steps;

import lt.viko.eif.kkvmavva.restfulwebservice.RestfulwebserviceApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = RestfulwebserviceApplication.class)
public class RestfulwebserviceApplicationTest {

    @Test
    public void whenSpringContextIsBootstrapped_thenNoExceptions() {
    }
}
