package dev.mhshahin.demosmallcompany.exceptions;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import dev.mhshahin.demosmallcompany.utils.APIResponse;
import lombok.extern.slf4j.Slf4j;
import org.flywaydb.core.api.exception.FlywayValidateException;
import org.hibernate.validator.internal.engine.ConstraintViolationImpl;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import javax.persistence.EntityNotFoundException;
import javax.validation.ConstraintDeclarationException;
import javax.validation.ConstraintViolationException;
import javax.validation.UnexpectedTypeException;
import java.util.Objects;

import static dev.mhshahin.demosmallcompany.utils.APIHelperUtil.createUnifiedResponse;
import static dev.mhshahin.demosmallcompany.utils.Constants.FLYWAY_MIGRATION_FAILED;
import static dev.mhshahin.demosmallcompany.utils.Constants.INTERNAL_SERVER_ERROR_MESSAGE;
import static org.springframework.http.HttpStatus.*;


@ControllerAdvice
@Component
@Slf4j
    public class GlobalExceptionHandler {


    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<APIResponse> handleDataIntegrityViolationException(DataIntegrityViolationException exception) {
        // general exception
        log.error("Error while validating request constraint : ", exception);
        if (Objects.requireNonNull(exception.getMessage()).contains("unique constraint")) {
            return createUnifiedResponse(null, BAD_REQUEST, "Duplicate value is not allowed - Unique Contraint captured it");
        }
        return createUnifiedResponse(null, BAD_REQUEST, exception.getMessage());
    }
        @ExceptionHandler
        public ResponseEntity<APIResponse> handle(Exception exception) {
            // general exception
            log.error("Internal Server Error, Please try again later With Exception : ", exception);
            return createUnifiedResponse(null, INTERNAL_SERVER_ERROR, INTERNAL_SERVER_ERROR_MESSAGE);
        }

        @ExceptionHandler(InvalidFormatException.class)
        public ResponseEntity<APIResponse> handleInvalidFormatException(InvalidFormatException ex) {
            log.error("Invalid Format Exception :  ", ex);
            return createUnifiedResponse(null, BAD_REQUEST, ex.getMessage());

        }

        @ExceptionHandler(EntityNotFoundException.class)
        public ResponseEntity<APIResponse> handleEntityNotFoundException(EntityNotFoundException ex) {
            log.error("Entity Not Found Exception :  ", ex);
            return createUnifiedResponse(null, NOT_FOUND, ex.getMessage());

        }
        @ExceptionHandler(ConstraintViolationException.class)
        public ResponseEntity<APIResponse> handleConstraintViolationException(ConstraintViolationException ex) {
            log.error("ConstraintViolationException :  ", ex);
            StringBuffer pureMessage = new StringBuffer();
            pureMessage.append("Duplicate value is not allowed - Unique Contraint captured it \n");
            for (Object cv : ex.getConstraintViolations()) {
                pureMessage.append(((ConstraintViolationImpl)cv).getMessageTemplate());
            }
            return createUnifiedResponse(null, BAD_REQUEST, pureMessage.toString());
        }
        @ExceptionHandler(ConstraintDeclarationException.class)
        public ResponseEntity<APIResponse> handleConstraintDeclarationException(ConstraintDeclarationException exception) {
            log.error("Error while validating request constraint : ", exception);
            return createUnifiedResponse(null, BAD_REQUEST, exception.getMessage());
        }

        @ExceptionHandler(UnexpectedTypeException.class)
        public ResponseEntity<APIResponse> handleUnexpectedTypeException(UnexpectedTypeException exception) {
            log.error("Error while validating request constraint  : ", exception);
            return createUnifiedResponse(null, BAD_REQUEST, exception.getMessage());
        }

        @ExceptionHandler(JsonProcessingException.class)
        public ResponseEntity<APIResponse> handleJsonProcessingException(JsonProcessingException ex) {
            log.error("JSON Parsing [from parameters map to column string] Error : ", ex);
            return createUnifiedResponse(null, BAD_REQUEST, ex.getMessage());
        }


        @ExceptionHandler(HttpStatusCodeException.class)
        public ResponseEntity<APIResponse> handHttpStatusCodeException(HttpStatusCodeException ex) {
            log.error("HttpStatusCodeException : ", ex);
            return createUnifiedResponse(null, ex.getStatusCode(), ex.getMessage());
        }



        @ExceptionHandler(IllegalArgumentException.class)
        public ResponseEntity<APIResponse> handleIllegalArgumentException(IllegalArgumentException ex) {
            log.error("IllegalArgumentException : ", ex);
            return createUnifiedResponse(null, INTERNAL_SERVER_ERROR, ex.getMessage());
        }

        @ExceptionHandler(HttpServerErrorException.InternalServerError.class)
        public ResponseEntity<APIResponse> handleHttpServerErrorException(HttpServerErrorException ex) {
            log.error("HttpServerErrorException : ", ex);
            return createUnifiedResponse(null, ex.getStatusCode(), ex.getResponseBodyAsString());
        }


        @ExceptionHandler(ResourceNotFoundException.class)
        public ResponseEntity<APIResponse>  handleResourceNotFoundException(
                ResourceNotFoundException exception) {
            log.error("No Data Found For Selected Item ", exception);
            return  createUnifiedResponse(null, OK, exception.getMessage());
        }

        @ExceptionHandler(MethodArgumentNotValidException.class)
        public ResponseEntity<APIResponse>  handleMethodArgumentNotValid(MethodArgumentNotValidException ex) {
            log.error("Validation Failed With Exception : ", ex);
            StringBuilder errorString = new StringBuilder();
            ex.getBindingResult().getFieldErrors()
                    .forEach(p -> errorString.append(p.getDefaultMessage()).append(System.getProperty("line.separator")));
            return  createUnifiedResponse(null, BAD_REQUEST, errorString.toString());
        }

        @ExceptionHandler(MethodArgumentTypeMismatchException.class)
        public ResponseEntity<APIResponse> handleMethodArgumentTypeMismatchException(MethodArgumentTypeMismatchException ex) {
            log.error("Validation Failed With Exception : ", ex);
            return  createUnifiedResponse(null, BAD_REQUEST, ex.getName() + " : " + ex.getErrorCode() + " : " + ex.getMessage());
        }

        @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
        public ResponseEntity<APIResponse>  handleHttpRequestMethodNotSupportedException(
                HttpRequestMethodNotSupportedException ex) {
            log.error("Method not allowed With Exception : ", ex);
            return  createUnifiedResponse(null, BAD_REQUEST,ex.getMessage());
        }


        @ExceptionHandler(FlywayValidateException.class)
        public ResponseEntity<APIResponse> handleFlywayValidateException(FlywayValidateException exception) {
            log.error("Flyway migration error : ", exception);
            return createUnifiedResponse(null, INTERNAL_SERVER_ERROR, FLYWAY_MIGRATION_FAILED);
        }




    }
