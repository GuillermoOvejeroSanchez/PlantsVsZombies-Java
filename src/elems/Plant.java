package elems;

public abstract class Plant extends GameObject {

	int cost;

	public Plant(int x, int y, int res, int dmg, int cycles, String name, String shortName, int cost) {
		super(x, y, res, dmg, cycles, name, shortName);
		this.cost = cost;
	}

	public Plant() {
	}

	public Plant parse(String plantName, int x, int y) {
		Plant p = null;

		if (plantName.equalsIgnoreCase(getName()) || plantName.equalsIgnoreCase(getShortName())) {
			//p = new Plant(x,y); //TODO como hacer esto para no repetir el codigo en todos las plantas
		}
		return p;
	}

	public int getCost() {
		return this.cost;
	}

}
