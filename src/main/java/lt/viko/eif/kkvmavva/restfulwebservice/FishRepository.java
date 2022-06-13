package lt.viko.eif.kkvmavva.restfulwebservice;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

/**
 * Declaring interface to get all functionality
 */
@Configuration
public
interface FishRepository extends JpaRepository<FishInfo, Long> {
}