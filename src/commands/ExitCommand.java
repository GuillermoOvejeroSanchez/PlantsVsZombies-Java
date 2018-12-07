package commands;

import src.Game;

public class ExitCommand extends NoParamsCommand {
	public final static String commandName = "exit";
	public final static String commandInfo = "[E]xit";
	public final static String helpInfo = "Terminates the program.";

	public ExitCommand() {
		super(commandName, commandInfo, helpInfo);

	}

	@Override
	public boolean execute(Game game) {
		game.setExit(true);
		return false;
	}


}
