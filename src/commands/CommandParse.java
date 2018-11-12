package command;

import src.Controller;

public class CommandParse {
	
	private static Command[] avaliableCommands= {
			new AddCommand(), 
			new HelpCommand(), 
			new ResetCommand(), 
			new ExitCommand(), 
			new ListCommand(), 
			new UpdateCommand()
	};

	public static Command parseCommand(String[] textoComando, Controller controller) {
		Command c = null; 
		boolean encontrado = false;
		int i = 0;
		 /*
		if(textoComando.length == 0 || textoComando.length > 4) {
			
			c  = null; 
		}
		*/
		
		while(!encontrado && i < avaliableCommands.length) {
			c = avaliableCommands[i].parse(textoComando, controller); 
			
			if(c != null) {
				encontrado = true; 
			}
			else
				i++; 
		}
		
		
		
		
		return c; 
	}
	
	public static String CommandHelp() {
		String ayuda = " "; 
		
		return ayuda; 
	}
	
}
