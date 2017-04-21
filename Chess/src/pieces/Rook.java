package pieces;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import gamelogic.ChessGame;
import pieces.ChessPiece.Piecetype;
import ui.Square;

public class Rook extends ChessPiece {

	public Rook(ChessGame.Player p, Square sq) {
		super(p, sq);
	}
	
	protected void setType(){
		 piecetype = Piecetype.rook;
	}
	
	protected void setImage(){
		 try {
			 if(player == ChessGame.Player.black){
					pieceImage = ImageIO.read(new File("Images/blackpieces/RookBlack.png"));
			 }else{
					pieceImage = ImageIO.read(new File("Images/whitepieces/RookWhite.png"));
			 }
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
}
