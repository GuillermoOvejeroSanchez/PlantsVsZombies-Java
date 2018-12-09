package src;

import java.util.Random;

//import com.sun.org.apache.xerces.internal.xs.datatypes.ObjectList;

//import com.sun.org.apache.xerces.internal.xs.datatypes.ObjectList;

import elems.GameObject;
import elems.Plant;
import elems.Zombie;
import excepciones.CommandExecuteException;

import factory.ZombieFactory;
import lista.GameObjectList;
import print.GamePrinter;
import print.ReleasePrinter;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.*;
import elems.GameObject;


public class Game {
	
	public static final String wrongPrefixMsg = "unknown game attribute: ";
	public static final String lineTooLongMsg = "too many words on line commencing: ";
	 public static final String lineTooShortMsg = "missing data on line commencing: ";
	
	public final static int COLUMNAS = 8;
	public final static int FILAS = 4;
	public final int MAX_PLANTAS = 24;
	private Level level;
	private GameObjectList zombieList;
	private GameObjectList plantList;
	private static SuncoinManager suncoinManager;
	private GamePrinter gp;
	private ZombieManager zombieManager;
	private int seed;
	private int ciclos;
	private boolean exit;
	private Random rand;
	private boolean update;

	public Game(Level level, int seed) {
		rand = new Random();
		rand.setSeed(seed);
		this.seed = seed;
		this.ciclos = 0;
		this.level = level;
		this.exit = false;
		this.update = false;
		zombieManager = new ZombieManager(this.level, this.seed, this.rand);
		suncoinManager = new SuncoinManager();
		zombieList = new GameObjectList(zombieManager.getNumZombies());
		plantList = new GameObjectList(MAX_PLANTAS);
		this.setGamePrinter(new ReleasePrinter(FILAS, COLUMNAS, this));
	}

	public void update() {
		plantList.update();
		zombieList.update();
		aumentarCiclos();
		cleanBoard();
	}
	public void setLevel(Level level) {
		this.level = level;
	}
	private void cleanBoard() {
		plantList.clean();
		zombieManager.setNumZombies(zombieManager.getNumZombies() - zombieList.clean());
	}

	public void peashooterAttack(int x, int y, GameObject go) {
		zombieList.getAttacked(x, y, go);
	}

	public int getCiclos() {
		return ciclos;
	}
	public void setCiclos(int ciclos) {
		this.ciclos = ciclos;
	}

	public int getSuncoins() {
		return suncoinManager.getSuncoins();
	}

	public int getNumZombies() {
		return zombieManager.getNumZombies();
	}

	public int getRemainingZombies() {
		return zombieManager.getRemainingZombies();
	}
	public void SetRemainingZombies(int remZombies) {
		zombieManager.setRemainingZombies(remZombies);
	}

	public void modifySuncoins(int i) {
		suncoinManager.modifySuncoins(i);
	}

	public boolean checkWin() {
		return zombieManager.getNumZombies() == 0;
	}

	public String getCharacterDebugModePlant(int i) {

		return plantList.getStringDebug(i);
	}

	public String getCharacterDebugModeZombie(int i) {

		return zombieList.getStringDebug(i);
	}

	public boolean checkZombieWin() {
		boolean theyWin = false;
		for (int i = 0; i < FILAS; i++) {
			if (zombieList.encontrar(i, 0))
				theyWin = true;

		}
		return theyWin;
	}

	public void accionOrdenador() {

		if (this.zombieManager.isZombieAdded()) {
			int x = new Random().nextInt(FILAS);
			while (!isEmpty(x, COLUMNAS - 1))
				x = new Random().nextInt(FILAS); // Si hay 4 al principio peta el juego
			addZombie(ZombieFactory.getZombie(x, COLUMNAS - 1, this));
		}
	}

	public boolean attack(int x, int y, GameObject go) {
		boolean attacked = false;
		if (plantList.encontrar(x, y - 1)) {
			plantList.getAttacked(x, y - 1, go);
			attacked = true;
		}
		return attacked;

	}

