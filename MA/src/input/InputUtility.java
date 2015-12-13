package input;

public class InputUtility {
	private static boolean[] keyPressed = new boolean[256];

	public static boolean getKeypressed(int index) {
		if (index < 0 || index > 256) return false;
		else return keyPressed[index];
	}
	
	public static void setKeyPressed(int index, boolean isPressed) {
		if (index < 0 || index > 256) return;
		else keyPressed[index] = isPressed;	
	}
}
