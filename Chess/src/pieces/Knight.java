package pieces;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

import javax.imageio.ImageIO;

import gamelogic.ChessGame;
import pieces.ChessPiece.Piecetype;
import ui.Square;

public class Knight extends ChessPiece {
	
	public Knight(ChessGame.Player p, Square sq, Boolean isVirtual) {
		super(p, sq, isVirtual);
	}
	

	@Override
	public Collection<Square> generatePossibleMoves() {
		possibleMoves.clear();
	    AttackMoves.clear();
        int[][] offsets = {
            {-2, 1},
            {-1, 2},
            {1, 2},
            {2, 1},
            {2, -1},
            {1, -2},
            {-1, -2},
            {-2, -1}
        };
        for (int[] o : offsets) {
            Square square = super.getSquare().neighbour(o[0], o[1]);
            if (square != null && (square.getPiece() == null || isOpponent(square.getPiece()))) {
                possibleMoves.add(square);
            }
            
            if(square != null && square.getPiece() != null){
            	if(!isOpponent(square.getPiece())){
            	 	BlockedMoves.add(square);
            	}
            }
            
            if(square != null){
                AttackMoves.add(square);
            }
        }
        //AttackMoves = possibleMoves;
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
