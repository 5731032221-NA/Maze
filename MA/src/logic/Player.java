package logic;

import java.awt.AlphaComposite;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;

import input.InputUtility;
import render.BreathThread;
import render.Resource;
import render.StartScreen;

public class Player extends CollidableEntity {

	private static final int speed = 24;
	private int angle = 0; // angle 0 = EAST
	private Field field;
	private static int itemFire;
	private int dimension;
	private static BreathThread gThread = new BreathThread();

	public static void collectItemFire() {
		Player.itemFire++;
	}


	public Player(int x, int y,Field field) {
		this.field = field;
		this.x = x;
		this.y = y;
	}

	private synchronized void forward() {
		int nextX = (int) (x + Math.cos(Math.toRadians(angle)) * speed);
		int nextY = (int) (y + Math.sin(Math.toRadians(angle)) * speed);
		if(nextX==23)nextX=24;
		System.out.println(x+" "+y+" "+field.getTileIndex((int)(nextX/24),(int)(nextY/24))+" "+nextX+" "+nextY);
		if(field.getTileIndex((int)(nextX/24),(int)(nextY/24))==0){
			this.x = nextX;
			this.y = nextY;
		}
	}

	public  void update() {
		System.out.println("tank");
		if (InputUtility.getKeypressed(KeyEvent.VK_LEFT)) {
			angle = 180;
			forward();
		} else if (InputUtility.getKeypressed(KeyEvent.VK_RIGHT)) {
			angle = 0;
			forward();
		} else if (InputUtility.getKeypressed(KeyEvent.VK_UP)) {
			angle = 270;
			forward();
		} else if (InputUtility.getKeypressed(KeyEvent.VK_DOWN)) {
			angle = 90;
			forward();
		}
	}

	@Override
	public void draw(Graphics2D g2d) {
		// TODO Auto-generated method stub
		g2d.drawImage(Resource.mineSprite.getSubimage(0, 0, 24, 24), null, x, y);
		// Black light
		float alpha = 0.025f;
		itemFire = 10;
		dimension = 12 + itemFire*2;

		for (int i = 2; i < 250 - (12 * itemFire); i++) {
			alpha += 0.025f;

			if (alpha >= 1.0f) {
				alpha = 1.0f;
			}
			g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha));
			g2d.setStroke(new BasicStroke((dimension) * i));
			g2d.setColor(Color.BLACK);
			g2d.drawOval(x - (dimension / 2) + 12, y - (dimension / 2) + 12, dimension, dimension);
		}
	}


}
