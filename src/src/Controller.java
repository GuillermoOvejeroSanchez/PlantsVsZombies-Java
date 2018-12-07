package src;

import java.util.Scanner;

import commands.Command;
import commands.CommandParse;
import excepciones.*;

public class Controller {

	private Game game;
	private Scanner in;
	boolean print;
	boolean update;
	boolean noSalir;

	public Controller(Game game) {
		this.game = game;
		this.in = new Scanner(System.in);
		this.print = true;
		this.update = true;
	}

	public void run() {
		game.getGamePrinter().printGame(game);
		while (!game.checkWin() && !game.checkZombieWin() && !game.isFinished()) {
			if (update)
				game.update();

			System.out.print("Command >");
			String[] comando = in.nextLine().toLowerCase().trim().split("\\s+");
			try {
				Command command = CommandParse.parseCommand(comando); // CommandParseException
				if (command != null) {
					if (command.execute(game))
						game.getGamePrinter().printGame(game); // CommandExecuteException
				} 
			} catch (CommandExecuteException | CommandParseException ex) {
				setNoUpdateGameState();
				System.err.format(ex.getMessage() + "%n%n");

			}

			if (!game.checkWin()) {
				game.accionOrdenador();
			}

		}


			
		}
		System.out.println("***** GAME OVER *****");

		if (game.checkWin()) {
			System.out.println("****** YOU WIN ******");
			setNoPrintGameState();
		} else if (game.checkZombieWin()) {
			System.out.println("****** YOU LOST ******");
			setNoPrintGameState();
		}
		else 
		System.out.println("****** Game over!: User exit ******");

	}

	public void setNoPrintGameState() {
		print = false;
	}

	public void setNoUpdateGameState() {
		update = false;
	}

	public void setNoSalir() {
		noSalir = false;
	}

}
