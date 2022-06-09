package Steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.http.HttpStatus;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class StepOne extends SpringIntegration{

    @When("^the client calls /fish$")
    public void the_client_issues_POST_fish() throws Throwable {
        executePost();
    }

    @Given("^the client calls /fish$")
    public void the_client_issues_GET_hello() throws Throwable {
        executeGet("http://localhost:8080/fish");
    }

    @When("^the client calls /fish$")
    public void the_client_issues_GET_version() throws Throwable {
        executeGet("http://localhost:8082/fish");
    }

    @Then("^the client receives status code of (\\d+)$")
    public void the_client_receives_status_code_of(int statusCode) throws Throwable {
        final HttpStatus currentStatusCode = latestResponse.getTheResponse().getStatusCode();
        assertThat("status code is incorrect : " + latestResponse.getBody(), currentStatusCode.value(), is(statusCode));
    }

    @And("^the client receives server version (.+)$")
    public void the_client_receives_server_version_body(String version) throws Throwable {
        assertThat(latestResponse.getBody(), is(version));
    }

}
