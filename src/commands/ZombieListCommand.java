package commands;

import factory.ZombieFactory;
import src.Controller;
import src.Game;

public class ZombieListCommand extends NoParamsCommand {

	public final static String commandName = "zombieList";
	public final static String commandInfo = "[Z]ombieList";
	public final static String helpInfo = "Prints the list of available zombies.";

	public ZombieListCommand() {
		super(commandName, commandInfo, helpInfo);
	}

	@Override
	public void execute(Game game, Controller controller) {
		System.out.println(ZombieFactory.listofAvailableZombies());
		controller.setNoPrintGameState();
		controller.setNoUpdateGameState();
	}

}
