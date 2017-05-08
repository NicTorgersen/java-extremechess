package pieces;

import java.io.File;
import java.util.Collection;
import gamelogic.ChessGame;
import ui.Square;

public class Pawn extends ChessPiece {
	
	public Pawn(ChessGame.Player p, Square sq, Boolean isVirtual) {
		super(p, sq, isVirtual);
	}
	 @Override
	    public Collection<Square> generateMoves() {
	        possibleMoves.clear();
	        AttackMoves.clear();
	        boolean color = super.player == ChessGame.Player.white;
	        int dx = color ? -1 : 1;
	        Square ahead = super.getSquare().neighbour(dx, 0);
	        if (ahead.getChessPiece() == null) {
	            possibleMoves.add(ahead);
	            if (super.getSquare().rowNumber == 6 && color) {
	                Square aheadsecond = super.getSquare().neighbour(dx - 1, 0);
	                if (aheadsecond.getChessPiece() == null) {
	                    possibleMoves.add(aheadsecond);
	                }
	            } else if (super.getSquare().rowNumber == 1 && !color) {
	                Square aheadsecond = super.getSquare().neighbour(dx + 1, 0);
	                if (aheadsecond.getChessPiece() == null) {
	                    possibleMoves.add(aheadsecond);
	                }
	            }
	        }
	        Square aheadLeft = super.getSquare().neighbour(dx, -1);
	        if(aheadLeft != null){
	        	AttackMoves.add(aheadLeft);
	        	 if (aheadLeft.getChessPiece() != null && isEnemy(aheadLeft.getChessPiece())) {
	 	            System.out.println("Left enemy");
	 	            possibleMoves.add(aheadLeft);
	 	        }
	        }
	        Square aheadRight = super.getSquare().neighbour(dx, 1);
	        if(aheadRight != null){
	         	AttackMoves.add(aheadRight);
	         	  if (aheadRight.getChessPiece() != null && isEnemy(aheadRight.getChessPiece())) {
	  	        	System.out.println("Right enemy");
	  	            possibleMoves.add(aheadRight);
	  	        }
	        }
	        return possibleMoves;
	    }
	@Override
	public Piecetype GetPieceType() {
		return  piecetype = Piecetype.pawn;
	}
	@Override
	public String GetImagePathBlack() {
		return "Bin" + File.separator + "blackpieces"+ File.separator + "PawnBlack.png";
	}
	@Override
	public String GetImagePathWhite() {
		return "Bin" + File.separator + "whitepieces"+ File.separator + "PawnWhite.png";
	}  
}
