package factory;

import java.util.Random;

import elems.Caracubo;
import elems.Deportista;
import elems.Zombie;
import elems.ZombieBasico;

public class ZombieFactory {

	private static Zombie[] availabeZombies = { new Caracubo(), new Deportista(), new ZombieBasico() };

	public static String listofAvailableZombies() {
		StringBuilder str = new StringBuilder();
		for (Zombie zombie : availabeZombies) {
			str.append(zombie.getName() + ": Speed " + zombie.getCycles() + "Harm:" + zombie.getDamage() + " Life: "
					+ zombie.getResistance() + System.lineSeparator() + System.lineSeparator());
		}
		return str.toString();
	}

	public static Zombie getZombie() {
		int zombie = new Random().nextInt(availabeZombies.length);
		return availabeZombies[zombie];
	}
}
