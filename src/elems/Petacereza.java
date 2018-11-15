package elems;

public class Petacereza extends Plant {
	final static int COST = 50;
	final static int CICLOS = 2;
	final static int FREC = 0;
	final static int DMG = 10;
	final static int RES = 2;
	final static String NAME = "Peta[c]ereza";

	public Petacereza() {
		super(RES, FREC, DMG, NAME, COST, CICLOS);
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return NAME;
	}

	@Override
	public int getDamage() {
		// TODO Auto-generated method stub
		return DMG;
	}

	@Override
	public int getCycles() {
		// TODO Auto-generated method stub
		return CICLOS;
	}

	@Override
	public int getResistance() {
		// TODO Auto-generated method stub
		return RES;
	}

	@Override
	public int getCost() {
		// TODO Auto-generated method stub
		return COST;
	}

}
