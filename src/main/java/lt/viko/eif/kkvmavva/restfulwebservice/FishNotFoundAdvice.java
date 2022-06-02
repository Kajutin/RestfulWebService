package lt.viko.eif.kkvmavva.restfulwebservice;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class FishNotFoundAdvice {
    @ResponseBody
    @ExceptionHandler(FishNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String fishNotFoundException(FishNotFoundException ex) {
        return ex.getMessage();
    }
}
