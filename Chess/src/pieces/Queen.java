package pieces;

import java.io.File;
import java.util.Collection;
import gamelogic.ChessGame;
import ui.Square;

public class Queen extends ChessPiece {
	
	public Queen(ChessGame.Player p, Square sq, Boolean isVirtual) {
		super(p, sq, isVirtual);
	}
	
	//The Queen uses virtual versions of Rook and Bishop to generate a path based on their movement logic. (Their constructor is set to be virtual)
	@Override
	public Collection<Square> generateMoves() {
	        for (ChessPiece piece : copiedMovementPieces()) {
	                possibleMoves.addAll(piece.generateMoves());
	                BlockedMoves.addAll(piece.getBlockedMoves());
	                BlockedByKingMoves.addAll(piece.getBlockedByKingMoves());
	                AttackMoves.addAll(piece.getAttackMoves());
	        }
	        return possibleMoves;
	}
	//Array containing all ChessPieces which to copy movement from
	private ChessPiece[] copiedMovementPieces(){
		  ChessPiece[] pieces = {
		    		new Rook(this.player, this.getSquare(), true),
		    		new Bishop(this.player, this.getSquare(), true), 
		        };
		  return pieces;
	}
	
	@Override
	public Piecetype GetPieceType() {
		return  piecetype = Piecetype.queen;
	}
	@Override
	public String GetImagePathBlack() {
		return "Bin" + File.separator + "blackpieces"+ File.separator + "QueenBlack.png";
	}
	@Override
	public String GetImagePathWhite() {
		return "Bin" + File.separator + "whitepieces"+ File.separator + "QueenWhite.png";
	}
}