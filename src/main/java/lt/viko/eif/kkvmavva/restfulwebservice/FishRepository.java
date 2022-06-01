package lt.viko.eif.kkvmavva.restfulwebservice;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
interface FishRepository extends CrudRepository<FishInfo, Long> {
}