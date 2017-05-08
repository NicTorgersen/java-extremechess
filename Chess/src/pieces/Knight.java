package pieces;

import java.io.File;
import java.util.Collection;
import gamelogic.ChessGame;
import ui.Square;

public class Knight extends ChessPiece {
	
	public Knight(ChessGame.Player p, Square sq, Boolean isVirtual) {
		super(p, sq, isVirtual);
	}
	@Override
	public Collection<Square> generateMoves() {
        int[][] possibleSquareints = {
            {-2, 1},
            {-1, 2},
            {1, 2},
            {2, 1},
            {2, -1},
            {1, -2},
            {-1, -2},
            {-2, -1}
        };
        for (int[] o : possibleSquareints) {
            Square square = super.getSquare().neighbour(o[0], o[1]);
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
