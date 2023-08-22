public class WrongOptionException extends ReservationCustomException {

    public int getCode() {
        return 101;
    }

    public WrongOptionException(String message) {
        super(message);
    }

}
