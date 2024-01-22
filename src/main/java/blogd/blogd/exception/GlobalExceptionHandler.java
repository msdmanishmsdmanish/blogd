package blogd.blogd.exception;

import blogd.blogd.payload.ErrorDetails;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorDetails>resourceNotFoundException(
            ResourceNotFoundException e, WebRequest webRequest
            ){
        ErrorDetails errorDetails=new ErrorDetails(e.getMessage(),new Date(),webRequest.getDescription(true));
        return new ResponseEntity<>(errorDetails, HttpStatus.OK);
    }
}
