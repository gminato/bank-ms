package monkey.luffy.accounts.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class CustomerAlreadyExistsException extends RuntimeException{

    public CustomerAlreadyExistsException(String message) {
        super(message);
    }
    
}
