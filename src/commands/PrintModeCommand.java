package commands;

import print.DebugPrinter;
import print.ReleasePrinter;
import src.Game;

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

//
	@Override
	public Command parse(String[] comando) {
		Command c = null;

		if (comando.length == 2 && (comando[0].equals(commandName) || comando[0].equals(commandName.substring(0, 1)))) {
			modo = comando[1];
			if (modo.equalsIgnoreCase("debug") || modo.equalsIgnoreCase("release"))
				c = new PrintModeCommand(modo);
			else
				System.err.println("Unknown Print Mode");
		}
		return c;
	}


	@Override
	public boolean execute(Game game) {
		boolean executed = false;
		if (modo.equalsIgnoreCase("debug")) {
			game.setGamePrinter(new DebugPrinter(game));
			executed = true;
		} else if (modo.equalsIgnoreCase("release")) {
			game.setGamePrinter(new ReleasePrinter(game.getFilas(), game.getColumnas(), game));
			executed = true;
		}
		return executed;
	}

}