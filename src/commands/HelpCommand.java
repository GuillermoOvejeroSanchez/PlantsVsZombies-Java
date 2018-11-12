package commands;

import src.Controller;
import src.Game;
import util.CommandParser;

public class HelpCommand extends NoParamsCommand {
	public final static String commandName = "help";
	public final static String commandInfo = "[H]elp";
	public final static String helpInfo = "Prints this help message.";

	public HelpCommand() {
		super(commandName, commandInfo, helpInfo);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void execute(Game game, Controller controller) {
		System.out.println(CommandParser.CommandHelp());
		controller.setNoPrintGameState();
	}

}
