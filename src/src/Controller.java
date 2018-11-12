package src;
import src.Game;
import java.util.Scanner;

public class Controller {

	private Game game; 
	private Scanner in; 
	private GamePrinter gamePrinter;
	public Controller(Game game) {
		this.game = game; 
		this.in = new Scanner(System.in); 
		this.gamePrinter = new GamePrinter(game, Game.FILAS,Game.COLUMNAS);
	}
	
/*
	while (!game.isFinished() && !exit) {
		printGame();
		noPrint = false;
		System.out.print(prompt);
		String[] words = scanner.nextLine().toLowerCase().trim().split("\\
		s+");
		Command command = CommandParser.parseCommand(words, this);
		if (command != null) {
		command.execute(game, this);
		}
		else {
		System.err.println(unknownCommandMsg);
		setNoPrintGameState();
		}
		}
*/
	
    public void run(Game game){
    	
    	boolean noSalir = true; 
    	while(noSalir) {
    		game.update();
    		this.gamePrinter.encodeGame(game);
    		this.gamePrinter.printBoard(game);
   			if(noSalir = !game.getFin()) {
   				noSalir = userCommand();
   				game.accionOrdenador();
    			}
    		}
    	System.out.println("GAME OVER");
    	}
    
    private boolean userCommand() {
    	
    	boolean noSalir = true; 
    	boolean continuar = false;
    	String[] comandos;
    	String comando;
    	
        while(!continuar) {
        	comando = in.nextLine();
        	comandos = comando.toLowerCase().split(" ");
        	
    		if(comandos[0].equals("add") || comandos[0].equals("a") && comandos.length == 4) {
  
    			while(!comandoCorrecto(comandos)){
    				System.out.println("Invalid object or position");
    				comando = in.nextLine();
    	        	comandos = comando.toLowerCase().split(" ");
    			}
    			
    			if(comandos[1].equals("sunflower") || comandos[1].equals("s"))
    				continuar = this.game.addSunflo(Integer.parseInt(comandos[2]), Integer.parseInt(comandos[3]));
    			
    			else if(comandos[1].equals("peashooter") || comandos[1].equals("p"))
    				continuar = this.game.addPea(Integer.parseInt(comandos[2]), Integer.parseInt(comandos[3])); 
    		}
    		
    		else if(comandos[0].equals("help") || comandos[0].equals("h"))
    			System.out.println(this.game.help());
    		
    		else if(comandos[0].equals("list") || comandos[0].equals("l")) 
    			System.out.println(this.game.list()); 
    		
    		else if(comandos[0].equals("reset") || comandos[0].equals("r")) {
    			this.game.reset();
    			continuar = true;	
    		}
   		
    		else if (comandos[0].equals("exit") || comandos[0].equals("e")) {
    			noSalir = false;
    			continuar = true;
    			System.out.println("YOU EXIT");
    		}
    		
    		else if(comandos[0].equals("none") || comandos[0].equals("n") || comandos[0].equals(""))
    			continuar = true;

    		else System.out.println("Unknown command");

        }
    	
    	return noSalir;
    }//userCommand
    
    
public boolean comandoCorrecto(String[] comandos) {
		
		boolean verificar = false;  	
		if(comandos.length == 4) {
			if(comandos[1].equals("sunflower") || comandos[1].equals("s")) {
				if((Integer.parseInt(comandos[2]) >= 0 && Integer.parseInt(comandos[2]) < Game.FILAS && Integer.parseInt(comandos[3]) >= 0 && Integer.parseInt(comandos[3]) < Game.COLUMNAS))
					verificar = true; 
			}
			else if(comandos[1].equals("peashooter") || comandos[1].equals("p")) {
				if(Integer.parseInt(comandos[2]) >= 0 && Integer.parseInt(comandos[2]) < Game.FILAS && Integer.parseInt(comandos[3]) >= 0 && Integer.parseInt(comandos[3]) < Game.COLUMNAS)
					verificar = true; 
			}	
		}
		return verificar; 	
	}
       
}//Controller

	


