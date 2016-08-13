package com.stevesoltys.indeed.exception;

/**
 * @author Steve Soltys
 */
public class IndeedParseException extends IndeedException {

    public IndeedParseException(String message) {
        super("Error while parsing response: " + message);
    }
}
