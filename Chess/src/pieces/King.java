package pieces;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import gamelogic.ChessGame;
import ui.Square;


public class King extends ChessPiece {

	public King(ChessGame.Player p, Square sq) {
		super(p, sq);
	}
	
	protected void setType(){
		 piecetype = Piecetype.king;
	}
	
	protected void setImage(){
		 try { 
			 if(player == ChessGame.Player.black){
					pieceImage = ImageIO.read(new File("Images/blackpieces/KingBlack.png"));
			 }else{
					pieceImage = ImageIO.read(new File("Images/whitepieces/KingWhite.png"));
			 }

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
}
