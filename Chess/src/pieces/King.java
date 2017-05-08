package pieces;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import gamelogic.ChessGame;
import ui.Square;

public class King extends ChessPiece {
	//Stores all AttackMoves that the enemy can do next round
	protected Collection<Square> EnemypossibleMoves;
	//The ChessPiece that has the king in Check
	private ChessPiece CheckPiece;
	
	public King(ChessGame.Player p, Square sq, Boolean isVirtual) {
		super(p, sq, isVirtual);
		EnemypossibleMoves = new ArrayList<>(); 
		ImpossibleMoves = new ArrayList<>(); 
	}
	//Moves the King, and sets CheckPiece to null if there is one
	public void movePiece(Square sq){
		super.movePiece(sq);
		if(CheckPiece != null){
			CheckPiece = null;
		}
	}
	//Given ChessPiece sets this king in check, and tells the chessGame that it is held in check.
	public void SetKingInCheck(ChessPiece p){
		CheckPiece = p;
		chessGame.SetKingInCheck(this);
	}
	// Returns all possible enemyAttackMoves (Which have been generated at the start of this turn).
	 private Collection<Square> getEnemyAttackMoves() {
		 Collection<Square> attackMoves = new ArrayList<>();
		 if(this.player == ChessGame.Player.white){
			 for (ChessPiece piece : chessGame.getBlackPieces()) {
				  System.out.println("Henter alle svarte" + this.player);
				  attackMoves.addAll(piece.getAttackMoves());
		        }
		 } 
		 else{
			 for (ChessPiece piece : chessGame.getWhitePieces()) {
				  System.out.println("Henter alle hvite" + this.player);
				  attackMoves.addAll(piece.getAttackMoves());
		        }
		 }
		 return attackMoves;
	 }
	 //Removes all impossible moves from given list of squares	
	 private List<Square> RemoveImpossibleMoves(List<Square> s){
		 List<Square> newlist = new ArrayList<>();
		 for (Square listsq : s) {
			 newlist.add(listsq);
			 for (Square enemysq : getEnemyAttackMoves()) {
				 if(enemysq.rowID == listsq.rowID && enemysq.rowNumber == listsq.rowNumber){
					 newlist.remove(listsq);
					 ImpossibleMoves.add(listsq);
				 }
		        }
			 }
		 //If checkPiece is not null, we remove the path that this king is blocking, from possible moves. (Mainly the path of Bishop, Rook and Queen)
		 if(CheckPiece != null){
			 for (Square listsq : s) {
				 for (Square enemysq : CheckPiece.getBlockedByKingMoves()) {
					 if(enemysq.rowID == listsq.rowID && enemysq.rowNumber == listsq.rowNumber){
						 newlist.remove(listsq);
					 }
			        }
				 }
		 }
		 return newlist;
	 }
	
	    @Override
	    public Collection<Square> generateMoves() {
		   possibleMoves.clear();
		   AttackMoves.clear();
	        List<Square> moves = new ArrayList<>();
	        int[][] possibleSquareints = {
	            {1, 0},
	            {0, 1},
	            {-1, 0},
	            {0, -1},
	            {1, 1},
	            {-1, 1},
	            {-1, -1},
	            {1, -1}
	        };
	        for (int[] o : possibleSquareints) {
	            Square square = super.getSquare().neighbour(o[0], o[1]);
	            if (square != null && (square.getChessPiece() == null || isEnemy(square.getChessPiece()))) {
	            		  moves.add(square);

	            }else if(square != null && square.getChessPiece() != null && !isEnemy(square.getChessPiece())){
	              BlockedMoves.add(square);
	              if(chessGame._PlayersTurn != this.player){
	            	    AttackMoves.add(square);
	    	       	}
          	} 	
	        }
	        if(chessGame._PlayersTurn == this.player){
	          possibleMoves.addAll(RemoveImpossibleMoves(moves));
	          AttackMoves.addAll(RemoveImpossibleMoves(moves));
	       	}else{
	       		possibleMoves.addAll(moves);
	       		AttackMoves.addAll(moves);
	       	}
	        //If the king can't move anywhere, we tell the chessGame to set this king in CheckMate
	        if(chessGame.kingIsInCheck() && possibleMoves.size() <= 0){
	        	chessGame.SetKingInCheckMate(this);
	        }
	        return possibleMoves;
	    }
	 
	@Override
	public Piecetype GetPieceType() {
		return  piecetype = Piecetype.king;
	}
	@Override
	public String GetImagePathBlack() {
		return "Bin" + File.separator + "blackpieces"+ File.separator + "KingBlack.png";
	}
	@Override
	public String GetImagePathWhite() {
		return "Bin" + File.separator + "whitepieces"+ File.separator + "KingWhite.png";
	}
}
