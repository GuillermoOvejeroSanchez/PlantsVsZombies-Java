package commands;

import src.Game;

public class UpdateCommand extends NoParamsCommand {

	public final static String commandName = "None";
	public final static String commandInfo = "[N]one";
	public final static String helpInfo = "Skips cycle.";

	public UpdateCommand() {
		super(commandName, commandInfo, helpInfo);
	}

	@Override
	public boolean execute(Game game) {
		game.update();
		return true;
	}

}
