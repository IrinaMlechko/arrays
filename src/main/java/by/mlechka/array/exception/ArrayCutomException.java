package by.mlechka.array.exception;

public class ArrayCutomException extends Exception {
    public ArrayCutomException() {
    }

    public ArrayCutomException(String message) {
        super(message);
    }

    public ArrayCutomException(String message, Throwable cause) {
        super(message, cause);
    }

    public ArrayCutomException(Throwable cause) {
        super(cause);
    }
}
