package elems;

import src.Game;

public class Peashooter extends Plant {


	public final static int COSTE = 50;
	public final static int CICLOS = 2; 
	public final static int	FRECUENCIA = 1; // TODO REVISAR
	public final static int DANYO = 1; 
	public final static int RESISTENCIA = 3; 
	
	public final static String NOMBRE = "[P]eashooter";
	public final static String SHORT_NAME = "P";

	
	public Peashooter() {
		super(COSTE, FRECUENCIA, RESISTENCIA, DANYO, CICLOS, NOMBRE, SHORT_NAME);
		// TODO Auto-generated constructor stub
	}
	
/*
	private void inicializar() {
		cost = 50;
		res = 3;
		cycles = 2;
		cyclesLeft = cycles;
		dmg = 1;
		nameShort = "P";
		name = "peashooter";
		infoName = "[P]eashooter";
	}
*/


	public Plant parse(String plantName) {
		Plant p = null;

		if (plantName.equalsIgnoreCase(NOMBRE) || plantName.equalsIgnoreCase(SHORT_NAME)) {
			p = new Peashooter();
			
			//TODO añadir x y 
		}
		return p;
	}

	public void accion() {
		game.peashooterAttack(this.x, this.y, this);
	}

	public boolean attack() {
		return false;
	}
	
	
}
