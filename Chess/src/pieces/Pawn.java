package pieces;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

import javax.imageio.ImageIO;

import gamelogic.ChessGame;
import pieces.ChessPiece.Piecetype;
import ui.Square;

public class Pawn extends ChessPiece {
	
	 Collection<Square> possibleMoves;

	public Pawn(ChessGame.Player p, Square sq) {
		super(p, sq);
	}
	
	protected void setType(){
		 piecetype = Piecetype.pawn;
		 possibleMoves = new ArrayList<>();
	}
	
	protected void setImage(){
		 try {
			 if(player == ChessGame.Player.black){
					pieceImage = ImageIO.read(new File("Images/blackpieces/PawnBlack.png"));
			 }else{
					pieceImage = ImageIO.read(new File("Images/whitepieces/PawnWhite.png"));
			 }
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

	 @Override
	    public Collection<Square> getPossibleMoves() {
	        return possibleMoves;
	    }

	 @Override
	    public Collection<Square> generatePossibleMoves() {
	        possibleMoves.clear();
	        boolean color = super.player == ChessGame.Player.white;
	        int dx = color ? -1 : 1;

	        Square ahead = super.getSquare().neighbour(dx, 0);
	        if (ahead.getPiece() == null) {
	            possibleMoves.add(ahead);
	            if (super.getSquare().rowNumber == 6 && color) {
	                Square aheadsecond = super.getSquare().neighbour(dx - 1, 0);
	                if (aheadsecond.getPiece() == null) {
	                    possibleMoves.add(aheadsecond);
	                }
	            } else if (super.getSquare().rowNumber == 1 && !color) {
	                Square aheadsecond = super.getSquare().neighbour(dx + 1, 0);
	                if (aheadsecond.getPiece() == null) {
	                    possibleMoves.add(aheadsecond);
	                }
	            }
	        }
	        Square aheadLeft = super.getSquare().neighbour(dx, -1);
	        if(aheadLeft != null){
	            System.out.println("Left" + aheadLeft.rowNumber + "rom" + aheadLeft.id + "id");
	        }
	        
	     //   if(aheadLeft.getPiece() != null){
	     //       System.out.println("Har brikke");
	       // }else{
	      //  	  System.out.println("Har ikke brikke");
	       // }
	        
	        if (aheadLeft != null && aheadLeft.getPiece() != null && isOpponent(aheadLeft.getPiece())) {
	        	//aheadLeft.setColorAsRed();
	            System.out.println("Left enemy");
	            possibleMoves.add(aheadLeft);
	        }
	        Square aheadRight = super.getSquare().neighbour(dx, 1);
	        if (aheadRight != null && aheadRight.getPiece() != null && isOpponent(aheadRight.getPiece())) {
	        	//aheadLeft.setColorAsRed();
	        	System.out.println("Right enemy");
	            possibleMoves.add(aheadRight);
	        }
	        
	        if(possibleMoves.size() > 0){

	        	   System.out.println(possibleMoves.size());
	        }
	   
	    	
	        return possibleMoves;
	    }
	 
	 
}
