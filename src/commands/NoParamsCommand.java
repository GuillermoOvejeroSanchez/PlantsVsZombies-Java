package commands;

import src.Controller;

public abstract class NoParamsCommand extends Command {

	public NoParamsCommand(String nombreComando, String textoInfo, String textoAyuda) {
		super(nombreComando, textoInfo, textoAyuda);

	}

	public Command parse(String[] comando, Controller controller) {
		Command c = null;

		if (comando.length == 1) {

			if (comando[0].equals(ExitCommand.commandName)
					|| comando[0].equals(ExitCommand.commandName.substring(0, 1))) {
				c = new ExitCommand();
			} else if (comando[0].equals(HelpCommand.commandName)
					|| comando[0].equals(HelpCommand.commandName.substring(0, 1))) {
				c = new HelpCommand();
			} else if (comando[0].equals(UpdateCommand.commandName)
					|| comando[0].equals(UpdateCommand.commandName.substring(0, 1)) || comando[0].equals("")) {
				c = new UpdateCommand();
			} else if (comando[0].equals(ResetCommand.commandName)
					|| comando[0].equals(ResetCommand.commandName.substring(0, 1))) {
				c = new ResetCommand();
			} else if (comando[0].equals(ListCommand.commandName)
					|| comando[0].equals(ListCommand.commandName.substring(0, 1))) {
				c = new ListCommand();
			} else if (comando[0].equalsIgnoreCase(ZombieListCommand.commandName)
					|| comando[0].equals(ZombieListCommand.commandName.substring(0, 1))) {
				c = new ZombieListCommand();
			}

		}

		return c;
	}

}
