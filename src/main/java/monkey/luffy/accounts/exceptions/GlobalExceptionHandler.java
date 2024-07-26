package monkey.luffy.accounts.exceptions;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import monkey.luffy.accounts.dto.ErrorResponseDto;

@ControllerAdvice
public class GlobalExceptionHandler {
     @ExceptionHandler(CustomerAlreadyExistsException.class)
    public ResponseEntity<ErrorResponseDto> handleCustomerAlreadyExistsException(CustomerAlreadyExistsException exception,
                                                                                 WebRequest webRequest){
        ErrorResponseDto errorResponseDTO = new ErrorResponseDto(
                webRequest.getDescription(false),
                HttpStatus.BAD_REQUEST,
                exception.getMessage(),
                LocalDateTime.now()
        );
        return new ResponseEntity<>(errorResponseDTO, HttpStatus.BAD_REQUEST);
    }  

    @ExceptionHandler(ResourceNotFoundClassException.class)
    public ResponseEntity<ErrorResponseDto> handleResourceNotFoundException(ResourceNotFoundClassException exception,WebRequest webRequest) {
        ErrorResponseDto errorResponseDto = new ErrorResponseDto(
            webRequest.getDescription(false),
            HttpStatus.NOT_FOUND,
            exception.getMessage(),
            LocalDateTime.now()
        );

        return new ResponseEntity<>(errorResponseDto,HttpStatus.NOT_FOUND);
    }
}
