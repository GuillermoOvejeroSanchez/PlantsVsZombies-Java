package excepciones;

public class CommandParseException extends Throwable{

	private static final long serialVersionUID = -5080960751433123333L;
	
	
	public CommandParseException() {
		super("Unknown Command, use 'help' to see the list of commands");
	}
	
	public CommandParseException(String message) {
		super(message);
	}
	
}
