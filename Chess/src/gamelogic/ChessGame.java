package gamelogic;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import gamelogic.ChessGame.Player;
import pieces.ChessPiece;
import pieces.King;
import ui.GameUI;
import ui.Square;

public final class ChessGame {
	
	public static GameUI gameUI;
	
	private List<ChessPiece> whitePieces = new ArrayList<ChessPiece>();
	private List<ChessPiece> blackPieces = new ArrayList<ChessPiece>();
	
	private ChessPiece selectedChessPiece;
	
	private King whiteKing;
	private King blackKing;
	
	public Player _PlayersTurn;
	public Boolean kingIsInCheck = false;
	
	public List<ChessPiece> getPieces(Player p){
		if(p == Player.white){
			return whitePieces;
		}else{
			return blackPieces;
		}
	}
	
	public void removePiece(Player p, ChessPiece piece) {
	

		if(p == Player.white){
			if(whitePieces.contains(piece))
				whitePieces.remove(piece);
			if((int)whitePieces.size() <= 0)
				setWinner(Player.black);
		}else{
			if(blackPieces.contains(piece))
				blackPieces.remove(piece);
		    System.out.println(Integer.toString(blackPieces.size()));
			if((int)blackPieces.size() <= 0)
				setWinner(Player.white);
		}
	}
	
	private void setWinner(Player p) {
		if(p == Player.white){
             gameUI.headermessage.setText("White is the winner");
             System.out.println("White is the winner");
		}else{
			 gameUI.headermessage.setText("Black is the winner");
			    System.out.println("Black is the winner");
		}
	}

	public enum Player{
		white,
		black
	}
	
	public void initiate(){
	     gameUI = new GameUI(this);
	  
         JFrame f = new JFrame("ExtremeChess");
         f.setResizable(false);
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
		whitePieces.clear();
		blackPieces.clear();
		gameUI.board.setupNewGame();
		gameUI.board.repaint();
		gameUI.board.updateUI();
		
		 for (ChessPiece piece : getWhitePieces()) {
			 piece.generatePossibleMoves();
	        }
		 for (ChessPiece piece : getBlackPieces()) {
			 piece.generatePossibleMoves();
	        }
		

	}
	
	public void resetGame(){
		for (int i = 0; i < blackPieces.size(); i++) {
			blackPieces.get(i).ResetPiece();
		}
		for (int i = 0; i < whitePieces.size(); i++) {
			whitePieces.get(i).ResetPiece();
		}
		newGame();
	}
	
	public ChessPiece getSelectedPiece(){
		return selectedChessPiece;
	}
	
	public boolean playerHasSelectedPiece(){
		if(getSelectedPiece() != null){
			return true;
		}else{
			return false;
		}
	}
	
	public void setSelectedPiece(ChessPiece piece){
		selectedChessPiece = piece;
		if(selectedChessPiece != null){
		    System.out.println("SelectedChessPiece" + " " + "is" + " " + piece.player.toString() + " " + piece.GetPieceType().toString() + "On square" + piece.getSquare().id + piece.getSquare().rowNumber);
		}
     }
	
	public void SetKing(Player p, King king){
		if(p == Player.white){
			whiteKing = king;
		} else{
			blackKing = king;
		}
	}
	
	public King getWhiteKing(){
		if(whiteKing != null){
			  System.out.println("Henter hvit konge");
		}

		return whiteKing;
	}
	
	public King getBlackKing(){
		return blackKing;
	}
	
	
	public void SetKingInCheck(King k){
		
		if(k.player == Player.white){
			 JOptionPane.showMessageDialog(this.gameUI, "White King in check");
             kingIsInCheck = true;
             getWhiteKing().Autoselect();
				  System.out.println("White is in check");
		}else{
			   JOptionPane.showMessageDialog(this.gameUI, "Black King in check");
			   kingIsInCheck = true;
			   getBlackKing().Autoselect();
			   System.out.println("Black is in check");
		}
	}
	
	public void SetKingInCheckMate(){
		
	}
	

	public void switchTurn() {
		
		if(kingIsInCheck){
			kingIsInCheck = false;
		}
		
		setSelectedPiece(null);
	    System.out.println("Switching");

		
		if(_PlayersTurn == Player.white){
			_PlayersTurn = Player.black;
			 for (ChessPiece piece : getWhitePieces()) {
				 piece.generatePossibleMoves();
				 piece.CheckifHasEnemyKingInCheck();
		        }
         //   if(getBlackKing().checkIfKingIsInCheck()){
           //     JOptionPane.showMessageDialog(this.gameUI, "Black King in check");
            //    kingIsInCheck = true;
           //     getBlackKing().Autoselect();
           // 	  System.out.println("Black is in check");
		//	}else{
		//		 kingIsInCheck = false;
		//	}
		}else{
			_PlayersTurn = Player.white;
			 for (ChessPiece piece : getBlackPieces()) {
				 piece.generatePossibleMoves();
				 piece.CheckifHasEnemyKingInCheck();
		        }
			//if(getWhiteKing().checkIfKingIsInCheck()){
             //   JOptionPane.showMessageDialog(this.gameUI, "White King in check");
             //   kingIsInCheck = true;
             //   getWhiteKing().Autoselect();
			//	  System.out.println("White is in check");
			//}else{
			//	   kingIsInCheck = false;
			//}
	
		}
		
	    gameUI.setTurnMessage(_PlayersTurn.toString()+"'"+"s" + " "+ "turn");

		// TODO Auto-generated method stub
		
	}
	
	public List<ChessPiece> getBlackPieces() {
		return blackPieces;
	}

	public void setBlackPieces(List<ChessPiece> blackPieces) {
		this.blackPieces = blackPieces;
	}
	
	public void addBlackPieces(ChessPiece blackPiece) {
		this.blackPieces.add(blackPiece);
	}

	public List<ChessPiece> getWhitePieces() {
		return whitePieces;
	}

	public void setWhitePieces(List<ChessPiece> whitePieces) {
		this.whitePieces = whitePieces;
	}
	
	public void addPieces(Player p, ChessPiece piece) {
		if(p == Player.white){
			this.whitePieces.add(piece);
		}else{
			this.blackPieces.add(piece);
		}

	}
	
	public void addWhitePieces(ChessPiece whitePiece) {
		this.whitePieces.add(whitePiece);
	}

}
