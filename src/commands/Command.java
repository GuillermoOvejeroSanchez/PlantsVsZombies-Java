package command;
import src.Controller;
import src.Game;


public abstract class Command {
	
	private String textoAtyuda; 
	private String textoInfo; 
	protected final String nombreComando; 
	
	public Command(String nombreComando, String textoInfo, String textoAyuda) {
		this.textoAtyuda = textoAyuda;
		this.textoInfo = textoInfo; 
		this.nombreComando = nombreComando; 
		
	}
	
	public abstract Command parse(String[] comando, Controller controller); 
	
	public abstract void execute(Game game,Controller controler); 
	
	public String helpText() {
		String t = " "; 
		
		
		
		return t; 
	}
	
	public boolean verificarComando(String[] comando) {
		boolean ok = false; 
		
		if(comando.length == 0 || comando.length > 4) {
			ok = true; 
		}
		
		return ok; 
	}
	
}
