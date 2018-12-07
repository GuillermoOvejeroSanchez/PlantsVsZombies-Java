package commands;

import excepciones.CommandParseException;
import print.DebugPrinter;
import print.ReleasePrinter;
import src.Game;

public class PrintModeCommand extends Command {

	public final static String commandName = "print";
	public final static String commandInfo = "[P]rint release|debug";
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
	public Command parse(String[] comando) throws CommandParseException {
		Command c = null;
		if ((comando[0].equals(commandName) || comando[0].equals(commandName.substring(0, 1)))) {
			if (comando.length == 2) {
				modo = comando[1];
				if (modo.equalsIgnoreCase("debug") || modo.equalsIgnoreCase("release"))
					c = new PrintModeCommand(modo);
				else
					throw new CommandParseException("Unknown print mode:" + comando[1]);
			} else {
				throw new CommandParseException("Incorrect number of arguments for printmode command: " + commandInfo);
			}
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
			game.setGamePrinter(new ReleasePrinter(Game.FILAS, Game.COLUMNAS, game));
			executed = true;
		}
		return executed;
	}

}