package commands;

import src.Controller;

public abstract class NoParamsCommand extends Command{

	public NoParamsCommand(String nombreComando, String textoInfo, String textoAyuda) {
		super(nombreComando, textoInfo, textoAyuda);
		
	}
	
	public  Command parse(String[] comando, Controller controller) {
		Command c = null; 
		
		if(comando.length == 1) {
			if(comando[0].equals("exit") || comando[0].equals("e")) {
				c = new ExitCommand(); 
			}
			else if(comando[0].equals("help") || comando[0].equals("h")) {
				c = new HelpCommand(); 
			}
			else if(comando[0].equals("none ") || comando[0].equals("n")) {
				c = new UpdateCommand(); 
			}
			else if(comando[0].equals("reset") || comando[0].equals("r")) {
				c = new ResetCommand(); 
			}
			else if(comando[0].equals("list") || comando[0].equals("l")) {
				c = new ListCommand(); 
			}
		}
		
		return c; 
	}

	
}
