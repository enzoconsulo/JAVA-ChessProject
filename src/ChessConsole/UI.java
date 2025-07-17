package ChessConsole;

import java.util.Scanner;

import Board.Board;
import Board.Piece;
import Chess.ChessMatch;
import Chess.ChessPiece;
import Chess.ChessPosition;
import Chess.Color;

public class UI {
	
	public static final String ANSI_RESET = "\u001B[0m";
	public static final String ANSI_BLACK = "\u001B[30m";
	public static final String ANSI_RED = "\u001B[31m";
	public static final String ANSI_GREEN = "\u001B[32m";
	public static final String ANSI_YELLOW = "\u001B[33m";
	public static final String ANSI_BLUE = "\u001B[34m";
	public static final String ANSI_PURPLE = "\u001B[35m";
	public static final String ANSI_CYAN = "\u001B[36m";
	public static final String ANSI_WHITE = "\u001B[37m";

	public static final String ANSI_BLACK_BACKGROUND = "\u001B[40m";
	public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
	public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
	public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
	public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
	public static final String ANSI_PURPLE_BACKGROUND = "\u001B[45m";
	public static final String ANSI_CYAN_BACKGROUND = "\u001B[46m";
	public static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";

	public static void printTable(ChessMatch cm) {
		Board board = cm.getBoard();
		Piece[][] pieces = board.getPieces();
		for (int i = 0; i < board.getRows(); i++) {
			System.out.print(8 - i +" |");
			for (int j = 0; j < board.getColumns(); j++) {
				System.out.print(printPiece((ChessPiece) pieces[i][j],false));
			}
		System.out.println();
		}
		System.out.println("----------------------------");
		System.out.println("  | a  b  c  d  e  f  g  h");
	}
	
	public static void printTable(ChessMatch cm,boolean[][] sourcePossibleMoves) {
		Board board = cm.getBoard();
		Piece[][] pieces = board.getPieces();
		for (int i = 0; i < board.getRows(); i++) {
			System.out.print(8 - i +" |");
			for (int j = 0; j < board.getColumns(); j++) {
				if(sourcePossibleMoves[i][j]) {
				System.out.print(printPiece((ChessPiece) pieces[i][j],true));
				}else{
				System.out.print(printPiece((ChessPiece) pieces[i][j],false));
				}
			}
		System.out.println();
		}
		System.out.println("----------------------------");
		System.out.println("  | a  b  c  d  e  f  g  h");
	}

	private static String printPiece(ChessPiece piece,boolean possibleCapture) {
		if (piece == null && possibleCapture) {
			return(" " + ANSI_RED + "-" + ANSI_RESET +" "); 
		}else if(piece == null){
			return(" - ");
		}
		
		 if (piece.getColor() == Color.WHITE) {
             if(possibleCapture)return(ANSI_RED + "(" + ANSI_RESET + ANSI_WHITE + piece + ANSI_RESET+ANSI_RED + ")" + ANSI_RESET );
			 return(" " + ANSI_WHITE + piece + ANSI_RESET + " ");
         }
         else {
        	 if(possibleCapture)return(ANSI_RED + "(" + ANSI_RESET + ANSI_BLACK + piece + ANSI_RESET+ANSI_RED + ")" + ANSI_RESET 
        			 );
             return(" " + ANSI_BLACK + piece + ANSI_RESET + " ");
         }
	}	 
	
	public static ChessPosition readChessPosition(Scanner sc){
		boolean sucess = false;
		char[] inputR = new char[2] ;
		while(sucess == false) {
			String input = sc.nextLine();
			if (input.length() == 2) {
				inputR[0] = input.toLowerCase().charAt(0);
				inputR[1] = input.charAt(1);
				sucess = true;
			}else {
				System.out.print("\n"
						+"                                    char   int\n"
						+"Type the posicion to read format->(Column)(Row) ! ");
			}
		}
		
		ChessPosition cp = new ChessPosition(inputR[0],((int) inputR[1]-'0'));
		return cp;
	}
	
	/*public static void clearScreen() {
		System.out.print("\033[H\033[2J");
		System.out.flush();
		}
	*/
	
	public static void clearScreen() {
	    for (int i = 0; i < 100; i++) {        //chunking to use on Eclipse console, but the right is the comment above
	        System.out.println();
	    }
	}
	
	
}
