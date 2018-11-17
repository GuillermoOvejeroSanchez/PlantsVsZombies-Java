package elems;

public class Deportista extends Zombie {
	final static int CICLOS = 1;
	final static int FREC = 1;
	final static int DMG = 1;
	final static int RES = 2;
	final static String NAME = "deportista";
	final static String INFONAME = "[D]eportista";
	final static String SHORTNA = "D";
	public Deportista() {
		super(RES, FREC, DMG, NAME, SHORTNA);
	}

}
