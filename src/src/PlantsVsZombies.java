package src;

import java.util.Random;

import excepciones.CommandParseException;

public class PlantsVsZombies {

	public static void main(String[] args) throws CommandParseException {
		if (args.length > 0) {
			Level level = Level.parse(args[0]);
			Random rand = new Random();
			if (level != null) {
				int seed = 0;
				try {
					seed = (args.length == 2) ? Integer.parseInt(args[1]) : rand.nextInt(Integer.MAX_VALUE);
				} catch (RuntimeException e) {
					seed = rand.nextInt(Integer.MAX_VALUE);
					System.err.println(e.getClass() + " " + e.getMessage()
							+ " introduced seed isn�t valid... Random seed added: " + seed);
				}
				Game game = new Game(level, seed);
				Controller controller = new Controller(game);
				controller.run();
			} else {
				throw new CommandParseException("No valid level name");
			}
		} else {
			throw new CommandParseException("Invalid number of arguments");
		}

	}
}
