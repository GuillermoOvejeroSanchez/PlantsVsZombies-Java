package commands;

import src.Game;

public class ResetCommand extends NoParamsCommand {

	public final static String commandName = "reset";
	public final static String commandInfo = "[R]eset";
	public final static String helpInfo = "Starts a new game.";

	public ResetCommand() {
		super(commandName, commandInfo, helpInfo);
	}

	@Override
	public boolean execute(Game game) {
		game.reset();
		return true;
	}

}
