package commands;

import elems.Plant;
import factory.PlantsFactory;
import src.Controller;
import src.Game;

public class AddCommand extends Command {
	private int x, y;
	private String plant;

	// Implentar planta
	public final static String commandName = "add";
	public final static String commandInfo = "[A]dd";
	public final static String helpInfo = "<plant> <x> <y>: Adds a plant in position x, y.";

	public AddCommand() {
		super(commandName, commandInfo, helpInfo);
	}

	public AddCommand(int x, int y, String plant) {
		super(commandName, commandInfo, helpInfo);

		this.x = x;
		this.y = y;
		this.plant = plant;
	}
// Cambiarlo, se comprueba a la hora de aniadir una planta 

	@Override
	public Command parse(String[] comando, Controller controller) {
		Command c = null;

		if (comando.length == 4 && (comando[0].equals(commandName) || comando[0].equals(commandName.substring(0, 1)))) {

			this.x = Integer.parseInt(comando[2]);
			this.y = Integer.parseInt(comando[3]);
			if (this.x < 3 || this.y < 6 || this.x >= 0 || this.y >= 0) {
				if (controller.isEmpty(x, y)) {
					c = new AddCommand(x, y, comando[1]);
				}
			}
		}

		return c;
	}

	@Override
	public void execute(Game game, Controller controller) {
		Plant p = PlantsFactory.getPlant(plant, x, y);
		if (p != null)
			game.addPlant(p, x, y);
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
