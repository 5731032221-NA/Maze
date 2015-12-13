import javax.swing.JComponent;
import javax.swing.JFrame;

import logic.GameLogic;
import render.GameScreen;
import render.ScreenManager;
import render.StartScreen;

public class Main {

	public static void main(String[] args) {

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
