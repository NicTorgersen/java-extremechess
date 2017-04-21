package ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import pieces.ChessPiece;

public class Square extends JButton {
	
	int id = 0;
	int rowNumber = 0;
	
	private ChessPiece currentPieceOnSquare = null;
	
	public ChessPiece getChessPiece(){
		return currentPieceOnSquare;
	}
	
	public Square(int i, int row, Board b){
		id = i;
		rowNumber = row;
		addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				SquarePress();
			}
    	});
	}
	
	public void SetNewChessPiece(ChessPiece p){
		currentPieceOnSquare = p;
	}
	
	public void RemoveChessPiece(){
		currentPieceOnSquare.destroyPiece();
		currentPieceOnSquare = null;
	}
	
	
	private void SquarePress(){
		if(HasPiece())
			return;
		
		if (isEnabled()) {
            System.out.println("Square"+ " " + Integer.toString(id) + " " +"on row" + " " + Integer.toString(rowNumber) +" " + "is pressed");
        }
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
	

}