package logic;

import java.awt.Graphics2D;

import render.Resource;

public class Mine extends CollidableEntity{

	public Mine(int x,int y){
		this.x = x;
		this.y = y;
		this.z = -100;
		this.radius = 20;
	}
	
	public void onCollision(Tank tank){
		this.destroyed = true;
	}
	
	@Override
	public void draw(Graphics2D g2d) {
		//g2d.drawImage(Resource.mineSprite.getSubimage(0, 0, 24, 24), null, x-radius, y-radius);
	}

}
