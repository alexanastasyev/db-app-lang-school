package dev.alexanastasyev.dbapp_languagesschool.exception;

public class InvalidValuesException extends RuntimeException {
    public InvalidValuesException() {
    }

    public InvalidValuesException(String message) {
        super(message);
    }

    public InvalidValuesException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidValuesException(Throwable cause) {
        super(cause);
    }
}
