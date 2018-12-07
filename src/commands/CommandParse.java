package commands;

import excepciones.CommandParseException;

public class CommandParse {

	private static Command[] avaliableCommands = { new AddCommand(), new HelpCommand(), new ResetCommand(),
			new ExitCommand(), new ListCommand(), new UpdateCommand(), new ZombieListCommand(),
			new PrintModeCommand(), new LoadCommand(), new SaveCommand() };

	public static Command parseCommand(String[] textoComando) throws CommandParseException {
		Command c = null;
		boolean encontrado = false;
		int i = 0;

		while (!encontrado && i < avaliableCommands.length) {
			c = avaliableCommands[i].parse(textoComando);
			if (c != null) {
				encontrado = true;
			} else
				i++;
		}
		if(c == null) {
			throw new CommandParseException("Invalid Command: " + textoComando[0]);
		}
		return c;
	}

	public static String CommandHelp() {

		StringBuilder ayudaTxt = new StringBuilder();

		ayudaTxt.append("The avaliable commands are:");
		ayudaTxt.append("\n");

		for (int i = 0; i < avaliableCommands.length; i++) {

			ayudaTxt.append("  ");
			ayudaTxt.append(avaliableCommands[i].helpText());
			ayudaTxt.append("\n");
		}

		return ayudaTxt.toString();
	}

}
