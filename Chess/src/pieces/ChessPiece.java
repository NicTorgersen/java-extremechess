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

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import gamelogic.ChessGame;
import gamelogic.Player;
import ui.Board;
import ui.Square;

public class ChessPiece extends JPanel implements MouseListener  {
	
	public ChessGame.Player player;
	protected BufferedImage pieceImage = null;
	private ChessGame chessGame;
	public Piecetype piecetype;
	
	private Square currentSquare;
	
	public enum Piecetype{
		pawn, 
		rook,
		knight,
		bishop,
		queen,
		king
	}
	
	public ChessPiece(ChessGame.Player p, Square sq){
      setOpaque(false);
      addMouseListener(this);
      setPreferredSize(new Dimension(70, 70));
      setType();
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
	}
	
	public void movePiece(Square sq){
		Square oldSquare = currentSquare;
		oldSquare.setColorToInitial();
		currentSquare = sq;
		sq.add(this);
		sq.getBoard().repaint();
		chessGame.switchTurn();
	}
	
	private void PiecePressed(){
 
		currentSquare.setBackground(Color.YELLOW);
        chessGame.setSelectedPiece(this);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if(chessGame._PlayersTurn == this.player){
			PiecePressed();
		}

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
