package gamelogic;

import java.util.List;

import pieces.ChessPiece;

public class Player {
	
	private List<ChessPiece> pieces;
	
	public List<ChessPiece> getPieces(){
		return pieces;
	}
	
	public void addPiece(ChessPiece piece){
		pieces.add(piece);
	}

	public void removePiece(ChessPiece piece) {
		if(pieces.contains(piece)){
			pieces.remove(piece);
		}
	}
}
