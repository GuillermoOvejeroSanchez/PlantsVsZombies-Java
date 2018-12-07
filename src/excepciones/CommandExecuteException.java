package excepciones;

public class CommandExecuteException extends Throwable {

	private static final long serialVersionUID = 7184993906046688983L;

	public CommandExecuteException() {
		super("command Execute Error");
	}

	public CommandExecuteException(String message) {
		super(message);
	}


}
