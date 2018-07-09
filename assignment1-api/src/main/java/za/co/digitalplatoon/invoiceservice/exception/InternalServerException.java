package za.co.digitalplatoon.invoiceservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author tshegomasedi
 */

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class InternalServerException extends RuntimeException {

    public InternalServerException(String resourceName) {
        super(String.format("%s with exact details already exists, or details provided are incorrect", resourceName));
    }
}
