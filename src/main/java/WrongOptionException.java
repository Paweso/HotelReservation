public class WrongOptionException extends RuntimeException {

    public WrongOptionException() {
        super();
    }

    public int getCode() {
        return 101;
    }

    public WrongOptionException(String message) {
        super(message);
    }

}
