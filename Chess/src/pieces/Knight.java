package pieces;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import gamelogic.ChessGame;
import pieces.ChessPiece.Piecetype;
import ui.Square;

public class Knight extends ChessPiece {

	public Knight(ChessGame.Player p, Square sq) {
		super(p, sq);
	}
	
	protected void setType(){
		 piecetype = Piecetype.knight;
	}
	
	protected void setImage(){
		 try {
			 if(player == ChessGame.Player.black){
					pieceImage = ImageIO.read(new File("Images/blackpieces/KnightBlack.png"));
			 }else{
					pieceImage = ImageIO.read(new File("Images/whitepieces/KnightWhite.png"));
			 }
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
}
