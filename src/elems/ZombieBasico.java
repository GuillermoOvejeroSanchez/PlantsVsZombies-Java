package elems;

public class ZombieBasico extends Zombie {

	final static int COST = 50;
	final static int CICLOS = 0;
	final static int FREC = 2;
	final static int DMG = 1;
	final static int RES = 5;
	final static String NAME = "[Z]ombie";

	public ZombieBasico() {
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
