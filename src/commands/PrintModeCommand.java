package commands;

import src.Controller;
import src.Game;
import print.*;

public class PrintModeCommand extends Command {

	public final static String commandName = "print";
	public final static String commandInfo = "[P]rint";
	public final static String helpInfo = "change printmode [Release|Debug].";

	private String modo;

	public PrintModeCommand() {
		super(commandName, commandInfo, helpInfo);
	}

	public PrintModeCommand(String modo) {
		super(commandName, commandInfo, helpInfo);
		this.modo = modo;

	}

	@Override
	public void execute(Game game, Controller controller) {
		System.out.println("Modo de Print cambiado");

		if (modo.equals("DEBUG")) {
			controller.gamePrinter = new DebugPrinter(game);
		} else if (modo.equals("RELEASE")) {
			controller.gamePrinter = new ReleasePrinter(game.getFilas(), game.getColumnas(), game);
		}

	}

	@Override
	public Command parse(String[] comando, Controller controller) {
		Command c = null;

		if (comando.length == 2 && (comando[0].equals(commandName) || comando[0].equals(commandName.substring(0, 1)))) {

			modo = comando[1];

			c = new PrintModeCommand(modo);
		}

		return c;
	}

}
