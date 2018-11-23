package elems;

import src.Game;

public class Petacereza extends Plant {
/*
	public Petacereza(int x, int y, Game game) {
		super(x, y, game);
		inicializar();
	}

	public Petacereza() {
		inicializar();
	}

	private void inicializar() {
		cost = 50;
		res = 2;
		cycles = 3;
		cyclesLeft = cycles;
		dmg = 10;
		nameShort = "C";
		name = "petacereza";
		infoName = "Peta[c]ereza";
	}
*/
	

	
	public final static int COSTE = 50;
	public final static int CICLOS = 3; 
	public final static int	FRECUENCIA = 1; // TODO REVISAR
	public final static int DANYO = 10; 
	public final static int RESISTENCIA = 2; 
	
	public final static String NOMBRE = "Peta[c]ereza";
	public final static String SHORT_NAME = "C";

	
	public Petacereza() {
		super(COSTE, FRECUENCIA, RESISTENCIA, DANYO, CICLOS, NOMBRE, SHORT_NAME);
		// TODO Auto-generated constructor stub
	}
	
	

	
	
	
	public Plant parse(String plantName) {
		Plant p = null;

		if (plantName.equalsIgnoreCase(NOMBRE) || plantName.equalsIgnoreCase(SHORT_NAME)) {
			p = new Petacereza();
			
			//TODO añadir x y 
		}
		return p;
	}
//Explota
	public void accion() {
		game.explode(this.x, this.y, this);
		res = 0;
	}

}
