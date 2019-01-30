package commands;

import excepciones.CommandExecuteException;
import excepciones.CommandParseException;
import src.Game;

public class FirewaveCommand extends Command {

	public final static String commandName = "firewave";
	public final static String commandInfo = "[F]irewave";
	public final static String helpInfo = "<side> : Invokes a fire wave that hits the firsr zombie of each row [left | right]";
	private String side;
	final static int dmg = 1;
	final static int cost = 100;

	public FirewaveCommand() {
		super(commandName, commandInfo, helpInfo);
	}
	public FirewaveCommand(String side) {
		super(commandName, commandInfo, helpInfo);
		this.side = side;
	}

	@Override
	public Command parse(String[] comando) throws CommandParseException {
		Command c = null;

		if ((comando[0].equalsIgnoreCase(commandName) || comando[0].equals(commandName.substring(0, 1)))) {

			if (comando.length == 2) {
				side = comando[1];
				c = new FirewaveCommand(comando[1]);
			} else {
				throw new CommandParseException("Firewave must be followed by a side");
			}
		}

		return c;
	}

	@Override
	public boolean execute(Game game) throws CommandExecuteException {
		//Siempre ataca desde arriba hacia abajo
		//y segun el lado que le pases de izq a der o de der a izq
		boolean executed = false;
		if(game.getSuncoins() - cost < 0)
			throw new CommandExecuteException("Command not executed " + commandName +": not enough suncoins available");
		
		if (side.equalsIgnoreCase("left")) {
			int posY = 0;
			boolean encontrado = false;
			encontrado = game.isZombie(0, posY);
			for (int i = 0; i < Game.FILAS; i++) { //Va para cada fila atacando lo primero que encuentra (0 a 3)
				encontrado = false;
				posY = 0;
				while (!encontrado && posY < Game.COLUMNAS) {
					posY++;
					encontrado = game.isZombie(i, posY);
				}
				if (encontrado)
					game.attackFirewave(i, posY, dmg);
				
			executed = true;
			}
			
		} 
		else if (side.equalsIgnoreCase("right")) {
			int posY = Game.COLUMNAS-1;
			boolean encontrado = false;
			encontrado = game.isZombie(0, posY);
			for (int i = 0; i < Game.FILAS; i++) { //Va para cada fila atacando lo primero que encuentra (0 a 3)
				encontrado = false;
				posY = Game.COLUMNAS-1;
				while (!encontrado && posY >= 0) {
					posY--;
					encontrado = game.isZombie(i, posY);
				}
				if (encontrado)
					game.attackFirewave(i, posY, dmg);
			}
			
			executed = true;
		} 
		
		else {
			throw new CommandExecuteException("Invalid side: the side must be left or right");
		}
		return executed;
	}

}
