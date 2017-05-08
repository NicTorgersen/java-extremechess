package pieces;

import java.io.File;
import java.util.Collection;
import gamelogic.ChessGame;
import ui.Square;

public class Bishop extends ChessPiece {

	public Bishop(ChessGame.Player p, Square sq, Boolean isVirtual) {
		super(p, sq, isVirtual);
	}
	//Generates the Bishops moves
	@Override
	public Collection<Square> generateMoves() {
		 int row = super.getSquare().rowNumber;
	        int column = super.getSquare().rowID;
	        possibleMoves.clear();
	        AttackMoves.clear();
	        //all possible moves in the down positive diagonal
	        boolean allPossibleDownDiagonalMovesFound = false;
	        boolean downDiagonalMovesBlockedByKing = false;
	        for (int j = column + 1, i = row + 1; j < ChessGame.gameUI.board.BoardSize && i < ChessGame.gameUI.board.BoardSize; j++, i++) {
	            Square square = super.getSquare().getBoardSquare(i, j);
	        	if(allPossibleDownDiagonalMovesFound){
	        		BlockedMoves.add(square);
	        		if(downDiagonalMovesBlockedByKing){
	        			BlockedByKingMoves.add(square);
	        		}
	            }
	        	else{
	            	   if (square.getChessPiece() == null) {
	   	                possibleMoves.add(square);
	   	            } else if (isEnemy(square.getChessPiece())) {
	   	            	if(square.getChessPiece().GetPieceType() == piecetype.king){
	   	            		downDiagonalMovesBlockedByKing = true;
	   	            	}
	   	                possibleMoves.add(square);
	   	             allPossibleDownDiagonalMovesFound = true;
	   	            }else if (!isEnemy(square.getChessPiece())) {
	   	            	allPossibleDownDiagonalMovesFound = true;
	   	         	    BlockedMoves.add(square);
	   	         	    AttackMoves.add(square);
	   	            } else {
	   	            	allPossibleDownDiagonalMovesFound = true;
	   	            }
	            }
	        }
	        //all possible moves in the up positive diagonal
	        boolean allPossibleUpDiagonalMovesFound = false;
	        boolean upDiagonalMovesBlockedByKing = false;
	        for (int j = column - 1, i = row + 1; j > -1 && i < ChessGame.gameUI.board.BoardSize; j--, i++) {
	            Square square = super.getSquare().getBoardSquare(i, j);
	          	if(allPossibleUpDiagonalMovesFound){
	        		BlockedMoves.add(square);
	        		if(upDiagonalMovesBlockedByKing){
	        			BlockedByKingMoves.add(square);
	        		}
	            }
	        	else{
	            	   if (square.getChessPiece() == null) {
	   	                possibleMoves.add(square);
	   	            } else if (isEnemy(square.getChessPiece())) {
	   	            	if(square.getChessPiece().GetPieceType() == piecetype.king){
	   	            		upDiagonalMovesBlockedByKing = true;
	   	            	}
	   	                possibleMoves.add(square);
	   	             allPossibleUpDiagonalMovesFound = true;
	   	            }else if (!isEnemy(square.getChessPiece())) {
	   	            	allPossibleUpDiagonalMovesFound = true;
	   	         	    BlockedMoves.add(square);
	   	         	    AttackMoves.add(square);
	   	            } else {
	   	            	allPossibleUpDiagonalMovesFound = true;
	   	            }
	            }
	        }
	        //all possible moves in the up negative diagonal
	        boolean allPossibleUpNegativeDiagonalMovesFound = false;
	        boolean upNegativeDiagonalMovesBlockedByKing = false;
	        for (int j = column - 1, i = row - 1; j > -1 && i > -1; j--, i--) {
	            Square square = super.getSquare().getBoardSquare(i, j);
	        	if(allPossibleUpNegativeDiagonalMovesFound){
	        		BlockedMoves.add(square);
	        		if(upNegativeDiagonalMovesBlockedByKing){
	        			BlockedByKingMoves.add(square);
	        		}
	            }
	        	else{
	            	   if (square.getChessPiece() == null) {
	   	                possibleMoves.add(square);
	   	            } else if (isEnemy(square.getChessPiece())) {
	   	            	if(square.getChessPiece().GetPieceType() == piecetype.king){
	   	            		upNegativeDiagonalMovesBlockedByKing = true;
	   	            	}
	   	                possibleMoves.add(square);
	   	             allPossibleUpNegativeDiagonalMovesFound = true;
	   	            }else if (!isEnemy(square.getChessPiece())) {
	   	            	allPossibleUpNegativeDiagonalMovesFound = true;
	   	         	    BlockedMoves.add(square);
	   	         	    AttackMoves.add(square);
	   	            } else {
	   	            	allPossibleUpNegativeDiagonalMovesFound = true;
	   	            }
	            }
	        }
	        //all possible moves in the down negative diagonal
	        boolean allPossibleDownNegativeDiagonalMovesFound = false;
	        boolean downNegativeDiagonalMovesBlockedByKing = false;
	        for (int j = column + 1, i = row - 1; j < ChessGame.gameUI.board.BoardSize && i > -1; j++, i--) {
	            Square square = super.getSquare().getBoardSquare(i, j);
	            if(allPossibleDownNegativeDiagonalMovesFound){
	        		BlockedMoves.add(square);
	        		if(downNegativeDiagonalMovesBlockedByKing){
	        			BlockedByKingMoves.add(square);
	        		}
	            }
	        	else{
	            	   if (square.getChessPiece() == null) {
	   	                possibleMoves.add(square);
	   	            } else if (isEnemy(square.getChessPiece())) {
	   	            	if(square.getChessPiece().GetPieceType() == piecetype.king){
	   	            		downNegativeDiagonalMovesBlockedByKing = true;
	   	            	}
	   	                possibleMoves.add(square);
	   	             allPossibleDownNegativeDiagonalMovesFound = true;
	   	            }else if (!isEnemy(square.getChessPiece())) {
	   	            	allPossibleDownNegativeDiagonalMovesFound = true;
	   	         	    BlockedMoves.add(square);
	   	         	    AttackMoves.add(square); 
	   	            } else {
	   	            	allPossibleDownNegativeDiagonalMovesFound = true;
	   	            }
	            }
	        }
	        AttackMoves.addAll(possibleMoves);
	        return possibleMoves;
	}

	@Override
	public Piecetype GetPieceType() {
		return  piecetype = Piecetype.bishop;
	}
	@Override
	public String GetImagePathBlack() {
		return "Bin" + File.separator + "blackpieces"+ File.separator + "BishopBlack.png";
	}
	@Override
	public String GetImagePathWhite() {
		return "Bin" + File.separator + "whitepieces"+ File.separator + "BishopWhite.png";

	}
}
