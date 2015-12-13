package logic;

import render.RenderableHolder;

public class GameLogic {
	
	private Player tank;
	private Mine mine;
	
	public GameLogic(){	
		Field field = new Field();
		RenderableHolder.getInstance().add(field);
		tank = new Player(456,0,field);
		mine = new Mine(100,100);
		RenderableHolder.getInstance().add(tank);
		RenderableHolder.getInstance().add(mine);
	}	
	
	public void logicUpdate(){
		//Preventing thread interference
		synchronized(RenderableHolder.getInstance()){
			System.out.println("Logic");
			tank.update();
			if(!mine.isDestroyed() && tank.collideWith(mine)){
				mine.onCollision(tank);
			}
		}
	}
}
