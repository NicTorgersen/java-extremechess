package pieces;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import pieces.ChessPiece.ChessPieceType;

public class King extends ChessPiece {

	public King(Boolean white, ChessPieceType type) {
		super(white, type);
		  try {
				BufferedImage image = ImageIO.read(new File("Images/blackpieces/KingBlack.png"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		// TODO Auto-generated constructor stub
	}

}
