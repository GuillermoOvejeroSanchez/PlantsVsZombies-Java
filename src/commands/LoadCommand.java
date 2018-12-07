package commands;

import src.Controller;
import src.Game;

public class LoadCommand extends Command{

	public final static String CommandName = "load";
	public final static String CommandInfo = "[Lo]ad"; 
	public final static String helpInfo = " <filename>: Load the state of the game from a file."; 
	
	
	public LoadCommand() {
		super(CommandName, CommandInfo, helpInfo);
		
	}


	public void execute(Game game, Controller controller) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public Command parse(String[] comando, Controller controller) {
		// TODO Auto-generated method stub
		return null;
	}

}
