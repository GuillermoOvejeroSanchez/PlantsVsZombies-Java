package src;

import java.util.Random;

import print.GamePrinter;
import print.ReleasePrinter;

public class PlantsVsZombies {

	public static void main(String[] args) {
		if (args.length > 0) {
			Level level = null;
			// Instanciamos el Level elegido
			if (args[0].equals("EASY"))
				level = Level.EASY;
			else if (args[0].equals("HARD"))
				level = Level.HARD;
			else if (args[0].equals("INSANE"))
				level = Level.INSANE;
			//
			Random rand = new Random();
			if (level != null) {
				int seed = (args.length == 2) ? Integer.parseInt(args[1]) : rand.nextInt(Integer.MAX_VALUE); // Seteamos
																												// la
																												// seed
																												// del
																												// game
				Game game = new Game(level, seed);
				GamePrinter gamePrinter = new ReleasePrinter(game.getFilas(), game.getColumnas(), game);
				Controller controller = new Controller(game, gamePrinter);
				controller.run();
			}
		} else {
			System.out.println("ERROR: NO HAY SUFICIENTES PARAMETROS");
		}

	}
}
