package br.com.cipher.loans.error;

public class RequestException extends RuntimeException{
    //costumer exception

    public RequestException(String message) {
        super(message);
    }

    public RequestException(String message, Throwable cause) {
        super(message, cause);
    }
}
