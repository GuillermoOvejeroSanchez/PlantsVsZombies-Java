package commands;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import excepciones.CommandExecuteException;
import util.*;

import src.Game;

public class SaveCommand extends Command {

	public final static String commandName = "Save";
	public final static String commandInfo = "[S]ave";
	public final static String helpInfo = "<filename>: Save the state of the game to a file.";
	public final static String cabecera = "Plants Vs Zombies v3.0";

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
		
		if ((comando[0].equalsIgnoreCase(commandName) || comando[0].equalsIgnoreCase(commandName.substring(0, 1)))){
			
			if(comando.length == 2 )
			{
				c = new SaveCommand(comando[1]); 
			}
		}

		return c;
	}

	public boolean execute(Game game) throws CommandExecuteException {
		if (MyStringUtils.isValidFilename(fileName)) {
			BufferedWriter bw = null;
			try {
				if (!MyStringUtils.fileExists(fileName)) {

					System.out.println("Se va a crear un nuevo fichero");

					bw = new BufferedWriter(new FileWriter(fileName+".dat"));
					bw.write(cabecera);
					bw.newLine();
					bw.write(game.store());
				}

				else {
					System.out.println("Ya existe un fichero con este nombre, la partida guardada se perdera");

					bw = new BufferedWriter(new FileWriter(fileName+".dat"));
					bw.write(cabecera);
					bw.newLine();
					bw.newLine();
					bw.write(game.store());
				}

			} catch (Exception e) {
				System.err.println(e.getClass() + " " + e.getMessage());
			} finally {
				try {
					bw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		} else {
			throw new CommandExecuteException("Invalid filename: " + fileName);
		}
		return false;

	} // 1er if

}// metodo
