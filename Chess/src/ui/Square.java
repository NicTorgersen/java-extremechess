package ui;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Collection;

import javax.swing.JButton;
import javax.swing.JPanel;

import pieces.ChessPiece;

public class Square extends JPanel implements MouseListener {
	
	public int id = 0;
	public int rowNumber = 0;
	
  //  public final int ROW;
  // public final int COLUMN;
	
	private Board board;
	

	
	private ChessPiece currentPieceOnSquare = null;
	private Color initialColor;
	
	public ChessPiece getChessPiece(){
		return currentPieceOnSquare;
	}
	
	public Board getBoard(){
		return board;

	}
	
	
		
	public Square(int i, int row, Board b, Color c){
		id = i;
		rowNumber = row;
		board = b;
		initialColor = c;
		addMouseListener(this);
	}
	
	//Sets new piece and checks if should remove an old piece
	public void SetNewChessPiece(ChessPiece piece){
		

		if(currentPieceOnSquare != null && piece.player != currentPieceOnSquare.player){
			currentPieceOnSquare.removePieceFromPlayer();
		}
		
		currentPieceOnSquare = piece;
	}
	
    public void setColorAsRed(){
        System.out.println("Red");
    	setBackground(Color.RED);
    }
    public void setColorAsGreen(){
    	setBackground(Color.GREEN);
    }
    
    public void setColorAsGray(){
    	setBackground(Color.GRAY);
    }
    
	public void setColorToInitial(){
		setBackground(initialColor);
	}
	
	public void RemoveChessPiece(){
		currentPieceOnSquare = null;
	}
	

	
	 public ChessPiece getPiece() {
	        return currentPieceOnSquare;
	    }
	
	private void SquarePress(MouseEvent e){
		if(board._ChessGame.playerHasSelectedPiece()){
			if(board._ChessGame.getSelectedPiece().getPossibleMoves().contains(this)){
				board._ChessGame.getSelectedPiece().movePiece(this);
			}
	
		} else if(currentPieceOnSquare != null){
			currentPieceOnSquare.mouseClicked(e);
		}
        System.out.println("Square"+ " " + Integer.toString(id) + " " +"on row" + " " + Integer.toString(rowNumber) +" " + "is pressed");
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if(currentPieceOnSquare == null){
			SquarePress(e);
		}
	}
	
	 public Square neighbour( int column, int row) {
	        return board.getSquare(id + row, rowNumber + column);
	    }
	 
	 public Square getBoardSquare(int column, int row) {
	        return board.getSquare(row, column);
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
