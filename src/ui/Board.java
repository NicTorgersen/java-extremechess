package ui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

public final class Board {
	
	 private static final String COLS = "ABCDEFGH";
	 public static JButton[][] Square = new JButton[8][8];
	    
	  public final static JPanel SetChessBoard(){
		    JPanel chessBoard = new JPanel(new GridLayout(0, 9));
	        chessBoard = new JPanel(new GridLayout(0, 9));
	        chessBoard.setBorder(new LineBorder(Color.BLACK));
	        CreateBoard(chessBoard);
	        return  chessBoard;
	    }
	  
	  private static void CreateBoard(JPanel chessBoard){
	    	 // create the chess board squares
	        Insets buttonMargin = new Insets(0,0,0,0);
	        for (int ii = 0; ii < Square.length; ii++) {
	            for (int jj = 0; jj < Square[ii].length; jj++) {
	                JButton b = new JButton();
	                b.setMargin(buttonMargin);
	                // our chess pieces are 64x64 px in size, so we'll
	                // 'fill this in' using a transparent icon..
	                ImageIcon icon = new ImageIcon(
	                        new BufferedImage(64, 64, BufferedImage.TYPE_INT_ARGB));
	                b.setIcon(icon);
	                if ((jj % 2 == 1 && ii % 2 == 1)
	                        //) {
	                        || (jj % 2 == 0 && ii % 2 == 0)) {
	                    b.setBackground(Color.WHITE);
	                } else {
	                    b.setBackground(Color.BLACK);
	                }
	                Square[jj][ii] = b;
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
	                        chessBoard.add(Square[jj][ii]);
	                }
	            }
	        }
	    }

}
