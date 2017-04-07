package ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import pieces.ChessPiece;

public class Square extends JButton {
	
	int id = 0;
	int rowNumber = 0;
	
	private ChessPiece currentPieceOnSquare = null;
	
	public void SetSquareValues(int i, int row){
		id = i;
		rowNumber = row;
		
		addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (isEnabled()) {
		            System.out.println("Square"+ " " + Integer.toString(id) + " " +"on row" + " " + Integer.toString(row) +" " + "is pressed");
		        }
		        if (!isEnabled()) {
		            System.out.println("Square"+ " " + Integer.toString(id) + " " +"on row" + " " + Integer.toString(row) + " " + "is not pressed");
		        }
				
			}
    	});
		
	}
	
	public void OnPressed(int i){
		id = i;
	}
	
	public Square(){
		
	}
	

}