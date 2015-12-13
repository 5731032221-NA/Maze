package logic;

import java.awt.Graphics2D;

import render.Resource;

public class Item extends CollidableEntity {
	private int bing;

	public Item(int x, int y) {
		this.x = x;
		this.y = y;
		this.z = -100;
		this.bing = 0;
	}

	public void onCollision(Player player) {
		this.destroyed = true;
		player.collectItemFire();
	}

	public void update() {
		bing++;
		if(bing==3){
			bing = 0;
		}
	}
	@Override
	public void draw(Graphics2D g2d) {
		g2d.drawImage(Resource.fireSprite.getSubimage(bing * 24, 0, 24, 24), null, x, y);
	}

}