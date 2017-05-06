package pieces;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.imageio.ImageIO;
import gamelogic.ChessGame;
import pieces.ChessPiece.Piecetype;
import ui.Square;


public class King extends ChessPiece {
	
	protected Collection<Square> EnemypossibleMoves;
	boolean inCheck;

	public King(ChessGame.Player p, Square sq, Boolean isVirtual) {
		super(p, sq, isVirtual);
		EnemypossibleMoves = new ArrayList<>(); 
	}
	
	public boolean checkIfKingIsInCheck(){
		
		Square square = super.getSquare();
		
		if(getEnemyAttackMoves().contains(square)){
	     	  System.out.println("Sjakk" + this.player);
	     	  
			return true;
	  
		}
		
		//for (Square possibleEnemyMove : getEnemypossibleMoves()) {
			
	    // }
		  System.out.println("Ikkje sjakk" + this.player);
		return false;
	}
	
	 private Collection<Square> getEnemyAttackMoves() {

		 Collection<Square> attackMoves = new ArrayList<>();
		 if(this.player == ChessGame.Player.white){
			 for (ChessPiece piece : chessGame.getBlackPieces()) {
				  System.out.println("Henter alle svarte" + this.player);
				  attackMoves.addAll(piece.getAttackMoves());
		        }
		 } else{
			 for (ChessPiece piece : chessGame.getWhitePieces()) {
				  System.out.println("Henter alle hvite" + this.player);
				  attackMoves.addAll(piece.getAttackMoves());
		        }
		 }
		 
		  System.out.println(attackMoves.size() + "Size");
		 
		    return attackMoves;
	 }
	
	// private Collection<Square> getEnemypossibleMoves() {
		// EnemypossibleMoves.clear();
		// if(this.player == ChessGame.Player.white){
		//	 for (ChessPiece piece : chessGame.getBlackPieces()) {
		//		  System.out.println("Henter alle svarte" + this.player);
		//		 EnemypossibleMoves.addAll(piece.getPossibleMoves());
		//        }
		// } else{
		//	 for (ChessPiece piece : chessGame.getWhitePieces()) {
		//		  System.out.println("Henter alle hvite" + this.player);
		//		 EnemypossibleMoves.addAll(piece.getPossibleMoves());
				
		//        }
		// }
		 
		// EnemypossibleMoves.addAll(getEnemyAttackMoves());
		 
	//	    return EnemypossibleMoves;
	// }
		

	
	 @Override
	    public Collection<Square> generatePossibleMoves() {
		   possibleMoves.clear();
		   AttackMoves.clear();
	        List<Square> moves = new ArrayList<>();
	        int[][] offsets = {
	            {1, 0},
	            {0, 1},
	            {-1, 0},
	            {0, -1},
	            {1, 1},
	            {-1, 1},
	            {-1, -1},
	            {1, -1}
	        };
	        for (int[] o : offsets) {
	            Square square = super.getSquare().neighbour(o[0], o[1]);
	            if (square != null && (square.getPiece() == null || isOpponent(square.getPiece()))) {
	            	if(chessGame._PlayersTurn == this.player){
	            	//	if(!getEnemyAttackMoves().contains(square)){
		            	     moves.add(square);
		            	//}
	            	}
	            }
	        }
	        possibleMoves.addAll(moves);
	        AttackMoves = possibleMoves;
	        return possibleMoves;
	    }



	@Override
	public Piecetype GetPieceType() {
		return  piecetype = Piecetype.king;
	}

	@Override
	public String GetImagePathBlack() {
		return "Images/blackpieces/KingBlack.png";
	}

	@Override
	public String GetImagePathWhite() {
		return "Images/whitepieces/KingWhite.png";
	}

}
