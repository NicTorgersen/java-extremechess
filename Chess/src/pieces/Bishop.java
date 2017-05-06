package pieces;

import java.io.File;
import java.io.IOException;
import java.util.Collection;

import javax.imageio.ImageIO;

import gamelogic.ChessGame;
import pieces.ChessPiece.Piecetype;
import ui.Square;

public class Bishop extends ChessPiece {

	public Bishop(ChessGame.Player p, Square sq) {
		super(p, sq);
	}
	
	protected void setType(){
		 piecetype = Piecetype.bishop;
	}
	
	protected void setImage(){
		 try {
			 if(player == ChessGame.Player.black){
					pieceImage = ImageIO.read(new File("Images/blackpieces/BishopBlack.png")); 
			 } else{
					pieceImage = ImageIO.read(new File("Images/whitepieces/BishopWhite.png")); 
			 }
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

	@Override
	public Collection<Square> getPossibleMoves() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<Square> generatePossibleMoves() {
		// TODO Auto-generated method stub
		return null;
	}
}
