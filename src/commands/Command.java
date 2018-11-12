package commands;

public abstract class Command {
private String helpText;
private String helpInfo;
protected final String commandName;
	
	Command(String helpText, String helpInfo, String commandName){
		this.helpText = helpText;
		this.helpInfo = helpInfo;
		this.commandName = commandName;
	}
}
