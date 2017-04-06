import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import gamelogic.PlayerBlack;
import gamelogic.PlayerWhite;
import ui.GameUI;

public class ChessGame {

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
}
