package Chess.Pieces;

import Board.Board;
import Board.Position;
import Chess.ChessMatch;
import Chess.ChessPiece;
import Chess.Color;

public class Pawn extends ChessPiece{

	private ChessMatch cm;
	
	public Pawn(Board board, Color color,ChessMatch cm) {
		super(board, color);
		this.cm = cm;
	}

	@Override
	public String toString() {
		return "P";
	}

	@Override
	public boolean[][] possibleMoves() {
		boolean[][] temp = new boolean[getBoard().getRows()][getBoard().getColumns()];
		
		Position p = new Position(0,0);
		
		int pawnDirectionByColor = (getColor() == Color.WHITE) ? position.getRow() - 1 : position.getRow() + 1;
		int pawnDirectionByColorFirstMove = (getColor() == Color.WHITE) ? position.getRow() - 2 : position.getRow() + 2;
		
		//above(1 move)
		p.setValues(pawnDirectionByColor, position.getColumn());
		if(getBoard().positionExists(p)){
			if(getBoard().piece(p) == null) {
				temp[p.getRow()][p.getColumn()] = true;
			}else {
				temp[p.getRow()][p.getColumn()] = false;
			}
		}
		
		//above(2 moves)(only for first move)
		p.setValues(pawnDirectionByColorFirstMove, position.getColumn());
		Position p2moves = new Position(pawnDirectionByColor,position.getColumn()); //to verify if the intermediary space is empty
		if(getBoard().positionExists(p) && getBoard().positionExists(p2moves) && getMoveCount() == 0){
			if(getBoard().piece(p) == null && getBoard().piece(p2moves) == null) {
				temp[p.getRow()][p.getColumn()] = true;
			}else {
				temp[p.getRow()][p.getColumn()] = false;
			}
		}
		
		//sides(to capture):
		
		//side west
		p.setValues(pawnDirectionByColor, position.getColumn()-1);
		if(getBoard().positionExists(p)) {
			if(getBoard().piece(p) != null && isThereOpponentPiece(p)) {
				temp[p.getRow()][p.getColumn()] = true;
			}else {
				temp[p.getRow()][p.getColumn()] = false;
			}
		}
		
		//side east
		p.setValues(pawnDirectionByColor, position.getColumn()+1);
		if(getBoard().positionExists(p)) {
			if(getBoard().piece(p) != null && isThereOpponentPiece(p)) {
				temp[p.getRow()][p.getColumn()] = true;
			}else {
				temp[p.getRow()][p.getColumn()] = false;
			}
		}
		
		//#Special Move 
		//En Passant 
		
		//west
		p.setValues(pawnDirectionByColor, position.getColumn()-1);
		Position pawnEnPassantPosition = new Position(position.getRow(),position.getColumn()-1);
		if(getBoard().positionExists(p) && cm.getEnPassantVulnerable() != null) {
			if(getBoard().piece(p) == null && cm.getEnPassantVulnerable() == cm.getBoard().piece(pawnEnPassantPosition)) {
				temp[p.getRow()][p.getColumn()] = true;
			}else {
				temp[p.getRow()][p.getColumn()] = false;
			}
		}
		
		//east
		p.setValues(pawnDirectionByColor, position.getColumn()+1);
		pawnEnPassantPosition = new Position(position.getRow(),position.getColumn()+1);
		if(getBoard().positionExists(p) && cm.getEnPassantVulnerable() != null) {
			if(getBoard().piece(p) == null && cm.getEnPassantVulnerable() == cm.getBoard().piece(pawnEnPassantPosition)) {
				temp[p.getRow()][p.getColumn()] = true;
			}else {
				temp[p.getRow()][p.getColumn()] = false;
			}
		}
		
		
		return temp;
	}

	
	
}
