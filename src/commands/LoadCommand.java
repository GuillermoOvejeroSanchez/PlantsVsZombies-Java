package commands;

import src.Game;
import util.MyStringUtils;
import java.io.*;

import excepciones.CommandExecuteException;
import excepciones.CommandParseException;
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

	public Command parse(String[] comando) throws CommandParseException {
		Command c = null;

		if ((comando[0].equalsIgnoreCase(commandName) || comando[0].equals(commandName.substring(0, 2)))) {

			if (comando.length == 2) {
				c = new LoadCommand(comando[1]);
			} else {
				throw new CommandParseException("Numero de parametros invalido para el comando load");
			}
		}

		return c;
	}

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
				throw new CommandExecuteException("Ha habido un problema al cargar el archivo");
			} catch (FileContentsException e) {
				throw new CommandExecuteException(e.getMessage());
			} catch (NullPointerException e) {
				throw new CommandExecuteException(e.getClass().toString() + " fichero vacio");
			}

		} else {
			throw new CommandExecuteException("El fichero " + fileName + " no es valido");
		}

		return true;
	}
}
