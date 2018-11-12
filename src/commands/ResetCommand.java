package commands;

import src.Controller;
import src.Game;

public class ResetCommand extends NoParamsCommand {

	public final static String commandName = "reset";
	public final static String commandInfo = "[R]eset";
	public final static String helpInfo = "Starts a new game.";

	public ResetCommand() {
		super(commandName, commandInfo, helpInfo);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void execute(Game game, Controller controler) {
		game.reset();
	}

}
