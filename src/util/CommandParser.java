package util;

import commands.AddCommand;
import commands.Command;
import commands.ExitCommand;
import commands.HelpCommand;
import commands.ListCommand;
import commands.ResetCommand;
import commands.UpdateCommand;
import src.Controller;

public class CommandParser {

	private static Command[] avaliableCommands = { new AddCommand(), new HelpCommand(), new ResetCommand(),
			new ExitCommand(), new ListCommand(), new UpdateCommand() };

	public static Command parseCommand(String[] textoComando, Controller controller) {
		Command command = null;
		boolean encontrado = false;
		int i = 0;
		if (textoComando.length == 0 || textoComando.length > 4) {
			command = null;
		} else {
			while (!encontrado && i < avaliableCommands.length) {
				command = avaliableCommands[i].parse(textoComando, controller);

				if (command != null) {
					encontrado = true;
				} else
					i++;
			}
		}
		return command;

	}

	public static String CommandHelp() {
		String ayuda;
		StringBuilder helpText = new StringBuilder();
		for (int i = 0; i < avaliableCommands.length; i++) {
			ayuda = avaliableCommands[i].helpText();
			helpText.append(ayuda);
			helpText.append("\n");
		}
		return helpText.toString();
	}

}