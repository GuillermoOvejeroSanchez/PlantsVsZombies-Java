package elems;

public class Peashooter extends Plant {
	final static int COST = 50;
	final static int CICLOS = 1;
	final static int FREC = 1;
	final static int DMG = 1;
	final static int RES = 3;
	final static String NAME = "[P]eashooter";

	public Peashooter() {
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
