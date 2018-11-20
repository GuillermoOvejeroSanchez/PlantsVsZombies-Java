package print;

import src.Game;
import util.MyStringUtils; 

public abstract class BoardPrinter implements GamePrinter{
	
	protected int filas; 
	protected int columnas; 
	protected String[][] board; 
	protected final String espacio = " ";
	
	public BoardPrinter(int filas, int columnas) {
		this.filas = filas; 
		this.columnas = columnas; 
		// pintar tablero 
	
	}
	
	public abstract void encodeGame(Game game); 
	
	
	public String printGame() {

		int cellSize = 7;
		int marginSize = 2;
		String vDelimiter = "|";
		String hDelimiter = "-";
		String rowDelimiter = MyStringUtils.repeat(hDelimiter, (filas * (cellSize + 1)) - 1);
		String margin = MyStringUtils.repeat(espacio, marginSize);
		String lineDelimiter = String.format("%n%s%s%n", margin + espacio, rowDelimiter);
		
		StringBuilder str = new StringBuilder();
		
		str.append(lineDelimiter);
		
		for(int i=0; i<columnas; i++) {
				str.append(margin).append(vDelimiter);
				for (int j=0; j<filas; j++) {
					str.append( MyStringUtils.centre(board[i][j], cellSize)).append(vDelimiter);
				}
				str.append(lineDelimiter);
		}
		return str.toString();
	}
	
	public void printBoard(Game game) {
		System.out.print(printGame());
		System.out.println("Number of cycles: " + game.getCiclos());
		System.out.println("Sun Coins: " + game.getSuncoins());
		System.out.println("Remaining Zombies: " + game.getRemainingZombies());
		System.out.println(("Total Zombies: " + game.getNumZombies()));
		System.out.print("Command > ");
	}
	

}
