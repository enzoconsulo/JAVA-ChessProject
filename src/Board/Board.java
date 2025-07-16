package Board;

public class Board {

	private Integer rows;
	private Integer columns;
	
	private Piece[][] pieces;
	
	public Board(Integer rows,Integer columns) {
		if (rows<1 || columns < 1) throw new BoardException("ERROR! Rows and Columns must be bigger than 1");
		this.rows = rows;
		this.columns = columns;
		pieces = new Piece[rows][columns];
	}
	

	public Integer getRows() {
		return rows;
	}


	public Integer getColumns() {
		return columns;
	}


	public Piece[][] getPieces() {
		return pieces;
	}

	private String convertFormatPosition(Position position) {
		char character = ((char) ('a' + position.getColumn()));
		int integer = (8-position.getRow());
		return "'" + character + integer + "'";
	}

	public Piece piece(int row , int column) {
		if(!positionExists(new Position(row,column)))throw new BoardException("ERROR! The position"+ convertFormatPosition(new Position(row,column)) +" is Invalid");
		return pieces[row][column];
	}
	
	public Piece piece(Position position) {
		if(!positionExists(position))throw new BoardException("ERROR! The position "+ convertFormatPosition(position) +" is Invalid");
		return pieces[position.getRow()][position.getColumn()];
	}
	
	public void placePiece(Piece piece, Position position) {
		if(thereIsAPiece(position))throw new BoardException("ERROR! The position "+convertFormatPosition(position) +" already have a piece");
		piece.position = position;
		pieces[position.getRow()][position.getColumn()] = piece;
	}
	
	public Piece removePiece(Position position) {
		if(!positionExists(position))throw new BoardException("ERROR! The position "+ convertFormatPosition(position) +" is Invalid");
		if(piece(position)==null)return null;
		Piece temp = piece(position);
		temp.position = null;
		pieces[position.getRow()][position.getColumn()] = null;
		return temp;
	}
	
	public boolean positionExists(Position position) {
		if(0 <= position.getRow() 
			&& position.getRow() <= 7 
			&& 0 <= position.getColumn() 
			&& position.getColumn() <= 7)
			return true;
		
		return false;
	}
	
	public boolean thereIsAPiece(Position position) {
		if(!positionExists(position))throw new BoardException("ERROR! The position "+ convertFormatPosition(position) +" is Invalid");
		if(piece(position)!=null)return true;
		return false;
	}
	
	
}
