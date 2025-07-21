package application;

import java.util.InputMismatchException;
import java.util.Scanner;

import Chess.ChessException;
import Chess.ChessMatch;
import Chess.ChessPiece;
import Chess.ChessPosition;
import ChessConsole.UI;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ChessMatch chessmatch = new ChessMatch();
		
		while(!chessmatch.getCheckMate()) {
			
			try {
				UI.printTable(chessmatch);

				System.out.print("Source:");
				ChessPosition source = UI.readChessPosition(sc);
				
				UI.clearScreen();
				boolean[][] possibleMoves = chessmatch.possibleMoves(source);
				UI.printTable(chessmatch, possibleMoves);
				
				System.out.print("Target:");
				ChessPosition target = UI.readChessPosition(sc);
				
				chessmatch.performChessMove(source,target);
				
				if(chessmatch.getPromoted() != null) {
					System.out.print("Promotion! \n >Choose your Chess Piece type to promote( Q / R / B / N ):");
					String input = sc.nextLine();
					chessmatch.replacePromotedPiece(input);
				}
				
				UI.clearScreen();
				
				}catch(ChessException e){
					System.out.println(e.getMessage()+"\n Press Enter to Continue.\n");
					sc.nextLine();
					UI.clearScreen();
				}catch(InputMismatchException e){
					System.out.println(e.getMessage()+"\n Press Enter to Continue.\n");
					sc.nextLine();
					UI.clearScreen();
			}
		}
		
		UI.checkMateMessage(chessmatch);
		sc.close();
		
	}

}
