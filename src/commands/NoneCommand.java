package commands;

import src.Controller;
import src.Game;

public class NoneCommand extends Command {

	public NoneCommand(String nombreComando, String textoInfo, String textoAyuda) {
		super(nombreComando, textoInfo, textoAyuda);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void execute(Game game, Controller controler) {

	}

	@Override
	public Command parse(String[] comando, Controller controller) {
		// TODO Auto-generated method stub
		return null;
	}

}
