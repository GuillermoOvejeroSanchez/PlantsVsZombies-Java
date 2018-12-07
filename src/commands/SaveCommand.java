package commands;

import java.io.BufferedWriter;
import java.io.FileWriter;
import util.*;

import src.Game;

public class SaveCommand extends Command {

	public final static String commandName = "save";
	public final static String commandInfo = "[S]ave";
	public final static String helpInfo = "<filename>: Save the state of the game to a file.";
	public final static String cabezera = "Plants Vs Zombies v3.0";

	private String fileName;

	public SaveCommand() {
		super(commandName, commandInfo, helpInfo);

	}

	public SaveCommand(String fileName) {
		super(commandName, commandInfo, helpInfo);
		this.fileName = fileName;
	}

	@Override
	public Command parse(String[] comando) {
		Command c = null;

		if (comando.length == 2 && (comando[0].equalsIgnoreCase(commandName))) {
			fileName = comando[1];

		}

		return c;
	}

	public boolean execute(Game game) {
		if (MyStringUtils.isValidFilename(fileName)) {

			try {

				if (!MyStringUtils.fileExists(fileName)) {

					System.out.println("Se va a crear un nuevo fichero");

					BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
					bw.write(cabezera);
					bw.newLine();
					bw.write(game.store());
				}

				else {
					System.out.println("Ya existe un fichero con este nombre, la partida guardada se perdera");

					BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
					bw.write(cabezera);
					bw.newLine();
					bw.write(game.store());
				}

			} catch (Exception e) {
				// TODO: handle exception
			} // catch
		} // 2º if
		return false;

	} // 1er if

}// metodo
