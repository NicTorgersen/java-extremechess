package pieces;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import gamelogic.ChessGame;
import gamelogic.Player;
import ui.Board;
import ui.Square;

public abstract class ChessPiece extends JPanel implements MouseListener  {
	protected Collection<Square> possibleMoves;
	protected Collection<Square> AttackMoves;
	public ChessGame.Player player;
	
	protected BufferedImage pieceImage = null;
    //public abstract BufferedImage SetImageNew();
	
	
	protected ChessGame chessGame;

	
	
    //public abstract Collection<Square> getPossibleMoves();

    public abstract Collection<Square> generatePossibleMoves();

	public Piecetype piecetype;
    public abstract Piecetype GetPieceType();
    
    public String ImagePath_Black;
    public String ImagePath_White;
    public abstract String GetImagePathBlack();
    public abstract String GetImagePathWhite();
	
	private Square currentSquare;
	
	//private Collection<Square> getPossibleMoves();
	
	public enum Piecetype{
		pawn, 
		rook,
		knight,
		bishop,
		queen,
		king
	}
	
    public Square getSquare() {
        return currentSquare;
    }
    public void setSquare(Square s) {
       currentSquare = s;
    }
    
    public Collection<Square> getAttackMoves() {
	    return AttackMoves;
	}
    
	public Collection<Square> getPossibleMoves() {
	    return possibleMoves;
	}
	
	
	public ChessPiece(ChessGame.Player p, Square sq, Boolean isVirtual){
	  possibleMoves = new ArrayList<>();
	  AttackMoves = new ArrayList<>();
	  player = p;
	  setSquare(sq);
	  
	  if(!isVirtual){
		      setOpaque(false);
		      addMouseListener(this);
		      setPreferredSize(new Dimension(70, 70));
		      sq.SetNewChessPiece(this);
		      setImage();
	  }
 
   
      
      if(sq.getBoard()._ChessGame != null){
          chessGame = sq.getBoard()._ChessGame;

      }

      generatePossibleMoves();

	}
	
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
	 @Override
	    protected void paintComponent(Graphics g) {
	        super.paintComponent(g);
	        g.drawImage(pieceImage, 0, 0, getWidth(), getHeight(), this);
	       // g.drawImage(pieceImage, 0, 0, this); // see javadoc for more info on the parameters            
	    }

	public void removePieceFromPlayer() {
		chessGame.removePiece(player, this);
		currentSquare.remove(this);
		//chessGame.setSelectedPiece(chessGame.getSelectedPiece());

		currentSquare.getBoard().repaint();
	}
	
	public void ResetPiece(){
		//chessGame.removePiece(player, this);
		currentSquare.remove(this);
		//currentSquare.getBoard().repaint();
	}
	
	public void movePiece(Square sq){
		Square oldSquare = currentSquare;
		oldSquare.setColorToInitial();
		oldSquare.RemoveChessPiece();
		sq.SetNewChessPiece(this);
		setSquare(sq);
		sq.add(this);
		sq.getBoard().repaint();

		
		
		 for (Square fruit : getPossibleMoves()) {
	        	fruit.setColorToInitial();
	            // fruit is an element of the `fruits` array.
	        }
		 generatePossibleMoves();
	     chessGame.switchTurn();
	}
	
	public void DeselectPiece(){
		 chessGame.setSelectedPiece(null);
		 currentSquare.setColorToInitial();
		 for (Square fruit : getPossibleMoves()) {
	        	fruit.setColorToInitial();
	            // fruit is an element of the `fruits` array.
	        }
	}
	
	public void Autoselect(){
		piecePressed();
	}
	
	private void piecePressed(){
		
		if(chessGame.kingIsInCheck && this.piecetype != piecetype.king ){
			return;
		}
		
		//if(chessGame.playerHasSelectedPiece() && chessGame._PlayersTurn != this.player){
		if(chessGame.playerHasSelectedPiece() && isOpponent(chessGame.getSelectedPiece())){
				if(chessGame.getSelectedPiece().getPossibleMoves().contains(this.currentSquare)){
					if(chessGame.playerHasSelectedPiece()){
							chessGame.getSelectedPiece().movePiece(this.currentSquare);
						}
					removePieceFromPlayer();
			}
		} 
		else if(chessGame._PlayersTurn == this.player) {
			
			if(chessGame.playerHasSelectedPiece()){
				chessGame.getSelectedPiece().DeselectPiece();
			}
			
			currentSquare.setBackground(Color.YELLOW);
	        chessGame.setSelectedPiece(this);
	        Collection<Square> s =  generatePossibleMoves();
	        
	        for (Square fruit : s) {
	        	fruit.setColorAsGreen();
	        	
	        	if(isOpponent(fruit.getPiece())){
	        		fruit.setColorAsRed();
		        	
	        	}
	            // fruit is an element of the `fruits` array.
	        }
		}	
	}
	
	public boolean isOpponent(ChessPiece piece) {
        return piece != null && player == ChessGame.Player.white != (piece.player == ChessGame.Player.white);
       // return piece != null && isWhite() != piece.isWhite();
    }

	@Override
	public void mouseClicked(MouseEvent e) {
	//	if(chessGame._PlayersTurn == this.player){
			piecePressed();
	//	}

	}

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
