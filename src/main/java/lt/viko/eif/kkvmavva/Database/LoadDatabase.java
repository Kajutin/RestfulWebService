package lt.viko.eif.kkvmavva.Database;

import lt.viko.eif.kkvmavva.restfulwebservice.FishInfo;
import lt.viko.eif.kkvmavva.restfulwebservice.FishRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Preloading data
 */
@Configuration
class LoadDatabase {

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(FishRepository repository) {

        FishInfo fish = new FishInfo("Pike","a","b","c","d",
                "e","f",0,"h");
        return args -> {
            log.info("Preloading " + repository.save(fish));
        };
    }
}