package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.BoxLayout;
import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import javax.swing.border.EmptyBorder;

import gamelogic.ChessGame;

public class GameUI extends JApplet implements KeyListener, MouseListener, MouseMotionListener {

	   private final JPanel gui = new JPanel(new BorderLayout(13, 13));
	   public final JLabel headermessage = new JLabel("ASD-3000 Eksamen");
	   public final JLabel turnmessage = new JLabel("White's turn");
	    //Panels
	    public Board board;
	    //private JPanel chessBoard;
	    private JPanel Menu;
	    private JToolBar toolBar;
	    private static int x = 0;
		   private static int y = 0;
		   
		private JButton exitButton = new JButton("Exit");   
	    private JButton resetButton = new JButton("Reset");
	    private JButton resignButton = new JButton("Resign");
		
	
	public GameUI(ChessGame cg){
		initializeGui(cg);
		resetButton.setPreferredSize(new Dimension(80, 80));
		resetButton.setBounds(0,0,50,80);
	}
	
	  public final void initializeGui(ChessGame cg) {
	       // gui.setBorder(new EmptyBorder(5, 5, 5, 5));
	        gui.add(SetToolBar(), BorderLayout.PAGE_START);
	    //    gui.add(SetSideMenu(cg),BorderLayout.LINE_START);
	        //JButton resetb = new JButton("Reset");
	        //resetb.setBounds(0,0,50,80);
	       // resetb.setPreferredSize(new Dimension(80, 80));
	      //  gui.add(resetb);
	        board = new Board(cg);
	        gui.add(board);
	    }
	  
	  private JToolBar SetToolBar(){
	    	toolBar = new JToolBar("Menu");
	        toolBar.setFloatable(false);
	        toolBar.addSeparator(new Dimension(150, 0));
	        toolBar.add(headermessage, BorderLayout.CENTER);
	        toolBar.addSeparator();
	       // JButton resetb = new JButton("Reset");
	        toolBar.add(exitButton);
	        toolBar.addSeparator();
	        toolBar.add(resetButton);
	        toolBar.addSeparator();
	        toolBar.add(resignButton);
	        toolBar.addSeparator();
	        toolBar.add(turnmessage);
	       // resetb.setBounds(0,0,50,80);
	        //resetb.setPreferredSize(new Dimension(80, 80));
	        gui.add(toolBar,BorderLayout.LINE_START);
	        return toolBar;
	    }
	    
	    private JPanel SetSideMenu(ChessGame cg){
	        Menu = new JPanel();
	        Menu.setBackground(Color.GRAY);
	        Menu.setLayout(new BoxLayout(Menu, BoxLayout.Y_AXIS));
	       JButton exitb = new JButton("Exit");
	       JButton resetb = new JButton("Reset");
	       resetb.addActionListener(new ActionListener() { 
			@Override
			public void actionPerformed(ActionEvent arg0) {
				cg.resetGame();
			} 
	    	 } );
	    
	       
	        Menu.add(exitb); // TODO - add functionality!
	        Menu.add(resetb); // TODO - add functionality!
	        Menu.add(new JButton("Resign")); 
	        Menu.add(turnmessage);
	        exitb.setPreferredSize(new Dimension(180, 180));
		       exitb.setBounds(0,0,50,80);
	        return  Menu;
	    }
	    public final JComponent getChessBoard() {
	        return board;
	    }

	    public final JComponent getGui() {
	        return gui;
	    }

		@Override
		public void mouseDragged(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseMoved(MouseEvent e) {
			// TODO Auto-generated method stub
			 x = e.getX();
			 y = e.getY();
			 System.out.print("test");
			 headermessage.setText(Integer.toString(y));
		}
		
		public void setTurnMessage(String s){
			 turnmessage.setText(s);
		}

		@Override
		public void mouseClicked(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseEntered(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void keyPressed(KeyEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void keyReleased(KeyEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void keyTyped(KeyEvent arg0) {
			// TODO Auto-generated method stub
			
		}
}