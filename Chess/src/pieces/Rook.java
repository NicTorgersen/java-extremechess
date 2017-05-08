package pieces;

import java.io.File;
import java.util.Collection;
import gamelogic.ChessGame;
import ui.Square;

public class Rook extends ChessPiece {

	public Rook(ChessGame.Player p, Square sq, Boolean isVirtual) {
		super(p, sq, isVirtual);
	}
	@Override
	public Collection<Square> generateMoves() {
		  int rowNumber = super.getSquare().rowNumber;
	      int rowID = super.getSquare().rowID;

	        boolean allPossibleUpMovesFound = false;
	        boolean upMovesBlockedByKing = false;
	        for (int i = rowNumber + 1; i < ChessGame.gameUI.board.BoardSize; i++) {
	         	Square square = super.getSquare().getBoardSquare(i, rowID);
	        	if(allPossibleUpMovesFound){
	        		BlockedMoves.add(square);
	        		if(upMovesBlockedByKing){
	        			BlockedByKingMoves.add(square);
	        		}
	            }
	        	else{
	            	   if (square.getChessPiece() == null) {
	   	                possibleMoves.add(square);
	   	            } else if (isEnemy(square.getChessPiece())) {
	   	            	if(square.getChessPiece().GetPieceType() == piecetype.king){
	   	            		upMovesBlockedByKing = true;
	   	            	}
	   	                possibleMoves.add(square);
	   	                allPossibleUpMovesFound = true;
	   	            }else if (!isEnemy(square.getChessPiece())) {
	   	                allPossibleUpMovesFound = true;
	   	                AttackMoves.add(square);
	   	         	    BlockedMoves.add(square);
	   	            } else {
	   	            	allPossibleUpMovesFound = true;
	   	            }
	            }
	        }
	        //all possible moves in the down
	        boolean allPossibledownMovesFound = false;
	        boolean downMovesBlockedByKing = false;
	        for (int i = rowNumber - 1; i > -1; i--) {
	            Square square = super.getSquare().getBoardSquare(i, rowID);
	            if(allPossibledownMovesFound){
	        		BlockedMoves.add(square);
	        		if(downMovesBlockedByKing){
	        			BlockedByKingMoves.add(square);
	        		}
	            }
	        	else{
	            	   if (square.getChessPiece() == null) {
	   	                possibleMoves.add(square);
	   	            } else if (isEnemy(square.getChessPiece())) {
	   	            	if(square.getChessPiece().GetPieceType() == piecetype.king){
	   	            		downMovesBlockedByKing = true;
	   	            	}
	   	                possibleMoves.add(square);
	   	             allPossibledownMovesFound = true;
	   	            }else if (!isEnemy(square.getChessPiece())) {
	   	            	allPossibledownMovesFound = true;
	   	         	    BlockedMoves.add(square);
	   	         	    AttackMoves.add(square);
	   	            } else {
	   	            	allPossibledownMovesFound = true;
	   	            }
	            }
	        }
	        //all possible moves to the right
	        boolean allPossiblerightMovesFound = false;
	        boolean rightMovesBlockedByKing = false;
	        for (int i = rowID + 1; i < ChessGame.gameUI.board.BoardSize; i++) {
	            Square square = super.getSquare().getBoardSquare(rowNumber, i);
	            if(allPossiblerightMovesFound){
	        		BlockedMoves.add(square);
	        		if(rightMovesBlockedByKing){
	        			BlockedByKingMoves.add(square);
	        		}
	            }
	        	else{
	            	   if (square.getChessPiece() == null) {
	   	                possibleMoves.add(square);
	   	            } else if (isEnemy(square.getChessPiece())) {
	   	                possibleMoves.add(square);
	   	             if(square.getChessPiece().GetPieceType() == piecetype.king){
	   	            	rightMovesBlockedByKing = true;
	   	            	}
	   	             allPossiblerightMovesFound = true;
	   	            }else if (!isEnemy(square.getChessPiece())) {
	   	            	allPossiblerightMovesFound = true;
	   	         	    BlockedMoves.add(square);
	   	         	    AttackMoves.add(square);
	   	            } else {
	   	            	allPossiblerightMovesFound = true;
	   	            }
	            }
	        }
	        //all possible moves to the left
	        boolean allPossibleleftMovesFound = false;
	        boolean leftMovesBlockedByKing = false;
	        for (int i = rowID - 1; i > -1; i--) {
	            Square square = super.getSquare().getBoardSquare(rowNumber, i);
	            if(allPossibleleftMovesFound){
	        		BlockedMoves.add(square);
	        		if(leftMovesBlockedByKing){
	        			BlockedByKingMoves.add(square);
	        		}
	            }
	        	else{
	            	   if (square.getChessPiece() == null) {
	   	                possibleMoves.add(square);
	   	            } else if (isEnemy(square.getChessPiece())) {
	   	                possibleMoves.add(square);
	   	             if(square.getChessPiece().GetPieceType() == piecetype.king){
	   	            	leftMovesBlockedByKing = true;
	   	            	}
	   	             allPossibleleftMovesFound = true;
	   	            }else if (!isEnemy(square.getChessPiece())) {
	   	            	allPossibleleftMovesFound = true;
	   	         	    BlockedMoves.add(square);
	   	         	    AttackMoves.add(square);
	   	            } else {
	   	            	allPossibleleftMovesFound = true;
	   	            }
	            }
	        }
	        AttackMoves.addAll(possibleMoves);
	        return possibleMoves;
	}
	@Override
	public Piecetype GetPieceType() {
		return  piecetype = Piecetype.rook;
	}
	@Override
	public String GetImagePathBlack() {
		return "Bin" + File.separator + "blackpieces"+ File.separator + "RookBlack.png";
	}
	@Override
	public String GetImagePathWhite() {
		return "Bin" + File.separator + "whitepieces"+ File.separator + "RookWhite.png";
	}
}