package Steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.spring.CucumberContextConfiguration;
import org.h2.util.json.JSONArray;
import org.springframework.http.HttpStatus;

import java.util.List;

@CucumberContextConfiguration
public class StepOne {
    @Given("^the following fish's$")
    public void givenTheFollowingFish(final JSONArray fishLists){
        System.out.println(fishLists);

    }

}
