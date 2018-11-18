package commands;

import src.Controller;
import src.Game;

public class PrintModeCommand extends NoParamsCommand {

	public final static String commandName = "print";
	public final static String commandInfo = "[P]rint";
	public final static String helpInfo = "change printmode [Release|Debug].";

	public PrintModeCommand(String nombreComando, String textoInfo, String textoAyuda) {
		super(nombreComando, textoInfo, textoAyuda);

	}

	public PrintModeCommand() {
		super(commandName, commandInfo, helpInfo);
	}

	@Override
	public void execute(Game game, Controller controller) {
		System.out.println("Modo de Print cambiado");
		// TODO execute swapPrintMode();

	}

}
