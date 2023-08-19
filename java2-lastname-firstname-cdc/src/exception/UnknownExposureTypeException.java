package exception;

public class UnknownExposureTypeException extends RuntimeException{
	private static final long serialVersionUID = 1L;

	public UnknownExposureTypeException(String msg) {
		super(msg);
	}
}
