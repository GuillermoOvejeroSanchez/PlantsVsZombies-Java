package src;

import util.MyStringUtils;

public class GamePrinter {
	int dimX;
	int dimY;
	String[][] board;
	final String space = " ";

	public GamePrinter(Game game, int dimX, int dimY) {
		this.dimX = dimX;
		this.dimY = dimY;
		encodeGame(game);
	}

	public void encodeGame(Game game) {
		board = new String[dimX][dimY];
		for (int i = 0; i < dimX; i++) {
			for (int j = 0; j < dimY; j++)
				board[i][j] = game.getCharacterInCoordante(i, j);
		}
	}

	private String toStringBoard() {
		int cellSize = 7;
		int marginSize = 2;
		String vDelimiter = "|";
		String hDelimiter = "-";
		String rowDelimiter = MyStringUtils.repeat(hDelimiter, (dimY * (cellSize + 1)) - 1);
		String margin = MyStringUtils.repeat(space, marginSize);
		String lineDelimiter = String.format("%n%s%s%n", margin + space, rowDelimiter);

		StringBuilder str = new StringBuilder();

		str.append(lineDelimiter);

		for (int i = 0; i < dimX; i++) {
			str.append(i);
			str.append(margin).append(vDelimiter);
			for (int j = 0; j < dimY; j++) {
				str.append(MyStringUtils.centre(board[i][j], cellSize)).append(vDelimiter);

			}
			str.append(lineDelimiter);
		}
		return str.toString();
	}

	public void printBoard(Game game) {
		System.out.print(toStringBoard());
		System.out.println("Number of cycles: " + game.getCiclos());
		System.out.println("Sun Coins: " + game.getSuncoins());
		System.out.println("Remaining Zombies: " + game.getRemainingZombies());
		System.out.println(("Total Zombies: " + game.getNumZombies()));
	}

	public void printGame() {
		// TODO Auto-generated method stub

	}
}