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
	
	 private static final String COLS = "ABCDEFGH";
	 public static Square[][] square = new Square[8][8];
	 
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
		    setupNewGame();

	        add(chessBoard);
	        return  chessBoard;
	    }
	  
	  private final static void setupNewGame() {
	        //message.setText("Make your move!");
	        // set up the black pieces
	        for (int i = 0; i < STARTING_ROW.length; i++) {
	        	Square s = square[i][0];
	        	switch(i){
	        	case 0: square[i][0].add(new Rook(ChessGame.Player.black, s)); break;
	        	case 1: square[i][0].add(new Knight(ChessGame.Player.black, s)); break;
	        	case 2: square[i][0].add(new Bishop(ChessGame.Player.black, s)); break;
	        	case 3: square[i][0].add(new King(ChessGame.Player.black, s)); break;
	        	case 4: square[i][0].add(new Queen(ChessGame.Player.black, s)); break;
	        	case 5: square[i][0].add(new Bishop(ChessGame.Player.black, s)); break;
	        	case 6: square[i][0].add(new Knight(ChessGame.Player.black, s)); break;
	        	case 7: square[i][0].add(new Rook(ChessGame.Player.black, s)); break;
	        	}
	        }
	        for (int i = 0; i < STARTING_ROW.length; i++) {
	        	Square s = square[i][1];
	        	square[i][1].add(new Pawn(ChessGame.Player.black, s));
	        }
	        // set up the white pieces
	        for (int i = 0; i < STARTING_ROW.length; i++) {
	          	Square s = square[i][6];
	        	square[i][6].add(new Pawn(ChessGame.Player.white, s));
	        }
	        for (int i = 0; i < STARTING_ROW.length; i++) {
	        	Square s = square[i][7];
	        	switch(i){
	        	case 0: square[i][7].add(new Rook(ChessGame.Player.white, s)); break;
	        	case 1: square[i][7].add(new Knight(ChessGame.Player.white, s)); break;
	        	case 2: square[i][7].add(new Bishop(ChessGame.Player.white, s)); break;
	        	case 3: square[i][7].add(new King(ChessGame.Player.white, s)); break;
	        	case 4: square[i][7].add(new Queen(ChessGame.Player.white, s)); break;
	        	case 5: square[i][7].add(new Bishop(ChessGame.Player.white, s)); break;
	        	case 6: square[i][7].add(new Knight(ChessGame.Player.white, s)); break;
	        	case 7: square[i][7].add(new Rook(ChessGame.Player.white, s)); break;
	        	}
	        }
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
		                } else {
		                	b = new Square(jj, ii, this,Color.BLACK);
		                    b.setBackground(Color.BLACK);
		                }
	            
	                 b.setPreferredSize(new Dimension(70, 70));
	                // our chess pieces are 64x64 px in size, so we'll
	                // 'fill this in' using a transparent icon..
	                ImageIcon icon = new ImageIcon(
	                        new BufferedImage(64, 64, BufferedImage.TYPE_INT_ARGB));
	           //     b.setIcon(icon);
	              
	                square[jj][ii] = b;
	            }
	        }

	        //fill the chess board
	        chessBoard.add(new JLabel(""));
	        // fill the top row
	        for (int ii = 0; ii < 8; ii++) {
	            chessBoard.add(
	                    new JLabel(COLS.substring(ii, ii + 1),
	                    SwingConstants.CENTER));
	        }
	        // fill the black non-pawn piece row
	        for (int ii = 0; ii < 8; ii++) {
	            for (int jj = 0; jj < 8; jj++) {
	                switch (jj) {
	                    case 0:
	                        chessBoard.add(new JLabel("" + (ii + 1),
	                                SwingConstants.CENTER));
	                    default:
	                        chessBoard.add(square[jj][ii]);
	                }
	            }
	        }
	    }

}
