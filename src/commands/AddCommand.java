package commands;

import src.Controller;
import src.Game;

public class AddCommand extends Command {
	private int x, y;
	private String planta;
	// Implentar planta
	public final static String commandName = "add";
	public final static String commandInfo = "[A]dd";
	public final static String helpInfo = "<plant> <x> <y>: Adds a plant in position x, y.";

	public AddCommand() {
		super(commandName, commandInfo, helpInfo);
	}

	public AddCommand(int x, int y, String planta) {
		super(commandName, commandInfo, helpInfo);

		this.x = x;
		this.y = y;
		this.planta = planta;
	}

	@Override
	public Command parse(String[] comando, Controller controler) {
		Command c = null;

		if (comando.length == 4 && (comando[0].equals(commandName) || comando[0].equals(commandName.substring(0, 1)))) {
			if (comando[1].equals("sunflower") || comando[1].equals("s")) {
				c = new AddCommand(string2Number(comando[2]), string2Number(comando[3]), "sunflower");
			} else if (comando[1].equals("peashooter") || comando[1].equals("p")) {
				c = new AddCommand(string2Number(comando[2]), string2Number(comando[3]), "peashooter");
			}

			this.x = string2Number(comando[2]);
			this.y = string2Number(comando[3]);

		}

		return c;
	}

	@Override
	public void execute(Game game, Controller controler) {

		if (planta == "peashooter") {
			game.addPea(this.x, this.y);
		} else if (planta == "sunflower") {
			game.addSunflo(this.x, this.y);
		}

	}

	public int string2Number(String string) {
		int n = 0;

		n = Integer.parseInt(string);

		return n;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

}
