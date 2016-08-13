package com.stevesoltys.indeed.exception;

/**
 * @author Steve Soltys
 */
public class IndeedParameterException extends IndeedException {

    public IndeedParameterException(String parameter) {
        super("Required parameter not set: " + parameter);
    }
}
