import javax.swing.JComponent;
import javax.swing.JFrame;

import logic.GameLogic;
import render.GameScreen;
import render.ScreenManager;
import render.StartScreen;

public class Main {

	public static void main(String[] args) {
//		JFrame frame = new JFrame("Maze Adventure");
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//
//		GameLogic logic = new GameLogic();
//		JComponent gameScreen = new GameScreen();
//		frame.getContentPane().add(gameScreen);
//		frame.setVisible(true);
//		frame.pack();
//		gameScreen.requestFocus();
//
//		while (true) {
//			try {
//				Thread.sleep(100);
//			} catch (InterruptedException e) {
//			}
//			gameScreen.repaint();
//			logic.logicUpdate();
//		}
		ScreenManager sm = new ScreenManager();
		while (true) {
			sm.update();
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
