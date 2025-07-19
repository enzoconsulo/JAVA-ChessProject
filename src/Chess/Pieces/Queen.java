package Chess.Pieces;

import Board.Board;
import Board.Position;
import Chess.ChessPiece;
import Chess.Color;

public class Queen extends ChessPiece{

	public Queen(Board board, Color color) {
		super(board, color);
	}

	@Override
	public String toString() {
		return "Q";
	}
	
	@Override
	public boolean[][] possibleMoves() { //here was just sum Rook possibleMoves with Bishop possibleMoves(copy/paste them codes).
		boolean[][] temp = new boolean[getBoard().getRows()][getBoard().getColumns()];
		
		Position p = new Position(0,0);
		//                                             Rook PossibleMoves code:
		//above
		p.setValues(position.getRow() - 1, position.getColumn());
		while(getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) { //while exists the position and havent a piece.
			temp[p.getRow()][p.getColumn()] = true;
			p.setRow(p.getRow() - 1);
		}
		if(getBoard().positionExists(p) && isThereOpponentPiece(p)) { //when while stopped and is a valid position and is a opponent piece
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
		
		//                                             Bishop PossibleMoves code:
		//above left
		p.setValues(position.getRow() - 1, position.getColumn()-1);
		while(getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) { //while exists the position and havent a piece.
			temp[p.getRow()][p.getColumn()] = true;
			p.setRow(p.getRow() - 1);
			p.setColumn(p.getColumn()-1);
		}
		if(getBoard().positionExists(p) && isThereOpponentPiece(p)) { //when while stopped and is a valid position and is a opponent piece
			temp[p.getRow()][p.getColumn()] = true;
		}
		
		//above right
		
		p.setValues(position.getRow() - 1, position.getColumn()+1);
		while(getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) { //while exists the position and havent a piece.
			temp[p.getRow()][p.getColumn()] = true;
			p.setRow(p.getRow() - 1);
			p.setColumn(p.getColumn()+1);
		}
		if(getBoard().positionExists(p) && isThereOpponentPiece(p)) { //when while stopped and is a valid position and is a opponent piece
			temp[p.getRow()][p.getColumn()] = true;
		}
		
		//under left
		p.setValues(position.getRow() + 1, position.getColumn()-1);
		while(getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) { 
			temp[p.getRow()][p.getColumn()] = true;
			p.setRow(p.getRow() + 1);
			p.setColumn(p.getColumn()-1);
		}
		if(getBoard().positionExists(p) && isThereOpponentPiece(p)) { 
			temp[p.getRow()][p.getColumn()] = true;
		}
		
		//under right
		p.setValues(position.getRow() + 1, position.getColumn()+1);
		while(getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) { 
			temp[p.getRow()][p.getColumn()] = true;
			p.setRow(p.getRow() + 1);
			p.setColumn(p.getColumn()+1);
		}
		if(getBoard().positionExists(p) && isThereOpponentPiece(p)) { 
			temp[p.getRow()][p.getColumn()] = true;
		}
		
		
		return temp;
	}

	
	
}
