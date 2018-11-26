package factory;

import java.util.Random;

import elems.Caracubo;
import elems.Deportista;
import elems.Zombie;
import elems.ZombieBasico;
import src.Game;

public class ZombieFactory {

	private static Zombie[] availabeZombies = { new Caracubo(), new Deportista(), new ZombieBasico() };

	public static String listofAvailableZombies() {
		StringBuilder str = new StringBuilder();
		for (Zombie zombie : availabeZombies) {
			str.append(zombie.getInfoName() + ":\tSpeed: " + zombie.getCycles() + " Harm: " + zombie.getDamage()
					+ " Life: " + zombie.getResistance() + System.lineSeparator() + System.lineSeparator());
		}
		return str.toString();
	}

	public static Zombie getZombie(int x, int y, Game game) {
		int zombieType = new Random().nextInt(availabeZombies.length);
		Zombie zombie = availabeZombies[zombieType].inPosition(x, y, game);
		zombie.setX(x);
		zombie.setY(y);
		zombie.setGame(game);
		return zombie;
	}
}
