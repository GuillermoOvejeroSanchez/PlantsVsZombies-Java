package commands;

import factory.PlantsFactory;
import src.Controller;
import src.Game;

public class ListCommand extends NoParamsCommand {

	public final static String commandName = "list";
	public final static String commandInfo = "[L]ist";
	public final static String helpInfo = "Prints the list of available plants.";

	public ListCommand() {
		super(commandName, commandInfo, helpInfo);
	}

	@Override
	public void execute(Game game, Controller controller) {
		System.out.println(PlantsFactory.listOfAvailablePlants());
		controller.setNoPrintGameState();
		controller.setNoUpdateGameState();

	}

}
