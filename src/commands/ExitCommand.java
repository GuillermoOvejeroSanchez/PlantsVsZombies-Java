package commands;

import src.Controller;
import src.Game;

public class ExitCommand extends NoParamsCommand {
	public final static String commandName = "exit";
	public final static String commandInfo = "[E]xit";
	public final static String helpInfo = "Terminates the program.";

	public ExitCommand() {
		super(commandName, commandInfo, helpInfo);

	}

	@Override
	public void execute(Game game, Controller controller) {
		controller.setNoSalir();
		controller.setNoPrintGameState();
	}

}
