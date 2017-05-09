package pieces;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import gamelogic.ChessGame;
import ui.Square;

public abstract class ChessPiece extends JPanel implements MouseListener  {
	
	//private boolean lockedByOtherPiece;
	protected Collection<Square> AllMoves;
	protected Collection<Square> ImpossibleMoves;
	protected Collection<Square> BlockedByKingMoves;
	protected Collection<Square> BlockedMoves;
	protected Collection<Square> possibleMoves;
	protected Collection<Square> AttackMoves;
	public ChessGame.Player player;
	protected BufferedImage pieceImage = null;
	protected ChessGame chessGame;
    public abstract Collection<Square> generateMoves();
	public Piecetype piecetype;
    public abstract Piecetype GetPieceType();
    public String ImagePath_Black;
    public String ImagePath_White;
    public abstract String GetImagePathBlack();
    public abstract String GetImagePathWhite();
	private Square currentSquare;
	public enum Piecetype{
		pawn, 
		rook,
		knight,
		bishop,
		queen,
		king
	}
	//Constructor. Sets the values of the ChessPiece
    public ChessPiece(ChessGame.Player p, Square sq, Boolean isVirtual){
		  newLists();
		  player = p;
		  setSquare(sq);
		  
		  if(!isVirtual){
			      setOpaque(false);
			      addMouseListener(this);
			      setPreferredSize(new Dimension(70, 70));
			      sq.SetNewChessPiece(this);
			      setImage();
		  }
	      if(sq.getBoard().chessGame != null){
	          chessGame = sq.getBoard().chessGame;

	      }
		}
	//Returns the square that this ChessPiece currently occupies
    public Square getSquare() {
        return currentSquare;
    }
    //Set the current square for this ChessPiece
    public void setSquare(Square s) {
       currentSquare = s;
    }
    //Returns ALL moves for this ChessPiece
    public Collection<Square> getAllMoves() {
    	AllMoves.clear();
   	    AllMoves.addAll(ImpossibleMoves);
    	AllMoves.addAll(getPossibleMoves());
    	AllMoves.addAll(getAttackMoves());
    	AllMoves.addAll(getBlockedMoves());
    	return AllMoves;
	}
    //Returns all moves that is blocked by the enemy king. (Gray moves) The enemy king can't walk there, as that would kill him next round.
    public Collection<Square> getBlockedByKingMoves() {
	    return BlockedByKingMoves;
	}
    //Returns all blockedMoves (Gray moves)
    public Collection<Square> getBlockedMoves() {
	    return BlockedMoves;
	}
    //Returns all attackMoves (Red moves)
    public Collection<Square> getAttackMoves() {
	    return AttackMoves;
	}
    //Returns all possible moves (Green moves)
	public Collection<Square> getPossibleMoves() {
	    return possibleMoves;
	}
	//Sets this piece as protector for the king. Means that it can't move this round, as that would kill the king next round.
	//public void SetAsProtectorForKing(boolean state){
	//	lockedByOtherPiece = state;
	//}
	//Initiates new lists for storing movement
	private void newLists(){
		  AllMoves = new ArrayList<>();
		  possibleMoves = new ArrayList<>();
		  AttackMoves = new ArrayList<>();
		  BlockedMoves = new ArrayList<>();
		  BlockedByKingMoves = new ArrayList<>();
		  ImpossibleMoves = new ArrayList<>(); 
	}
	//Clears all stored movement
	private void ClearAllLists(){
		 AllMoves.clear();
		 ImpossibleMoves.clear();
		 possibleMoves.clear();
		 AttackMoves.clear();
		 BlockedMoves.clear();
		 BlockedByKingMoves.clear();
	}
	//Sets the Pieces image
	private void setImage(){
		 try {
			 if(player == ChessGame.Player.black){
					pieceImage = ImageIO.read(new File(GetImagePathBlack()));
			 }else{
					pieceImage = ImageIO.read(new File(GetImagePathWhite()));
			 }
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			    System.out.println("Bilde error... finner ikke bilde");
			}
	}
	//Removes the piece from it's player
	public void removePieceFromPlayer() {
		chessGame.removePiece(player, this);
		currentSquare.remove(this);
		currentSquare.getBoard().repaint();
	}
	//Resets this piece
	public void resetPiece(){
		 for (Square squ : getAllMoves()) {
			 squ.setColorToInitial();
	        }
		currentSquare.remove(this);
		currentSquare.setColorToInitial();
		currentSquare.RemoveChessPiece();
		newLists();
	}
	//Moves the ChessPiece to given Square
	public void movePiece(Square sq){
		Square oldSquare = currentSquare;
		oldSquare.setColorToInitial();
		oldSquare.RemoveChessPiece();
		sq.SetNewChessPiece(this);
		setSquare(sq);
		sq.add(this);
		sq.getBoard().repaint();
		 for (Square squ : getAllMoves()) {
			 squ.setColorToInitial();
	        }
		 ClearAllLists();
	     chessGame.switchTurn();
	}
	//Sets selected ChessPiece to Null, and set path color to initial
	public void deselectPiece(){
		 chessGame.setSelectedPiece(null);
		 currentSquare.setColorToInitial();
		 for (Square sq : getAllMoves()) {
	        	sq.setColorToInitial();
	        }
	}
	//Checks if this piece has the enemy king in his AttackMoves. Sets the king in Check if it does.
	public void checkifHasEnemyKingInCheck(){
		King k;
		 if(player == ChessGame.Player.white){
			k = chessGame.getBlackKing();
		 }else{
		    k = chessGame.getWhiteKing();
		 }
		 for (Square piece : getAttackMoves()) {
			 if(piece.rowID == k.getSquare().rowID && piece.rowNumber == k.getSquare().rowNumber){
				 System.out.println("Sets king in check");
				 k.SetKingInCheck(this);
			 }
	     }
	}
	//Auto selects this piece. Used to select king at start of a turn where the king is set in check
	public void autoselect(){
		piecePressed();
	}
	//Action for when the piece is pressed
	protected void piecePressed(){
		//If player has selected a piece and attacks an enemy-piece
		if(chessGame.playerHasSelectedPiece() && isEnemy(chessGame.getSelectedPiece())){
				if(chessGame.getSelectedPiece().getPossibleMoves().contains(this.currentSquare)){
					if(chessGame.playerHasSelectedPiece()){
							chessGame.getSelectedPiece().movePiece(this.currentSquare);
						}
					removePieceFromPlayer();
			}
		}
		//If king is in check, only the king can be selected.
		else if(chessGame.kingIsInCheck() && this.piecetype != piecetype.king){
			return;
		}
		else if(chessGame._PlayersTurn == this.player) {
			if(chessGame.playerHasSelectedPiece()){
				chessGame.getSelectedPiece().deselectPiece();
			}
			currentSquare.setBackground(Color.YELLOW);
	        chessGame.setSelectedPiece(this);
	        possibleMoves.clear();
		    AttackMoves.clear();
		    BlockedMoves.clear();
		    BlockedByKingMoves.clear();
	        Collection<Square> s =  generateMoves();
	        //Sets color on Possible moves and on attack moves
	        for (Square sq : s) {
	        	sq.setColorAsGreen();
	        	if(isEnemy(sq.getChessPiece())){
	        		sq.setColorAsRed();
	        	}
	        }
	        //Sets color on blocked moves
	        for (Square sq : BlockedMoves) {
	        	sq.setColorAsGray();
	        }
	        //Sets color on impossible moves (Used only by the king)
	        for (Square sq : ImpossibleMoves) {
	        	sq.setColorAsPink();
	        }
		}	
	}
	//Checks if given piece is an enemy
	public boolean isEnemy(ChessPiece piece) {
        return piece != null && player == ChessGame.Player.white != (piece.player == ChessGame.Player.white);
    }
	@Override
	protected void paintComponent(Graphics g) {
	        super.paintComponent(g);
	        g.drawImage(pieceImage, 0, 0, getWidth(), getHeight(), this);          
	}
	@Override
	public void mouseClicked(MouseEvent e) {
			piecePressed();
	}
	//Empty events
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
	}
}