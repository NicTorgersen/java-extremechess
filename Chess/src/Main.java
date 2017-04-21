import javax.swing.SwingUtilities;
import gamelogic.ChessGame;

public class Main {

	public static void main(String[] args) {
		  Runnable r = new Runnable() {
	            @Override
	            public void run() {
	            	ChessGame cg = new ChessGame();
	            	cg.initiate();
	            }
	        };
	        SwingUtilities.invokeLater(r);
	}
}
