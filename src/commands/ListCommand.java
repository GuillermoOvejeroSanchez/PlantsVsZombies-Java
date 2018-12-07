package commands;

import factory.PlantsFactory;
import src.Game;

public class ListCommand extends NoParamsCommand {

	public final static String commandName = "List";
	public final static String commandInfo = "[L]ist";
	public final static String helpInfo = "Prints the list of available plants.";

	public ListCommand() {
		super(commandName, commandInfo, helpInfo);
	}


	@Override
	public boolean execute(Game game) {
		System.out.println(PlantsFactory.listOfAvailablePlants());
		return false;
	}

}
