package lt.viko.eif.kkvmavva.restfulwebservice;

import org.springframework.data.repository.CrudRepository;

/**
 * Declaring interface to get all functionality
 */
public interface FishRepository extends CrudRepository<FishInfo, Long> {
}
