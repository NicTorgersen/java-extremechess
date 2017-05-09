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
		 int row = getSquare().rowNumber;
	     int column = getSquare().rowID;
	     generateDownDiagonalMoves(row,column);
	     generateUpDiagonalMoves(row,column);
	     generateUpNegativeDiagonalMoves(row,column);
	     generateDownNegativeDiagonalMoves(row,column);
	     AttackMoves.addAll(possibleMoves);
	     return possibleMoves;
	}
	//Generates all possible moves down diagonal (Right side)
	private void generateDownDiagonalMoves(int row, int column){
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
	}
	//Generates all possible moves up diagonal (Right side)
	private void generateUpDiagonalMoves(int row, int column){
       boolean allPossibleMovesFound = false;
       boolean MovesBlockedByKing = false;
       for (int j = column - 1, i = row + 1; j > -1 && i < ChessGame.gameUI.board.BoardSize; j--, i++) {
       	Square square = super.getSquare().getBoardSquare(i, j);
       	if(allPossibleMovesFound){
       		BlockedMoves.add(square);
       		if(MovesBlockedByKing){
       			BlockedByKingMoves.add(square);
       		}
           }
       	else{
           	   if (square.getChessPiece() == null) {
  	                possibleMoves.add(square);
  	            } else if (isEnemy(square.getChessPiece())) {
  	            	if(square.getChessPiece().GetPieceType() == piecetype.king){
  	            		MovesBlockedByKing = true;
  	            	}
  	                possibleMoves.add(square);
  	             allPossibleMovesFound = true;
  	            }else if (!isEnemy(square.getChessPiece())) {
  	            	allPossibleMovesFound = true;
  	         	    BlockedMoves.add(square);
  	         	    AttackMoves.add(square);
  	            } else {
  	            	allPossibleMovesFound = true;
  	            }
           }
       }
	}
	//Generates all possible moves down diagonal (Left side)
		private void generateDownNegativeDiagonalMoves(int row, int column){
	     boolean allPossibleMovesFound = false;
	     boolean MovesBlockedByKing = false;
	     for (int j = column + 1, i = row - 1; j < ChessGame.gameUI.board.BoardSize && i > -1; j++, i--) {
	     	Square square = super.getSquare().getBoardSquare(i, j);
	     	if(allPossibleMovesFound){
	     		BlockedMoves.add(square);
	     		if(MovesBlockedByKing){
	     			BlockedByKingMoves.add(square);
	     		}
	         }
	     	else{
	         	   if (square.getChessPiece() == null) {
		                possibleMoves.add(square);
		            } else if (isEnemy(square.getChessPiece())) {
		            	if(square.getChessPiece().GetPieceType() == piecetype.king){
		            		MovesBlockedByKing = true;
		            	}
		                possibleMoves.add(square);
		             allPossibleMovesFound = true;
		            }else if (!isEnemy(square.getChessPiece())) {
		            	allPossibleMovesFound = true;
		         	    BlockedMoves.add(square);
		         	    AttackMoves.add(square);
		            } else {
		            	allPossibleMovesFound = true;
		            }
	         }
	     }
		}
	//Generates all possible moves up diagonal (Left side)
	private void generateUpNegativeDiagonalMoves(int row, int column){
      boolean allPossibleMovesFound = false;
      boolean MovesBlockedByKing = false;
      for (int j = column - 1, i = row - 1; j > -1 && i > -1; j--, i--) {
      	Square square = super.getSquare().getBoardSquare(i, j);
      	if(allPossibleMovesFound){
      		BlockedMoves.add(square);
      		if(MovesBlockedByKing){
      			BlockedByKingMoves.add(square);
      		}
          }
      	else{
          	   if (square.getChessPiece() == null) {
 	                possibleMoves.add(square);
 	            } else if (isEnemy(square.getChessPiece())) {
 	            	if(square.getChessPiece().GetPieceType() == piecetype.king){
 	            		MovesBlockedByKing = true;
 	            	}
 	                possibleMoves.add(square);
 	             allPossibleMovesFound = true;
 	            }else if (!isEnemy(square.getChessPiece())) {
 	            	allPossibleMovesFound = true;
 	         	    BlockedMoves.add(square);
 	         	    AttackMoves.add(square);
 	            } else {
 	            	allPossibleMovesFound = true;
 	            }
          }
      }
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
