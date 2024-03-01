package Exceptions;

public class ExemplarNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public ExemplarNotFoundException(String message) {
		super(message);
	}

}