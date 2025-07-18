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
				
				UI.clearScreen();
				
				}catch(ChessException e){
					System.out.println(e.getMessage()+"\n Press Enter to Continue.\n");
					sc.nextLine();
				}catch(InputMismatchException e){
					System.out.println(e.getMessage()+"\n Press Enter to Continue.\n");
					sc.nextLine();
			}
		}
		
		//sc.close() (when checkmate = true)(not implementable now)
		
		
	}

}
