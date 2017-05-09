package gamelogic;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import pieces.ChessPiece;
import pieces.King;
import ui.GameUI;

public final class ChessGame {
	public static GameUI gameUI;
	private List<ChessPiece> whitePieces = new ArrayList<ChessPiece>();
	private List<ChessPiece> blackPieces = new ArrayList<ChessPiece>();
	private ChessPiece selectedChessPiece;
	private King whiteKing;
	private King blackKing;
	public Player _PlayersTurn;
	private Boolean kingIsInCheck = false;
	public enum Player{
		white,
		black
	}
	
	//Constructor. Initiates the game
	public ChessGame(){
		initiate();
	}
	//Initiates the Games UI and starts a new game
	private void initiate(){
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
	//Removes given ChessPiece from given player
	public void removePiece(Player p, ChessPiece piece) {
		if(p == Player.white){
			if(whitePieces.contains(piece))
				whitePieces.remove(piece);
		}else{
			if(blackPieces.contains(piece))
				blackPieces.remove(piece);
		}
	}
	//Closes the game
	public void CloseGame(){
		System.exit(0);
	}
	//Resigns as current player. Next player is set as winner
	public void ResignCurrentPlayer(){
		if(_PlayersTurn == Player.white){
			setWinner(Player.black);
		}else{
			setWinner(Player.white);
		}
	}
	//Sets given player as winner
	private void setWinner(Player p) {
		if(p == Player.white){
             gameUI.headermessage.setText("White is the winner");
             System.out.println("White is the winner");
		}else{
			 gameUI.headermessage.setText("Black is the winner");
			    System.out.println("Black is the winner");
		}
		resetGame();
	}
	//Starts a new game
	private void newGame(){
		kingIsInCheck = false;
		_PlayersTurn = Player.white;
		whitePieces.clear();
		blackPieces.clear();
		gameUI.board.setupNewGame();
		 for (ChessPiece piece : getWhitePieces()) {
			 piece.generateMoves();
	        }
		 for (ChessPiece piece : getBlackPieces()) {
			 piece.generateMoves();
	        }
	}
	//Resets the game
	public void resetGame(){
		for (int i = 0; i < blackPieces.size(); i++) {
			blackPieces.get(i).resetPiece();
		}
		for (int i = 0; i < whitePieces.size(); i++) {
			whitePieces.get(i).resetPiece();
		}
		newGame();
	}
	//Returns the currently selected ChessPiece
	public ChessPiece getSelectedPiece(){
		return selectedChessPiece;
	}
	//Returns the KingIsInCheck boolean
	public boolean kingIsInCheck(){
		return kingIsInCheck;
	}
	//Returns boolean based on if player has selected a ChessPiece
	public boolean playerHasSelectedPiece(){
		if(getSelectedPiece() != null){
			return true;
		}else{
			return false;
		}
	}
	//Sets the given ChessPiece as selected
	public void setSelectedPiece(ChessPiece piece){
		selectedChessPiece = piece;
		if(selectedChessPiece != null){
		    System.out.println("SelectedChessPiece" + " " + "is" + " " + piece.player.toString() + " " + piece.GetPieceType().toString() + "On square" + piece.getSquare().rowID + piece.getSquare().rowNumber);
		}
     }
	//Assigns given king to given player
	public void SetKing(Player p, King king){
		if(p == Player.white){
			whiteKing = king;
		} else{
			blackKing = king;
		}
	}
	//Returns white players king
	public King getWhiteKing(){
		return whiteKing;
	}
	//Returns black players king
	public King getBlackKing(){
		return blackKing;
	}
	//Sets given king in check
	public void SetKingInCheck(King k){
		if(k.player == Player.white){
			 JOptionPane.showMessageDialog(this.gameUI, "White King in check");
             kingIsInCheck = true;
             getWhiteKing().autoselect();
				  System.out.println("White is in check");
		}else{
			   JOptionPane.showMessageDialog(this.gameUI, "Black King in check");
			   kingIsInCheck = true;
			   getBlackKing().autoselect();
			   System.out.println("Black is in check");
		}
	}
	//Sets given king in CheckMate. Ending this turn
	public void SetKingInCheckMate(King k){
		if(k.player == Player.white){
			 JOptionPane.showMessageDialog(this.gameUI, "CheckMate! Black wins");
		}else{
			   JOptionPane.showMessageDialog(this.gameUI, "CHeckMate! White wins");
		}
	}
	//Switches turn between players
	public void switchTurn() {
		gameUI.headermessage.setText("ASD-3000 eksamen");
		if(kingIsInCheck){
			kingIsInCheck = false;
		}
		setSelectedPiece(null);
	    System.out.println("Switching");

		if(_PlayersTurn == Player.white){
			_PlayersTurn = Player.black;
			 for (ChessPiece piece : getWhitePieces()) {
				 piece.generateMoves();
		        }
			 for (ChessPiece piece : getWhitePieces()) {
				 piece.checkifHasEnemyKingInCheck();
		        }
		}else{
			_PlayersTurn = Player.white;
			 for (ChessPiece piece : getBlackPieces()) {
				 piece.generateMoves();
		        }
			 for (ChessPiece piece : getBlackPieces()) {
				 piece.checkifHasEnemyKingInCheck();
		        }
		}
	    gameUI.setTurnMessage(_PlayersTurn.toString()+"'"+"s" + " "+ "turn");
	}
	//Return the black pieces
	public List<ChessPiece> getBlackPieces() {
		return blackPieces;
	}
    //Returns the white pieces
	public List<ChessPiece> getWhitePieces() {
		return whitePieces;
	}
    //Adds given piece to given player
	public void addPieces(Player p, ChessPiece piece) {
		if(p == Player.white){
			this.whitePieces.add(piece);
		}else{
			this.blackPieces.add(piece);
		}
	}
}
