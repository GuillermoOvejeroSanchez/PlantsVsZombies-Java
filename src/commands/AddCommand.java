package commands;

import elems.Plant;
import factory.PlantsFactory;
import src.Controller;
import src.Game;

public class AddCommand extends Command {
	private int x, y;
	private String name;

	// Implentar namea
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
// Cambiarlo, se comprueba a la hora de aniadir una namea 

	@Override
	public Command parse(String[] comando, Controller controller) {
		Command c = null;

		if (comando.length == 4 && (comando[0].equals(commandName) || comando[0].equals(commandName.substring(0, 1)))) {

			this.x = Integer.parseInt(comando[2]);
			this.y = Integer.parseInt(comando[3]);
			if (this.x < 4 && this.y < 7 && this.x > -1 && this.y > -1) {
				if (controller.isEmpty(x, y)) {
					c = new AddCommand(x, y, comando[1]);
				}
			}
		}

		return c;
	}

	@Override
	public void execute(Game game, Controller controller) {
		Plant p = PlantsFactory.getPlant(name, x, y);
		if (p != null)
			game.addPlant(p);
		else
			controller.setNoPrintGameState();
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

}
