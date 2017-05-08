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
	public Board board;
	private JPanel Menu;
	private JToolBar toolBar;
	private static int x = 0;
	private static int y = 0;   
	private JButton exitButton = new JButton("Exit");   
	private JButton resetButton = new JButton("Reset");
	private JButton resignButton = new JButton("Resign");
		
	  //Constructor. Initialises the UI.
	  public GameUI(ChessGame cg){
		initializeGui(cg);
	  }
      //Initialises the GUI
	  public final void initializeGui(ChessGame cg) {
		  	gui.add(SetToolBar(), BorderLayout.PAGE_START);
	     	board = new Board(cg);
	     	gui.add(board);
	        SetButtonActions(cg);
	    }
	  //Sets the ButtonActions
	  private void SetButtonActions(ChessGame cg){
			resetButton.setPreferredSize(new Dimension(80, 80));
			resetButton.setBounds(0,0,50,80);
			   resetButton.addActionListener(new ActionListener() { 
					@Override
					public void actionPerformed(ActionEvent arg0) {
						cg.resetGame();
					} 
			    	 } );
			   resignButton.addActionListener(new ActionListener() { 
					@Override
					public void actionPerformed(ActionEvent arg0) {
						cg.ResignCurrentPlayer();
					} 
			    	 } );
			   exitButton.addActionListener(new ActionListener() { 
					@Override
					public void actionPerformed(ActionEvent arg0) {
						cg.CloseGame();
					} 
			    	 } );
		}
	  //Sets and returns the games ToolBar
	  private JToolBar SetToolBar(){
	    	toolBar = new JToolBar("Menu");
	        toolBar.setFloatable(false);
	        toolBar.addSeparator(new Dimension(150, 0));
	        toolBar.add(headermessage, BorderLayout.CENTER);
	        toolBar.addSeparator();
	        toolBar.add(exitButton);
	        toolBar.addSeparator();
	        toolBar.add(resetButton);
	        toolBar.addSeparator();
	        toolBar.add(resignButton);
	        toolBar.addSeparator();
	        toolBar.add(turnmessage);
	        gui.add(toolBar,BorderLayout.LINE_START);
	        return toolBar;
	    }
	    //Returns the games ChessBoard
	    public final JComponent getChessBoard() {
	        return board;
	    }
	    //Returns the games GUI
	    public final JComponent getGui() {
	        return gui;
	    }
		//Sets the TurnMessageText.
		public void setTurnMessage(String s){
			 turnmessage.setText(s);
		}
		@Override
		public void mouseMoved(MouseEvent e) {
			// TODO Auto-generated method stub
			 x = e.getX();
			 y = e.getY();
			 System.out.print("test");
			 headermessage.setText(Integer.toString(y));
		}
        //Empty events
		@Override
		public void mouseDragged(MouseEvent e) {
			// TODO Auto-generated method stub
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