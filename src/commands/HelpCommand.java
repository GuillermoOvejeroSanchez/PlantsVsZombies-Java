package commands;

import src.Controller;
import src.Game;

public class HelpCommand extends NoParamsCommand {
	public final static String commandName = "help";
	public final static String commandInfo = "[H]elp";
	public final static String helpInfo = "Prints this help message.";

	public HelpCommand() {
		super(commandName, commandInfo, helpInfo);
	}

	@Override
	public void execute(Game game, Controller controller) {
		System.out.println(CommandParse.CommandHelp());
		controller.setNoPrintGameState();
		controller.setNoUpdateGameState();
	}

}
