package ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Iterator;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import gamelogic.ChessGame;
import pieces.Bishop;
import pieces.ChessPiece;
import pieces.King;
import pieces.Knight;
import pieces.Pawn;
import pieces.Queen;
import pieces.Rook;

public final class Board extends JPanel {
	 public static final int BoardSize = 8;
	 private static final String COLS = "ABCDEFGH";
	 public static Square[][] square = new Square[BoardSize][BoardSize];
	 
	 private static Image[][] chessPieceImages = new Image[2][6];
	 public static final int BLACK = 0, WHITE = 1;
	 
	   public static final int QUEEN = 0, KING = 1,
	            ROOK = 2, KNIGHT = 3, BISHOP = 4, PAWN = 5;
	    public static final int[] STARTING_ROW = {
	        ROOK, KNIGHT, BISHOP, KING, QUEEN, BISHOP, KNIGHT, ROOK
	    };
	    
	 public ChessGame _ChessGame;
	    
	    public Board(ChessGame cg) {
	    	 _ChessGame = cg;

	    	 JPanel chessBoard = SetChessBoard();

	    }
	    
	  public JPanel SetChessBoard(){
		    JPanel chessBoard = new JPanel(new GridLayout(0, 9));
	        chessBoard = new JPanel(new GridLayout(0, 9));
	        chessBoard.setBorder(new LineBorder(Color.BLACK));
	        CreateBoard(chessBoard);
		    //setupNewGame();

	        add(chessBoard);
	        return  chessBoard;
	    }
	  
	  public final void setupNewGame() {
	        //message.setText("Make your move!");
	        // set up the black pieces
	        for (int i = 0; i < STARTING_ROW.length; i++) {
	        	Square s = square[i][0];
	        	ChessGame.Player p = ChessGame.Player.black;
	        	addFirstRow(i, s, p);
	        }
	        for (int i = 0; i < STARTING_ROW.length; i++) {
	        	Square s = square[i][1];
	        	ChessGame.Player p = ChessGame.Player.black;
	        	addPawnRow(s, p);
	        }
	        // set up the white pieces
	        for (int i = 0; i < STARTING_ROW.length; i++) {
	          	Square s = square[i][6];
	          	ChessGame.Player p = ChessGame.Player.white;
	        	addPawnRow(s, p);
	        }
	        for (int i = 0; i < STARTING_ROW.length; i++) {
	        	Square s = square[i][7];
	        	ChessGame.Player p = ChessGame.Player.white;
	        	addFirstRow(i, s, p);
	        
	        }

	    }
	  
	  private void addPawnRow(Square s, ChessGame.Player p){
		  Pawn pawn = new Pawn(p, s); s.add(pawn); _ChessGame.addPieces(p, pawn);
	  }
	  
	  private void addFirstRow(int i, Square s, ChessGame.Player p){
		  switch(i){
	      	case 0: Rook rook = new Rook(p, s); s.add(rook); _ChessGame.addPieces(p, rook); break;
	      	case 1: Knight knight = new Knight(p, s); s.add(knight); _ChessGame.addPieces(p, knight); break;
	      	case 2: Bishop bishop = new Bishop(p, s); s.add(bishop); _ChessGame.addPieces(p, bishop); break;
	      	case 3: King king = new King(p, s); s.add(king); _ChessGame.addPieces(p, king); break;
	      	case 4: Queen queen = new Queen(p, s); s.add(queen); _ChessGame.addPieces(p, queen); break;
	      	case 5: Bishop bishop2 = new Bishop(p, s); s.add(bishop2); _ChessGame.addPieces(p, bishop2); break;
	      	case 6: Knight knight2 = new Knight(p, s); s.add(knight2); _ChessGame.addPieces(p, knight2); break;
	      	case 7: Rook rook2 = new Rook(p, s); s.add(rook2); _ChessGame.addPieces(p, rook2); break;
	      	}
	  }
	  
	  public Square getSquare(int row, int column) {
	        Square squ = null;
	        if (row < BoardSize && column < BoardSize && row >= 0 && column >= 0) {
	            squ = square[row][column];
	        }
	        return squ;
	    }
	  
	  private void CreateBoard(JPanel chessBoard){
	    	 // create the chess board squares
	        //Insets buttonMargin = new Insets(0,0,0,0);
	        for (int ii = 0; ii < square.length; ii++) {
	            for (int jj = 0; jj < square[ii].length; jj++) {
	            	Square b;
	            	if ((jj % 2 == 1 && ii % 2 == 1)
		                        //) {
		                        || (jj % 2 == 0 && ii % 2 == 0)) {
	            			b = new Square(jj, ii, this,Color.WHITE);
		                    b.setBackground(Color.WHITE);
		                    b.setBorder(BorderFactory.createMatteBorder(0,2,2,2, Color.black)); 
		                } else {
		                	b = new Square(jj, ii, this,Color.BLACK);
		                    b.setBackground(Color.BLACK);
		                    b.setBorder(BorderFactory.createMatteBorder(0,2,2,2, Color.black)); 
		                }
	            
	                 b.setPreferredSize(new Dimension(70, 70));
	                // our chess pieces are 64x64 px in size, so we'll
	                // 'fill this in' using a transparent icon..
	               // ImageIcon icon = new ImageIcon(
	               //         new BufferedImage(64, 64, BufferedImage.TYPE_INT_ARGB));
	           //     b.setIcon(icon);
	              
	                square[jj][ii] = b;
	            }
	        }

	        //fill the chess board
	        chessBoard.add(new JLabel(""));
	        // fill the top row
	        for (int i = 0; i < 8; i++) {
	            chessBoard.add(new JLabel(COLS.substring(i, i + 1),SwingConstants.CENTER));
	        }
	  
	        // fill the black non-pawn piece row
	        for (int ii = 0; ii < 8; ii++) {
	            for (int jj = 0; jj < 8; jj++) {
	                switch (jj) {
	                    case 0:
	                        chessBoard.add(new JLabel("" + (ii + 1),
	                                SwingConstants.CENTER));
	                    //case 9:
	                       // chessBoard.add(new JLabel("" + (ii + 1),
	                        //        SwingConstants.CENTER));
	                    default:
	                        chessBoard.add(square[jj][ii]);
	                }
	            }
	        }
	        chessBoard.add(new JLabel(""));
	        
	        for (int i = 0; i < 8; i++) {
	            chessBoard.add(new JLabel(COLS.substring(i, i + 1),SwingConstants.CENTER));
	        }
	    }

}
