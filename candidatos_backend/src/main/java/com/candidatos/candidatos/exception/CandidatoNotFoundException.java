package com.candidatos.candidatos.exception;

public class CandidatoNotFoundException extends RuntimeException{

    public CandidatoNotFoundException() {
        super();
    }

    public CandidatoNotFoundException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public CandidatoNotFoundException(final String message) {
        super(message);
    }

    public CandidatoNotFoundException(final Throwable cause) {
        super(cause);
    }
}
