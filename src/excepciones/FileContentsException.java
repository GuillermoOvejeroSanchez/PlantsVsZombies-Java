package excepciones;

public class FileContentsException extends Throwable {

	private static final long serialVersionUID = 7669068857961246139L;

	public FileContentsException() {
		super("File Contents Exception");
	}

	public FileContentsException(String message) {
		super(message);
	}

}
