package src;

import java.util.Scanner;

import commands.Command;
import util.CommandParser;

public class Controller {

	private Game game;
	private Scanner in;
	private GamePrinter gamePrinter;
	boolean print;
	boolean noSalir;

	public Controller(Game game) {
		this.game = game;
		this.in = new Scanner(System.in);
		this.gamePrinter = new GamePrinter(game, Game.FILAS, Game.COLUMNAS);
		this.print = true;
	}

	public void run(Game game) {

		noSalir = true;

		while (noSalir && !game.getFin()) {
			if (print) {
				game.update();
				printGame();
			}
			if (!game.getFin()) {
				print = true;
				System.out.print("Command >");
				String[] comando = in.nextLine().toLowerCase().trim().split("\\s+");
				Command command = CommandParser.parseCommand(comando, this);

				if (command != null) {
					command.execute(game, this);
				}

				else {
					System.err.println("Unknown Command");
					setNoPrintGameState();
				}
				if (noSalir) {
					game.accionOrdenador();
				}
			}
		}
		System.out.println("GAME OVER");
	}

	public void setNoPrintGameState() {
		print = false;

	}

	public void setNoSalir() {
		noSalir = false;
	}

	private void printGame() {
		this.gamePrinter.encodeGame(game);
		this.gamePrinter.printBoard(game);

	}

}
