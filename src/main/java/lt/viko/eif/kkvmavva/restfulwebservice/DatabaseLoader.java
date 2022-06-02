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

        return args -> {
            repository.save(new FishInfo("European Pike","Freshwater","River, Lake",
                    "Least Concern","Summer-Autumn",
                    "February-April","February-April",50,
                    "Olive green, shading from yellow to white along the belly. Have very sharp and" +
                            " numerous teeth"));
            repository.save(new FishInfo("European perch","Freshwater","Slow-flowing rivers," +
                    " deep lakes, ponds",
                    "Least Concern","Autumn",
                    "March-April","-",0,
                    "Greenish with red pelvic, anal and caudal fins. They have five to eight dark vertical" +
                            " bars on their sides."));
        };
    }
}