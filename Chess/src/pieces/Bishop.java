package pieces;

import java.io.File;
import java.io.IOException;
import java.util.Collection;

import javax.imageio.ImageIO;

import gamelogic.ChessGame;

import pieces.ChessPiece.Piecetype;
import ui.Square;

public class Bishop extends ChessPiece {

	public Bishop(ChessGame.Player p, Square sq, Boolean isVirtual) {
		super(p, sq, isVirtual);
	}
	

	@Override
	public Collection<Square> generatePossibleMoves() {
		 int row = super.getSquare().rowNumber;
	        int column = super.getSquare().id;
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
	            	   if (square.getPiece() == null) {
	   	                possibleMoves.add(square);
	   	            } else if (isOpponent(square.getPiece())) {
	   	            	if(square.getPiece().GetPieceType() == piecetype.king){
	   	            		downDiagonalMovesBlockedByKing = true;
	   	            	}
	   	                possibleMoves.add(square);
	   	             allPossibleDownDiagonalMovesFound = true;
	   	            }else if (!isOpponent(square.getPiece())) {
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
	            	   if (square.getPiece() == null) {
	   	                possibleMoves.add(square);
	   	            } else if (isOpponent(square.getPiece())) {
	   	            	if(square.getPiece().GetPieceType() == piecetype.king){
	   	            		upDiagonalMovesBlockedByKing = true;
	   	            	}
	   	                possibleMoves.add(square);
	   	             allPossibleUpDiagonalMovesFound = true;
	   	            }else if (!isOpponent(square.getPiece())) {
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
	            	   if (square.getPiece() == null) {
	   	                possibleMoves.add(square);
	   	            } else if (isOpponent(square.getPiece())) {
	   	            	if(square.getPiece().GetPieceType() == piecetype.king){
	   	            		upNegativeDiagonalMovesBlockedByKing = true;
	   	            	}
	   	                possibleMoves.add(square);
	   	             allPossibleUpNegativeDiagonalMovesFound = true;
	   	            }else if (!isOpponent(square.getPiece())) {
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
	            	   if (square.getPiece() == null) {
	   	                possibleMoves.add(square);
	   	            } else if (isOpponent(square.getPiece())) {
	   	            	if(square.getPiece().GetPieceType() == piecetype.king){
	   	            		downNegativeDiagonalMovesBlockedByKing = true;
	   	            	}
	   	                possibleMoves.add(square);
	   	             allPossibleDownNegativeDiagonalMovesFound = true;
	   	            }else if (!isOpponent(square.getPiece())) {
	   	            	allPossibleDownNegativeDiagonalMovesFound = true;
	   	         	    BlockedMoves.add(square);
	   	         	    AttackMoves.add(square); 
	   	            } else {
	   	            	allPossibleDownNegativeDiagonalMovesFound = true;
	   	            }
	            }
	        }
	        AttackMoves = possibleMoves;
	        return possibleMoves;
	}

	@Override
	public Piecetype GetPieceType() {
		// TODO Auto-generated method stub
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
