package commands;

import src.Controller;

public class CommandParse {

	private static Command[] avaliableCommands = { new AddCommand(), new HelpCommand(), new ResetCommand(),
			new ExitCommand(), new ListCommand(), new UpdateCommand(), new ZombieListCommand(),
			new PrintModeCommand() };

	public static Command parseCommand(String[] textoComando, Controller controller) {
		Command c = null;
		boolean encontrado = false;
		int i = 0;

		if (textoComando.length == 0 || textoComando.length > 4) {

			c = null;
		} else {

			while (!encontrado && i < avaliableCommands.length) {
				c = avaliableCommands[i].parse(textoComando, controller);

				if (c != null) {
					encontrado = true;
				} else
					i++;
			}
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
