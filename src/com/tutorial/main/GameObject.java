package com.tutorial.main;

import java.awt.Graphics;
import java.awt.Rectangle;

public abstract class GameObject {
	//protected - can only be accessed by inherited class
	protected int x, y;
	protected ID id; 
	protected int velX, velY; 
	protected int exist; 
	public GameObject(int x, int y, ID id)
	{
		this.x = x;
		this.y = y;
		this.id = id; 
	}
	public abstract void tick(); 
	public abstract void render(Graphics g);
	public abstract Rectangle getBounds();
	
	public void setX(int x)
	{
		// Need to have this. in order to refer to top variable rather than parameter
		this.x = x;
	}
	public void setY(int y)
	{
		this.y = y; 
	}
	public int getX()
	{
		return x;
	}
	public int getY()
	{
		return y; 
	}
	public void setId(ID id)
	{
		this.id = id; 
	}
	public ID getId()
	{
		return id; 
	}
	public void setVelX(int velX)
	{
		this.velX = velX;
	}
	public void setVelY(int velY)
	{
		this.velY = velY;
	}
	public int getVelX()
	{
		return velX;
	}
	public int getVelY()
	{
		return velY;
	}
	public void setexist(int exist)
	{
		this.exist = exist;
	}
	public int getexist()
	{
		return exist; 
	}
}

