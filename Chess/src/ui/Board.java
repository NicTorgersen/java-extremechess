package ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import gamelogic.ChessGame;
import pieces.Bishop;
import pieces.King;
import pieces.Knight;
import pieces.Pawn;
import pieces.Queen;
import pieces.Rook;

public final class Board extends JPanel {
	 private static final String alphabetSample = "ABCDEFGH";
	 public static final int BoardSize = 8;
	 private static Square[][] squares = new Square[BoardSize][BoardSize];
	 public ChessGame chessGame;
	    
	 //Constructor. Set's the board
	 public Board(ChessGame cg) {
		 chessGame = cg;
		 JPanel chessBoard = SetChessBoard();
       }  
	 //Sets up and returns the board  
	 public JPanel SetChessBoard(){
		 JPanel chessBoard = new JPanel(new GridLayout(0, 9));
	        chessBoard = new JPanel(new GridLayout(0, 9));
	        chessBoard.setBorder(new LineBorder(Color.BLACK));
	        CreateBoard(chessBoard);
	        add(chessBoard);
	        return  chessBoard;
	   }
	  //Sets up a new game. Sets ChessPieces where they belong
	  public final void setupNewGame() {
	        // set up the black pieces
		   //Set up all pieces on row 0
	        for (int i = 0; i < BoardSize; i++) {
	        	Square s = squares[i][0];
	        	ChessGame.Player p = ChessGame.Player.black;
	        	addFirstRow(i, s, p);
	        }
	        //Set up all pieces on row 1
	        for (int i = 0; i < BoardSize; i++) {
	        	Square s = squares[i][1];
	        	ChessGame.Player p = ChessGame.Player.black;
	        	addPawnToSquare(s, p);
	        }
	        //Set up the white pieces
	        //Set up all pieces on row 6
	        for (int i = 0; i < BoardSize; i++) {
	          	Square s = squares[i][6];
	          	ChessGame.Player p = ChessGame.Player.white;
	          	addPawnToSquare(s, p);
	        }
	        //Set up all pieces on row 7
	        for (int i = 0; i < BoardSize; i++) {
	        	Square s = squares[i][7];
	        	ChessGame.Player p = ChessGame.Player.white;
	        	addFirstRow(i, s, p);
	        
	        }
	    	repaint();
			updateUI();
	    }
	  //Adds a Pawn to given Square and Player
	  private void addPawnToSquare(Square s, ChessGame.Player p){
		  Pawn pawn = new Pawn(p, s, false); s.add(pawn); chessGame.addPieces(p, pawn);
	  }
	  //Sets up first row for Given player
	  private void addFirstRow(int i, Square s, ChessGame.Player p){
		  switch(i){
	      	case 0: Rook rook = new Rook(p, s, false); s.add(rook); chessGame.addPieces(p, rook); break;
	      	case 1: Knight knight = new Knight(p, s, false); s.add(knight); chessGame.addPieces(p, knight); break;
	      	case 2: Bishop bishop = new Bishop(p, s, false); s.add(bishop); chessGame.addPieces(p, bishop); break;
	      	case 3: King king = new King(p, s, false); chessGame.SetKing(p, king); s.add(king); chessGame.addPieces(p, king); break;
	      	case 4: Queen queen = new Queen(p, s, false); s.add(queen); chessGame.addPieces(p, queen); break;
	      	case 5: Bishop bishop2 = new Bishop(p, s, false); s.add(bishop2); chessGame.addPieces(p, bishop2); break;
	      	case 6: Knight knight2 = new Knight(p, s, false); s.add(knight2); chessGame.addPieces(p, knight2); break;
	      	case 7: Rook rook2 = new Rook(p, s, false); s.add(rook2); chessGame.addPieces(p, rook2); break;
	      	}
	  }
	  //Returns square with given row and column
	  public Square getSquare(int row, int column) {
	        Square squ = null;
	        if (row < BoardSize && column < BoardSize && row >= 0 && column >= 0) {
	            squ = squares[row][column];
	        }
	        return squ;
	    }
	  // create the chess board squares
	  private void CreateBoard(JPanel chessBoard){
	        for (int i = 0; i < squares.length; i++) {
	            for (int j = 0; j < squares[i].length; j++) {
	            	Square b;
	            	if ((j % 2 == 1 && i % 2 == 1)
		                        || (j % 2 == 0 && i % 2 == 0)) {
	            			b = new Square(j, i, this,Color.WHITE);
		                    b.setBackground(Color.WHITE);
		                    b.setBorder(BorderFactory.createMatteBorder(0,2,2,2, Color.black)); 
		                } else {
		                	b = new Square(j, i, this,Color.BLACK);
		                    b.setBackground(Color.BLACK);
		                    b.setBorder(BorderFactory.createMatteBorder(0,2,2,2, Color.black)); 
		                }
	                 b.setPreferredSize(new Dimension(70, 70));
	                squares[j][i] = b;
	            }
	        }
	        //Adds empty corner label top
	        chessBoard.add(new JLabel(""));
	        //Adds rest of labels top
	        for (int i = 0; i < 8; i++) {
	            chessBoard.add(new JLabel(alphabetSample.substring(i, i + 1),SwingConstants.CENTER));
	        }
	        // fill the black non-pawn piece row
	        for (int i = 0; i < 8; i++) {
	            for (int j = 0; j < 8; j++) {
	                switch (j) {
	                    case 0:
	                        chessBoard.add(new JLabel("" + (i + 1),
	                                SwingConstants.CENTER));
	                    default:
	                        chessBoard.add(squares[j][i]);
	                }
	            }
	        }
	        //Adds empty corner label bottom
	        chessBoard.add(new JLabel(""));
	        //Adds rest of labels bottom
	        for (int i = 0; i < 8; i++) {
	            chessBoard.add(new JLabel(alphabetSample.substring(i, i + 1),SwingConstants.CENTER));
	        }
	    }
}
