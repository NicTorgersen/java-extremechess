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
	        possibleMoves.clear();
	        AttackMoves.clear();
	        //all possible moves in the up
	        for (int i = row + 1; i < ChessGame.gameUI.board.BoardSize; i++) {
	            Square square = super.getSquare().getBoardSquare(i, column);
	            if (square.getPiece() == null) {
	                possibleMoves.add(square);
	            } else if (isOpponent(square.getPiece())) {
	                possibleMoves.add(square);
	                break;
	            } else {
	                break;
	            }
	        }
	        //all possible moves in the down
	        for (int i = row - 1; i > -1; i--) {
	            Square square = super.getSquare().getBoardSquare(i, column);
	            if (square.getPiece() == null) {
	                possibleMoves.add(square);
	            } else if (isOpponent(square.getPiece())) {
	                possibleMoves.add(square);
	                break;
	            } else {
	                break;
	            }
	        }
	        //all possible moves to the right
	        for (int i = column + 1; i < ChessGame.gameUI.board.BoardSize; i++) {
	            Square square = super.getSquare().getBoardSquare(row, i);
	            if (square.getPiece() == null) {
	                possibleMoves.add(square);
	            } else if (isOpponent(square.getPiece())) {
	                possibleMoves.add(square);
	                break;
	            } else {
	                break;
	            }
	        }
	        //all possible moves to the left
	        for (int i = column - 1; i > -1; i--) {
	            Square square = super.getSquare().getBoardSquare(row, i);
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
		return  piecetype = Piecetype.rook;
	}

	@Override
	public String GetImagePathBlack() {
		return "Images/blackpieces/RookBlack.png";
	}

	@Override
	public String GetImagePathWhite() {
		return "Images/whitepieces/RookWhite.png";
	}
}
