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
	        for (int j = column + 1, i = row + 1; j < ChessGame.gameUI.board.BoardSize && i < ChessGame.gameUI.board.BoardSize; j++, i++) {
	            Square square = super.getSquare().getBoardSquare(i, j);
	            if (square.getPiece() == null) {
	                possibleMoves.add(square);
	            } else if (isOpponent(square.getPiece())) {
	                possibleMoves.add(square);
	                break;
	            } else {
	                break;
	            }
	        }
	        //all possible moves in the up positive diagonal
	        for (int j = column - 1, i = row + 1; j > -1 && i < ChessGame.gameUI.board.BoardSize; j--, i++) {
	            Square square = super.getSquare().getBoardSquare(i, j);
	            if (square.getPiece() == null) {
	                possibleMoves.add(square);
	            } else if (isOpponent(square.getPiece())) {
	                possibleMoves.add(square);
	                break;
	            } else {
	                break;
	            }
	        }
	        //all possible moves in the up negative diagonal
	        for (int j = column - 1, i = row - 1; j > -1 && i > -1; j--, i--) {
	            Square square = super.getSquare().getBoardSquare(i, j);
	            if (square.getPiece() == null) {
	                possibleMoves.add(square);
	            } else if (isOpponent(square.getPiece())) {
	                possibleMoves.add(square);
	                break;
	            } else {
	                break;
	            }
	        }
	        //all possible moves in the down negative diagonal
	        for (int j = column + 1, i = row - 1; j < ChessGame.gameUI.board.BoardSize && i > -1; j++, i--) {
	            Square square = super.getSquare().getBoardSquare(i, j);
	            if (square.getPiece() == null) {
	                possibleMoves.add(square);
	            } else if (isOpponent(square.getPiece())) {
	                possibleMoves.add(square);
	                break;
	            } else {
	                break;
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
