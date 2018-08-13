package com.candidatos.candidatos.exception;

public class CandidatoMismatchException extends RuntimeException {
    public CandidatoMismatchException() {
        super();
    }

    public CandidatoMismatchException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public CandidatoMismatchException(final String message) {
        super(message);
    }

    public CandidatoMismatchException(final Throwable cause) {
        super(cause);
    }
}
