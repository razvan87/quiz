package com.quiz.rest.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.*;


@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@ToString
@Builder
//@JsonInclude(JsonInclude.Include.NON_NULL)
public class ErrorInfo {
    private int status;
    private String messageKey;
    private String message;
    private List<FieldErrorInfo> fieldErrors;

    private Integer internalCode;

    private String developerMessage;
    private String developerResource;
}
