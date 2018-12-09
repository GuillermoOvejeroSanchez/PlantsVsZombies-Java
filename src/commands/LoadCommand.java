package commands;

import src.Game;
import util.MyStringUtils;
import java.io.*;

import excepciones.CommandExecuteException;
import excepciones.FileContentsException;

public class LoadCommand extends Command {

	public final static String commandName = "load";
	public final static String commandInfo = "[Lo]ad";
	public final static String helpInfo = " <filename>: Load the state of the game from a file.";

	private String fileName;

	public LoadCommand() {
		super(commandName, commandInfo, helpInfo);

	}

	public LoadCommand(String fileName) {
		super(commandName, commandInfo, helpInfo);
		this.fileName = fileName;
	}

	public Command parse(String[] comando) {
		Command c = null;

		if ((comando[0].equalsIgnoreCase(commandName) || comando[0].equals(commandName.substring(0, 1)))) {

			if (comando.length == 2) {
				c = new LoadCommand(comando[1]);
			}
		}

		return c;
	}

	@Override
	public boolean execute(Game game) throws CommandExecuteException {

		if (MyStringUtils.isValidFilename(fileName + ".dat") && MyStringUtils.isReadable(fileName + ".dat")) {

			try {
				BufferedReader br = new BufferedReader(new FileReader(fileName + ".dat"));
				String cabecera = br.readLine();

				if (cabecera.equals("Plants Vs Zombies v3.0")) {
					br.readLine();
					game.load(br);
					System.out.println("Game successfully loaded from file " + fileName);
				} else {
					br.close();
					throw new CommandExecuteException("Cabecera " + cabecera + " no valida");
				}

			} catch (IOException e) {
				throw new CommandExecuteException("Ha habido un problema");
			} catch (FileContentsException e) {
				throw new CommandExecuteException(e.getMessage());
			}

		} else {
			throw new CommandExecuteException("El fichero no es valido");
		}

		return true;
	}
}
