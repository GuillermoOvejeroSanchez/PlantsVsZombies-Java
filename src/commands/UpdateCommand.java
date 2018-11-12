package commands;

import src.Controller;
import src.Game;

public class UpdateCommand extends NoParamsCommand {

	public final static String commandName = "none";
	public final static String commandInfo = "[N]one";
	public final static String helpInfo = "Skips cycle.";

	public UpdateCommand() {
		super(commandName, commandInfo, helpInfo);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void execute(Game game, Controller controler) {

	}

}
