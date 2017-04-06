package ui;

import java.awt.BorderLayout;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import javax.swing.border.EmptyBorder;

public class GameUI {

	   private final JPanel gui = new JPanel(new BorderLayout(3, 3));
	    private final JLabel headermessage = new JLabel(
	            "EXTREME CHESS!");
	    //Panels
	    public Board board;
	    private JPanel chessBoard;
	    private JPanel Menu;
	    private JToolBar toolBar;
	
	public GameUI(){
		initializeGui();
	}
	
	  public final void initializeGui() {
	        gui.setBorder(new EmptyBorder(5, 5, 5, 5));
	        gui.add(SetToolBar(), BorderLayout.PAGE_START);
	        gui.add(SetSideMenu(),BorderLayout.LINE_START);
	        gui.add(chessBoard = Board.SetChessBoard());
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
	        return chessBoard;
	    }

	    public final JComponent getGui() {
	        return gui;
	    }
}