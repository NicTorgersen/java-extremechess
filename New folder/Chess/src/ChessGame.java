import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JApplet;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import gamelogic.PlayerBlack;
import gamelogic.PlayerWhite;
import ui.GameUI;

public class ChessGame extends JApplet implements KeyListener, MouseListener, MouseMotionListener {

	  //private Image p2Image = null;
	   private static int x = 0;
	   private static int y = 0;
	   private int heightPosition = 0;
	public static GameUI gameUI = new GameUI();
	public PlayerWhite playerWhite = new PlayerWhite();
	public PlayerBlack playerBlack = new PlayerBlack();
	
	public static void main(String[] args) {
		  Runnable r = new Runnable() {
	            @Override
	            public void run() {
	                gameUI = new GameUI();

	                JFrame f = new JFrame("ExtremeChess");
	                f.add(gameUI.getGui());
	                f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	                f.setLocationByPlatform(true);
	                f.pack();
	                f.setMinimumSize(f.getSize());
	                f.setVisible(true);
	            }
	        };
	        SwingUtilities.invokeLater(r);
	}
	
	  public void paint(Graphics g) {
		    //update(g);
		  }

	@Override
	public void mouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub
		 x = arg0.getX();
		 y = arg0.getY();
		 System.out.print("test");
		// gameUI.headermessage.setText(Integer.toString(y));
		 repaint();
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