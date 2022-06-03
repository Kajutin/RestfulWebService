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
            repository.save(new FishInfo("Atlantic salmon","Freshwater, Saltwater","Baltic sea, " +
                    "Curonian Lagoon, in Nemunas from Baltic sea to Kaunas hydroelectric power plant",
                    "Vulnerable ","During breeding season in legal places",
                    "Autumn","October-December",65,
                    "While young they have blue and red spots. At maturity, they take on a silver-blue sheen." +
                            "Adults have black spots predominantly above the lateral line"));
            repository.save(new FishInfo("Sea lamprey","Saltwater","Baltic sea, Curonian Lagoon," +
                    "Nemunas delta",
                    "Least Concern - Endangered in Lithuania","-",
                    "Spring","In Lithuania red book",0,
                    "Has an eel-like body without paired fins. Its mouth is jawless, round and sucker-like," +
                            " and as wide or wider than the head; sharp teeth are arranged in many consecutive circular" +
                            " rows."));
        };
    }
}