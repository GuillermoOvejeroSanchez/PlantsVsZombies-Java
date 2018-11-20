package src;

import java.util.Random;

import elems.GameObject;
import elems.Plant;
import elems.Zombie;
import factory.ZombieFactory;
import lista.GameObjectList;

public class Game {
	static public final int COLUMNAS = 8;
	static public final int FILAS = 4;
	public final int MAX_PLANTAS = 24;
	private Level level;
	private GameObjectList zombieList;
	private GameObjectList plantList;
	private static SuncoinManager suncoinManager;
	private ZombieManager zombieManager;
	private int seed;
	//private boolean fin;
	private boolean zombieWin;
	private int ciclos;
	private Random rand;

	public Game(Level level, int seed) {
		rand = new Random();
		rand.setSeed(seed);
		this.seed = seed;
		this.ciclos = 0;
		this.level = level;
		//this.fin = false;
		this.zombieWin = false;
		zombieManager = new ZombieManager(this.level, this.seed, this.rand);
		suncoinManager = new SuncoinManager();
		zombieList = new GameObjectList(zombieManager.getNumZombies());
		plantList = new GameObjectList(MAX_PLANTAS);
	}

	public void update() {
		aumentarCiclos();
		plantList.update();
		zombieList.update();
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

	public String getCharacterInCoordante(int x, int y) {
		String elem = " ";
		if (plantList.encontrar(x, y)) {
			elem = plantList.toString(x, y);
		}
		if (zombieList.encontrar(x, y)) {
			elem = zombieList.toString(x, y);
		}

		return elem;
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
		//fin = false;
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

	public void explode(int x, int y, GameObject go) {
		for (int i = -1; i <= 1; i++) {
			for (int j = -1; j <= 1; j++) {
				if (!isEmpty(x - i, y - j))
					if (zombieList.encontrar(x - i, y - j))
						zombieList.getAttacked(x - i, y - j, go);
			}
		}
	}

	// TODO hacer un level to string para el modo debug

//
//	public boolean dispararPea(int x, int y, int dmg) {
//		boolean zombieEncontrado = false;
//
//		while (y < COLUMNAS && !zombieEncontrado) {
//			zombieEncontrado = (board[x][y].equals(Elements.ZOMBIE));
//			y++;
//		}
//
//		if (zombieEncontrado)
//			zList.atacado(x, y - 1, dmg);
//
//		return zombieEncontrado;
//	}
//

}
