package com.kenite.automation.core.exceptions;

/**
 * @author olufemi on 2019-05-16
 *
 * Runtime KeniteWebException
 */
public class KeniteWebException extends RuntimeException {

    public KeniteWebException(String message) {
        super(message);
    }

    public KeniteWebException(String message, Throwable cause) {
        super(message, cause);
    }
}
