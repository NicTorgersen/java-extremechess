package pieces;

import java.io.File;
import java.util.Collection;
import gamelogic.ChessGame;
import ui.Square;

public class Knight extends ChessPiece {
	
    private int[][] possibleSquareints = {
            {-2, 1},
            {-1, 2},
            {1, 2},
            {2, 1},
            {2, -1},
            {1, -2},
            {-1, -2},
            {-2, -1}
        };
	
	public Knight(ChessGame.Player p, Square sq, Boolean isVirtual) {
		super(p, sq, isVirtual);
	}
	@Override
	public Collection<Square> generateMoves() {
        for (int[] psi : possibleSquareints) {
            Square square = super.getSquare().neighbour(psi[0], psi[1]);
            if (square != null && (square.getChessPiece() == null || isEnemy(square.getChessPiece()))) {
                possibleMoves.add(square);
            }
            if(square != null && square.getChessPiece() != null){
            	if(!isEnemy(square.getChessPiece())){
            	 	BlockedMoves.add(square);
            	}
            }
            if(square != null){
                AttackMoves.add(square);
            }
        }
        return possibleMoves;
	}
	@Override
	public Piecetype GetPieceType() {
		 return  piecetype = Piecetype.knight;
	}
	@Override
	public String GetImagePathBlack() {
		return "Bin" + File.separator + "blackpieces"+ File.separator + "KnightBlack.png";
	}
	@Override
	public String GetImagePathWhite() {
		return "Bin" + File.separator + "whitepieces"+ File.separator + "KnightWhite.png";
	}
}
