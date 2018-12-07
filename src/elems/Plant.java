package elems;

public abstract class Plant extends GameObject {

	protected int frec; 
	protected int coste; 
	
	public Plant(int coste, int frec, int resistencia, int danyo, int ciclos, String name, String shortName) {
		super(resistencia,  danyo,  ciclos,  name,  shortName);
		this.coste = coste; 
		this.frec = frec; 
		
	}
	
	public abstract Plant parse(String plantName);

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
		return this.coste;
	}


	public String getName() {
		return this.name;
	}

}
