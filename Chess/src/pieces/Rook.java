package pieces;

import java.io.File;
import java.io.IOException;
import java.util.Collection;

import javax.imageio.ImageIO;

import gamelogic.ChessGame;
import pieces.ChessPiece.Piecetype;
import ui.Square;

public class Rook extends ChessPiece {

	public Rook(ChessGame.Player p, Square sq, Boolean isVirtual) {
		super(p, sq, isVirtual);
	}
	
	

	

	@Override
	public Collection<Square> generatePossibleMoves() {
		  int row = super.getSquare().rowNumber;
	        int column = super.getSquare().id;
	       // possibleMoves.clear();
	       // AttackMoves.clear();
	       // BlockedMoves.clear();
	        //all possible moves in the up
	        boolean allPossibleUpMovesFound = false;
	        boolean upMovesBlockedByKing = false;
	        for (int i = row + 1; i < ChessGame.gameUI.board.BoardSize; i++) {
	         	Square square = super.getSquare().getBoardSquare(i, column);
	        	if(allPossibleUpMovesFound){
	        		BlockedMoves.add(square);
	        		if(upMovesBlockedByKing){
	        			BlockedByKingMoves.add(square);
	        		}
	            }
	        	else{
	            	   if (square.getPiece() == null) {
	   	                possibleMoves.add(square);
	   	            } else if (isOpponent(square.getPiece())) {
	   	            	if(square.getPiece().GetPieceType() == piecetype.king){
	   	            		upMovesBlockedByKing = true;
	   	            	}
	   	                possibleMoves.add(square);
	   	                allPossibleUpMovesFound = true;
	   	            }else if (!isOpponent(square.getPiece())) {
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
	        for (int i = row - 1; i > -1; i--) {
	            Square square = super.getSquare().getBoardSquare(i, column);
	            if(allPossibledownMovesFound){
	        		BlockedMoves.add(square);
	        		if(downMovesBlockedByKing){
	        			BlockedByKingMoves.add(square);
	        		}
	            }
	        	else{
	            	   if (square.getPiece() == null) {
	   	                possibleMoves.add(square);
	   	            } else if (isOpponent(square.getPiece())) {
	   	            	if(square.getPiece().GetPieceType() == piecetype.king){
	   	            		downMovesBlockedByKing = true;
	   	            	}
	   	                possibleMoves.add(square);
	   	             allPossibledownMovesFound = true;
	   	            }else if (!isOpponent(square.getPiece())) {
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
	        for (int i = column + 1; i < ChessGame.gameUI.board.BoardSize; i++) {
	            Square square = super.getSquare().getBoardSquare(row, i);
	            if(allPossiblerightMovesFound){
	        		BlockedMoves.add(square);
	        		if(rightMovesBlockedByKing){
	        			BlockedByKingMoves.add(square);
	        		}
	            }
	        	else{
	            	   if (square.getPiece() == null) {
	   	                possibleMoves.add(square);
	   	            } else if (isOpponent(square.getPiece())) {
	   	                possibleMoves.add(square);
	   	             if(square.getPiece().GetPieceType() == piecetype.king){
	   	            	rightMovesBlockedByKing = true;
	   	            	}
	   	             allPossiblerightMovesFound = true;
	   	            }else if (!isOpponent(square.getPiece())) {
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
	        for (int i = column - 1; i > -1; i--) {
	            Square square = super.getSquare().getBoardSquare(row, i);
	            if(allPossibleleftMovesFound){
	        		BlockedMoves.add(square);
	        		if(leftMovesBlockedByKing){
	        			BlockedByKingMoves.add(square);
	        		}
	            }
	        	else{
	            	   if (square.getPiece() == null) {
	   	                possibleMoves.add(square);
	   	            } else if (isOpponent(square.getPiece())) {
	   	                possibleMoves.add(square);
	   	             if(square.getPiece().GetPieceType() == piecetype.king){
	   	            	leftMovesBlockedByKing = true;
	   	            	}
	   	             allPossibleleftMovesFound = true;
	   	            }else if (!isOpponent(square.getPiece())) {
	   	            	allPossibleleftMovesFound = true;
	   	         	    BlockedMoves.add(square);
	   	         	    AttackMoves.add(square);
	   	            } else {
	   	            	allPossibleleftMovesFound = true;
	   	            }
	            }
	        }
	        AttackMoves = possibleMoves;
	        return possibleMoves;
	}

	@Override
	public Piecetype GetPieceType() {
		// TODO Auto-generated method stub
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
