package lt.viko.eif.kkvmavva.restfulwebservice;

public class FishNotFoundException extends RuntimeException {

    FishNotFoundException(Long id) {
        super("Could not find employee " + id);
    }
}