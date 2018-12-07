package src;

import java.util.Random;

//import com.sun.org.apache.xerces.internal.xs.datatypes.ObjectList;

import elems.GameObject;
import elems.Plant;
import elems.Zombie;
import factory.ZombieFactory;
import lista.GameObjectList;
import print.GamePrinter;
import print.ReleasePrinter;

public class Game {
	public final int COLUMNAS = 8;
	public final int FILAS = 4;
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

	public Game(Level level, int seed) {
		rand = new Random();
		rand.setSeed(seed);
		this.seed = seed;
		this.ciclos = 0;
		this.level = level;
		this.exit = false;
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

	public int getSuncoins() {
		return suncoinManager.getSuncoins();
	}

	public int getNumZombies() {
		return zombieManager.getNumZombies();
	}

	public int getRemainingZombies() {
		return zombieManager.getRemainingZombies();
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
	}

	public String addPlant(Plant plant) {
		String exception = null;
		if (plant != null) {
			if (plant.getX() < 4 && plant.getY() < 7 && plant.getX() > -1 && plant.getY() > -1) {
				if (isEmpty(plant.getX(), plant.getY())) {
					if (getSuncoins() >= plant.getCost()) {
						plantList.addObject(plant);
						modifySuncoins(-plant.getCost());
					} else {
						exception = ("Failed to add " + plant.getInfoName() +" not enough Suncoins: " + getSuncoins() + " out of " + plant.getCost());
					}
				} else {
					exception = ("Failed to add " + plant.getInfoName() + ": (" + plant.getX() + ", " + plant.getY() + ") isn't empty");
				}
			} else {
				exception = ("Failed to add " + plant.getInfoName() + ": (" + plant.getX() + ", " + plant.getY() + ") is an invalid position" );
			}
		}
		return exception;
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

	public int getFilas() {
		return this.FILAS;
	}

	public int getColumnas() {
		return this.COLUMNAS;
	}

	public boolean isZombie(int x, int y) {
		return zombieList.encontrar(x, y);
	}

	public String store() {

		StringBuilder datosJuego = new StringBuilder();

		datosJuego.append("cycles: ");
		datosJuego.append(getCiclos());
		datosJuego.append("\n");
		datosJuego.append("sunCoins: ");
		datosJuego.append(getSuncoins());
		datosJuego.append("\n");
		datosJuego.append("Level: ");
		datosJuego.append(getLevel());
		datosJuego.append("\n");
		datosJuego.append("remZombies: ");
		datosJuego.append(getRemainingZombies());
		datosJuego.append("plantList: ");
		datosJuego.append(plantList.datosLista());
		datosJuego.append("zombieList: ");
		datosJuego.append(zombieList.datosLista());

		return datosJuego.toString();

	}

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

}
