package commands;

import src.Game;

public class LoadCommand extends Command{

	public final static String CommandName = "Load";
	public final static String CommandInfo = "[Lo]ad"; 
	public final static String helpInfo = " <filename>: Load the state of the game from a file."; 
	
	
	public LoadCommand() {
		super(CommandName, CommandInfo, helpInfo);
		
	}

	@Override
	public Command parse(String[] comando) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public boolean execute(Game game) {
		// TODO Auto-generated method stub
		return false;
	}

}
