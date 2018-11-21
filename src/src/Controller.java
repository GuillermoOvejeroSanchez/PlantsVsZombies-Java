package src;

import java.util.Scanner;

import commands.Command;
import commands.CommandParse;
import print.GamePrinter;

public class Controller {

	private Game game;
	private Scanner in;
	public GamePrinter gamePrinter;
	boolean print;
	boolean update;
	boolean noSalir;

	public Controller(Game game, GamePrinter printer) {
		this.game = game;
		this.in = new Scanner(System.in);
		this.gamePrinter = printer;
		this.print = true;
		this.update = true;
		this.noSalir = true;
	}

	public void run() {

		while (!game.checkWin() && !game.checkZombieWin() && noSalir) {
			if (update)
				game.update();
			if (print)
				gamePrinter.printGame(game);
			print = true;
			update = true;
			System.out.print("Command >");
			String[] comando = in.nextLine().toLowerCase().trim().split("\\s+");
			Command command = CommandParse.parseCommand(comando, this);

			if (command != null) {
				command.execute(game, this);
			} else {
				System.err.println("Unknown Command");
				setNoPrintGameState();
			}

			if (!game.checkWin()) {
				game.accionOrdenador();
			}

		}
		if (game.checkWin()) {
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

	public void setNoUpdateGameState() {
		update = false;
	}

	public void setNoSalir() {
		noSalir = false;
	}

}
