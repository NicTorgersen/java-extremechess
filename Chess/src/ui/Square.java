package ui;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JPanel;
import pieces.ChessPiece;

public class Square extends JPanel implements MouseListener {
	public int rowID = 0;
	public int rowNumber = 0;
	private Board board;
	private ChessPiece currentPieceOnSquare = null;
	private Color initialColor;
	
	//COnrstructor. Sets square values	
	public Square(int i, int row, Board b, Color c){
		rowID = i;
		rowNumber = row;
		board = b;
		initialColor = c;
		addMouseListener(this);
	}
	//Returns the ChessPiece currently occupying the square
	public ChessPiece getChessPiece() {
	    return currentPieceOnSquare;
	}
	//Returns the Squares board
	public Board getBoard(){
		return board;
	}
	//Sets new piece and checks if should remove an old piece
	public void SetNewChessPiece(ChessPiece piece){
		if(currentPieceOnSquare != null && piece.player != currentPieceOnSquare.player){
			currentPieceOnSquare.removePieceFromPlayer();
		}
		currentPieceOnSquare = piece;
	}
	//Used by all pieces to display "possible moves" with enemies on the square"
    public void setColorAsRed(){
        System.out.println("Red");
    	setBackground(Color.RED);
    }
    //Used by all pieces to display "possible moves"
    public void setColorAsGreen(){
    	setBackground(Color.GREEN);
    }
    //Used by all pieces to display "blocked moves"
    public void setColorAsGray(){
    	setBackground(Color.GRAY);
    }
    //Used by the king to display "impossible moves"
    public void setColorAsPink(){
    	setBackground(Color.PINK);
    }
    //Resets the color
	public void setColorToInitial(){
		setBackground(initialColor);
	}
	//Removes the current chessPiece that is on this square
	public void RemoveChessPiece(){
		currentPieceOnSquare = null;
	}
	//For when the square is pressed
	private void SquarePress(MouseEvent e){
		if(board.chessGame.playerHasSelectedPiece()){
			if(board.chessGame.getSelectedPiece().getPossibleMoves().contains(this)){
				board.chessGame.getSelectedPiece().movePiece(this);
			}
	
		} else if(currentPieceOnSquare != null){
			currentPieceOnSquare.mouseClicked(e);
		}
        System.out.println("Square"+ " " + Integer.toString(rowID) + " " +"on row" + " " + Integer.toString(rowNumber) +" " + "is pressed");
	}
	//Returns this squares neighbour by given column and row (Ads this squares row and column)
	public Square neighbour( int column, int row) {
	   return board.getSquare(rowID + row, rowNumber + column);
	}
	//Returns a requested Square on given column and row 
	public Square getBoardSquare(int column, int row) {
	   return board.getSquare(row, column);
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		if(currentPieceOnSquare == null){
			SquarePress(e);
		}
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
