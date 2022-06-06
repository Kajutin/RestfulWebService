package lt.viko.eif.kkvmavva.restfulwebservice;

import org.json.simple.JSONObject;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * Loads JSON file
 */
@Component
class DatabaseLoader {
    /**
     * Reads JSON file and loads to web database
     * @param repository
     * @return
     */
    @Bean
    CommandLineRunner initDatabase(FishRepository repository) {
        JSON json= new JSON();
        json.ReadJSONFile();
        return args -> { // repository.save() is responsible for uploading data to web
            // fishList stores all JSON information
            // With parseFish we get one fish information. It returns FishInfo
            json.fishList.forEach(fishList -> repository.save(json.parseFish((JSONObject) fishList)));
        };
    }
}
