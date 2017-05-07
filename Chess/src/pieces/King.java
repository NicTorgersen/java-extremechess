package pieces;
import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystem;
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
	
	private ChessPiece CheckPiece;

	public King(ChessGame.Player p, Square sq, Boolean isVirtual) {
		super(p, sq, isVirtual);
		EnemypossibleMoves = new ArrayList<>(); 
	}
	
	public void movePiece(Square sq){
		super.movePiece(sq);
		CheckPiece = null;
	}
	
	public void SetKingInCheck(ChessPiece p){
		CheckPiece = p;
		chessGame.SetKingInCheck(this);
	}
	
	public boolean checkIfKingIsInCheck(){
		
		Square square = getSquare();
		
		if(getEnemyAttackMoves().contains(square)){
	     	  System.out.println("Sjakk" + this.player + square.id + square.rowNumber);
	     	  
			return true;
	  
		}
		
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
		 } 
		 else{
			 for (ChessPiece piece : chessGame.getWhitePieces()) {
				  System.out.println("Henter alle hvite" + this.player);
				  attackMoves.addAll(piece.getAttackMoves());
		        }
		 }
		 
		  System.out.println(attackMoves.size() + "Size");
		 
		    return attackMoves;
	 }
		
	 private List<Square> RemoveImpossibleMoves(List<Square> s){
		 List<Square> newlist = new ArrayList<>();
		 for (Square listsq : s) {
			 newlist.add(listsq);
			 for (Square enemysq : getEnemyAttackMoves()) {
				 if(enemysq.id == listsq.id && enemysq.rowNumber == listsq.rowNumber){
					 newlist.remove(listsq);

				 }
		        }
			 }
		 
		 if(CheckPiece != null){
			 for (Square listsq : s) {
				 for (Square enemysq : CheckPiece.getBlockedByKingMoves()) {
					 if(enemysq.id == listsq.id && enemysq.rowNumber == listsq.rowNumber){
						 newlist.remove(listsq);

					 }
			        }
				 }
		 }
		 
		 return newlist;
	 }
	
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
	            
	            	//if(isOpponent(square.getPiece())){
	            		  moves.add(square);
	            //	} 
	            }else if(square != null && square.getPiece() != null && !isOpponent(square.getPiece())){
	              BlockedMoves.add(square);
	              AttackMoves.add(square);
          		 // moves.add(square);
          	} 	
	        }
	        if(chessGame._PlayersTurn == this.player){
	          possibleMoves.addAll(RemoveImpossibleMoves(moves));
	       	}else{
	       		possibleMoves.addAll(moves);
	       	}
	        AttackMoves = possibleMoves;
	        if(inCheck && possibleMoves.size() <= 0){
	        	
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
