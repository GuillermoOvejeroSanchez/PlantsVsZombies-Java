package commands;

import elems.Plant;
import factory.PlantsFactory;
import src.Controller;
import src.Game;

public class AddCommand extends Command {
	private int x, y;
	private Plant plant;  
	
	
	// Implentar planta
	public final static String commandName = "add";
	public final static String commandInfo = "[A]dd";
	public final static String helpInfo = "<plant> <x> <y>: Adds a plant in position x, y.";

	public AddCommand() {
		super(commandName, commandInfo, helpInfo);
	}

	public AddCommand(int x, int y, Plant plant) {
		super(commandName, commandInfo, helpInfo);

		this.x = x;
		this.y = y;
		this.plant = plant; 
	}
// Cambiarlo, se comprueba a la hora de añadier una planta 
	
	
	@Override
	public Command parse(String[] comando, Controller controler) {
		Command c = null;

		if (comando.length == 4 && (comando[0].equals(commandName) || comando[0].equals(commandName.substring(0, 1)))) {

			this.x = Integer.parseInt(comando[2]);
			this.y = Integer.parseInt(comando[3]);
			
			PlantsFactory.getPlant(comando[1]); 
			Plant p = PlantsFactory.getPlant(comando[1]); 
			
			c = new AddCommand(x,y, p);


		}

		return c;
	}

	@Override
	public void execute(Game game, Controller controler) {
			game.addPlantToGame(plant, x, y);
	}


	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

}
