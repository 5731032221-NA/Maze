package render;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.swing.JComponent;
import javax.swing.JPanel;

public class StartScreen extends JComponent {
	private BufferedImage screen;
	private BufferedImage button;
	private BufferedImage startButton;
	private BufferedImage startButton2;
	private BufferedImage exitButton;
	private AudioClip opening;
	private AudioClip start;
	private boolean isStarted = false;
	public static BreathThread bThread;

	public StartScreen() {
		try {
			ClassLoader loader = StartScreen.class.getClassLoader();
			screen = ImageIO.read(loader.getResource("Start_Screen.jpg"));
			startButton = ImageIO.read(loader.getResource("Start_Button.png"));
			startButton2 = ImageIO.read(loader.getResource("Start_Button2.png"));
			exitButton = ImageIO.read(loader.getResource("Exit_Button.png"));
			opening = Applet.newAudioClip((loader.getResource("Opening.wav")).toURI().toURL());
			start = Applet.newAudioClip((loader.getResource("coin.wav")).toURI().toURL());
		} catch (Exception e) {
			e.printStackTrace();
			screen = null;
			startButton = null;
			startButton2 = null;
			exitButton = null;
			opening = null;
		}
		button = startButton;
		opening.loop();
		this.setPreferredSize(new Dimension(1024, 768));
		bThread = new BreathThread();
		bThread.start();
		this.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				int x = e.getX();
				int y = e.getY();
				if (354 <= x && x <= 669) {
					if (309 <= y && y <= 438) {
						System.out.println("Start");
						setStarted(true);
						ScreenManager.nowState = 1;
						opening.stop();
						start.play();
//						bThread.stop();
					} else if (468 <= y && y <= 597) {
						System.out.println("Exit");
						start.play();
						opening.stop();
						System.exit(0);
					}
				}

			}
		});
	}

	protected void update() {
		button = startButton2;
//		System.out.println("update");
		repaint();
	}

	public synchronized void paintComponent(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.drawImage(screen, null, 0, 0);
		g2d.drawImage(button, null, 354, 309);
		g2d.drawImage(exitButton, null, 354, 459);
		
		g2d.setFont(new Font("Tahoma", Font.BOLD, 100));
		g2d.setColor(Color.GRAY);
		g2d.drawString("Maze Adventure", 130, 140);
		
		bThread.draw(g2d);
		g2d.setStroke(new BasicStroke(5));
		g2d.setColor(Color.GREEN);
		g2d.drawRect(373, 329, 263, 97);
		g2d.drawRect(373, 479, 263, 97);
		
		repaint();
		
	}

	public boolean isStarted() {
		return isStarted;
	}

	public void setStarted(boolean isStarted) {
		this.isStarted = isStarted;
	}

}
