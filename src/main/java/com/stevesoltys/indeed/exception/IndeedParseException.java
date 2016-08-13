package com.stevesoltys.indeed.exception;

/**
 * Occurs when there is an error parsing an Indeed API response.
 *
 * @author Steve Soltys
 */
public class IndeedParseException extends IndeedException {

    public IndeedParseException(String message) {
        super("Error while parsing response: " + message);
    }
}
