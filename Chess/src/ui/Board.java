package ui;

import java.awt.Color;
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

import pieces.ChessPiece;

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
	    
	    public Board() {
	    	 JPanel chessBoard = SetChessBoard();
	    	 //add(chessBoard);
	    }
	    
	  public JPanel SetChessBoard(){
		    JPanel chessBoard = new JPanel(new GridLayout(0, 9));
	        chessBoard = new JPanel(new GridLayout(0, 9));
	        chessBoard.setBorder(new LineBorder(Color.BLACK));
	        CreateBoard(chessBoard);
	        createImages();
	        setupNewGame();
	        try {
	  				BufferedImage image = ImageIO.read(new File("Images/blackpieces/KingBlack.png"));
	  			} catch (IOException e) {
	  				// TODO Auto-generated catch block
	  				e.printStackTrace();
	  			}
	        //BufferedImage image = ImageIO.read(Board.class.getResourceAsStream("/images/grass.png"));
	       // Image i = getClass().getResource("/Resources/images/logo.jpg");
	       // InputStream input = classLoader.getResourceAsStream("image.jpg");
	        add(chessBoard);
	        return  chessBoard;
	    }
	  
	  private final static void setupNewGame() {
	        //message.setText("Make your move!");
	        // set up the black pieces
	        for (int i = 0; i < STARTING_ROW.length; i++) {
	        	square[i][0].setIcon(new ImageIcon(
	                    chessPieceImages[BLACK][STARTING_ROW[i]]));
	        }
	        for (int i = 0; i < STARTING_ROW.length; i++) {
	        	square[i][1].setIcon(new ImageIcon(
	                    chessPieceImages[BLACK][PAWN]));
	        }
	        // set up the white pieces
	        for (int i = 0; i < STARTING_ROW.length; i++) {
	        	square[i][6].setIcon(new ImageIcon(
	                    chessPieceImages[WHITE][PAWN]));
	        }
	        for (int i = 0; i < STARTING_ROW.length; i++) {
	        	square[i][7].setIcon(new ImageIcon(
	                    chessPieceImages[WHITE][STARTING_ROW[i]]));
	        }
	        
	    }
	  
	  private final static void createImages() {
	        try {
	            URL url = new URL("http://i.stack.imgur.com/memI0.png");
	            BufferedImage bi = ImageIO.read(url);
	            for (int i = 0; i < 2; i++) {
	                for (int i2 = 0; i2 < 6; i2++) {
	                    chessPieceImages[i][i2] = bi.getSubimage(i2 * 64, i * 64, 64, 64);
	                }
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	            System.exit(1);
	        }
	    }
	  
	  private void CreateBoard(JPanel chessBoard){
	    	 // create the chess board squares
	        Insets buttonMargin = new Insets(0,0,0,0);
	        for (int ii = 0; ii < square.length; ii++) {
	            for (int jj = 0; jj < square[ii].length; jj++) {
	            	Square b = new Square(jj, ii, this);
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