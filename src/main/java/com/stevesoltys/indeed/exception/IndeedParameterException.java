package com.stevesoltys.indeed.exception;

/**
 * Occurs when a required parameter is not given in a search query.
 *
 * @author Steve Soltys
 */
public class IndeedParameterException extends IndeedException {

    public IndeedParameterException(String parameter) {
        super("Required parameter not set: " + parameter);
    }
}
