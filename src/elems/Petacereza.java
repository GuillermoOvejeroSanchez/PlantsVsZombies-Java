package elems;

import src.Game;

public class Petacereza extends Plant {
	
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
		cycles = 2;
		cyclesLeft = cycles;
		dmg = 10;
		nameShort = "C";
		name = "petacereza";
		infoName = "Peta[c]ereza";
	}
	@Override
	public Plant parse(String plantName, int x, int y, Game game) {
		Plant p = null;

		if (plantName.equalsIgnoreCase(name) || plantName.equalsIgnoreCase(nameShort)) {
			p = new Petacereza(x, y, game);
		}
		return p;
	}

//Explota
	public void accion() {
//TODO accion Petacereza
	}
	
	public boolean attack() {
		return false;
	}

}