	public boolean attackZombie(int x, int y, GameObject go) {
		boolean attacked = false;
		if (zombieList.encontrar(x, y)) {
			zombieList.getAttacked(x, y, go);
			attacked = true;
		}

		return attacked;
	}

	public void aumentarCiclos() {
		ciclos++;
	}

	public void reset() {
		zombieManager = new ZombieManager(level, seed, rand);
		suncoinManager = new SuncoinManager();
		ciclos = 0;
		zombieList = new GameObjectList(zombieManager.getNumZombies());
		plantList = new GameObjectList(MAX_PLANTAS);
		update = false;
	}

	public boolean addPlant(Plant plant) throws CommandExecuteException {
		boolean executed = false;
		if (plant != null) {
			if (plant.getX() < 4 && plant.getY() < 7 && plant.getX() > -1 && plant.getY() > -1) {
				if (isEmpty(plant.getX(), plant.getY())) {
					if (getSuncoins() >= plant.getCost()) {
						plantList.addObject(plant);
						modifySuncoins(-plant.getCost());
						executed = true;
					} else {
						throw new CommandExecuteException("Failed to add " + plant.getInfoName()
								+ " not enough Suncoins: " + getSuncoins() + " out of " + plant.getCost());
					}
				} else {
					throw new CommandExecuteException("Failed to add " + plant.getInfoName() + ": (" + plant.getX()
							+ ", " + plant.getY() + ") isn't empty");
				}
			} else {
				throw new CommandExecuteException("Failed to add " + plant.getInfoName() + ": (" + plant.getX() + ", "
						+ plant.getY() + ") is an invalid position");
			}
		}
		return executed;
	}

	public void addZombie(Zombie zombie) {
		zombieList.addObject(zombie);
	};

	public boolean isEmpty(int x, int y) {
		boolean empty = false;
		if (!plantList.encontrar(x, y))
			if (!zombieList.encontrar(x, y))
				empty = true;

		return empty;
	}

	public String getDificultad() {
		return this.level.name();
	}

	public int getSeed() {
		return seed;
	}

	public int GetSizeZombieList() {
		return this.zombieList.getSize();
	}

	public int GetSizePlantList() {
		return this.plantList.getSize();
	}

	public String getString(int x, int y) {
		return (plantList.getString(x, y) + zombieList.getString(x, y));
	}

	public int getNumPlants() {
		return plantList.getSize();
	}

	public String getLevel() {
		return level.name();
	}

	/*
	 * public String getPlantsStringDebug(int pos) { return
	 * plantList.getStringDebug(pos); }
	 * 
	 * public String getZombiesStringDebug(int pos) { return
	 * zombieList.getStringDebug(pos); }
	 */

	public boolean isZombie(int x, int y) {
		return zombieList.encontrar(x, y);
	}

	public String store() {

		StringBuilder datosJuego = new StringBuilder();

		datosJuego.append("cycles:");
		datosJuego.append(getCiclos());
		datosJuego.append("\n");
		datosJuego.append("sunCoins:");
		datosJuego.append(getSuncoins());
		datosJuego.append("\n");
		datosJuego.append("level:");
		datosJuego.append(getLevel());
		datosJuego.append("\n");
		datosJuego.append("remZombies:");
		datosJuego.append(getRemainingZombies());
		datosJuego.append("\n"); 
		datosJuego.append("plantList:");
		datosJuego.append(plantList.datosLista());
		datosJuego.append("\n"); 
		datosJuego.append("zombieList:"); 
		datosJuego.append(zombieList.datosLista()); 
		
		
		return datosJuego.toString(); 
		

	}
	
	private static String[] prefix = {
			"cycles", 
			"sunCoins", 
			"level", 
			"remZombies",
			"plantList",
			"zombieList"		
	};
	

	public boolean isFinished() {
		return exit;
	}

	public void setExit(boolean exit) {
		this.exit = exit;

	}

	public GamePrinter getGamePrinter() {
		return gp;
	}

