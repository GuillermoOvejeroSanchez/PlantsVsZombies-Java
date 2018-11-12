package command;

import src.Controller;
import src.Game;

public class ResetCommand extends NoParamsCommand{

	public ResetCommand() {
		super("reset", "[R]eset", "Starts a new game.");
		// TODO Auto-generated constructor stub
	}

	

	@Override
	public void execute(Game game, Controller controler) {
		game.reset();
		
	}

}
