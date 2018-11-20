package print;
import src.*;
import util.MyStringUtils;

public class DebugPrinter extends BoardPrinter {

	public DebugPrinter(int filas, int columnas, Game game) {
		super(filas, columnas);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void encodeGame(Game game) {
		board = new String[0][columnas]; 
		
		for(int i = 0; i < columnas; i++) {
			board[0][i] = espacio; // implenatar bichos; 
		}
	}
	
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
		System.out.println(("Level" + game.getNumZombies()));
		System.out.print("Command > ");
	}
	
	
	

}
