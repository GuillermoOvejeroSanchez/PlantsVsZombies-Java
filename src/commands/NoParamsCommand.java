package commands;

import excepciones.CommandParseException;

public abstract class NoParamsCommand extends Command {

	public NoParamsCommand(String nombreComando, String textoInfo, String textoAyuda) {
		super(nombreComando, textoInfo, textoAyuda);

	}

	private static Command[] avaliableCommands = { new HelpCommand(), new ResetCommand(), new ExitCommand(),
			new ListCommand(), new UpdateCommand(), new ZombieListCommand() };

	@Override
	public Command parse(String[] comando) throws CommandParseException {
		Command c = null;

		for (int i = 0; i < avaliableCommands.length; i++) {
			if (comando[0].equals(""))
				c = avaliableCommands[4];
			else if (comando[0].equalsIgnoreCase(avaliableCommands[i].commandName)
					|| comando[0].equalsIgnoreCase(avaliableCommands[i].commandName.substring(0, 1))) {
				c = avaliableCommands[i];
			}
		}
		if (comando.length != 1 && c != null) {
			throw new CommandParseException(c.commandName + " command has no arguments");
		}
		return c;
	}
}
