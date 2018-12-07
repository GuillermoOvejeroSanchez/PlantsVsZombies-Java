package commands;

import excepciones.CommandExecuteException;
import excepciones.CommandParseException;
import src.Game;

public abstract class Command {

	private String helpText;
	private String commandText;
	protected final String commandName;

	public Command(String commandText, String commandInfo, String helpInfo) {
		this.commandText = commandInfo;
		this.helpText = helpInfo;
		String[] commandInfoWords = commandText.split("\\s+");
		commandName = commandInfoWords[0];
	}

	public abstract Command parse(String[] comando) throws CommandParseException;

	public abstract boolean execute(Game game) throws CommandExecuteException;
	
	

	public String helpText() {
		StringBuilder helpText = new StringBuilder();
		helpText.append(commandText + "\t: " + this.helpText);
		return helpText.toString();
	}

}
