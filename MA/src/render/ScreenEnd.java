package render;

import javax.swing.JComponent;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.AlphaComposite;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.swing.JComponent;
import javax.swing.JPanel;



public class ScreenEnd extends JComponent {
	private BufferedImage bg;
	// private AudioClip audio;
	private String title;
	private boolean isWin;

	public ScreenEnd() {
		this.isWin = false;
		// don't test
		if (isWin) {
			title = "You Win!!";
			try {
				ClassLoader loader = ScreenEnd.class.getClassLoader();
				bg = ImageIO.read(loader.getResource("win.png"));
				// audio =
				// Applet.newAudioClip((loader.getResource("res/ending.wav")).toURI().toURL());
			} catch (Exception e) {
				bg = null;
				// audio = null;
			}
		} else {
			title = "Game Over";
			try {
				ClassLoader loader = ScreenEnd.class.getClassLoader();
				bg = ImageIO.read(loader.getResource("lose.jpg"));
				// audio =
				// Applet.newAudioClip((loader.getResource("res/ending.wav")).toURI().toURL());
			} catch (Exception e) {
				bg = null;
				// audio = null;
			}
		}

		setDoubleBuffered(true);
		setPreferredSize(new Dimension(1024, 768));
		setVisible(true);
	}

	public boolean isWin() {
		return isWin;
	}

	public void setWin(boolean isWin) {
		this.isWin = isWin;
	}

	@Override
	public void paintComponent(Graphics g) {

		super.paintComponents(g);
		Graphics2D g2 = (Graphics2D) g;
		g2.drawImage(bg, null, 0, 0);
		g2.setFont(new Font("Tahoma", Font.BOLD, 80));
		g2.setColor(Color.RED);
		g2.drawString(title, 325, 200);
	}

	public void update() {
		repaint();
	}
}
