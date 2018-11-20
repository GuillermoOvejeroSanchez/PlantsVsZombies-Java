package elems;

import src.Game;

public abstract class Plant extends GameObject {

	protected int cost;

	protected Plant(int x, int y, Game game) {
		super(x, y, game);
	}

	protected Plant() {
	}

	public Plant parse(String plantName, int x, int y, Game game) {
		Plant p = null;

		if (plantName.equalsIgnoreCase(getName()) || plantName.equalsIgnoreCase(getShortName())) {
			// p = new Plant(x,y); //TODO como hacer esto para no repetir el codigo en todos
			// las plantas
		}
		return p;
	}

	public int getCost() {
		return this.cost;
	}

	
}
