package elems;

public class Caracubo extends Zombie {
	final static int COST = 50;
	final static int CICLOS = 0;
	final static int FREC = 0;
	final static int DMG = 0;
	final static int RES = 10;
	final static String NAME = "[N]uez";

	public Caracubo() {
		super(RES, FREC, DMG, NAME);
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
