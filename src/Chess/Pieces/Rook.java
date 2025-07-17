package Chess.Pieces;

import Board.Board;
import Board.Position;
import Chess.ChessPiece;
import Chess.Color;

public class Rook extends ChessPiece{

	public Rook(Board board, Color color) {
		super(board, color);
	}

	@Override
	public String toString() {
		return "R";
	}

	@Override
	public boolean[][] possibleMoves() {
		boolean[][] temp = new boolean[getBoard().getRows()][getBoard().getColumns()];
		
		Position p = new Position(0,0);
		
		//above
		p.setValues(position.getRow() - 1, position.getColumn());
		while(getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) { //while exists the position and havent a piece.
			temp[p.getRow()][p.getColumn()] = true;
			p.setRow(p.getRow() - 1);
		}
		if(getBoard().positionExists(p) && isThereOpponentPiece(p)) { //if while stopped, have a piece,is a valid position and is a opponent piece
			temp[p.getRow()][p.getColumn()] = true;
		}
		
		//left
		p.setValues(position.getRow(), position.getColumn()-1);
		while(getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
			temp[p.getRow()][p.getColumn()] = true;
			p.setColumn(p.getColumn() - 1);
		}
		if(getBoard().positionExists(p) && isThereOpponentPiece(p)) { 
			temp[p.getRow()][p.getColumn()] = true;
		}
		
		//right
		p.setValues(position.getRow(), position.getColumn()+1);
		while(getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
			temp[p.getRow()][p.getColumn()] = true;
			p.setColumn(p.getColumn() + 1);
		}
		if(getBoard().positionExists(p) && isThereOpponentPiece(p)) { 
			temp[p.getRow()][p.getColumn()] = true;
		}
			
		//under
		p.setValues(position.getRow() + 1, position.getColumn());
		while(getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) { 
			temp[p.getRow()][p.getColumn()] = true;
			p.setRow(p.getRow() + 1);
		}
		if(getBoard().positionExists(p) && isThereOpponentPiece(p)) { 
			temp[p.getRow()][p.getColumn()] = true;
		}
		
		return temp;
	}
}
