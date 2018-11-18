package elems;

public abstract class Plant extends GameObject {

	int cost;
	int freq;

	public Plant(int x, int y, int res, int dmg, int cycles, String name, String shortName, int cost, int freq) {
		super(x, y, res, dmg, cycles, name, shortName);
		this.cost = cost;
		this.freq = freq;
	}

	public Plant() {
	}

	public void damage(GameObject gameObject) {

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
