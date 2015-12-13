package render;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JComponent;

import input.InputUtility;
import logic.GameLogic;

@SuppressWarnings("serial")
public class GameScreen extends JComponent{
	private GameLogic logic ;
	public GameScreen(){
		super();
		logic = new GameLogic();
		setDoubleBuffered(true);
		setPreferredSize(new Dimension(985,985));
		setVisible(true);
//		requestFocus();
		
		this.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				InputUtility.setKeyPressed(e.getKeyCode(), false);
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				InputUtility.setKeyPressed(e.getKeyCode(), true);
				
			}
		});
	}
	
	@Override
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D)g;
		g2d.setBackground(Color.BLACK);
		g2d.clearRect(0, 0, 640, 480);
		
		//Preventing thread interference
		synchronized(RenderableHolder.getInstance()){
			for(IRenderable entity : RenderableHolder.getInstance().getRenderableList()){
				if(entity.isVisible()){
					entity.draw(g2d);
				}
			}
		}
	}
	
	 public void update() {
		 System.out.println("update");
	  this.repaint();
	  logic.logicUpdate();
	 }
	
}
