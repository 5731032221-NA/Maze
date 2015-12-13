package render;

import java.awt.AlphaComposite;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;

public class BreathThread implements Runnable {
	private Thread thread;
	private boolean running = false;
	private static float breath = 0f;
	private static int type =0;
	
	public synchronized void start() {
		if (running)
			return;
		thread = new Thread(this);
		thread.start();
		running = true;
	}


	public synchronized void stop() {
		if (!running)
			return;
		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private synchronized void tick() {
		if (type == 1) {
			if(breath - 0.0125f<= 0f){
				type = 0;
				return;
			}
			breath = breath - 0.0125f;
		} else if(type == 0){
			if(breath + 0.0125f >= 1f){
				type = 1;
				return;
			}
			breath = breath + 0.0125f;
		}
	}

	public synchronized void draw(Graphics2D g) {
		g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, breath));
	}
	

	@Override
	public void run() {
		// TODO Auto-generated method stub

		while (running) {
			tick();
			try {
				Thread.sleep(35);
			} catch (Exception e) {
				// TODO: handle exception
			}
//			System.out.println(breath);
		}

		stop();
	}

}
