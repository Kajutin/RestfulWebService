package Runer;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.messages.Messages;
import io.cucumber.spring.CucumberContextConfiguration;
import lt.viko.eif.kkvmavva.restfulwebservice.RestfulwebserviceApplication;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;

@RunWith(Cucumber.class)
@CucumberContextConfiguration
@SpringBootTest(classes = {RestfulwebserviceApplication.class, Run.class}, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@CucumberOptions(plugin = {"pretty"}, tags = "",  features = "src/test/resources/features", glue = "Steps")
public class Run {
}
