package commands;

import src.Controller;
import src.Game;

public class NoneCommand extends NoParamsCommand {

	public NoneCommand(String nombreComando, String textoInfo, String textoAyuda) {
		super(nombreComando, textoInfo, textoAyuda);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void execute(Game game, Controller controler) {

	}

}
