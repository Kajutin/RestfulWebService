package lt.viko.eif.kkvmavva.restfulwebservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
//@ComponentScan("com.myapp.repositories")
public class RestfulwebserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestfulwebserviceApplication.class, args);}

	@Bean
	public RestTemplate getRestTemplate(){ return new RestTemplate();}

}
