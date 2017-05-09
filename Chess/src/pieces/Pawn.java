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
	        int moveValue = 0;
	        if(player == ChessGame.Player.white){
	        	moveValue = -1;
	        }else{
	        	moveValue = 1;
	        }
	        Square path = getSquare().neighbour(moveValue, 0);
	        if (path.getChessPiece() == null) {
	            possibleMoves.add(path);
	            if (getSquare().rowNumber == 6 && chessGame._PlayersTurn == ChessGame.Player.white) {
	                Square aheadsecond = getSquare().neighbour(moveValue - 1, 0);
	                if (aheadsecond.getChessPiece() == null) {
	                    possibleMoves.add(aheadsecond);
	                }
	            } else if (getSquare().rowNumber == 1 && chessGame._PlayersTurn == ChessGame.Player.black) {
	                Square aheadsecond = getSquare().neighbour(moveValue + 1, 0);
	                if (aheadsecond.getChessPiece() == null) {
	                    possibleMoves.add(aheadsecond);
	                }
	            }
	        }
	        Square pathLeft = getSquare().neighbour(moveValue, -1);
	        if(pathLeft != null){
	        	AttackMoves.add(pathLeft);
	        	 if (pathLeft.getChessPiece() != null && isEnemy(pathLeft.getChessPiece())) {
	 	            possibleMoves.add(pathLeft);
	 	        }
	        }
	        Square pathRight = getSquare().neighbour(moveValue, 1);
	        if(pathRight != null){
	         	AttackMoves.add(pathRight);
	         	  if (pathRight.getChessPiece() != null && isEnemy(pathRight.getChessPiece())) {
	  	            possibleMoves.add(pathRight);
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
