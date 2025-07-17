package Chess.Pieces;

import Board.Board;
import Board.Position;
import Chess.ChessPiece;
import Chess.Color;

public class King extends ChessPiece{

	public King(Board board, Color color) {
		super(board, color);
	}

	@Override
	public String toString() {
		return "K";
	}

	@Override
	public boolean[][] possibleMoves() {
		boolean[][] temp = new boolean[getBoard().getRows()][getBoard().getColumns()];
		
		Position p = new Position(0,0);
		
		//above
		p.setValues(position.getRow() - 1, position.getColumn());
		if(getBoard().positionExists(p)){
			if(getBoard().piece(p) != null && !isThereOpponentPiece(p)) {
				temp[p.getRow()][p.getColumn()] = false;
			}else {
				temp[p.getRow()][p.getColumn()] = true;
			}
		}
		
		//under
		p.setValues(position.getRow() + 1, position.getColumn());
		if(getBoard().positionExists(p)) {
			if(getBoard().piece(p) != null && !isThereOpponentPiece(p)) {
				temp[p.getRow()][p.getColumn()] = false;
			}else {
				temp[p.getRow()][p.getColumn()] = true;
			}
		}
		
		//left
		p.setValues(position.getRow(), position.getColumn()-1);
		if(getBoard().positionExists(p)) {
			if(getBoard().piece(p) != null && !isThereOpponentPiece(p)) {
				temp[p.getRow()][p.getColumn()] = false;
			}else {
				temp[p.getRow()][p.getColumn()] = true;
			}
		}
		
		//right
		p.setValues(position.getRow(), position.getColumn()+1);
		if(getBoard().positionExists(p)) {
			if(getBoard().piece(p) != null && !isThereOpponentPiece(p)) {
				temp[p.getRow()][p.getColumn()] = false;
			}else {
				temp[p.getRow()][p.getColumn()] = true;
			}
		}
		
		//northwest
		p.setValues(position.getRow()- 1, position.getColumn()-1);
		if(getBoard().positionExists(p)) {
			if(getBoard().piece(p) != null && !isThereOpponentPiece(p)) {
				temp[p.getRow()][p.getColumn()] = false;
			}else {
				temp[p.getRow()][p.getColumn()] = true;
			}
		}
		
		//northeast
		p.setValues(position.getRow()-1, position.getColumn()+1);
		if(getBoard().positionExists(p)) {
			if(getBoard().piece(p) != null && !isThereOpponentPiece(p)) {
				temp[p.getRow()][p.getColumn()] = false;
			}else {
				temp[p.getRow()][p.getColumn()] = true;
			}
		}
		
		//southwest
		p.setValues(position.getRow()+1, position.getColumn()-1);
		if(getBoard().positionExists(p)) {
			if(getBoard().piece(p) != null && !isThereOpponentPiece(p)) {
				temp[p.getRow()][p.getColumn()] = false;
			}else {
				temp[p.getRow()][p.getColumn()] = true;
			}
		}
		
		//southeast
		p.setValues(position.getRow()+1, position.getColumn()+1);
		if(getBoard().positionExists(p)) {
			if(getBoard().piece(p) != null && !isThereOpponentPiece(p)) {
				temp[p.getRow()][p.getColumn()] = false;
			}else {
				temp[p.getRow()][p.getColumn()] = true;
			}
		}
		
		return temp;
	}
	
}
