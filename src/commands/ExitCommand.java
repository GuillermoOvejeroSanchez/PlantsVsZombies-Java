package command;

import src.Controller;
import src.Game;

public class ExitCommand extends NoParamsCommand {
	
	public ExitCommand() {
		super("exit", "[E]xit", "Terminates the program."); 
	}

	
	@Override
	public void execute(Game game, Controller controler) {
		// TODO Auto-generated method stub
		
	}

}
