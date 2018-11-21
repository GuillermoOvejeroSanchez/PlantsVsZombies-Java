package commands;

import elems.Plant;
import factory.PlantsFactory;
import src.Controller;
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
	public Command parse(String[] comando, Controller controller) {
		Command c = null;

		if (comando.length == 4 && (comando[0].equals(commandName) || comando[0].equals(commandName.substring(0, 1)))) {

			this.x = Integer.parseInt(comando[2]);
			this.y = Integer.parseInt(comando[3]);
			c = new AddCommand(x, y, comando[1]);
		}

		return c;
	}

	@Override
	public void execute(Game game, Controller controller) {
		Plant p = PlantsFactory.getPlant(name, x, y, game);
		if (p != null && game.isEmpty(x, y)) {
			if (game.getSuncoins() >= p.getCost()) {
				game.addPlant(p);
				game.modifySuncoins(-p.getCost());
			} else {
				System.err.println("Not Enough Suncoins");
				controller.setNoPrintGameState();
			}
		} else {
			System.err.println("Invalid Plant or Position out of Bounds");
			controller.setNoPrintGameState();
		}
	}

}
