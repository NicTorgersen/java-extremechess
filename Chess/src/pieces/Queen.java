package pieces;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import gamelogic.ChessGame;
import pieces.ChessPiece.Piecetype;
import ui.Square;

public class Queen extends ChessPiece {

	public Queen(ChessGame.Player p, Square sq) {
		super(p, sq);
	}
	
	protected void setType(){
		 piecetype = Piecetype.queen;
	}
	
	protected void setImage(){
		 try {
			 if(player == ChessGame.Player.black){
					pieceImage = ImageIO.read(new File("Images/blackpieces/QueenBlack.png"));
			 }else{
					pieceImage = ImageIO.read(new File("Images/whitepieces/QueenWhite.png"));
			 }
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
}
