package application;

import java.util.Scanner;

import Chess.ChessMatch;
import Chess.ChessPiece;
import Chess.ChessPosition;
import ChessConsole.UI;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		ChessMatch chessmatch = new ChessMatch();
		UI.printTable(chessmatch);
		
		System.out.print("Source:");
		ChessPosition source = UI.readChessPosition(sc);
		
		System.out.print("Target:");
		ChessPosition target = UI.readChessPosition(sc);
		
		ChessPiece captured = chessmatch.performChessMove(source,target);
		UI.printTable(chessmatch);
		System.out.println("Captured piece:"+captured);
		
		sc.close();
	}

}
