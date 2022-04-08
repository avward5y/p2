package com.revature.p2.myp2.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.Date;


@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Dialect<T> {

    private Status status;
    private T payload;
    private Object errors;
    private Object metadata;

    public static <T> Dialect<T> badRequest() {
        Dialect<T> Dialect = new Dialect<>();
        Dialect.setStatus(Status.BAD_REQUEST);
        return Dialect;
    }

    public static <T> Dialect<T> ok() {
        Dialect<T> Dialect = new Dialect<>();
        Dialect.setStatus(Status.OK);
        return Dialect;
    }

    public static <T> Dialect<T> unauthorized() {
        Dialect<T> Dialect = new Dialect<>();
        Dialect.setStatus(Status.UNAUTHORIZED);
        return Dialect;
    }

    public static <T> Dialect<T> validationException() {
        Dialect<T> Dialect = new Dialect<>();
        Dialect.setStatus(Status.VALIDATION_EXCEPTION);
        return Dialect;
    }

    public static <T> Dialect<T> wrongCredentials() {
        Dialect<T> Dialect = new Dialect<>();
        Dialect.setStatus(Status.WRONG_CREDENTIALS);
        return Dialect;
    }

    public static <T> Dialect<T> accessDenied() {
        Dialect<T> Dialect = new Dialect<>();
        Dialect.setStatus(Status.ACCESS_DENIED);
        return Dialect;
    }

    public static <T> Dialect<T> exception() {
        Dialect<T> Dialect = new Dialect<>();
        Dialect.setStatus(Status.EXCEPTION);
        return Dialect;
    }

    public static <T> Dialect<T> notFound() {
        Dialect<T> Dialect = new Dialect<>();
        Dialect.setStatus(Status.NOT_FOUND);
        return Dialect;
    }

    public static <T> Dialect<T> duplicateEntity() {
        Dialect<T> Dialect = new Dialect<>();
        Dialect.setStatus(Status.DUPLICATE_ENTITY);
        return Dialect;
    }

    public void addErrorMsgToDialect(String errorMsg, Exception ex) {
        DialectError error = new DialectError()
                .setDetails(errorMsg)
                .setMessage(ex.getMessage())
                .setTimestamp(new Date());
        setErrors(error);
    }

    public enum Status {
        OK, BAD_REQUEST, UNAUTHORIZED, VALIDATION_EXCEPTION, EXCEPTION, WRONG_CREDENTIALS, ACCESS_DENIED, NOT_FOUND, DUPLICATE_ENTITY
    }

    @Getter
    @Accessors(chain = true)
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class PageMetadata {
        private int size;
        private long totalElements;
        private int totalPages;
        private int number;

        public PageMetadata(int size, long totalElements, int totalPages, int number) {
            this.size = size;
            this.totalElements = totalElements;
            this.totalPages = totalPages;
            this.number = number;
        }
    }

}