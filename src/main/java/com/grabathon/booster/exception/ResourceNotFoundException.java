package com.grabathon.booster.exception;

public class ResourceNotFoundException extends Exception {
    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;

    /**
     * Instantiates a new resource not found exception.
     */
    public ResourceNotFoundException() {
        super();
    }

    /**
     * Instantiates a new resource not found exception.
     *
     * @param message the message
     */
    public ResourceNotFoundException(String message) {
        super(message);
    }

    /**
     * Instantiates a new resource not found exception.
     *
     * @param e the e
     */
    public ResourceNotFoundException(Throwable e) {
        super(e);
    }

    /**
     * Instantiates a new resource not found exception.
     *
     * @param message the message
     * @param e the e
     */
    public ResourceNotFoundException(String message, Throwable e) {
        super(message, e);
    }
}
