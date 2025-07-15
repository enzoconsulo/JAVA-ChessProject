package application;

import Chess.ChessMatch;
import Chess.ChessPosition;
import ChessConsole.UI;

public class Program {

	public static void main(String[] args) {
		ChessMatch chessmatch = new ChessMatch();
		UI.printTable(chessmatch);
		
	}

}
