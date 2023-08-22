public class OnlyNumberException extends ReservationCustomException {
    public int getCode() {
        return 102;
    }

    public OnlyNumberException(String message) {
        super(message);
    }
}
