package factory;

import elems.Nuez;
import elems.Peashooter;
import elems.Petacereza;
import elems.Plant;
import elems.Sunflower;
import src.Game;

public class PlantsFactory {

	private static Plant[] availablePlants = { new Nuez(), new Peashooter(), new Petacereza(), new Sunflower() };

	public static String listOfAvailablePlants() {
		StringBuilder str = new StringBuilder();
		for (Plant plant : availablePlants) {
			str.append(plant.getInfoName() + ": \tCost " + plant.getCost() + " SunCoins " + "Harm: " + plant.getDamage() +  System.lineSeparator() +  System.lineSeparator());
		}
		return str.toString();
	}

	public static Plant getPlant(String plantName, int x, int y, Game game) {
		Plant plant = null;
		int i = 0;
		boolean encontrado = false;
			while (!encontrado && i < availablePlants.length) {
				plant = availablePlants[i].parse(plantName);
				if (plant != null) {
					encontrado = true;
					plant.setX(x);
					plant.setY(y);
					plant.setGame(game);
				} else
					i++;
			}
		return plant;
	}
}
