package commands;

import elems.Plant;
import factory.PlantsFactory;
import src.Game;

public class AddCommand extends Command {
	private int x, y;
	private String name;

	public final static String commandName = "add";
	public final static String commandInfo = "[A]dd";
	public final static String helpInfo = "<name> <x> <y>: Adds a name in position x, y.";

	public AddCommand() {
		super(commandName, commandInfo, helpInfo);
	}

	public AddCommand(int x, int y, String name) {
		super(commandName, commandInfo, helpInfo);
		this.x = x;
		this.y = y;
		this.name = name;
	}

	@Override
	public Command parse(String[] comando) {
		Command c = null;

		try {
			if (comando.length == 4
					&& (comando[0].equals(commandName) || comando[0].equals(commandName.substring(0, 1)))) {
				this.x = Integer.parseInt(comando[2]);
				this.y = Integer.parseInt(comando[3]);
				c = new AddCommand(x, y, comando[1]);
			}
		} catch (NumberFormatException e) {
			System.err.println(e.getClass() + " " + e.getMessage() + " invalid input");
		}
		return c;
	}

	@Override
	public boolean execute(Game game) {
		boolean executed = true;
		Plant p = PlantsFactory.getPlant(name, x, y, game);
		if (!game.addPlant(p)) {
			executed = false;
		}
		return executed;
	}
}
