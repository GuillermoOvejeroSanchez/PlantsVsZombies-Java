package src;

import java.util.Scanner;

import commands.Command;
import commands.CommandParse;

public class Controller {

	private Game game;
	private Scanner in;
	public GamePrinter gamePrinter;
	boolean print;
	boolean noSalir;

	public Controller(Game game, GamePrinter printer) {
		this.game = game;
		this.in = new Scanner(System.in);
		this.gamePrinter = printer;
		this.print = true;
	}

	public void run(Game game) {

		while (!game.getFin() && !game.getZombieWin()) {
			if (print) {
				game.update();
				gamePrinter.printGame();
			}
			print = true;
			System.out.print("Command >");
			String[] comando = in.nextLine().toLowerCase().trim().split("\\s+");
			Command command = CommandParse.parseCommand(comando, this);

			if (command != null) {
				command.execute(game, this);
			} else {
				System.err.println("Unknown Command");
				setNoPrintGameState();
			}

			if (!game.getFin()) {
				game.accionOrdenador();
			}
		}
		if (game.getFin()) {
			System.out.println("YOU WIN");
			setNoPrintGameState();
		} else if (game.checkZombieWin()) {
			System.out.println("YOU LOST");
			setNoPrintGameState();
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

	public boolean isEmpty(int x, int y) {
		return game.isEmpty(x, y);
	}

}
