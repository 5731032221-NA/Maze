package render;

import java.awt.Dimension;

import javax.swing.JFrame;

public class ScreenManager extends JFrame {
	public StartScreen ss;
	private GameScreen gs;
	private ScreenEnd se;

	private int prevState;
	public static int nowState;
	private boolean paused = false;

	public ScreenManager() {
		// TODO Auto-generated constructor stub
		setTitle("Maze Adventure");
		setPreferredSize(new Dimension(1024, 768));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		nowState = 0;
		ss = new StartScreen();
		add(ss);
		setVisible(true);
		pack();
	}

	public void UpdateState() {
		// game start screen
		if (nowState == 0) {
			System.out.println("st0");
			StartScreen ss = new StartScreen();
		}
		// start play
		else if (nowState == 1) {
			 this.remove(ss);
			ss = null;
			// repaint();
			// System.out.println("st1");
			gs = new GameScreen();
			 repaint();

			this.add(gs);

			// this.repaint();
		}
		// End
		else {
			this.remove(gs);
			gs = null;
			this.remove(gs);
			se = new ScreenEnd();
			this.add(se);
		}
	}

	public synchronized void update() {
		if (nowState != prevState) {
			prevState = nowState;
			UpdateState();
			this.pack();
		}
		
		 if(nowState ==0) ss.update();
		 else if(nowState ==1) gs.update();
		 else se.update();
	}

}