	public void setGamePrinter(GamePrinter gp) {
		this.gp = gp;
	}
	

	public boolean getUpdate() {
		// TODO Auto-generated method stub
		return update;
	}
	public void setUpdate(boolean update) {
		this.update = update;
	}
	
	public String[] loadLine(BufferedReader inStream, String prefix, boolean isList) throws IOException, FileContentsException {

		String line = inStream.readLine().trim();
		// absence of the prefix is invalid
		if (!line.startsWith(prefix + ":"))
			throw new FileContentsException(wrongPrefixMsg + prefix);
		// cut the prefix and the following colon off the line
		// then trim it to get the attribute contents
		String contentString = line.substring(prefix.length() + 1).trim();
		String[] words;
		// the attribute contents are not empty
		if (!contentString.equals("")) {
			if (!isList) {
				// split non−list attribute contents into words
				// using 1−or−more−white−spaces as separator
				words = contentString.split("\\s+");
				// a non−list attribute with contents of more than one word is invalid
				if (words.length != 1)
					throw new FileContentsException(lineTooLongMsg + prefix);
			} else
				// split list attribute contents into words
				// using comma+0−or−more−white−spaces as separator
				words = contentString.split(",\\s*");
			// the attribute contents are empty
		} else {
			// a non−list attribute with empty contents is invalid
			if (!isList)
				throw new FileContentsException(lineTooShortMsg + prefix);
			// a list attibute with empty contents is valid;
			// use a zero−length array to store its words
			words = new String[0];
		}

		return words;

	}
	
	public void load(BufferedReader br) throws IOException, FileContentsException {
	
		String[] cycles; 
		String[] sunCoins; 
		String[] level; 
		String[] remZombies; 
		String[] listPlants; 
		String[] listZombies; 
		
		int parCycles; 
		int parSunCoins; 
		int parRemZombies; 
		Level lvl; 
		
		
		cycles = loadLine(br, prefix[0], false); 
		sunCoins  = loadLine(br, prefix[1], false);
		level  = loadLine(br, prefix[2], false);
		remZombies = loadLine(br, prefix[3], false);
		listPlants = loadLine(br, prefix[4], true);
		listZombies = loadLine(br, prefix[5], true);
		
		parCycles = Integer.parseInt(cycles[0]); 
		parSunCoins = Integer.parseInt(sunCoins[0]); 
		parRemZombies = Integer.parseInt(remZombies[0]); 
		lvl = Level.parse(level[0]); 
		
		suncoinManager.loadSuncoins(parSunCoins);
		setCiclos(parCycles);
		
		if(lvl == null) {
			throw new FileContentsException("nivel erroneo"); 
		}
		setLevel(lvl);
		SetRemainingZombies(parRemZombies);
		
		
		this.zombieList = new GameObjectList(MAX_PLANTAS); 
		loadList(listZombies, this.zombieList, false);
		
		this.plantList = new GameObjectList(MAX_PLANTAS); 
		loadList(listPlants, this.plantList, true);
		
		
		
		
		//System.out.println(this.ciclos); 
		
		


	public boolean getUpdate() {
		// TODO Auto-generated method stub
		return update;

	}
	
	public void loadList(String [] lista, GameObjectList objectList, boolean isPlant) {
		
		String[] objectInfo; 
		GameObject object; 
		
		
		for(int i = 0; i < lista.length; i++) {
			objectInfo = lista[i].split(":"); 
			
			if(!isPlant) {
				object = ZombieFactory.getZombie(objectInfo[0]); 
				/*
				if(object == null) {
					throw new FileContentsException("El zombie del fichero es incorrecto"); 
				}
				*/
			}
			else {
				object = PlantsFactory.getPlant(objectInfo[0]);
			}
			
			object.setResistance(Integer.parseInt(lista[1]));
			object.setX(Integer.parseInt(lista[2]));
			object.setY(Integer.parseInt(lista[3]));
			object.setRemainigCycles(Integer.parseInt(lista[4]));
			
			objectList.addObject(object); 
		}
		
	}
	

}






















