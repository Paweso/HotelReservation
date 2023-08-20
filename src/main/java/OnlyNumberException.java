public class OnlyNumberException extends RuntimeException {
    public int getCode() {
        return 102;
    }

    public OnlyNumberException(){
        super();
    }

    public OnlyNumberException(String message) {
        super(message);
    }
}
