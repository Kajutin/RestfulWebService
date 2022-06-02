package lt.viko.eif.kkvmavva.restfulwebservice;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * Preloading data
 */
@Component
class DatabaseLoader {

    @Bean
    CommandLineRunner initDatabase(FishRepository repository) {
        FishInfo fish = new FishInfo("Pike","a","b","c","d",
                "e","f",0,"h");
        return args -> {
            repository.save(fish);
        };
    }
}