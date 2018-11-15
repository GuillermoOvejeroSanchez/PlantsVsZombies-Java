package elems;

public abstract class Plant extends GameObject {

	int cost;
	int freq;

	public Plant(int x, int y, int cycles, String name, int cost, int freq) {
		super(x, y, cycles, name);
		this.cost = cost;
		this.freq = freq;
	}

	public void damage(GameObject gameObject) {

	}

	public Plant parse(String plantName) {
		// TODO Auto-generated method stub
		return null;
	}

}
