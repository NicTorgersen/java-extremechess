package pieces;

import java.io.File;
import java.io.IOException;
import java.util.Collection;

import javax.imageio.ImageIO;

import gamelogic.ChessGame;
import pieces.ChessPiece.Piecetype;
import ui.Square;

public class Queen extends ChessPiece {

	public Queen(ChessGame.Player p, Square sq, Boolean isVirtual) {
		super(p, sq, isVirtual);
	}
	



	@Override
	public Collection<Square> generatePossibleMoves() {
	     possibleMoves.clear();
	     AttackMoves.clear();
	     ChessPiece[] pieces = {
	    		new Rook(this.player, this.getSquare(), true),
	    		new Bishop(this.player, this.getSquare(), true), 
	        };
	        for (ChessPiece piece : pieces) {
	            //piece.setSquare(getSquare());
	                possibleMoves.addAll(piece.generatePossibleMoves());

	
	        }
	        AttackMoves = possibleMoves;
	        return possibleMoves;
	}

	@Override
	public Piecetype GetPieceType() {
		// TODO Auto-generated method stub
		return  piecetype = Piecetype.queen;
	}

	@Override
	public String GetImagePathBlack() {
		return "Images" + File.separator + "blackpieces"+ File.separator + "QueenBlack.png";
	}

	@Override
	public String GetImagePathWhite() {
		return "Images" + File.separator + "whitepieces"+ File.separator + "QueenWhite.png";
	}
}
