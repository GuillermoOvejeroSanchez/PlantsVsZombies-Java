package src;

import java.util.Random;

//import com.sun.org.apache.xerces.internal.xs.datatypes.ObjectList;

import elems.GameObject;
import elems.Plant;
import elems.Zombie;
import factory.ZombieFactory;
import lista.GameObjectList;

public class Game {
	public final int COLUMNAS = 8;
	public final int FILAS = 4;
	public final int MAX_PLANTAS = 24;
	private Level level;
	private GameObjectList zombieList;
	private GameObjectList plantList;
	private static SuncoinManager suncoinManager;
	private ZombieManager zombieManager;
	private int seed;
	// private boolean fin;
	private boolean zombieWin;
	private int ciclos;
	private Random rand;

	public Game(Level level, int seed) {
		rand = new Random();
		rand.setSeed(seed);
		this.seed = seed;
		this.ciclos = 0;
		this.level = level;
		// this.fin = false;
		this.zombieWin = false;
		zombieManager = new ZombieManager(this.level, this.seed, this.rand);
		suncoinManager = new SuncoinManager();
		zombieList = new GameObjectList(zombieManager.getNumZombies());
		plantList = new GameObjectList(MAX_PLANTAS);
	}

	public void update() {
		//aumentarCiclos();
		plantList.update();
		zombieList.update();
		aumentarCiclos();
		cleanBoard();
		getFin();
		zombieWin = checkZombieWin();
	}

	private void cleanBoard() {
		plantList.clean();
		zombieManager.setNumZombies(zombieManager.getNumZombies() - zombieList.clean());
	}

	public void peashooterAttack(int x, int y, GameObject go) {
		boolean encontrado = false;
		int i = 0;
		while (!encontrado && y < COLUMNAS) {
			if (zombieList.encontrar(x, y + i)) {
				zombieList.getAttacked(x, y + i, go);
				encontrado = true;
			}
			i++;
		}
	}

	public boolean getZombieWin() {
		return zombieWin;
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

	public boolean getFin() {
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

	public void aumentarCiclos() {
		ciclos++;
	}

	public void reset() {
		zombieManager = new ZombieManager(level, seed, rand);
		suncoinManager = new SuncoinManager();
		// fin = false;
		ciclos = 0;
		zombieList = new GameObjectList(zombieManager.getNumZombies());
		plantList = new GameObjectList(MAX_PLANTAS);
	}

	public void addPlant(Plant plant) {
		plantList.addObject(plant);
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
		return this.level.getDif();
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

	public void explode(int x, int y, GameObject go) {
		for (int i = -1; i <= 1; i++) {
			for (int j = -1; j <= 1; j++) {
				if (!isEmpty(x - i, y - j))
					if (zombieList.encontrar(x - i, y - j))
						zombieList.getAttacked(x - i, y - j, go);
			}
		}
	}

	public String getString(int x, int y) {
		return (plantList.getString(x, y)+ zombieList.getString(x, y));
	}

	public int getNumPlants() {
		return plantList.getSize();
	}

	public String getLevel() {
		return level.name();
	}
/*
	public String getPlantsStringDebug(int pos) {
		return plantList.getStringDebug(pos);
	}
	
	public String getZombiesStringDebug(int pos) {
		return zombieList.getStringDebug(pos);
	}
	*/

	public int getFilas() {
		return this.FILAS;
	}

	public int getColumnas() {
		return this.COLUMNAS;
	}

}
