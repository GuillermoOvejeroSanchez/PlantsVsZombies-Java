package factory;

import elems.Nuez;
import elems.Peashooter;
import elems.Petacereza;
import elems.Plant;
import elems.Sunflower;

public class PlantsFactory {

	private static Plant[] availabePlants = { new Nuez(), new Peashooter(), new Petacereza(), new Sunflower() };

	public static String listOfAvailablePlants() {
		StringBuilder str = new StringBuilder();
		for (Plant plant : availabePlants) {
			str.append(plant.getName() + ": Cost " + plant.getCost() + " suncoins " + "Harm " + plant.getDamage()
					+ System.lineSeparator());
		}
		return str.toString();
	}

	public static Plant getPlant(String plantName) {
		Plant plant = null;
		int i = 0;
		boolean encontrado = false;
		while (!encontrado && i < availabePlants.length) {
			plant = plant.parse(plantName);
			if (plant != null)
				encontrado = true;
			else
				i++;
		}

		return plant;
	}
}
