package Chess.Pieces;

import Board.Board;
import Board.Position;
import Chess.ChessPiece;
import Chess.Color;

public class Knight extends ChessPiece{

	public Knight(Board board, Color color) {
		super(board, color);
	}

	@Override
	public String toString() {
		return "N";
	}
	
	@Override
	public boolean[][] possibleMoves() {
		boolean[][] temp = new boolean[getBoard().getRows()][getBoard().getColumns()];
		
		Position p = new Position(0,0);
		
		//above left
		p.setValues(position.getRow() - 2, position.getColumn()-1);
		if(getBoard().positionExists(p)){
			if(getBoard().piece(p) != null && !isThereOpponentPiece(p)) {
				temp[p.getRow()][p.getColumn()] = false;
			}else {
				temp[p.getRow()][p.getColumn()] = true;
			}
		}
		
		//above right
		p.setValues(position.getRow() - 2, position.getColumn()+1);
		if(getBoard().positionExists(p)){
			if(getBoard().piece(p) != null && !isThereOpponentPiece(p)) {
				temp[p.getRow()][p.getColumn()] = false;
			}else {
				temp[p.getRow()][p.getColumn()] = true;
			}
		}
		
		//left above
		p.setValues(position.getRow() - 1, position.getColumn()-2);
		if(getBoard().positionExists(p)){
			if(getBoard().piece(p) != null && !isThereOpponentPiece(p)) {
				temp[p.getRow()][p.getColumn()] = false;
			}else {
				temp[p.getRow()][p.getColumn()] = true;
			}
		}
		
		//left under
		p.setValues(position.getRow() + 1, position.getColumn()-2);
		if(getBoard().positionExists(p)){
			if(getBoard().piece(p) != null && !isThereOpponentPiece(p)) {
				temp[p.getRow()][p.getColumn()] = false;
			}else {
				temp[p.getRow()][p.getColumn()] = true;
			}
		}
		
		//right above
		p.setValues(position.getRow() - 1, position.getColumn()+2);
		if(getBoard().positionExists(p)){
			if(getBoard().piece(p) != null && !isThereOpponentPiece(p)) {
				temp[p.getRow()][p.getColumn()] = false;
			}else {
				temp[p.getRow()][p.getColumn()] = true;
			}
		}
		
		//right under
		p.setValues(position.getRow() + 1, position.getColumn()+2);
		if(getBoard().positionExists(p)){
			if(getBoard().piece(p) != null && !isThereOpponentPiece(p)) {
				temp[p.getRow()][p.getColumn()] = false;
			}else {
				temp[p.getRow()][p.getColumn()] = true;
			}
		}
		
		//under left
		p.setValues(position.getRow() + 2, position.getColumn()-1);
		if(getBoard().positionExists(p)){
			if(getBoard().piece(p) != null && !isThereOpponentPiece(p)) {
				temp[p.getRow()][p.getColumn()] = false;
			}else {
				temp[p.getRow()][p.getColumn()] = true;
			}
		}
		
		//under left
		p.setValues(position.getRow() + 2, position.getColumn()+1);
		if(getBoard().positionExists(p)){
			if(getBoard().piece(p) != null && !isThereOpponentPiece(p)) {
				temp[p.getRow()][p.getColumn()] = false;
			}else {
				temp[p.getRow()][p.getColumn()] = true;
			}
		}
		
		
		
		
		
		return temp;
	}
	
	

}
