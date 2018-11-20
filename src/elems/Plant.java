package elems;

import src.Game;

public abstract class Plant extends GameObject {

	protected int cost;

	protected Plant(int x, int y, Game game) {
		super(x, y, game);
	}

	protected Plant() {
	}

	public abstract Plant parse(String plantName, int x, int y, Game game);

	/*
	 * //TODO como hacer esto para no repetir el codigo en todos public Plant
	 * parse(String plantName, int x, int y, Game game) { Plant p = null;
	 * 
	 * if (plantName.equalsIgnoreCase(getName()) ||
	 * plantName.equalsIgnoreCase(getShortName())) { // p = new Plant(x,y); // las
	 * plantas } return p; }
	 */
	public boolean update() {
		int ciclos = --this.cyclesLeft;
		if (this.cyclesLeft == 0) {
			this.accion();
			this.cyclesLeft = this.cycles;
		}
		return ciclos == 0;
	}

	public int getCost() {
		return this.cost;
	}

}
