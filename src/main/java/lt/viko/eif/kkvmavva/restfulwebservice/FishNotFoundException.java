package lt.viko.eif.kkvmavva.restfulwebservice;

/**
 * Throws exception
 */
public class FishNotFoundException extends RuntimeException {
    FishNotFoundException(Long id) {
        super(String.format("Where is no such fish with %d id",id));
    }
}