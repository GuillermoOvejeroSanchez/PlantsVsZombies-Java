package elems;

public abstract class Plant extends GameObject {

	int cost;
	int freq;

	public Plant(int x, int y, int cycles, String name, String shortName, int cost, int freq) {
		super(x, y, cycles, name, shortName);
		this.cost = cost;
		this.freq = freq;
	}
	public Plant() {
		super();
	}

	public void damage(GameObject gameObject) {

	}

	public Plant parse(String plantName) {
	Plant p = null; 
		
		if(plantName.equalsIgnoreCase(getName()) || plantName.equalsIgnoreCase(getShortName()) ) {
			p = this; 
		}
	
		return p;
	}
	
	public int getCost() {
		return this.cost; 
	}

}
