package pieces;

import java.awt.Image;

public class ChessPiece  {
	
	enum ChessPieceType {
		PAWN,
		ROOK,
		KNIGHT,
		BISHOP,
		QUEEN,
		KING;
		}
	
	public ChessPieceType _type;
	
	public Image pieceImage = null;
	private boolean isWhite;
	
	public ChessPiece(Boolean white, ChessPieceType type){
		isWhite = white;
		_type = type;
		//pieceImage = image;
	}
	
	public void destroyPiece(){
		//ToDo
	}
	
	public void setImage(Image img){
		pieceImage = img;
	}

}
