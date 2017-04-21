package gamelogic;

import java.util.List;

import javax.swing.JFrame;

import gamelogic.ChessGame.Player;
import pieces.ChessPiece;
import ui.GameUI;

public final class ChessGame {
	
	public static GameUI gameUI;
	
	private List<ChessPiece> whitePieces;
	private List<ChessPiece> blackPieces;
	
	private ChessPiece selectedChessPiece;
	
	public Player _PlayersTurn;
	
	public List<ChessPiece> getPieces(Player p){
		if(p == Player.white){
			return whitePieces;
		}else{
			return blackPieces;
		}
	}
	
	public void addPiece(Player p, ChessPiece piece){
		if(p == Player.white){
			whitePieces.add(piece);
		}else{
			blackPieces.add(piece);
		}
	}

	public void removePiece(Player p, ChessPiece piece) {
		if(p == Player.white){
			if(whitePieces.contains(piece))
				whitePieces.remove(piece);
		}else{
			if(blackPieces.contains(piece))
				blackPieces.remove(piece);
		}
	}
	
	public enum Player{
		white,
		black
	}
	
	public void initiate(){
	     gameUI = new GameUI(this);
	  
         JFrame f = new JFrame("ExtremeChess");
         f.add(gameUI.getGui());
         f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
         f.setLocationByPlatform(true);
         f.pack();
         f.setMinimumSize(f.getSize());
         f.setVisible(true);
         newGame();
	}
	
	public void newGame(){
		_PlayersTurn = Player.white;
	}
	
	public ChessPiece getSelectedPiece(){
		return selectedChessPiece;
	}
	
	public void setSelectedPiece(ChessPiece piece){
		selectedChessPiece = piece;
		if(selectedChessPiece != null){
		    System.out.println("SelectedChessPiece" + " " + "is" + " " + piece.player.toString() + " " + piece.piecetype.toString());
		}
     }

	public void switchTurn() {
		
		if(_PlayersTurn == Player.white){
			_PlayersTurn = Player.black;
		}else{
			_PlayersTurn = Player.white;
		}
		setSelectedPiece(null);
	    System.out.println("Switching");
	    gameUI.setTurnMessage(_PlayersTurn.toString()+"'"+"s" + " "+ "turn");
		// TODO Auto-generated method stub
		
	}

}
