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
	
	public ChessGame.Player player;
	protected BufferedImage pieceImage = null;
	private ChessGame chessGame;
	public Piecetype piecetype;
	
	
    public abstract Collection<Square> getPossibleMoves();

    public abstract Collection<Square> generatePossibleMoves();

	
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
	

	
	public ChessPiece(ChessGame.Player p, Square sq){
	 
      setOpaque(false);
      addMouseListener(this);
      setPreferredSize(new Dimension(70, 70));
      setType();
      sq.SetNewChessPiece(this);
      player = p;
      currentSquare = sq;
      
      if(sq.getBoard()._ChessGame != null){
          chessGame = sq.getBoard()._ChessGame;

      }

      setImage();

	}
	
	protected void setType(){
	  piecetype = Piecetype.rook;
	}
	
	protected void setImage(){
		  try {
				pieceImage = ImageIO.read(new File("Images/blackpieces/KingBlack.png"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
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
		currentSquare = sq;
		sq.add(this);
		sq.getBoard().repaint();
		chessGame.switchTurn();
		
		
		 for (Square fruit : getPossibleMoves()) {
	        	fruit.setColorToInitial();
	            // fruit is an element of the `fruits` array.
	        }
	}
	
	public void DeselectPiece(){
		 chessGame.setSelectedPiece(null);
		 currentSquare.setColorToInitial();
		 for (Square fruit : getPossibleMoves()) {
	        	fruit.setColorToInitial();
	            // fruit is an element of the `fruits` array.
	        }
	}
	
	private void piecePressed(){
		
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
