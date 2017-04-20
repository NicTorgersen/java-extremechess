package gamelogic;
import pieces.ChessPiece;
import ui.Square;

public class Movement {
	
	
	public void move(Square squarefrom, Square squareto) {
		ChessPiece piece = squarefrom.getChessPiece();
		
		if(moveIsLegal(piece)){
			
		}
		squareto.SetNewChessPiece(piece);
		squarefrom.RemoveChessPiece();
    }
	
	private boolean moveIsLegal(ChessPiece piece){
		if(piece != null){
			return true;
		}else{
			return false;
		}
	}
}
