package elems;

public abstract class Plant extends GameObject {

	int cost;
	int freq;

	public Plant(int x, int y, int cycles, String name, String shortName, int cost, int freq) {
		super(x, y, cycles, name, shortName);
		this.cost = cost;
		this.freq = freq;
	}

	public void damage(GameObject gameObject) {

	}

	public abstract Plant parse(String plantName); 
	
	public int getCost() {
		return this.cost; 
	}

}
