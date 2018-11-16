package elems;

public class Sunflower extends Plant {

	final static int COST = 20;
	final static int CICLOS = 0;
	final static int FREC = 1;
	final static int DMG = 0;
	final static int RES = 1;
	final static String NAME = "[S]unflower";
	final static String SHORTNA = "S"; 

	public Sunflower() {
		super(RES, FREC, DMG, NAME, SHORTNA, COST, CICLOS);
	}

	
	public Plant parse(String plantName) {
	Plant p = null; 
		
		if(plantName.equalsIgnoreCase(getName()) || plantName.equalsIgnoreCase(getShortName()) ) {
			p = this; 
		}
	
		return p; 
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


	@Override
	public int getDamage() {
		// TODO Auto-generated method stub
		return 0;
	}

}
