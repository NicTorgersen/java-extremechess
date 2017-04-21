package ui;

import java.awt.BorderLayout;
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

public class GameUI extends JApplet implements KeyListener, MouseListener, MouseMotionListener {

	   private final JPanel gui = new JPanel(new BorderLayout(3, 3));
	    public final JLabel headermessage = new JLabel(
	            "EXTREME CHESS!");
	    //Panels
	    public Board board;
	    //private JPanel chessBoard;
	    private JPanel Menu;
	    private JToolBar toolBar;
	    private static int x = 0;
		   private static int y = 0;
	
	public GameUI(){
		initializeGui();
	}
	
	  public final void initializeGui() {
	        gui.setBorder(new EmptyBorder(5, 5, 5, 5));
	        gui.add(SetToolBar(), BorderLayout.PAGE_START);
	        gui.add(SetSideMenu(),BorderLayout.LINE_START);
	        board = new Board();
	        gui.add(board);
	    }
	  
	  private JToolBar SetToolBar(){
	    	toolBar = new JToolBar();
	        toolBar.setFloatable(false);
	        toolBar.addSeparator();
	        toolBar.add(headermessage);
	        toolBar.addSeparator();
	        return toolBar;
	    }
	    
	    private JPanel SetSideMenu(){
	        Menu = new JPanel();
	        Menu.setLayout(new BoxLayout(Menu, BoxLayout.Y_AXIS));
	        Menu.add(new JButton("Exit")); // TODO - add functionality!
	        Menu.add(new JButton("Reset")); // TODO - add functionality!
	        Menu.add(new JButton("Resign")); 
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