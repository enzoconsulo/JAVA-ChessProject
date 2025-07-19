package Chess.Pieces;

import Board.Board;
import Board.Position;
import Chess.ChessMatch;
import Chess.ChessPiece;
import Chess.Color;

public class King extends ChessPiece{

	private ChessMatch cm;
	
	public King(Board board, Color color,ChessMatch cm) {
		super(board, color);
		this.cm = cm; 
	}

	@Override
	public String toString() {
		return "K";
	}
	
	private boolean rookToCastling(Position rookPosition) {
		ChessPiece possibleRook = (ChessPiece) cm.getBoard().piece(rookPosition);
		if(possibleRook instanceof Rook && possibleRook.getMoveCount() == 0 && !isThereOpponentPiece(rookPosition)) {
			return true;
		}
		return false;
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
		
		//special Move
		//minor castling 
		p.setValues(position.getRow(), position.getColumn()+2); 
		if(getBoard().positionExists(p)) {
			Position rookPosition = new Position(position.getRow(), position.getColumn() + 3);
			Position p1 = new Position(position.getRow(),position.getColumn()+1);
			Position p2 = new Position(position.getRow(),position.getColumn()+2);
			
			
			if(	rookToCastling(rookPosition) // if rook can castle
				&& getMoveCount()==0 // if king hasn't moves before
				&& !getBoard().thereIsAPiece(p1) && !getBoard().thereIsAPiece(p2) ) { //if hasn't pieces beside rook and king
					
				temp[p.getRow()][p.getColumn()] = true;
			}else {
				temp[p.getRow()][p.getColumn()] = false;
			}
		}
		
		p.setValues(position.getRow(), position.getColumn() - 2);
		if (getBoard().positionExists(p)) {
		    Position rookPosition = new Position(
		        position.getRow(),
		        position.getColumn() - 4
		    );
		    if (getBoard().positionExists(rookPosition)) {
		        Position p1 = new Position(position.getRow(), position.getColumn() - 1);
		        Position p2 = new Position(position.getRow(), position.getColumn() - 2);
		        Position p3 = new Position(position.getRow(), position.getColumn() - 3);

		        if (
		            rookToCastling(rookPosition) &&
		            getMoveCount() == 0 &&
		            !getBoard().thereIsAPiece(p1) &&
		            !getBoard().thereIsAPiece(p2) &&
		            !getBoard().thereIsAPiece(p3)
		        ) {
		            temp[p.getRow()][p.getColumn()] = true;
		        } else {
		            temp[p.getRow()][p.getColumn()] = false;
		        }
		    }
		}
		
		return temp;
	}
	
}
