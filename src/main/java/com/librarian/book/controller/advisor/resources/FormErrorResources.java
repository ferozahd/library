package com.librarian.book.controller.advisor.resources;

import com.librarian.book.controller.advisor.enums.ErrorType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FormErrorResources {
    private ErrorType type;
    private int status;
    private List<String> errors;
    private LocalDateTime timestamp;

}
