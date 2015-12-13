package logic;

import render.IRenderable;

public abstract class Entity implements IRenderable{

	protected int x,y,z;
	protected boolean visible,destroyed;
	
	protected Entity(){
		visible = true;
		destroyed = false;
	}
	
	public boolean isDestroyed(){
		return destroyed;
	}
	
	@Override
	public boolean isVisible(){
		return visible && !destroyed;
	}
	
	@Override
	public int getZ(){
		return z;
	}
}
