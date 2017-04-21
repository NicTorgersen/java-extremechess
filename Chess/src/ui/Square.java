package ui;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import pieces.ChessPiece;

public class Square extends JPanel implements MouseListener {
	
	int id = 0;
	int rowNumber = 0;
	
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
		
	//	addActionListener(new ActionListener() {
	//		@Override
		//	public void actionPerformed(ActionEvent arg0) {
		//		SquarePress();
		//	}
    	//});
	}
	
	//Sets new piece and checks if should remove an old piece
	public void SetNewChessPiece(ChessPiece piece){
		
		if(currentPieceOnSquare != null && piece.player != currentPieceOnSquare.player){
			currentPieceOnSquare.removePieceFromPlayer();
		}
		
		currentPieceOnSquare = piece;
	}
	
	public void RemoveChessPiece(){
		currentPieceOnSquare = null;
	}
	
	public void setColorToInitial(){
		setBackground(initialColor);
	}
	
	private void SquarePress(){
		
		if(board._ChessGame.getSelectedPiece() != null){
			board._ChessGame.getSelectedPiece().movePiece(this);
			//add(board._ChessGame.getSelectedPiece());
			//board.repaint();
			//board._ChessGame.getSelectedPiece().repaint();
	       //  System.out.println("hm2");
		}
		
		
		//if (isEnabled()) {
            System.out.println("Square"+ " " + Integer.toString(id) + " " +"on row" + " " + Integer.toString(rowNumber) +" " + "is pressed");
       // }
		
		if(!HasPiece())
			return;
	}
	
	private boolean HasPiece(){
		if(currentPieceOnSquare == null){
			return false;
			
		}else{
			return true;
		}
	}
	
	public void OnPressed(int i){
		id = i;
	}
	
	public Square(){
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		SquarePress();
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
