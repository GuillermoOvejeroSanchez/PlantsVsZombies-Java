package elems;

import src.Game;

public class Nuez extends Plant {
/*
	public Nuez(int x, int y, Game game) {
		super(x, y, game);
		inicializar();
	}

	public Nuez() {
		inicializar();
	}

	private void inicializar() {
		cost = 50;
		res = 10;
		cycles = 0;
		nameShort = "N";
		name = "nuez";
		infoName = "[N]uez";
	}
*/
	
	public final static int COSTE = 50;
	public final static int CICLOS = 0; 
	public final static int	FRECUENCIA = 1; // TODO REVISAR
	public final static int DANYO = 0; // TODO revisar 
	public final static int RESISTENCIA = 10; 
	
	public final static String NOMBRE = "[S]unflower";
	public final static String SHORT_NAME = "S";

	
	public Nuez() {
		super(COSTE, FRECUENCIA, RESISTENCIA, DANYO, CICLOS, NOMBRE, SHORT_NAME);
		// TODO Auto-generated constructor stub
	}


	public Plant parse(String plantName) {
		Plant p = null;

		if (plantName.equalsIgnoreCase(NOMBRE) || plantName.equalsIgnoreCase(SHORT_NAME)) {
			p = new Nuez();
			
			//TODO añadir x y 
		}
		return p;
	}
	
	

	public boolean accion() {
		return true;

	}

}
