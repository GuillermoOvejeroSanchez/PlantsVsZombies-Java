package print;

import src.*;
import util.MyStringUtils;

public class ReleasePrinter extends BoardPrinter {

	private String[][] board;
	private final int filas;
	private final int columnas;
	private int cycle, suncoins, remZombies;

	public ReleasePrinter(int filas, int columnas, Game game) {
		super(game);
		this.filas = filas;
		this.columnas = columnas;
	}

	public void encodeGame(Game game) {
		board = new String[filas][columnas];
		this.cycle = game.getCiclos();
		this.suncoins = game.getSuncoins();
		this.remZombies = game.getRemainingZombies();

		for (int i = 0; i < filas; i++) {
			for (int j = 0; j < columnas; j++) {
				board[i][j] = game.getString(i, j);
			}
		}

	}

	public String toString() {

		int cellSize = 7;
		int marginSize = 2;
		String vDelimiter = "|";
		String hDelimiter = "-";
		String rowDelimiter = MyStringUtils.repeat(hDelimiter, (columnas * (cellSize + 1)) - 1);
		String margin = MyStringUtils.repeat(espacio, marginSize);
		String lineDelimiter = String.format("%n%s%s%n", margin + espacio, rowDelimiter);

		StringBuilder str = new StringBuilder();

		str.append("Number of cycles: " + cycle + "\nCoins: " + suncoins + "\nRemaining zombies: " + remZombies + "\n\n");

		for (int j = 0; j < columnas; j++) {
			str.append(MyStringUtils.centre("", cellSize)).append(j);
		}
		
		str.append(lineDelimiter);


		for (int i = 0; i < filas; i++) {
			str.append(i);
			str.append(margin).append(vDelimiter);
			for (int j = 0; j < columnas; j++) {
				str.append(MyStringUtils.centre(board[i][j], cellSize)).append(vDelimiter);
			}
			str.append(lineDelimiter);
		}
		return str.toString();
	}
	//////////////////////////////////////////////////////////////////

}
