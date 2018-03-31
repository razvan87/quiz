//package com.quiz.rest.util;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Locale;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.MessageSource;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Component;
//import org.springframework.validation.BindingResult;
//import org.springframework.validation.FieldError;
//
//import com.quiz.rest.dto.ErrorInfo;
//import com.quiz.rest.dto.FieldErrorInfo;
//import com.quiz.service.errors.LocalizableRuntimeException;
//
//
//
//@Component
//public class ErrorInfoFactory {
//
//    private MessageSource messageSource;
//
//    @Autowired
//    public ErrorInfoFactory(MessageSource messageSource) {
//        this.messageSource = messageSource;
//    }
//
//    public ErrorInfo getInstance(Exception e, HttpStatus status) {
//        return ErrorInfo.builder()
//            .status(status.value())
//            .messageKey(e.toString())
//            .message(e.getMessage())
//            .developerMessage(e.getMessage())
//            .build();
//    }
//
//    public ErrorInfo getLocalizedInstance(HttpStatus status, LocalizableRuntimeException e) {
//        return ErrorInfo.builder()
//            .status(status.value())
//            .messageKey(e.getMessageKey())
//            .message(messageSource.getMessage(e.getMessageKey(), e.getMessageArguments(), e.getMessage(), getCurrentUserLocale()))
//            .developerMessage(e.getMessage())
//            .build();
//    }
//
//    public ErrorInfo getLocalizedInstance(HttpStatus status, String messageKey, Object ... messageArguments) {
//        return ErrorInfo.builder()
//            .status(status.value())
//            .messageKey(messageKey)
//            .message(messageSource.getMessage(messageKey, messageArguments, getCurrentUserLocale()))
//            .build();
//    }
//
//    private Locale getCurrentUserLocale(){
//        return Locale.ENGLISH;
//    }
//
//	public static ErrorInfo buildBadRequestErrorInfo(String message, String messageKey, BindingResult bindingResult) {
//		List<FieldErrorInfo> fieldErrors = new ArrayList<>();
//		List<FieldError> errors = bindingResult.getFieldErrors();
//		for (FieldError error : errors) {
//			fieldErrors.add(new FieldErrorInfo(error.getDefaultMessage(), error.getField(), messageKey + "." + error.getField() + "." + error.getCode(),
//					error.getRejectedValue()));
//		}
//		return ErrorInfo.builder()
//            .status(HttpStatus.BAD_REQUEST.value())
//            .message(message)
//            .messageKey(messageKey)
//            .fieldErrors(fieldErrors)
//            .build();
//	}
//
//    public ResponseEntity<ErrorInfo> createResponseEntityForError(
//        HttpStatus httpStatus, String messageKey, Object ... messageArguments) {
//        return ResponseEntity
//            .status(httpStatus)
//            .body(getLocalizedInstance(httpStatus, messageKey, messageArguments));
//    }
//
//
//    public ResponseEntity<ErrorInfo> createResponseEntityForErrorWithDetails(
//        HttpStatus httpStatus, String messageKey, String details, Object ... messageArguments) {
//       ErrorInfo i = getLocalizedInstance(httpStatus, messageKey, messageArguments);
//       	i.setDeveloperMessage(details);
//    	return ResponseEntity 
//            .status(httpStatus)
//            .body(i);
//    }
//	public ErrorInfo buildBadRequestErrorInfo(String message, String messageKey, List<FieldError> errors) {
//			List<FieldErrorInfo> fieldErrors = new ArrayList<>();
//			for (FieldError error : errors) {
//				fieldErrors.add(new FieldErrorInfo(messageSource.getMessage(error.getCode(), error.getArguments(), error.getDefaultMessage(),getCurrentUserLocale()), error.getField(), error.getCode(),
//						error.getRejectedValue()));
//			}
//			return ErrorInfo.builder()
//	            .status(HttpStatus.BAD_REQUEST.value())
//	            .message(message)
//	            .messageKey(messageKey)
//	            .fieldErrors(fieldErrors)
//	            .build();
//	}
//	
//    public ErrorInfo getLocalizedInstance1(HttpStatus status, LocalizableRuntimeException e) {
//        return ErrorInfo.builder()
//            .status(status.value())
//            .messageKey(e.getMessageKey())
//            .message(messageSource.getMessage(e.getMessageKey(), e.getMessageArguments(), e.getMessage(), getCurrentUserLocale()))
//            .developerMessage(e.getMessage())
//            .build();
//    }
//	
//}
