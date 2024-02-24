package Exceptions;

public class LivroSemExemplaresException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public LivroSemExemplaresException(String message) {
        super(message);
    }
}
