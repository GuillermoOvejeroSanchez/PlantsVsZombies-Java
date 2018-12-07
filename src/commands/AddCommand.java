package commands;

import elems.Plant;
import excepciones.CommandExecuteException;
import excepciones.CommandParseException;
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

	public Command parse(String[] comando) throws CommandParseException {
		Command c = null;

		if ((comando[0].equals(AddCommand.commandName) || comando[0].equals(AddCommand.commandName.substring(0, 1)))) {
			if (comando.length == 4) {
				try {
					this.x = Integer.parseInt(comando[2]);
					this.y = Integer.parseInt(comando[3]);
				} catch (NumberFormatException e) {
					System.err.println(e.getClass() + " " + e.getMessage() + " invalid input");
				}

				c = new AddCommand(x, y, comando[1]);
			} else {
				throw new CommandParseException(
						"Incorrect number of arguments: " + comando.length + " out of 4 arguments added");
			}
		}

		return c;
	}

	@Override
	public boolean execute(Game game) throws CommandExecuteException {
		boolean executed = false;
		Plant p = PlantsFactory.getPlant(name, x, y, game);
		if (p != null) {
			game.addPlant(p);
			executed = true;
		}
		else
			throw new CommandExecuteException("Unknown plant name " + name);

		return executed;
	}
}
