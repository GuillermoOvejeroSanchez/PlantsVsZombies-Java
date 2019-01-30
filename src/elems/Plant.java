package elems;

import java.util.Random;

public abstract class Plant extends GameObject {

	protected int frec;
	protected int coste;
	protected boolean canHeal;
	
	public Plant(int coste, int frec, int resistencia, int danyo, int ciclos, String name, String shortName) {
		super(resistencia, danyo, ciclos, name, shortName);
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
	
	public boolean willHeal() {
		Random rand = new Random();
		double random = rand.nextDouble();
		//double random = game.getRand().nextDouble(); 
		/*No he podido usar el random del game, me da NullPointerException,
		 *  con tiempo podria cambiar a que el random fuese el mismo que el usado en el game
		 */
		
		if(random <= 0.1)
			return true;
		else
			return false;
	}
	
	public String toString() {
		String exclamation = "";
		if(this.canHeal)
			exclamation = "!";
		return shortName + " [" + res + "]" + exclamation;
	}

	public void setcanHeal(boolean willHeal) {
		this.canHeal = willHeal;
		
	}
	
	
	public void takeDmg(GameObject go) {
		this.setResistance(this.res - go.getDamage());
		if(isDead() && this.canHeal) {
			game.setHeal(true);
		}
	}
}
