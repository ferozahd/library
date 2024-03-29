package com.librarian.book.controller.advisor;
import com.librarian.book.controller.advisor.enums.ErrorType;
import com.librarian.book.controller.advisor.resources.FormErrorResources;
import com.librarian.book.exception.InvalidConversion;
import com.librarian.book.exception.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
@ControllerAdvice
public class ControllerAdvisors {
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<FormErrorResources> handleResourceNotFoundException(ResourceNotFoundException exception){
        FormErrorResources error =new FormErrorResources();
        error.setErrors(List.of(exception.getMessage()));
        error.setType(ErrorType.RESOURCE_NOT_FOUND);
        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setTimestamp(LocalDateTime.now());
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(error);
    }
    @ExceptionHandler({HttpMessageNotReadableException.class})
    public ResponseEntity<FormErrorResources> handleJsonExceptionInPost(HttpMessageNotReadableException exception){
        FormErrorResources error =new FormErrorResources();
        error.setErrors(List.of("Post body is not valid, May be some data are not convertable"));
        error.setType(ErrorType.BAD_REQUEST);
        error.setStatus(HttpStatus.BAD_REQUEST.value());
        error.setTimestamp(LocalDateTime.now());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(error);
    }
    @ExceptionHandler({ConstraintViolationException.class})
    public ResponseEntity<FormErrorResources> handleJsonExceptionInPost(ConstraintViolationException exception){
        List<String> violations = exception.getConstraintViolations().stream().map(ConstraintViolation::getMessage).collect(Collectors.toList());
        FormErrorResources error =new FormErrorResources();
        error.setErrors(violations);
        error.setType(ErrorType.NOTIFY_DEVELOPER);
        error.setStatus(HttpStatus.BAD_REQUEST.value());
        error.setTimestamp(LocalDateTime.now());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(error);
    }


    @ExceptionHandler({InvalidConversion.class})
    public ResponseEntity<FormErrorResources> handleJsonExceptionInPost(InvalidConversion exception){

        FormErrorResources error =new FormErrorResources();
        error.setErrors(List.of(exception.getMessage()));
        error.setType(ErrorType.FORM_VALIDATION);
        error.setStatus(HttpStatus.BAD_REQUEST.value());
        error.setTimestamp(LocalDateTime.now());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(error);
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleDataValidationException(MethodArgumentNotValidException exception){

        List<String> errors = exception.getBindingResult()
                .getFieldErrors()
                .stream().map(fieldError -> fieldError.getDefaultMessage()).collect(Collectors.toList());


        FormErrorResources error =new FormErrorResources();
        error.setErrors(errors);
        error.setType(ErrorType.FORM_VALIDATION);
        error.setStatus(HttpStatus.BAD_REQUEST.value());
        error.setTimestamp(LocalDateTime.now());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(error);

    }


}