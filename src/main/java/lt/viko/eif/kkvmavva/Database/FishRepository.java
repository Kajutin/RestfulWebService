package lt.viko.eif.kkvmavva.Database;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
interface FishRepository extends CrudRepository<FishInfo, Long> {
}