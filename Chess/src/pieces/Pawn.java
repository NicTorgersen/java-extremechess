package pieces;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

import javax.imageio.ImageIO;

import gamelogic.ChessGame;
import pieces.ChessPiece.Piecetype;
import ui.Square;

public class Pawn extends ChessPiece {
	

	public Pawn(ChessGame.Player p, Square sq, Boolean isVirtual) {
		super(p, sq, isVirtual);
	}
	
	 @Override
	    public Collection<Square> generatePossibleMoves() {
	        possibleMoves.clear();
	        AttackMoves.clear();
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
	        	AttackMoves.add(aheadLeft);
	        	 if (aheadLeft.getPiece() != null && isOpponent(aheadLeft.getPiece())) {
	 	            System.out.println("Left enemy");
	 	            possibleMoves.add(aheadLeft);
	 	        }
	        }
	        
	        
	       
	        Square aheadRight = super.getSquare().neighbour(dx, 1);
	        if(aheadRight != null){
	         	AttackMoves.add(aheadRight);
	         	  if (aheadRight.getPiece() != null && isOpponent(aheadRight.getPiece())) {
	  	        	System.out.println("Right enemy");
	  	         	AttackMoves.add(aheadRight);
	  	            possibleMoves.add(aheadRight);
	  	        }
	  	        
	        }
	        
	      
	        if(possibleMoves.size() > 0){

	        	   System.out.println(possibleMoves.size());
	        }
	        return possibleMoves;
	    }

	@Override
	public Piecetype GetPieceType() {
		return  piecetype = Piecetype.pawn;
	}

	@Override
	public String GetImagePathBlack() {
		return "Images/blackpieces/PawnBlack.png";
	}

	@Override
	public String GetImagePathWhite() {
		return "Images/whitepieces/PawnWhite.png";
	}  
}
