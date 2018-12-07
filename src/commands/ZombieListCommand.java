package commands;

import factory.ZombieFactory;
import src.Game;

public class ZombieListCommand extends NoParamsCommand {

	public final static String commandName = "zombieList";
	public final static String commandInfo = "[Z]ombieList";
	public final static String helpInfo = "Prints the list of available zombies.";

	public ZombieListCommand() {
		super(commandName, commandInfo, helpInfo);
	}

	@Override
	public boolean execute(Game game) {
		System.out.println(ZombieFactory.listofAvailableZombies());
		return false;
	}

}
